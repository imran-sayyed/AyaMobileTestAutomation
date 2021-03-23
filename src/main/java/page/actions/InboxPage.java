package page.actions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.DailyRecommendObjects;
import page.objects.DashboardObjects;
import page.objects.InboxPageObjects;
import page.test.InboxReceivedTest;
import page.test.InboxResponseTest;

public class InboxPage extends InboxPageObjects {

	public void clickOnSentItems() throws Exception {

		if (RunEnvironment.equals("iOSLocal")) {
			tabSentItems.click();
		} else {
			((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sent Items\"));").click();
		}

	}

	public void CloseAcceptStopPage() throws Exception {
		ClickNoException(closeAcceptStopPagebtn, 5, "Close accept stop page", "Inbox-03");
	}

	public void ClickRequest() throws Exception {
		BasePageActions.navigateToMatchesTab(RequestTab);
	}

	public void ClickRequestPremium() throws Exception {
		click(actionBarItemSearch.get(4), "Click request Tab", "Inbox-02");
	}

	public void ClickViewAll() throws Exception {
		ClickNoException(viewAllCountbtn, 5, "Close accept stop page", "Inbox-03");
	}

	public void ScrollClickDeleteButton() {
		try

		{
			Thread.sleep(2000);

			scrollDownToElement(btn_Delete_ReceivedTab);
			Thread.sleep(2000);
			btn_Delete_ReceivedTab.click();

		} catch (Exception e) {
			System.out.println("Delete button not found  on page");
		}
	}

	public void clickAcceptedTab() throws InterruptedException {

		Thread.sleep(2000);

		click(AcceptedTab1, "Land on Accepted tab", "Test-03");

		Thread.sleep(3000);

		boolean isclosehunkydoryiOSVisible = false;

		isclosehunkydoryiOSVisible = isDisplayed(closehunkydoryi);

		if (isclosehunkydoryiOSVisible) {

			click(closehunkydoryi, "Close Hunky Dory", "Test-03");
			Thread.sleep(2000);
		}

	}

	public void clickViewcontact() throws InterruptedException {
		if (RunEnvironment.equals("iOSLocal")) {

			AssertEquals(ViewContactTextiOS, "View Contact", "Verify the text View Contact");

			click(btn_ViewContact, "Click View Contact", "Test-07");

			if (isDisplayed(btn_closeContactPopUp)) {
				btn_closeContactPopUp.click();
			}

		}

		else {

			waitForSometime(2000);
			click(CallCTA, "Click Call CTA ", "WT3");

		}
	}

	public void clickWriteMsg() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			AssertEquals(WriteMessageTextiOS, "Write Message", "Verify the text Write Message");

		}

		else {
			click(ShaadiChatCTA, "Click Shaadi Chat CTA ", "WT3");

			click(CloseIcon, "Click Close Button", "WT2");

			Thread.sleep(2000);

		}
	}

	public void openProfilePage() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			Boolean isCancelCTAVisible, isDeclineCTAVisible;

			click(VerifyUserName, "Click to Open profile page", "Test-09");

			Thread.sleep(2000);

			isCancelCTAVisible = isDisplayed(BtnCanceliOSProfilepage);

			if (isCancelCTAVisible) {

				click(BtnCanceliOSProfilepage, "Click on Cancel button", "Test-09");

			}

			isDeclineCTAVisible = isDisplayed(BtnDeclineiOSProfilepage);

			if (isDeclineCTAVisible) {

				click(BtnDeclineiOSProfilepage, "Click on Decline button", "Test-09");
			}

		} // IOS code ends here
		else {

			waitForElementToBeDisplayed(ClickonNamenOpn, "", "");
			click(ClickonNamenOpn, "Click to open profile page", "Test-10");
			waitForSometime(2000);
		}

	}

	public void clickReceived() throws Exception {
		click(topNavBar.get(0), "Click received Tab", "Inbox-02");
	}

	public void clickAccept() throws Exception {

		if (RunEnvironment.equals("iOSLocal")) {
			WebElement accepttab = driver.findElement(By.id("segmentedcontrolSubNav"))
					.findElements(By.className("XCUIElementTypeButton")).get(1);
			accepttab.click();
		} else {
			click(topNavBar.get(1), "Click accept Tab", "Inbox-02");
		}
	}

	public void hortizonalRightSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.50);
		int startx = (int) (width * 0.90);
		int endx = (int) (width * 0.15);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void hortizonalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.90);
		int endx = (int) (width * 0.20);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void hortizonalLeftSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.50);
		int startx = (int) (width * 0.20);
		int endx = (int) (width * 0.90);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void FeatureLeftSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.25);
		int startx = (int) (width * 0.20);
		int endx = (int) (width * 0.80);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void FeatureRightSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.25);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.20);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void scrollToRightReceived(WebElement from) {
		try {
			int x = from.getLocation().getX();
			int y = from.getLocation().getY();
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x + 50, y).moveTo(x, y).release().perform();
		} catch (Exception e) {
			System.out.println("---------SCROLL FAILED--------");
		}
	}

	public void scroll10PlusProfiles() throws InterruptedException {

		for (int i = 0; i <= 12; i++) {
			Thread.sleep(2000);
			scrollDownToElement(btn_Decline_ReceivedTab);
		}

	}

	public void scrollUpToDownFast() {
		try {
			int x = 300;
			int y = 400;
			TouchAction action = new TouchAction(driver);
			action.press(350, 1000).moveTo(350, 900).release().perform();
		} catch (Exception e) {
			System.out.println("---------SCROLL FAILED--------");

		}

	}

	public void profileinfo() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			ContainsText(lbl_Member_Waiting, "Print Header 1st Line", "Test-01");

			ContainsText(lbl_SubText_Member_Waiting, "Print Header 2nd Line", "Test-02");

			ContainsText(txt_ProfileName, "Print User's Name", "Test-03");

			ContainsText(txt_age_height, "Print Age Height Info", "Test-04");

			ContainsText(txt_religion, "Print User's Religion", "Test-05");

			ContainsText(txt_profession, "Print User's Profession", "Test-06");

			if (chckElementPresent(txt_location)) {
				ContainsText(txt_location, "Print User's Location", "Test-07");
			}

			Boolean isTimeVisible = false;

			isTimeVisible = isDisplayed(txt_SentDate);

			if (isTimeVisible) {
				ContainsText(txt_SentDate, "Print User's Time info , invitation received", "Test-08");

			}
		} else {
			String HeaderText = (HeaderTextonStack).getText();
			System.out.println("Header Count: " + HeaderText);

			String profileName = (UserNameonStack).getText();
			System.out.println("Name:" + profileName);

			String casteDetail = (UserAgeHeightonStack).getText();
			System.out.println("Age and Height:" + casteDetail);

			String eduLocDetails = (UserLocationonStack).getText();
			System.out.println("Location:" + eduLocDetails);

			String Profession = (UserProfessiononStackAndroid).getText();
			System.out.println("Profession:" + Profession);

			String Date = (InvitationRcvdTime).getText();
			System.out.println("Time:" + Date);

		}

	}

	public void openProfilePageAndAccept() throws InterruptedException {

		profileinfo();

		openStackProfile();

		openProfilePageandAccept();// accept
	}

	public void openProfilePageAndDecline() throws InterruptedException {
		profileinfo();// second user in line

		openStackProfile();// second user in line info

		openProfilePageandDecline();// decline on profile page
	}

	public void checkDeclineOnStack() throws InterruptedException {
		profileinfo();// third user in line

		clickDeclineOnStack();// decline on stack third user
	}

	public void checkDeclineOnStack_Received(int invite_Count) throws InterruptedException {
		profileinfo();// third user in line

		clickDeclineOnStackReceived(invite_Count);// decline on stack third user
	}

	public void checkAcceptOnStack() throws InterruptedException {
		profileinfo();// fourth profile

		clickAcceptOnStack();// fourth profile accept on stack
	}

	public void checkAcceptOnStack_Received(int invite_Count) throws InterruptedException {
		profileinfo();// fourth profile

		clickAcceptOnStackReceived(invite_Count);// fourth profile accept on stack
	}

	public void swipeToDecline() throws InterruptedException {
		profileinfo();// swipe left decline

		hortizonalSwipeLeftOnStack();
	}

	public void swipeToDecline_Received(int invite_Count) throws InterruptedException {
		profileinfo();// swipe left decline

		hortizonalSwipeLeftOnStackReceived(invite_Count);
	}

	public void swipeToAccept() throws InterruptedException {
		profileinfo();

		hortizonalSwipeRightOnStack();// swipe right accept
	}

	public void swipeToAcceptReceived(int invite_Count) throws InterruptedException {
		profileinfo();

		hortizonalSwipeRightOnStackReceived(invite_Count);// swipe right accept
	}

	public void openStackProfile() throws InterruptedException

	{

		if (RunEnvironment.equals("iOSLocal")) {

			click(txt_ProfileName, "Click to open profile page", "Test-03");

			ContainsText(NameonProfilePge, "Open Profile Page", "Test-03");

			ContainsText(AgeHeightProfilePge, "Print Age Height Info", "Test-04");

			ContainsText(CommunityProfilePge, "Print User's Religion", "Test-05");

			ContainsText(CareerProfilePge, "Print User's Profession", "Test-06");

			if (chckElementPresent(LocationProfilePge)) {
				ContainsText(LocationProfilePge, "Print User's Location", "Test-07");
			}

		} else {
			click(OpenStackProfilePge, "Click to open profile page", "Test-03");

			Thread.sleep(2000);
			String Name = (NameonProfilePge).getText();
			System.out.println("Name:" + Name);

			String AgeandHeight = (AgeHeightProfilePge).getText();
			System.out.println("Age and Height:" + AgeandHeight);

			String Community = (CommunityProfilePge).getText();
			System.out.println("Community:" + Community);

			String Location = (LocationProfilePge).getText();
			System.out.println("Location:" + Location);

		}

	}

	public void openProfilePageandAccept() throws InterruptedException

	{

		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			boolean eleVisibility = chckElementPresent(profileAcceptAndroid);

			if (eleVisibility == true) {

				profileAcceptAndroid.click();

			}

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

			Thread.sleep(2000);
		}

		else {

			int new_Invtite_Count = 0;
			performAcceptOrDecline(profileAcceptAndroid, "Accept", "Test-02", "Click on Accept");

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

			if (BaseTest.UserType.equals("receivedpremium")) {
				boolean buttondisplay = false;
				buttondisplay = isDisplayed(sendMessageButtonAccept);
				if (buttondisplay) {
					InputValue(sendMessageTextAreaAccept,
							"Hi, I like your profile as well. We can take the communication further. Please feel free to contact me to take this conversation ahead.!!!",
							"Edited message", "Test-05");
					if (BaseTest.AutomationRunName.equals("Appium"))
						driver.hideKeyboard();
					sendMessageButtonAccept.click();
				} else {
					String header = (WriteMsgHeaderAndroid).getText();
					sa.assertEquals(header, "Write a Message", "Verify the text -- Write a Message");
					String savedraft = (cbSaveDraftAndroid).getText();
					System.out.println(savedraft);
					sa.assertEquals(savedraft, "Set as default (editable)", "'Set as default' text is not displayed");
					InputValue(edtMessage,
							"Hi, I like your profile. We can take the communication further. Please feel free to contact me to take this conversation ahead.!!!",
							"Edited message", "Test-05");
					cbSaveDraft.click();

					sa.assertEquals(SendSMSOKbtn.getText(), "Send", "'Send' text is not displayed");
					SendSMSOKbtn.click();
				}
			} else {
				if (isDisplayed(AcceptBannerdissmiss)) {
					AcceptBannerdissmiss.click();
				}
			}
		}
	}

	public void openProfilePageandDecline() throws InterruptedException

	{

		if (RunEnvironment.equals("iOSLocal")) {
			int new_Invtite_Count = 0;

			boolean eleVisibility = chckElementPresent(profileDeclineAndroid);

			if (eleVisibility == true) {
				profileDeclineAndroid.click();
			}

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

		else {

			int new_Invtite_Count = 0;

			performAcceptOrDecline(profileDeclineAndroid, "Decline", "Test-02", "Click on Decline");

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}
	}

	public void clickAcceptOnStack() throws InterruptedException {

		boolean eleVisibility;

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			eleVisibility = chckElementPresent(StackProfileAccept);

			if (eleVisibility == true) {

				StackProfileAccept.click();

			}

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

		else {
			int new_Invtite_Count = 0;
			performAcceptOrDecline(AcceptonStack, "Accept", "Test-03", "Click on Accept");
			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

	}

	public void clickAcceptOnStackReceived(int invite_Count) throws InterruptedException {

		boolean eleVisibility;

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			eleVisibility = chckElementPresent(StackProfileAccept);

			if (eleVisibility == true) {

				StackProfileAccept.click();

			}

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

		else {
			int new_Invtite_Count = 0;
			performAcceptOrDecline(AcceptonStack, "Accept", "Test-03", "Click on Accept");
			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount_Received(new_Invtite_Count, 1, invite_Count);

		}

	}

	public void clickDeclineOnStack() throws InterruptedException {
		boolean eleVisibility;

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			eleVisibility = chckElementPresent(StackProfileDecline);

			if (eleVisibility == true) {

				StackProfileDecline.click();

			}

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

		else {
			int new_Invtite_Count = 0;
			performAcceptOrDecline(DeclineonStack, "Decline", "Test-02", "Click on Decline");
			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}
	}

	public void clickDeclineOnStackReceived(int invite_Count) throws InterruptedException {
		boolean eleVisibility;

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			eleVisibility = chckElementPresent(StackProfileDecline);

			if (eleVisibility == true) {

				StackProfileDecline.click();

			}

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount_Received(new_Invtite_Count, 1, invite_Count);

		}

		else {
			int new_Invtite_Count = 0;
			performAcceptOrDecline(DeclineonStack, "Decline", "Test-02", "Click on Decline");
			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			verifyUpdateInviteCount_Received(new_Invtite_Count, 1, invite_Count);

		}
	}

	public void hortizonalSwipeLeftOnStackReceived(int invite_Count) throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "left");
			js1.executeScript("mobile: swipe", params);

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			Thread.sleep(3000);

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

		int new_Invtite_Count = 0;

		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.40);
		int startx = (int) (width * 0.85);
		int endx = (int) (width * 0.25);
		driver.swipe(startx, y, endx, y, 500);
		new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());
		Thread.sleep(2000);
		verifyUpdateInviteCount_Received(new_Invtite_Count, 1, invite_Count);
	}

	public void hortizonalSwipeLeftOnStack() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "left");
			js1.executeScript("mobile: swipe", params);

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			Thread.sleep(3000);

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}

		int new_Invtite_Count = 0;

		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.40);
		int startx = (int) (width * 0.85);
		int endx = (int) (width * 0.25);
		driver.swipe(startx, y, endx, y, 500);
		new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());
		Thread.sleep(3000);
		verifyUpdateInviteCount(new_Invtite_Count, 1);
	}

	public void hortizonalSwipeRightOnStackReceived(int invite_Count) throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "right");
			js1.executeScript("mobile: swipe", params);

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			Thread.sleep(3000);

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}
		int new_Invtite_Count = 0;
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.40);
		int startx = (int) (width * 0.25);
		int endx = (int) (width * 0.85);
		driver.swipe(startx, y, endx, y, 500);
		new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

		Thread.sleep(3000);

		verifyUpdateInviteCount_Received(new_Invtite_Count, 1, invite_Count);
	}

	public void hortizonalSwipeRightOnStack() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			int new_Invtite_Count = 0;

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "right");
			js1.executeScript("mobile: swipe", params);

			new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

			Thread.sleep(3000);

			verifyUpdateInviteCount(new_Invtite_Count, 1);

		}
		int new_Invtite_Count = 0;
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.40);
		int startx = (int) (width * 0.25);
		int endx = (int) (width * 0.85);
		driver.swipe(startx, y, endx, y, 500);
		new_Invtite_Count = getInvitationCount(lbl_Member_Waiting.getText());

		Thread.sleep(3000);

		verifyUpdateInviteCount(new_Invtite_Count, 1);
	}

	public void performAcceptOrDecline(WebElement elementName, String status, String tcName, String message)
			throws InterruptedException {

		if (status.equals("Accept")) {
			Thread.sleep(2000);

			if (isDisplayed(AcceptonStackText)) {
				AssertEquals(AcceptonStackText, status, "Verify the text Accept");// Changes
																					// made
																					// as
																					// the
																					// text
																					// for
																					// Accept
																					// button
																					// has
																					// diffrent
																					// ID
			} else {
				AssertEquals(elementName, status, "Verify the text Accept");

			}

			Thread.sleep(1000);

			click(elementName, message, tcName);

			Thread.sleep(1000);

		} else {
			Thread.sleep(1000);

			AssertEquals(elementName, status, "Verify the text Decline");

			Thread.sleep(1000);

			click(elementName, message, tcName);

			Thread.sleep(1000);

		}
	}

	public void CloseStack() throws InterruptedException

	{

		Thread.sleep(2000);

		click(CloseStackicon, "Click to close stack ", "Test-03");

		Boolean isAppRatingVisible = false;
		isAppRatingVisible = isDisplayed(AppRatingLayer);
		if (isAppRatingVisible) {
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		}

		Thread.sleep(2000);

		// Text are different in both the Platform hence if condition is used
		// here
		if (RunEnvironment.equals("iOSLocal")) {
			AssertEquals(RespDescriptionAndroid, "Members are eagerly awaiting your reply", "Verify the text");
			AssertEquals(QuickPhaseBtn, "Quick Response", "Verify the text Quick Response");
		} else {
			AssertEquals(RespDescriptionAndroid, "Members are eagerly awaiting your reply.", "Verify the text");
			AssertEquals(QuickPhaseBtn, "Respond Now", "Verify the text Quick Response");

		}

		if (RunEnvironment.equals("androidLocal")) {
			click(QuickPhaseBtn, "Click on Quick Phase Btn", "Test-02");

			Thread.sleep(2000);

			ContainsText(HeaderTextonStack, "Print Header 1st Line", "Test-01");

			Thread.sleep(2000);

			click(CloseStackicon, "Click to close stack ", "Test-03");

			Thread.sleep(2000);

			String profileName = (RcvdUserName).getText();
			System.out.println("Name:" + profileName);

			String casteDetail = (RcvdUserAgeHgt).getText();
			System.out.println("Age and Height:" + casteDetail);

			String eduLocDetails = (RcvdUserEduLoc).getText();
			System.out.println("Location and Education:" + eduLocDetails);

			String Date = (RcvdUserTime).getText();
			System.out.println("Time:" + Date);

			Thread.sleep(4000);

			click(OpenRcvdProfilePge, "Click to open profile page ", "Test-03");

			AssertEquals(DeclineRcvdProfilePge, "Decline", "Verify the text Decline");

			click(DeclineRcvdProfilePge, "Click on Decline", "Test-02");

			Thread.sleep(2000);

			click(BtnNxt, "Go to Next profile page ", "Test-03");

			click(BtnNxt, "Go to Next profile page ", "Test-03");

			AssertEquals(ViewContactRcvdProfilePge, "View Contact", "Verify the text View Contact");

			click(ViewContactRcvdProfilePge, "Click on View Contact", "Test-02");

			driver.navigate().back();

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		}

	}

	public void CloseStackPremium() throws InterruptedException

	{
		click(CloseStackicon, "Click to close stack ", "Test-03");
		Thread.sleep(2000);
		AssertEquals(RespDescriptionAndroid, "Members are eagerly awaiting your reply.", "Verify the text");
		AssertEquals(QuickPhaseBtn, "Quick Response", "Verify the text Quick Response");
		click(QuickPhaseBtn, "Click on Quick Phase Btn", "Test-02");
		Thread.sleep(2000);

		ContainsText(HeaderTextonStack, "Print Header 1st Line", "Test-01");

		Thread.sleep(2000);

		click(CloseStackicon, "Click to close stack ", "Test-03");

		Thread.sleep(2000);

		String profileName = (RcvdUserName).getText();
		System.out.println("Name:" + profileName);

		String casteDetail = (RcvdUserAgeHgt).getText();
		System.out.println("Age and Height:" + casteDetail);

		String eduLocDetails = (RcvdUserEduLoc).getText();
		System.out.println("Location and Education:" + eduLocDetails);

		String Date = (RcvdUserTime).getText();
		System.out.println("Time:" + Date);

		Thread.sleep(4000);

		click(OpenRcvdProfilePge, "Click to open profile page ", "Test-03");

		Boolean isHiddenVisible = false;
		isHiddenVisible = isDisplayed(HiddenProfile);
		if (isHiddenVisible) {
			click(BtnNxt, "Go to Next profile page ", "Test-03");
			click(BtnNxt, "Go to Next profile page ", "Test-03");

		}

		AssertEquals(DeclineRcvdProfilePge, "Decline", "Verify the text Decline");
		click(DeclineRcvdProfilePge, "Click on Decline", "Test-02");
		Thread.sleep(2000);

		click(BtnNxt, "Go to Next profile page ", "Test-03");
		click(BtnNxt, "Go to Next profile page ", "Test-03");

		AssertEquals(ViewContactRcvdProfilePge, "View Contact", "Verify the text View Contact");
		AssertEquals(AcceptRcvdProfilePge, "Accept", "Verify the text Write Message");

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	public void ClickSentTab() {

		click(sentTab, "Click on Sent tab", "Test-03");

	}

	public void ClickConnectNow() {
		click(btnConnectNow, "Click on Connect Now Button", "Test-01");

	}

	public void MyMatchestab() throws InterruptedException
	{

		Thread.sleep(2000);

		AssertEquals(carouselconnect, "Connect Now", "Verify the text Connect Now");
		click(carouselconnect, "Click connect in carousel button  ", "Test-07");
		if (isDisplayed(sendMessageOnConnctNowAndroid)) {
			InputValue(sendMessageOnConnctNowAndroid, "Hello, How are you?", "Edited message", "EditEmail-05");
			AssertEquals(sendMessageOnConnctNowAndroid, "Hello, How are you?",
					"Verify the text when clicked and edited as new");

			click(sendMessageButtonAndroid, "Click to send message", "Test-08");
		}
		Thread.sleep(3000);

		scrollDownToElement(myMatchesConnectNow);
		AssertEquals(myMatchesConnectNow, "Connect Now", "Verify the text Connect Now");
		click(myMatchesConnectNow, "Click to send message", "Test-08");
		if (isDisplayed(sendMessageOnConnctNowAndroid)) {
			InputValue(sendMessageOnConnctNowAndroid, "Hello, How are you", "Edited message", "EditEmail-05");
			AssertEquals(sendMessageOnConnctNowAndroid, "Hello, How are you",
					"Verify the text when clicked and edited as new");
			click(sendMessageButtonAndroid, "Click to send message", "Test-08");
			Thread.sleep(3000);
		}

	}

	public void SendMsg() {
		click(SendMsgbtn, "Click to send message", "Test-08");
	}

	public void ScrollandConnectinListing() {
		ScrollTill(btnConnectNow, "Scroll till Connect CTA", "Test-08");
		click(btnConnectNow, "Click to send message", "Test-08");
	}

	public void Profilepage() {
		click(Openprofilepage, "Click to send message", "Test-08");
	}

	public void InboxGotIt() {
		click(btnGotItinInbox, "Click on Got it", "Test-02");
	}

	@SuppressWarnings("unchecked")
	public void ClickSentTabForSaveDraft() throws InterruptedException {

		click(topNavBar.get(2), "Click on Sent Tab", "Test-08");
		Thread.sleep(3000);

		scrollDownToElement(profileCardName);
		waitForSometime(2000);
		click(profileCardName, "Open profile page", "");
		waitForSometime(2000);
		boolean flag = false;
		while (!flag) {
			click(imgArrowAndroid, "Click Drop Down Icon", "Test-03");
			waitForSometime(2000);
			if (DropdownText.get(0).getText().equals("Remind")) {
				AssertEquals(DropdownText.get(0), "Remind", "Verify the text -- Remind");
				click(DropdownText.get(0), "Click 1st Value", "Test-03");
				flag = true;
			} else {
				waitForSometime(2000);
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				click(SwipeNext, "Click to Swipe next profile", "Test-03");
				waitForSometime(2000);
			}
		}

		waitForSometime(2000);
		if (isDisplayed(WriteMsgHeader)) {
			BasePageActions.AssertEquals(RequestSentText, "Reminder can only be sent only after 24 hrs", "");
			click(OkBtn2, "click on Ok", "");
		} else if (isDisplayed(edtMessage)) {
			InputValue(edtMessage, "Hi, How are you?", "Edited message", "Test-05");
			AssertEquals(edtMessage, "Hi, How are you?", "Verify the text when clicked and edited as new");
			AssertEquals(cbSaveDraftAndroid, "Set as default (editable)",
					"Verify the text when clicked n Cancel invitations");
			click(cbSaveDraftAndroid, "Click CheckBox ", "Test-03");
			click(SendMsgbtn, "Click to send message", "Test-08");

		}

		waitForSometime(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	public void ClickAcceptedtab() throws InterruptedException {
		Thread.sleep(4000);
		click(topNavBar.get(1), "Click Accepted Tab", "Test-08");
	}

	public void ClickReceivedtab() throws InterruptedException

	{
		waitForSometime(3000);
		click(topNavBar.get(0), "Click Received Tab", "Test-08");
		waitForSometime(3000);
		openProfilePageAndAccept();
		openProfilePageAndDecline();
		checkDeclineOnStack();
		checkAcceptOnStack();

	}

	public void RequestActions() throws InterruptedException {
		Thread.sleep(3000);

		scrollDownTillRemindMessage();

		scrollDownToElement(btn_Request_Sent_RequestTab);

		click(OpnProfile, "Click to Open Profile page", "Test-03");

		if (VerifyTextPhotoRequested.getText().equals("Photo Requested")) {
			String verifyTextPhotoRequested = (VerifyTextPhotoRequested).getText();
			System.out.println("Photo Requested: " + verifyTextPhotoRequested);

		} else {
			AssertEquals(RequestAPhotoBtnonProfilePge, "Request a Photo", "Verify the text Request a Photo");
			click(RequestAPhotoBtnonProfilePge, "click button", "Test-04");

			AssertEquals(PhotoRequestSentPopUpHdr, "Photo Request Sent", "Verify the text Photo Request Sent");
			String VerifyTextPhotoRequestSent = (PhotoRequestSentPopUpText).getText();
			System.out.println("Photo Request Sent Text: " + VerifyTextPhotoRequestSent);
			click(PhotoRequestSentPopUpOKbtn, "Close Ok", "Test-05");
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		}

		while (!TakeAction.isDisplayed()) {
			click(NextProfileBtn, "Go to Next ptofile", "Test-05");
		}

		click(TakeAction, "Click Connect", "Test-05");

		String VerifyTextRequest = (VerifyTextRequestSent).getText();
		System.out.println("Request Sent: " + VerifyTextRequest);

		String Info = (InfoLayer).getText();
		System.out.println("Info on profile card : " + Info);

	}

	public void RequestActionsWithoutAction() throws InterruptedException {
		click(OpnProfile, "Click to Open Profile page", "Test-08");

		String verifyTextPhotoRequested = (VerifyTextPhotoRequested).getText();
		System.out.println("Photo Requested: " + verifyTextPhotoRequested);

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		String VerifyTextRequestSentonListing = (VerifyTextRequestSent).getText();
		System.out.println("Request Sent: " + VerifyTextRequestSentonListing);

		String Info = (InfoLayer).getText();
		System.out.println("Info on profile card : " + Info);

	}

	public void clickOnDeleted() throws Exception {
		click(topNavBar.get(4), "Click Sent Items", "Inbox-01");

	}

	public void Scrolljust(WebElement Locator, String Description, String TCID) {

		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Profiles you Ignored\"));");

	}

	public void AssertFirstName(WebElement locator, String expectedText, String description) {
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

	public void scrollDownTillRemindMessage() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.40)).waitAction(4000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public void verifyContactDataGeneric(int rowNumber, String elementToVerify_1, boolean flag, String Message,
			String Message_2) {

		String actualText1;
		boolean actualElement;

		@SuppressWarnings("unchecked")
		List<WebElement> viewContactDetails = driver
				.findElements(By.xpath("//XCUIElementTypeCell[@name=\"SMSCallCell\"]"));

		@SuppressWarnings("unused")
		int numberOfRows = viewContactDetails.size();

		actualText1 = viewContactDetails.get(rowNumber)
				.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"lblTitle.label\"]")).getText();

		actualElement = isDisplayed(viewContactDetails.get(rowNumber)
				.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"lblValue.label\"]")));

		Assert.assertEquals(actualText1, elementToVerify_1, Message);

		Assert.assertTrue(actualElement, Message_2);

	}

	public static int getInvitationCount(String str) {

		int length = str.length();

		String result = "";

		for (int i = 0; i < length; i++) {
			Character character = str.charAt(i);
			if (Character.isDigit(character)) {
				result += character;
			}
		}

		System.out.println("result is: " + result);

		return Integer.parseInt(result);
	}

	public void verifyUpdateInviteCount(int actual_Count, int decreaseValue) {

		InboxResponseTest.invite_Count = InboxResponseTest.invite_Count - decreaseValue;

		Assert.assertEquals(actual_Count, InboxResponseTest.invite_Count);

	}

	public void verifyUpdateInviteCount_Received(int actual_Count, int decreaseValue, int invite_Count) {

		invite_Count = invite_Count - decreaseValue;

		Assert.assertEquals(actual_Count, invite_Count);

	}

	public String declineUserFromProfilePage(WebElement dropdownbutton) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String profilename = "";
		Thread.sleep(1000);
		click(SwipeNext, "Click on next profile on profile page", "");
		boolean flag = false;
		int count = 0;
		while (!flag) {
			// if Delete profile is found in swipe next operation
			while (!isDisplayedAfterWait(NameonProfilePge, 3)) {
				click(SwipeNext, "Click on next profile on profile page", "");
			}
			profilename = NameonProfilePge.getText();
			click(dropdownbutton, "Click on dropdown button", "");
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (isDisplayedAfterWait(dd_DeclineProfile, 3)) {
					Thread.sleep(1000);
					dd_DeclineProfile.click();
					flag = true;
				} else {
					System.out.println("count is" + count);
					waitForSometime(1000);
					driver.navigate().back();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");
					if (count == 3) {
						flag = true;
					}
					count++;

				}
			} else {

				if (isDisplayedAfterWait(dd_DeclineProfile, 3)) {
					click(dd_DeclineProfile, "Click 1st Value", "Test-03");
					flag = true;
				} else {
					System.out.println("count is" + count);
					waitForSometime(2000);
					btn_dd_Cancel.click();
					SwipeNext.click();
					if (count == 3) {
						flag = true;
					}
					count++;

				}

			}

		}

		if (count < 3) {

			Thread.sleep(3000);
			click(SwipePrev, "Go back to previous profile", "");
			if (isDisplayedAfterWait(DeclineMemberTxt, 3)) {
				sa.assertEquals(DeclineMemberTxt.getText(), "Declined Member", "Declined Member text not displayed");

				sa.assertTrue(chckElementPresent(btn_AcceptAfterDecline), "Change your mind option is not seen");
			} else {
				sa.assertTrue(chckElementPresent(txt_message_dropdownactions), "Decline Message is not seen");
				sa.assertTrue(chckElementPresent(accept_connect_btn_new), "Accept Button is not seen");
			}


			click(SwipeNext, "Click on next profile on profile page", "");

			System.out.println("Declined profile :" + profilename);

			sa.assertAll();
		}
		return profilename;
	}

	public String cancelRequestFromProfilePage(WebElement dropdownbutton) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String profilename = "";
		waitForSometime(1000);
		click(SwipeNext, "Click on next profile on profile page", "");
		boolean flag = false;
		int count = 0;
		while (!flag) {
			// if Delete profile is found in swipe next operation
			while (!isDisplayedAfterWait(NameonProfilePge, 3)) {
				click(SwipeNext, "Click on next profile on profile page", "");

			}
			profilename = NameonProfilePge.getText();
			click(dropdownbutton, "Click on dropdown button", "");
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (isDisplayedAfterWait(dd_CancelRequest, 3)) {
					Thread.sleep(1000);
					dd_CancelRequest.click();
					flag = true;
				}

				else {
					System.out.println("count is" + count);
					waitForSometime(1000);
					driver.navigate().back();
					click(SwipeNext, "Click on next profile on profile page", "");
					
					if (count == 3) {
						flag = true;
					}
					count++;
				}
			} else {

				if (isDisplayedAfterWait(dd_CancelRequest, 3)) {
					click(dd_CancelRequest, "Click on Cancel request from dropdown options", "");
					flag = true;
				} else {

					waitForSometime(2000);
					btn_dd_Cancel.click();
					Thread.sleep(2000);
					SwipeNext.click();
					if (count == 2) {
						flag = true;
					}
					count++;

				}

			}

		}

		if (count < 2) {
			Thread.sleep(3000);
			click(SwipePrev, "Go back to previous profile", "");
			

			if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
				Thread.sleep(3000);

				if (chckElementPresent(CancelMemberTxt_Premium)) {
					Thread.sleep(2000);
					sa.assertTrue(isDisplayedAfterWait(CancelMemberTxt_Premium, 3),
							"Cancel text is not seen  for Premium Profile");
				} else {
					Thread.sleep(2000);
					sa.assertTrue(isDisplayedAfterWait(CancelMemberTxt, 3), "Cancel text is not seen for Free Profile");
				}

			}

			else {
				if (isDisplayedAfterWait(CancelMemberTxt, 3)) {
					sa.assertEquals(CancelMemberTxt.getText(), "Cancelled Member",
							"Cancelled Member text not displayed");
					sa.assertTrue(isDisplayedAfterWait(myMatchesConnectNow, 3), "Connect now button not visible");
				} else {
					sa.assertTrue(chckElementPresent(txt_message_dropdownactions));
					sa.assertTrue(chckElementPresent(accept_connect_btn_new));
				}
			}

			click(SwipeNext, "Click on next profile on profile page", "");

			System.out.println("Cancelled profile :" + profilename);

			sa.assertAll();
		}

		return profilename;
	}

	public String remindFromProfilePage(WebElement dropdownbutton) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String profilename = "";
		click(SwipeNext, "Click to Swipe next profile", "Test-03");
		waitForSometime(1000);
		boolean flag = false;
		while (!flag) {
			profilename = NameonProfilePge.getText();
			click(dropdownbutton, "Click Drop Down Icon", "Test-03");
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (isDisplayedAfterWait(dd_Remind, 3)) {
					dd_Remind.click();
					flag = true;
				}

				else {
					waitForSometime(2000);
					driver.navigate().back();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			} else {

				if (isDisplayedAfterWait(btnRemindOnSentTab, 3)) {
					click(btnRemindOnSentTab, "Click 1st Value", "Test-03");
					flag = true;
				} else {

					waitForSometime(2000);
					btn_dd_Cancel.click();
					Thread.sleep(2000);
					SwipeNext.click();

				}

			}

		}

		if (isDisplayedAfterWait(txt_RemindOnSentTab, 3)) {
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				waitForSometime(1000);
				sa.assertTrue(txt_RemindOnSentTab.getText().contains("Reminder can only be sent only after 24 hrs"));
			} else {
				waitForSometime(2000);
				sa.assertTrue(txt_RemindOnSentTab.getText().contains("Visit again after 24 hours to send a Reminder."));

			}

			click(OkBtn2, "Dismiss the Tool Tip", "IS03");
		} else if (isDisplayedAfterWait(edtMessage, 3) && RunEnvironment.equalsIgnoreCase("androidLocal")) {
			InputValue(edtMessage, "Hello", "Edit reminder message", "");
			click(SendSMSOKbtn, "click on send button", "");

		}

		click(SwipeNext, "Click to Swipe next profile", "Test-03");

		sa.assertAll();
		return profilename;
	}

	public String remindFromProfilePage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String profilename = "";
		waitForSometime(2000);
		SwipeNext.click();
		waitForSometime(2000);
		boolean flag = false;
		while (!flag) {
			waitForSometime(2000);
			profilename = NameonProfilePge.getText();
			DropDownIcon.click();
			waitForSometime(2000);
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (DropdownText.get(0).getText().contains("Remind")) {
					click(DropdownText.get(0), "Click 1st Value", "Test-03");
					flag = true;
				} else if (DropdownText.get(1).getText().contains("Remind")) {
					click(DropdownText.get(1), "Click 1st Value", "Test-03");
					flag = true;
				}

				else {
					waitForSometime(2000);
					driver.navigate().back();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			} else {

				if (isDisplayedAfterWait(btnRemindOnSentTab, 3)) {
					click(btnRemindOnSentTab, "Click 1st Value", "Test-03");
					flag = true;
				} else {

					waitForSometime(2000);
					btn_dd_Cancel.click();
					Thread.sleep(2000);
					SwipeNext.click();

				}

			}

		}

		if (isDisplayedAfterWait(txt_RemindOnSentTab, 3)) {
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				waitForSometime(2000);
				sa.assertTrue(txt_RemindOnSentTab.getText().contains("Reminder can only be sent only after 24 hrs"));
			} else {
				waitForSometime(2000);
				sa.assertTrue(txt_RemindOnSentTab.getText().contains("Visit again after 24 hours to send a Reminder."));

			}

			click(OkBtn2, "Dismiss the Tool Tip", "IS03");
		} else if (isDisplayedAfterWait(edtMessage, 3) && RunEnvironment.equalsIgnoreCase("androidLocal")) {
			InputValue(edtMessage, "Hello", "Edit reminder message", "");
			click(SendSMSOKbtn, "click on send button", "");

		}

		click(SwipeNext, "Click to Swipe next profile", "Test-03");

		sa.assertAll();
		return profilename;
	}

	public void verifyFilterOptionsReceivedTab(String option) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		click(btnFilter, "Click on filter button", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text , '" + option + "')]")).click();
		waitForElementToBeDisplayed(acceptedTabSubTitle, "wait for filter to apply", "");
		sa.assertTrue(acceptedTabSubTitle.getText().contains(option),
				"Filter value does not match on listing page - " + option);
		sa.assertAll();

	}

	public void verifyFilterOptionsReceivedTabIOS(WebElement elementName) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		waitForElementToBeDisplayed(btnFilter, "wait for Filter button to be visible", "");
		Thread.sleep(3000);
		btnFilter.click();
		Thread.sleep(2000);
		waitForElementToBeDisplayed(elementName, "wait for filter to apply", "");
		elementName.click();
		sa.assertAll();

	}

	public void verifyDropDownOnSentTabAndroidListing() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		List<String> dropDownList = new ArrayList<>();
		dropDownList.add("Remind");
		dropDownList.add("Cancel request");
		
		
		scrollDownToElement(dropDownButtonAndroid);// search for drop down button on sent page
		click(dropDownButtonAndroid, "click on drop down", "IS03");// click on dropdown button
		waitForSometime(1000);

		int size = DropdownText.size();
		System.out.println(size);

		for (WebElement e : DropdownText) {
			for (String s : dropDownList) {
				if (e.getText().contains(s))
					sa.assertTrue(e.getText().contains(s), "Dropdown options does not match");

			}
		}
		
		//sa.assertEquals(DropdownText.get(0).getText(), "Cancel request","Cancel Request option not available in dropdown");
		Thread.sleep(1000);
		driver.navigate().back();
		sa.assertAll();
	}

	public void verifyDropDownOnSentTabIOSListing() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		waitForSometime(2000);
		scrollDownToElement(dropDownButtonAndroid);// search for drop down button on sent page
		click(dropDownButtonAndroid, "click on drop down", "IS03");// click on dropdown button
		waitForSometime(2000);
		sa.assertEquals(btnCancelRequestSentTab.getText(), "Cancel Request",
				"Cancel Request option not available in dropdown");
		sa.assertEquals(btnBlockProfileSentTab.getText(), "Block Profile",
				"Block Profile option not available in dropdown");
		sa.assertEquals(btnReportProfileSentTab.getText(), "Report Profile/Photo",
				"Report Profile/Photo option not available in dropdown");

		Thread.sleep(1000);
		btnCancelSentTab.click();
		sa.assertAll();
	}

	public void verifyRemindSentTab() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		scrollDownToElement(dropDownButtonAndroid);// search for drop down button on sent page
		click(dropDownButtonAndroid, "click on drop down", "IS03");// click on dropdown button
		waitForSometime(2000);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			click(DropdownText.get(0), "click on remind button", "verifyRemindCTAOnSentListing");
			waitForSometime(2000);
			sa.assertTrue(txt_RemindOnSentTab.getText().contains("Reminder can only be sent only after 24 hrs"));
		} else {

			btnRemindOnSentTab.click();

			waitForSometime(2000);

			if (chckElementPresent(txt_RemindOnSentTab)) {
				sa.assertTrue(txt_RemindOnSentTab.getText().contains("Visit again after 24 hours to send a Reminder."));
			}

		}

		click(OkBtn2, "Dismiss the Tool Tip", "IS03");

		sa.assertAll();
	}

	public void verifyCancelRequestSentTab(MatchesPage matchespage) throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		waitForSometime(1000);
		scrollDownToElement(dropDownButtonAndroid);// search for drop down button on sent page
		click(dropDownButtonAndroid, "click on drop down", "IS03");// click on dropdown button
		//waitForSometime(2000);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			click(DropdownText.get(0), "click on Cancel Request button", "verifyCancelCTAOnSentListing");
			scrollDownToElement(deletedMessageAndroid);
			waitForSometime(1000);
			sa.assertEquals(getText(deletedMessageAndroid, "Get Cancelled Invitation text"),
					"You Cancelled your Invitation.", "Cancelled Invitation text doesn't match");
			sa.assertEquals(getText(connectNowButtonAndroid, "Get Connect Now button text"), "Connect Now",
					"Connect Now button not displayed");

			click(connectNowButtonAndroid, "Click on connect Now", "");
			matchespage.sendMessageOnConnectPremium();
			matchespage.verifyCTAAFterConnect_DR();

		} else {
			btnCancelRequestSentTab.click();
			waitForSometime(2000);
			// CTA SendInterest Hover text is seen on Connect Now button for iOS
			sa.assertEquals(getText(connectNowButtonAndroid, "Get Connect Now button text"), "CTA SendInterest Hover",
					"Connect Now button not displayed");
			click(connectNowButtonAndroid, "Click on connect Now", "");
			matchespage.sendMessageOnConnectPremium();
			matchespage.verifyCTAAFterConnect_DR();

		}

		sa.assertAll();
	}

	public void verifyAcceptOnReceivedListing(MatchesPage matches, String options) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		if (options.equalsIgnoreCase("Premium")) {
			verifyFilterOptionsReceivedTab("Premium");
		}
		scrollDownToElement(btn_Accept_DeleteTab);
		Thread.sleep(1000);
		String acceptedProfileOnReceivedTab = RcvdUserName.getText().split(" ")[0];
		btn_Accept_DeleteTab.click();

		if (UserType.contains("free")) {
			if (isDisplayedAfterWait(cardBannerPersonalized_btnViewPlans, 2)) {
				waitForElementToBeDisplayed(cardBannerPersonalized_btnViewPlans,
						"Wait for view plans button to be visible", "");
				sa.assertEquals(cardBannerPersonalized_btnViewPlans.getText(), "View Plans",
						" View Plans text does not match");
				cardBannerPersonalized_btnViewPlans.click();
				waitForElementToBeDisplayed(upgradePageHeader, "wait for payment page to load", "");
				Thread.sleep(2000);
				driver.navigate().back();
			}
		} else {

			if (isDisplayedAfterWait(sendMessageTextAreaAccept, 2)) {
				sa.assertEquals(sendMessageHeaderAccept.getText(), "It's an Accept!");
				InputValue(sendMessageTextAreaAccept, "Hello", "Input message after sending connect", "");
				sendMessageButtonAccept.click();
				Thread.sleep(1000);
				matches.verifyCTAAFterConnect_DR();
			}

		}

		navigateToSpecifiedMatchesTab(acceptedTab, "Navigate to accepted tab");
		Thread.sleep(2000);
		scrollUp();
		scrollUp();
		// waitForPageToLoad();
		Thread.sleep(2000);
		scrollDownToElement(RcvdUserName);
		String acceptedProfileOnAcceptedTab = RcvdUserName.getText().split(" ")[0];
		sa.assertEquals(acceptedProfileOnReceivedTab, acceptedProfileOnAcceptedTab);
		navigateToSpecifiedMatchesTab(receivedTab, "Navigate to Received tab");
		sa.assertAll();

	}

	public void verifyDeclineOnReceivedListing() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		scrollDownToElement(btn_Decline);
		Thread.sleep(1000);
		String declinedProfileOnReceivedTab = RcvdUserName.getText().split(" ")[0];
		btn_Decline.click();
		waitForElementToBeDisplayed(deletedMessageAndroid, "Wait for text to display", "ReceivedTab");
		sa.assertTrue(isDisplayedAfterWait(deletedMessageAndroid, 2), "Declined Invitation text not present");
		scrollDownToElement(changedYourMind);
		Thread.sleep(1000);
		sa.assertEquals(changedYourMind.getText(), "Changed your mind?", "Changed your mind text not present");
		sa.assertTrue(isDisplayedAfterWait(btn_Accept, 2), "Accept Button is not visible");

		navigateToSpecifiedMatchesTab(DeletedTab, "Navigate to Inbox Deleted Tab");
		Thread.sleep(2000);
		scrollUp();
		scrollUp();
		Thread.sleep(2000);
		scrollDownToElement(RcvdUserName);
		String declinedProfileOnDeletedTab = RcvdUserName.getText().split(" ")[0];
		sa.assertEquals(declinedProfileOnReceivedTab, declinedProfileOnDeletedTab,
				"Profile name on received and deleted tab does not match");
		if (UserType.contains("premium")) {
			navigateToSpecifiedMatchesTab(sentTab, "Navigate to Sent tab");

		}
		navigateToSpecifiedMatchesTab(acceptedTab, "Navigate to Accepted tab");
		navigateToSpecifiedMatchesTab(receivedTab, "Navigate to Received tab");
		sa.assertAll();

	}

	public void verifyAcceptFromProfilePage(String position, MatchesPage matches) throws InterruptedException {

		while (!isDisplayedAfterWait(btn_Accept_DeleteTab, 2)) {
			click(SwipeNext, "Go to next profile", "");
		}

		if (position.equalsIgnoreCase("bottom")) {
			scrollDown();
			scrollDown();
			Thread.sleep(1000);
		}

		btn_Accept_DeleteTab.click(); // click on Accept button on profile page

		if (UserType.contains("free")) {
			if (isDisplayedAfterWait(AcceptStopPageUpgrade, 3)) {
				AcceptStopPageUpgrade.click();
				waitForElementToBeDisplayed(matches.upgradePageHeader, "wait for payment page to load", "");
				Thread.sleep(2000);
				driver.navigate().back();

			}
		} else {

			if (isDisplayedAfterWait(edtMessage, 5)) {
				Thread.sleep(1000);
				SendSMSOKbtn.click();
			}

		}

		click(SwipePrev, "GO to accepted profile", "");
		matches.verifyCTAAFterConnect_DR();
		matches.verifyShaadiChatCTA();
		matches.verifyCallCTA();
		matches.verifyWhatsAppCTA();

		click(SwipeNext, "GO to accepted profile", "");

	}

	public void verifyDeclineFromProfilePage(String position, MatchesPage matches) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		while (!isDisplayedAfterWait(btn_Decline_DeleteTab, 2)) {
			click(SwipeNext, "Go to next profile", "");
		}

		if (position.equalsIgnoreCase("bottom")) {
			scrollDown();
			scrollDown();
			Thread.sleep(1000);
		}
		btn_Decline_DeleteTab.click();
		click(SwipePrev, "Go to next profile", "");
		waitForElementToBeDisplayed(declinedMemberTextAndroid, "wait for text", "ReceivedTab");
		sa.assertEquals(declinedMemberTextAndroid.getText(), "Declined Member",
				"Declined Member text not shown after declining member from profile page");
		sa.assertTrue(profileAcceptAndroid.isDisplayed());
		sa.assertAll();

	}

	public void navigateToProfilePageFromListing() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		scrollDownToElement(profileCardName);
		Thread.sleep(1000);
		String name = profileCardName.getText().split(" ")[0];
		profileCardName.click();
		waitForElementToBeDisplayed(profileName, "Wait for profile page", "");
		sa.assertEquals(name, profileName.getText().split(" ")[0],
				"Profile name on listing and profile page does not match");
		Thread.sleep(2000);
		sa.assertAll();
	}

	/*--------------------------------Inbox Received Actions -----------------------------*/

	static String initInvitationCnt;

	public void checkAcceptDeclineFunctionality(String btnType, String msg, String msg2) throws InterruptedException {

		boolean setConnectionFlag;

		Thread.sleep(3000);

		if (chckElementPresent(btnCloseFrstAcptWindow) == true) {

			Assert.assertTrue(chckElementPresent(driver.findElementByXPath(btnType)), msg);

			String accptdUserName = txtPrfName.getText();

			driver.findElementByXPath(btnType).click();

			// Condition Added to check if the above profile is not a single profile is the
			// cards

			if (chckElementPresent(btnQuckResponse) != true) {

				// Name of the Profile next in queue who's name should be seen
				String nxtUserName = txtPrfName.getText();

				if (accptdUserName.equalsIgnoreCase(nxtUserName) == false) {

					// Since two names are not equal connection request is send to the user
					setConnectionFlag = true;

					Assert.assertTrue(setConnectionFlag, msg2);
				}
			}

		}

		else {

			if (chckElementPresent(txtNoPendingInvites) == true) {

				Assert.assertEquals(txtNoPendingInvites.getText(), "There are no Pending Invitations to Connect",
						"No Pending Connections Message is Seen");
			}

			else {
				Assert.fail("None of the above Condition is satisfied");
			}
		}
	}

	public void checkAcceptDeclineOnProfile(WebElement btnAction, WebElement btnActionTab, WebElement profileName,
			String msg, String msg1, boolean accptFlag) throws InterruptedException {

		String getUserName = null;

		if (chckElementPresent(btnAction) == true) {

			getUserName = profileName.getAttribute("value");

			if (InboxReceivedTest.setUserType.equals("Free")) {

				btnAction.click();

				if (accptFlag == true) {
					checkFirstAccept(getUserName);
				}

			} else {

				if (btnAction == btnDecline) {

					btnAction.click();

				} else {

					btnAction.click();

					InputValue(DashboardObjects.textviewMessage, "Hi, Can you please accept my connection",
							"Input send description", "Daily-06");

					click(DashboardObjects.btnSend, "Click Send Button", "Daily-06");

					if (accptFlag == true) {

						checkProfileStatus(btnActionTab, getUserName, msg1);

						btnRecievedTab.click();

						// checkFirstAccept(getUserName);
					}

				}
			}

			Thread.sleep(3000);

			if (accptFlag == false)
				checkProfileStatus(btnActionTab, getUserName, msg1);
		}

	}

	public void checkDeclineOnProfile(WebElement btnAction, WebElement btnActionTab, WebElement profileName,
			String msg, String msg1, boolean accptFlag) throws InterruptedException {

		String getUserName = null;

		if (chckElementPresent(btnAction) == true) {

			getUserName = profileName.getAttribute("value");

			if (InboxReceivedTest.setUserType.equals("Free")) {

				btnAction.click();

				if (accptFlag == true) {
					checkFirstAccept(getUserName);
				}

			} else {

				if (chckElementPresent(btnAction) == chckElementPresent(btnDecline)) {

					btnAction.click();

				} else {

					InputValue(DashboardObjects.textviewMessage, "Hi, Can you please accept my connection",
							"Input send description", "Daily-06");

					click(DashboardObjects.btnSend, "Click Send Button", "Daily-06");

					if (accptFlag == true) {
						checkFirstAccept(getUserName);
					}

				}
			}

			Thread.sleep(3000);

			if (accptFlag == false)
				checkProfileStatus(btnActionTab, getUserName, msg1);
		}

	}

	public void checkProfileStatus(WebElement btnActionTab, String getuserName, String msg)
			throws InterruptedException {

		boolean checkProfileStatus = false;
		String actualUserName;

		if (btnActionTab == btnAcceptedTab) {

			scrollUpToElement(btnQuckResponse);

			btnAcceptedTab.click();

			Thread.sleep(3000);

			if (chckElementPresent(btnCloseUpGrdWnd) == true) {
				btnCloseUpGrdWnd.click();
			}

			Thread.sleep(2000);

			actualUserName = txtProfileName.getAttribute("value");

			if (actualUserName.equals(getuserName)) {
				checkProfileStatus = chckElementPresent(driver.findElement(By.name(getuserName)));
			}

		}

		else {

			scrollUpToElement(btnQuckResponse);

			btnSentItemsTab.click();

			btnDeletedTab.click();

			Thread.sleep(3000);

			actualUserName = txtProfileName.getAttribute("value");

			if (actualUserName.equals(getuserName)) {
				checkProfileStatus = chckElementPresent(driver.findElement(By.name(getuserName)));
			}

		}

		Assert.assertTrue(checkProfileStatus, msg);

	}

	public void checkFirstAccept(String userName) throws InterruptedException {

		Assert.assertEquals(txtAcceptedMsg.getText(), "You have accepted", "First Accept Message is Seen");

		System.out.println(txtAcceptedMsg.getText());

		Assert.assertTrue(chckElementPresent(driver.findElement(By.id(userName))),
				"The Name of the Accepted User is Seen");

	}

	public String getInvitationCount() throws InterruptedException {

		String str;

		if (RunEnvironment.equals("iOSLocal")) {

			Thread.sleep(3000);

			str = txtPendingCnt.getText();

			str = StringUtils.substringBetween(str, "(", ")");

			str = str.replace("+", "");

		} else {
			str = DailyRecommendObjects.txtMatchCnt.getText();
		}

		return str;
	}

	public void checkFilterStatusAndCount(WebElement typOfFilter) throws InterruptedException {
		boolean cntFlagStatus;

		initInvitationCnt = getInvitationCount();

		int count1 = Integer.parseInt(initInvitationCnt);

		System.out.println("The intitial count of Invitation is " + count1);

		btnFilter.click();

		typOfFilter.click();

		Thread.sleep(5000);

		if (chckElementPresent(txt_ExpiryFilter) == true) {

			boolean isWarningSeen = chckElementPresent(txt_ExpiryFilter);

			OKBtn.click();

			System.out.println("This type of connection does not exist in the LIST");

			Assert.assertTrue(isWarningSeen, "The filter does not have this connect");

		} else {
			String InvitationCnt2 = getInvitationCount();

			int count2 = Integer.parseInt(InvitationCnt2);

			System.out.println("The count after applying the filter is " + count2);

			btnFilter.click();

			btnAllInvitations.click();
			if (count2 < count1) {

				cntFlagStatus = true;

				Assert.assertTrue(cntFlagStatus, "The filter is working fine and the count is reflected");
			} else {

				Assert.fail("Count does not change after filter is Applied");
			}
		}

	}

}
