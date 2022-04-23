package webCalc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.isEmpty() && password.isEmpty() )
		{
			request.setAttribute("err", "Поля пустые!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else if (username.isEmpty()) {
			request.setAttribute("err", "Введите имя пользователя!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else if (password.isEmpty()) {
			request.setAttribute("err", "Введите пароль!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else
		{
		    response.sendRedirect("Calc");
		}
	}
}
