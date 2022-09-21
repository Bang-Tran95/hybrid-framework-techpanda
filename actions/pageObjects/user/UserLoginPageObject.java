package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	
	WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	@Step("Input To Email Textbox with value {0}")
	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	@Step("Input To Password Textbox with value {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	@Step("Click To Login Button")
	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashBoardPage(driver);
		
	}

	@Step("Get Email Address Empty Message")
	public Object getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
	}

	@Step("Get Pasword Empty Message")
	public Object getPasswordAddressEmptyErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
	}

	@Step("Get Email Address Invald Message")
	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
	}
	
	@Step("Get Email Address Incorect Message")
	public String getEmailAddressIncorrectErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
	}

	@Step("Get Password Invalid Message")
	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	@Step("Get Password Incorrect Message")
	public String getPasswordIncorectErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ADDRESS_INCORRECT_ERROR_MESSAGE);
	}

}
