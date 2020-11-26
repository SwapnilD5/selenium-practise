package com.selenium.webobject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCodeTest {
	
	WebDriver w;
	String projectPath=System.getProperty("user.dir");
	String storeScreenshot;
	
	
	public void takeScreenshot() throws Exception {		
		
	//	String currencyOption=get();
		//  String storeScreenshot=projectPath+"\\ScreenshotFolder\\"+currencyOption+".png";		
		 TakesScreenshot ts=(TakesScreenshot)w;
		  File fin=ts.getScreenshotAs(OutputType.FILE);	 
		  FileUtils.copyFile(fin, new File(storeScreenshot));
	}

}
