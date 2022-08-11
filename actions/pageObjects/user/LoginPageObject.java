package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.LoginPageUI;

public class LoginPageObject extends BasePage {
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashBoardPage(driver);
		
	}

	public Object getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
	}

	public Object getPasswordAddressEmptyErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
	}


	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	public String getEmailAddressIncorrectErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
	}

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	public String getPasswordIncorectErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
	}

}
