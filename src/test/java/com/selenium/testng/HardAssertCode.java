package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertCode {

	String projectPath = System.getProperty("user.dir");
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority=0,description="Test Case to verify Login functionality with 'admin' user.",groups="Login",enabled=true)
	public void loginTestUser() {

		w.get("http://demo.testfire.net/login.jsp");
		
		String currentPageTitle=w.getTitle();		
		WebElement currentPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String labelText=currentPageLabel.getText();
		
		//Equals means matching
		Assert.assertEquals(currentPageTitle, "Altoro Mutual");		
		Assert.assertTrue(labelText.contains("Login"),"Page Label is different");

		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();

	}

	@Test(priority=1,description="Test Case to verify Logout functionality")
	public void logoutTestUser() {
		
		
		String currentPageTitle=w.getTitle();		
		WebElement currentPageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String labelText=currentPageLabel.getText();
		
		//Equals means matching
		Assert.assertEquals(currentPageTitle, "Altoro Mutual");		
		Assert.assertTrue(labelText.contains("Admin"),"Page Label is different");

		w.findElement(By.linkText("Sign Off")).click();

	}

	@AfterTest
	public void afterTest() {
	}

}
