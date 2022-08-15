package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextbox(String userName) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXBOX, userName);
		
	}

	public void inputToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXBOX, passWord);
		
	}

	public AdminManagerCustomerPageObject clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminManagerCustomerPage(driver);
	}
}
