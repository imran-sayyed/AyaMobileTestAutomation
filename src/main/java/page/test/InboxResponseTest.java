package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;

public class InboxResponseTest extends BasePageActions {

	BottomMenu menu;
	public static InboxPage inboxpage;
	public static int invite_Count;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inboxpage = new InboxPage();

	}

	@Test(priority = 0, groups = "", description = "checkInbox_Received_Tab_Response")
	public void checkInbox_Received_Tab_Response() throws Exception {

		menu.clickOnlyOnInbox();

		if (isDisplayed(inboxpage.AcceptBannerdissmiss)) {
			inboxpage.AcceptBannerdissmiss.click();
		}

	}

	@Test(priority = 1, groups = "", description = " click Accept On Profile")
	public void clickAcceptOnProfile() throws InterruptedException {

		InboxResponseTest.invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());

		inboxpage.openProfilePageAndAccept();
	}

	@Test(priority = 2, groups = "", description = "click Decline On Profile")
	public void clickDeclineOnProfile() throws InterruptedException {

		InboxResponseTest.invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());

		inboxpage.openProfilePageAndDecline();
	}

	@Test(priority = 3, groups = "", description = "click Decline On Stack")
	public void clickDeclineOnStk() throws InterruptedException {
		InboxResponseTest.invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.checkDeclineOnStack();
	}

	@Test(priority = 4, groups = "", description = "click Accept On Stack")
	public void clickAcceptOnStk() throws InterruptedException {
		InboxResponseTest.invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.checkAcceptOnStack();
	}

	@Test(priority = 5, groups = "", description = "verify decline from swiping left")
	public void swipeForDecline() throws InterruptedException {
		InboxResponseTest.invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.swipeToDecline();
	}

	@Test(priority = 6, groups = "", description = "verify accept from swiping right")
	public void swipeForAccept() throws InterruptedException {
		InboxResponseTest.invite_Count = InboxPage.getInvitationCount(inboxpage.lbl_Member_Waiting.getText());
		inboxpage.swipeToAccept();
	}

	@Test(priority = 7, groups = "", description = "close the stop page", enabled = false)
	public void chkCloseStack() throws InterruptedException {
		inboxpage.CloseStack();
	}

}
