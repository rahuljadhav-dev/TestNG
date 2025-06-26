package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import testng_listeners.ListeneresUtil;

public class FormRegistration {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	@Parameters({"browsers"})
	public void setup(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			ListeneresUtil.driver=driver;
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser specified. Launching Chrome by default.");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void openApp() {
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Title of the page: " + driver.getTitle());
	}

	@Test(dependsOnMethods = "openApp",dataProvider = "formData",dataProviderClass = DataUtil.class)
	public void register(String name,String email,String phone,String address) throws InterruptedException {
		driver.findElement(By.cssSelector("#name")).sendKeys(name);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("#phone")).sendKeys(phone);
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys(address);
		driver.findElement(By.cssSelector("#male")).click();
		
		List<WebElement> days=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement webElement : days) {
			webElement.click();
		}
		
		WebElement country= driver.findElement(By.cssSelector("#country"));
		Select select=new Select(country);
		select.selectByVisibleText("India");
		
		WebElement colors= driver.findElement(By.xpath("//select[@id='colors']"));
		Select select2=new Select(colors);
		select2.selectByVisibleText("Red");
		
		WebElement sortedList= driver.findElement(By.xpath("//select[@id='animals']"));
		Select select3=new Select(sortedList);
		select3.selectByVisibleText("Cheetah");
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/26/2025");
		driver.findElement(By.xpath("//input[@id='txtDate']")).sendKeys("26/06/2025");
		WebElement start= driver.findElement(By.xpath("//input[@id='start-date']"));
		start.click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
