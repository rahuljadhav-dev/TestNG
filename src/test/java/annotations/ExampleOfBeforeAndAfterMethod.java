package annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 TC1
1.login----@BeforeMethod
2.search----@Test
3.logout----@AfterMethod
4.login
5.advanced serach----@Test
6.logout
 */
public class ExampleOfBeforeAndAfterMethod {
	@BeforeMethod
	public void login() {
		System.out.println("Successfully Logged In...");
	}
	@AfterMethod
	public void logout() {
		System.out.println("Successfully Logged Out...");
	}
	@Test(priority =4)
	public void search() {
		System.out.println("Searching Completed..");
	}
	
	@Test(priority =5)
	public void advancedSearch() {
		System.out.println("Advanced Searching Completed..");
	}

}
