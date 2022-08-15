package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.SideBarMyAccountPageObject;

public class MyOrdersPageObject extends SideBarMyAccountPageObject {
	
	WebDriver driver;
	
	public MyOrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}


}
