package com.murx.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PatientRegistrationElements {
	
	@FindBy(how = How.ID, using="field-prefix")
	public WebElement salutation;
	
	@FindBy(how = How.ID, using="field-first-name")
	public WebElement firstName;
	
	@FindBy(how = How.ID, using="field-middle-name")
	public WebElement middleName;
	
	@FindBy(how =How.ID, using="field-last-name")
	public WebElement lastName;
	
	@FindBy(how = How.ID, using="field-age")
	public WebElement age;
	
	@FindBy(how = How.ID, using="field-patient-gender")
	public WebElement gender;
	
}
