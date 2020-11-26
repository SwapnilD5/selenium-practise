package com.selenium.webobject;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testWait {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver w;
		w = new ChromeDriver();
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		w.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		w.get("https://in.via.com/flight-tickets");

		w.findElement(By.id("wzrk-cancel")).click();

		// Select source location
		w.findElement(By.id("source")).clear();
		w.findElement(By.id("source")).sendKeys("Mumbai");
		Thread.sleep(3000);
		w.findElement(By.id("ui-id-1")).click();

		// Select target location

		w.findElement(By.id("destination")).clear();
		w.findElement(By.id("destination")).sendKeys("Pune");
		Thread.sleep(3000);
		w.findElement(By.id("ui-id-2")).click();
		Thread.sleep(3000);

		w.findElement(By.xpath("(//div[contains(@class,'vc-cell') and contains(@data-date,'1')])[2]")).click();

		Thread.sleep(3000);
		w.findElement(By.id("search-flight-btn")).click();

	//	Thread.sleep(12000);
		
	//	WebDriverWait wt=new WebDriverWait(w, 30);
	//	wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cheap_flight_container']/div[2]/div/div[1]/div[3]/span[2]")));

		Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class); // this defines the exception to ignore

		WebElement foo = fluentwt.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//*[@id='cheap_flight_container']/div[2]/div/div[1]/div[3]/span[2]"));
			}
		});
		
		
		String price = w.findElement(By.xpath("//*[@id='cheap_flight_container']/div[2]/div/div[1]/div[3]/span[2]"))
				.getText();

		
		System.out.println("Cheapest Flights is : " + price);

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		String projectPath = System.getProperty("user.dir");

		FileUtils.copyFile(f, new File(projectPath + "\\Flight.png"));

		w.quit();

	}

}
