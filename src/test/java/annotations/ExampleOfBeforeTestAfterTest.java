package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleOfBeforeTestAfterTest {
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test...");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class..");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class..");
	}
	
	@BeforeMethod
	public void loginMethod() {
		System.out.println("Logged In Successfully...");
	}
	@AfterMethod
	public void logoutMethod() {
		System.out.println("Logged Out Successfully...");
	}
	@Test(priority = 4)
	public void searchMethod() {
		System.out.println("Searching Done...");
	}
	@Test(priority = 5)
	public void advancedSearchMethod() {
		System.out.println("Advanced Searching Done...");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test..");
	}

}
