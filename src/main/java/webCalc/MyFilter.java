package webCalc;

import javax.servlet.Filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/** 
 * Класс для запрета перехода на jsp формы 
 * @author Tyutyunnik E
 * @version 1.0
*/
public class MyFilter implements Filter{
	/**
     * Метод определения конфигурационных параметров фильтра
     * @param config объект конфигурации фильтра для передачи информации фильтру
     */
	public void  init(FilterConfig config) throws ServletException {
		// Получить параметр инициализации
	}
	/**
     * Основной метод фильтрации
     * @param request параметр запросов 
     * @param response параметр ответов
     * @param chain объект представления цепочки вызовов отфильтрованного запроса на ресурс
     */
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws java.io.IOException, ServletException {
		  
		// Получить IP-адрес клиентской машины.   
		String ipAddress = request.getRemoteAddr();
		  
		// Зарегистрировать IP-адрес и текущую отметку времени.
		System.out.println("IP "+ ipAddress + ", Time "+ new Date().toString());
		  
		HttpServletRequest req= (HttpServletRequest) request;
		req.getRequestDispatcher("Login.jsp").forward(request,response);
	}
	/**
     * Метод вызывается после того как фильтр заканчивает свою работу
     */
	public void destroy( ) {
		// Вызывается перед удалением экземпляра фильтра из службы веб-контейнера
	}
}
