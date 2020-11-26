package com.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCaseCSS {

	public static void main(String[] args) {
		
		String projectPath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");		
		WebDriver w = new ChromeDriver();
		
		//Steps :
		
		w.get("http://demo.testfire.net/login.jsp");	
		w.findElement(By.cssSelector("input#uid")).sendKeys("admin");
        w.findElement(By.cssSelector("input[type='password']")).sendKeys("admin");
		w.findElement(By.cssSelector("input[name='btnSubmit']")).click();	

		w.findElement(By.cssSelector("a#LoginLink")).click();

		
		System.out.println("Test Case executed ..");
		
		w.quit();
		

	}

}
