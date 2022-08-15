package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	
	WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashBoardPage(driver);
		
	}

	public Object getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
	}

	public Object getPasswordAddressEmptyErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
	}


	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	public String getEmailAddressIncorrectErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
	}

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	public String getPasswordIncorectErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
	}

}
