package com.techpanda.account;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_I {
	WebDriver driver;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		basePage = new BasePage();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {

		basePage.openPageUrl(driver, "http://live.techpanda.org/");
		basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");

		basePage.sendkeyToElement(driver, "//input[@id='email']", "");
		basePage.sendkeyToElement(driver, "//input[@id='pass']", "");
		basePage.clickToElement(driver, "//button[@id='send2']");

		assertEquals(basePage.getTextElement(driver, "//div[@id='advice-required-entry-email']"),
				"This is a required field.");
		assertEquals(basePage.getTextElement(driver, "//div[@id='advice-required-entry-pass']"),
				"This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		basePage.openPageUrl(driver, "http://live.techpanda.org/");
		basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");

		basePage.sendkeyToElement(driver, "//input[@id='email']", "123@456.789");
		basePage.sendkeyToElement(driver, "//input[@id='pass']", "123456");
		basePage.clickToElement(driver, "//button[@id='send2']");

		assertEquals(basePage.getTextElement(driver, "//div[@id='advice-validate-email-email']"),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail() {
		basePage.openPageUrl(driver, "http://live.techpanda.org/");
		basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");

		basePage.sendkeyToElement(driver, "//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
		basePage.sendkeyToElement(driver, "//input[@id='pass']", "123456");
		basePage.clickToElement(driver, "//button[@id='send2']");

		assertEquals(basePage.getTextElement(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");

	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword() {
		basePage.openPageUrl(driver, "http://live.techpanda.org/");
		basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");

		basePage.sendkeyToElement(driver, "//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
		basePage.sendkeyToElement(driver, "//input[@id='pass']", "123");
		basePage.clickToElement(driver, "//button[@id='send2']");

		assertEquals(basePage.getTextElement(driver, "//div[@id='advice-validate-password-pass']"),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		basePage.openPageUrl(driver, "http://live.techpanda.org/");
		basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");

		basePage.sendkeyToElement(driver, "//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
		basePage.sendkeyToElement(driver, "//input[@id='pass']", randomNumber() + "");
		basePage.clickToElement(driver, "//button[@id='send2']");

		assertEquals(basePage.getTextElement(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");

	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		basePage.openPageUrl(driver, "http://live.techpanda.org/");
		basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");

		basePage.sendkeyToElement(driver, "//input[@id='email']", "automationfc.vn@gmail.com");
		basePage.sendkeyToElement(driver, "//input[@id='pass']", "123123");
		basePage.clickToElement(driver, "//button[@id='send2']");

		assertTrue(basePage.isElementDisplayed(driver,
				"//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'Automation FC')]"));
		assertTrue(basePage.isElementDisplayed(driver,
				"//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'automationfc.vn@gmail.com')]"));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}