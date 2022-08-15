package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyOrdersPageObject;
import pageObjects.user.PageGeneratorManager;
import pageUIs.navigation.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {

	WebDriver driver;

	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AccountInformationPageObject openAccountInformationPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPage(driver);
	}

	public MyApplicationPageObject openMyApplicationsPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.MY_APPLICATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_APPLICATION_LINK);
		return PageGeneratorManager.getMyApplicationPage(driver);
	}

	public MyOrdersPageObject openMyOrdersPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.MY_ORDERS_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_ORDERS_LINK);
		return PageGeneratorManager.getMyOrdersPage(driver);
	}

	// 1 method, áp dụng cho bài 10
	public void openSideBarLinkByPageName(String pageName) {
		waitForElementVisible(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
	}

}
