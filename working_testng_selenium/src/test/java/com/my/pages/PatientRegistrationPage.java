package com.murx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.murx.elements.PatientRegistrationElements;

public class PatientRegistrationPage extends PatientRegistrationElements{

	WebDriver driver;
	
	public PatientRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForTime(int waitTime) {
		try {
			Thread.sleep(waitTime*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectSalutation(String patientSalutation) {
		Select select = new Select(salutation);
		select.selectByVisibleText(patientSalutation);
	}
	
	public void enterFirstName(String pFirstName) {
		firstName.sendKeys(pFirstName);
	}
	
	public void enterMiddleName(String pMiddleName) {
		middleName.sendKeys(pMiddleName);
	}
	
	public void enterLastName(String pLastName) {
		lastName.sendKeys(pLastName);
	}
	
	public void enterAge(String pAge) {
		age.sendKeys(pAge);
	}
	
	public void selectGenter(String pGender) {
		Select select = new Select(gender);
		select.selectByVisibleText(pGender);
	}
}
