package org.cinglevue.automation.cucumber

import org.apache.log4j.Logger;

import cucumber.api.java.After;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.cinglevue.automation.pages.GmailInboxPage;
import org.cinglevue.automation.pages.GmailLoginPage;
import org.cinglevue.automation.pages.GmailSentMailPage;
import org.cinglevue.automation.selenium.BrowserInstance;
import org.cinglevue.automation.selenium.SeleniumCommandBase;
import org.junit.Assert;

import cucumber.api.java.After;

class StepDefinitions {

	/** The web browser. */
	private BrowserInstance browser;

	/** The test commands. */
	private SeleniumCommandBase caller;

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(BrowserInstance.class);

	@Given('^A new \"(.*)\" browser window is open$')
	public void selectBrowser(String browserType) {
		browser = new BrowserInstance(browserType);
		browser.maximize();
		caller = new SeleniumCommandBase(browser);
	}
	
	@When('^I open \"(.*)\" I must be navigated to the login page$')
	public void launchWebpage(String url) {
		caller.launch(url);
		caller.waitForElement(GmailLoginPage.userNameTextField);
	}

	@Then('^I login using username \"(.*)\" and password \"(.*)\" to gmail.$')
	public void login(String username, String password)  {
		caller.type(GmailLoginPage.userNameTextField, username);
		caller.type(GmailLoginPage.passwordTextField, password);
		caller.click(GmailLoginPage.signInButton);
		String actualValue = caller.getElementPropertyToString("textContent", GmailInboxPage.lnkUsername);
		if(!actualValue.equals(username)){
			logger.error("Verfication failiure. Expected value : " +username+ " differs from actual value :"+actualValue);
			Assert.fail("Verfication failiure. Expected value : " +username+ " differs from actual value :"+actualValue);
		}
	}

	@And('^I send an email to \"(.*)\" with subject \"(.*)\" and body contains \"(.*)\"$')
	public void sendEmail(String recepient, String subject, String body) {
		caller.click(GmailInboxPage.btnCompose);
		caller.waitForElement(GmailInboxPage.textFieldRecipient);
		caller.type(GmailInboxPage.textFieldRecipient, recepient);
		caller.type(GmailInboxPage.textFieldSubject,subject);
		caller.waitForElement(GmailInboxPage.textFieldMessageBody);
		caller.type(GmailInboxPage.textFieldMessageBody, body);
		caller.click(GmailInboxPage.btnSend);
	}

	@And ('^Coposed mail should be in the sent mail.$')
	public void verifySentMail(){
		caller.click(GmailInboxPage.btnSentMail);
		caller.click(GmailSentMailPage.sentMail);
		String actualValue = caller.getElementPropertyToString("email", GmailSentMailPage.recipientMail);
		if(!"sendayt@gmail.com".equals(actualValue)){
			logger.error("Verfication failiure. Expected value : 'sendayt@gmail.com' differs from actual value :"+actualValue);
			Assert.fail("Verfication failiure. Expected value : 'sendayt@gmail.com' differs from actual value :"+actualValue);
		}
	}

	@Then('^I log out from the gmail.$')
	public void logout()  {
		caller.click(GmailInboxPage.btnAccount);
		caller.click(GmailInboxPage.lnkSignOut);
	}

	/**
	 * Executes after each scenario.
	 */
	@After
	public void afterScenario(){

		browser.quit();
	}
}
