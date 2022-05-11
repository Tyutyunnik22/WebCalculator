package webCalc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** 
 * Класс-сервлет обработки вывода окна результата создания pdf
 * @author Mamleeva Z
 * @version 1.0
*/
@WebServlet("/PdfResults")
public class PdfResults extends HttpServlet {
	/** Константа сериализации*/
	private static final long serialVersionUID = 1L;
	/** Конструктор-стандартный*/
    public PdfResults() {
        super();
    }
    /**
     * Метод обрабатыввает запросы получения данных
     * @param request параметр запросов 
     * @param response параметр ответов
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PdfResults.jsp");
        dispatcher.forward(request, response);
	}
}