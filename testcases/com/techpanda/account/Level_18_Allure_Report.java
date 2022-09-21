package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_18_Allure_Report extends BaseTest {
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

	@Description("TC_01: Login with empty Email and Password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("");

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordAddressEmptyErrorMessage(), "This is a required field.");

	}

	@Description("TC_02: Login with Invalid Email")
	@Test
	public void TC_02_LoginWithInvalidEmail() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("123@456.789");

		loginPage.inputToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Description("TC_03: Login with Incorrect Email")
	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");

		loginPage.inputToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");

	}

	@Description("TC_02: Login with Invalid Password")
	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");

		loginPage.inputToPasswordTextbox("123");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Description("TC_02: Login with Incorrect Password")
	@Test
	public void TC_05_LoginWithIncorrectPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");

		loginPage.inputToPasswordTextbox(getrandomNumber() + "");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getPasswordIncorectErrorMessage(), "Invalid login or password.");

	}

	@Description("TC_02: Login with Email and Password Correct")
	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("bentran01@gmail.com");

		loginPage.inputToPasswordTextbox("123123");

		myDashboardPage = loginPage.clickToLoginButton();

		Assert.assertTrue(myDashboardPage.getContactNameTextDisplay("Ben Tran!"));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}