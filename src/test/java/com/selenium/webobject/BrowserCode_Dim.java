package com.selenium.webobject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode_Dim {

	WebDriver w;
	String projectPath = System.getProperty("user.dir");

	@Test(priority=0,description="verify chrome")
	public void chrome() {

		WebDriverManager.chromedriver().setup();		
		w = new ChromeDriver();
		
		//Dimension dim=new Dimension(800, 800);
		w.manage().window().maximize();
		
	//	w.manage().window().maximize();
		
		w.get("https://www.google.com/");
	}

	@Test(priority=1,description="verify firefox")
	public void firefox() {
		
		
		WebDriverManager.firefoxdriver().setup();
		
		w = new FirefoxDriver();
		Dimension dim=new Dimension(700, 600);
		w.manage().window().setSize(dim);		
		w.get("https://www.google.com/");
		
		w.navigate().refresh();

	}

	@Test(priority=2,description="verify Edge")
	public void edge() {

		WebDriverManager.edgedriver().setup();
		
		w = new EdgeDriver();
		//w.manage().window().maximize();

		Dimension dim=new Dimension(400, 400);
		w.manage().window().setSize(dim);
		
		w.get("https://www.google.com/");

	}

	@Test(priority=3,description="verify opera")
	public void opera() {

		WebDriverManager.operadriver().setup();
		
		w = new OperaDriver();
	    w.manage().window().maximize();

		
		
		w.get("https://www.google.com/");

	}

}
