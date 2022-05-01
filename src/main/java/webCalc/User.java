package webCalc;

public class User	implements Person {
	String loginName;
	boolean admin = false;
	
	public User(String login, String role) {
		this.loginName = login;
		if (role.equals("admin")) {
			admin = true;
		}
	}

	@Override
	public String login() {
		return loginName;
	}

	@Override
	public boolean isAdmin() {
		return admin;
	}
}
