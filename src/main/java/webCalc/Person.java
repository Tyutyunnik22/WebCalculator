package webCalc;

/** 
* Класс-интерфейс субъекта
* @author Mamleeva Z
* @version 1.0
*/
public interface Person {
	/**
	 * Метод возврата логина
	 * @return возвращает значение логина 
	 */
	public String login();
	/**
	 * Метод возврата логической переменой админа 
	 * @return возвращает значение логической переменной, является ли пользователь админом 
	 */
	public boolean isAdmin();
}
