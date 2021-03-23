package page.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import android.shaadi.BasePageActions;
import page.objects.DailyRecommendObjects;
import page.test.DailyRecommendTest;
import shaadi.utils.AppStringConstants;

public class DailyRecommendActions extends BasePageActions {

	public void ClickProfileProofIcon() {
		// WebElement buttonProfileVerifiedProofs =
		// driver.findElementByAccessibilityId("buttonProfileVerifiedProofs");
		click(DailyRecommendObjects.btnTrustBadge, "Click Profile Proof", "Daily-01");
	}

	public void ClickButtonProfileOnline() throws InterruptedException {
		// WebElement buttonProfileOnline =
		// driver.findElementByAccessibilityId("buttonProfileOnline");
		do {
			DailyRecommendObjects.buttonMoveToNextProfile.click();
		} while (chckElementPresent(DailyRecommendObjects.btnPstOnLineSts) != false);

		click(DailyRecommendObjects.btnOnline, "Click Button Profile Online", "Daily-02");
	}

	public void ClickButtonProfileMatchingData() {
		// WebElement buttonProfileMatchingData =
		// driver.findElementByAccessibilityId("buttonProfileMatchingData");
		click(DailyRecommendObjects.btnProfileMatchingData, "Click Button Profile Matching Data", "Daily-03");
	}

	public void ClickChatBackArrow() {
		if(RunEnvironment.equals("iOSLocal"))
		{
			WebElement ChatBackArrow = driver.findElementByAccessibilityId("arrow left white");
			click(ChatBackArrow, "Click Chat Back Arrow", "Daily-04");
		}
		else {
			driver.navigate().back();
		}
	}

	public void ClickGreenTick() {
		// WebElement buttonGreenTick =
		// driver.findElementByAccessibilityId("ShYouAndHerCellSectionHeaderID");
		if (RunEnvironment.equals("iOSLocal")) {
			click(DailyRecommendObjects.btnGreenTick, "Click Chat Back Arrow", "Daily-06");
		} else {
			driver.navigate().back();
		}
	}

	public void ClickShortlist() {
		click(DailyRecommendObjects.btnAddToShrtLst, "Click Shortlist", "Daily-07");
	}

	public void ClickProfileOptions() {

		click(DailyRecommendObjects.btnProfileOptions, "Click Profile Options Arrow", "Daily-05");
	}

	public void ClickShortlists() {
		WebElement menuShortlists = driver.findElementByAccessibilityId("Shortlists");
		click(menuShortlists, "Click Shortlist", "Daily-05");
	}

	public void GotoPhotoProifle(String TCID) {
		click(DailyRecommendObjects.buttonProfileAlbumRedirection, "Click Button Profile Album Redirection", TCID);
	}

	public void ClickConnect() {
		boolean isConnectVisible = false;
		while (!isConnectVisible) {
			isConnectVisible = isDisplayed(DailyRecommendObjects.btnConnect);
			if (isConnectVisible) {
				click(DailyRecommendObjects.btnConnect, "Click Connect Now", "Daily-02");

				if (RunEnvironment.equals("iOSLocal")) {
					AssertEquals(DailyRecommendObjects.labelSendEmail, "Send an Email", "Assert Send an Email");
				} else {
					AssertEquals(DailyRecommendObjects.labelSendEmail, "Write a Message", "Assert Send an Email");
				}

				InputValue(DailyRecommendObjects.textviewMessage, "Hi, Can you please accept my connection",
						"Input send description", "Daily-03");

				click(DailyRecommendObjects.btnSend, "Click Send Button", "Daily-04");
				
				if(RunEnvironment.equals("AndroidLocal"))
				{
					DailyRecommendTest.profileName =DailyRecommendObjects.labelProfileName.getText();

				}

				break;
			} else {
				click(DailyRecommendObjects.buttonMoveToNextProfile, "Click arrow to move to next profile", "Daily-06");
			}
		}
	}

	public void CTAAsserts() {
		AssertEquals(DailyRecommendObjects.labelContact, "View Contact", "Assert View Contact");
		AssertEquals(DailyRecommendObjects.labelWriteMessage, "Write Message", "Assert Write Message");
		AssertEquals(DailyRecommendObjects.labelConnectNow, "Connect Now", "Assert Connect Now");
	}

	public void ClickButtonContextual(String TCID) {
		// AssertEquals(DailyRecommendObjects.buttonContextual, "Okay, Got it!", "Assert
		// OK Got it Button");
		ClickNoException(DailyRecommendObjects.btnOkGotIt, 5, "Click OK Got it View", TCID);
	}

	public void VerifyAndSendPhotoProfileConnect(String TCID) {

//		String expString=DailyRecommendObjects.lblLikeThisProfile.getText();
//		
//		Assert.assertTrue(expString.equalsIgnoreCase("Like this Profile?"),"Assert Label CTA Photo Profile");

		click(DailyRecommendObjects.btnCTASendInterest, "Send Connect from Photo", TCID);

		if (RunEnvironment.equals("iOSLocal")) {
			AssertEquals(DailyRecommendObjects.labelSendEmail, "Send an Email", "Assert Send an Email");
		} else {
			AssertEquals(DailyRecommendObjects.labelSendEmail, "Write a Message", "Assert Send an Email");
		}

		InputValue(DailyRecommendObjects.textviewMessage, "Hi, Can you please accept my connection",
				"Input send description", TCID);

		click(DailyRecommendObjects.btnSend, "Click Send Button", TCID);

		AssertEquals(DailyRecommendObjects.labelInvitationSent, "Invitation Sent", "Assert Invitation Sent");

		click(DailyRecommendObjects.ButtonClose, "Click Cancel Button", TCID);
	}

	public void ClickNextProfile() {
		click(DailyRecommendObjects.buttonMoveToNextProfile, "Click arrow to move to next profile", "Daily-06");
	}

	public void ClickPreviousProfile() {
		click(DailyRecommendObjects.buttonMoveToPreviousProfile, "Click arrow to move to previous profile", "Daily-06");
	}

	public void AssertInvitation() {
		AssertEquals(DailyRecommendObjects.labelInvitationSent, "Invitation Sent", "Assert Invitation Sent");
	}

	public void ClickViewContact() {
		click(DailyRecommendObjects.labelViewContact, "Click View Contact", "Daily-07");
	}

	public void ClickYes() {
		click(DailyRecommendObjects.btnYes, "Click Yes", "Daily-07");
	}

	public void ClickMyShaadi() {
		click(DailyRecommendObjects.tabMyShaadi, "Click My Shaadi Tab", "Daily-05");
	}

	public void ClickMatches() {
		click(DailyRecommendObjects.tabMatches, "Click Macthes", "Daily-05");
	}

	public static void ScrollToolBarNew(String ExpectedText) {
		// RemoteWebElement element = (RemoteWebElement)driver.
		// findElement(By.xpath("//XCUIElementTypeToolbar[@name=\\\"Toolbar\\\"]/XCUIElementTypeScrollView/XCUIElementTypeSegmentedControl"));
		RemoteWebElement element = (RemoteWebElement) driver
				.findElement(By.className("XCUIElementTypeSegmentedControl"));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID);
		scrollObject.put("direction", "right");
		scrollObject.put("toVisible", ExpectedText);
		driver.executeScript("mobile:scroll", scrollObject);
	}

	public static void ScrollToolBarNewTest(String ExpectedText) {
		// RemoteWebElement element = (RemoteWebElement)driver.
		// findElement(Byxpath("//XCUIElementTypeToolbar[@name=\\\"Toolbar\\\"]/XCUIElementTypeScrollView/XCUIElementTypeSegmentedControl"));
		WebElement seg = driver.findElement(By.id("segmentedcontrolSubNav"))
				.findElements(By.className("XCUIElementTypeButton")).get(1);
		seg.click();
	}

	public static String VerifyTodayCount(String TCID) {

		String str;
		if (RunEnvironment.equals("iOSLocal")) {
			str = DailyRecommendObjects.segmentedcontrolSubNav.findElements(By.className("XCUIElementTypeButton"))
					.get(2).getAttribute("name");

			str = StringUtils.substringBetween(str, "(", ")");

		} else {
			str = DailyRecommendObjects.txtMatchCnt.getText();
		}

		return str;
	}

	public static void ClickNextTillLastProfile(String str, String TCID) {

		int cnt = 0;

		boolean isNextButtonDisplayed = true;

		while (isNextButtonDisplayed) {
			isNextButtonDisplayed = isDisplayed(DailyRecommendObjects.buttonMoveToNextProfile);
			if (isNextButtonDisplayed)
				click(DailyRecommendObjects.buttonMoveToNextProfile, "Click arrow to move to next profile", TCID);
			cnt++;
		}

		Assert.assertEquals(cnt, Integer.parseInt(str));
	}

	public void VerifyProfileData(WebElement locator) {
		if (locator.getText().isEmpty()) {
			System.out.println("Empty Value: Test Case Failed");
			extentTest.log(LogStatus.FAIL, "Check if Profile Name is empty or not");
		} else {
			System.out.println("Profile Name :" + locator.getText());
			extentTest.log(LogStatus.PASS, "Check if Profile Name is empty or not");
		}
	}

	public void VerifyContactDetails(boolean isInvitationSentView) throws InterruptedException {
		
		
		
		if (!isInvitationSentView) {
			
			if(RunEnvironment.equals("iOSLocal"))
			{
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "left");
				js1.executeScript("mobile: swipe", params);
				String text = "Manglik";
				final JavascriptExecutor js = (JavascriptExecutor) driver;
				final HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("predicateString", "value == '" + text + "'");
				scrollObject.put("direction", "down");
				scrollObject.put("toVisible", "true");
				js.executeScript("mobile: scroll", scrollObject);
				click(DailyRecommendObjects.btnAction, "Click View Details", "Daily-02");	
			}
			else {
				
				DailyRecommendObjects.buttonMoveToNextProfile.click();
				scrollTillVisibleTextAndClick(AppStringConstants.txtDetails);
				
			}
		}
	
		click(DailyRecommendObjects.btnYes, "Click Yes to View Contact Layout", "Daily-02");

		Thread.sleep(3000);

		boolean isDailyLimitPopUpDisplayed = false;

		isDailyLimitPopUpDisplayed = isDisplayed(DailyRecommendObjects.labelDailyLimitReached);

		if (isDailyLimitPopUpDisplayed) {
			click(DailyRecommendObjects.btnOk, "Click OK", "Daily-02");
		}

		else {
			String contactText;

			Thread.sleep(5000);

			if (RunEnvironment.equals("iOSLocal")) {
				verifyContactDataGeneric(0, "Mobile", true, "Mobile Header is seen", "MobileData is also Seen");
				verifyContactDataGeneric(1, "Email", true, "Email Header is seen", "EmailData is also Seen");
				verifyContactDataGeneric(2, "Contacts Available", true, "Contacts Available Header is seen",
						"Contacts AvailableData is also Seen");
				@SuppressWarnings("unchecked")
				List<WebElement> contactType = driver
						.findElements(By.xpath("//XCUIElementTypeCell[@name=\"SMSCallCell\"]"));

				contactText = contactType.get(0)
						.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"lblValue.label\"]")).getText();

				WebElement buttonOk = driver.findElement(By.xpath(
						"//XCUIElementTypeApplication[@name=\"Shaadi\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]"));
				click(buttonOk, "Click OK", "Daily-02");

			}

			else {
				try {

					Assert.assertEquals(DailyRecommendObjects.txtMobileHeader.getText(), "Mobile",
							"Mobile header is Seen");

					Assert.assertEquals(DailyRecommendObjects.txtEmailHeader.getText(), "Email",
							"Email header is Seen");

					Assert.assertEquals(DailyRecommendObjects.txtLblConAvail.getText(), "Contacts Available",
							"Email header is Seen");

					contactText = DailyRecommendObjects.txtMobileNum.getText();

					DailyRecommendObjects.btnOK_ViewContact.click();

				} catch (Exception e) {
					contactText = DailyRecommendObjects.txtMobileNum.getText();
					DailyRecommendObjects.btnOK_ViewContact.click();
					// TODO: handle exception
				}

			}

			// Id not there so adding xpath temporary

			if (!isInvitationSentView && contactText.equals("Visible on accept")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "right");
				js.executeScript("mobile: swipe", params);
			}

			else {
				if (!isInvitationSentView) {
					
					if(RunEnvironment.equals("iOSLocal")) {
						click(DailyRecommendObjects.buttonMoveToPreviousProfile, "Click arrow to move to previous profile",
								"Daily-06");
						Thread.sleep(3000);
						// This line is added because the application does not show accessibility id
						// when the invitation is set to false
						String txtInvite = driver.findElement(By.name("lblHyperlinkedHeader.label")).getText();
						Assert.assertEquals(txtInvite, "Invitation Sent", "Assert Invitation Sent");
					}
					else {
						
						scrollTillVisibleText(DailyRecommendTest.profileName);
						AssertEquals(DailyRecommendObjects.labelInvitationSent, "Invitation Sent", "Assert Invitation Sent");
					}

					
					
				}

				else {
					AssertEquals(DailyRecommendObjects.labelInvitationSent, "Invitation Sent",
							"Assert Invitation Sent");
				}
			}

			if(RunEnvironment.equals("iOSLocal")) {
				String text = "Basic Info & Lifestyle";
				final JavascriptExecutor js = (JavascriptExecutor) driver;
				final HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("predicateString", "value == '" + text + "'");
				scrollObject.put("direction", "down");
				scrollObject.put("toVisible", "true");
				js.executeScript("mobile: scroll", scrollObject);
			}
			
			
			AssertEquals(DailyRecommendObjects.labelInvitationSent, "Invitation Sent", "Assert Invitation Sent");
		}
	}

	public void VerifyBottomCTA() throws InterruptedException {
		if(RunEnvironment.equals("iOSLocal")) {
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "left");
			js1.executeScript("mobile: swipe", params);
			String text = "Manglik";
			final JavascriptExecutor js = (JavascriptExecutor) driver;
			final HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("predicateString", "value == '" + text + "'");
			scrollObject.put("direction", "down");
			scrollObject.put("toVisible", "true");
			js.executeScript("mobile: scroll", scrollObject);
		}
		
		else {
			
			scrollTillVisibleText("online");
			DailyRecommendObjects.buttonMoveToNextProfile.click();
			scrollTillVisibleText(AppStringConstants.txtDetails);
			
			
		}
		
		AssertEquals(DailyRecommendObjects.labelContact, "View Contact", "Assert View Contact");
		AssertEquals(DailyRecommendObjects.labelWriteMessage, "Write Message", "Write Message");
		AssertEquals(DailyRecommendObjects.labelConnectNow, "Connect Now", "Assert Connect Now");
	}

	public void SendBottomConnect() {
		click(DailyRecommendObjects.btnConnect, "Click Connect Now", "Daily-06");
		if(RunEnvironment.equals("iOSLocal"))
		{
			AssertEquals(DailyRecommendObjects.labelSendEmail, "Send an Email", "Assert Send an Email");

		}
		else {
			AssertEquals(DailyRecommendObjects.labelSendEmail, "Write a Message", "Assert Send an Email");
		}
		InputValue(DailyRecommendObjects.textviewMessage, "Hi, Can you please accept my connection",
				"Input send description", "Daily-06");
		click(DailyRecommendObjects.btnSend, "Click Send Button", "Daily-06");
	}

	public static void ScrollToView_ButtonProfile() throws InterruptedException {
		WebElement ButtonProfile = driver.findElement(By.xpath("//*[@name=\"buttonProfileVerifiedProofs\"]"));
		scrollingIOS(ButtonProfile, "up");
	}

	public void VerifyProfileDetails() {
		List<WebElement> test = driver.findElementByAccessibilityId("tblProfileDetails")
				.findElements(By.className("XCUIElementTypeStaticText"));
		System.out.println(test.size());
		WebElement tblProfileDetails = driver.findElementByXPath(
				"//*[@name=\"tblProfileDetails\"]/XCUIElementTypeStaticText[3]/XCUIElementTypeStaticText[1]");
		System.out.println(tblProfileDetails.getText());
	}

	public void VerifyDetails() {
		@SuppressWarnings("unused")
		WebElement buttonView_Contact = driver.findElementByAccessibilityId("buttonView Contact");
		@SuppressWarnings("unused")
		WebElement buttonWrite_Message = driver.findElementByAccessibilityId("buttonWrite Message");
		@SuppressWarnings("unused")
		WebElement labelAboutProfile = driver.findElementByAccessibilityId("labelData");
		@SuppressWarnings("unused")
		WebElement tblProfileDetails = driver.findElementByAccessibilityId("tblProfileDetails");
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

	public void verifyContactDataAndroid() {

	}

}