package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//when we want execute statements after test failed or passed then we need soft assertions 
public class SoftAssertions {
	@Test
	public void openApp() {
		SoftAssert softAssert=new SoftAssert();
		System.out.println("Execution Start");
		softAssert.assertEquals(456, 458);
		System.out.println("Execution End");
		softAssert.assertAll();//mandatory after all 
	}

}
