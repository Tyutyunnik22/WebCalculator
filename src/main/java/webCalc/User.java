package webCalc;

/** 
 * Класс пользователя
 * @author Skityaeva A
 * @version 1.0
*/
public class User	implements Person {
	/**Переменная значения логина */
	String loginName;
	
	/**Логическая переменная, является ли пользователь админом */
	boolean admin = false;
	
    /**
     * Конструктор класса пользователя
     * @param login параметр логина 
     * @param role параметр роли
     */
	public User(String login, String role) {
		this.loginName = login;
		if (role.equals("admin")) {
			admin = true;
		}
	}

	/**
	 * Метод возврата логина
	 * @return возвращает значение логина 
	 */
	@Override
	public String login() {
		return loginName;
	}

	/**
	 * Метод возврата логической переменой админа 
	 * @return возвращает значение логической переменной, является ли пользователь админом 
	 */
	@Override
	public boolean isAdmin() {
		return admin;
	}
}
