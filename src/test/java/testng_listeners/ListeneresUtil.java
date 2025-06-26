package testng_listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListeneresUtil implements ITestListener {

    private ExtentReports reports;
    private ExtentSparkReporter sparkReporter;
    private ExtentTest extentTest;

    public static WebDriver driver; // Set this in your base test or before method

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/Automation_Report_" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);

        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Tester", "Rahul Jadhav");
        reports.setSystemInfo("Tool", "Selenium + TestNG");
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = reports.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed: " + result.getName());
        attachScreenshot(result.getName(), Status.PASS);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Failed: " + result.getName());
        extentTest.log(Status.FAIL, result.getThrowable());
        attachScreenshot(result.getName(), Status.FAIL);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped: " + result.getName());
        extentTest.log(Status.SKIP, result.getThrowable());
        attachScreenshot(result.getName(), Status.SKIP);
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }

    // =================== Screenshot Helper Method ===================
    private void attachScreenshot(String testName, Status status) {
        if (driver == null) {
            extentTest.log(Status.WARNING, "WebDriver is null. Cannot capture screenshot.");
            return;
        }

        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        new File(screenshotDir).mkdirs();

        String path = screenshotDir + testName + "_" + date + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
            extentTest.addScreenCaptureFromPath(path);
            extentTest.log(status, "Screenshot Attached");
        } catch (IOException e) {
            extentTest.log(Status.WARNING, "Failed to save screenshot: " + e.getMessage());
        }
    }
}
