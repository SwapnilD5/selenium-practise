package com.selenium.pageobjects;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerCode implements ITestListener {

	public void onTestStart(ITestResult result) {

//		System.out.println("Test Started : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Case Passed : " + result.getName());

		try {
			FDObject.captureScreenshot(result, "passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getName());
		
		try {
			FDObject.captureScreenshot(result, "failed");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	//	System.out.println("Test Case failed but within success Percentage : " + result.getName());

	}

	public void onStart(ITestContext context) {

	//	System.out.println("Test Started : " + context.getName());

	}

	public void onFinish(ITestContext context) {

		//System.out.println("On Finish: ");
		//System.out.println(context.getPassedTests());
		//System.out.println(context.getFailedTests());

	}

}
