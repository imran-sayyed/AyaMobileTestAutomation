package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;

public class DeletedTest_New extends BasePageActions {

	BottomMenu menu;
	InboxPage inboxpage;
	MatchesPage matches;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inboxpage = new InboxPage();
		matches = new MatchesPage();

	}

	@Test(priority = 0, description = "Verify landing on Deleted Tab")
	public void navigateToDeletedTab() throws Throwable {

		menu.ClickInbox();
		//Thread.sleep(1000);
		//driver.navigate().back();
		navigateToSpecifiedMatchesTab(inboxpage.DeletedTab, "Navigate to Inbox Deleted  tab");

	}

	@Test(priority = 1, groups = "", description = "verify profile details on Deleted tab Listing")
	public void verifyProfileOnListingPage() throws Exception {
		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inboxpage.profileCardName);
		sa.assertTrue(isDisplayedAfterWait(inboxpage.profileCardName, 3) , "Profile name not visible on profile page");
		sa.assertTrue(isDisplayedAfterWait(inboxpage.tvEducationLocDetails, 3) , "Education and location details not visible on profile page");
		sa.assertTrue(isDisplayedAfterWait(inboxpage.tvDate, 3) , "Date not visible on profile page");
		if (isDisplayedAfterWait(inboxpage.CannedMsgInListing, 2)) {
			System.out.println(inboxpage.CannedMsgInListing.getText());
		}
		sa.assertAll();

	}
	
	@Test(priority = 2, groups = "", description = "verify filter options in received Tab")
	public void verifyFilterOptionsOnListingPage() throws Exception {
		
		inboxpage.verifyFilterOptionsReceivedTab("Declined/Cancelled by Me");
		inboxpage.verifyFilterOptionsReceivedTab("Declined/Cancelled by H");
		inboxpage.verifyFilterOptionsReceivedTab("Deleted");
		inboxpage.verifyFilterOptionsReceivedTab("All Invitations");

		
	}
	
	@Test(priority = 3, groups = "", description = "verify successful navigation to profile page from  Deleted tab Listing")
	public void verifyNavigationToProfilePageFromListingPage() throws Exception {

		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inboxpage.profileCardName);
		Thread.sleep(1000);
		waitForElementToBeDisplayed(inboxpage.profileCardName, "Wait for profile name to be visible", "");
		String name = inboxpage.profileCardName.getText().split(" ")[0];
		inboxpage.profileCardName.click();
		waitForElementToBeDisplayed(inboxpage.profileName, "Wait for profile page to load", "");
		sa.assertEquals(name, inboxpage.profileName.getText().split(" ")[0] , "Profile name on listing and profile page is not same");
		Thread.sleep(1000);
		driver.navigate().back();
		sa.assertAll();

	}

	@Test(priority = 4, description = "Verify user can scroll on list and click connect button")
	public void verifyClickOnConnectnow() throws Throwable {
		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inboxpage.btn_connectNow_DeleteTab);
		Thread.sleep(1000);
		click(inboxpage.btn_connectNow_DeleteTab, "Click on connect now button", "");
		matches.sendMessageOnConnectPremium();
		matches.verifyCTAAFterConnect_DR();
		sa.assertAll();
	}

	@Test(priority = 5, description = "Verify user can scroll on list and click accept button")
	public void verifyClickOnAccept() throws Throwable {
		SoftAssert sa = new SoftAssert();

		scrollDownToElement(inboxpage.btn_Accept_DeleteTab);
		Thread.sleep(1000);
		click(inboxpage.btn_Accept_DeleteTab, "Click On Accept button", "");
		
		if(UserType.contains("free")) {
			if(isDisplayedAfterWait(matches.cardBannerPersonalized_btnViewPlans, 2)) {
			waitForElementToBeDisplayed(matches.cardBannerPersonalized_btnViewPlans, "Wait for View plans button to be visible", "");
			sa.assertEquals(matches.cardBannerPersonalized_btnViewPlans.getText(), "View Plans" , "View plans text does not match");
			matches.cardBannerPersonalized_btnViewPlans.click();
			waitForElementToBeDisplayed(matches.upgradePageHeader, "wait for payment page to load", "");
			Thread.sleep(1000);
			driver.navigate().back();
			}
		}
		else {
			
			if(isDisplayedAfterWait(inboxpage.sendMessageTextAreaAccept, 2)) {
				sa.assertEquals(inboxpage.sendMessageHeaderAccept.getText(), "It's an Accept!");
				InputValue(inboxpage.sendMessageTextAreaAccept, "Hello", "Input message after sending connect", "");
				inboxpage.sendMessageButtonAccept.click();
				Thread.sleep(1000);
				matches.verifyCTAAFterConnect_DR();
			}
			
			
		}

		sa.assertAll();
	}

}
