package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class WhatsappTest extends BasePageActions {

	BottomMenu menu;
	MatchesPage matches;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		menu = new BottomMenu();
		matches = new MatchesPage();
	}

	@Test(priority = 0, description = "Verify Landing on Today's Matches and top CTA's on profile page- Free Logger", groups = {
			"inboxresponse" })
	public void WT01() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		menu.clickOnMatches();
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.DRprofilePage), "Todays Matches page not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.LikeThisProfile),
				"Like this profile is not displayed");
		sa.assertEquals(matches.ConnectNowTopCTA.getText(), "Connect Now", "Connect Now CTA is not displayed");
		click(matches.ConnectNowTopCTA, "Click Connect Now top CTA", "WT1");
		//Thread.sleep(3000);

		sa.assertAll();

	}

	@Test(priority = 1, description = "Verify Top CTAs post connect", groups = { "inboxresponse" })
	public void WT02() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		waitForElementToBeDisplayed(matches.ToContactdirectlytext, "", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ToContactdirectlytext),
				"To Contact him/her directly, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.UpgradeNowLink), "Upgrade Now, is not displayed");
		click(matches.UpgradeNowLink, "Click Upgrade Now Link", "WT2");
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ShaadiChatCTA), "Shaadi Chat, is not displayed");
		sa.assertEquals(matches.ShaadiChatText.getText(), "Shaadi Chat", "Shaadi Chat text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.WhatsappCTA), "Whatsapp CTA, is not displayed");
		sa.assertEquals(matches.WhatsappText.getText(), "WhatsApp", "WhatsApp text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CallCTA), "Call CTA, is not displayed");
		sa.assertEquals(matches.CallText.getText(), "Call", "Call text is improper");

	}

	@Test(priority = 2, description = "Verify Bottom Sheet Layer on Shaadi Chat", groups = { "inboxresponse" })
	public void WT03() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		click(matches.ShaadiChatCTA, "Click Shaadi Chat CTA", "WT2");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.BottomSheetText),
				"Contact him directly,Upgrade Now text is not displayed");
		sa.assertEquals(matches.MaskedNum.getText(), "+91-78********", "Masked Number is improper");
		sa.assertEquals(matches.MaskedEmail.getText(), "*********@gmail.com", "Masked Email is improper");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ViewPlansOnBottomSheet),
				"ViewPlans On BottomSheet, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CloseIcon),
				"Close Icon On BottomSheet, is not displayed");

		click(matches.ViewPlansOnBottomSheet, "Click View Plans Button", "WT2");
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	@Test(priority = 3, description = "Verify Bottom Sheet Layer on Whatsapp CTA", groups = { "inboxresponse" })
	public void WT04() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		click(matches.WhatsappCTA, "Click Whatsapp CTA ", "WT3");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.BottomSheetText),
				"Contact him directly,Upgrade Now text is not displayed");
		sa.assertEquals(matches.MaskedNum.getText(), "+91-78********", "Masked Number is improper");
		sa.assertEquals(matches.MaskedEmail.getText(), "*********@gmail.com", "Masked Email is improper");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ViewPlansOnBottomSheet),
				"ViewPlans On BottomSheet, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CloseIcon),
				"Close Icon On BottomSheet, is not displayed");
		click(matches.ViewPlansOnBottomSheet, "Click View Plans Button", "WT2");
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	@Test(priority = 4, description = "Verify Bottom Sheet Layer on Whatsapp CTA", groups = { "inboxresponse" })
	public void WT05() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		click(matches.CallCTA, "Click Call CTA ", "WT3");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.BottomSheetText),
				"Contact him directly,Upgrade Now text is not displayed");
		sa.assertEquals(matches.MaskedNum.getText(), "+91-78********", "Masked Number is improper");
		sa.assertEquals(matches.MaskedEmail.getText(), "*********@gmail.com", "Masked Email is improper");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ViewPlansOnBottomSheet),
				"ViewPlans On BottomSheet, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CloseIcon),
				"Close Icon On BottomSheet, is not displayed");
		click(matches.ViewPlansOnBottomSheet, "Click View Plans Button", "WT2");
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	@Test(priority = 5, description = "Verify Bottom CTAs post connect", groups = { "inboxresponse" })
	public void WT06() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		scrollDown();
		scrollDown();

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ShaadiChatCTA),
				"Shaadi Chat, is not displayed");
		sa.assertEquals(matches.ShaadiChatText.getText(), "Shaadi Chat", "Shaadi Chat text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.WhatsappCTA),
				"Whatsapp CTA, is not displayed");
		sa.assertEquals(matches.WhatsappText.getText(), "WhatsApp", "WhatsApp text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CallCTA), "Call CTA, is not displayed");
		sa.assertEquals(matches.CallText.getText(), "Call", "Call text is improper");

		Thread.sleep(2000);

		scrollUp();
		scrollUp();

	}

	@Test(priority = 6, description = "Verify Whatsapp CTAs in Accepted listing", groups = { "inboxresponse" })
	public void WT07() throws Exception {

		SoftAssert sa = new SoftAssert();

		menu.ClickInbox();
		click(matches.acceptedtab.get(1), "Click on Accepted tab", "Test-03");
		Thread.sleep(2000);
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.VerifyUserName), "User Name is not displayed");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ShaadiChatCTA),
				"Shaadi Chat, is not displayed");
		sa.assertEquals(matches.ShaadiChatText.getText(), "Shaadi Chat", "Shaadi Chat text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.WhatsappCTA),
				"Whatsapp CTA, is not displayed");
		sa.assertEquals(matches.WhatsappText.getText(), "WhatsApp", "WhatsApp text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CallCTA), "Call CTA, is not displayed");
		sa.assertEquals(matches.CallText.getText(), "Call", "Call text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.DropdownAccepted),
				"Drop down in Accepted list is not displayed");

		click(matches.VerifyUserName, "Click on name to open profile page", "Test-03");

	//	Thread.sleep(3000);
		sa.assertAll();

	}

	@Test(priority = 7, description = "Verify Top Whatsapp CTAs in Accepted profile page", groups = { "inboxresponse" })
	public void WT08() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		waitForElementToBeDisplayed(matches.ToContactdirectlytext, "", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ToContactdirectlytext),
				"To Contact him/her directly, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(matches.UpgradeNowLink),
				"Upgrade Now, is not displayed");
		click(matches.UpgradeNowLink, "Click Upgrade Now Link", "WT2");
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ShaadiChatCTA),
				"Shaadi Chat, is not displayed");
		sa.assertEquals(matches.ShaadiChatText.getText(), "Shaadi Chat", "Shaadi Chat text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.WhatsappCTA),
				"Whatsapp CTA, is not displayed");
		sa.assertEquals(matches.WhatsappText.getText(), "WhatsApp", "WhatsApp text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CallCTA), "Call CTA, is not displayed");
		sa.assertEquals(matches.CallText.getText(), "Call", "Call text is improper");

	}

	@Test(priority = 8, description = "Verify Bottom Whatsapp CTAs in Accepted profile page", groups = {
			"inboxresponse" })
	public void WT09() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		scrollDown();
		scrollDown();

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.ShaadiChatCTA),
				"Shaadi Chat, is not displayed");
		sa.assertEquals(matches.ShaadiChatText.getText(), "Shaadi Chat", "Shaadi Chat text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.WhatsappCTA),
				"Whatsapp CTA, is not displayed");
		sa.assertEquals(matches.WhatsappText.getText(), "WhatsApp", "WhatsApp text is improper");

		sa.assertTrue(BasePageActions.isElementDisplayed(matches.CallCTA), "Call CTA, is not displayed");
		sa.assertEquals(matches.CallText.getText(), "Call", "Call text is improper");
		Thread.sleep(2000);
		sa.assertAll();

		scrollUp();
		scrollUp();

		sa.assertAll();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

}