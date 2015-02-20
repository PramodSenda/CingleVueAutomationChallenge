@search
Feature: Compose an email and verify the sent mail.

  Scenario: Verify sent mail.
    Given A new "Firefox" browser window is open
    When I open "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1" I must be navigated to the login page
    Then I login using username "automationcodechallenge@gmail.com" and password "1qaz2wsx@" to gmail.
    And I send an email to "sendayt@gmail.com" with subject "Automation Challenge" and body contains "This is a test mail"
 	And Coposed mail should be in the sent mail.
 	Then I log out from the gmail.