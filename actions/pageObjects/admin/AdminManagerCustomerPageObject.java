package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminManageCustomerPageUI;

public class AdminManagerCustomerPageObject extends BasePage {

	WebDriver driver;

	public AdminManagerCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCloseIncomingMessage() {
		waitForElementVisible(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE);
		waitForElementClickable(driver, AdminManageCustomerPageUI.CLOSE_BUTTON);
		clickToElement(driver, AdminManageCustomerPageUI.CLOSE_BUTTON);
	}

}
