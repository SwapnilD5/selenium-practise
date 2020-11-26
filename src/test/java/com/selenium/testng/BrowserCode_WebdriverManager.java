package com.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode_WebdriverManager {

	WebDriver w;
	String projectPath = System.getProperty("user.dir");

	@Test(priority=0,description="verify chrome")
	public void chrome() {

		WebDriverManager.chromedriver().setup();
		
		w = new ChromeDriver();
		w.get("https://www.google.com/");
	}

	@Test(priority=1,description="verify firefox")
	public void firefox() {
		
		
		WebDriverManager.firefoxdriver().setup();
		
		w = new FirefoxDriver();
		w.get("https://www.google.com/");

	}

	@Test(priority=2,description="verify Edge")
	public void edge() {

		WebDriverManager.edgedriver().setup();
		
		w = new EdgeDriver();
		w.get("https://www.google.com/");

	}

	@Test(priority=3,description="verify opera")
	public void opera() {

		WebDriverManager.operadriver().setup();
		
		w = new OperaDriver();
		w.get("https://www.google.com/");

	}

}
