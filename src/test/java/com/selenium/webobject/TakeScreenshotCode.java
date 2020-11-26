package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TakeScreenshotCode {
 
	WebDriver w;
	String projectPath=System.getProperty("user.dir");
	String storeScreenshot;
	
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
	  
  }
  
  @Test
  public void f() throws Exception{
	  
	  w.get("https://www.selenium.dev/");
	  
	  storeScreenshot=projectPath+"\\ScreenshotFolder\\Selenium.png";
	  
	  TakesScreenshot ts=(TakesScreenshot)w;
	  File fin=ts.getScreenshotAs(OutputType.FILE);	 
	  FileUtils.copyFile(fin, new File(storeScreenshot));
	  
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
