package com.techpanda.account;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyDashBoardPageObject;

public class Level_03_Apply_Page_Object_Pattern {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyDashBoardPageObject myDashboardPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://live.techpanda.org");
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {

		homePage.openMyAccountPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		assertEquals(loginPage.getPasswordAddressEmptyErrorMessage(), "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {

		homePage.openMyAccountPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail() {

		homePage.openMyAccountPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");

	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword() {

		homePage.openMyAccountPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {

		homePage.openMyAccountPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(randomNumber() + "");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordIncorectErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {

		homePage.openMyAccountPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboardPage = new MyDashBoardPageObject(driver);
		

		assertTrue(myDashboardPage.getContactNameTextDisplay("Automation FC"));
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}