
package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;

public class SaveDraftTest extends BasePageActions {

	BottomMenu menu;
	InboxPage inbox;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inbox = new InboxPage();

	}

	@Test(priority = 0, groups = "")
	public void Save_Draft_Inbox() throws Exception {

		menu.ClickInbox();

	}

	@Test(priority = 1, groups = "")
	public void Save_Draft_SentTab() throws Exception {

		inbox.ClickSentTabForSaveDraft();

	}

	@Test(priority = 2, groups = "")
	public void Save_Draft_AcceptedTab() throws Exception {
		inbox.ClickAcceptedtab();

	}

	@Test(priority = 3, groups = "")
	public void Save_Draft_RecivedTab() throws Exception {
		inbox.ClickReceivedtab();

	}

	@Test(priority = 4, groups = "")
	public void Save_Draft_MyMatchesTab() throws Exception {
		Thread.sleep(5000);
		menu.clickOnMatches();
		navigateToMatchesTab(inbox.myMatchesTab);
		inbox.MyMatchestab();

	}

}