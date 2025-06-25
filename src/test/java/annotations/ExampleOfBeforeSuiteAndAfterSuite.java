package annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExampleOfBeforeSuiteAndAfterSuite {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Berfore Suite Done....");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Done....");
	}

}
