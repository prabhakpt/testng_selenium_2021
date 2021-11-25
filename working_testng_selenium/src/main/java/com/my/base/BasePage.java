package com.murx.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.murx.utils.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {
	
	protected static WebDriver driver;
	
	public static ReadProperties readProperties = new ReadProperties();
	
	public static WebDriver getDriverInstance() {
		System.out.println("Returning the driver:"+ driver);
		return driver;
	}
	
	@BeforeClass
	public void configureDriver() {
		System.out.println("Running configureDriver before class");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

