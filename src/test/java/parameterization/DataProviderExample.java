package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Login Module")
@Feature("Valid and Invalid Login")
public class DataProviderExample {
	WebDriver driver;

	@BeforeClass
	@Parameters({"browser"})
	public void setup(String b) {
		switch (b.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();
		break;

		case "edge":driver=new EdgeDriver();
		break;

		case "firefox":driver=new FirefoxDriver();
		break;

		default:System.out.println("Not Valid Browser Found...");
		return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login and Logout with data provider")
	@Test(dataProvider = "data")
	public void loginAndLogout(String username,String password) throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		Thread.sleep(1000);

		boolean loginSuccess = false;

		try {
			// If Dashboard heading is visible, login was successful
			String dashboard = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
			loginSuccess = dashboard.equals("Dashboard");
		} catch (Exception e) {
			// Element not found = login failed
			loginSuccess = false;
		}

		if (loginSuccess) {
			System.out.println("Login successful for: " + username + " & " + password);

			// Proceed to logout
			driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			Thread.sleep(1000);

			// Verify logout worked
			Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
			System.out.println("Logout successful\n");

		} else {
			System.out.println("Login failed for: " + username + " & " + password + "\n");
			Assert.fail("Login failed: Invalid credentials or dashboard not found.");
		}
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	@DataProvider(name = "data")
	public Object[][] data() {
		Object object[][]= {
				{"admin","admin"},
				{"admin5","Admin123"},
				{"Admin","admin12"},
				{"Admin","Admin"},
				{"Admin","admin123"},
				{"admin","admin"},
				{"Admin","admin123"}

		};

		return object;
	}

}
