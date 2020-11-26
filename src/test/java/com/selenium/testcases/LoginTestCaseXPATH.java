package com.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCaseXPATH {

	public static void main(String[] args) {
		
		String projectPath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");		
		WebDriver w = new ChromeDriver();
		
		//Steps :
		
		w.get("http://demo.testfire.net/login.jsp");	


		w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys("admin");
		
		w.findElement(By.xpath("//*[@id=\"passw\"]")).sendKeys("admin");
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		
		w.findElement(By.xpath("/html/body/div[1]/form/table/tbody/tr[1]/td[2]/a[1]/font")).click();
		
		System.out.println("Test Case executed ..");
		
		w.quit();
		

	}

}
