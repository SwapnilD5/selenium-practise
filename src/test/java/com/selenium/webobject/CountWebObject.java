package com.selenium.webobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountWebObject {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}
	
	@Test(priority=0,description="Count radiobutton")
	public void countRadio() {	 
		  w.get("http://demo.automationtesting.in/Register.html");

		List<WebElement> radio=w.findElements(By.cssSelector("input[type='radio']"));		
		System.out.println("Number of radio button : "+radio.size());	
		
	}
	
	@Test(priority=1,description="Count CheckBox")
	public void countCheckbox() {	 

		List<WebElement> checkbox=w.findElements(By.cssSelector("input[type='checkbox']"));		
		System.out.println("Number of checkbox : "+checkbox.size());	
		
	}
	
	@Test(priority=2,description="Count drop-down list")
	public void countdropdownlist() {	 

		List<WebElement> drop_down=w.findElements(By.tagName("select"));	
		System.out.println("Number of drop_down : "+drop_down.size());	
		
	}
	
	
	
	
	
	
	
	
	
}
