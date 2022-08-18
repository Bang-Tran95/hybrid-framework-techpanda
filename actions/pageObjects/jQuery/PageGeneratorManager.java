package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomepage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	
}
