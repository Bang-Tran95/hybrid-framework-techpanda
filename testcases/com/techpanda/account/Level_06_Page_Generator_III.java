package com.techpanda.account;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.PageGeneratorManager;

public class Level_06_Page_Generator_III extends BaseTest {
	WebDriver driver;

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {

		loginPage = homePage.clickTToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		assertEquals(loginPage.getPasswordAddressEmptyErrorMessage(), "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {

		loginPage = homePage.clickTToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail() {

		loginPage = homePage.clickTToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");

	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword() {

		loginPage = homePage.clickTToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {

		loginPage = homePage.clickTToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("auto_test" + getrandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(getrandomNumber() + "");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordIncorectErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {

		loginPage = homePage.clickTToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("bentran@gmail.com");
		loginPage.inputToPasswordTextbox("123123");

		// Chuyển từ LoginPage -> DashboardPage
		myDashboardPage = loginPage.clickToLoginButton();

		assertTrue(myDashboardPage.getContactNameTextDisplay("Ben Tran"));

	}

	@Test
	public void TC_07_UpdateAccountInformation() {
		accountInformationPage = myDashboardPage.clickToAccountInformationLink();

		accountInformationPage.inputToFirstNameTextbox("Software");
		accountInformationPage.inputToLastNameTextbox("Testing");
		accountInformationPage.inputToEmailAddressTextbox("softwaretesting" + getrandomNumber() + "@live.com");
		accountInformationPage.inputCurentPasswordTextbox("123123");
		myDashboardPage = accountInformationPage.clickToSaveButton();

		assertTrue(myDashboardPage.isAccountInformationMessageSavedDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}