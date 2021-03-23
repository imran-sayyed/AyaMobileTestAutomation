package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;

public class SentTest extends BasePageActions {

	BottomMenu menu;
	InboxPage inboxpage;
	MatchesPage matchespage;
	public static boolean sentTestFlag = false;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inboxpage = new InboxPage();
		matchespage = new MatchesPage();
	}

	@Test(priority = 0, description = "Verify Landing on Sent tab when clicked on it")
	public void verifyLandingOnSentTab() throws Exception {

		menu.ClickInbox();
		inboxpage.ClickSentTab();
	}

	@Test(priority = 1, description = "Send a connect via Matches screen and then verify CTA of that user on Sent tab")
	public void verifyConnectSentInSentTab() throws Exception {

		SoftAssert sa = new SoftAssert();
		String nameBefore = "";
		menu.clickOnMatches();
		BasePageActions.navigateToSpecifiedMatchesTab(matchespage.myMatchesTab, "Navigate to My Matches tab");
		waitForSometime(2000);

		if (UserType.contains("premium")) {
			scrollDownToElement(inboxpage.connectNowButtonListingAndroid);
			waitForElementToBeDisplayed(inboxpage.myMatchesMemberName_Premium, "Wait for My Matches page to load", "");
			nameBefore = getText(inboxpage.myMatchesMemberName, "Get member name on My matches").split(" ")[0];
			click(inboxpage.connectNowButtonListingAndroid, "Click on Connect Now", "");
			matchespage.sendMessageOnConnectPremium();

		} else {
			scrollDownToElement(inboxpage.myMatchesConnectButtonAndroid);
			waitForElementToBeDisplayed(inboxpage.myMatchesMemberName, "Wait for My Matches page to load", "");
			nameBefore = getText(inboxpage.myMatchesMemberName, "Get member name on My matches").split(" ")[0];
			click(inboxpage.myMatchesConnectButtonAndroid, "Click on Connect Now", "");
		}

		menu.ClickInbox();
		inboxpage.ClickSentTab();
		Thread.sleep(1000);
		scrollUp();
		scrollUp();
		waitForElementToBeDisplayed(inboxpage.tvName, "Wait for Sent Tab to laod", "");
		String nameAfter = getText(inboxpage.tvName, "Get member name on Inbox Sent tab").split(" ")[0];
		if(nameAfter.equalsIgnoreCase(nameBefore)) {
			sa.assertEquals(nameAfter, nameBefore, "Member name in Inbox sent tab doesn't match");

		}
		else {
			waitForSometime(90000);
			scrollUp();
			scrollUp();
			waitForElementToBeDisplayed(inboxpage.tvName, "", "");
			nameAfter = getText(inboxpage.tvName, "Get member name on Inbox Sent tab").split(" ")[0];
			sa.assertEquals(nameAfter, nameBefore, "Member name in Inbox sent tab doesn't match");
		}


		sa.assertAll();
	}

	@Test(priority = 2, groups = "", description = "verify profile details on Sent tab Listing")
	public void verifyProfileOnListingPage() throws Exception {
		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inboxpage.profileCardName);
		sa.assertTrue(isDisplayedAfterWait(inboxpage.profileCardName, 3) , "Profile name not present on listing");
		sa.assertTrue(isDisplayedAfterWait(inboxpage.tvEducationLocDetails, 3) , "Education and location details not present on listing page");
		sa.assertAll();

	}

	
	@Test(priority = 3, groups = "", description = "verify CTA on Sent tab Listing")
	public void verifyCTAOnListingPage() throws Exception {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(1000);
		if (BaseTest.UserType.contains("free")) {
		scrollDownToElement(inboxpage.btn_Cancel);
		//Assert the visibilty of CTA on listing page
		sa.assertTrue(isDisplayedAfterWait(inboxpage.messageAcceptedProfileCard, 3),
				"Accepted profile card not  seen");
		sa.assertTrue(isDisplayedAfterWait(inboxpage.btn_Cancel, 3));
		sa.assertTrue(isDisplayedAfterWait(inboxpage.btn_Remind, 3));
		
		//Verify action on CTA
		click(inboxpage.btn_Remind, "Click on Remind button on Listing page", "");
		waitForElementToBeDisplayed(inboxpage.RemindToolTip, "Wait for remind tool tip", "");
		AssertEquals(inboxpage.RemindToolTip, "Visit again after 24 hours to send a Reminder.", "Assert remind tool tip text");
		Thread.sleep(1500);
		driver.navigate().back();
		click(inboxpage.btn_Cancel, "Click on cancel button on Listing page", "");
		waitForElementToBeDisplayed(inboxpage.connectNowButtonAndroid, "Wait for Connect now button after clicking on cancel request", "");
		sa.assertEquals(getText(inboxpage.deletedMessageAndroid, "Get Cancelled Invitation text"),
				"You Cancelled your Invitation.", "Cancelled Invitation text doesn't match");
			
		
		}
		
		else {
			
			scrollDownToElement(matchespage.ShaadiChatCTA);
			sa.assertTrue(isDisplayedAfterWait(inboxpage.messageAcceptedProfileCard, 3),
					"Accepted profile card not  seen");
			matchespage.verifyShaadiChatCTA();
			matchespage.verifyWhatsAppCTA();
			matchespage.verifyCallCTA();
		}
		
		
		
		sa.assertAll();
	}

	@Test(priority = 4, groups = "", description = "verify filter options in Sent Tab")
	public void verifyFilterOptionsOnListingPage() throws Exception {

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollUpToElement(inboxpage.btnFilter);
			Thread.sleep(1000);
			inboxpage.verifyFilterOptionsReceivedTab("Viewed by");
			inboxpage.verifyFilterOptionsReceivedTab("Not Viewed by");
			inboxpage.verifyFilterOptionsReceivedTab("All Invitations");
		} else {
			inboxpage.verifyFilterOptionsReceivedTabIOS(inboxpage.btnViewed_by_Him);
			inboxpage.verifyFilterOptionsReceivedTabIOS(inboxpage.btnNot_Viewed_by_Him);
			inboxpage.verifyFilterOptionsReceivedTabIOS(inboxpage.btnAllInvitations);
			Thread.sleep(2000);

		}

	}

	@Test(priority = 5, groups = "", description = "verify Remind and Cancel request present in dropdown options on listing page")
	public void verifyDropDownOnListingPage() throws InterruptedException {

		// changes added to verify dropdownoption for iOS
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			inboxpage.verifyDropDownOnSentTabAndroidListing();
		}

		else {
			inboxpage.verifyDropDownOnSentTabIOSListing();
		}

	}

	@Test(priority = 6, description = "Verify Remind CTA on listing; Verify tool tip text when clicked on Remind CTA", enabled = false)
	public void verifyRemindCTAOnSentListing() throws InterruptedException {
		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
			Thread.sleep(2000);
			inboxpage.verifyRemindSentTab();
		}
	}

	@Test(priority = 7, description = "Verify Cancel CTA from Dropdown options on Sent listing")
	public void verifyCancelCTAOnSentListing() throws Exception {
		scrollUp();
		Thread.sleep(1000);
		scrollUp();
		inboxpage.verifyCancelRequestSentTab(matchespage);

	}

	@Test(priority = 8, groups = "", description = "verify successful navigation to profile page from  Sent tab Listing")
	public void verifyNavigationToProfilePageFromListingPage() throws Exception {

		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inboxpage.profileCardName);
		Thread.sleep(1000);
		String name = inboxpage.profileCardName.getText().split(" ")[0];
		inboxpage.profileCardName.click();
		waitForElementToBeDisplayed(matchespage.UserName, "Wait for profile page", "");
		sa.assertEquals(name, matchespage.UserName.getText().split(" ")[0] , "Profile name does not match on listing and profile page");
		click(inboxpage.SwipeNext, "Go to next profile", "");
		sa.assertAll();

	}

	@Test(priority = 9, description = "Verify user can initiate chat with Recent Visitor")
	public void initiateChat_AcceptedTab() throws InterruptedException {

		matchespage.initiateChatFromProfilePage();
	}

	@Test(priority = 10, description = "Verify user can view the conversation starter")
	public void viewConversationStarter_AcceptedTab() throws InterruptedException {

		matchespage.viewConversationStarterFromProfilePage();
	}

	@Test(priority = 11, description = "Verify CTA on profile page")
	public void viewTopCTAOnProfilePage() throws InterruptedException {

		// added while loop since filtered out profile does not have CTA on
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			while (!isDisplayedAfterWait(matchespage.ShaadiChatCTA, 3)) {
				Thread.sleep(1000);
				matchespage.SwipeNext.click();

			}
			matchespage.verifyCTAAFterConnect_DR();
			matchespage.verifyShaadiChatCTA();
			matchespage.verifyWhatsAppCTA();
			matchespage.verifyCallCTA();
		} else {

			while (!isDisplayedAfterWait(matchespage.WhatsappCTA_OnProfile, 3)) {
				Thread.sleep(1000);
				matchespage.SwipeNext.click();

			}
			matchespage.verifyCTAAFterConnect_DR_iOS(false);
		}

	}

	@Test(priority = 12, description = "Verify CTA on profile page")
	public void viewBottomCTAOnProfilePage() throws InterruptedException {

		scrollDown();
		scrollDown();

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			matchespage.verifyCTAAFterConnect_DR();
			matchespage.verifyShaadiChatCTA();
			matchespage.verifyWhatsAppCTA();
			matchespage.verifyCallCTA();
		} else {

			matchespage.verifyCTAAFterConnect_DR_iOS(true);
		}

	}

	@Test(priority = 13, description = "Remind from  profile page dropdowm", enabled = false)
	public void remindFromProfilePage() throws InterruptedException {
		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			scrollUpToElement(matchespage.SwipeNext);
			Thread.sleep(2000);
			if (chckElementPresent(matchespage.dropdownArrow)) {

				inboxpage.remindFromProfilePage(matchespage.dropdownArrow);
			} else {
				inboxpage.remindFromProfilePage(matchespage.dropDownThreeDots);

			}
		}

	}

	@Test(priority = 14, description = "report a user from  profile page dropdowm", enabled = false)
	public void verifyReportProfileOnDropDown() throws InterruptedException {


		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.reportUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.reportUserFromProfilePage(matchespage.dropDownThreeDots);

		}
		
	}

	@Test(priority = 15, description = "block a user from  profile page dropdowm" , enabled = false)
	public void blockUserFromProfilePage() throws InterruptedException {

		if (chckElementPresent(matchespage.dropdownArrow)) {

			matchespage.blockUserFromProfilePage(matchespage.dropdownArrow);
		} else {
			matchespage.blockUserFromProfilePage(matchespage.dropDownThreeDots);

		}

	}

	@Test(priority = 16, description = "Cancel request from  profile page dropdowm")
	public void cancelRequestFromProfilePage() throws InterruptedException {

		if (chckElementPresent(matchespage.dropdownArrow)) {

			inboxpage.cancelRequestFromProfilePage(matchespage.dropdownArrow);
		} else {
			inboxpage.cancelRequestFromProfilePage(matchespage.dropDownThreeDots);

		}
	}

}
