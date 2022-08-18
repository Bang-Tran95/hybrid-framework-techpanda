package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_12_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;


	@Parameters({ "browser", "Url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomepage(driver);

	}

	
	public void TC_01_Handle_Textbox() {
		homePage.enterToTextboxByHeaderName("Country","Angola");
		Assert.assertTrue(homePage.isRowValueDisplays("276880","Angola","276472","553353"));
		homePage.refreshCurentPage(driver);
		
		homePage.enterToTextboxByHeaderName("Total","49397");
		Assert.assertTrue(homePage.isRowValueDisplays("24128","Albania","25266","49397"));
		homePage.refreshCurentPage(driver);

		homePage.enterToTextboxByHeaderName("Females","338282");
		Assert.assertTrue(homePage.isRowValueDisplays("338282","Argentina","349238","687522"));
		homePage.refreshCurentPage(driver);
		
		


	}

	
	public void TC_02() {
		
		homePage.clickToActionIconByCountryName("Angola","remove");
		homePage.clickToActionIconByCountryName("Afghanistan","remove");
		
		homePage.refreshCurentPage(driver);
		homePage.clickToActionIconByCountryName("Angola","edit");
		
	}

	@Test
	public void TC_03_Open_Any_Page() {
		
		homePage.clickToPageByNumber("13");
		Assert.assertTrue(homePage.isPageNumberActived("13"));
		
		homePage.clickToPageByNumber("5");
		Assert.assertTrue(homePage.isPageNumberActived("5"));

		
		homePage.clickToPageByNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}