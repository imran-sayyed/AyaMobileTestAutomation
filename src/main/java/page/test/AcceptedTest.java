package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;

public class AcceptedTest extends BasePageActions {

	BottomMenu menu;
	InboxPage inboxpage;
	MatchesPage matches;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inboxpage = new InboxPage();
		matches = new MatchesPage();
		
		System.out.println("The user type is " +BaseTest.UserType);
	}

	@Test(priority = 0, groups = "", description = "Navigate to AcceptedTab on Inbox Page ")
	public void navigateToAcceptedTab() throws Exception {
		SoftAssert sa = new SoftAssert();
		menu.ClickInbox();
		navigateToSpecifiedMatchesTab(inboxpage.acceptedTab, "Navigate to Inbox Accepted Tab");
		waitForElementToBeDisplayed(inboxpage.acceptedTabSubTitle, "wait for page to load", "");
		sa.assertTrue(inboxpage.acceptedTabSubTitle.getText().contains("Accepted Invitation") , "Accepted tab title text not present");
		sa.assertAll();
	}

	@Test(priority = 1, groups = "", description = "verify profile details on Accepted tab Listing")
	public void verifyProfileOnListingPage() throws Exception {
		SoftAssert sa = new SoftAssert();
		if (isDisplayedAfterWait(matches.closeUpgradeBanner, 2)) {
			matches.closeUpgradeBanner.click();
		}
		scrollDownToElement(inboxpage.profileCardName);
		sa.assertTrue(isDisplayedAfterWait(inboxpage.profileCardName, 3) , "Profile name not displayed on Accepted Tab listing");
		sa.assertTrue(isDisplayedAfterWait(inboxpage.tvEducationLocDetails, 3) , "Education and location details not displayed on Accepted tab Listing");
		sa.assertAll();

	}

	@Test(priority = 2, groups = "", description = "verify CTA on Accepted tab Listing")
	public void verifyCTAListingPage() throws Exception {
		SoftAssert sa = new SoftAssert();
		//sa.assertTrue(isDisplayedAfterWait(inboxpage.messageAcceptedProfileCard, 3),"Message Card is not seen for the User");
		matches.verifyCTAAFterConnect_DR();
		matches.verifyShaadiChatCTA();
		matches.verifyWhatsAppCTA();
		matches.verifyCallCTA();
		sa.assertAll();
	}

	@Test(priority = 3, groups = "", description = "verify successful navigation to profile page from  Accepted tab Listing")
	public void verifyNavigationToProfilePageFromListingPage() throws Exception {

		SoftAssert sa = new SoftAssert();
		Thread.sleep(100);
		scrollDownToElement(inboxpage.profileCardName);
		waitForElementToBeDisplayed(inboxpage.profileCardName, "Wait for profile name to be visible","");
		String name = inboxpage.profileCardName.getText().split(" ")[0];
		Thread.sleep(1000);
		inboxpage.profileCardName.click();
		waitForElementToBeDisplayed(inboxpage.NameonProfilePge, "Wait for profile page to load on Accepted Tab Listing", "");
		sa.assertEquals(name, inboxpage.NameonProfilePge.getText().split(" ")[0] , "Profile name on Listing page and profile page does not match");
		sa.assertAll();

	}

	@Test(priority = 4, description = "Verify user can initiate chat with Recent Visitor")
	public void initiateChat_AcceptedTab() throws InterruptedException {

		matches.initiateChatFromProfilePage();
	}

	@Test(priority = 5, description = "Verify user can view the conversation starter")
	public void viewConversationStarter_AcceptedTab() throws InterruptedException {

		matches.viewConversationStarterFromProfilePage();
	}

	@Test(priority = 6, description = "Verify CTA on profile page")
	public void viewTopCTAOnProfilePage() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			matches.verifyCTAAFterConnect_DR();
			matches.verifyShaadiChatCTA();
			matches.verifyWhatsAppCTA();
			matches.verifyCallCTA();
		} else {
			matches.verifyCTAAFterConnect_DR_iOS(false);
		}

	}

	@Test(priority = 7, description = "Verify CTA on profile page")
	public void viewBottomCTAOnProfilePage() throws InterruptedException {

		scrollDown();
		scrollDown();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			matches.verifyCTAAFterConnect_DR();
			matches.verifyShaadiChatCTA();
			matches.verifyWhatsAppCTA();
			matches.verifyCallCTA();
		} else {

			matches.verifyCTAAFterConnect_DR_iOS(true);
		}
	}
	
	
	@Test(priority = 8, description = "report a user from  profile page dropdowm")
	public void verifyReportProfileOnDropDown() throws InterruptedException {


		if(isDisplayedAfterWait(matches.dropdownArrow, 3)) {

			matches.reportUserFromProfilePage(matches.dropdownArrow);
		}
		else {
			matches.reportUserFromProfilePage(matches.dropDownThreeDots);

		}
		
	}

	@Test(priority = 9, description = "Decline a member from  profile page dropdowm")
	public void declineUserFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matches.dropdownArrow, 3)) {
		inboxpage.declineUserFromProfilePage(matches.dropdownArrow);
		}
		else {
			inboxpage.declineUserFromProfilePage(matches.dropDownThreeDots);

		}
	}

	@Test(priority = 10, description = "Cancel request from  profile page dropdowm")
	public void cancelRequestFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matches.dropdownArrow, 3)) {

		inboxpage.cancelRequestFromProfilePage(matches.dropdownArrow);
		}
		else {
			inboxpage.cancelRequestFromProfilePage(matches.dropDownThreeDots);

		}
	}

	
	
	@Test(priority = 11, description = "block a user from  profile page dropdowm")
	public void blockUserFromProfilePage() throws InterruptedException {
		if(isDisplayedAfterWait(matches.dropdownArrow, 3)) {

		matches.blockUserFromProfilePage(matches.dropdownArrow);
		}
		else {
			matches.blockUserFromProfilePage(matches.dropDownThreeDots);

		}
	}
	


	

}
