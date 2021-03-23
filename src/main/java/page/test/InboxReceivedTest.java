package page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.InboxPage;
import page.objects.DashboardObjects;

public class InboxReceivedTest extends BasePageActions {

	public static String setUserType;
	public static boolean navFlag;
	DashboardObjects dsh_obj;
	public InboxPage inbox;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {

		 dsh_obj = new DashboardObjects();
//		 inb_obj = new inbox();
		inbox = new InboxPage();

//			closeUnWantedPage();

		Thread.sleep(3000);

		inbox.btnMyShaadiTab.click();

		setUserType = setMyUser(DashboardObjects.usr_Profile_Expiry);

		System.out.println(setUserType + " User is Running the test");

	}

	@Test(priority = 0, groups = "", description = "Find total number of invitation on Inbox")
	public void checkInboxCount() {

		boolean setCountFlag;

		String count = inbox.btnInboxTab.getText();

		if (count != null) {

			setCountFlag = true;

			System.out.println(count);

			Assert.assertTrue(setCountFlag, "The count on the inbox Tab is seen");
		}

	}

	@Test(priority = 1, groups = "", description = "Check the QR page and see if it is visible on Inbox Page")
	public void checkQuickResponseLayer() throws InterruptedException {

		inbox.btnInboxTab.click();

		Thread.sleep(5000);

		if (chckElementPresent(inbox.btnCloseFrstAcptWindow) == true) {

			Assert.assertTrue(chckElementPresent(inbox.btnCloseFrstAcptWindow), "Porfile card for the user is seen");
		}

		else {

			if (chckElementPresent(inbox.txtNoPendingInvites) == true) {

				Assert.assertEquals(inbox.txtNoPendingInvites.getText(), "There are no Pending Invitations to Connect",
						"No Pending Connections Message is Seen");

				System.out.println("Second Condition got Executed");

			} else {
				Assert.fail("None of the Above Parameter is seen on the Page");
			}

		}

	}

	@Test(priority = 2, groups = "", description = "Check if the user is able to see the First Accept Page ")
	public void checkFirstAccept() throws InterruptedException {

		Thread.sleep(5000);

		if (chckElementPresent(inbox.btnCloseFrstAcptWindow) == true) {

			inbox.btnCloseFrstAcptWindow.click();

			Thread.sleep(3000);

			// calling this code since first accept logic is written in it for common
			// implementation
			inbox.checkAcceptDeclineOnProfile(inbox.btnAcceptOnProfile, inbox.btnAcceptedTab, inbox.txtProfileName,
					"Checking first Accept POP up", "", true);

			if (InboxReceivedTest.setUserType.equals("Free")) {

				inbox.btnCloseFrstAcptWindow.click();
			}

			if (chckElementPresent(inbox.btnQuckResponse) == true) {

				inbox.btnQuckResponse.click();

				Thread.sleep(3000);
			}

		} else {
			Assert.fail("None of the Above Parameter is seen on the Page");
		}

	}

// Below test are commented because they are repetitive in nature and hence can be eliminated from here

//	@Test(priority = 3, groups = "",description="Check if the user is able to Accept Invitation from Stack")
//	public void checkAcceptButton_ProfileCard() throws InterruptedException {
//
//		checkAcceptDeclineFunctionality(AppStringConstants.btnAcceptPath,
//				"Accept button on Profile card for the user is seen", "Invitation to the user was Send");
//	}
//
//	@Test(priority = 4, groups = "",description="Check if the user is able to Decline Invitation from Stack")
//	public void checkDeclineButton_ProfileCard() throws InterruptedException {
//
//		checkAcceptDeclineFunctionality(AppStringConstants.btnDeclinePath,
//				"Decline button on Profile card for the user is seen", "Decline  to the user was Send");
//	}

	@Test(priority = 3, groups = "", description = "Check if the user is able to See QR page is still open after Accept and Decline Operations")
	public void closeQuickResponse() throws InterruptedException {

		if (chckElementPresent(inbox.btnCloseFrstAcptWindow) == true) {

			inbox.btnCloseFrstAcptWindow.click();

			Thread.sleep(3000);

			Assert.assertTrue(chckElementPresent(inbox.btnQuckResponse),
					"The stack is closed and Quick Reponse Button is seen");
		}

		else {

			if (chckElementPresent(inbox.txtNoPendingInvites) == true) {

				Assert.assertEquals(inbox.txtNoPendingInvites.getText(), "There are no Pending Invitations to Connect",
						"No Pending Connections Message is Seen");
			}
		}
	}

	@Test(priority = 4, groups = "", description = "Check if the Accept is working fine from Inbox listing Page")
	public void acceptFrom_RecievedInvitationPage() throws InterruptedException {

		if (chckElementPresent(inbox.btnQuckResponse) == true) {

			// normal scroll to avoid 90 sec wait for page to load
			// Accept button on second profile is used in this case
			scrollDownToElement(inbox.btnAcceptOnProfile_2);

			inbox.checkAcceptDeclineOnProfile(inbox.btnAcceptOnProfile_2, inbox.btnAcceptedTab, inbox.txtProfileName2,
					"", "", false);

		}

		else {
			Assert.fail("The Window is seen Expected");
		}
	}

	@Test(priority = 5, groups = "", description = "Check if the user is navigated to QR page by clicking on QR button from Inbox page")
	public void checkQuickResponseButton() throws InterruptedException {

		inbox.btnRecievedTab.click();

		if (chckElementPresent(inbox.btnQuckResponse) == true) {

			inbox.btnQuckResponse.click();

			Thread.sleep(3000);

			Assert.assertTrue(chckElementPresent(inbox.btnCloseFrstAcptWindow),
					"Quick Response Window is Visible and can be closed");
		}

		else {

			if (chckElementPresent(inbox.txtNoPendingInvites) == true) {

				Assert.assertEquals(inbox.txtNoPendingInvites.getText(), "There are no Pending Invitations to Connect",
						"No Pending Connections Message is Seen");

				System.out.println("Second Condition got Executed");
			}

			else {
				Assert.fail("Neither No Pending Request Message is seen Nor Quick Response button is seen");
			}
		}

	}

	@Test(priority = 6, groups = "", description = "Check if the user is able to apply the Premium Filter and check")
	public void checkFilter_Premium() throws InterruptedException {

		inbox.btnCloseFrstAcptWindow.click();

		inbox.checkFilterStatusAndCount(inbox.btnPremium);
	}

	@Test(priority = 7, groups = "", description = "Check if the user is able to apply the matching preference Filter and check")
	public void checkFilter_MatchingPref() throws InterruptedException

	{

		inbox.checkFilterStatusAndCount(inbox.btnMatchingPreferences);

	}

	@Test(priority = 8, groups = "", description = "Check if the user is able to apply the Expiring Soon Filter")
	public void checkFilter_ExpringSoon() throws InterruptedException

	{

		inbox.checkFilterStatusAndCount(inbox.btnExpiringSoon);

	}

	@Test(priority = 9, groups = "", description = "Check if the Decline is working fine from the Inbox listing Page")
	public void deleteFrom_RecievedInvitationPage() throws InterruptedException {

		inbox.btnRecievedTab.click();

		inbox.checkDeclineOnProfile(inbox.btnDeclineOnProfile, inbox.btnDeletedTab, inbox.txtProfileName, "", "",
				false);

	}

}
