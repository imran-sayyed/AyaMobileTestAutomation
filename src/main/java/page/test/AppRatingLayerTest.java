package page.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.actions.BottomMenu;
import page.actions.InboxPage;

public class AppRatingLayerTest extends BasePageActions

{

	BottomMenu menu;
	InboxPage inbox;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		inbox = new InboxPage();

	}

	@Test(priority = 0, description = "Verify landing on received Tab", groups = { "receivedfree",
			"inboxdeletedpremium", "newuser" })
	public void ID1() throws Throwable {

		SoftAssert sa = new SoftAssert();
		// click(AppRatingLayerObjects.inbox, "Click Inbox Tab", "Inbox-01");
		menu.ClickInbox();
		// Thread.sleep(3000);
//		Boolean isQuickResponseVisible = false;
//		isQuickResponseVisible = isDisplayed(inbox.QuickResponseHeader);
//		if (isQuickResponseVisible) {
//			click(inbox.CloseStackicon, "Click Inbocx Reponse Close Stack icon", "Test-03");
//		}
//
//		ClickNoException(inbox.closeAcceptStopPagebtn, 5, "Close accept stop page", "Inbox-03");

		sa.assertAll();

	}

	@Test(priority = 1, description = "Verify landing on inbox Tab", groups = { "receivedfree", "inboxdeletedpremium",
			"newuser" })
	public void ID2() throws Throwable {

		SoftAssert sa = new SoftAssert();

		{

			// For android

			click(inbox.actionBarItemSearch.get(0), "Click received Tab", "Inbox-02");
			// scrollUsingResourceID("com.shaadi.android:id/item_inbox_profile_tv_name");

			// Click accept button list

			// AssertEquals(inbox.btnAccept, "Accept", "Verify accept button text");
			// AssertEquals(inbox.AcceptonStack, "Accept", "Verify accept button text");

			System.out.println("accept button");
			// inbox.btnAccept.click();
			if (isDisplayed(inbox.AcceptonStack)) {
				inbox.AcceptonStack.click();
				inbox.AcceptBannerdissmiss.click();
			} else {
				inbox.AcceptBannerdissmiss.click();
				waitForSometime(3000);
				inbox.AcceptonStack.click();
				inbox.AcceptBannerdissmiss.click();
			}

			// click(AppRatingLayerObjects.btnAccept, "Click Accept Button", "Inbox-08");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(3000);
			ClickNoException(inbox.closeAcceptStopPagebtn, 5, "Close accept stop page", "Inbox-03");

		}
		sa.assertAll();

	}

	@Test(priority = 2, description = "Verify layer displayed on tab switch", groups = { "receivedfree",
			"inboxdeletedpremium" })

	public void ID3() throws Throwable {

		System.out.println("Tab switch");

		// click(AppRatingLayerObjects.myShaadi, "Click myshaadi Tab", "Layer-01");
		menu.clickMyShaadiTabForAppRating();

		Thread.sleep(7000);

		String text1 = (inbox.txtLayerheader).getText();
		AssertEquals(inbox.txtLayerheader, text1, "Verify text");

		String text2 = (inbox.btnnotsatisfiled).getText();
		AssertEquals(inbox.btnnotsatisfiled, text2, "Verify text");

		String text3 = (inbox.btnsatisfield).getText();
		AssertEquals(inbox.btnsatisfield, text3, "Verify text");

	}

	@Test(priority = 3, description = "Verify user can click not yet option on layer & click back", groups = {
			"receivedfree" })

	public void ID4() throws Throwable {

		SoftAssert sa = new SoftAssert();

		String text2 = (inbox.btnnotsatisfiled).getText();
		AssertEquals(inbox.btnnotsatisfiled, text2, "Verify text");

		click(inbox.btnnotsatisfiled, "Click not yet ", "Layer-01");

		click(inbox.back, "Click back on not yet feedback ", "Layer-01");

		sa.assertAll();

	}

	@Test(priority = 4, description = "Verify user can click loving it - rate now option on layer", groups = {
			"receivedfree" })

	public void ID5() throws Throwable {

		SoftAssert sa = new SoftAssert();

		String text3 = (inbox.btnsatisfield).getText();
		AssertEquals(inbox.btnsatisfield, text3, "Verify text");

		click(inbox.btnsatisfield, "Click loving it ", "Layer-01");

		System.out.println("loving it page");

		String text5 = (inbox.txtsatisfiedheader).getText();
		AssertEquals(inbox.txtsatisfiedheader, text5, "Verify text");

		String text6 = (inbox.txtsatisfiedtitle).getText();
		AssertEquals(inbox.txtsatisfiedtitle, text6, "Verify text");

		String text7 = (inbox.btnratenow).getText();
		AssertEquals(inbox.btnratenow, text7, "Verify text");

		inbox.btnratenow.click();

		System.out.println("Rate now clicked");

		String text8 = (inbox.playstoretitle).getText();
		AssertEquals(inbox.playstoretitle, text8, "Verify text");

		sa.assertAll();
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		

	}

}
