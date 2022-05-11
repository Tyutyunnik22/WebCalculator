package webCalc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * Класс-сервлет обработки входных данных
 * @author Skityaeva A
 * @author Tyutyunnik E
 * @version 1.0
*/
@WebServlet("/Login")
public class Login extends HttpServlet {
	/** Константа сериализации*/
	private static final long serialVersionUID = 1L;
	
	/** Конструктор-стандартный*/
    public Login() {
        super();
    }
    
    /**
     * Метод обрабатывает запросы получения данных
     * @param request параметр запросов 
     * @param response параметр ответов
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
        dispatcher.forward(request, response);
	}
    
    /**
     * Метод обрабатывает запросы отправки данных
     * @param request параметр запросов 
     * @param response параметр ответов
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.isEmpty() && password.isEmpty()) {
			request.setAttribute("err", "Поля пустые!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else if (username.isEmpty()) {
			request.setAttribute("err", "Введите имя пользователя!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else if (password.isEmpty()) {
			request.setAttribute("err", "Введите пароль!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			boolean result = checkPassword(username, password, request);
			if (result == true) {
				response.sendRedirect("Calc");
			} else {
				request.setAttribute("err", "Логин или пароль введен неверно!");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}
	
    /**
     * Метод проверки логина и пароля
     * @param login параметр логина
     * @param password параметр пароля
     * @param request параметр запросов
     * @return возвращает логическое значение true, если данные авторизации верны
     */
	private boolean checkPassword(String login, String password, HttpServletRequest request) {
		boolean result = false;
		HttpSession session = request.getSession();
        String jspPath = session.getServletContext().getRealPath("/");
		
		String fileName = jspPath + "login.txt";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(fileName), "UTF-8"))) {
			String textLine = null;
		    while ((textLine = br.readLine()) != null) {
		    	if(!textLine.isEmpty()){
		    		String[] words = textLine.split(";");
		    		if (words.length == 3) {
		    			if (login.equals(words[0]) && password.equals(words[1])) {
		    				result = true;
		    				User u = new User(login, words[2]);
		    				session.setAttribute("user", u);
		    				break;
		    			}
		    		}
		    	}
		    }
		} catch (IOException ex) {
			String msg = String.format("Файл %s не найден", fileName);
			log("Login.java: checkPassword: err = " + msg + "; " + ex.toString());
		}
		return result;
	}
}
