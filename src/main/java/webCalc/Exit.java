package webCalc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Класс-сервлет выхода на форму авторизации
 * @author Skityaeva A
 * @version 1.0
*/
@WebServlet("/Exit")
public class Exit extends HttpServlet {
	/** Константа сериализации*/
	private static final long serialVersionUID = 1L;

    /**
     * Метод обрабатыввает запросы отправки данных
     * @param request параметр запросов 
     * @param response параметр ответов
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
}
