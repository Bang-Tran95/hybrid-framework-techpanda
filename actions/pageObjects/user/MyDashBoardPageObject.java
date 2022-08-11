package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyDashBoardPageUI;

public class MyDashBoardPageObject extends BasePage {

	WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public boolean getContactNameTextDisplay(String contactInfor) {
		waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFOR_NAME);
		String actualContactName = getTextElement(driver, MyDashBoardPageUI.CONTACT_INFOR_NAME);
		return actualContactName.contains(contactInfor);
	}

	public AccountInformationPageObject clickToAccountInformationLink() {
		waitForElementClickable(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPage(driver);
	}

	public boolean isAccountInformationMessageSavedDisplayed() {
		waitForElementInVisible(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_SAVED);
		return isElementDisplayed(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_SAVED);
	}

}
