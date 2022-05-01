package webCalc;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
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

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String selectType = "";
	String selectKind = "";
	boolean needRefresh = false;
	
    public Admin() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	webCalc.User user = (webCalc.User)session.getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			request.setAttribute("isAdmin", user.isAdmin());
		}
    	
    	readDataFromPage(request);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin.jsp");
        dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("btnApply") != null) {
			needRefresh = true;
			String kind = request.getParameter("txtKind");
			String unit = request.getParameter("txtUnit");
			String price = request.getParameter("txtPrice");
			String newPrice = request.getParameter("txtNewPrice");
			replaceSelected(request, kind, unit, price, newPrice);
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
		if (needRefresh) {
			WorkKind.refresh();
		}
		
        HttpSession session = request.getSession();
        String jspPath = session.getServletContext().getRealPath("/");
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
    	request.setAttribute("price2","руб. за " + kind.getUnit());
    	
    	request.setAttribute("txtKind",selectKind);
    	request.setAttribute("txtUnit",kind.getUnit());
    	
    	DecimalFormat format = new DecimalFormat("0.#");
    	request.setAttribute("txtPrice",format.format(kind.getPrice()));
	}
	
	private void replaceSelected(HttpServletRequest request, String kind, String unit, String oldPrice, String newPrice) {
        HttpSession session = request.getSession();
        String jspPath = session.getServletContext().getRealPath("/");
		
	    try {
	    	String filePath = jspPath + "data.txt";
	        BufferedReader file = new BufferedReader(new FileReader(filePath));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        file.close();
	        String inputStr = inputBuffer.toString();

	        String line1 = kind + "\t" + unit + "\t" + oldPrice;
	        String line2 = kind + "\t" + unit + "\t" + newPrice;
	        
	        log("line1= " + line1);
	        log("line2= " + line2);
	        
	        inputStr = inputStr.replace(line1, line2); 
	        // показать новый файл для отладки

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(filePath);
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        log("Admin.java:replaceSelected() e= " + e.toString());
	    }
	}
}
