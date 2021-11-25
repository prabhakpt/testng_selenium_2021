package com.murx.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PatientManagementElements {
	
	@FindBy(how = How.XPATH, using="//form[@id='patient-search']/div[3]/div[2]/button[1]")
	public WebElement patientRegistrationButton;
	
}
