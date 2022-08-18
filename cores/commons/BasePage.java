package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.navigation.FooterContainerPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageUIs.admin.AdminBasePageUI;
import pageUIs.jQuery.HomePageUI;

public class BasePage {

	public static BasePage getBasePageInsstance() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		waitForAlertPresence(driver).sendKeys(valueToSendkey);
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void switchToWindowByID(WebDriver driver, String expectedID) {
		Set<String> allTabIDs = driver.getWindowHandles();

		for (String id : allTabIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allTabIDs = driver.getWindowHandles();

		for (String id : allTabIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
	
	public String castRestParameter(String locator, String... dynamicLocator) {
		System.out.println("Locator trước khi input value:" + locator);
		locator = String.format(locator,(Object[]) dynamicLocator);
		System.out.println("Locator trước sau input value:" + locator);

		return locator;
	}

	// Locator này nhận tham số đầu vào là id/class/name/xpath/css
	// Quy ước convention của by locator là: id=/ class=/ name=/ xpath=/ css=
	// xử lí được việc viết không đồng bộ hoa thường: id=/ Id=/ iD=/ ID=
	private By getByLocator(String locator) {
		By by = null;
		if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
			by = By.id(locator.substring(3));
		} else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
			by = By.className(locator.substring(6));
		} else if (locator.startsWith("name=") || locator.startsWith("Name") || locator.startsWith("NAME=")) {
			by = By.name(locator.substring(5));
		} else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
			by = By.cssSelector(locator.substring(4));
		} else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=") || locator.startsWith("XPath=")) {
			by = By.xpath(locator.substring(6));
		} else {
			throw new RuntimeException("Locator Type is not valid");
		}
		return by;
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListElements(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... dynamicLocator) {
		getWebElement(driver, castRestParameter(locator, dynamicLocator)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToInput) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(valueToInput);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String valueToInput, String... dynamicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dynamicLocator));
		element.clear();
		element.sendKeys(valueToInput);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String...dynamicLocator) {
		return getWebElement(driver, castRestParameter(locator, dynamicLocator)).getText();
	}

	// 3Hàm cho Dropdow
	public void selectItemInDefaultDropdow(WebDriver driver, String locator, String itemText) {
		Select select = new Select(getWebElement(driver, locator));
		select.deselectByVisibleText(itemText);
	}
	
	public void selectItemInDefaultDropdow(WebDriver driver, String locator, String itemText, String...dynamicLocator) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, dynamicLocator)));
		select.deselectByVisibleText(itemText);
	}

	public String getFirstSelectedTextItem(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public Boolean isDropdowMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	// Hàm xử lí custom Dropdow
	public void selectItemInCustomDropdow(WebDriver driver, String parentXpath, String chilXpath,
			String expectedItemText) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);

		List<WebElement> chilItem = new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chilXpath)));

		// 4 - Duyệt qua từng item
		for (WebElement tempElement : chilItem) {
			if (tempElement.getText().trim().equals(expectedItemText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", tempElement);
				sleepInSecond(1);
				tempElement.click();
				sleepInSecond(1);
				break;

			}
		}
	}

	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName, String...dynamicLocator) {
		return getWebElement(driver, castRestParameter(locator, dynamicLocator)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}

	public Dimension getListElementSize(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getSize();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();

		}
	}

	public Boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public Boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicLocator) {
		return getWebElement(driver, castRestParameter(locator, dynamicLocator)).isDisplayed();
	}

	public Boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public Boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public void sleepInSecond(long timeInSecond) {

		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// User
	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String locator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, locator), getWebElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String...dynamicLocator) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(locator, dynamicLocator)), key).perform();
	}

	// JavaExcutor
	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashes;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator));
	}

	public void removeAttributeInDom(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (!status) {
			return true;
		} else
			return false;
	}

	// Wait
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String...dynamicLocator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicLocator))));
	}

	public void waitForElementInVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementInVisible(WebDriver driver, String locator, String...dynamicLocator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicLocator))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String...dynamicLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, dynamicLocator))));
	}
	
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
		//Đường dẫn đến thư mục upload file
		String uploadFilePath = GlobalConstants.UPLOAD_PATH;
		String fullFileName = "";
		
		for(String file : fileNames) {
			fullFileName = fullFileName + uploadFilePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
		
	}

	public FooterContainerPageObject getFooterContainerPage(WebDriver driver) {
		return new FooterContainerPageObject(driver);
	}

	public AdminLoginPageObject openAdminLoginPage(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return PageGeneratorManager.getAdminLoginPage(driver);

	}

	public UserHomePageObject openUserHomePage(WebDriver driver, String userUrl) {
		openPageUrl(driver, userUrl);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public AdminLoginPageObject clickToLogOutLink(WebDriver driver) {
		waitForElementVisible(driver, AdminBasePageUI.LOG_OUT_LINK);
		clickToElement(driver, AdminBasePageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	private long longTimeout = 30;

}
