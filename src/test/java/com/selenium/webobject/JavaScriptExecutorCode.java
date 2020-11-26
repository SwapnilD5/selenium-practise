package com.selenium.webobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorCode {
	WebDriver w;
	
	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test
	public void javaScriptExec() {
		
		JavascriptExecutor js;

		
		w.get("https://opensource-demo.orangehrmlive.com/index.php");
		
		js=(JavascriptExecutor)w;
		js.executeScript("alert('Welcome to Login Page...');");
        
		
		
		WebElement txtUsername=w.findElement(By.id("txtUsername"));			
		js=(JavascriptExecutor)w;
		js.executeScript("arguments[0].value='Admin'", txtUsername);
		
		
		WebElement txtPassword=w.findElement(By.id("txtPassword"));		
		js=(JavascriptExecutor)w;
		js.executeScript("arguments[0].value='admin123'", txtPassword);
		
		
		WebElement btnLogin=w.findElement(By.id("btnLogin"));		
		js=(JavascriptExecutor)w;
		js.executeScript("arguments[0].click()", btnLogin);
		
		
	
		
		
		
		
		
		
		
		
		
	}
}
