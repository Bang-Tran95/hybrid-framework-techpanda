package pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Cách định nghĩa 1 element(1)
	@FindBy(xpath = "//div[@class='footer']//a[@title='My Account']")
	WebElement myAccountLink;

	// Cách định nghĩa 1 element (2)
//	@FindBy(how = How.XPATH, using = "//div[@class='footer']//a[@title='My Account']")
//	List<WebElement> footerLinks;

	public void clickTToMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);

	}

}
