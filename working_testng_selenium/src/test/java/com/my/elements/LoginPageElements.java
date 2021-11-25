package com.murx.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageElements {
	
	@FindBy(how = How.NAME, using = "ssoId")
	public WebElement userName;
	
	@FindBy(how = How.NAME, using="password")
	public WebElement password;
	
	@FindBy(how =How.ID, using="submitButton")
	public WebElement submitButton;	

}
