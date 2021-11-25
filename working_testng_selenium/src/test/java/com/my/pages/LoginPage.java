package com.murx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.murx.elements.LoginPageElements;

public class LoginPage extends LoginPageElements{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void enterUserName(String userLoginName) {
		userName.sendKeys(userLoginName);
	}
	
	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void clickLoginButton() {
		submitButton.click();
	}
}
