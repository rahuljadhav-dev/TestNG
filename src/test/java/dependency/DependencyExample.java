package dependency;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependencyExample {
	@Test(priority = 1)
	public void openApp() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2,dependsOnMethods = "openApp")
	public void login() {
		Assert.assertTrue(false);
	}
	
	@Test(priority = 3,dependsOnMethods = "login")
	public void search() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4,dependsOnMethods = "login")
	public void advSearch() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 5, dependsOnMethods = "login")
	public void logout() {
		Assert.assertTrue(true);
	}

}
