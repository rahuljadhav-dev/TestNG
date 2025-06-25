package example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Chatgpt {
	WebDriver driver;
	@Test(priority = 1)
	public void openApp() {
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.chatgpt.com");
		driver.manage().window().maximize();
	}
	@Test(priority = 2)
	public void isLogoPresent() throws InterruptedException {
	
		driver.findElement(By.xpath("//*[@id='prompt-textarea']/p")).sendKeys("hello buddy");
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M8.99992 1')]")).click();
		Thread.sleep(9000);
		String text=driver.findElement(By.cssSelector("p[data-start='0']")).getText();
		System.out.println(text);
		Thread.sleep(4000);
		driver.quit();

	}

}
