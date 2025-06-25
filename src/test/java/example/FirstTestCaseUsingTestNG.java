package example;

import org.testng.annotations.Test;

/*
 1.open the page
 2.login
 3.logout
 */
public class FirstTestCaseUsingTestNG {
	@Test
	public void openApp() {
		System.out.println("Open Appliction");
	}
	@Test
	public void loginApp() {
		System.out.println("Login Appliction");
	}
	@Test
	public void logoutApp() {
		System.out.println("Logout Appliction");
	}



}
