package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	protected final Log log;

	public BaseTest() {

		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			// Latest browser driver version
			driver = WebDriverManager.firefoxdriver().create();

			// Specific browser driver version (99) ~ browser version (99)
			// WebDriverManager.firefoxdriver().driverVersion("99.0.444.9").setup();

			// Base on: Version
			// WebDriverManager.firefoxdriver().browserVersion("99.109.22.109").setup();

			break;

		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;

		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;

		default:
			throw new RuntimeException("Browser nam is not valid!");

		}

		driver.get("http://live.techpanda.org");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName, String urlValue) {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case FIREFOX:
			// Latest browser driver version
			driver = WebDriverManager.firefoxdriver().create();
			break;

		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;

		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;

		default:
			throw new RuntimeException("Browser nam is not valid!");

		}

		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;

	}

	protected int getrandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("----------------------------Passed-------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("----------------------------Failed-------------------------");
		}
		return status;
	}

	protected boolean verifyFlase(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("----------------------------Passed-------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("----------------------------Failed-------------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("----------------------------Passed-------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("----------------------------Failed-------------------------");
		}
		return status;
	}
}
