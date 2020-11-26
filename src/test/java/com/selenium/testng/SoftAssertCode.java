package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class SoftAssertCode {

	String projectPath = System.getProperty("user.dir");
	WebDriver w;
	SoftAssert st;

	@BeforeTest
	public void preCondition() {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeSoftAssert() {

		st = new SoftAssert();

	}

	@Test(priority = 0, description = "Test Case to verify Login functionality with 'admin' user.", groups = "Login", enabled = true)
	public void loginTestUser() {

		w.get("http://demo.testfire.net/login.jsp");

		String currentPageTitle = w.getTitle();
		WebElement currentPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String labelText = currentPageLabel.getText();

		st.assertEquals(currentPageTitle, "ALtoro Login");
		st.assertTrue(labelText.contains("Login"), "Page label is different");

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
        st.assertAll();
	}

	@Test(priority = 1, description = "Test Case to verify Logout functionality")
	public void logoutTestUser() {

		String currentPageTitle = w.getTitle();
		WebElement currentPageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String labelText = currentPageLabel.getText();

		st.assertEquals(currentPageTitle, "ALtoro HomePage");
		st.assertTrue(labelText.contains("ABCD"), "Page label is different");

		w.findElement(By.linkText("Sign Off")).click();
		st.assertAll();
	}
	
	

}
