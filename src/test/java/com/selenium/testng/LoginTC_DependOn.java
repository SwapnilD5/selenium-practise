package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTC_DependOn {

	String projectPath = System.getProperty("user.dir");
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority=0,description="Test Case to verify Login functionality with 'tuser' user.")
	public void loginTestUser() {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
	
	}
	
	@Test(priority=1,description="Test Case to verify Logout functioanlity",dependsOnMethods="loginTestUser")
	public void logoutTestUser() {
		
      w.findElement(By.linkText("Sign Off")).click();
	
      
	}

	
	
	

	@AfterTest
	public void postCondition() {

		w.quit();
	}

}
