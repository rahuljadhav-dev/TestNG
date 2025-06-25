package grouping;

import org.testng.annotations.Test;

public class SignupTests {
	@Test(groups = {"regression"})
	public void signupByGithub() {
		System.out.println("Successfully Sign Up..");
	}
	
	@Test(groups = {"regression"})
	public void signupByFacebook() {
		System.out.println("Successfully Sign Up..");
	}
	
	@Test(groups = {"regression"})
	public void signupByTwitter() {
		System.out.println("Successfully Sign Up..");
	}
	
	@Test(groups = {"regression"})
	public void signupByInstagram() {
		System.out.println("Successfully Sign Up..");
	}

}
