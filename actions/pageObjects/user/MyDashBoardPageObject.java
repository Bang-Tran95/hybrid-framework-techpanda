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


}
