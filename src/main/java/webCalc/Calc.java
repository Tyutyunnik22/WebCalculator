package webCalc;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repairCalculator.WorkKind;
import repairCalculator.WorkType;

@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String selectType = "";
	String selectKind = "";
	
    public Calc() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String jspPath = session.getServletContext().getRealPath("/");
        log("jspPath=" + jspPath);
        WorkType.filePath = jspPath;
        WorkKind.filePath = jspPath;
        
		List<WebWorkType> listWorkType = WebWorkType.getList(selectType);
        request.setAttribute("listWorkType", listWorkType);
        if (selectType.isEmpty()) {
        	selectType = listWorkType.get(0).getName();
        }
        List<WebWorkKind> listWorkKind = WebWorkKind.getList(selectType, selectKind);
        request.setAttribute("listWorkKind", listWorkKind);
        if (request.getParameter("ddlKind") != null && request.getParameter("ddlType") != null) {
        	WorkKind kind = WorkKind.findWorkKind(selectType, selectKind);
        	request.setAttribute("price1",String.format(Locale.US, "%.2f",kind.getPrice()));
        	request.setAttribute("price2","руб за " + kind.getUnit());
        	request.setAttribute("count2",kind.getUnit());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Calc.jsp");
        dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		selectType = request.getParameter("ddlType");
		selectKind = request.getParameter("ddlKind");
		
		if (request.getParameter("btnAuthors") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Authors.jsp");
	        dispatcher.forward(request, response);
		} else if (request.getParameter("btnPdf") != null) {
			repairCalculator.CreatePdf.savePdf();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/PdfResults.jsp");
	        dispatcher.forward(request, response);
		}
		
		doGet(request, response);
		

	}
}
