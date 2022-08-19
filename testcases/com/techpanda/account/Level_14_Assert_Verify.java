package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

@Listeners(commons.MethodListener.class)
public class Level_14_Assert_Verify extends BaseTest {
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

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		verifyEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		//fail 1
		verifyEquals(loginPage.getPasswordAddressEmptyErrorMessage(), "This is a required field....");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

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

		loginPage.inputToEmailAddressTextbox("bentran@gmail.com");
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