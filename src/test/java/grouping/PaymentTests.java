package grouping;

import org.testng.annotations.Test;

public class PaymentTests {
	@Test(groups = {"sanity","regression","functional"})
	public void paymentOne() {
		System.out.println("Payment Successfull..");
	}
	
	@Test(groups = {"sanity","regression","functional"})
	public void paymentTwo() {
		System.out.println("Payment Successfull..");
	}

}
