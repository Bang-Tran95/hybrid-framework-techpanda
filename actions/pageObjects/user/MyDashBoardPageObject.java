package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyDashBoardPageUI;

public class MyDashBoardPageObject extends BasePage {

	WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public boolean getContactNameText() {
		waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFOR_NAME);
		return true;
	}

	public boolean getContactConTentText() {
		waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFOR_CONTENT);
		return true;
	}

}
