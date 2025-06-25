package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 TC2
1.login----@BeforeClass
2.search----@Test
3.advanced serach----@Test
3.logout----@AfterClass
 */
public class ExampleOfBeforeClassAfterClass {
	@BeforeClass
	public void login() {
		System.out.println("Successfully Logged In...");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("Successfully Logged Out...");
	}
	
	@Test(priority = 4)
	public void searchMethod() {
		System.out.println("Searching Successfull...");
	}
	
	@Test(priority = 5)
	public void advancedSearchMethod() {
		System.out.println("Advanced Searching Successfull...");
	}
	

}
