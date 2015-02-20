package org.cinglevue.automation.selenium

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver

class BrowserInstance {


	/** The web driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new web browser.
	 *
	 * @param browser the browser type
	 */
	public BrowserInstance(String browser) {

		if ("Firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Illegal argument passed. Unable to create an instance of " + browser + " as a webdriver instance.");
		}
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Sets the driver.
	 *
	 * @param driver
	 *            the new web driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Maximize the browser.
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * Quit the browser instance.
	 */
	public void quit() {
		driver.quit();
	}
}
