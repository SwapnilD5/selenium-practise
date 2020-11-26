package com.selenium.datadriven;

import org.testng.annotations.Test;

import com.selenium.pageobjects.FDObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataDriven_DataProvider {

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "2000", "10" ,"3" ,"Simple Interest" }, 
			new Object[] { "3000", "8" , "2","Simple Interest" }, 
			new Object[] { "4000", "12" , "4","Simple Interest" }, 
		};
	}

	FDObject fd=new FDObject();
	
	@BeforeTest
	public void beforeTest() {
		
		fd.openBrowser("chrome");
		fd.exportPageFactory();

	}
	
	@Test(dataProvider = "dp")
	public void fdAmount(String priciple, String interest,String tenure,String frequency) throws Exception {
		
		fd.openBaseUrl();
		fd.typeValue(fd.txtPrincipal, priciple);
		fd.typeValue(fd.txtInterest, interest);
		fd.typeValue(fd.txtTenure, tenure);
		fd.handledropDown(fd.dropDowntenurePeriod, "year(s)");
		fd.handledropDown(fd.dropDownfrequency, frequency);
		fd.btnClick(fd.btnCalculate);
		fd.pause(2);
		String maturityValue=fd.returnText(fd.maturityValue);
		System.out.println("Maturity Value for "+priciple+": "+maturityValue);
	}


	@AfterTest
	public void afterTest() {
		fd.closeBrowser();
	}

}
