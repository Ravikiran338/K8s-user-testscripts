/**
 * @author Jp
 *
 */
package com.radiant.microservices.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JWebDriver {
	private static JWebDriver jWebDriver = null;
	WebDriver driver = null;

	// ==========================================================================

	private JWebDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		/*
		 * ProfilesIni profile = new ProfilesIni(); FirefoxProfile myProfile =
		 * profile.getProfile("profile1");
		 */
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		 * DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		 * capabilities.setCapability("marionette", true); WebDriver driver =
		 * new FirefoxDriver(capabilities);
		 */

		driver.manage().window().maximize();
	}

	// ==========================================================================

	public static synchronized JWebDriver getInstance() {
		if (jWebDriver == null) {
			jWebDriver = new JWebDriver();
		}
		return jWebDriver;
	}

	// ==========================================================================

	public WebDriver getWebDriver() {
		return driver;
	}

	// ==========================================================================
}
