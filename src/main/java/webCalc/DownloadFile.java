package webCalc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * Класс-сервлет обработки для загрузки и отображения pdf-файла
 * @author Salimgareev K
 * @author Tyutyunnik E
 * @version 1.0
*/
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	/** Константа сериализации*/
	private static final long serialVersionUID = 1L;
	/** Стандартный конструктор*/
    public DownloadFile() {
        super();
    }
    /**
     * Метод обрабатыввает запросы получения данных
     * @param request параметр запросов 
     * @param response параметр ответов
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("type");
        
		// читает входной файл с абсолютного пути
        HttpSession session = request.getSession();
        String jspPath = session.getServletContext().getRealPath("/");
        String filePath = jspPath + "RepairCalculator.pdf";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // если вы хотите использовать относительный путь к корню контекста:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // получает ServletContext
        ServletContext context = getServletContext();
         
        // получает MIME-тип файла
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // установить двоичный тип, если сопоставление MIME не найдено
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // изменяет ответ
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // форсирует загрузку
        if (key.equals("view")) {
        	response.addHeader("Content-Disposition", "inline; filename=Documentation.pdf");
        } else {
        	String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);
        }
        
        // получает выходной поток ответа
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        
        inStream.close();
        outStream.close();
	}
    /**
     * Метод обрабатывает запросы отправки данных
     * @param request параметр запросов 
     * @param response параметр ответов
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// вызов метода doGet
		doGet(request, response);
	}
}
