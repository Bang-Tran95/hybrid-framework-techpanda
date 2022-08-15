package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminManagerCustomerPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static MyDashBoardPageObject getMyDashBoardPage(WebDriver driver) {
		return new MyDashBoardPageObject(driver);
	}

	public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}

	public static MyOrdersPageObject getMyOrdersPage(WebDriver driver) {
		return new MyOrdersPageObject(driver);
	}

	public static MyApplicationPageObject getMyApplicationPage(WebDriver driver) {
		return new MyApplicationPageObject(driver);
	}

	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}

	public static ContactUsPageObject getContactUsPage(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}

	public static SearchTermsPageObject getSearchTermsPage(WebDriver driver) {
		return new SearchTermsPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminManagerCustomerPageObject getAdminManagerCustomerPage(WebDriver driver) {
		return new AdminManagerCustomerPageObject(driver);
	}
}
