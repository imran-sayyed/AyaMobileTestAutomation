package page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;

public class Delete_Profile_test extends BasePageActions {

	BottomMenu menu;
	MyShaadiPage shaadipage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();

	}

	@Test(priority = 0, description = "Navigate to MyShaadi page")
	public void navigateToMyShaadiPage() throws InterruptedException {

		menu.clickMyShaadiTab();
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verfiy successful landing on Myshaadi page");

	}

	@Test(priority = 1, description = "Scroll and click on Account settings")
	public void scrollAndClickOnAccountSettings() throws InterruptedException {

		shaadipage.scrollAndClickOnAccountSettings();
		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "Wait for Account Settings page to load", "");
		AssertEquals(shaadipage.AlertsTabText, "Alerts", "Verify Alerts text on Account settings page");

		boolean flag = shaadipage.PushNotificationButton.getText().equals("Push Notifications & Sounds")
				|| shaadipage.PushNotificationButton.getText().equals("Push Notifications and Sounds");
		Assert.assertTrue(flag);

	}

	@Test(priority = 2, description = "Scroll and click on Hide/Delete profile on Account Settings page")
	public void scrollAndClickOnHide_Delete_Profile() throws InterruptedException {

		shaadipage.scrollAndClickOnHideDelete();
		waitForElementToBeDisplayed(shaadipage.HideTitle, "Wait for Hide/Delete page to load", "");
		AssertEquals(shaadipage.HideTitle, "Hide Profile", "Verify title text on Hide/delete page");

	}



	@Test(priority = 3, description = "Verify delete profile button is present and click on it")
	public void clickOnDeleteProfile() throws InterruptedException {
		waitForElementToBeDisplayed(shaadipage.deleteProfileButton, "wait for delete button to be visible", "");
		AssertEquals(shaadipage.deleteProfileButton, "Delete", "Assert Delete text");
		click(shaadipage.deleteProfileButton, "click on delete button", "");

	}

	@Test(priority = 4, description = "Verify delete profile page")
	public void verifyDeleteProfilePage() throws InterruptedException {
		waitForElementToBeDisplayed(shaadipage.deleteProfilePageHeaderText, "wait for delete profile page to be visible",
				"");
		AssertEquals(shaadipage.deleteProfilePageHeaderText, "Why do you want to delete your Profile?",
				"Assert Delete profile page header text");
		AssertEquals(shaadipage.FoundMyMatchText, "Found my Match", "Assert Delete option - Found my Match");
		AssertEquals(shaadipage.FoundMyMatchSubHeadingText, "Select this if you have found your Life Partner", "Assert Delete option - Select this if you have found your Life Partne ");
		AssertEquals(shaadipage.TakingBreakText, "Taking a break", "Assert Delete option - Taking a break");
		AssertEquals(shaadipage.TakingBreakSubHeadingText,
				"Select this if you’ve postponed your Partner Search temporarily", "Assert Delete option - Select this if you’ve postponed your Partner Search temporarily");
		AssertEquals(shaadipage.UnsatisfactoryExperienceText, "Unsatisfactory experience", "Assert Delete option - Unsatisfactory experience");
		AssertEquals(shaadipage.UnsatisfactoryExperienceSubHeadingText,
				"Select this if you are unhappy with your experience on Shaadi.com", "Assert Delete option - Select this if you are unhappy with your experience on Shaadi.com ");
		AssertEquals(shaadipage.ReasonNotMentionedTextText, "Reason not mentioned here", "Assert Delete option - Reason not mentioned here");

	}

	@Test(priority = 5, description = "Verify found my match page")
	public void verifyFoundMyMatchPage() throws InterruptedException {
		click(shaadipage.foundMyMatchButton, "click on found my match button", "");
		waitForElementToBeDisplayed(shaadipage.foundMyMatchPageHeaderText, "wait for found my match page to be visible",
				"");
		AssertEquals(shaadipage.foundMyMatchPageHeaderText, "Congratulations on finding your Life Partner!",
				"Assert Found my match page header text");
		AssertEquals(shaadipage.foundThroughShaadiText, "Found my Match through Shaadi.com", "Assert Found my match page options - Found my Match through Shaadi.com");
		AssertEquals(shaadipage.foundElseWhereText, "Found my Match elsewhere", "Assert Found my match page options - Found my Match elsewhere");

		click(shaadipage.foundThroughShaadiButton, "click on found from shaadi button", "Assert Found my match page options - ");
		AssertEquals(shaadipage.foundThroughShaadiPageHeaderText,
				"Would you like to share your story and inspire others ?", "Assert Found my match page options - Would you like to share your story and inspire others ? ");
		AssertEquals(shaadipage.foundThroughShaadiPageTextBox,
				"Share some details on how you met, what you liked about each other, etc.", "Assert Found my match page options - Share some details on how you met, what you liked about each other, etc.");
		AssertEquals(shaadipage.foundThroughShaadiPagePartnerEmailTextBox, "Your Partner’s registered email ID", "Assert Found my match page options - Your Partner’s registered email ID");
		AssertEquals(shaadipage.foundThroughShaadiPageAddPhotosLink, "Add Photos of you together", "Assert Found my match page options - Add Photos of you together");
		AssertEquals(shaadipage.foundThroughShaadiPageDeleteButton, "Submit & delete Profile", "Assert Found my match page options - Submit & delete Profile");
		Thread.sleep(1000);
		driver.navigate().back();

		waitForElementToBeDisplayed(shaadipage.foundElseWhereButton, "Wait for Found else where button", "");
		click(shaadipage.foundElseWhereButton, "click on found elsewhere button", "");
		shaadipage.verifyConfirmProfileDeleteAlert();

	}

	@Test(priority = 6, description = "Verify Taking Break page")
	public void verifyTakingBreakPage() throws InterruptedException {
		waitForElementToBeDisplayed(shaadipage.takingBreakButton, "Wait for Taking break page to load", "");
		click(shaadipage.takingBreakButton, "click on Taking Break button", "");
		waitForElementToBeDisplayed(shaadipage.takingBreakTitleText, "wait for taking break page to be visible", "");
		AssertEquals(shaadipage.takingBreakTitleText, "Why don’t you hide your Profile instead?", "Assert Taking break page options - Why don’t you hide your Profile instead?");
		AssertEquals(shaadipage.hideProfileButton, "Hide my Profile", "Assert Taking break page options - Hide my Profile");
		AssertEquals(shaadipage.deleteProfileLink, "No, delete my Profile", "Assert Taking break page options - No, delete my Profile");
		click(shaadipage.deleteProfileLink, "click on delete profile link", "Assert Taking break page options - click on delete profile link");
		shaadipage.verifyConfirmProfileDeleteAlert();

	}

	@Test(priority = 7, description = "Verify Unsatisfactory Experience page")
	public void verifyUnsatisfactoryExperiencePage() throws InterruptedException {

		waitForElementToBeDisplayed(shaadipage.unsatisfactoryExperienceButton, "Wait for unsatisfactory Experience Button to be visible", "");
		click(shaadipage.unsatisfactoryExperienceButton, "click on unsatisfactoryExperienceButton", "");

		waitForElementToBeDisplayed(shaadipage.unHappyWithMatchesText, "Wait for page to load", "");
		AssertEquals(shaadipage.unHappyWithMatchesText, "Unhappy with Matches", "");
		AssertEquals(shaadipage.misUseProfileText, "Misuse or Non-serious Profiles", "");
		AssertEquals(shaadipage.receivingToomanyCallsText, "Receiving too many calls", "");
		AssertEquals(shaadipage.unableToEditProfileText, "Unable to edit Profile details", "");
		AssertEquals(shaadipage.notMentioneHereText, "Not mentioned here", "");

		click(shaadipage.unHappyWithMatchesButton, "", "");
		waitForElementToBeDisplayed(shaadipage.editPartnerPreferencesButton, "", "");
		AssertEquals(shaadipage.editPartnerPreferencesButton, "Edit Partner Preferences", "");
		click(shaadipage.deleteProfileLink, "", "");
		shaadipage.verifyConfirmProfileDeleteAlert();

		waitForElementToBeDisplayed(shaadipage.misUseProfileButton, "", "");
		click(shaadipage.misUseProfileButton, "", "");
		waitForElementToBeDisplayed(shaadipage.contactDetailsButton, "", "");
		AssertEquals(shaadipage.contactDetailsButton, "Contact details settings", "");
		click(shaadipage.deleteProfileLink, "click on delete profile link", "");
		shaadipage.verifyConfirmProfileDeleteAlert();

		waitForElementToBeDisplayed(shaadipage.receivingToomanyCallsButton, "", "");
		click(shaadipage.receivingToomanyCallsButton, "", "");
		waitForElementToBeDisplayed(shaadipage.contactDetailsButton, "", "");
		AssertEquals(shaadipage.contactDetailsButton, "Contact details settings", "");
		waitForElementToBeDisplayed(shaadipage.stopSalesCallButton, "", "");
		AssertEquals(shaadipage.stopSalesCallButton, "Yes, stop sales calls", "");
		click(shaadipage.deleteProfileLink, "click on delete profile link", "");
		shaadipage.verifyConfirmProfileDeleteAlert();

		waitForElementToBeDisplayed(shaadipage.unableToEditProfileButton, "", "");
		click(shaadipage.unableToEditProfileButton, "", "");
		waitForElementToBeDisplayed(shaadipage.callUsButton, "", "");
		AssertEquals(shaadipage.callUsButton, "Call us", "");
		AssertEquals(shaadipage.chatWithUsButton, "Chat with us", "");
		click(shaadipage.deleteProfileLink, "click on delete profile link", "");
		shaadipage.verifyConfirmProfileDeleteAlert();

		waitForElementToBeDisplayed(shaadipage.notMentioneHereButton, "", "");
		click(shaadipage.notMentioneHereButton, "", "");
		waitForElementToBeDisplayed(shaadipage.deleteProfileLink, "", "");
		AssertEquals(shaadipage.deleteProfileLink, "Delete my Profile", "");
		click(shaadipage.deleteProfileLink, "click on delete profile link", "");
		shaadipage.verifyConfirmProfileDeleteAlert();

		Thread.sleep(2000);
		driver.navigate().back();

	}

	@Test(priority = 8, description = "Verify Unsatisfactory Experience page")
	public void verifyReasonNotMentionedPage() throws InterruptedException {

		waitForElementToBeDisplayed(shaadipage.reasonNotMentionedButton, "", "");
		click(shaadipage.reasonNotMentionedButton, "", "");
		waitForElementToBeDisplayed(shaadipage.deleteProfileLink, "", "");
		AssertEquals(shaadipage.deleteProfileLink, "Delete my Profile", "");
		click(shaadipage.deleteProfileLink, "click on delete profile link", "");
		shaadipage.verifyConfirmProfileDeleteAlert();
		Thread.sleep(1000);
		driver.navigate().back();
	}

}
