package com.techpanda.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import reportConfig.ExtentManager;

public class Level_17_Extent_Report_Version_2 extends BaseTest {
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
	public void TC_01_LoginWithEmptyEmailAndPassword(Method method) {
		
		ExtentManager.startTest(method.getName(), "TC_01_Login_Empty_Email_And_Password");
		ExtentManager.getTest().log(Status.INFO, "Login_01 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();

		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 02: Enter to Email Address textbox with empty data");
		loginPage.inputToEmailAddressTextbox("");
		
		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 03: Enter to Password textbox with empty data");
		loginPage.inputToPasswordTextbox("");
		
		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO,"Login_01 - Step 05: Verify Email Address Invalid Error Message");
		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordAddressEmptyErrorMessage(), "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail(Method method) {
		ExtentManager.startTest(method.getName(), "TC_02_Login_With_Invalid_Email");
		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();
		
		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 02: Enter to Email Address textbox");
		loginPage.inputToEmailAddressTextbox("123@456.789");
		
		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 03: Enter to Password textbox");
		loginPage.inputToPasswordTextbox("123456");
		
		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO,"Login_02 - Step 05: Verify Email Address Invalid Error Message");
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail(Method method) {
		ExtentManager.startTest(method.getName(), "TC_03_Login_With_Incorrect_Email");
		ExtentManager.getTest().log(Status.INFO,"Login_03 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();

		ExtentManager.getTest().log(Status.INFO,"Login_03 - Step 02: Enter to Email Address textbox");
		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		
		ExtentManager.getTest().log(Status.INFO,"Login_03 - Step 03: Enter to Password textbox");
		loginPage.inputToPasswordTextbox("123456");
		
		ExtentManager.getTest().log(Status.INFO,"Login_03 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO,"Login_03 - Step 05: Verify Email not exist in application");
		Assert.assertEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");

	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword(Method method) {
		ExtentManager.startTest(method.getName(), "TC_04_Login_With_Invalid_Password");
		ExtentManager.getTest().log(Status.INFO,"Login_04 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();

		ExtentManager.getTest().log(Status.INFO,"Login_04 - Step 02: Enter to Email Address textbox");
		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		
		ExtentManager.getTest().log(Status.INFO,"Login_04 - Step 03: Enter to Password textbox, less than 6 characters");
		loginPage.inputToPasswordTextbox("123");
		
		ExtentManager.getTest().log(Status.INFO,"Login_04 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();
		
		ExtentManager.getTest().log(Status.INFO,"Login_04 - Step 05: Verify Password invalid error message");
		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword(Method method) {
		ExtentManager.startTest(method.getName(), "TC_05_Login_With_Incorrect_Email");
		ExtentManager.getTest().log(Status.INFO,"Login_05 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();

		ExtentManager.getTest().log(Status.INFO,"Login_05 - Step 02: Enter to Email Address textbox");
		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		
		ExtentManager.getTest().log(Status.INFO,"Login_05 - Step 03: Enter to Password textbox");
		loginPage.inputToPasswordTextbox(getrandomNumber() + "");
		
		ExtentManager.getTest().log(Status.INFO,"Login_05 - Step 04: Enter to Login Button");
		loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO,"Login_05 - Step 05: Verify Password invalid error message");
		Assert.assertEquals(loginPage.getPasswordIncorectErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword(Method method) {
		ExtentManager.startTest(method.getName(), "TC_02_Login_With_Email_And_Password_Correct");
		ExtentManager.getTest().log(Status.INFO,"Login_06 - Step 01: Click to My Account Link");
		loginPage = homePage.openMyAccountPage();

		ExtentManager.getTest().log(Status.INFO,"Login_06 - Step 02: Enter to Email Address textbox");
		loginPage.inputToEmailAddressTextbox("bentran01@gmail.com");
		
		ExtentManager.getTest().log(Status.INFO,"Login_06 - Step 03: Enter to Password textbox");
		loginPage.inputToPasswordTextbox("123123");

		ExtentManager.getTest().log(Status.INFO,"Login_05 - Step 04: Enter to Login Button");
		myDashboardPage = loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO,"Login_06 - Step 05: Verify Login success");
		Assert.assertTrue(myDashboardPage.getContactNameTextDisplay("Ben Tran!"));

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}