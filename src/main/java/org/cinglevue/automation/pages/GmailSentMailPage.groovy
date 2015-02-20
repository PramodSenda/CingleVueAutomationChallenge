package org.cinglevue.automation.pages

import org.openqa.selenium.By;

class GmailSentMailPage {
	
	/** The locator of the sent mail. */
	public static By sentMail = By.xpath("//span[text()='Automation Challenge']");
	
	/** The locator of the recipient mail address inside the sent mail. */
	public static By recipientMail = By.xpath("//span[@name='Pramod']");

}
