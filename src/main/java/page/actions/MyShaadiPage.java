package page.actions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import android.shaadi.BasePageActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.MyShaadiPageObjects;
import page.test.DraftSettingsTest;
import shaadi.utils.AppStringConstants;

public class MyShaadiPage extends MyShaadiPageObjects {

	public void UpgradeNow() {
		click(btnUpgradeNow, "Click on Upgrade Now Button to View Payments Page", "Payments-02");
	}

	public void ScrollToView_AccountSettings() throws InterruptedException {

		scrollDownToElement(AccountSettingsIOS);

	}

	public void clickOnAccountSettings() {

		click(AccountSettingsIOS, "Click on Account Settings", "");

	}

	public void clickOnContactFilters() {
		if (RunEnvironment.equals("iOSLocal")) {

			// Add weblement for IOS
		} else {
			click(RlSettingsRow.get(1), "Click to Contact Filters", "");
		}
	}

	public void clickOnPartnerPreferences() {
		if (RunEnvironment.equals("iOSLocal")) {

			// Add weblement for IOS
		} else {
			click(RlSettingsRow.get(0), "Click to Contact Filters", "");
		}
	}

	public void VerifyExitsingEmailID() {
		waitForElementToBeDisplayed(lbl_exisitngEmail, "", "");
		AssertEquals(lbl_exisitngEmail, LoginPage.username, "Verify existing email id");
	}

	public void ClickEditEmailID() {
		if (RunEnvironment.equals("iOSLocal")) {
			WebElement lblEditEmailID = driver.findElementByAccessibilityId("id_detailTextLabel_email");
			click(lblEditEmailID, "Click Edit your Email ID", "EditEmail-04");
		} else {
			click(lblEditEmailID, "Click Edit your Email ID", "EditEmail-04");
		}
	}

	public void UpdateAndSubmitEmailID(String EmailID, String EmailErrorMessage, String Password,
			String PasswordErrorMessage, boolean ForgotPassword) throws InterruptedException {
		if (RunEnvironment.equals("iOSLocal")) {

			InputValue(edEmailID, EmailID, "Update Email ID", "");
			InputValue(edPassword, Password, "Update Password", "");
			Assert.assertTrue(
					enabled(btnSubmit, "Check whether SAVE button in disbaled when email field is blank", ""));

			if (!EmailErrorMessage.isEmpty()) {
				click(btnSubmit, "Click Save", "");
				Thread.sleep(2000);
				WebElement AlertTitle = driver.findElementByAccessibilityId(EmailErrorMessage);
				AssertEquals(AlertTitle, EmailErrorMessage, "Verify Email Message Text: " + EmailErrorMessage);
				click(btnOK, "Click OK Button", "");

			}
			if (!PasswordErrorMessage.isEmpty()) {
				click(btnSubmit, "Click Save", "");
				Thread.sleep(2000);
				WebElement AlertTitle = driver.findElementByAccessibilityId(PasswordErrorMessage);
				AssertEquals(AlertTitle, PasswordErrorMessage, "Verify Password Message Text: " + PasswordErrorMessage);
				click(btnOK, "Click OK Button", "");
			}

		}

		else {
			click(lblEditEmailID, "Click Edit your Email ID", "");
			InputValue(edEmailID, EmailID, "Update Email ID", "");
			AssertEquals(edEmailID, EmailID, "");

			waitForElementToBeDisplayed(btnSubmit, "Wait for submit button to be visible", "");
			click(btnSubmit, "Click on Submit button", "");

			if (EmailErrorMessage.isEmpty()) {
				if (!ForgotPassword) {
					InputValue(edPassword, Password, "Enter Password", "");
					click(btnSubmit, "Click on Submit button", "");

					if (!PasswordErrorMessage.isEmpty()) {
						AssertEquals(txtValidationError, PasswordErrorMessage, "Invalid Password validation error");
						click(btnCancel, "Click Cancel button", "");
					}

					else {
						AssertEquals(txtUpdatedSuccessfully, "Your email ID has been updated",
								"Email ID updated Successfully");


					}
				}

				else {
					AssertEquals(lnkForgotPassword, "Forgot Password?", "Verify Forgot Password text");
					click(lnkForgotPassword, "Click Forgot Password button", "");
					AssertEquals(txtPasswordResetLinkSent, "Password reset link sent",
							"Verify Password reset link text");
					String txtPswdReset = (txtUpdatedSuccessfully).getText();
					AssertEquals(txtUpdatedSuccessfully, txtPswdReset, "Verify Password reset text");
					AssertEquals(btnOK, "OKAY", "Verify OKAY text");
					click(btnOK, "Click OK button", "");
				}
			} else {
				AssertEquals(txtValidationError, EmailErrorMessage, "Invalid Email Id validation error");
				waitForElementToBeClickable(btnCancel, "Wait for Cancel Button to be clickable", "");
				click(btnCancel, "Click Cancel button", "");

			}
		}
	}

	public void scrolltillpremiummatches() {

		scrollDownToElement(btnSeeAll_premium);
		click(btnSeeAll_premium, "Click on Premium Mathes See All button", "");

	}

	public void clickOnPremiumMatchesSeeAll() {
		click(premiumMatchesSeeAll, "description", "String tc");
	}

	public void clickOnImageProfileSection() {
		click(img_profile_selection, "clicking on image profile section", "String tc");
	}

	public void clickOnAddtoShortlist() {
		click(dropdownOptons.get(0), "click On add to shortlist", "String tc");
	}

	public void clickOnMyMatches() {
		click(MyMatches, "click on my matches", "String tc");
	}

	public void scrollRightTillShortlist() {
		scroll_to_right(shortlisted.get(7));

	}

	public void clickShortlist() {

		click(horizontalTabs.get(7), "click on my shortlisted", "clicking on shortlisted");
	}

	public void clickConnectNowOnPremiumMatchListing() {
		click(connectNowCarausal, "click on my connect now from carousal", "clicking on shortlisted");

	}

	public void ClickOnDontShowAgain() {
		click(dropdownOptons.get(2), "click On Dont show again", "String tc");
	}

	public void selectContactFilters(WebElement element, ArrayList<Object> parameter) {
		click(element, "Selecting parameters ", "MD08");
		selectOptionUsingText2(parameter);

	}

	public void selectOptionUsingText2(ArrayList<Object> parameter) {
		for (int i = 0; i < parameter.size(); i++) {
			((AndroidDriver<AndroidElement>) driver)
					.findElementByXPath("//android.widget.TextView[@text=' " + parameter.get(i).toString() + "']")
					.click();

			List<WebElement> element = driver.findElementsById("com.shaadi.android:id/edtTxt1");

			boolean flag = false;

			for (int i1 = 0; i1 < element.size(); i1++) {
				if (element.get(i1).getText().contains(text)) {
					flag = true;
					break;

				}

			}
			if (!flag) {
				((AndroidDriver<AndroidElement>) driver)
						.findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();

			}

		}
		scrollTillVisibleTextAndClick("APPLY");
	}

	public void selectingParameters(WebElement element, ArrayList<Object> parameter) throws InterruptedException {
		for (int i = 0; i < parameter.size(); i++) {
			Thread.sleep(1000);
			click(element, "", "");
			selectOptionUsingText(parameter.get(i).toString());

		}

	}

	public void selectingParametersPP(WebElement element, ArrayList<Object> parameter) {
		for (int i = 0; i < parameter.size(); i++) {
			click(element, "", "");
			waitForSometime(1000);
			selectOptionUsingTextPP(parameter.get(i).toString());

		}

	}

	public static void AssertFirstName(WebElement locator, String expectedText, String description) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(locator));
			String[] ActualValue = locator.getText().split(" ");

			String Actual = ActualValue[0];
			String[] expected = expectedText.split(" ");
			System.out.println("Expected---------> " + expected[0]);
			System.out.println("Actual-------> " + Actual);
			assertEquals(Actual, expected[0]);
			extentTest.log(LogStatus.PASS, description);
		} catch (AssertionError e) {
			System.out.println("Exception Occured " + e.getMessage());
			extentTest.log(LogStatus.FAIL,
					" <span style='font-weight:bold;'>Failure trace Selenium: " + e.toString() + "</span>");
			System.out.println(description + "not found to verify Text");
		}
	}

	public void ClickGotit() {
		ClickNoException(btnGotIt, 5, "Click on Button Got it", "Login-06");
	}

	public void clickOnSentItems() throws Exception {

		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sent Items\"));").click();
	}

	public void scrollRightTillRecentlyViewed() {
		scroll_to_right(shortlisted.get(8));

	}

	public void clickRecentlyViewed() {

		click(shortlisted.get(8), "click on my recently viewed", "clicking on recently viewed");
	}

	public static void Scrolljust(WebElement Locator, String Description, String TCID) {
		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Ignored Member\"));");
	}

	public void hortizonalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.10);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void swipeTillShortlist() {
		boolean f = false;
		for (int i = 1; i <= 10; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				f = horizontalTabs.get(1).findElement(By.className("android.widget.TextView")).isDisplayed();

				f = true;
				break;
			} catch (Exception e) {
				hortizonalSwipe();
			}
		}
		if (f) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	public void clickShortlists1() {

		click(horizontalTabs.get(7).findElement(By.className("android.widget.TextView")), "click on my shortlisted",
				"clicking on shortlisted");
	}

	public void InboxClickGotit() {
		click(btnGotIt, "Click on Button Got it", "Inbox-06");
	}

	public static void clickSendButton() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void ScrollHorizontallytillShortlist(List<WebElement> Locator, String ExpectedText,
			String Description, String TCID) {
		boolean found = false;
		String strExpected = ExpectedText;
		while (!found) {
			int size = 0;
			size = size + Locator.size();
			for (int i = 0; i < size; i++) {
				String strActual = Locator.get(i).findElement(By.className("android.widget.TextView")).getText();
				if (strActual.equals(strExpected)) {
					System.out.print(
							"Text: " + Locator.get(i).findElement(By.className("android.widget.TextView")).getText());
					click(Locator.get(i), Description, TCID);
					found = true;
					break;
				}
			}
			if (!found) {
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int y = (int) (height * 0.10);
				int startx = (int) (width * 0.75);
				int endx = (int) (width * 0.35);
				driver.swipe(startx, y, endx, y, 500);
			}
		}
	}

	public void scrollAndClickOnAccountSettings() {

		scrollDownToElement(AccountSettingsIOS);
		waitForElementToBeDisplayed(AccountSettingsIOS, "wait for element to be visible", "Login");
		AccountSettingsIOS.click();

	}

	public void clickOnAlerts() {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
			PushNotificationButton.click();
		} else {
			((AndroidDriver<AndroidElement>) driver)
					.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Push Notifications & Sounds\"));")
					.click();
		}

	}

	public void turnOffAlerts() {

		if (isDisplayed(whatsapp_alert_toggle)) {
			turnOffIfOn(whatsapp_alert_toggle);
		}

		scrollDown();

		turnOffIfOn(newInvitations);

		turnOffIfOn(newAccepts);

		turnOffIfOn(recommendations);

		turnOffIfOn(newMatches);

		turnOffIfOn(shortlistsAlerts);

		turnOffIfOn(recentVisitors);

		turnOffIfOn(premiumMatches);

		turnOffIfOn(pendingInvitations);

	}

	public void turnOffIfOn(WebElement locator) {
		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			if (locator.getAttribute("value").equals("1")) {
				locator.click();

			}
		} else {
			System.out.println(locator.getText());
			if (locator.getText().equalsIgnoreCase("ON")) {
				locator.click();

			}
		}

	}

	public void turnOnIfOff(WebElement locator) {
		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			if (locator.getAttribute("value").equals("0")) {
				locator.click();

			}
		} else {
			System.out.println(locator.getText());
			if (locator.getText().equalsIgnoreCase("OFF")) {
				locator.click();

			}
		}
	}

	public void turnOnAlerts() {
		if (isDisplayed(whatsapp_alert_toggle)) {
			turnOnIfOff(whatsapp_alert_toggle);
		}

		scrollDown();
		turnOnIfOff(newInvitations);

		turnOnIfOff(newAccepts);

		turnOnIfOff(recommendations);

		turnOnIfOff(newMatches);

		turnOnIfOff(shortlistsAlerts);

		turnOnIfOff(recentVisitors);

		turnOnIfOff(premiumMatches);

		turnOnIfOff(pendingInvitations);

	}

	public void verifyAndAssertVerificationBadge() {

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			AssertEquals(badgeOptions.get(0), "Visible to all members", "Visible to all members - assert text");
			AssertEquals(badgeOptions.get(1), "Not visible to anyone", "Not visible to anyone - assert text");

			click(badgeOptions.get(1), "click on Not visible to anyone", "");
			click(badgeOptions.get(0), "click on visible to all members", "");
			click(badgeOkButton, "click on OK button", "");
		} else {

			AssertEquals(visibleToAllMembersIOS, "Visible to all members", "Visible to all members - assert text");
			AssertEquals(notVisibleToAllMembersIOS, "Not visible to all members",
					"Not visible to anyone - assert text");

			click(notVisibleToAllMembersIOS, "click on visible to all members", "");
			click(visibleToAllMembersIOS, "click on Not visible to anyone", "");
			click(CancelButtonIOS, "click on Cancel button", "");

		}
	}

	public void verifyAndAssertAlertOFF() throws InterruptedException {
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {

			if (isDisplayed(whatsapp_alert_toggle)) {
				String ONOFF = whatsapp_alert_toggle.getText();
				AssertEquals(whatsapp_alert_toggle, ONOFF, "Verify Whats app alert.");
			}
			scrollTillVisibleText("In-app Sounds");// scroll down till In-app Sounds alert toggle appears
			AssertEquals(newInvitations, "OFF", "verify new Invitations off");
			AssertEquals(newAccepts, "OFF", "verify new accepts off");
			AssertEquals(recommendations, "OFF", "verify recommendations off");
			AssertEquals(newMatches, "OFF", "verify new matches off");
			AssertEquals(shortlistsAlerts, "OFF", "verify shortlists off");
			AssertEquals(recentVisitors, "OFF", "verify recent visitors off");
			AssertEquals(premiumMatches, "OFF", "verify premium off");
			AssertEquals(pendingInvitations, "OFF", "verify pending invitations");
			Thread.sleep(2000);
		} else {

			if (isDisplayed(whatsapp_alert_toggle)) {
				String ONOFF = whatsapp_alert_toggle.getAttribute("value");
				AssertEquals(whatsapp_alert_toggle, ONOFF, "Verify Whats app alert.");
			}
			// scrollTillVisibleText("In-app Sounds");// scroll down till In-app Sounds
			// alert toggle appears
			Assert.assertEquals(newInvitations.getAttribute("value"), "0", "verify new Invitations off");
			Assert.assertEquals(newAccepts.getAttribute("value"), "0", "verify new Invitations off");
			Assert.assertEquals(recommendations.getAttribute("value"), "0", "verify new Invitations off");
			Assert.assertEquals(newMatches.getAttribute("value"), "0", "verify new Invitations off");
			Assert.assertEquals(shortlistsAlerts.getAttribute("value"), "0", "verify new Invitations off");
			Assert.assertEquals(recentVisitors.getAttribute("value"), "0", "verify new Invitations off");
			Assert.assertEquals(premiumMatches.getAttribute("value"), "0", "verify new Invitations off");
			Thread.sleep(2000);
		}
	}

	public void scrollAndClickOnHideDelete() {

		scrollDownToElement(HideDeleteButton);
		waitForElementToBeDisplayed(HideDeleteButton, "wait for Hide/Delete button to be in view", "");
		HideDeleteButton.click();

	}

	public void clickOnHide() {

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.TextView[@text='Hide']")
					.click();
		} else {
			profileVisibletxtIOS.click();
		}
	}

	public void clickOnSave() {
		hideProfileButton.click();
	}

	public void clickOnUnHide() {

		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.TextView[@text='Unhide']")
				.click();
	}

	public void clickOk() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(unHideOkButton));

		unHideOkButton.click();

	}

	public void scrollAndClickOnVerificationBadge() throws InterruptedException {

		// Fixes done here should work fine now
		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
			scrollDownToElement(btn_DobCell);
			Thread.sleep(2000);
			if (isDisplayed(VerificationBadgeButtonIOS)) {
				VerificationBadgeButtonIOS.click();
			} else {
				NotVisible_VerificationBadgeButtonIOS.click();
			}

		} else {
			scrollDownToElement(VerificationBadgeButtonIOS);
			VerificationBadgeButtonIOS.click();
		}

	}

	public void clickReligionInContactFilters() {

		driver.findElementByClassName("android.widget.RelativeLayout")
				.findElement(By.id("com.shaadi.android:id/txt_title")).click();// contactFilterParamaters.get(0).click();
	}

	public void clickCommunityInContactFilters() {
		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.RelativeLayout[@index='2']")
				.findElementById("com.shaadi.android:id/txt_title").click();

	}

	public void clickMotherTongueInContactFilters() {
		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.RelativeLayout[@index='3']")
				.findElementById("com.shaadi.android:id/txt_title").click();

	}

	public void clickMaritalStatusInContactFilters() {
		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.RelativeLayout[@index='4']")
				.findElementById("com.shaadi.android:id/txt_title").click();

	}

	public void clickCountryInContactFilters() {
		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.RelativeLayout[@index='5']")
				.findElementById("com.shaadi.android:id/txt_title").click();

	}

	public void selectOptionUsingText(String text) {
		waitForSometime(2000);

		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.TextView[@text='" + text + "']")
				.click();

		List<WebElement> element = driver.findElementsById("com.shaadi.android:id/edtTxt1");

		boolean flag = false;

		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(text)) {
				flag = true;
				break;

			}

		}
		if (flag) {
			scrollTillVisibleTextAndClick("APPLY");
		} else {
			((AndroidDriver<AndroidElement>) driver)
					.findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
			scrollTillVisibleTextAndClick("APPLY");

		}

	}

	public void selectOptionUsingTextPP(String text) {

		((AndroidDriver<AndroidElement>) driver).findElementByXPath("//android.widget.TextView[@text='" + text + "']")
				.click();

		List<WebElement> element = driver.findElementsById("com.shaadi.android:id/edtTxt1");

		boolean flag = false;

		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(text)) {
				flag = true;
				break;

			}

		}
		if (flag) {
			click(applyButton, "click apply button", "");
		} else {
			((AndroidDriver<AndroidElement>) driver)
					.findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
			click(applyButton, "click apply button", "");
		}

	}

	// Generic function for Scroll
	public void scrollUsingTouchActionsByElements(MobileElement startElement, MobileElement endElement) {
		TouchAction actions = new TouchAction(driver);
		actions.press(startElement).waitAction(2000).moveTo(endElement).release().perform();
	}

	public void scrolltillmore() {
		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.shaadi.android:id/tv_more\"));")
				.click();

	}

	public void clickOnDeleted() throws Exception {
		click(inboxSent.get(4), "Click Sent Items", "Inbox-01");

	}

	public static void dismissLayer() {
		// ClickNoException(driver., timeLimitInSeconds, description, tcid);

	}

	public void verifyConfirmProfileDeleteAlert() throws InterruptedException {

		waitForElementToBeDisplayed(confirmProfileDeletionAlertHeaderText, "", "");
		AssertEquals(confirmProfileDeletionAlertHeaderText, "Confirm Profile deletion?",
				"Assert dialog box Header text");
		AssertEquals(confirmProfileDeletionAlertText,
				"This will result in the permanent loss of your Profile info, all Matches you’ve liked, connected or contacted & Chat history.",
				"Verify confirm deletion alert box text");
		AssertEquals(confirmProfileDeletionAlertCancelButton, "CANCEL",
				"Assert Cancel button on delete profile dialog box");
		AssertEquals(confirmProfileDeletionAlertDeleteButton, "DELETE MY PROFILE",
				"Assert DELETE MY PROFILE button on delete profile dialog box");
		click(confirmProfileDeletionAlertCancelButton, "Click on Confirm profile deletion button", "");
		Thread.sleep(1000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void ClickLogout() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDownToElement(btnLogout);
		}
		click(btnLogout, "Click Logout", "Login-09");
	}

	public void scrollDownTillRemindMessage() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.40)).waitAction(4000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public void renewPremium() throws InterruptedException {
		verifyText(btnRenewPremium, "RENEW PREMIUM", " Verify RENEW PREMIUM Text");
		click(btnRenewPremium, "Click on RENEW PREMIUM Button to View Payments Page", "Test-01");
		waitForSometime(3000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void RenewPremiumonBanner() throws InterruptedException {
		click(inboxNav1, "Click on Inbox", "Test-01");
		Thread.sleep(6000);
		Boolean isQuickResponseVisible = false;
		isQuickResponseVisible = isDisplayed(QuickResponseHeader);
		if (isQuickResponseVisible) {
			click(CloseStackicon, "Click on close icon to close the Qucik Response stack", "Test-01");
		}

		Boolean isInvitationVisible = false;
		isInvitationVisible = isDisplayed(FirstAccept);
		if (isInvitationVisible) {
			AssertEquals(FirstAccept, "Accept", "Verify the text Accept");
			click(FirstAccept, "Click on Accept CTA ", "Test-01");
			AssertEquals(AcceptBanner, "RENEW PREMIUM", "Verify the text RENEW PREMIUM");
		}

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public String clickOnDropDownAndSelect(String dropDownText) {
		boolean flag = false;
		String before = "";
		while (!flag) {
			waitForSometime(2000);
			click(img_profile_selection, "Click on the dropdown arrow", "SL01");
			waitForSometime(2000);
			List<WebElement> options = driver.findElementsById("android:id/title");
			for (WebElement e : dropdownOptions) {
				if (e.getText().equals(dropDownText)) {
					waitForSometime(1000);
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					waitForSometime(1000);
					before = getText(profileName, "Get member name");
					click(img_profile_selection, "Click on the dropdown arrow", "SL01");

					click(e, "", "");
					flag = true;
				} else {
					waitForSometime(1000);
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

					NextArrowBtn.click();
				}
			}
		}
		return before;

	}

	@SuppressWarnings("unchecked")
	public void editMessage(String[] messages, int index, WebElement IOSButton , String messageType) {

		String message = "";
		
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {

			waitForElementToBeClickable(EditBtn.get(index), "Wait for Edit button to be visible", "");
			click(EditBtn.get(index), "Click Edit Btn", "SD04");
		} else {

			waitForElementToBeDisplayed(IOSButton, "", "");
			click(IOSButton, "Click Edit Btn", "SD04");
		}

		waitForElementToBeDisplayed(EditBox, "Wait for EDIT MESSAGE box to be visible", "");
		String existingMessage = getText(EditBox, "Get the existing text from the box");
		
		if(!messages[0].equals(existingMessage)) {
			
			message = messages[0];
			
		}
		else {
			message = messages[1];

		}
		
		InputValue(EditBox, message, "Enter message", "");
		click(SaveMessageBtn, "Click Save Message Btn", "");
		
		if(messageType.equalsIgnoreCase("Connect")) {
			DraftSettingsTest.actualConnectMessage = message;
		}

	}

	public void assertMessageWindow() {

		SoftAssert sa = new SoftAssert();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {

			sa.assertTrue(BasePageActions.isElementDisplayed(ConnectMessageText.get(0)),
					"Connect Message text not displayed");
			sa.assertEquals(MsgInfo.get(0).getText(),
					"This Message is sent to Members that you send Connect Request to",
					"Expected text is not displayed");

			waitForElementToBeDisplayed(AcceptMessageText.get(1), "", "");
			sa.assertTrue(BasePageActions.isElementDisplayed(AcceptMessageText.get(1)),
					"Accept Message text not displayed");
			sa.assertEquals(MsgInfo.get(1).getText(),
					"This message is sent to Members when you Accept their Connect Request",
					"Expected text is not displayed");
			waitForElementToBeDisplayed(ReminderMessageText.get(2), "", "");
			sa.assertTrue(BasePageActions.isElementDisplayed(ReminderMessageText.get(2)),
					"Reminder Message text not displayed");
			sa.assertEquals(MsgInfo.get(2).getText(), "This Message is sent to Members that you send a Reminder to",
					"Expected text is not displayed");
		} else {

			sa.assertEquals(connectMessageTxtIOS.getText(), AppStringConstants.connectMessage);
			sa.assertEquals(acceptMessageTxtIOS.getText(), AppStringConstants.acceptMessage);
			sa.assertEquals(reminderMessageTxtIOS.getText(), AppStringConstants.reminderMessage);
		}
		sa.assertAll();

	}

	public void verifyConnectMessage(String message) throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Connect Now\"));");
		sa.assertEquals(ConnectNowBtn.getText(), "Connect Now", "Connect Now text is not displayed");
		click(ConnectNowBtn, "Click Connect Now Btn", "");

		Thread.sleep(500);
		click(shaadiChatButton, "Click on Shaadi Chat Btn after connect", "");

		waitForElementToBeDisplayed(messageText, "Wait for Chat window to load", "");
		String text = messageText.getText();
		boolean flag = text.contains(message);
		sa.assertTrue(flag, "Auto send Connect Message does not match on chat window");

		sa.assertAll();
	}

	public void selectingParameters_contactFilters(WebElement element, ArrayList<Object> parameter)
			throws InterruptedException {
		for (int i = 0; i < parameter.size(); i++) {
			scrollDownToElement_search(element);
			Thread.sleep(1000);
			element.click();
			selectOptionUsingText_contactFilters(parameter.get(i).toString());

		}

	}

	public void selectingParametersForPP(WebElement element, ArrayList<Object> parameter) throws InterruptedException {
		for (int i = 0; i < parameter.size(); i++) {
			scrollDownToElement_search(element);
			Thread.sleep(1000);
			element.click();
			selectOptionUsingText_PP(parameter.get(i).toString());

		}

	}

	@SuppressWarnings("unchecked")
	public void selectOptionUsingText_PP(String text) throws InterruptedException {
		Thread.sleep(2000);
		WebElement textelement = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("//android.widget.CheckBox[@text='" + text + "']");

		waitForElementToBeDisplayed(textelement, "", "");
		textelement.click();
		
		if(isDisplayedAfterWait(NoBtnPP, 2)) {
			click(NoBtnPP, "Click on no option on PP selection page", "");
		}

		Thread.sleep(1000);
		List<WebElement> element = driver.findElementsById("com.shaadi.android:id/edtTxt1");

		boolean flag = false;

		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(text)) {
				flag = true;
				break;

			}

		}
		if (flag) {
			click(applyButtonPP, "click apply button", "");
		} else {

		//	textelement.click();
			((AndroidDriver<AndroidElement>) driver)
			.findElementByXPath("//android.widget.CheckBox[@text='" + text + "']").click();
			Thread.sleep(1000);
			applyButtonPP.click();
		}

	}

	@SuppressWarnings("unchecked")
	public void selectOptionUsingText_contactFilters(String text) throws InterruptedException {
		Thread.sleep(2000);
		WebElement textelement = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("//android.widget.CheckBox[@text='" + text + "']");

		waitForElementToBeDisplayed(textelement, "", "");
		textelement.click();

		Thread.sleep(2000);
		List<WebElement> element = driver.findElementsById("com.shaadi.android:id/edtTxt1");

		boolean flag = false;

		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(text)) {
				flag = true;
				break;

			}

		}
		if (flag) {
			click(applyButtonContactFilters, "click apply button", "");
		} else {

			textelement.click();
			Thread.sleep(1000);
			applyButtonContactFilters.click();
		}

	}

}
