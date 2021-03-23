package page.actions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import page.objects.ChatPageObjects;

public class ChatPage extends ChatPageObjects {

	public void verifyViewContactButton() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		waitForElementToBeDisplayed(listOfTextOnChatWindow.get(2), "", "");

		// click on viewcontact button on chat window and verify for free and premium
		viewContactButtonChatTab.click();
		if (isDisplayedAfterWait(shaadiChatButton , 3)) {

			sa.assertTrue(BasePageActions.isElementDisplayed(shaadiChatButton), "Shaadi Chat button not visible");
			shaadiChatButton.click();
			sa.assertAll();

		} else if (isDisplayedAfterWait(shaadiChatButtonPremium , 3)) {

			sa.assertTrue(BasePageActions.isElementDisplayed(shaadiChatButtonPremium), "Shaadi Chat button not visible");
			shaadiChatButtonPremium.click();
			sa.assertAll();

		} else if (isDisplayedAfterWait(BottomSheetText , 3)) {
			sa.assertTrue(BasePageActions.isElementDisplayed(BottomSheetText),
					"Contact him directly,Upgrade Now text is not displayed");
			sa.assertEquals(MaskedNum.getText(), "+91-78********", "Masked Number is improper");
			sa.assertEquals(MaskedEmail.getText(), "*********@gmail.com", "Masked Email is improper");
			sa.assertTrue(BasePageActions.isElementDisplayed(ViewPlansOnBottomSheet),
					"ViewPlans On BottomSheet, is not displayed");
			sa.assertTrue(BasePageActions.isElementDisplayed(CloseIcon), "Close Icon On BottomSheet, is not displayed");
			ViewPlansOnBottomSheet.click();
			sa.assertAll();
			Thread.sleep(2000);
			driver.navigate().back();
		} else {

			Thread.sleep(1000);
			driver.navigate().back();

		}

	}

	public void verifyViewProfileOnChatPage() throws InterruptedException {

		waitForElementToBeDisplayed(menuButtonChatTab, "Wait for view profile option on chat window", "");
		String profilename = profileNameOnChatPage.getText().split(" ")[1];
		System.out.println(profilename);
		menuButtonChatTab.click();
		Thread.sleep(2000);
		viewprofileText.click();
		waitForElementToBeDisplayed(profileName, "wait for profile page to load after clicking on view profile", "");
		System.out.println(profileName.getText());
		Assert.assertEquals(profileName.getText().split(" ")[1], profilename);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	public void verifyProfileInfo() {
		SoftAssert sa = new SoftAssert();
		waitForElementToBeDisplayed(txtAgeHeight, "Wait for profile page to load", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(txtAgeHeight), "Height parameter not present on profile page");
		sa.assertTrue(BasePageActions.isElementDisplayed(profession), "Profession parameter not present on profile page");
		if (isDisplayedAfterWait(messageStatus , 3))
			sa.assertTrue(BasePageActions.isElementDisplayed(messageStatus), "Message status not present on profile page");
		sa.assertAll();
	}

	public void sendMessage() throws InterruptedException {
		Thread.sleep(1000);
		ClickWriteMsg.click();
		InputValue(ClickWriteMsg, "Hello", "Type Chat message", "MT21");
		if (BaseTest.AutomationRunName.equals("Appium"))
			driver.hideKeyboard();

		SendMsgBtn.click();
		if (isDisplayedAfterWait(upgradeNowLinkOnChatWindow , 3)) {
			upgradeNowLinkOnChatWindow.click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(1000);

		}
		ChatbackButton.click();
		boolean isAppRatingVisible = false;
		isAppRatingVisible = isDisplayed(AppRatingLayer);
		System.out.println(isAppRatingVisible);
		if (isAppRatingVisible) {
			driver.navigate().back();
		}

		if (isDisplayedAfterWait(ChatbackButton , 3)) {
			ChatbackButton.click();
		}
		Thread.sleep(1000);
	}

}