package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTC {

	String projectPath = System.getProperty("user.dir");
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority=0,description="Test Case to verify Login functionality with 'tuser' user.",groups="Login",enabled=true)
	public void loginTestUser() {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		w.findElement(By.linkText("Sign Off")).click();

		System.out.println("Test Case executed ..");
	}
	@Test(priority=1,description="Test Case to verify Login functionality with 'admin' user.",groups="Login",enabled=true)
	public void loginAdmin() {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		w.findElement(By.linkText("Sign Off")).click();

		System.out.println("Test Case executed ..");
	}
	
	

	@AfterTest
	public void postCondition() {

		w.quit();
	}

}
