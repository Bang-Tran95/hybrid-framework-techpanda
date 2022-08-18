package com.jquery.upload;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_13_Upload_File extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	String seleniumImage = "Selenium.png";
	String appiumImage = "Appium.png";
	String apiImage = "API.png";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomepage(driver);

	}

	@Test
	public void TC_01_One_File() {
		homePage.uploadMultipleFiles(driver, seleniumImage);

		Assert.assertTrue(homePage.isFileNameLoadedSuccess(seleniumImage));
		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadedSuccess(seleniumImage));

	}
	@Test
	public void TC_02_Multiple_File() {
		
		homePage.refreshCurentPage(driver);

		homePage.uploadMultipleFiles(driver, seleniumImage);

		Assert.assertTrue(homePage.isFileNameLoadedSuccess(seleniumImage));
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(appiumImage));
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(appiumImage));
		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadedSuccess(seleniumImage));
		Assert.assertTrue(homePage.isFileUploadedSuccess(appiumImage));
		Assert.assertTrue(homePage.isFileUploadedSuccess(appiumImage));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}