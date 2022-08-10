package pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashBoardPageObject extends BasePageFactory {

	WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'Automation FC')]")
	WebElement ContactNamText;

	public boolean getContactNameTextDisplay(String contactInfor) {
		waitForElementVisible(driver, ContactNamText);
		String actualContactName = getTextElement(driver, ContactNamText);
		return actualContactName.contains(contactInfor);
	}


}
