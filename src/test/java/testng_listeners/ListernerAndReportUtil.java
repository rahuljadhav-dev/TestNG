package testng_listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernerAndReportUtil implements ITestListener {
	private ExtentSparkReporter sparkReporter;//for ui
	private ExtentReports reports;//populate common info on the report
	private ExtentTest extentTest;//creatingtest case entries in the report
	
	@Override
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");//title of report
		sparkReporter.config().setReportName("Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("Computer Name", "Local Host");
		reports.setSystemInfo("Enviornment", "QA");
		reports.setSystemInfo("Tester Name", "Ashu");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser Name", "Chrome");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest=reports.createTest(result.getName());//create new entry in the report
		extentTest.log(Status.PASS, "Test Case Is Passed :"+result.getName());//update status
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest=reports.createTest(result.getName());//create new entry in the report
		extentTest.log(Status.FAIL, "Test Case Is Failed :"+result.getName());//update status
		extentTest.log(Status.INFO, "Test Case Failure Cause :"+result.getThrowable());
	
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest=reports.createTest(result.getName());//create new entry in the report
		extentTest.log(Status.SKIP, "Test Case Is Skipped:"+result.getName());//update status
	}
	
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
