/**
 * @author Jp
 *
 */
package com.radiant.microservices.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

public class JWebDriver {
	private static JWebDriver jWebDriver = null;
	WebDriver driver = null;

	// ==========================================================================

	private JWebDriver() {
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		String Xport = System.getProperty("lmportal.xvfb.id", ":1");
        //final File firefoxPath = new File(System.getProperty("lmportal.deploy.firefox.path", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        //FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
        Map<String, String> environment = new HashMap();
        environment.put("DISPLAY", Xport);
        GeckoDriverService service = new GeckoDriverService.Builder()        		
        		 .usingDriverExecutable(new File(System.getProperty("user.dir") + "\\Drivers\\geckodriver"))
     	        .usingAnyFreePort().withEnvironment(environment).build();
        //FirefoxOptions option=new FirefoxOptions();
        //option.setBinary(firefoxBinary);
        driver = new FirefoxDriver(service);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		
        //System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        //driver = new ChromeDriver();
        //driver = new PhantomJSDriver();

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
