package com.selenium.webobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleFrame {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.firefoxdriver().setup();
		w = new FirefoxDriver();
	}

	@Test(priority=0,description="handle frame")
	public void handleFrameCode() {
		
		//w.get("");
		
		w.navigate().to("https://s1.demo.opensourcecms.com/s/5");
		
		//w.switchTo().frame("preview-frame");
		
		w.switchTo().frame(w.findElement(By.cssSelector("iframe.full-screen-preview__frame")));
		
		w.findElement(By.id("q")).clear();
		w.findElement(By.id("q")).sendKeys("Selenium");
	
		
		
	}
}
