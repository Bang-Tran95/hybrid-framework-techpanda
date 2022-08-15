package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

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
}
