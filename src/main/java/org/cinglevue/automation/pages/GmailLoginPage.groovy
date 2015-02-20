package org.cinglevue.automation.pages

import org.openqa.selenium.By;

class GmailLoginPage {

	/** The user name text field locator. */
	public static By userNameTextField = By.cssSelector("input[id='Email']");
	
	/** The Password text field locator. */
	public static By passwordTextField = By.cssSelector("input[id='Passwd']");
	
	/** The sign in button locator. */
	public static By signInButton = By.cssSelector("input[id='signIn']");
}
