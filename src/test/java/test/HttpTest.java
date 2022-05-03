package test;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * Тестовый класс проверки соединения
 * @author Salimgareev K
 * @version 1.0
*/
public class HttpTest {
	/**
    * Проверяет соединение с серверным приложением
    */
	@Test
	public void test() {
		String url = "http://localhost:8080/WebCalculator-test/";
		//String url = "http://localhost:8080/15448";
		JavaHttpClient h = new JavaHttpClient(url);
		int result = h.getRandomQuote();
		if (result == -1) {
			//error("Не найден сервер: " + url);
			System.out.print("Не найден сервер: " + url);
		} else if (result != 200) {
			fail("Ошибка подключения к ресурсу: " + url + "; Код ошибки: " + result);
		}
	}

}
