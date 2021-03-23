package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;

public class PhoneBookTest extends BasePageActions {

	BottomMenu menu;
	InboxPage inbox;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inbox = new InboxPage();

	}

	@Test(priority = 0, description = "Verify Successful navigation to contacts tab and verify contacts contact is being displayed")
	public void PB01() throws Exception {

		SoftAssert sa = new SoftAssert();

		menu.ClickInbox();
		BasePageActions.navigateToMatchesTab(inbox.PhoneBooktab);
		waitForElementToBeDisplayed(inbox.ContactText, "Wait for Contacts Page to load", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.ContactText),
				"Contacts viewed by you text not displayed");
		waitForElementToBeDisplayed(inbox.ContactCount, "Wait for Contacts count to be visible", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.ContactCount), "Contact Count is not displayed");

		sa.assertAll();
	}

	@Test(priority = 1, description = "Verify User Details on Contacts Tab")
	public void PB02() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.UserName), "User Name not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.Profilecreatedby), "Profile created by not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.TimeDate), "Time Date by not displayed");
		sa.assertAll();

	}

	@Test(priority = 2, description = "Verify if Contact Details Visible")
	public void PB03() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		Boolean ContactNo = false;
		ContactNo = isDisplayed(inbox.ContactNumber);
		if (ContactNo) {

			sa.assertTrue(BasePageActions.isElementDisplayed(inbox.ContactNumber), "Contact Number not displayed");
			sa.assertTrue(BasePageActions.isElementDisplayed(inbox.EmailID), "Email ID not displayed");

			sa.assertAll();
		}

	}

	@Test(priority = 3, description = "Verify if the user can view SMS or Send SMS")
	public void PB04() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		Boolean ContactNo = false;
		ContactNo = isDisplayed(inbox.SendSMS);
		if (ContactNo) {

			sa.assertTrue(BasePageActions.isElementDisplayed(inbox.SendSMS), "Time Date by not displayed");
			waitForElementToBeDisplayed(inbox.SendSMS, "Wait for Send SMS button", "");
			click(inbox.SendSMS, "Click Send SMS", "");
			waitForElementToBeDisplayed(inbox.SendSMSOKbtn, "Wait for OK button on Contacts page", "");
			click(inbox.SendSMSOKbtn, "Click OK to Send SMS", "");

		}

		waitForElementToBeDisplayed(inbox.ViewSMS, "Wait for view SMS button", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.ViewSMS), "View SMS not displayed");
		click(inbox.ViewSMS, "Click View SMS", "");
		waitForElementToBeDisplayed(inbox.SMScontent, "Wait for SMS content to be visible", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.SMScontent), "SMS content not displayed");
		click(inbox.ViewSMS, "Click on View SMS", "");

		sa.assertAll();
	}

	@Test(priority = 4, description = "Verify Block user action from Contacts page")
	public void PB05() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		scrollDownToElement(inbox.ThreeDots);
		click(inbox.ThreeDots, "Click on Three Dots", "");
		Thread.sleep(1000);
		click(inbox.BlockanReport.get(0), "Click on Block Profile", "");
		click(inbox.SendSMSOKbtn, "Click OK to Block Profile", "");
		waitForElementToBeDisplayed(inbox.ContactNotAvailable, "Wait for Hidden title", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.ContactNotAvailable),
				"Contact Not Available Text not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(inbox.YouHveBlocked),
				"You have blocked this member Text not displayed");
		click(inbox.OpenProfilePage, "Click to Open profile page", "");
		
		
		if (isDisplayedAfterWait(inbox.BlockedMemberTxt, 3)) {
			sa.assertEquals(inbox.BlockedMemberTxt.getText(), "Blocked Member", "Blocked Member text not displayed");
		} else {
			sa.assertEquals(inbox.blockedText_new.getText(), "You blocked this Profile", "Blocked Member text not displayed");

		}

		Thread.sleep(1000);
		driver.navigate().back();

		sa.assertAll();

	}

}
