package org.cinglevue.automation.selenium

import org.apache.bcel.generic.RETURN;
import org.apache.log4j.Logger;
import org.cinglevue.automation.utils.PropertyFileReader;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class SeleniumCommandBase {

	/** The web driver. */
	private WebDriver driver;

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(SeleniumCommandBase.class);

	/** The time out. */
	private int timeOut;

	/**
	 * Instantiates a new Selenium commands.
	 *
	 * @param browser the browser
	 */
	public SeleniumCommandBase (BrowserInstance browser) {
		this.driver = browser.getDriver();
		init();
	}

	/**
	 * Initializes the execution parameters.
	 */
	private void init() {

		PropertyFileReader handler = new PropertyFileReader("/execution.properties");
		String timeout = handler.getProperty("TIMEOUT");
		this.timeOut = Integer.parseInt(timeout);
	}

	/**
	 * Find element in the web page.
	 *
	 * @param byLocator the by locator
	 * @return the web element
	 */
	private WebElement findElement(By byLocator) {

		WebElement element = (new WebDriverWait(driver, timeOut))
				.until(ExpectedConditions.presenceOfElementLocated(byLocator));

		return element;
	}

	/**
	 * Wait for element in the web page.
	 *
	 * @param byLocator the by locator
	 */
	public void waitForElement(By byLocator) {

		findElement(byLocator);
		logger.info("Wait for web element " + byLocator + " to present.");
	}

	/**
	 * Launch the given url.
	 *
	 * @param url the url
	 */
	public void launch(String url) {

		try {
			driver.navigate().to(url);
			logger.info("Launch the URL " + url + " successfully.");
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * Type on a web element.
	 *
	 * @param byLocator the by locator
	 * @param text the text
	 */
	public void type(By byLocator, String text) {

		try{
			WebElement element = findElement(byLocator);
			element.sendKeys(text);
			logger.info("Typed the value " + text + " in to object " + byLocator);
		} catch (Exception e){
			logger.error(e);
		}
	}


	/**
	 * Click on a web element.
	 *
	 * @param byLocator the by locator
	 * 
	 */
	public void click(By byLocator) {
		try{
			WebElement element = findElement(byLocator);
			element.click();
			logger.info("Clicked on the object" + byLocator);
		} catch (Exception e){
			logger.error(e);
		}
	}

	/**
	 * get specific property value of a web element and stores to string variable.
	 *
	 * @param byLocator the by locator
	 * @param property the property of the element.
	 *
	 *@return value of the property.
	 */

	public String getElementPropertyToString(String property, By byLocator){
		try{
			WebElement element = findElement(byLocator);
			String propertyValue = element.getAttribute(property);
			logger.info("Stored the property value of the object "+ byLocator + " property :" + property + "value : "+propertyValue);
			return propertyValue;
		} catch (Exception e){
			logger.error(e);
		}
	}
}
