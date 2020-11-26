package com.selenium.webobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleAlert {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.firefoxdriver().setup();
		w = new FirefoxDriver();
	}

	@Test(priority=0,description="handle alert")
	public void handleAlertCode() {
		
		//w.get("");
		
		w.navigate().to("http://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).clear();
		w.findElement(By.id("uid")).sendKeys("Test");
		w.findElement(By.name("btnSubmit")).click();
		
		w.switchTo().alert().dismiss();
		
		w.findElement(By.id("uid")).clear();
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).clear();
		w.findElement(By.id("passw")).sendKeys("tuser");
	
		w.findElement(By.name("btnSubmit")).click();
		w.findElement(By.linkText("Sign Off")).click();
		
		w.quit();
		
		
		
		
		
		
	}
}
