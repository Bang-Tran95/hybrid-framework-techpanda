package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class ContactUsPageObject extends FooterContainerPageObject {
	
	WebDriver driver;
	
	public ContactUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
