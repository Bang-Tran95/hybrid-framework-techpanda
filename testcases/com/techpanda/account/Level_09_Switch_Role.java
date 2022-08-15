package com.techpanda.account;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminManagerCustomerPageObject;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashBoardPageObject;
import pageObjects.user.MyOrdersPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_09_Switch_Role extends BaseTest {
	WebDriver driver;

	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminManagerCustomerPageObject adminManagerCustomerPage;
	MyDashBoardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPage;
	MyOrdersPageObject myOrdersPage;
	MyApplicationPageObject myApplicationPage;
	
	String userUrl, adminUrl;

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
		
		driver = getBrowserDriver(browserName, this.userUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
	}

	@Test
	public void TC_01_Switch_Role() {

		userLoginPage = userHomePage.openMyAccountPage();

		userLoginPage.inputToEmailAddressTextbox("bentran01@gmail.com");
		userLoginPage.inputToPasswordTextbox("123123");

		// Chuyển từ LoginPage -> DashboardPage
		myDashboardPage = userLoginPage.clickToLoginButton();

		assertTrue(myDashboardPage.getContactNameTextDisplay("Ben Tran"));

		// User -> Admin
		adminLoginPage = myDashboardPage.openAdminLoginPage(driver, adminUrl);
		
		adminLoginPage.inputToUserNameTextbox("user01");
		adminLoginPage.inputToPasswordTextbox("guru99com");
		adminManagerCustomerPage = adminLoginPage.clickToLoginButton();
		
		adminManagerCustomerPage.clickCloseIncomingMessage();
		
		// Logout
		adminLoginPage = adminManagerCustomerPage.clickToLogOutLink(driver);

		// Admin -> User
		userHomePage = adminLoginPage.openUserHomePage(driver, userUrl);
		
		userLoginPage = userHomePage.openMyAccountPage();
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}