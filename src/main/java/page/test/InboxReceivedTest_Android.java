package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;

public class InboxReceivedTest_Android extends BasePageActions {

	BottomMenu menu;
	InboxPage inboxpage;
	MatchesPage matches;
	public static int invite_Count;


	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inboxpage = new InboxPage();
		matches = new MatchesPage();
	}

	@Test(priority = 0, groups = "", description = "Navigate to Received Tab on Inbox Page ")
	public void navigateToReceivedTab() throws Exception {
		SoftAssert sa = new SoftAssert();
		menu.ClickInbox();
		Thread.sleep(1000);
		driver.navigate().back();
		navigateToSpecifiedMatchesTab(inboxpage.receivedTab, "Navigate to Received Tab");
		if(isDisplayedAfterWait(inboxpage.receivedQRCloseButton, 10)) {
			inboxpage.receivedQRCloseButton.click();
		}
	//	wait_for_element_displayed(inboxpage.acceptedTabSubTitle, "wait for Accepted page to load", "");
		sa.assertAll();
	}

	@Test(priority = 1, groups = "", description = "verify profile details on Accepted tab Listing")
	public void verifyProfileOnListingPage() throws Exception {
		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inboxpage.profileCardName);
		sa.assertTrue(isDisplayedAfterWait(inboxpage.profileCardName, 3) , "Profile name is not present on Accepted Listing");
		sa.assertTrue(isDisplayedAfterWait(inboxpage.tvEducationLocDetails, 3) , "Education and location details not present on Accepted listing");
		sa.assertAll();

	}

	@Test(priority = 2, groups = "", description = "verify filter options in received Tab")
	public void verifyFilterOptionsOnListingPage() throws Exception {

		inboxpage.verifyFilterOptionsReceivedTab("Premium");
		inboxpage.verifyFilterOptionsReceivedTab("Matching Preferences");
		inboxpage.verifyFilterOptionsReceivedTab("Expiring Soon");
		inboxpage.verifyFilterOptionsReceivedTab("Filtered Out");
		inboxpage.verifyFilterOptionsReceivedTab("All Invitations");

	}

	@Test(priority = 3, groups = "", description = "verify Accept on listing page in received Tab")
	public void verifyAcceptFromListingPage() throws Exception {

		inboxpage.verifyAcceptOnReceivedListing(matches , "Premium");

	}

	@Test(priority = 4, groups = "", description = "verify Decline on listing page in received Tab")
	public void verifyDeclineFromListingPage() throws Exception {

		inboxpage.verifyDeclineOnReceivedListing();
	}

	@Test(priority = 5, groups = "", description = "verify successful navigation to profile page from  Deleted tab Listing")
	public void verifyNavigationToProfilePageFromListingPage() throws Exception {


		inboxpage.navigateToProfilePageFromListing();

	}

	@Test(priority = 6, groups = "", description = "verify Top Accept from profile page")
	public void verifyAcceptFromTopOfProfilePage() throws Exception {

		inboxpage.verifyAcceptFromProfilePage("Top", matches);

	}

	@Test(priority = 7, groups = "", description = "verify Bottom Accept from profile page")
	public void verifyAcceptFromBottomOfProfilePage() throws Exception {

	
		inboxpage.verifyAcceptFromProfilePage("Bottom", matches);

	}

	@Test(priority = 8, groups = "", description = "verify Top Decline from profile page")
	public void verifyDeclineFromTopOfProfilePage() throws Exception {

		inboxpage.verifyDeclineFromProfilePage("Top", matches);

	}

	@Test(priority = 9, groups = "", description = "verify Bottom Decline from profile page")
	public void verifyDeclineFromBottomOfProfilePage() throws Exception {

		inboxpage.verifyDeclineFromProfilePage("Bottom", matches);	
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test(priority = 10, groups = "", description = "verify Member can Accept Filtered Out Profiles")
	public void verifyAcceptForFilteredOutProfile() throws Exception {

		while(!isDisplayedAfterWait(inboxpage.receivedTab, 3)) {
			driver.navigate().back();

		}
		
		scrollUpToElement(inboxpage.QuickPhaseBtn);
		inboxpage.verifyFilterOptionsReceivedTab("Filtered Out");
		if (isDisplayedAfterWait(inboxpage.RcvdUserName, 3)) {

			inboxpage.verifyAcceptOnReceivedListing(matches , "Filtered");

		}

	}

	@Test(priority = 11, groups = "", description = "verify Member can Decline Filtered Out Profiles")
	public void verifyDeclineForFilteredOutProfile() throws Exception {

		inboxpage.verifyFilterOptionsReceivedTab("Filtered Out");
		if (isDisplayedAfterWait(inboxpage.RcvdUserName, 3)) {

			inboxpage.verifyDeclineOnReceivedListing();

		}

	}
	
	@Test(priority = 12, groups = "", description = "verify Member can Decline Filtered Out Profiles")
	public void verifyNavigationToQRFromReceivedListing() throws Exception {
		
		
		inboxpage.verifyFilterOptionsReceivedTab("All Invitations");
		waitForElementToBeDisplayed(inboxpage.QuickPhaseBtn, "Wait for Quick response button", "");
		inboxpage.QuickPhaseBtn.click();
		waitForElementToBeDisplayed(inboxpage.lbl_Member_Waiting, "Wait for QR page to load", "");
		
		

		
	}

	@Test(priority = 13, groups = "" , description = "click Decline On Stack")
	public void clickDeclineOnStk() throws InterruptedException {
		invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.checkDeclineOnStack_Received(invite_Count);
	}

	@Test(priority = 14, groups = "", description = "click Accept On Stack")
	public void clickAcceptOnStk() throws InterruptedException {
		invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.checkAcceptOnStack_Received(invite_Count);
	}

	@Test(priority = 15, groups = "", description = "verify decline from swiping left")
	public void swipeForDecline() throws InterruptedException {
		invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.swipeToDecline_Received(invite_Count);
	}

	@Test(priority = 16, groups = "" , description = "verify accept from swiping right")
	public void swipeForAccept() throws InterruptedException {
		invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.swipeToAcceptReceived(invite_Count);
	}


	
	
}
