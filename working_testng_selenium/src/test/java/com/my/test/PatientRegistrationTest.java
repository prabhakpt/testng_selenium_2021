package com.murx.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.murx.pages.HomePage;
import com.murx.pages.LoginPage;
import com.murx.pages.PatientManagementPage;
import com.murx.pages.PatientRegistrationPage;
import com.murx.utils.ReadProperties;
import com.murx.xlsx.XLSXReader;

public class PatientRegistrationTest extends BaseTest{
	
	WebDriver driver;
	ReadProperties properties = new ReadProperties();
	LoginPage loginPage;
	HomePage homePage;
	PatientManagementPage patientManagementPage;
	PatientRegistrationPage patientRegistrationPage;
	
	@BeforeTest
	public void accessHomePage() {
		// Setting up the driver
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * WebDriverManager.chromedriver().setup(); driver = new
		 * ChromeDriver(chromeOptions); driver.manage().window().maximize();
		 */
		driver = getDriver();
		// Initialize the Pages
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		patientManagementPage = new PatientManagementPage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
	}

	@Test(priority = 1)
	public void loginToApplication() {
		// Access Home/Login page
		driver.get(properties.getPropertyValue("dev.url"));
		
		// Enter Login to application
		loginPage.enterUserName(properties.getPropertyValue("user.name"));
		loginPage.enterPassword(properties.getPropertyValue("password"));
		loginPage.clickLoginButton();
	}
	
	@Test(priority = 2)
	public void accessPatientManagementLink() {
		homePage.waitForTheElementToPresent(homePage.patientManagementLink);
		homePage.clickOnPatientManageLink();
	}
	
	@Test(priority = 3)
	public void clickPatientRegistrationButton() {
		patientManagementPage.clickPatientRegistrationButton();
	}
	
	//@Test(dataProvider = "userInformation")
	public void inputData(String patientSalutation, String firstName, String middleName, String lastName, String age,
			String gender, String dob, String adharNo, String alternateIdType, String alternateID, String maritalStatus,
			String mobileNumber) {
		
		//Enter all values then click on Register button and track the status
		patientRegistrationPage.selectSalutation(patientSalutation);
		patientRegistrationPage.enterFirstName(firstName);
		patientRegistrationPage.enterMiddleName(middleName);
		patientRegistrationPage.enterLastName(lastName);
		patientRegistrationPage.enterAge(age);
		patientRegistrationPage.selectGenter(gender);
		
		// Reading the error notifications/ Success notifications
		
		// Write the status based of notification appears after Clicking on register button.
		
	}
	
	@Test(priority = 4)
	public void test() {
		patientRegistrationPage.selectSalutation("Dr.");
		patientRegistrationPage.waitForTime(2);
		patientRegistrationPage.enterFirstName("Dhoni");
		patientRegistrationPage.waitForTime(2);
		patientRegistrationPage.enterMiddleName("a");
		patientRegistrationPage.waitForTime(2);
		patientRegistrationPage.enterLastName("Sachin");
		patientRegistrationPage.enterAge("");
		patientRegistrationPage.waitForTime(3);
		patientRegistrationPage.selectGenter("Do not want to specify");
		patientRegistrationPage.waitForTime(10);
	}

	//@DataProvider(name = "userInformation")
	public String[][] getExcelData() throws IOException {
		XLSXReader read = new XLSXReader();
		return read.getUserInfo();
	}
	
	@BeforeTest
	public void tearDown() {
		driver.quit();
	}

}
