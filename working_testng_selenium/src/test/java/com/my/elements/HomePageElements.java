package com.murx.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageElements {

	@FindBy(how = How.XPATH, using = "//img[contains(@src,'patientRegistration.jpg')]")
	public WebElement patientManagementLink;
	
}
