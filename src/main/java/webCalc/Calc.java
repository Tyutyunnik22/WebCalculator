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
       
	String selectType = null;
	String selectKind = null;
	
    public Calc() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	readDataFromPage(request);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Calc.jsp");
        dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		readDataFromPage(request);
		
		if (request.getParameter("btnAuthors") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Authors.jsp");
	        dispatcher.forward(request, response);
		} else if (request.getParameter("btnPdf") != null) {
			repairCalculator.CreatePdf.savePdf();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/PdfResults.jsp");
	        dispatcher.forward(request, response);
		} else if (request.getParameter("btnAdd") != null) {
			addWorkItem(request);
		} else if (request.getParameter("btnCalc") != null) {
			HttpSession session = request.getSession();
			repairCalculator.Order order = getOrder(request);
			session.setAttribute("orderSum", order.getTotalsum());
		} else if (request.getParameter("btnClearAll") != null) {
			HttpSession session = request.getSession();
			session.removeAttribute("order");
			session.removeAttribute("orderSum");
		} else if (request.getParameter("btnDel") != null) {
			String idx = request.getParameter("txtRowIdx");
			if (idx.length() != 0) {
				HttpSession session = request.getSession();
				int idx1 = Integer.parseInt(idx)-1;
				repairCalculator.Order order = getOrder(request);
				order.removeWorkItem(idx1);
				session.setAttribute("order", order);
				session.setAttribute("orderSum", order.getTotalsum());
			}
		} 
		
		doGet(request, response);	
	}
	protected void readDataFromPage(HttpServletRequest request) {
		if (request.getParameter("btnDdlType1") != null) {
			selectType = request.getParameter("ddlType");
			selectKind = null;
		} else {
			selectType = request.getParameter("ddlType");
			selectKind = request.getParameter("ddlKind");
		}
		
        HttpSession session = request.getSession();
        String jspPath = session.getServletContext().getRealPath("/");
        log("jspPath=" + jspPath);
        WorkType.filePath = jspPath;
        WorkKind.filePath = jspPath;
        
		List<WebWorkType> listWorkType = WebWorkType.getList(selectType);
        request.setAttribute("listWorkType", listWorkType);
        if (selectType == null || selectType.isBlank()) {
        	selectType = listWorkType.get(0).getName();
        }
        List<WebWorkKind> listWorkKind = WebWorkKind.getList(selectType, selectKind);
        request.setAttribute("listWorkKind", listWorkKind);
        if (selectKind == null || selectKind.isBlank()) {
        	selectKind = listWorkKind.get(0).getName();
        }
        
    	WorkKind kind = WorkKind.findWorkKind(selectType, selectKind);
    	request.setAttribute("price1",String.format(Locale.US, "%.2f",kind.getPrice()));
    	request.setAttribute("price2","руб за " + kind.getUnit());
    	request.setAttribute("count2",kind.getUnit());
    	
    	repairCalculator.Order order = getOrder(request);
    	request.setAttribute("listWorkItem", order.getWorkItemList());
	}
	
	protected void addWorkItem(HttpServletRequest request) {
		WorkKind kind = WorkKind.findWorkKind(selectType, selectKind);
		String strCount = request.getParameter("txtCount");
		
		HttpSession session = request.getSession();
		repairCalculator.Order order = getOrder(request);
		
		order.addWorkItem(kind, Integer.parseInt(strCount));
		session.setAttribute("order", order);
	}
	private repairCalculator.Order getOrder(HttpServletRequest request){
		HttpSession session = request.getSession();
		repairCalculator.Order order = (repairCalculator.Order)session.getAttribute("order");
		if (order == null) {
			order = new repairCalculator.Order();
		}
		return order;
	}
}
