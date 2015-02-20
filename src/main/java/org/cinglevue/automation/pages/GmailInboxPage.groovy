package org.cinglevue.automation.pages

import org.openqa.selenium.By;

class GmailInboxPage {
	
	
	/** The locator of the logged user name link */
	public static By lnkUsername = By.cssSelector("a[title='Account automationcodechallenge@gmail.com']");
	
	/** The locator of the compose button. */
	public static By btnCompose = By.xpath("//div[text()='COMPOSE']");
	
	/** The locator of the Recipient text field. */
	public static By textFieldRecipient = By.cssSelector("textarea[name='to']");
	
	/** The locator of the Subject text field. */
	public static By textFieldSubject = By.cssSelector("input[name='subjectbox']");
	
	/** The locator of the message body text field. */
	public static By textFieldMessageBody = By.cssSelector("div[aria-label='Message Body']");
	
	/** The locator of the button send. */
	public static By btnSend = By.xpath("//div[text()='Send']");
	
	/** The locator of the button sent mail. */
	public static By btnSentMail = By.linkText("Sent Mail");
	
	/** The locator of the button account. */
	public static By btnAccount = By.cssSelector("span[class='gb_da']");
	
	/** The locator of the button log out. */
	public static By lnkSignOut = By.linkText("Sign out");

}
