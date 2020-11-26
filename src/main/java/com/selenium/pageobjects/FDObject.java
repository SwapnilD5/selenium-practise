package com.selenium.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FDObject {

	static WebDriver w;
	String baseUrl = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html";
	public static String projectPath = System.getProperty("user.dir");

	@FindBy(id = "principal")
	public WebElement txtPrincipal;

	@FindBy(name = "interest")
	public WebElement txtInterest;

	@FindBy(id = "tenure")
	public WebElement txtTenure;

	@FindBy(id = "tenurePeriod")
	public WebElement dropDowntenurePeriod;

	@FindBy(id = "frequency")
	public WebElement dropDownfrequency;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]")
	public WebElement btnCalculate;

	@FindBy(id = "resp_matval")
	public WebElement maturityValue;
	
	@FindBy(xpath="[cuurecy]//li")
	public List<WebElement> currency;
	

	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
		}

	}

	public void closeBrowser() {
		w.quit();
	}

	public void openBaseUrl() {
		w.get(baseUrl);
	}
	
	public void openBaseUrlProperties(String url) {
		w.get(url);
	}


	public void typeValue(WebElement we, String value) {
		we.clear();
		we.sendKeys(value);
	}

	public void btnClick(WebElement we) {
		we.click();
	}

	public void handledropDown(WebElement we, String value) {

		Select sc = new Select(we);
		sc.selectByVisibleText(value);

	}

	public String returnTitle() {
		return w.getTitle();
	}

	public String returnText(WebElement we) {
		return we.getText();
	}

	public void pause(int sec) throws Exception {
		sec = sec * 1000;
		Thread.sleep(sec);
	}

	public static String captureScreenshot(ITestResult result, String status) throws Exception {

		String filename = result.getMethod().getMethodName() + ".png";

		TakesScreenshot ts = (TakesScreenshot) w;
		File fin = ts.getScreenshotAs(OutputType.FILE);

		if (status.equalsIgnoreCase("passed")) {
			FileUtils.copyFile(fin, new File(projectPath + "\\ScreenShot\\Pass\\" + filename));
		} else if (status.equalsIgnoreCase("failed")) {
			FileUtils.copyFile(fin, new File(projectPath + "\\ScreenShot\\Fail\\" + filename));
		}
		return filename;
	}
	
	
	public String readValueProperty(String key) throws Exception {
		
		TestBase.initialize();
		
	    return TestBase.prop.getProperty(key); //return be value of given key
	    
	}
	
	

	public void exportPageFactory() {

		PageFactory.initElements(w, this);
	}

}
