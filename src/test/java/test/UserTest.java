package test;

import static org.junit.Assert.*;

import org.junit.Test;

import webCalc.User;
/**skitaeva*/
public class UserTest {

	@Test
	public void testConstructor() {
		User u1 = new User("cat","admin");
		if (u1.login() != "cat") {
			fail("В конструкторе не устанавливается св-во loginName");
		}
		if (!u1.isAdmin()) {
			fail("В конструкторе не устанавливается св-во admin");
		}
		User u2 = new User("cat","user");
		if (u2.isAdmin()) {
			fail("В конструкторе устанавливается ошибочное св-во admin");
		}
	}
}
