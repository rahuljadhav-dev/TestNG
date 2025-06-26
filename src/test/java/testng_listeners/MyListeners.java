package testng_listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution Started...");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed....");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finish...");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped..");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Passed..");
	}

}
