package pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "email")
	WebElement EmailAddressTextbox;
	
	@FindBy(id = "pass")
	WebElement PasswordTextbox;
	
	@FindBy(id = "send2")
	WebElement LoginButton;
	
	@FindBy(xpath = "//div[@id='advice-required-entry-email']")
	WebElement EmailAddressEmptyErrorMessage;
	
	@FindBy(xpath = "//div[@id='advice-validate-email-email']")
	WebElement EmailAddressInvalidErrorMessage;
	
	@FindBy(xpath = "//div[@id='advice-required-entry-pass']")
	WebElement PasswordAddressEmptyErrorMessage;
	
	@FindBy(xpath = "//div[@id='advice-validate-password-pass']")
	WebElement PasswordAddressInvalidErrorMessage;
	
	@FindBy(xpath = "//li[@class='error-msg']//span")
	WebElement EmailAddressIncorrectErrorMessage;
	
	
	

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, EmailAddressTextbox);
		sendkeyToElement(driver, EmailAddressTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, PasswordTextbox);
		sendkeyToElement(driver, PasswordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginButton);
		clickToElement(driver, LoginButton);
		
	}

	public Object getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, EmailAddressEmptyErrorMessage);
		return getTextElement(driver, EmailAddressEmptyErrorMessage);
	}

	public Object getPasswordAddressEmptyErrorMessage() {
		waitForElementVisible(driver,PasswordAddressEmptyErrorMessage);
		return getTextElement(driver,PasswordAddressEmptyErrorMessage);
	}


	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver,EmailAddressInvalidErrorMessage);
		return getTextElement(driver,EmailAddressInvalidErrorMessage);
	}

	public String getEmailAddressIncorrectErrorMessage() {
		waitForElementVisible(driver, EmailAddressIncorrectErrorMessage);
		return getTextElement(driver, EmailAddressIncorrectErrorMessage);
	}

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, PasswordAddressInvalidErrorMessage);
		return getTextElement(driver, PasswordAddressInvalidErrorMessage);
	}

	public String getPasswordIncorectErrorMessage() {
		waitForElementVisible(driver, EmailAddressIncorrectErrorMessage);
		return getTextElement(driver, EmailAddressIncorrectErrorMessage);
	}

}
