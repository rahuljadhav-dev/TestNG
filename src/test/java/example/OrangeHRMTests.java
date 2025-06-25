package example;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*
 1.open the app
 2.see the logo is displayed or not
 3.login
 4.logout
 */
public class OrangeHRMTests {
	WebDriver driver;
	@Test(priority = 1)
	public void openApp() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test(priority = 2)
	public void isLogoPresent() throws InterruptedException {
		Thread.sleep(1000);
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println(status);

	}
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify login functionality")
	@Test(priority = 3)
	public void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 4)
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		Thread.sleep(4000);
		driver.quit();
	}
}
