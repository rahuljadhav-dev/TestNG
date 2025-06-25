package grouping;

import org.testng.annotations.Test;

public class LoginTests {
	@Test(groups = {"sanity"})
	public void loginGithub() {
		System.out.println("Logged In Successfull...");
	}
	
	@Test(groups = {"sanity"})
	public void loginFacebook() {
		System.out.println("Logged In Successfull...");
	}
	
	@Test(groups = {"sanity"})
	public void loginTwitter() {
		System.out.println("Logged In Successfull...");
	}
	
	@Test(groups = "sanity")
	public void loginInstagram() {
		System.out.println("Logged In Successfull...");
	}




}
