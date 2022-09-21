package pageObjects.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObjects.navigation.SideBarMyAccountPageObject;
import pageUIs.user.MyDashBoardPageUI;

public class MyDashBoardPageObject extends SideBarMyAccountPageObject {

	WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}
	
	@Step("Verify Contact Name Display")
	public boolean getContactNameTextDisplay(String contactInfor) {
		waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFOR_NAME);
		String actualContactName = getTextElement(driver, MyDashBoardPageUI.CONTACT_INFOR_NAME);
		return actualContactName.contains(contactInfor);
	}

	@Step("Verify Account Information Message Saved Display")
	public boolean isAccountInformationMessageSavedDisplayed() {
		waitForElementInVisible(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_SAVED);
		return isElementDisplayed(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_SAVED);
	}

	
	
	

}
