package com.techpanda.account;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.MyOrdersPageObject;
import pageObjects.user.PageGeneratorManager;

public class Level_07_Switch_Page extends BaseTest {
	WebDriver driver;

	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyDashBoardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPage;
	MyOrdersPageObject myOrdersPage;
	MyApplicationPageObject myApplicationPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	

	@Test
	public void TC_01_Login_With_Valid_Email_And_Password() {

		loginPage = homePage.openMyAccountPage();

		loginPage.inputToEmailAddressTextbox("bentran01@gmail.com");
		loginPage.inputToPasswordTextbox("123123");

		// Chuyển từ LoginPage -> DashboardPage
		myDashboardPage = loginPage.clickToLoginButton();

		assertTrue(myDashboardPage.getContactNameTextDisplay("Ben Tran"));

	}

	@Test
	public void TC_02_Navigate_Page() {
		
		// Từ Dashboard Page -> Account Information Page
		accountInformationPage =  myDashboardPage.openAccountInformationPage();
		
		//Từ Information Page -> My Orders Page
		myOrdersPage = accountInformationPage.openMyOrdersPage();
		
		//Từ My Order Page -> Account Information Page
		accountInformationPage = myOrdersPage.openAccountInformationPage();
		
		//Từ Information Page -> My Applications Page
		myApplicationPage =  accountInformationPage.openMyApplicationsPage();
		
		//Từ My Application Page -> My Orders Page
		myOrdersPage = myApplicationPage.openMyOrdersPage();
		
		//Từ My Orders Page -> My Application Page
		myApplicationPage = myOrdersPage.openMyApplicationsPage();
		
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}