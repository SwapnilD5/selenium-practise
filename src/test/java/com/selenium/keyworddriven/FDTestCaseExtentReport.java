package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.pageobjects.FDObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageobjects.ListenerCode.class)

public class FDTestCaseExtentReport {

	FDObject fd = new FDObject();
	
	ExtentHtmlReporter extentHtmlReport;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	

	@BeforeTest
	public void beforeTest() {
		
	 fd.openBrowser("chrome");
	 fd.exportPageFactory();
	 
	 extentHtmlReport=new ExtentHtmlReporter(FDObject.projectPath+"\\ReportFile.html");
	 extentHtmlReport.config().setDocumentTitle("Test Report");
	 extentHtmlReport.config().setReportName("Fixed deposit Report");

	 extentReports=new ExtentReports();
	 extentReports.attachReporter(extentHtmlReport);
	 extentReports.setSystemInfo("User Info", "Test User");
	 extentReports.setSystemInfo("Tool", "Selenium");
	 extentReports.setSystemInfo("Programming Language", "Java");

	}

	@Test(priority=0,description="Test cases to verify fixed depoist amount for 2000")
	public void fdAmount1()throws Exception {
		
		extentTest=extentReports.createTest("fdAmount1");
		
		fd.openBaseUrl();
		fd.typeValue(fd.txtPrincipal, "2000");
		fd.typeValue(fd.txtInterest, "10");
		fd.typeValue(fd.txtTenure, "1");
		fd.handledropDown(fd.dropDowntenurePeriod, "year(s)");
		fd.handledropDown(fd.dropDownfrequency, "Simple Interest");
		fd.btnClick(fd.btnCalculate);
		fd.pause(2);
		String maturityValue=fd.returnText(fd.maturityValue);
		System.out.println("Maturity Value : "+maturityValue);
		
		
	}
	
	@Test(priority=1,description="Test cases to verify fixed depoist amount for 3000")
	public void fdAmount2()throws Exception {
		
		extentTest=extentReports.createTest("fdAmount2");

		
		fd.typeValue(fd.txtPrincipal, "3000");
		fd.typeValue(fd.txtInterest, "12");
		fd.typeValue(fd.txtTenure, "2");
		fd.handledropDown(fd.dropDowntenurePeriod, "year(s)");
		fd.handledropDown(fd.dropDownfrequency, "Simple Interest");
		fd.btnClick(fd.btnCalculate);
		fd.pause(2);
		String maturityValue=fd.returnText(fd.maturityValue);
		System.out.println("Maturity Value : "+maturityValue);
	}

	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getName());
		}
		
		//Store report in given location....
		extentReports.flush();
	}
	

	@AfterTest
	public void afterTest() {
		
		fd.closeBrowser();
	}

}
