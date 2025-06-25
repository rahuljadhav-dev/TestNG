package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample {
	//without assertion 
	//	@Test
	//	public void openApp() {
	//		String expected="Rahul";
	//		String actual="rahul";
	//		
	//		if(expected.equals(actual)) {
	//			System.out.println("Test Passed");
	//		}else {
	//			System.out.println("Test Failed");
	//		}
	//		//the problem using conditional if our expected result failed but test still passed
	//		
	//	}

	@Test
	public void openApp() {
		String expected="Rahul";
		String actual="rahul";

		//			Assert.assertEquals(expected, actual,"Actual and expected values do not match.");//failed
		//			Assert.assertNotEquals(expected, actual);//passed

//		if(expected.equals(actual)) {
//			System.out.println("Test Passed");
//			Assert.assertTrue(true);
//		}else {
//			System.out.println("Test Failed");
//			Assert.assertTrue(false);
//		}
		

	}

}
