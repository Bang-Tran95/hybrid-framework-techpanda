package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.AboutUsPageObject;
import pageObjects.user.ContactUsPageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.SearchTermsPageObject;
import pageUIs.navigation.FooterContainerPageUI;

public class FooterContainerPageObject extends BasePage {
	
	WebDriver  driver;
	
	public FooterContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public AboutUsPageObject openAboutUsPage() {
		waitForElementVisible(driver, FooterContainerPageUI.ABOUT_US_LINK);
		clickToElement(driver, FooterContainerPageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}
	
	public ContactUsPageObject openContactUsPage() {
		waitForElementVisible(driver, FooterContainerPageUI.CONTACT_US_LINK);
		clickToElement(driver, FooterContainerPageUI.CONTACT_US_LINK);
		return PageGeneratorManager.getContactUsPage(driver);
	}
	
	public SearchTermsPageObject openSearchTermsPage() {
		waitForElementVisible(driver, FooterContainerPageUI.SEARCH_TERMS_LINK);
		clickToElement(driver, FooterContainerPageUI.SEARCH_TERMS_LINK);
		return PageGeneratorManager.getSearchTermsPage(driver);
	}
	
	public MyAccountPageObject openMyAccountPage() {
		waitForElementVisible(driver, FooterContainerPageUI.SEARCH_TERMS_LINK);
		clickToElement(driver, FooterContainerPageUI.SEARCH_TERMS_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	

}
