package com.travelsolution.core.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Framework {
	
	private static WebDriver driver;
	
	public void initBrowser(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		Capabilities caps = DesiredCapabilities.chrome(); 
		driver = new ChromeDriver(caps);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		System.out.println("Browser started");
	}
	
	public  void type(String locator, String text){
		getDriver().findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public  void click(String locator){
		getDriver().findElement(By.xpath(locator)).click();
	}
	
	public  String getText(String locator){
		return getDriver().findElement(By.xpath(locator)).getText();
	}
	
	public  void open(String url){
		System.out.println("Open url: " + url);
		getDriver().get(url);
	}
	
	public  void waitForElement(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void killDriver(){
		driver.quit();
	}
	
	public WebDriver getDriver(){
		if(driver != null){
			return driver;
		}
		initBrowser();
		return driver;
	}
}
