package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobjects.FDObject;
import com.selenium.pageobjects.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;


public class FDTestCase {

	FDObject fd = new FDObject();

	@BeforeTest
	public void beforeTest() throws Exception {
	
	TestBase.initialize();
		
		
	 fd.openBrowser("chrome");
	 fd.exportPageFactory();
		
	}

	@Test(priority=0,description="Test cases to verify fixed depoist amount for 2000")
	public void fdAmount1()throws Exception {
		
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


	@AfterTest
	public void afterTest() {
		
	//	fd.closeBrowser();
	}

}
