package webCalc;

import javax.servlet.Filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MyFilter implements Filter{
	public void  init(FilterConfig config) throws ServletException {
		// Get init parameter 
		String testParam = config.getInitParameter("test-param"); 
		 
		//Print the init parameter 
		System.out.println("Test Param: " + testParam); 
	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws java.io.IOException, ServletException {
		  
		// Get the IP address of client machine.   
		String ipAddress = request.getRemoteAddr();
		  
		// Log the IP address and current timestamp.
		System.out.println("IP "+ ipAddress + ", Time "+ new Date().toString());
		  
		HttpServletRequest req= (HttpServletRequest) request;
		req.getRequestDispatcher("Login.jsp").forward(request,response);
	}
	public void destroy( ) {
		/* Called before the Filter instance is removed 
		from service by the web container*/
	}
}
