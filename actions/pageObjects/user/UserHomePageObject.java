package pageObjects.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObjects.navigation.SideBarMyAccountPageObject;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends SideBarMyAccountPageObject {
	
	WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	@Step("Open My Account Link")
	public UserLoginPageObject openMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

}
