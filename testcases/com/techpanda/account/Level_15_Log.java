package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_15_Log extends BaseTest {
	WebDriver driver;

	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyDashBoardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		
		log.info("Login_01 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();

		log.info("Login_01 - Step 02: Enter to Email Address textbox with empty data");
		loginPage.inputToEmailAddressTextbox("");
		
		log.info("Login_01 - Step 03: Enter to Password textbox with empty data");
		loginPage.inputToPasswordTextbox("");
		
		log.info("Login_01 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();

		log.info("Login_01 - Step 05: Verify Email Address Empty Error Message");
		verifyEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		
		log.info("Login_01 - Step 05: Verify PassWord Empty Error Message");
		verifyEquals(loginPage.getPasswordAddressEmptyErrorMessage(), "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		log.info("Login_02 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();
		
		log.info("Login_02 - Step 02: Enter to Email Address textbox with empty data");
		loginPage.inputToEmailAddressTextbox("123@456.789");
		
		log.info("Login_02 - Step 03: Enter to Password textbox with empty data");
		loginPage.inputToPasswordTextbox("123456");
		
		log.info("Login_02 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();

		log.info("Login_01 - Step 05: Verify Email Address Invalid Error Message");
		verifyEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		verifyEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");

	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		//fail 2
		verifyEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces....");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(getrandomNumber() + "");
		loginPage.clickToLoginButton();

		verifyEquals(loginPage.getPasswordIncorectErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("bentran01@gmail.com");
		loginPage.inputToPasswordTextbox("123123");

		// Chuyển từ LoginPage -> DashboardPage
		myDashboardPage = loginPage.clickToLoginButton();

		verifyTrue(myDashboardPage.getContactNameTextDisplay("Ben Tran"));

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}