package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.AccountInformationPageUI;

public class AccountInformationPageObject extends BasePage {
	
	WebDriver driver;
	
	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, AccountInformationPageUI.FIRST_NAME_TEXBOX);
		sendkeyToElement(driver, AccountInformationPageUI.FIRST_NAME_TEXBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX, lastname);
		
	}

	public void inputToEmailAddressTextbox(String emailaddress) {
		waitForElementVisible(driver, AccountInformationPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.EMAIL_ADDRESS_TEXTBOX, emailaddress);
		
	}

	public void inputCurentPasswordTextbox(String curentpassword) {
		waitForElementVisible(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX, curentpassword);
		
	}

	public MyDashBoardPageObject clickToSaveButton() {
		waitForElementVisible(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX);
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getMyDashBoardPage(driver);
	}

}

