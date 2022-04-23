package webCalc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repairCalculator.WorkKind;
import repairCalculator.WorkType;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String selectType = "";
	String selectKind = "";
	
    public Admin() {
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
        request.setAttribute("adminWorkType", listWorkType);
        if (selectType.isEmpty()) {
        	selectType = listWorkType.get(0).getName();
        }
        List<WebWorkKind> listWorkKind = WebWorkKind.getList(selectType, selectKind);
        request.setAttribute("adminWorkKind", listWorkKind);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin.jsp");
        dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		selectType = request.getParameter("adminType");
		selectKind = request.getParameter("adminKind");
		
		doGet(request, response);
	}
}
