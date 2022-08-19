package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxByHeaderName(String headerName, String value) {

		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
	}

	public boolean isRowValueDisplays(String femalesValue, String contryNameValue, String maleValue,
			String totalValue) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, femalesValue, contryNameValue, maleValue, totalValue);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, femalesValue, contryNameValue, maleValue, totalValue);
	}

	public void clickToActionIconByCountryName(String countryName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, countryName, actionName);
	}

	public void clickToPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_ACTIVE_BY_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_ACTIVE_BY_PAGE_NUMBER, pageNumber);
	}

	//Upload File
	public boolean isFileNameLoadedSuccess(String fileName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.IMAGE_FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtonElements = getListElements(driver, HomePageUI.START_BUTTON);
		
		for (WebElement startButton: startButtonElements) {
			waitForElementClickable(driver, startButton);
			startButton.click();
			sleepInSecond(2);
			
		}
	}

	public boolean isFileUploadedSuccess(String fileName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.IMAGE_FILE_NAME_UPLOADED, fileName);
	}

}
