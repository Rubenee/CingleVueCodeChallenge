package gmail.tests;

import org.junit.Assert;

import gmail.pageObjetcs.gmailPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class gmail extends gmailPage {
	
	@Before
	public void login() throws Exception{
		launchApp("http://www.gmail.com");
		enterUserName("cchallengeuser1");
		clickNext();
		enterPassword("cchallengepwd1");
		clickSignIn();
	}
	
	@Given("^I am logged into my gmail account$")
	public void isGmailInbox() throws Exception {
	    Assert.assertTrue(isInboxPage());
	}
	
	@When("^I click on compose button$")
	public void clickComposeButton() throws Exception {
	    clickCompose();
	}
	
	@When("^I compose a mail$")
	public void composeTheMail() throws Exception {
	    composeMail();
	}
	
	@When("^I close the mail$")
	public void closeMail() throws Exception {
	   clickClose();
	}
	
	@Then("^the mail should be saved in drafts$")
	public void isMailPresentInDrafts() throws Exception {
	    Assert.assertTrue(isMailSavedInDrafts());
	}
	
	
	@After
	public void SignOut() throws Exception{
		clickSignOut();
		Assert.assertTrue(isUserLoggedOut());
		webdriver.close();
	}
	

}
