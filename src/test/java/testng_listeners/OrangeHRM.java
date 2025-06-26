package testng_listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class OrangeHRM {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        ListeneresUtil.driver = driver; // Assign static driver for screenshots
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
    }

    @Test
    public void openApp() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"openApp"})
    public void isLogoPresent() throws InterruptedException {
        Thread.sleep(1000);
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Test(dependsOnMethods = {"isLogoPresent"})
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Orange"); // This will fail on purpose
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login functionality")
    @Test(priority = 3)
    public void loginAndLogout() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
