package page.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import data.AdvanceSearchData;
import data.SearchData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSElement;
import page.objects.MatchesPageObjects;
import page.test.Dashboard_Shortlist_Connect_ignore_test;
import page.test.NearMeTest;
import page.test.SearchTest;
import page.test.SendConectFromListingTest;
import shaadi.utils.AppStringConstants;

public class MatchesPage extends MatchesPageObjects {

	public SoftAssert sa = new SoftAssert();

	InboxPage inb_page = new InboxPage();
	public static int profileIndex;

	public void clickSearch() throws InterruptedException {
		waitForSometime(2000);

		if (RunEnvironment.equals("iOSLocal")) {

			WebElement navSearchButton = driver.findElement(By.id("buttonSubNav0"));
			navSearchButton.click();

		} else {

			navigateToSpecifiedMatchesTab(todayMatchesTabAndroid, "Navigate to Todays Matches Tab");
			navigateToSpecifiedMatchesTab(newMatchesTabAndroid, "Navigate to New Matches Tab");
			Thread.sleep(2000);
			click(actionBarItemSearch.get(0), "Click on Search", "Search-01");
		}

	}

	public void selectingParameters(WebElement element, ArrayList<Object> parameter) throws InterruptedException {
		for (int i = 0; i < parameter.size(); i++) {
			Thread.sleep(1000);
			click(element, "", "");
			selectOptionUsingText(parameter.get(i).toString());

		}

	}

	public void selectingParameters_new(WebElement element, ArrayList<Object> parameter) throws InterruptedException {
		for (int i = 0; i < parameter.size(); i++) {
			// scrollDownToElement(element);
			scrollDownToElement_search(element);
			if (isDisplayedAfterWait(searchNowButton, 1)) {
				if (areElementsOverlapping(element, searchNowButton)) {
					scrollDownSlow();
				}
			}
			Thread.sleep(1000);
			element.click();
			selectOptionUsingTextNew(parameter.get(i).toString());

		}

	}

	@SuppressWarnings("unchecked")
	public void selectOptionUsingText(String text) {

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

	@SuppressWarnings("unchecked")
	public void selectOptionUsingTextNew(String text) throws InterruptedException {
		Thread.sleep(2000);
		WebElement textelement = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("//android.widget.TextView[@text='" + text + "']");

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
			click(applyButton, "click apply button", "");
		} else {

			textelement.click();
			Thread.sleep(1000);
			applyButton.click();
		}

	}

	public void tapMartialStatusDropdown() {
		click(maritialStatusDropdown, "tap martial status dropdown", "");

	}

	public void tapReligionDropdown() {
		click(religion, "tap on religion dropdown", "");

	}

	public void tapCommunityDropdown() {
		click(community, "tap on community dropdown", "");

	}

	public void tapMOtherTongue() {
		click(motherTongue, "tap on Mother tongue dropdown", "");

	}

	public void tapCountryLivingIn() {
		click(country, "tap Country Living in", "");

	}

	public void tapStateLivingIn() {
		click(state, "tap state Living in", "");

	}

	public void tapcountryGrewUpIn() {
		click(countryGrewUpIn, "country grew up in", "");

	}

	public void tapPhotoSettings() {
		click(photoSettings, "tap Photo Settings", "");
	}

	public void scrollUsingTouchActionsByElements(MobileElement startElement, MobileElement endElement) {
		TouchAction actions = new TouchAction(driver);
		actions.press(startElement).waitAction(2000).moveTo(endElement).release().perform();
	}

	public void tapEducation() {
		click(education, "Clicking on education", "");
	}

	public void tapEducationArea() {
		click(educationArea, "click education area", "");

	}

	public void tapWorkingWith() {
		click(workingWith, "tap working with", "");
	}

	public void tapProfessionArea() {
		click(professionalArea, "tap working with", "");
	}

	public void tapWorkingAs() {
		click(workingAs(), "tap working with", "");
	}

	public void tapDiet() {
		click(diet, "tap Diet", "");
	}

	public void tapSmoke() {
		click(smoke, "tap Smoke", "");
	}

	public void tapDrink() {
		click(drink, "tap Smoke", "");
	}

	public void tapBodyTye() {
		click(bodyType, "tap Smoke", "");
	}

	public void tapSkinTone() {
		click(skinType, "tap Smoke", "");
	}

	public void clickSearchButton() throws InterruptedException {
		scrollDownToElement(searchNowButton);
		Thread.sleep(1000);
		click(searchNowButton, "Click On Search Now button", "");
	}

	public void profileThatHaveFilteredMeOutAsWell(String button) {
		scrollDownToElement(IncludeProfilesthathaveFilteredmeoutaswell);
		if (areElementsOverlapping(IncludeProfilesthathaveFilteredmeoutaswell, searchNowButton)) {
			scrollDownSlow();
		}
		if (button.equalsIgnoreCase("ON")) {
			turnOnIfOff(IncludeProfilesthathaveFilteredmeoutaswell);
		}
		if (button.equalsIgnoreCase("OFF")) {
			turnOffIfOn(IncludeProfilesthathaveFilteredmeoutaswell);
		}
	}

	public void profileThatIHaveAlreadyViewed(String button) {
		scrollDownToElement(IncludeProfilesthatIhavealreadyviewed);
		if (areElementsOverlapping(IncludeProfilesthatIhavealreadyviewed, searchNowButton)) {
			scrollDownSlow();
		}
		if (button.equalsIgnoreCase("ON")) {
			turnOnIfOff(IncludeProfilesthatIhavealreadyviewed);
		}

		if (button.equalsIgnoreCase("OFF")) {
			turnOffIfOn(IncludeProfilesthatIhavealreadyviewed);
		}
	}

	public void turnOffIfOn(WebElement locator) {
		System.out.println(locator.getText());
		if (locator.getText().equalsIgnoreCase("ON")) {
			locator.click();

		}

	}

	public void turnOnIfOff(WebElement locator) {
		System.out.println(locator.getText());
		if (locator.getText().equalsIgnoreCase("OFF")) {
			locator.click();

		}

	}

	public void hortizonalSwipetoLeft() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.10);
		int startx = (int) (width * 0.35);
		int endx = (int) (width * 0.75);
		driver.swipe(startx, y, endx, y, 500);

	}

	public void scrollToMembersLookingForMeSection() throws InterruptedException {
		BasePageActions.scrollUpToElement(RecentVisitors);
		// scroll to members you may like
		BasePageActions.scrollFromOneElementToAnother(SectionTitle.get(1), SectionTitle.get(0));

		// scroll to MembersLookingForMe
		BasePageActions.scrollFromOneElementToAnother(SectionTitle.get(1), SectionTitle.get(0));
	}

	public void clickOnMyMatches() {
		click(MyMatches, "click on my matches", "String tc");
	}

	public void nearMeHeader() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			SoftAssert sa = new SoftAssert();
			Thread.sleep(3000);
			click(MyMatchestabIOS, "Click My Matches tab", "NM01");
			Thread.sleep(2000);
			click(NearMetabIOS, "Click Near Me tab", "NM02");
			Thread.sleep(3000);
			sa.assertEquals(NearMeHeader.getText(), "Members around your city",
					"Members around your city text is not displayed");
			sa.assertEquals(REFINEBtn.getText(), "REFINE", "REFINE text is not displayed");
			click(REFINEBtn, "Click REFINE Btn", "NM03");
			Thread.sleep(2000);
			sa.assertTrue(BasePageActions.isElementDisplayed(RefineText), "Refine Text is not displayed");
			sa.assertTrue(BasePageActions.isElementDisplayed(ApplyCTAonRefine), "Apply CTA on Refine is not displayed");
			click(ApplyCTAonRefine, "Click Apply CTA on Refine page", "NM03");
			driver.navigate().back();

			Thread.sleep(3000);

		} else {
			BasePageActions.navigateToMatchesTab(NearMeTab);
			Thread.sleep(3000);
			ClickNoException(GotIt, 5, "Click on Got It button", "Test-01");
			AssertEquals(nearMeHeaderAndroid, "Members around your city",
					"Verify the text -- Members around your city");

		}
	}

	public void profileInfo() throws InterruptedException {

		Boolean isPhotoCountVisible = false;
		scrollDownToElement(UserName_NearMe);

		isPhotoCountVisible = isDisplayed(tvPicCount);
		if (isPhotoCountVisible) {
			String txtCount = (tvPicCount).getText();
			verifyText(tvPicCount, txtCount, "Verify Photo Count");
		}

		String userName = (UserName_NearMe).getText();
		System.out.println(" User's Name: " + userName);

		String userAgeHeight = (UserAgeHeight).getText();
		System.out.println(" User's Age and Height: " + userAgeHeight);

		String userCommunity = (UserCommunity).getText();
		System.out.println(" User's Community: " + userCommunity);

		if (isDisplayed(OnlineStatus)) {
			String Onlinestatus = (OnlineStatus).getText();
			System.out.println(" User's Online Status: " + Onlinestatus);
		}

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			Boolean YouandherValue = false;
			YouandherValue = isDisplayed(YouAndHer);

			if (YouandherValue) {

				String YouandHerHim = (YouAndHer).getText();
				System.out.println(" You and Her/Him text: " + YouandHerHim);

				click(YouAndHer, "Click You and her/him", "Test-03");

				String YouandHerHeader = (YouAndHerHeader).getText();
				System.out.println("Header : " + YouandHerHeader);

				String YouandHerValue1 = (YouAndHerValue.get(0)).getText();
				System.out.println("You and her/him value: " + YouandHerValue1);
				waitForSometime(2000);

				driver.navigate().back();
			}
		}

		Boolean UserCareerVisible = false;
		UserCareerVisible = isDisplayed(UserCareer);
		if (UserCareerVisible) {
			String Usercareer = (UserCareer).getText();
			System.out.println("User Career : " + Usercareer);

		}

		String Userlocation = (UserLocation).getText();
		System.out.println("User Location : " + Userlocation);

	}

	@SuppressWarnings("rawtypes")
	public void trustBadge() throws InterruptedException {

		if (RunEnvironment.equals("androidLocal")) {
			scrollUpToElement(myMatchesRefineButtonAndroid);
		}

		if (RunEnvironment.equals("iOSLocal")) {

			Boolean TrustBadgeVisibleiOSGreen = false;
			TrustBadgeVisibleiOSGreen = isDisplayed(TrustBadgeGrayIcon);
			if (TrustBadgeVisibleiOSGreen) {
				Thread.sleep(3000);
			}

		} else {

			Boolean TrustBadgeVisible = false;
			TrustBadgeVisible = isDisplayed(TrustBadgeIcon);
			if (TrustBadgeVisible) {
				click(TrustBadgeIcon, "Click Trust Badge Icon", "Test-01");

				Boolean trustBadgeValue1 = false;
				trustBadgeValue1 = isDisplayed(TrustBadgeValue1);
				if (trustBadgeValue1) {
					String TrustBadgeValue01 = (TrustBadgeValue1).getText();
					System.out.println("Trust Badge Value 1 : " + TrustBadgeValue01);
				}

				Boolean trustBadgeValue2 = false;
				trustBadgeValue2 = isDisplayed(TrustBadgeValue2);
				if (trustBadgeValue2) {
					String TrustBadgeValue02 = (TrustBadgeValue2).getText();
					System.out.println("Trust Badge Value 2 : " + TrustBadgeValue02);
				}

				Boolean trustBadgeValue3 = false;
				trustBadgeValue3 = isDisplayed(TrustBadgeValue3);
				if (trustBadgeValue3) {
					String TrustBadgeValue03 = (TrustBadgeValue3).getText();
					System.out.println("Trust Badge Value 3 : " + TrustBadgeValue03);
				}

				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			}
		}

	}

	public void dropDownValuesPremium() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			click(buttonMoreMenu, "Click button More Menu ", "Test-01");
			Thread.sleep(2000);

		} else {

			SoftAssert sa = new SoftAssert();
			List<String> dropDownList = new ArrayList<>();
			dropDownList.add("Add to Shortlist");
			dropDownList.add("Don't Show Again");
			dropDownList.add("Block Profile");
			dropDownList.add("Report Profile");
			scrollDownToElement(DropDownIcon);

			click(DropDownIcon, "Click Drop Down Icon", "Test-03");
			waitForSometime(2000);
			int size = DropDownValue.size();
			System.out.println(size);

			for (WebElement e : DropDownValue) {
				for (String s : dropDownList) {
					if (e.getText().contains(s))
						// AssertEquals(e, s, "Verify the text" + s);
						sa.assertTrue(e.getText().contains(s));

				}
			}

			sa.assertAll();
			Thread.sleep(2000);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
		}
	}

	public void dropDownValues() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {

			buttonMoreMenu.click();

			Thread.sleep(2000);

			if (isDisplayed(dd_shortlistProfile)) {
				sa.assertTrue(isDisplayed(dd_shortlistProfile), "Shortlist option is seen");
				System.out.println("Shortlist Option Seen");
			}

			if (isDisplayed(dd_blockProfile)) {
				sa.assertTrue(isDisplayed(dd_blockProfile), "Block option is seen");
				System.out.println("Block Option Seen");
			}

			if (isDisplayed(dd_reportProfile)) {
				sa.assertTrue(isDisplayed(dd_reportProfile), "Report option is seen");
				System.out.println("Report option Seen");
			}

			btn_dd_Cancel.click();
		}

		else {

			SoftAssert sa = new SoftAssert();
			List<String> dropDownList = new ArrayList<>();
			dropDownList.add("Add to Shortlist");
			dropDownList.add("Don't Show Again");
			dropDownList.add("Block Profile");
			dropDownList.add("Report Profile");
			scrollDownToElement(DropDownArrow);

			click(DropDownArrow, "Click Drop Down Icon", "Test-03");
			waitForSometime(2000);
			int size = DropDownValue.size();
			System.out.println(size);

			for (WebElement e : DropDownValue) {
				for (String s : dropDownList) {
					if (e.getText().contains(s))
						sa.assertTrue(e.getText().contains(s));
				}
			}

			sa.assertAll();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
		}
	}

	public void photoCase() throws InterruptedException {

		scrollDownToElement(UserName_NearMe);
		Boolean NoPhotoAdded = false;
		NoPhotoAdded = isDisplayed(NoPhotoAddedTxt);
		if (NoPhotoAdded) {
			String NoPhotoAdded1 = (NoPhotoAddedTxt).getText();
			System.out.println("Text: " + NoPhotoAdded1);

			String RequestPhoto = (ReqPhotoBtn).getText();
			System.out.println("Text: " + RequestPhoto);
			Thread.sleep(3000);
			scrollUpToDown();
			Thread.sleep(3000);
			scrollUpToDown();
			Thread.sleep(3000);

		}

		Boolean VisibletoPremium = false;
		VisibletoPremium = isDisplayed(VisbleToPremiumTxt);
		if (VisibletoPremium) {

			String visbleToPremiumTxt = (VisbleToPremiumTxt).getText();
			System.out.println("Text: " + visbleToPremiumTxt);

			Thread.sleep(3000);

			scrollUpToDown();
			Thread.sleep(3000);
			scrollUpToDown();
			Thread.sleep(3000);
		}

		Boolean VisibleOnAccept = false;
		VisibleOnAccept = isDisplayed(VisibleOnAcceptBtn);
		if (VisibleOnAccept) {

			String VisbleOnAccept = (VisibleOnAcceptBtn).getText();
			System.out.println("Text: " + VisbleOnAccept);
			Thread.sleep(3000);
			scrollUpToDown();
			Thread.sleep(3000);
			scrollUpToDown();
			Thread.sleep(3000);
		}

		scrollDownToElement(PhotoAlbum);
		PhotoAlbum.click();
		waitForSometime(2000);
		AssertEquals(likethisprofiletxt, "Like this profile?", "Verify the text -- Like this profile? ");
		click(ConnectFrmAlbumBtn, "Click Photo Album Connect Button", "Test-03");
		Thread.sleep(2000);

//			-----new code to be added----- You are filtered out

		if (isDisplayed(CloseUpgradePopUp)) {
			CloseUpgradePopUp.click();
		}

		if (RunEnvironment.equalsIgnoreCase("android")) {

			if (InvitationSentTxt.getText().equalsIgnoreCase("You are filtered out")) {
				AssertEquals(InvitationSentTxt, "You are filtered out", "Verify the text -- You are filtered out");
			} else {
				AssertEquals(InvitationSentTxt, "Invitation Sent", "Verify the text -- Invitation Sent");
			}
		} else {

			if (isDisplayed(filtered_out_Txt)) {

				AssertEquals(filtered_out_Txt, "Your Request may not be visible in his Inbox.",
						"Verify the text -- You are filtered out");
			} else {

				AssertEquals(InvitationSentTxt, "Invitation Sent", "Verify the text -- Invitation Sent");
			}
		}

		if (isDisplayed(UpgradeBtn)) {
			AssertEquals(UpgradeBtn, "Upgrade Now", "Verify the text -- Upgrade Now");
			click(UpgradeBtn, "Click Upgrade Btn Button", "Test-03");
			Thread.sleep(3000);
			driver.navigate().back();
		}
		Thread.sleep(3000);
		driver.navigate().back();

		Thread.sleep(3000);
		scrollUpToDown();
		Thread.sleep(3000);

		// }
	}

	public void BottomCTA(WebElement likeProfile) throws InterruptedException {

		AssertEquals(likeProfile, "Like this profile? ", "Verify the text -- Like this profile? ");
		AssertEquals(ConnectOnListBtn, "Connect Now", "Verify the text -- Connect Now");
		click(ConnectOnListBtn, "Click Connect Now Button", "Test-03");
		Thread.sleep(3000);

		if (NearMeTest.premFlag == true) {
			sendMessageOnConnectPremium();
		}
		Thread.sleep(2000);
		driver.navigate().back();

	}

	public void connectOnList() throws InterruptedException {
		Thread.sleep(3000);
		click(btnConnectOnList, "Click Connect Now Button", "Test-03");

	}

	public void photoCaseforPremium() throws InterruptedException {
		Boolean NoPhotoAdded = false;
		NoPhotoAdded = isDisplayed(NoPhotoAddedTxt);
		if (NoPhotoAdded && NoPhotoAddedTxt.getText().contains("No Photo Added")) {
			String NoPhotoAdded1 = (NoPhotoAddedTxt).getText();
			System.out.println("Text: " + NoPhotoAdded1);

			AssertEquals(ReqPhotoBtn, "Request a Photo", "Verify the text -- Request a Photo");
			click(ReqPhotoBtn, "Click Request a Photo Button", "Test-03");

			Thread.sleep(3000);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);
		}

		Boolean VisibleOnAccept = false;
		VisibleOnAccept = isDisplayed(VisibleOnAcceptBtn);
		if (VisibleOnAccept) {
			String VisibleonAccept = (VisibleOnAcceptBtn).getText();
			System.out.println("Text: " + VisibleonAccept);
			Thread.sleep(3000);
		}

		Boolean PhotoVisible = false;
		PhotoVisible = isDisplayed(PhotoAlbum);
		if (PhotoVisible) {
			click(PhotoAlbum, "Click Photo Album Button", "Test-03");
			AssertEquals(likethisprofiletxt, "Like this profile? ", "Verify the text -- Like this profile? ");
			click(ConnectFrmAlbumBtn, "Click Photo Album Connect Button", "Test-03");
			Thread.sleep(2000);
			sendMessageOnConnectPremium();
			Thread.sleep(2000);

			if (InvitationSentTxt.getText().equalsIgnoreCase("You are filtered out")) {
				AssertEquals(InvitationSentTxt, "You are filtered out", "Verify the text -- You are filtered out");
			} else {
				AssertEquals(InvitationSentTxt, "Message Sent", "Verify the text -- Message Sent");
			}

			if (isDisplayed(ViewContactOnAlbum)) {
				AssertEquals(ViewContactOnAlbum, "View Contact", "Verify the text -- View Contact");
				click(ViewContactOnAlbum, "Click View contact link", "Test-03");
			}
			waitForSometime(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(3000);
			scrollUpToDown();

		}

	}

	public void emptyCase() throws InterruptedException {
		AssertEquals(NoMatchesTxt, "NO MORE MATCHES", "Verify the text -- NO MORE MATCHES");
		AssertEquals(NoMatchesTxt1, "You have no more Matches in this section",
				"Verify the text -- You have no more Matches in this section");
		AssertEquals(DiscoverMatches, "Discover more Matches", "Verify the text -- Discover more Matches");
		click(DiscoverMatches, "Click Discover more Matches Button", "Test-03");

		String membersUmayLike = (MembersUmayLike).getText();
		System.out.println("Members You may Like text : " + membersUmayLike);

	}

	public void navigateToProfilePage() throws InterruptedException {
		scrollDownToElement(tvListingUserName);
		waitForSometime(2000);
		click(tvListingUserName, "Click on Username", "Test-03");
		waitForSometime(2000);

		click(NextArrowBtn, "click on next profile", "");
	}

	public void clickPreferenceField(String statusValue, WebElement elemnetName) {
		if (RunEnvironment.equals("iOSLocal")) {

			elemnetName.click();
		}

		else {
			boolean found = false;
			while (!found)
				found = isElementFoundAndClickable(dropDownMartialStatusList, "Click on Marital Status", "Search-02");
		}
	}

	public void selectStatusValue(String statusValue, int size) throws InterruptedException

	{
		if (RunEnvironment.equals("iOSLocal")) {

			if (!statusValue.equals("Doesn't Matter")) {

				Thread.sleep(2000);

				fldSearchText.click();

				fldSearchText.sendKeys(statusValue);

				driver.findElement(By.name("" + statusValue)).click();

			} else {

				driver.findElement(By.name("" + statusValue)).click();
			}

		}

		else {

			for (int i = 0; i < size; i++) {
				ScrollToText(textViewData, statusValue, "Click" + statusValue, "Search-03");
				i++;
			}
		}
	}

	public void assertSelectedStatus(String statusName, WebElement elementName) throws InterruptedException {
		if (RunEnvironment.equals("iOSLocal")) {

			Thread.sleep(3000);

			String expStatus = elementName.getText();

			String[] actualStatus = statusName.replace(";", "").trim().split(",");

			System.out.println(Arrays.toString(actualStatus));

			String[] expectedStatus = expStatus.replace(";", "").trim().split(",");

			System.out.println(Arrays.toString(expectedStatus));

			removeWhiteSpaces(actualStatus);

			removeWhiteSpaces(expectedStatus);

			Arrays.sort(actualStatus);

			Arrays.sort(expectedStatus);

			Assert.assertEquals(actualStatus, expectedStatus);

		}

		else {
			AssertEquals(dropDownMartialStatusList, statusName, "Assert Marital Status Text");
		}

	}

	public String[] removeWhiteSpaces(String[] temp) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].trim();

		}
		return temp;
	}

	public void ClickHaveChildren(String HaveChildren) {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownChildrenlist, "Click on kid status", "Search-07");
	}

	public void AssertHaveChildren(String HaveChildren) {
		AssertEquals(dropDownChildrenlist, HaveChildren, "Assert Children Status Text");
	}

	public void SelectHaveChildrenValue(String HaveChildren, int size) {

		if (RunEnvironment.equals("iOSLocal")) {

			// Generic code written to select value from picker wheel in iOS
			selectValueFromPickerWheel(HaveChildren);

		} else {
			for (int i = 0; i < size; i++) {
				ScrollToText(textViewData, HaveChildren, "Click" + HaveChildren, "Search-03");
				i++;
			}
		}

	}

	public static void selectValueFromPickerWheel(String selectStr) {
		WebDriver wd = driver;

		IOSElement picker = (IOSElement) new WebDriverWait(wd, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypePickerWheel")));

		picker.setValue(selectStr);
	}

	public void ClickReligion() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownReligion, "Click on Religion", "Search-03");
	}

	public void SelectReligionValue(String Religion, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, Religion, "Click" + Religion, "Search-03");
			i++;
		}
	}

	public void AssertReligion(String Religion) {
		AssertEquals(dropDownReligion, Religion, "Assert Religion");
	}

	public void ClickCommunity(String Community) {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownCommunity, "Click on Community", "Search-04");
	}

	public void ClickMotherTongue() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownMotherTongue, "Click on Mothertongue", "Search-05");
	}

	public void SelectMotherTongueValue(String MotherTongue, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, MotherTongue, "Click" + MotherTongue, "Search-03");
			i++;
		}
	}

	public void AssertMotherTongue(String Mothertongue) {
		AssertEquals(dropDownMotherTongue, Mothertongue, "Assert Mother Tongue");
	}

	public void ClickCommunity() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownCommunity, "Click on Community", "Search-04");
	}

	public void SelectCommunityValue(String Community, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, Community, "Click" + Community, "Search-03");
			i++;
		}
	}

	public void AssertCommunity(String Community) {
		AssertEquals(dropDownCommunity, Community, "Assert Community");
	}

	public void ClickCountry() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownCountry, "Click on Country", "Search-06");
	}

	public void SelectCountryValue(String Country, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, Country, "Click" + Country, "Search-03");
			i++;
		}
	}

	public void AssertCountry(String Country) {
		AssertEquals(opt_CountryLiving, Country, "Assert Country ");
	}

	public void ClickState() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownState, "Click on State", "Search-06");
	}

	public void SelectStateValue(String State, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, State, "Click" + State, "Search-03");
			i++;
		}
	}

	public void AssertState(String State) {
		scrollDownToElement(dropDownPhotoSettingsList);
		AssertEquals(opt_State, State, "Assert State ");
	}

	public void ClickCity() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownCity, "Click on City", "Search-06");

	}

	public void SelectCityValue(String City, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, City, "Click" + City, "Search-03");
			i++;
		}
	}

	public void AssertCity(String City) {
		AssertEquals(dropDownCity, City, "Assert City");
	}

	public void ClickManglik() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownManglik, "Click on Manglik", "Search-07");
	}

	public void SelectManglikValue(String Manglik, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, Manglik, "Click" + Manglik, "Search-03");
			i++;
		}
	}

	public void AssertManglik(String Manglik) {
		AssertEquals(dropDownManglik, Manglik, "Assert Manglik");
	}

	public void ClickPhotoSettings() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(dropDownPhoto, "Click on Photo Settings", "Search-07");
	}

	public void SelectPhotoValue(String PhotoSettings, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(textViewData, PhotoSettings, "Click" + PhotoSettings, "Search-07");
			i++;
		}
	}

	public void AssertPhotoSettings(String PhotoSettings, WebElement eleName) {
		AssertEquals(eleName, PhotoSettings, "Assert Photo");
	}

	public void ClickFilterOutToggle() {
		ScrollTill(filterToggle, "Scroll till filter toggle", "Search-03");
	}

	public void ClickProfileViewedToggle() {
		ScrollTill(profilesViewedToggle, "Scroll till Profile Viewed toggle", "Search-03");

	}

	public void ClickApply() {
		click(textViewApply, "Click on Apply", "Search-05");
	}

	public void scrollToSearch() throws InterruptedException {
		scrollUpToDown();
		Thread.sleep(3000);
		scrollUpToDown();
		Thread.sleep(3000);
		scrollUpToDown();

	}

	public void ClickListConnect()

	{
		click(btnConnectNow, "Click on Connect", "Search-11");
	}

	public void ClickSearchNow() {
		ScrollTill(btnSearchNow, "Scroll Search Button", "Search-12");
	}

	public String convertToStr(ArrayList<Object> statusField, int size) {
		Set<String> strBuilder = new HashSet<>();
		String strConcat = null;

		for (int j = 0; j < size; j++) {
			;
			String primaryStr = statusField.get(j).toString().trim();
			strBuilder.add(primaryStr);
			strConcat = String.join(",", strBuilder);

		}
		return strConcat;
	}

	public void checkSearchResultPage() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		boolean noRsultFlag = chckElementPresent(txt_noResult);

		if (noRsultFlag == true) {
			System.out.println("\"The user did not get any Result\"");
			SearchTest.asrtSrch.assertEquals(txt_noResult.getText(), "NO RESULTS",
					"No result text is seen for the user");
		}

		else {

			if (chckElementPresent(btn_Refine) == true) {
				System.out.println("\"The user did get some  Results\"");
				SearchTest.asrtSrch.assertTrue(isDisplayed(btn_Refine),
						"Search Page is Visible to the user and Refine button is seen");
				SearchTest.asrtSrch.assertTrue(isDisplayed(txtMatchConfirmation), "Search Page is Visible to the user");
			}
		}

	}

	public void checkMaritialStatus(SearchData searchData) throws InterruptedException {

		System.out.println(SearchTest.clickFlag);

		clickPreferenceField("", dropDownMartialStatusList);// index for maritial status is 3

		Thread.sleep(2000);

		selectStatusValue("Doesn't Matter", 1);

		ClickApply();

		clickPreferenceField("", dropDownMartialStatusList);

		for (int i = 0; i < searchData.maritalStatus.size(); i++) {
			selectStatusValue(searchData.maritalStatus.get(i).toString(), searchData.maritalStatus.size());
		}

		ClickApply();

		if (searchData.maritalStatus.size() > 1) {

			assertSelectedStatus(convertToStr(searchData.maritalStatus, searchData.maritalStatus.size()),
					opt_MaritialStatus);

		}

		else {

			assertSelectedStatus(searchData.maritalStatus.get(0).toString(), opt_MaritialStatus);
		}
	}

	public void checkChildrenStatus(SearchData searchData) {
		clickPreferenceField("", drodropDownChildStatusList);// clicking on have children field

		SelectHaveChildrenValue("Doesn't Matter", 1);// selecting value from pickerwheel iOS

		ClickApply();

		clickPreferenceField("", drodropDownChildStatusList);// clicking on have children again

		for (int i = 0; i < searchData.haveChildren.size(); i++) {
			// the below code cannot work on ioS since at a time only one value can be
			// selected
			// from the picker wheel ,which is not the same in the case of Android

			SelectHaveChildrenValue(searchData.haveChildren.get(i).toString(), searchData.haveChildren.size());

		}

		ClickApply();

		if (searchData.haveChildren.size() > 1) {
			AssertHaveChildren("Multiple Selected");
		} else {
			AssertHaveChildren(searchData.haveChildren.get(0).toString());
		}
	}

	public void checkReligionStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", dropDownReligion);// CLICKING RELIGION FIELD WITH INDEX 5
		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR RELEGION
		ClickApply();
		clickPreferenceField("", dropDownReligion);
		for (int i = 0; i < searchData.religion.size(); i++) {
			selectStatusValue(searchData.religion.get(i).toString(), searchData.religion.size());// REPLACED WITH
																									// GENERIC BEHAVIOUR

		}

		ClickApply();

		if (searchData.religion.size() > 1) {

			assertSelectedStatus(convertToStr(searchData.religion, searchData.religion.size()), opt_Religion);// REPLACED
																												// WITH
																												// GENERIC
			// BEHAVIOUR

		} else {
			assertSelectedStatus(searchData.religion.get(0).toString(), opt_Religion);
		}

	}

	public void checkComunityStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", dropDownCommunity); // CLICKING Community FIELD WITH INDEX 6

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR Community

		ClickApply();

		clickPreferenceField("", dropDownCommunity);

		for (int i = 0; i < searchData.community.size(); i++) {
			selectStatusValue(searchData.community.get(i).toString(), searchData.community.size());// REPLACED WITH
			// GENERIC BEHAVIOUR
		}

		ClickApply();

		if (searchData.community.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.religion, searchData.religion.size()), dropDownCommunity);// REPLACED
																													// WITH
																													// GENERIC
			// BEHAVIOUR
		} else {
			assertSelectedStatus(searchData.community.get(0).toString(), dropDownCommunity);
		}
	}

	public void checkMotherTongue(SearchData searchData) throws InterruptedException {

		clickPreferenceField("", dropDownMotherTongue);// CLICKING MOTHER TOUGUE FIELD WITH INDEX 5

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR MOTHER TOUNGE

		ClickApply();

		clickPreferenceField("", dropDownMotherTongue);

		for (int i = 0; i < searchData.motherTongue.size(); i++) {

			selectStatusValue(searchData.motherTongue.get(i).toString(), searchData.motherTongue.size());

		}

		ClickApply();

		if (searchData.motherTongue.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.motherTongue, searchData.motherTongue.size()),
					opt_MotherTongue);// REPLACED WITH
			// GENERIC
			// BEHAVIOUR

		} else {
			AssertMotherTongue(searchData.motherTongue.get(0).toString());
		}
	}

	public void checkCountryStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", dropDownCountry);// CLICKING COUNTRY FIELD WITH INDEX 9

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR COUNTRY

		ClickApply();

		clickPreferenceField("", dropDownCountry);

		for (int i = 0; i < searchData.country.size(); i++) {
			selectStatusValue(searchData.country.get(i).toString(), searchData.country.size());// REPLACED WITH GENERIC
																								// BEHAVIOUR

		}

		ClickApply();

		if (searchData.country.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.country, searchData.country.size()), opt_CountryLiving);// REPLACED
																													// WITH
																													// GENERIC
			// BEHAVIOUR

		} else {
			AssertCountry(searchData.country.get(0).toString());
		}
	}

	public void checkStateStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", dropDownState);// CLICKING STATE FIELD WITH INDEX 10

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR STATE

		ClickApply();

		clickPreferenceField("", dropDownState);// CLICKING STATE FIELD WITH INDEX 10

		for (int i = 0; i < searchData.state.size(); i++) {
			selectStatusValue(searchData.state.get(i).toString(), searchData.state.size());// REPLACED WITH GENERIC
																							// BEHAVIOUR

		}

		ClickApply();

		if (searchData.state.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.state, searchData.state.size()), opt_State);// REPLACED
																										// WITH
																										// GENERIC
			// BEHAVIOUR

		} else {
			AssertState(searchData.state.get(0).toString());
		}

		// scrollUpToDown();
	}

	public void checkCityStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", dropDownCity);// CLICKING City FIELD WITH INDEX 11

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR STATE

		ClickApply();

		clickPreferenceField("", dropDownCity);// CLICKING STATE FIELD WITH INDEX 11

		for (int i = 0; i < searchData.city.size(); i++) {
			selectStatusValue(searchData.city.get(i).toString(), searchData.city.size());// REPLACED WITH GENERIC
																							// BEHAVIOUR

		}
		ClickApply();

		if (searchData.city.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.city, searchData.city.size()), opt_City);// REPLACED
																									// WITH
																									// GENERIC
			// BEHAVIOUR

		} else {
			AssertCity(searchData.city.get(0).toString());
		}
	}

	public void checkManglikStatus(SearchData searchData) {
		ClickManglik();

		SelectManglikValue("Doesn't Matter", 1);

		ClickApply();

		ClickManglik();

		for (int i = 0; i < searchData.Manglik.size(); i++) {
			SelectManglikValue(searchData.Manglik.get(i).toString(), searchData.Manglik.size());
		}

		ClickApply();

		if (searchData.Manglik.size() > 1) {
			AssertManglik("Multiple Selected");
		} else {
			AssertManglik(searchData.Manglik.get(0).toString());
		}

	}

	public void checkPhotoStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", dropDownPhoto);// CLICKING PHOTO FIELD WITH INDEX 14

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR PHOTO

		ClickApply();

		clickPreferenceField("", dropDownPhoto);// CLICKING PHOTO FIELD WITH INDEX 14

		for (int i = 0; i < searchData.PhotoSettings.size(); i++) {
			selectStatusValue(searchData.PhotoSettings.get(i).toString(), searchData.PhotoSettings.size());// REPLACED
																											// WITH
																											// GENERIC
																											// BEHAVIOUR
		}

		ClickApply();

		if (searchData.PhotoSettings.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.PhotoSettings, searchData.PhotoSettings.size()),
					dropDownPhotoSettingsList);// REPLACED
			// WITH
			// GENERIC
			// BEHAVIOUR

		}

		else {
			AssertPhotoSettings(searchData.PhotoSettings.get(0).toString(), dropDownPhotoSettingsList);
		}
	}

	public void scrollDownTillRemindMessage() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.40)).waitAction(4000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public void navigateToMyMatches() {
		BasePageActions.navigateToMatchesTab(myMatchesTab);
		waitForSometime(2000);

	}

	public void ClickPhoto() throws InterruptedException {

		BasePageActions.AssertEquals(txtButtonHeadingTwo, "Get more responses, add Photos", "");
		Thread.sleep(2000);
		System.out.println("Inside click photo method");
		waitForElementToBeDisplayed(btnAddPhotoTwo, "", "");
		System.out.println("add photo button found");
		btnAddPhotoTwo.click();
		isElementFoundAndClickable(btnCamera, "Open Camera", "TC-21");
		if (isDisplayed(cameraAcceptButton)) {
			cameraAcceptButton.click();
			if (isDisplayed(cameraAcceptButton))
				cameraAcceptButton.click();
		}

		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void ScrolTillPhotoCard() {
		waitForSometime(2000);
		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Get more responses, add Photos\"));");

	}

	public void ScrolTillMoreResponse() {
		((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Get more responses, add Photos\"));");

	}

	public void verifyCardDetails() {

		try {

			if (txtButtonHeading.isDisplayed()) {
				int x = 300;
				int y = 400;
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(x, y).moveTo(x, y + 35).release().perform();
				AssertEquals(txtSubHeading, "get missed frequently", "Verify Sub Heading");
				isElementDisplayed(photoCardOptions, "Verify Profile Options", "TC-1");
				isElementDisplayed(photoCardSHeild, "Verify Sheild on card", "TC-2");
				isElementDisplayed(txtOnlineStatus, "Verify Online Status", "TC-3");
				isElementDisplayed(txtAgeAndHeight, "Verify Height on card", "TC-4");
				isElementDisplayed(txtReligion, "Verify religion on Card", "TC-5");
				isElementDisplayed(txt_Profession, "Verify Professio on Card", "TC-6");
				isElementDisplayed(txt_Place, "Verify location on card", "TC-7");
				ScrolTillMoreResponse();
				AssertEquals(txtButtonHeading, "Get more responses, add Photos", "Text Verify");
				isElementDisplayed(btnAddPhoto, "Verify Add Photo button", "TC-9");
			}

		} catch (Exception e) {
			int x = 300;
			int y = 400;
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x, y).moveTo(x, y + 30).release().perform();
			AssertEquals(txtHeadingTwo, "Members with Photos", "Verify Header text");
			AssertEquals(txtSubHeadingTwo, "get twice as many responses", "Verify Sub Heading");
			isElementDisplayed(imgDislike, "Verify dislike image", "TC-10");
			isElementDisplayed(imgLike, "Verify like image", "TC-11");
			isElementDisplayed(imgAvatarLeft, "Verify left image", "TC-12");
			isElementDisplayed(imgAvatarRight, "Verify right image", "TC-13");
			isElementDisplayed(imgProfileLeft, "Verify Left Profile card", "TC-14");
			isElementDisplayed(imgProfileRight, "Verify rught profile card", "TC-15");

			AssertEquals(txtButtonHeadingTwo, "Get more responses, add Photos", "TC-16");
			isElementDisplayed(btnAddPhotoTwo, "Verify Add Photo button", "TC-17");
		}
	}

	public void manageDummyClick(boolean flag) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		clickPreferenceField("", dropDownMartialStatusList);

		Thread.sleep(4000);

		if (SearchTest.clickFlag == true)

		{
			driver.navigate().back();
		}

		SearchTest.clickFlag = false;

	}

	@SuppressWarnings("rawtypes")
	public String selectDropdown(WebElement dropDownButton, WebElement dd_option, String dd_value, SoftAssert sa)
			throws InterruptedException {

		SwipeNext.click();
		String profilename = null;
		boolean flag = false;
		while (!flag) {
			waitForElementToBeDisplayed(dropDownButton, "", "");
			click(dropDownButton, "Click Drop Down Icon", "Test-03");
			waitForSometime(2000);

			if (isDisplayed(dd_option)) {
				waitForSometime(1000);
				if (RunEnvironment.equals("iOSLocal")) {
					btn_dd_Cancel.click();
				} else {
					driver.navigate().back();
				}

				waitForSometime(1000);
				profilename = getText(UserName, "Get member name");
				Dashboard_Shortlist_Connect_ignore_test.shortListedProfileName = profilename;
				System.out.println("Member name before clicking on" + dd_value + ":" + profilename);
				click(dropDownButton, "Click on the dropdown arrow", "SL01");
				waitForSometime(2000);
				click(dd_option, "Click on dd option", "SL01");
				if (dd_value.equalsIgnoreCase("shortlist")) {
					waitForElementToBeDisplayed(PrevArrowBtn, "", "");
					Thread.sleep(3000);
					PrevArrowBtn.click();
					waitForElementToBeDisplayed(dropDownButton, "Menu", "Test-03");
					click(dropDownButton, "Click on the dropdown arrow", "SL01");
					waitForSometime(2000);
					if (chckElementPresent(btn_dd_Cancel)) {
						btn_dd_Cancel.click();
					}

					if (chckElementPresent(dd_removeshortlist)) {
						sa.assertTrue(chckElementPresent(dd_removeshortlist),
								"Remove Shortlist Option is seen for the profile");
					}
				}
				flag = true;
			} else {
				waitForSometime(2000);
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				waitForElementToBeDisplayed(ProfilePageNext, "", "");
				click(ProfilePageNext, "Click to Swipe next profile", "Test-03");

			}

		}

		return profilename;
	}

	public boolean verifyIgnoreOptionIOS() throws InterruptedException {
		boolean ignoreOptnIsSeen = true;

		waitForElementToBeDisplayed(dropDownThreeDots, "", "");

		dropDownThreeDots.click();

		ignoreOptnIsSeen = chckElementPresent(dd_ignoreProfile);

		btn_dd_Cancel.click();

		return ignoreOptnIsSeen;
	}

	public void sendConnectToProfile() throws InterruptedException {
		String connectSentProfile;

		Dashboard_Shortlist_Connect_ignore_test.menu.clickMyShaadiTabForAppRating();

		// Wait for Premium Matches Header
		if (chckElementPresent(Dashboard_Shortlist_Connect_ignore_test.shaadipage.txtHelp)) {
			scrollUpToElement(Dashboard_Shortlist_Connect_ignore_test.shaadipage.myShaadiPageUsername);

		}

		waitForElementToBeDisplayed(Dashboard_Shortlist_Connect_ignore_test.shaadipage.myShaadiPageUsername, "", "");
		Dashboard_Shortlist_Connect_ignore_test.shaadipage.scrolltillpremiummatches();

		if (RunEnvironment.equals("iOSLocal")) {

			waitForSometime(3000);
			if (chckElementPresent(UserName_OnListing) == true) {
				scrollDownToElement(UserName_OnListing);
				connectSentProfile = UserName_OnListing.getText();
			} else {
				scrollDownToElement(UserName_OnListing_FreeUser);
				connectSentProfile = UserName_OnListing_FreeUser.getText();

			}
			// Go back to Myshaadi dashboard
			while (chckElementPresent(Dashboard_Shortlist_Connect_ignore_test.matchespage.btn_backArrow)) {
				Dashboard_Shortlist_Connect_ignore_test.matchespage.btn_backArrow.click();

			}
			// Scroll is added because ios page automatically scrolls down
			waitForSometime(5000);
			if (chckElementPresent(Dashboard_Shortlist_Connect_ignore_test.shaadipage.txtHelp)) {
				scrollUpToElement(Dashboard_Shortlist_Connect_ignore_test.shaadipage.myShaadiPageUsername);

			}

			// Adding Two connect clicks since first click is not responding
			Dashboard_Shortlist_Connect_ignore_test.shaadipage.connectNowCarausal.click();

			if (isDisplayed(Dashboard_Shortlist_Connect_ignore_test.shaadipage.btn_SendMsg)) {
				Dashboard_Shortlist_Connect_ignore_test.shaadipage.btn_SendMsg.click();
			}

			waitForSometime(3000);

			if (chckElementPresent(Dashboard_Shortlist_Connect_ignore_test.shaadipage.txtHelp)) {
				scrollUpToElement(Dashboard_Shortlist_Connect_ignore_test.shaadipage.myShaadiPageUsername);

			}

			System.out.println(connectSentProfile);
			Dashboard_Shortlist_Connect_ignore_test.connectSentSplit = connectSentProfile.split(" ", 2);
			Dashboard_Shortlist_Connect_ignore_test.connectSendPorfileName = connectSentProfile;
			waitForSometime(3000);

		}

		else {
			scrollUp();
			waitForSometime(2000);
			if (BaseTest.UserType.contains("premium")) {
				scrollDownToElement(connectNowButtonOnListingPageAndroid);
				scrollDownToElement(UserName);
				connectSentProfile = UserName.getText();
				click(connectNowButtonOnListingPageAndroid, "Click on top Connect Now CTA", "sendTopCTAConnect");
				sendMessageOnConnectPremium();
			} else {
				scrollDownToElement(AlbumConnect);
				scrollDownToElement(UserName);
				connectSentProfile = UserName.getText();
				click(AlbumConnect, "Click on top Connect Now CTA", "sendTopCTAConnect");

			}
			click(Dashboard_Shortlist_Connect_ignore_test.shaadipage.backButton, "click on back button", "");
			System.out.println(connectSentProfile);
			Dashboard_Shortlist_Connect_ignore_test.connectSentSplit = connectSentProfile.split(" ", 2);
			waitForSometime(500);

		}

	}

	public void verifyConnectSentToProfile() {
		if (RunEnvironment.equals("iOSLocal")) {

			WebElement profileName = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='"
					+ Dashboard_Shortlist_Connect_ignore_test.connectSendPorfileName + "']"));

			scrollDownToElement(profileName);

		} else {
			// Added because off banner visibility
			scrollDownToElement(Dashboard_Shortlist_Connect_ignore_test.inboxpage.profileNameOnSentItemsListing);
		}

		String nameOnSentList = Dashboard_Shortlist_Connect_ignore_test.inboxpage.profileNameOnSentItemsListing
				.getText();

		Assert.assertTrue(nameOnSentList.contains(Dashboard_Shortlist_Connect_ignore_test.connectSentSplit[0]),
				"Profile name in Sent Tab not equal to the connect sent profile name");

	}

	public void verifyShortlistedMember(BottomMenu menu, String shortlistedProfile) throws InterruptedException {
		boolean isprofilePresent = false;
		menu.clickOnMatches();

		if (RunEnvironment.equals("iOSLocal")) {

			MyMatchestabIOS.click();
			NearMetabIOS.click();
			Thread.sleep(2000);
			MoreMatchestab.click();
			ShortlistTab.click();

			Thread.sleep(2000);

			waitForSometime(90000);

			scrollUp();
			Thread.sleep(3000);
			scrollUp();
			Thread.sleep(5000);

			isprofilePresent = scrollDownToElement_By(
					By.xpath("//XCUIElementTypeStaticText[@value='" + shortlistedProfile + "']"));

			scrollUp();
			scrollUp();

			Assert.assertTrue(isprofilePresent, "The shortlisted profile was found in Shortlisted TAB");

		} else {

			BasePageActions.navigateToSpecifiedMatchesTab(Shortlists, "Navigate to Shortlists tab");
			// newly added to refresh the shortlist tab
			Thread.sleep(2000);
			scrollUp();
			Thread.sleep(2000);
			scrollUp();

			sa.assertEquals(myMatchesHeaderTextAndroid.getText(), "Shortlisted Members",
					"Shortlisted page is not displayed");
			scrollDownToElement(tvListingUserName);
			String after = tvListingUserName.getText();
			System.out.println("Member name after adding to Shortlists: " + after);
			if (after.equalsIgnoreCase(shortlistedProfile)) {
				sa.assertEquals(after, shortlistedProfile, "Member is not added to Shortlists");
			} else {
				System.out.println("Profile not visible , Waiting 90 secs for shortlist tab to update");
				waitForSometime(90000);
				scrollUp();
				scrollUp();
				Thread.sleep(1000);
				scrollUp();
				scrollDownToElement(tvListingUserName);
				after = tvListingUserName.getText();
				System.out.println("Member name after adding to Shortlists: " + after);
				sa.assertEquals(after, shortlistedProfile, "Member is not added to Shortlists");

			}

		}

	}

	public void verifyIgnoreMember(String ignoredProfile) throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {
			boolean isprofilePresent = false;

			RVTab.click();

			waitForSometime(3000);

			scrollDownToElement(btnSeeAllIgnored);

			btnSeeAllIgnored.click();

			isprofilePresent = elementPresent_By(
					By.xpath("//XCUIElementTypeStaticText[@value='" + ignoredProfile + "']"));

			waitForSometime(3000);

			Assert.assertFalse(isprofilePresent, "The Profile should not be in the list");

		}

		else {

			navigateToSpecifiedMatchesTab(RecentlyViewed, "Navigate to recently viewed Tab");
			waitForSometime(5000);

			scrollDownToElement(profilesYouIgnored);

			Dashboard_Shortlist_Connect_ignore_test.inboxpage.AssertFirstName(
					Dashboard_Shortlist_Connect_ignore_test.inboxpage.ignornedMemberProfileName, ignoredProfile,
					"String description");
		}

	}

	public void verifyAdvanceSearchNew(AdvanceSearchData searchData) throws InterruptedException {

		// Checks if the Age and Height parameters are present on search page
		waitForElementToBeDisplayed(txt_ageSearchPage, "Wait for search page to load", "");
		sa.assertTrue(chckElementPresent(txt_ageSearchPage), "Age parameter not present on search page");
		sa.assertTrue(chckElementPresent(txt_minAgeSearchpage), "Minimum age parameter not present on search page");
		sa.assertTrue(chckElementPresent(txt_maxAgeSearchpage), "Maximum age parameter not present on search page");
		sa.assertTrue(chckElementPresent(txt_heightSearchPage), "Height parameter not present on search page");
		sa.assertTrue(chckElementPresent(txt_minHeightSearchpage),
				"Minimum Height parameter not present on search page");
		sa.assertTrue(chckElementPresent(txt_maxHeightSearchpage),
				"Maximum Height parameter not present on search page");

		waitForElementToBeDisplayed(maritialStatusDropdown, "Wait for Marital Status Dropdown to be visible", "");
		selectingParameters_new(maritialStatusDropdown, searchData.maritalStatus);
		selectingParameters_new(religion, searchData.religion);
		selectingParameters_new(community, searchData.community);
		selectingParameters_new(motherTongue, searchData.motherTongue);
		selectingParameters_new(country, searchData.country);
		selectingParameters_new(state, searchData.state);
		selectingParameters_new(countryGrewUpIn, searchData.countryGrewUpIn);

		scrollDownToElement(moreSearchOptions);
		Thread.sleep(1000);
		moreSearchOptions.click();

		selectingParameters_new(photoSettings, searchData.PhotoSettings);
		selectingParameters_new(education, searchData.education);
		selectingParameters_new(educationArea, searchData.educationArea);
		selectingParameters_new(workingWith, searchData.workingWith);
		selectingParameters_new(professionalArea, searchData.ProfessionArea);

		scrollDownToElement(doesNotMatterSearchpageAndroid);
		if (areElementsOverlapping(doesNotMatterSearchpageAndroid, searchNowButton)) {
			scrollDownSlow();
		}
		Thread.sleep(1000);
		doesNotMatterSearchpageAndroid.click();

		profileThatHaveFilteredMeOutAsWell("ON");
		profileThatIHaveAlreadyViewed("ON");
		clickSearchButton();

		if (isDisplayed(btnGotIt))
			btnGotIt.click();

		click(backButton, "click on back button", "");

		sa.assertAll();

	}

	public void verifyAdvanceSearch(AdvanceSearchData searchData) throws InterruptedException {

		// Checks if the Age and Height parameters are present on search page
		waitForElementToBeDisplayed(txt_ageSearchPage, "", "");
		sa.assertTrue(chckElementPresent(txt_ageSearchPage));
		sa.assertTrue(chckElementPresent(txt_minAgeSearchpage));
		sa.assertTrue(chckElementPresent(txt_maxAgeSearchpage));
		sa.assertTrue(chckElementPresent(txt_heightSearchPage));
		sa.assertTrue(chckElementPresent(txt_minHeightSearchpage));
		sa.assertTrue(chckElementPresent(txt_maxHeightSearchpage));

		waitForElementToBeDisplayed(maritialStatusDropdown, "", "");
		selectingParameters(maritialStatusDropdown, searchData.maritalStatus);
		selectingParameters(religion, searchData.religion);
		scrollUsingTouchActionsByElements(religionDropDownMobileElement(), searchOptions());

		selectingParameters(community, searchData.community);
		selectingParameters(motherTongue, searchData.motherTongue);
		selectingParameters(country, searchData.country);
		scrollUsingTouchActionsByElements(countryLivingInMobile(), communityMobile());

		selectingParameters(state, searchData.state);

		selectingParameters(countryGrewUpIn, searchData.countryGrewUpIn);
		scrollUsingTouchActionsByElements(residencystatusMobile(), countryLivingInMobile());

		scrollDownToElement(moreSearchOptions);

		selectingParameters(photoSettings, searchData.PhotoSettings);
		scrollUsingTouchActionsByElements(educationAndProfessionalDetails(), cityMobile());
		selectingParameters(education, searchData.education);
		selectingParameters(educationArea, searchData.educationArea);
		selectingParameters(workingWith, searchData.workingWith);
		selectingParameters(professionalArea, searchData.ProfessionArea);
		scrollUsingTouchActionsByElements(professDropdown(), educationAndProfessionalDetails());
		doesNotMatterSearchpageAndroid.click();

		scrollUsingTouchActionsByElements(dietMobile(), professionMobile());
		profileThatHaveFilteredMeOutAsWell("ON");
		profileThatIHaveAlreadyViewed("ON");
		clickSearchButton();

		if (isDisplayed(btnGotIt))
			btnGotIt.click();

		click(backButton, "click on back button", "");

		sa.assertAll();

	}

	public void verifyProfileSearch() throws InterruptedException {

		clickSearch();
		waitForElementToBeDisplayed(ProfileIDSearchTabAndroid, "wait for profile search tab", "");
		click(ProfileIDSearchTabAndroid, "Click on Profile ID search on Matches Search Page", "");
		waitForElementToBeDisplayed(profileIDSearchAndroid, "wait for Profile ID search page to load", "");
		AssertEquals(profileIDSearchAndroid, "For example - SHXXXXXXX1",
				"Verify the auto populated text on profile ID search bar");
		InputValue(profileIDSearchAndroid, AppStringConstants.profileSHID, "Enter the profile SHID", "");
		click(goToProfileButtonAndroid, "click on got to profile button", "");
		waitForElementToBeDisplayed(UserName, "wait for Profile page to load", "");
		AssertEquals(UserName, AppStringConstants.profileName, "Verify profile name is correct for SHID entered");
		driver.navigate().back();
		waitForElementToBeDisplayed(profileIDSearchAndroid, "wait for search tab", "");

	}

	// **************************************************************************************************************8

	public String shortlistUserFromProfilePage(WebElement dropdownbutton) throws InterruptedException {
		String profilename = "";
		click(SwipeNext, "Click to Swipe next profile", "Test-03");
		waitForSometime(1000);
		boolean flag = false;
		boolean counterflag = false;
		int i = 0;
		while (!flag && !counterflag) {
			// if Deleted profile is found in swipe next operation
			while (!isDisplayedAfterWait(UserName, 3)) {
				SwipeNext.click();
			}

			i++; // Counter to restrict the script from checking more than 5 profiles

			profilename = UserName.getText();
			click(dropdownbutton, "Click Drop Down Icon", "Test-03");
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (isDisplayedAfterWait(dd_shortlistProfile, 3)) {
					AssertEquals(dd_shortlistProfile, "Add to Shortlist", "Verify the text -- Add to Shortlist");
					click(dd_shortlistProfile, "Click on Shortlist profile from dropdown options", "");
					flag = true;
				} else {
					waitForSometime(1000);
					driver.navigate().back();
					click(SwipeNext, "Click to Swipe next profile", "");
					if (i == 5) {
						counterflag = true;
					}
				}
			} else {
				if (dd_shortlistProfile.getText().equals("Add to Shortlist")) {
					AssertEquals(dd_shortlistProfile, "Add to Shortlist", "Verify the text -- Add to Shortlist");
					click(dd_shortlistProfile, "Click 1st Value", "Test-03");
					flag = true;
				} else {
					waitForSometime(2000);
					btn_dd_Cancel.click();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			}
		}

		if (flag) {

			Thread.sleep(3000);
			click(SwipePrev, "Click to Swipe to prev profile", "Test-03");
			click(dropdownbutton, "Click Drop Down Icon", "Test-03");

			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				AssertEquals(dd_removeshortlist, "Remove from Shortlist", "Verify the text -- Remove from Shortlist");
				Thread.sleep(1000);
				driver.navigate().back();
			} else {
				AssertEquals(dd_removeshortlist, "Remove from Shortlist", "Verify the text -- Remove from Shortlist");
				btn_dd_Cancel.click();
			}
			click(SwipeNext, "Click to Swipe next profile", "Test-03");

			System.out.println("Shortlisted profile :" + profilename);

		} else {

			System.out.println("Add to shortlist option not present");
		}

		return profilename;

	}

	// ****************************************************************************************************************

	public String shortlistUserFromProfilePage() throws InterruptedException {
		String profilename = "";
		click(SwipeNext, "Click to Swipe next profile", "Test-03");
		waitForSometime(2000);
		boolean flag = false;
		while (!flag) {
			// if Delete profile is found in swipe next operation
			while (!isDisplayedAfterWait(UserName, 3)) {
				SwipeNext.click();
			}
			profilename = UserName.getText();
			click(DropDownIcon, "Click Drop Down Icon", "Test-03");
			waitForSometime(2000);
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (DropdownText.get(0).getText().equals("Add to Shortlist")) {
					AssertEquals(DropdownText.get(0), "Add to Shortlist", "Verify the text -- Add to Shortlist");
					click(DropdownText.get(0), "Click 1st Value", "Test-03");
					flag = true;
				} else {
					waitForSometime(2000);
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			} else {
				if (dd_shortlistProfile.getText().equals("Add to Shortlist")) {
					AssertEquals(dd_shortlistProfile, "Add to Shortlist", "Verify the text -- Add to Shortlist");
					click(dd_shortlistProfile, "Click 1st Value", "Test-03");
					flag = true;
				} else {
					waitForSometime(2000);
					btn_dd_Cancel.click();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			}
		}
		Thread.sleep(3000);
		click(SwipePrev, "Click to Swipe to prev profile", "Test-03");
		click(DropDownIcon, "Click Drop Down Icon", "Test-03");
		Thread.sleep(2000);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			AssertEquals(DropdownText.get(0), "Remove from Shortlist", "Verify the text -- Remove from Shortlist");
			driver.navigate().back();
		} else {
			AssertEquals(dd_removeshortlist, "Remove from Shortlist", "Verify the text -- Remove from Shortlist");
			btn_dd_Cancel.click();
		}
		click(SwipeNext, "Click to Swipe next profile", "Test-03");

		System.out.println("Shortlisted profile :" + profilename);

		return profilename;
	}

	// ************************************************************************************************

	public String blockUserFromProfilePage(WebElement dropdownbutton) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String profilename = "";
		Thread.sleep(1000);
		click(SwipeNext, "Click on next profile on profile page", "");
		boolean flag = false;
		while (!flag) {
			// if Deleted profile is found in swipe next operation
			while (!isDisplayedAfterWait(UserName, 3)) {
				click(SwipeNext, "Click on next profile on profile page", "");
			}
			profilename = UserName.getText();
			Thread.sleep(1000);
			click(dropdownbutton, "Click on dropdown button", "");
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (isDisplayedAfterWait(dd_blockProfile, 3)) {
					click(dd_blockProfile, "Click on Block profile from dropdown options", "");
					click(OKblock, "Click OK to Block Profile profile", "MT13");
					flag = true;
				} else {
					waitForSometime(1000);
					driver.navigate().back();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			} else {
				if (chckElementPresent(dd_blockProfile) == true) {
					click(dd_blockProfile, "Click on Block profile from dropdown options", "");
					click(OKblock, "Click OK to Block Profile profile", "MT13");
					flag = true;
				} else {
					waitForSometime(1000);
					btn_dd_Cancel.click();
					Thread.sleep(1000);
					SwipeNext.click();

				}

			}
		}
		Thread.sleep(3000);

		click(PrevArrowBtn, "CLick on button to go back to the blocked profile", "");

		if (isDisplayedAfterWait(BlockedMemberTxt, 3)) {
			sa.assertEquals(BlockedMemberTxt.getText(), "Blocked Member", "Blocked Member text not displayed");
		} else {
			sa.assertEquals(blockedText_new.getText(), "You blocked this Profile", "Blocked Member text not displayed");

		}

		click(dropdownbutton, "Click on dropdown button", ""); // To check unblock option is present
		sa.assertTrue(isDisplayed(dd_UnblockProfile),
				"Unblock profile Option not present in dropdown list after blocking the profile");
		Thread.sleep(1000);
		System.out.println("Unblock option verified after block");
		driver.navigate().back();

		click(SwipeNext, "Move to next profile", "");

		System.out.println("Blocked profile :" + profilename);

		sa.assertAll();

		return profilename;
	}

	// ************************************************************************************************

	public String blockUserFromProfilePage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String profilename = "";
		Thread.sleep(2000);
		SwipeNext.click();
		waitForSometime(2000);
		boolean flag = false;
		while (!flag) {
			// if Delete profile is found in swipe next operation
			while (!isDisplayedAfterWait(UserName, 3)) {
				SwipeNext.click();
			}
			profilename = UserName.getText();
			Thread.sleep(1000);
			DropDownIcon.click();
			waitForSometime(2000);
			if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
				if (DropdownText.size() >= 3 && DropdownText.get(2).getText().contains("Block")) {
					click(DropdownText.get(2), "Click 1st Value", "Test-03");
					click(OKblock, "Click OK to Block Profile profile", "MT13");
					flag = true;
				} else if (isDisplayed(DropdownText.get(1))) {
					if (DropdownText.get(1).getText().contains("Block")) {
						click(DropdownText.get(1), "Click 1st Value", "Test-03");
						click(OKblock, "Click OK to Block Profile profile", "MT13");
						flag = true;
					}
				} else if (DropdownText.get(0).getText().contains("Block")) {

					click(DropdownText.get(0), "Click 1st Value", "Test-03");
					click(OKblock, "Click OK to Block Profile profile", "MT13");
					flag = true;
				} else {
					waitForSometime(2000);
					driver.navigate().back();
					click(SwipeNext, "Click to Swipe next profile", "Test-03");

				}
			} else {
				if (chckElementPresent(dd_blockProfile) == true) {
					click(dd_blockProfile, "Click 1st Value", "Test-03");
					click(OKblock, "Click OK to Block Profile profile", "MT13");
					flag = true;
				} else {
					waitForSometime(2000);
					btn_dd_Cancel.click();
					Thread.sleep(1000);
					SwipeNext.click();

				}

			}
		}
		Thread.sleep(5000);

		PrevArrowBtn.click();

		Thread.sleep(3000);

		waitForElementToBeDisplayed(BlockedMemberTxt, "", "");

		sa.assertEquals(BlockedMemberTxt.getText(), "Blocked Member", "Blocked Member text not displayed");

		SwipeNext.click();

		System.out.println("Blocked profile :" + profilename);

		sa.assertAll();

		return profilename;
	}

	// ****************************************************************************************************

	public String ignoreUserFromProfilePage(WebElement dropdownbutton) throws InterruptedException {
		String profilename = "";

		if (UserType.contains("premium")) {

			SoftAssert sa = new SoftAssert();
			click(SwipeNext, "Click to Swipe next profile", "Test-03");
			waitForSometime(2000);
			boolean flag = false;
			while (!flag) {
				// if Delete profile is found in swipe next operation
				while (!isDisplayedAfterWait(UserName, 3)) {
					SwipeNext.click();
				}
				profilename = UserName.getText();
				click(dropdownbutton, "Click Drop Down Icon", "Test-03");
				waitForSometime(2000);
				if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
					if (isDisplayedAfterWait(dd_ignoreProfile, 3)) {
						click(dd_ignoreProfile, "Click 1st Value", "Test-03");
						flag = true;
					} else {
						waitForSometime(2000);
						driver.navigate().back();
						click(SwipeNext, "Click to Swipe next profile", "Test-03");

					}
				} else {

					// not there on iOS for now
					if (isDisplayed(dd_ignoreProfile)) {
						if (dd_ignoreProfile.getText().contains("Don't Show Again")) {
							click(dd_ignoreProfile, "Click 1st Value", "Test-03");
							flag = true;
						} else {
							waitForSometime(2000);
							btn_dd_Cancel.click();
							click(SwipeNext, "Click to Swipe next profile", "Test-03");
						}
					} else {
						break;
					}

				}

			}
			Thread.sleep(3000);
			click(PrevArrowBtn, "Go to previous ignored profile", "MT13");

			if (UserType.contains("premium")) {
				waitForElementToBeDisplayed(BlockedMemberTxt, "", "");
				sa.assertEquals(BlockedMemberTxt.getText(), "Ignored Member", "Ignored Member text not displayed");
			} else {
				waitForElementToBeDisplayed(IgnoredMemText, "", "");
				sa.assertEquals(IgnoredMemText.getText(), "Ignored Member", "Ignored Member text not displayed");

			}
			click(SwipeNext, "Click to Swipe next profile", "Test-03");

			System.out.println("Ignored profile :" + profilename);

			sa.assertAll();

		}

		return profilename;

	}

	// ****************************************************************************************************

	public String ignoreUserFromProfilePage() throws InterruptedException {
		String profilename = "";

		if (UserType.contains("premium")) {

			SoftAssert sa = new SoftAssert();
			click(SwipeNext, "Click to Swipe next profile", "Test-03");
			waitForSometime(2000);
			boolean flag = false;
			while (!flag) {
				// if Delete profile is found in swipe next operation
				while (!isDisplayedAfterWait(UserName, 3)) {
					SwipeNext.click();
				}
				profilename = UserName.getText();
				click(DropDownIcon, "Click Drop Down Icon", "Test-03");
				waitForSometime(2000);
				if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
					if (DropdownText.get(1).getText().contains("Don't Show Again")) {
						click(DropdownText.get(1), "Click 1st Value", "Test-03");
						flag = true;
					} else if (isDisplayed(DropdownText.get(2))) {
						if (DropdownText.get(2).getText().contains("Don't Show Again")) {
							click(DropdownText.get(2), "Click 1st Value", "Test-03");
							flag = true;
						}
					} else {
						waitForSometime(2000);
						// ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
						driver.navigate().back();
						click(SwipeNext, "Click to Swipe next profile", "Test-03");

					}
				} else {

					// not there on iOS for now
					if (isDisplayed(dd_ignoreProfile)) {
						if (dd_ignoreProfile.getText().contains("Don't Show Again")) {
							click(dd_ignoreProfile, "Click 1st Value", "Test-03");
							flag = true;
						} else {
							waitForSometime(2000);
							btn_dd_Cancel.click();
							click(SwipeNext, "Click to Swipe next profile", "Test-03");
						}
					} else {
						break;
					}

				}

			}
			Thread.sleep(3000);
			click(PrevArrowBtn, "Go to previous ignored profile", "MT13");

			if (UserType.contains("premium")) {
				waitForElementToBeDisplayed(BlockedMemberTxt, "", "");
				sa.assertEquals(BlockedMemberTxt.getText(), "Ignored Member", "Ignored Member text not displayed");
			} else {
				waitForElementToBeDisplayed(IgnoredMemText, "", "");
				sa.assertEquals(IgnoredMemText.getText(), "Ignored Member", "Ignored Member text not displayed");

			}
			click(SwipeNext, "Click to Swipe next profile", "Test-03");

			System.out.println("Ignored profile :" + profilename);

			sa.assertAll();

		}

		return profilename;

	}

	public void verifyDropDownOptions() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		List<String> dropDownList = new ArrayList<>();
		dropDownList.add("Add to Shortlist");
		dropDownList.add("Remind");
		dropDownList.add("Cancel request");
		dropDownList.add("Remove from Shortlist");
		dropDownList.add("Don't Show Again");
		dropDownList.add("Block Profile");
		dropDownList.add("Report Profile");

		if (isDisplayedAfterWait(DropDownArrow, 3)) {

			if (isDisplayedAfterWait(refineButtonOnListing, 2)) {
				while (areElementsOverlapping(refineButtonOnListing, DropDownArrow)) {
					Thread.sleep(1000);
					scrollDown();

				}
			}

			scrollDownToElement(DropDownArrow);
			click(DropDownArrow, "Click on the dropdown arrow", "SL03");
			int size = DropDownValue.size();
			System.out.println(size);

			for (WebElement e : DropDownValue) {
				for (String s : dropDownList) {
					if (e.getText().contains(s))
						sa.assertTrue(e.getText().contains(s), "Dropdown options does not match");

				}
			}

		}

		else {

			if (isDisplayedAfterWait(refineButtonOnListing, 2)) {

				while (areElementsOverlapping(refineButtonOnListing, dropDownIconAndroid)) {
					Thread.sleep(1000);
					scrollDown();

				}
			}
			scrollDownToElement(dropDownIconAndroid);
			click(dropDownIconAndroid, "Click on the dropdown arrow", "SL03");
			int size = dropDownOptionsAndroid.size();
			System.out.println(size);

			for (WebElement e : dropDownOptionsAndroid) {
				for (String s : dropDownList) {
					if (e.getText().contains(s))
						sa.assertTrue(e.getText().contains(s), "Dropdown options does not match");

				}
			}

		}

		// dismiss the dropdown
		waitForSometime(1000);
		driver.navigate().back();

		sa.assertAll();

	}

	public void verifyProfileInfoOnListingPage() {
		SoftAssert sa = new SoftAssert();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			sa.assertTrue(BasePageActions.isDisplayed(tvListingUserName), "Member name is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingAgeHeight), "Member age and height is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingCommunity), "Member comminity is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingLocation), "Member location is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingOnlineStatus), "Member online status is not displayed");

		} else {
			sa.assertTrue(BasePageActions.isDisplayed(driver.findElement(By.id("labelDisplayName_" + profileIndex))),
					"Member name is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(driver.findElement(By.id("labelFirstLeft_" + profileIndex))),
					"Member age and height is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(driver.findElement(By.id("labelFirstRight_" + profileIndex))),
					"Member Profession is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(driver.findElement(By.id("labelSecondLeft_" + profileIndex))),
					"Member comminity is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(driver.findElement(By.id("labelSecondRight_" + profileIndex))),
					"Member location is not displayed");

		}

		sa.assertAll();
	}

	public void verifyProfileShortlisted(String shortlistProfileName) throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		// added new changes for ios
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			Thread.sleep(1000);
			BasePageActions.navigateToSpecifiedMatchesTab(Shortlists, "Navigate to Shortlists tab");
			// newly added to refresh the shortlist tab
			Thread.sleep(1000);
			scrollUp();
			Thread.sleep(1000);
			scrollUp();

			sa.assertEquals(myMatchesHeaderTextAndroid.getText(), "Shortlisted Members",
					"Shortlisted page header text does not match");
			scrollDownToElement(tvListingUserName);
			String after = tvListingUserName.getText();
			System.out.println("Member name after adding to Shortlists: " + after);
			if (after.equalsIgnoreCase(shortlistProfileName)) {
				sa.assertEquals(after, shortlistProfileName, "Member is not added to Shortlists");
			} else {
				System.out.println("Profile not visible , Waiting 90 secs for shortlist tab to update");
				waitForSometime(90000);
				scrollUp();
				scrollUp();
				Thread.sleep(1000);
				scrollUp();
				scrollDownToElement(tvListingUserName);
				after = tvListingUserName.getText();
				System.out.println("Member name after adding to Shortlists: " + after);
				sa.assertEquals(after, shortlistProfileName, "Member is not added to Shortlists");

			}

		} else {// IOS code

			System.out.println("Wait for shortlist tab to update");
			waitForSometime(90000);
			BasePageActions.navigateToSpecifiedMatchesTab(Shortlists, "Navigate to Shortlists tab");
			ClickNoException(btnGotIt, 10, "Click Got it button", "SL01");
			// newly added to refresh the shortlist tab
			Thread.sleep(2000);
			scrollUp();
			Thread.sleep(2000);
			scrollUp();

			sa.assertEquals(myMatchesHeaderTextAndroid.getText(), "Shortlisted Members",
					"Shortlisted page is not displayed");

			// code added to handle iOS profile search
			profileIndex = findProfileInInboxTab(shortlistProfileName);
			String after = driver.findElement(By.id("labelDisplayName_" + profileIndex)).getText();

			System.out.println("Member name after adding to Shortlists: " + after);

			sa.assertEquals(after, shortlistProfileName, "Member is not added to Shortlists");
		}

		sa.assertAll();
	}

	public void verifyProfileRemovedFromShortlist(BottomMenu menu) throws InterruptedException {

		try {
		SoftAssert sa = new SoftAssert();

		// get profile details before removing member from Shortlists
		click(tvListingUserName, "Click on profile name to open profile page", "");
		// Thread.sleep(2000);
		waitForElementToBeDisplayed(UserName, "Wait for Profile name to be visible", "");
		Thread.sleep(1000);
		String before = UserName.getText();
		System.out.println("Member name before removing from Shortlists: " + before);

		// Thread.sleep(2000);
		if (isDisplayedAfterWait(dropdownArrow, 3)) {
			dropdownArrow.click();
			Thread.sleep(1000);
			dd_removeshortlist.click();
			Thread.sleep(1000);
		} else {

			dropDownThreeDots.click();
			Thread.sleep(1000);
			dd_removeshortlist.click();
			Thread.sleep(1000);

		} // changes this dropdown element since ios was added with some other android
			// element of the same type

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			driver.navigate().back();
		} else {
			// back button from profile page to myMatchesTab
			ChatbackButton.click();
		}

		// wait for 90 seconds
		System.out.println("Waiting 90 secs for Shortlists to be updated...");
		Thread.sleep(90000);

		menu.clickOnMatches();
		waitForSometime(2000);
		navigateToSpecifiedMatchesTab(Shortlists, "Navigate to Shortlists tab");
		waitForSometime(2000);
		scrollUp();
		scrollUp();

		// added Listing Name element instead of UserName since ios Element is present
		// for that
		scrollDownToElement(tvListingUserName);

		waitForElementToBeDisplayed(tvListingUserName, "", "");
		String after = BasePageActions.getText(tvListingUserName, "Get member name");
		System.out.println("Member name after removing from Shortlists: " + after);

		sa.assertFalse(before.equalsIgnoreCase(after), "Member not removed from Shortlists");

		sa.assertAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			Thread.sleep(2000);
			driver.navigate().back();

			
		}
	}

	public void verifyTrustBadgesOnProfilePage() {
		SoftAssert sa = new SoftAssert();
		int i = 0;
		boolean flag = true;

		// scroll to profile that has Trust badge displayed
		click(SwipeNext, "Go to next profile", "");

		// If the trustBadgeButtonAndroid webelement is present on profile page
		while (!isDisplayedAfterWait(trustBadgeButtonAndroid, 2)) {
			click(SwipeNext, "Go to next profile", "");
			i++;
			if (i == 2) {
				flag = false;
				break;
			}

		}
		if (flag) {
			click(trustBadgeButtonAndroid, "Click on Trust Badge icon", "SL05");
			// dismiss the popup
			waitForSometime(1000);
			driver.navigate().back();
		}
		// If the trustBadgeButtonAndroid webelement is present on profile page

		if (!flag) {
			i = 0;
			flag = true;
			click(SwipeNext, "Go to next profile", "");

			// If the TrustBadgeIcon webelement is present on profile page
			while (!isDisplayedAfterWait(TrustBadgeIcon, 2)) {
				click(SwipeNext, "Go to next profile", "");
				i++;
				if (i == 2) {
					flag = false;
					break;

				}
			}

			if (flag) {
				click(TrustBadgeIcon, "Click on Trust Badge icon", "SL05");
				waitForSometime(1000);
				driver.navigate().back();
			} else {

				Assert.fail("Trust badge with given id not found");

			}
		}
		// If the TrustBadgeIcon webelement is present on profile page

		sa.assertAll();
	}

	public void verifyTrustBadgesOnProfilePage_backup() {
		SoftAssert sa = new SoftAssert();
		int i = 0;

		if (UserType.contains("premium")) {
			// scroll to profile that has Trust badge displayed
			click(SwipeNext, "Go to next profile", "");

			while (!isDisplayed(trustBadgeButtonAndroid)) {
				click(SwipeNext, "Go to next profile", "");
				i++;
				if (i == 3)
					break;
			}

			click(trustBadgeButtonAndroid, "Click on Trust Badge icon", "SL05");

			// dismiss the popup
			waitForSometime(2000);
			driver.navigate().back();
		} else { // free user UI
			click(SwipeNext, "Go to next profile", "");

			while (!isDisplayed(trustBadgeButtonAndroid)) {
				click(SwipeNext, "Go to next profile", "");
				i++;
				if (i == 3)
					break;
			}

			if (i < 3) {
				click(trustBadgeButtonAndroid, "Click on Trust Badge icon", "SL05");

				waitForSometime(2000);
				driver.navigate().back();
			} else {

				Assert.fail("Trust badge with given id not found");

			}

		}

		sa.assertAll();
	}

	public void verifyTrustBadgesOnProfileListing() {
		SoftAssert sa = new SoftAssert();
		int i = 0;
		boolean flag = true;

		scrollUp();

		// scroll to profile that has Trust badge displayed
		while (!isDisplayed(trustBadgeButtonAndroid)) {
			BasePageActions.scrollDown();
			i++;
			if (i == 2) {
				flag = false;
				break;
			}
		}

		if (flag) {
			sa.assertTrue(trustBadgeButtonAndroid.isEnabled(), "Trust Badge Button not enabled");
			click(trustBadgeButtonAndroid, "Click on Trust Badge icon", "");
			waitForSometime(1000);
			driver.navigate().back();
		}
		// dismiss the popup
		waitForSometime(1000);
		driver.navigate().back();

		if (!flag) {
			flag = true;
			i = 0;
			while (!isDisplayed(TrustBadgeIcon)) {
				BasePageActions.scrollDown();
				i++;
				if (i == 3) {
					flag = false;
					break;

				}

			}

			if (flag) {
				sa.assertTrue(TrustBadgeIcon.isEnabled(), "Trust Badge Button not enabled");
				click(TrustBadgeIcon, "Click on Trust Badge icon", "SL05");
				waitForSometime(1000);
				driver.navigate().back();
			} else {
				Assert.fail("Trust badge with given id not found");
			}

		}
		sa.assertAll();

	}

	public void verifyTrustBadgesOnProfileListing_backup() {
		SoftAssert sa = new SoftAssert();
		int i = 0;

		scrollUp();

		if (UserType.contains("premium")) {
			// scroll to profile that has Trust badge displayed
			while (!isDisplayed(trustBadgeButtonAndroid)) {
				BasePageActions.scrollDown();
				i++;
				if (i == 2)
					break;
			}

			if (i < 3) {
				sa.assertTrue(trustBadgeButtonAndroid.isEnabled(), "Trust Badge Button not enabled");
				click(trustBadgeButtonAndroid, "Click on Trust Badge icon", "");

				waitForSometime(2000);
				driver.navigate().back();
			} else {
				Assert.fail("Trust badge with given id not found");
			}

			// dismiss the popup
			waitForSometime(2000);
			driver.navigate().back();
		} else { // free user UI
			while (!isDisplayed(trustBadgeButtonAndroid)) {
				BasePageActions.scrollDown();
				i++;
				if (i == 3)
					break;
			}

			if (i < 3) {
				sa.assertTrue(trustBadgeButtonAndroid.isEnabled(), "Trust Badge Button not enabled");
				click(trustBadgeButtonAndroid, "Click on Trust Badge icon", "SL05");
				waitForSometime(2000);
				driver.navigate().back();
			} else {
				Assert.fail("Trust badge with given id not found");
			}
		}

		sa.assertAll();
	}

	public void verifyPhotoAlbumOnListingPage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		scrollDown();
		scrollDownToElement(PicCount);
		if (isDisplayedAfterWait(tvPicCount, 2)) {
			sa.assertTrue(isDisplayed(tvPicCount), "Photo count is not displayed");
			String count = BasePageActions.getText(tvPicCount, "Get photo count");
			System.out.println("Photo count is: " + count);
		} else {
			sa.assertTrue(isDisplayed(profilePhotoCountAndroid), "Photo count is not displayed");
			String count = BasePageActions.getText(profilePhotoCountAndroid, "Get photo count");
			System.out.println("Photo count is: " + count);
		}

		sa.assertTrue(isElementDisplayed(PicCount), "Pic Count not displayed");
		click(PicCount, "Click to Open Photo Album", "");

		sendConnectFromPhotoAlbum();

		sa.assertAll();
	}

	public void verifyPhotoAlbumOnProfilePage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (isDisplayedAfterWait(SwipeNext, 2)) {
			click(SwipeNext, "Got to next profile", "");
			click(SwipeNext, "Got to next profile", "");
		}

		while (!isDisplayedAfterWait(PicCount, 2)) {
			click(SwipeNext, "Got to next profile", "");
		}

		if (isDisplayedAfterWait(tvPicCount, 2)) {
			sa.assertTrue(tvPicCount.isDisplayed(), "Photo count is not displayed");
			String count = BasePageActions.getText(tvPicCount, "Get photo count");
			System.out.println("Photo count is: " + count);
		} else {
			sa.assertTrue(profilePhotoCountAndroid.isDisplayed(), "Photo count is not displayed");
			String count = BasePageActions.getText(profilePhotoCountAndroid, "Get photo count");
			System.out.println("Photo count is: " + count);
		}

		// sending connect from profile page
		sa.assertTrue(isElementDisplayed(PicCount), "Pic Count not displayed");
		click(ProfilePageName, "Click to Open Photo Album", "");

		sendConnectFromPhotoAlbum();

		sa.assertAll();
	}

	public void verifyUpgradeBannerForFreeUser() throws InterruptedException {

		Thread.sleep(1000);
		waitForElementToBeDisplayed(BottomSheetText, "wait for View plans pop up to be visible", "");
		sa.assertTrue(BasePageActions.isElementDisplayed(BottomSheetText),
				"Contact him directly,Upgrade Now text is not displayed");
		sa.assertEquals(MaskedNum.getText(), "+91-78********", "Masked Number is improper");
		sa.assertEquals(MaskedEmail.getText(), "*********@gmail.com", "Masked Email is improper");
		sa.assertTrue(BasePageActions.isElementDisplayed(ViewPlansOnBottomSheet),
				"ViewPlans On BottomSheet, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(CloseIcon), "Close Icon On BottomSheet is not displayed");
		click(ViewPlansOnBottomSheet, "Click on view Plans button", "");
		sa.assertAll();
		waitForElementToBeDisplayed(upgradePageHeader, "Wait for payment page to load", "");
		Thread.sleep(1000);
		click(paymentPageBackButton, "Click on back button", "");
	}

	public void verifyUpgradeBannerForFreeUser_iOS() throws InterruptedException {

		Thread.sleep(2000);
		sa.assertTrue(BasePageActions.isElementDisplayed(BottomSheetText),
				"Contact him directly,Upgrade Now text is not displayed");
		Thread.sleep(4000);
		if (isDisplayed(MaskedNum_partOne_iOS_B)) {
			Thread.sleep(2000);
			sa.assertEquals(MaskedNum_partOne_iOS_B.getText().trim(), "+91-78", "Masked Number Part one is Seen");
			sa.assertEquals(MaskedEmail_partTwo_iOS_B.getText().trim(), "@gmail.com", "Masked Email is improper");

		} else {
			Thread.sleep(2000);
			sa.assertEquals(MaskedNum_partOne_iOS.getText().trim(), "+91-78", "Masked Number Part one is Seen");
			sa.assertEquals(MaskedNum_partTwo_iOS.getText().trim(), "********", "Masked Number Part two is Seen");
			sa.assertEquals(MaskedEmail_partOne_iOS.getText().trim(), "**********", "Masked Email is improper");
			sa.assertEquals(MaskedEmail_partTwo_iOS.getText().trim(), "@gmail.com", "Masked Email is improper");
		}

		sa.assertTrue(BasePageActions.isElementDisplayed(ViewPlansOnBottomSheet),
				"ViewPlans On BottomSheet, is not displayed");
		sa.assertTrue(BasePageActions.isElementDisplayed(CloseIcon), "Close Icon On BottomSheet, is not displayed");
		ViewPlansOnBottomSheet.click();
		sa.assertAll();
		Thread.sleep(3000);
		waitForElementToBeDisplayed(upgradePageHeader, "wait for payment page to load", "");

		Thread.sleep(3000);

		btn_BackFromUpgrade.click();
	}

	public void verifyInfoFromProfilePage_Shortlist() {

		SoftAssert sa = new SoftAssert();

		scrollDownToElement(tvListingUserName);
		String before = getText(tvListingUserName, "Get member name");
		System.out.println("Member name before going to Profile page: " + before);
		click(tvListingUserName, "Click on Member name to go to Profile page", "SL11");
		waitForSometime(2000);
		String after = tvListingUserName.getText();
		System.out.println("Member name after going to Profile page: " + after);
		sa.assertEquals(after, before, "Incorrect member Profile displayed");

		sa.assertAll();
	}

	public void verifyBanner_Shortlist() {

		SoftAssert sa = new SoftAssert();

		scrollUp();
		scrollUp();

		// scroll down till Upgrade card is displayed
		scrollDownToElement(cardBannerPersonalized_txtOffer);

		sa.assertTrue(isDisplayed(cardBannerPersonalized_btnViewPlans),
				"View Plans button is not displayed on Upgrade card");
		sa.assertTrue(isDisplayed(cardBannerPersonalized_txtContact),
				"Contact number is not displayed on Upgrade card");
		sa.assertTrue(isDisplayed(cardBannerPersonalized_txtContactTitle),
				"Contact Title is not displayed on Upgrade card");
		sa.assertTrue(isDisplayed(cardBannerPersonalized_txtName), "Member Name is not displayed on Upgrade card");
		sa.assertTrue(isDisplayed(cardBannerPersonalized_imgAvatar), "Member Photo is not displayed on Upgrade card");
		sa.assertTrue(isDisplayed(cardBannerPersonalized_txtHeading), "Heading is not displayed on Upgrade card");

		sa.assertAll();
	}

	public void verifyActionsAfterClickOnChat_Shortlist() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		// get name of the member

		scrollDownToElement(callButtonAndroid);
		click(callButtonAndroid, "Click on 'View Contact' option", "SL09");
		if (BaseTest.UserType.contains("free")) {

			verifyUpgradeBannerForFreeUser();
		} else {
			Thread.sleep(2000);
			if (isDisplayed(callNowButtonPremium))
				sa.assertEquals(callNowButtonPremium.getText(), "Call now",
						"Assert Call Now button on clicking on view contact");
			driver.navigate().back(); // for time being as the profile contact view limit is excedeed
		}

		sa.assertAll();

	}

	public void verifyAfterConnectSent_Shortlist() {

		SoftAssert sa = new SoftAssert();

		// new design
		if (BaseTest.UserType.contains("free")) {
			click(btnListingConnectNow, "Click on 'Connect Now' option", "SL08");
			sa.assertTrue(isDisplayed(btnUpgrade), "'Upgrade' button is not displayed");
			sa.assertTrue(isDisplayed(callButtonAndroid), " Call button is not displayed");
			sa.assertTrue(isDisplayed(shaadiChatButtonAndroid), "Shaadi chat is not displayed");
		} else {

			click(connectNowButtonOnListingPageAndroid, "Click on 'Connect Now' option", "SL08");
			if (isDisplayed(sendMessageButtonAndroid))
				sendMessageButtonAndroid.click();

		}
		sa.assertAll();

	}

	public void verifyCTAOnProfileCard_Shortlist() {

		SoftAssert sa = new SoftAssert();

		if (BaseTest.UserType.contains("free")) {
			// scroll down till Connect Now option is displayed
			while (!isDisplayed(txtLikeThisProfile)) {
				BasePageActions.scrollDown();
			}

			sa.assertTrue(isDisplayed(btnListingConnectNow), "'Connect Now' button is not displayed");
			sa.assertTrue(isDisplayed(imgListingConnectNow), "'Connect Now' button image is not displayed");
			sa.assertTrue(isDisplayed(txtLikeThisProfile), "'Like this profile?' text is not displayed");

		}

		else {
			scrollDownToElement(connectNowButtonOnListingPageAndroid);
			sa.assertTrue(isDisplayed(connectNowButtonOnListingPageAndroid), "'Connect Now' button is not displayed");

			sa.assertTrue(isDisplayed(viewContactButtonOnListingPageAndroid), "'View contact' text is not displayed");

		}
		sa.assertAll();

	}

	public void sendMessageOnConnectPremium() throws InterruptedException {
		if (isDisplayedAfterWait(sendMessageButtonAndroid, 2)) {
			if (isDisplayedAfterWait(sendMessagetextBox, 2)) {
				Thread.sleep(2000);
				if (sendMessagetextBox.getText().isEmpty()) {
					sendMessagetextBox.click();
					sendMessagetextBox.sendKeys("Hello");
					sendMessageButtonAndroid.click();
				} else {
					System.out.println("Message present in Connect text : " + sendMessagetextBox.getText());
					sendMessageButtonAndroid.click();
				}

			}

		}

	}

	public void verifyLandingOnDRPage_DR(BottomMenu menu) throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		menu.clickOnMatches();

		if (BaseTest.UserType.contains("premium")) {

			sa.assertTrue(isElementDisplayed(Dr_Image_free), "Todays Matches page not displayed");

			while (!isDisplayed(btn_connectNow_DR)) {
				Thread.sleep(1000);
				NextArrowBtn.click();

			}
		} else {
			sa.assertTrue(isElementDisplayed(Dr_Image_free), "Todays Matches page not displayed");

			while (!isDisplayed(btn_ConnectNowText)) {
				Thread.sleep(1000);
				NextArrowBtn.click();

			}
			sa.assertEquals(btn_ConnectNowText.getText(), "Connect Now", "Connect Now CTA is not displayed");

		}

		sa.assertAll();

	}

	// name to be changed
	public void verifyCTAAFterConnect_DR() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (BaseTest.UserType.contains("premium")) {
			if (isDisplayed(txtCaption)) {
				AssertEquals(txtCaption, "Message sent. Take the next step",
						"Verify message after Connect Action for premium Member");
				Thread.sleep(1000);
				scrollDownToElement(CallCTA);
				sa.assertTrue(chckElementPresent(CallCTA),
						"Call CTA is not seen after sending connect for premium member");
				sa.assertTrue(chckElementPresent(WhatsappCTA),
						"WhatsApp CTA is not seen after sending connect for premium member");
				sa.assertTrue(chckElementPresent(ShaadiChatCTA),
						"Shaadi Chat CTA is not seen after sending connect for premium member");
				Thread.sleep(1000);

			}
		} else {
			if (isDisplayed(btnUpgrade)) {

				AssertEquals(btnUpgrade, "Upgrade Now",
						"Verify upgrade now button is visible after sending connect for Free user");
				click(btnUpgrade, "Click on upgrade Now button", "DR");
				waitForElementToBeDisplayed(upgradePageHeader, "Wait for payment page 1 to load", "");
				Thread.sleep(1000);
				waitForElementToBeDisplayed(paymentPageBackButton, "Wait for payment page back button", "");
				paymentPageBackButton.click();
				Thread.sleep(1000);
				scrollDownToElement(CallCTA);
				sa.assertTrue(chckElementPresent(CallCTA),
						"Call CTA is not seen after sending connect for free member");
				sa.assertTrue(chckElementPresent(WhatsappCTA),
						"WhatsApp CTA is not seen after sending connect for free member");
				sa.assertTrue(chckElementPresent(ShaadiChatCTA),
						"Shaadi Chat CTA is not seen after sending connect for free member");
				Thread.sleep(1000);
			}
		}

		sa.assertAll();

	}

	// specially made for profile CTA verification
	public void verifyCTAAFterConnect_DR_iOS(boolean scrollFlag) throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (BaseTest.UserType.contains("premium")) {
			if (isDisplayed(txtCaption)) {
				AssertEquals(txtCaption, "Message sent. Take the next step", "Message sent take next step is Seen");
			}
		} else {
			if (isDisplayed(txtCaption)) {

				String result = btnUpgrade.getText().replaceAll("[-+^:,]", "");
				System.out.println(result + " Is The Upgrade Message");
				sa.assertTrue(result.trim().contains("To Contact"), "Assert Upgrade Now text");
				click(btnUpgrade, "click on upgrade Now button", "DR");
				Thread.sleep(2000);
				driver.navigate().back();
			}
		}
		Thread.sleep(1000);

		if (scrollFlag == true) {
			scrollDownToElement(CallCTA_OnProfile);
		}
		Thread.sleep(3000);
		sa.assertTrue(chckElementPresent(CallCTA_OnProfile), "Call CTA is seen");
		sa.assertTrue(chckElementPresent(WhatsappCTA_OnProfile), "WhatsAppCTA is seen");
		// sent test flag condition is added because the Shaadi CTA for premium profile
		// has same id as that of Free profile hence condition based run is required
		if (chckElementPresent(ShaadiChatCTA_OnProfile_premium) == true) {
			sa.assertTrue(chckElementPresent(ShaadiChatCTA_OnProfile_premium), "Shaadi Chat CTA is seen for Premium");

		} else {
			sa.assertTrue(chckElementPresent(ShaadiChatCTA_OnProfile), "Shaadi Chat CTA is seen for Free");

		}

		sa.assertAll();

	}

	public void verifyMatchesCountDecreaseOnSwipe_DR() throws InterruptedException {

		Thread.sleep(2000);
		SoftAssert sa = new SoftAssert();
		Thread.sleep(2000);
		String beforeSwipe = todayMatchesCount_DR.getText();

		beforeSwipe = beforeSwipe.substring(beforeSwipe.indexOf('(') + 1, beforeSwipe.lastIndexOf(')'));
		System.out.println(beforeSwipe);

		swipeLeft();
		Thread.sleep(3000);

		String afterSwipe = todayMatchesCount_DR.getText();

		afterSwipe = afterSwipe.substring(afterSwipe.indexOf('(') + 1, afterSwipe.lastIndexOf(')'));

		System.out.println(afterSwipe);

		sa.assertTrue(Integer.parseInt(beforeSwipe) > Integer.parseInt(afterSwipe),
				"The DR count after swipe is not decreased");
		sa.assertAll();

	}

	public void sendConnectFromAlbum_DR() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		while (!isDisplayed(PicCount)) {
			click(NextArrowBtn, "Go to Next profile", "");

		}

		sa.assertTrue(isElementDisplayed(PicCount), "Pic Count not displayed");
		click(UserName, "Click to Open Photo Album", "");
		click(AlbumConnect, "Send Connect from Photo Album", "");
		sendMessageOnConnectPremium();
		if (BaseTest.UserType.contains("premium")) {
			if (isDisplayedAfterWait(InvitationSent, 3)) {
				sa.assertEquals(InvitationSent.getText(), "Message Sent", "Message Sent text not displayed");
			}
		} else {
			if (isDisplayedAfterWait(InvitationSent, 3)) {
				sa.assertEquals(InvitationSent.getText(), "Invitation Sent", "Invitation Sent text not displayed");
				sa.assertEquals(UpgradeBtn.getText(), "Upgrade Now", "Upgrade Now text not displayed");
				click(UpgradeBtn, "click on upgrade now button", "DR");
				Thread.sleep(2000);
				driver.navigate().back();
			}

		}
		driver.navigate().back();
		sa.assertAll();
	}

	public void sendConnect_DR() throws InterruptedException {

		if (BaseTest.UserType.contains("premium")) {
			click(btn_connectNow_DR, "Click on top Connect Now CTA", "sendTopCTAConnect");
			sendMessageOnConnectPremium();
			waitForElementToBeDisplayed(PrevArrowBtn, "Wait for Prev arrow to be visible", "sendTopCTAConnect");
			click(PrevArrowBtn, "Go to previous Connect sent profile", "sendTopCTAConnect");
		} else {
			click(btn_ConnectNowText, "Click on top Connect Now CTA", "sendTopCTAConnect");

		}

	}

	public void verifyWhatsAppCTA() throws InterruptedException {

		if (UserType.contains("premium")) {

			click(WhatsappCTA, "click on whatsapp button", "");
			// need to add limit exceeded id for Android

			if (isDisplayedAfterWait(tx_LimitExceeded, 3)) {
				btn_Cancel.click();
			}

			else if (isDisplayedAfterWait(whatsAppButton, 2)) {
				sa.assertEquals(whatsAppButton.getText(), "WhatsApp",
						"WhatsApp button not visible after clicking Whatsapp CTA");
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			} else if (isDisplayedAfterWait(ShaadiChatButtonPhoneNumberHidden, 2)) {

				sa.assertEquals(ShaadiChatButtonPhoneNumberHidden.getText(), "Shaadi Chat",
						"Shaadi Chat button not visible after clicking Whatsapp CTA if the Contact no. is not present or Hidden");

				waitForElementToBeDisplayed(CloseIcon, "Wait for close button", "");
				CloseIcon.click();
			} else {

				driver.navigate().back();

			}

		} else {
			click(WhatsappCTA, "click on whatsapp button", "");
			if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
				verifyUpgradeBannerForFreeUser_iOS();
			} else {
				verifyUpgradeBannerForFreeUser();
			}

		}

	}

	public void verifyShaadiChatCTA() throws InterruptedException {
		if (UserType.contains("premium")) {

			click(ShaadiChatCTA, "Click on shaadi chat CTA visible after sending connect", "");

			waitForElementToBeDisplayed(ClickWriteMsg, "Wait for chat window to load", "");
			sa.assertEquals(ClickWriteMsg.getText(), "Type a Message",
					"Chat window did not load after clicking on ShaadiChat CTA");
			click(ChatbackButton, "Click on back button", "");
			boolean isAppRatingVisible = false;
			isAppRatingVisible = isDisplayedAfterWait(AppRatingLayer, 2);
			System.out.println(isAppRatingVisible);
			if (isAppRatingVisible) {
				driver.navigate().back();
			}

			if (isDisplayedAfterWait(ClickWriteMsg, 2)) {

				ChatbackButton.click();
			}

		} else {
			click(ShaadiChatCTA, "click on shaadi chat button", "");
			if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
				verifyUpgradeBannerForFreeUser_iOS();
			} else {
				verifyUpgradeBannerForFreeUser();
			}

		}

	}

	public void verifyCallCTA() throws InterruptedException {

		if (UserType.contains("premium")) {

			click(CallCTA, "click on Call button", "");
			if (isDisplayedAfterWait(tx_LimitExceeded, 3)) {
				btn_Cancel.click();
			}

			else if (isDisplayedAfterWait(callButton, 2)) {
				sa.assertEquals(callButton.getText(), "Call now",
						"Call Now button not visible after clicking on Call CTA");
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			} else if (isDisplayedAfterWait(ShaadiChatButtonPhoneNumberHidden, 2)) {
				sa.assertEquals(ShaadiChatButtonPhoneNumberHidden.getText(), "Shaadi Chat",
						"Shaadi chat button not visible after clicking on Call CTA in case the phone no. is hidden");
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			} else {
				driver.navigate().back();
			}

		}

		else {
			// check Call CTA
			click(CallCTA, "click on Call button", "");
			if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
				verifyUpgradeBannerForFreeUser_iOS();
			} else {
				verifyUpgradeBannerForFreeUser();
			}
		}

	}

	public void verifyShaadiChatWhatsappCTA() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		// check whatsapp CTA
		if (UserType.contains("premium")) {
			click(WhatsappCTA, "click on whatsapp button", "");
			if (isDisplayed(whatsAppButton)) {
				sa.assertEquals(whatsAppButton.getText(), "WhatsApp");
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			} else {
				if (isDisplayed(ShaadiChatButtonPhoneNumberHidden)) {
					sa.assertEquals(ShaadiChatButtonPhoneNumberHidden.getText(), "Shaadi Chat");

				}
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			}

			// check Call CTA
			click(CallCTA, "click on Call button", "");
			if (isDisplayed(callButton)) {
				sa.assertEquals(callButton.getText(), "Call now");
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			} else {
				if (isDisplayed(ShaadiChatButtonPhoneNumberHidden)) {
					sa.assertEquals(ShaadiChatButtonPhoneNumberHidden.getText(), "Shaadi Chat");

				}
				waitForElementToBeDisplayed(CloseIcon, "wait for close button", "");
				CloseIcon.click();
			}

			// check ShaadichatCTA
			click(ShaadiChatCTA, "click on shaadi chat button", "");
			if (isDisplayed(ClickWriteMsg)) {
				sa.assertEquals(ClickWriteMsg.getText(), "Type a Message");
				driver.navigate().back();
			} else {
				driver.navigate().back();

			}
		}

		else {

			click(WhatsappCTA, "click on whatsapp button", "");
			verifyUpgradeBannerForFreeUser();

			// check Call CTA
			click(CallCTA, "click on Call button", "");
			verifyUpgradeBannerForFreeUser();

			// check ShaadichatCTA
			click(ShaadiChatCTA, "click on shaadi chat button", "");
			verifyUpgradeBannerForFreeUser();

		}

	}

	public void navigateAndVerifyMyMatchesTab(BottomMenu menu) throws InterruptedException {

		String[] array = { "Matching most of your Preferences Edit", "Matching your Preferences Edit" };

		menu.clickOnMatches();
		BasePageActions.navigateToSpecifiedMatchesTab(myMatchesTab, "Navigate to More Matches tab");
		waitForSometime(1000);
		waitForElementToBeDisplayed(myMatchesHeaderTextAndroid, "Wait for My Matches page to load", "");

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			AssertEquals(matchingPreferences, "Matching your Preferences", "");

		} else {
			String arraytext = myMatchesHeaderTextAndroid.getText();
			System.out.println(arraytext);
			if (arraytext.equals(array[0])) {
				AssertEquals(myMatchesHeaderTextAndroid, array[0], "Assert title text on My matches tab");
			} else {
				AssertEquals(myMatchesHeaderTextAndroid, array[1], "Assert title text on My matches tab");
			}
		}
	}

	public void navigateAndVerifyNewMatchesTab(BottomMenu menu) throws InterruptedException {

		menu.clickOnMatches();
		navigateToMatchesTab(todayMatchesTabAndroid);
		Thread.sleep(1000);
		BasePageActions.navigateToSpecifiedMatchesTab(newTab, "Navigate to New Matches tab");
		// waitForSometime(2000);
		waitForElementToBeDisplayed(myMatchesHeaderTextAndroid, "Wait for New Matches page to load", "");
		Thread.sleep(1000);
		String arraytext = myMatchesHeaderTextAndroid.getText();
		System.out.println(arraytext);
		AssertEquals(myMatchesHeaderTextAndroid, "Members who joined recently", "Verify New Matches tab title text");

	}

	public void navigateAndVerifyNearMeTab(BottomMenu menu) throws InterruptedException {

		menu.clickOnMatches();
		BasePageActions.navigateToSpecifiedMatchesTab(NearMeTab, "Navigate to New Matches tab");
		// waitForSometime(2000);
		waitForElementToBeDisplayed(nearMeHeaderAndroid, "Wait for Near Me page to load", "");
		Thread.sleep(1000);
		String arraytext = nearMeHeaderAndroid.getText();
		System.out.println(arraytext);
		AssertEquals(nearMeHeaderAndroid, "Members around your city", "Verify Near me tab header text");

	}

	public void verifyrefinebuttonCommon() {
		waitForElementToBeDisplayed(myMatchesRefineButtonAndroid, "", "");
		Assert.assertTrue(myMatchesRefineButtonAndroid.isDisplayed(), "Verifying if the refine button is displayed");
		AssertEquals(myMatchesRefineButtonAndroid, "REFINE", "");

	}

	public void verifyRefineButtonOnMatchesTab() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
			verifyrefinebuttonCommon();

		} else {
			verifyrefinebuttonCommon();
			click(myMatchesRefineButtonAndroid, "Click on Refine Button", "");
			waitForSometime(1000);
			waitForElementToBeDisplayed(getMoreMatchesButtonAndroid, "Wait for Refine button to be visible", "");
			String getMoreMatchesFlag = getMoreMatchesButtonAndroid.getText();
			System.out.println(getMoreMatchesFlag);
			if (getMoreMatchesFlag.equalsIgnoreCase("OFF")) {
				click(getMoreMatchesButtonAndroid, "Click on get more matches button", "");
				waitForElementToBeDisplayed(toggleButtonAndroid, "", "");
				click(toggleButtonAndroid, "Click on toggle button", "");
				waitForElementToBeDisplayed(backButton, "", "");
				click(backButton, "Click on back button", "");

				Thread.sleep(1000);
				driver.navigate().back();

			} else {
				click(getMoreMatchesButtonAndroid, "Click on get more matches button", "");
				waitForElementToBeDisplayed(toggleButtonAndroid, "", "");
				click(toggleButtonAndroid, "Click on toggle button", "");
				waitForElementToBeDisplayed(toggleButtonAndroid, "", "");
				click(toggleButtonAndroid, "Click on toggle button", "");
				waitForElementToBeDisplayed(backButton, "", "");
				click(backButton, "Click on back button", "");

				Thread.sleep(1000);
				driver.navigate().back();
			}
		}

	}

	public void verifyRefineButtonOnNewMatchesTab() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		waitForElementToBeDisplayed(myMatchesRefineButtonAndroid, "Wait for Refine button to be visible", "");
		sa.assertTrue(myMatchesRefineButtonAndroid.isDisplayed(), "Refine button is Not displayed");
		sa.assertEquals(myMatchesRefineButtonAndroid.getText(), "REFINE", "REFINE text does not match");

		click(myMatchesRefineButtonAndroid, "Click on Refine Button", "");
		waitForElementToBeDisplayed(tvTitle_RV, "wait for page to load", "");
		sa.assertEquals(tvTitle_RV.getText(), "Refine", "Header text on Refine search page doesnot match");
		sa.assertEquals(RefineSearchButton.getText(), "Refine Search",
				"Refine button text on Refine search page does not match");
		Thread.sleep(1000);
		driver.navigate().back();
		sa.assertAll();

	}

	public void verifyMyMatchescarousal() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (isDisplayed(premiumCarousal)) {
			sa.assertTrue(plusSign.isDisplayed());
			scrollDownToElement(connectCarousal);
			String nameCarousal = carousalName.getText();
			click(connectCarousal, "Click connect on carousal", "case ID");
			sendMessageOnConnectPremium();

			// Thread.sleep(3000);
			sa.assertTrue(connectCarousal.getText().contains("Write Message")
					|| connectCarousal.getText().contains("Shaadi Chat")
					|| connectCarousal.getText().contains("View Contact"));

			carousalName.click();
			waitForElementToBeDisplayed(UserName, "Wait for profile page to load", "MyMatches Test");
			sa.assertEquals(UserName.getText().split(" ")[0], nameCarousal.split(" ")[0],
					"Profile name on My matches carousal and profile page does not match");
			verifyCTAAFterConnect_DR();
			Thread.sleep(1000);
			driver.navigate().back();

		}
		sa.assertAll();
	}

	public void verifyProfileFromProfilePageConnectNow() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		if (UserType.contains("premium")) { // Block for premium User
			scrollDownToElement(connectNowButtonOnListingPageAndroid);
			Thread.sleep(1000);
			click(UserName, "open profile page", "");
			waitForElementToBeDisplayed(connectNowButtonOnListingPageAndroid,
					"wait for Connect Now Button to be visible on profile page", "");
			// Thread.sleep(2000);
			sa.assertTrue(connectNowButtonOnListingPageAndroid.isEnabled(),
					"Connect Now button is not enabled on profile page");
			click(connectNowButtonOnListingPageAndroid, "click connect now", "tc");
			sendMessageOnConnectPremium();
			Thread.sleep(3000); // wait for automatic profile swipe
			click(SwipePrev, "swipe to previous profile", "tc");

			if (isDisplayedAfterWait(txtCaption, 6))// CTA visible after Connect Now action
			{
				verifyCTAAFterConnect_DR();
				verifyShaadiChatCTA();
				verifyWhatsAppCTA();
				verifyCallCTA();
			} else if (isDisplayedAfterWait(connectRejectedText1, 3)) // Not Matching Preference
			{
				sa.assertTrue(chckElementPresent(ExclamationAfterConnect), "Exclamation not present");
				sa.assertTrue(chckElementPresent(connectRejectedText1), "Rejected text1 not present");
				sa.assertTrue(chckElementPresent(connectRejectedText2), "Rejected text2 not present");
				sa.assertTrue(chckElementPresent(connectRejectedToolTip), "Rejected tooltip not present");

			} else {
				// driver.navigate().back();
			}

		} else { // Block for Free user
			Thread.sleep(1000);
			scrollDownToElement(AlbumConnect);
			Thread.sleep(1000);
			click(UserName, "open profile page", "");

			waitForElementToBeDisplayed(btn_ConnectNowText, "wait for page to load", "");
			while (!isDisplayedAfterWait(btn_ConnectNowText, 3)) {
				click(SwipeNext, "swipe to next profile", "tc");

			}
			AssertEquals(btn_ConnectNowText, "Connect Now", "");
			click(btn_ConnectNowText, "click connect now", "tc");

			if (isDisplayedAfterWait(btnUpgrade, 6)) {

				verifyCTAAFterConnect_DR();
				verifyShaadiChatCTA();
				verifyWhatsAppCTA();
				verifyCallCTA();
			} else {
				waitForElementToBeDisplayed(connectRejectedText1, "wait for rejection message", "");
				sa.assertTrue(chckElementPresent(ExclamationAfterConnect), "Exclamation not present");
				sa.assertTrue(chckElementPresent(connectRejectedText1), "Rejected text1 not present");
				sa.assertTrue(chckElementPresent(connectRejectedText2), "Rejected text2 not present");
				sa.assertTrue(chckElementPresent(connectRejectedToolTip), "Rejected tooltip not present");
			}

		}

		sa.assertAll();
	}

	public void verifyProfileFromProfilePageViewContact() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		if (UserType.contains("premium")) {
			click(SwipeNext, "Go to next profile", "");
			waitForElementToBeDisplayed(viewContactButtonOnListingPageAndroid,
					"wait for view contact button to be visible", "");
			sa.assertTrue(viewContactButtonOnListingPageAndroid.isEnabled(),
					"View Contact Button not enabled on profile page");
			viewContactButtonOnListingPageAndroid.click();
			if (isDisplayedAfterWait(connectSentText, 10)) {
				sa.assertEquals(connectSentText.getText(), "Connect Request Sent",
						"Connect request not sent  along with view contact");
				Thread.sleep(2000);
				click(CloseIcon, "close view contact pop up", "");
				Thread.sleep(3000); // wait for automatic profile swipe
				click(SwipePrev, "Go to previous profile", "");

				if (isDisplayedAfterWait(txtCaption, 6))// If CTA displayed after view contact action
				{
					verifyCTAAFterConnect_DR();
					verifyShaadiChatCTA();
					verifyWhatsAppCTA();
					verifyCallCTA();
				} else if (isDisplayedAfterWait(connectRejectedText1, 4)) // Not matching preferences
				{
					waitForElementToBeDisplayed(connectRejectedText1, "wait for rejection message", "");
					sa.assertTrue(chckElementPresent(ExclamationAfterConnect), "Exclamation not present");
					sa.assertTrue(chckElementPresent(connectRejectedText1), "Rejected text1 not present");
					sa.assertTrue(chckElementPresent(connectRejectedText2), "Rejected text2 not present");
					sa.assertTrue(chckElementPresent(connectRejectedToolTip), "Rejected tooltip not present");

				}
			} else if (isDisplayedAfterWait(txt_contactNotViewed, 3)) { // Contact Hidden
				Thread.sleep(2000);
				click(CloseIcon, "close view contact pop up", "");
			}

			else { // view contact limit exceeded
				waitForElementToBeDisplayed(OKblock,
						"wait for Okay button to be visible as user has exceeded the view contact limit", "");
				OKblock.click();
			}

		}

		sa.assertAll();

		Thread.sleep(2000);

	}

	public void verifyProfileFromListingPageViewContact() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		if (UserType.contains("premium")) {
			scrollDownToElement(viewContactButtonOnListingPageAndroid);
			Thread.sleep(1000);
			sa.assertTrue(viewContactButtonOnListingPageAndroid.isEnabled(),
					"View Contact Button is not enabled on Listing Page");
			viewContactButtonOnListingPageAndroid.click();
			if (isDisplayedAfterWait(connectSentText, 10)) {
				sa.assertEquals(connectSentText.getText(), "Connect Request Sent",
						"Connect request not sent along with view contact");
				click(CloseIcon, "close view contact pop up", "");

				if (isDisplayedAfterWait(txtCaption, 10)) // Executed when CTA are displayed on view Contact Action
				{
					verifyCTAAFterConnect_DR();
					verifyShaadiChatCTA();
					verifyWhatsAppCTA();
					verifyCallCTA();
				} else if (isDisplayedAfterWait(filtered_out_Txt, 2)) // Filtered out profile
				{

					sa.assertEquals(filtered_out_Txt.getText(), "You are filtered out",
							"Filtered Out text not visible");
					sa.assertEquals(connectNow.getText(), "Cancel Interest", "Cancel Interest text not visible");
				} else if (isDisplayedAfterWait(connectRejectedText1, 3)) // Not matching preferences
				{
					waitForElementToBeDisplayed(connectRejectedText1, "wait for rejection message", "");
					sa.assertTrue(chckElementPresent(ExclamationAfterConnect), "Exclamation not present");
					sa.assertTrue(chckElementPresent(connectRejectedText1), "Rejected text1 not present");
					sa.assertTrue(chckElementPresent(connectRejectedText2), "Rejected text2 not present");
					sa.assertTrue(chckElementPresent(connectRejectedToolTip), "Rejected tooltip not present");

				}
			} else if (isDisplayedAfterWait(txt_contactNotViewed, 3)) // If Contact Hidden
			{
				Thread.sleep(2000);
				click(CloseIcon, "close view contact pop up", "");
			} else // View Contact limit exceeded
			{
				waitForElementToBeDisplayed(OKblock,
						"wait for Okay button to be visible as user has exceeded the view contact limit", "");
				OKblock.click();
			}

		}

		sa.assertAll();

		Thread.sleep(2000);

	}

	public void verifyProfileFromListingPageConnectNow() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		if (UserType.contains("premium")) {
			scrollDown();
			scrollDownToElement(connectNowButtonOnListingPageAndroid);
			Thread.sleep(1000);
			sa.assertTrue(connectNowButtonOnListingPageAndroid.isEnabled(),
					"Connect Now button is not enabled on Listing page");
			click(connectNowButtonOnListingPageAndroid, "click on connect now", "");
			sendMessageOnConnectPremium();
			if (isDisplayedAfterWait(txtCaption, 7)) {
				verifyCTAAFterConnect_DR();
				verifyShaadiChatCTA();
				verifyWhatsAppCTA();
				verifyCallCTA();
			} else if (isDisplayedAfterWait(filtered_out_Txt, 4)) {
				sa.assertEquals(filtered_out_Txt.getText(), "You are filtered out", "Filtered Out text not visible");
				sa.assertEquals(connectNow.getText(), "Cancel Interest", "Cancel Interest text not visible");
			} else if (isDisplayedAfterWait(connectRejectedText1, 3)) {
				waitForElementToBeDisplayed(connectRejectedText1, "wait for rejection message", "");
				sa.assertTrue(chckElementPresent(ExclamationAfterConnect), "Exclamation not present");
				sa.assertTrue(chckElementPresent(connectRejectedText1), "Rejected text1 not present");
				sa.assertTrue(chckElementPresent(connectRejectedText2), "Rejected text2 not present");
				sa.assertTrue(chckElementPresent(connectRejectedToolTip), "Rejected tooltip not present");

			}
		}
		// free user case
		else {
			scrollDown();
			scrollDownToElement(AlbumConnect);
			Thread.sleep(1000);
			sa.assertTrue(BasePageActions.isDisplayed(tvListingUserName), "Member name is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingAgeHeight), "Member age and height is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingCommunity), "Member comminity is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingLocation), "Member location is not displayed");
			sa.assertTrue(BasePageActions.isDisplayed(tvListingOnlineStatus), "Member online status is not displayed");

			sa.assertTrue(AlbumConnect.isEnabled(), "Connect Now button is not enabled on Listing page");
			click(AlbumConnect, "Click on top Connect Now CTA", "sendTopCTAConnect");
			Thread.sleep(1000);

			if (isDisplayedAfterWait(goPremiumUprgadeButton, 3)) {
				click(goPremiumUprgadeButton, "Click on Upgrade Now banner", "");
				waitForElementToBeDisplayed(upgradePageHeader, "wait for payment page to load", "");
				Thread.sleep(2000);
				waitForElementToBeDisplayed(paymentPageBackButton, "wait for back button", "");
				paymentPageBackButton.click();
			}

			if (!isDisplayedAfterWait(btnUpgrade, 5)) {
				driver.navigate().back();
			}

			if (isDisplayedAfterWait(btnUpgrade, 10)) {
				verifyCTAAFterConnect_DR();
				verifyShaadiChatCTA();
				verifyWhatsAppCTA();
				verifyCallCTA();
			} else {
				waitForElementToBeDisplayed(connectRejectedText1, "wait for rejection message", "");
				sa.assertTrue(chckElementPresent(ExclamationAfterConnect), "Exclamation not present");
				sa.assertTrue(chckElementPresent(connectRejectedText1), "Rejected text1 not present");
				sa.assertTrue(chckElementPresent(connectRejectedText2), "Rejected text2 not present");
				sa.assertTrue(chckElementPresent(connectRejectedToolTip), "Rejected tooltip not present");

			}

		}

		sa.assertAll();

		Thread.sleep(2000);

	}

	public void verifyBannerOnListingpage() throws InterruptedException {

		if (UserType.contains("free")) {
			SoftAssert sa = new SoftAssert();
			scrollDownToElement(cardBannerPersonalized_btnViewPlans);

			click(cardBannerPersonalized_btnViewPlans, "click on view plans button on upgrade banner", "");
			waitForElementToBeDisplayed(upgradePageHeader, "wait for payment page to load", "");
			driver.navigate().back();

			sa.assertAll();
		}

	}

	public void verifyRecentlyViewedSections(WebElement element, String sectionName, String titleText, SoftAssert sa)
			throws InterruptedException {

		int seeallcount = 0;
		Thread.sleep(2000);
		scrollDownToElement_recentlyviewed(element);
		waitForElementToBeDisplayed(tvTitle_RV, "wait for Recently viewed tab to load", "");
		String titleText1 = tvTitle_RV.getText();
		int count = Integer.parseInt(titleText1.replaceAll("[^0-9]", ""));
		System.out.println(count);
		sa.assertTrue(titleText1.contains(titleText), "Title text for the section does not match -" + sectionName);
		sa.assertTrue(count > 1);
		@SuppressWarnings("unchecked")
		List<WebElement> seeall = driver.findElements(By.id("com.shaadi.android:id/btn_see_all"));
		if (seeall.size() > 1) {
			seeallcount = 1;
		}
		Thread.sleep(2000);
		scrollDownToElement(seeall.get(seeallcount));
		Thread.sleep(1000);
		seeall.get(seeallcount).click();
		waitForElementToBeDisplayed(subTitleText, "wait for profile Page to load", "");
		sa.assertEquals(subTitleText.getText(), sectionName, sectionName + " text not visible on profile page");
		Thread.sleep(1000);

	}

	public void verifyRecentlyViewedSections_iOS(WebElement element, String sectionName, String titleText,
			SoftAssert sa, WebElement seeAlliOS, WebElement subTitleText, WebElement titleHeader)
			throws InterruptedException {

		Thread.sleep(2000);
		scrollDownToElement_recentlyviewed(element);
		waitForElementToBeDisplayed(titleHeader, "wait for Recently viewed tab to load", "");
		String titleText1 = titleHeader.getText();
		int count_OnCarousal = Integer.parseInt(titleText1.replaceAll("[^0-9]", ""));

		System.out.println(count_OnCarousal);
		sa.assertTrue(titleText1.contains(titleText), "Title expected for the Section");

		Thread.sleep(2000);
		scrollDownToElement(seeAlliOS);
		Thread.sleep(1000);
		seeAlliOS.click();

		Thread.sleep(3000);

		WebElement navBarElement = driver.findElement(By.className("XCUIElementTypeNavigationBar"));
		String titleText2 = navBarElement.getAttribute("name");

		int listingCount = Integer.parseInt(titleText2.replaceAll("[^0-9]", ""));
		sa.assertEquals(count_OnCarousal, listingCount, "Count on Carousel is Equal to Count on Lisitng Page");
		// Replaced subTitleText with parameterised WebElement as iOS has different id
		// for this
		waitForElementToBeDisplayed(subTitleText, "wait for profile Page to load", "");
		sa.assertEquals(subTitleText.getText(), sectionName, sectionName + " text not visible on profile page");
		Thread.sleep(1000);

	}

	public void sendConnectToIgnoredMember(SoftAssert sa) throws InterruptedException {

		// added this because the index for free and premium userNames starts from 1 and
		// 0 respectively in iOS
		if (chckElementPresent(UserName_OnListing)) {
			Thread.sleep(2000);
			scrollDownToElement(UserName_OnListing);
			Thread.sleep(1000);
			UserName_OnListing.click();

		} else {
			Thread.sleep(2000);
			scrollDownToElement(UserName_OnListing_FreeUser);
			Thread.sleep(1000);
			UserName_OnListing_FreeUser.click();
		}

		if (UserType.contains("premium")) {

			Thread.sleep(3000);
			while (!chckElementPresent(btnConnectNowProfile_Premium)) {
				Thread.sleep(2000);
				click(SwipeNext, "", "");
			}

			Thread.sleep(2000);

			sa.assertEquals(IgnoredMemPremium.getText(), "Ignored Member",
					"Ignored member text present on profile card");

			sa.assertTrue(chckElementPresent(btnConnectNowProfile_Premium), "Connect Button is Seen for Premium User");

			btnConnectNowProfile_Premium.click();

			sendMessageOnConnectPremium();

		} else {

			while (!chckElementPresent(btnConnectNowProfile)) {
				click(SwipeNext, "", "");
			}

			Thread.sleep(2000);

			sa.assertTrue(IgnoredMemText.getText().replaceAll("[\n]", "").contains("You Ignored"),
					"Ignored member text present on profile card for Free User");

			sa.assertTrue(isDisplayed(btnConnectNowProfile), "Connect Button is Seen for Free User");

			btnConnectNowProfile.click();
		}

		if (UserType.contains("premium")) {

			click(SwipePrev, "", "");
		}

		if (isDisplayedAfterWait(txtCaption, 3)) {

			if (RunEnvironment.equalsIgnoreCase("iosLocal")) {
				verifyCTAAFterConnect_DR_iOS(false);
			} else {
				verifyCTAAFterConnect_DR();
			}

		}

		if (RunEnvironment.equalsIgnoreCase("iOSlocal")) {
			waitForElementToBeDisplayed(btn_back_recentlyViewed, "", "");
			btn_back_recentlyViewed.click();
			Thread.sleep(2000);
		} else {
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(3000);
		}

		waitForElementToBeDisplayed(btn_back_recentlyViewed, "", "");
		btn_back_recentlyViewed.click();
		Thread.sleep(2000);

	}

	public void unblockmember(SoftAssert sa) throws InterruptedException {

//		// added this because the index for free and premium userNames starts from 1 and
//		// 0 respectively in iOS
		if (chckElementPresent(UserName_OnListing)) {
			Thread.sleep(2000);
			scrollDownToElement(UserName_OnListing);
			Thread.sleep(1000);
			UserName_OnListing.click();

		} else {
			Thread.sleep(2000);
			scrollDownToElement(UserName_OnListing_FreeUser);
			Thread.sleep(1000);
			UserName_OnListing_FreeUser.click();
		}
		Thread.sleep(3000);
		/*
		 * while (!chckElementPresent(btn_unblock)) { Thread.sleep(2000);
		 * click(SwipeNext, "", ""); }
		 */

		if (isDisplayedAfterWait(BlockedMemberTxt, 4)) {
			sa.assertEquals(BlockedMemberTxt.getText(), "Blocked Member",
					"Blocked member text present on profile card");
			sa.assertTrue(isDisplayed(btn_unblock));
		} else if (isDisplayedAfterWait(blockedText_new, 4)) {
			sa.assertEquals(blockedText_new.getText(), "You blocked this Profile",
					"Blocked member text present on profile card");

		}

		boolean flag = false;
		boolean breakflag = false;
		int i = 0;
		while (!flag) {
			if (!chckElementPresent(btn_unblock)) {
				i++;
				click(SwipeNext, "", "");

				if (i == 2) {
					breakflag = true;
					break;
				}

			} else {
				btn_unblock.click();
			}
			Thread.sleep(2000);
			if (chckElementPresent(BlockPopupTxt)) {
				sa.assertEquals(BlockPopupTxt.getText(), "Member can be unblocked only after 48 hours.");
				sa.assertEquals(OopsTxt.getText(), "Oops!");
				btn_OK.click();
				Thread.sleep(2000);
				i++;
				if (i == 4) {
					breakflag = true;
					break;
				}
				click(SwipeNext, "", "");
				flag = false;

			} else {
				flag = true;
			}
		}

		if (breakflag) {
			if (UserType.contains("premium")) {
				Thread.sleep(2000);
				SwipeNext.click();
				Thread.sleep(2000);
				SwipePrev.click();
				Thread.sleep(1000);
				sa.assertTrue(chckElementPresent(connectNowButtonOnListingPageAndroid),
						"Connect Now Button is seen for Premium User");
			} else {
				Thread.sleep(2000);
				SwipeNext.click();
				Thread.sleep(2000);
				SwipePrev.click();
				Thread.sleep(2000);
				sa.assertTrue(chckElementPresent(btnConnectNowProfile), "Connect Now Button is seen for Free User");
			}
		}

	}

	public String verifyRecentVisitorssection(SoftAssert sa) {

		String text = BasePageActions.getText(RecentVisitors, "Get element text");
		sa.assertTrue(text.contains("Recent Visitors"), "Recent Visitors section not displayed");
		String recentVisitorsCount = text.replaceAll("[^0-9]", "");
		System.out.println(recentVisitorsCount);

		return recentVisitorsCount;
	}

	public String verifyMembersYouMayLikesection(SoftAssert sa) {

		BasePageActions.scrollDownToElement(MembersYouMayLike);
		String text = BasePageActions.getText(MembersYouMayLike, "Get element text");
		sa.assertTrue(text.contains("Members you may like"), "Members you may like section not displayed");
		String membersYouMayLikeCount = text.replaceAll("[^0-9]", "");
		System.out.println(membersYouMayLikeCount);

		return membersYouMayLikeCount;
	}

	public String verifyMembersLookingforMesection(SoftAssert sa) {

		BasePageActions.scrollDownToElement(MemberslookingforMe);
		String text = BasePageActions.getText(MemberslookingforMe, "Get element text");
		sa.assertTrue(text.contains("Members looking for me"), "Members looking for me section not displayed");
		String membersLookingforMeCount = text.replaceAll("[^0-9]", "");
		System.out.println(membersLookingforMeCount);

		return membersLookingforMeCount;
	}

	public void verifyRecentVisitorsSections() {

		SoftAssert sa = new SoftAssert();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			// verify sub-title
			waitForElementToBeDisplayed(SectionSubTitle.get(0), "", "");
			String subTitle = SectionSubTitle.get(0).getText();
			sa.assertEquals(subTitle, "Members who visited your Profile",
					"Recent Visitors sub-title text doesn't match");

			// Verify Profile image, name, details and Connect now
			sa.assertTrue(lblName.get(0).isDisplayed(), "Name not displayed");
			sa.assertTrue(lblDetails1.get(0).isDisplayed(), "1st line details not displayed");
			sa.assertTrue(lblDetails2.get(0).isDisplayed(), "2nd line details not displayed");
			sa.assertTrue(lblDetails3.get(0).isDisplayed(), "3rd line details not displayed");
			sa.assertTrue(llConnect.get(0).isDisplayed(), "Connect Now button not displayed");
		}

		else {
			// verify sub-title
			sa.assertTrue(BasePageActions.enabled(RecentVisitorSubsection, "Verify Recent Visitors sub-title", "MMA02"),
					"Recent Visitors sub-title is not displayed");

			// Verify Profile image, name, details and Connect now
			sa.assertTrue(StaticText.get(1).isEnabled(), "Name not displayed");
			sa.assertTrue(StaticText.get(2).isEnabled(), "1st line details not displayed");
			sa.assertTrue(StaticText.get(3).isEnabled(), "2nd line details not displayed");
			sa.assertTrue(StaticText.get(4).isEnabled(), "3rd line details not displayed");
			sa.assertEquals(ConnectNow.size(), 9, "Connect Now button not displayed");
		}
		sa.assertAll();

	}

	public void verifyUserNavigationToProfilePageRecentlyViewed() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			// Get details of profile on More matches landing page
			HashMap<String, String> hm1 = new HashMap<String, String>();
			waitForElementToBeDisplayed(lblName.get(0), "Wait for profile on more matches page to load", "");
			String name = lblName.get(0).getText();
			System.out.println("First page: " + name);
			hm1.put("name", name.split(" ")[0]);
			String allDetails = lblDetails1.get(0).getText().concat(lblDetails2.get(0).getText())
					.concat(lblDetails3.get(0).getText());
			hm1.put("details", allDetails.replaceAll("[,\\s+]", ""));

			// navigate to profile page of recent visitor
			lblName.get(0).click();
			waitForElementToBeDisplayed(ProfilePage, "Wait for Profile page to load",
					"navigateToProfilePageOfRecentVisitor");

			// Verify details on Profile page
			HashMap<String, String> hm2 = new HashMap<String, String>();
			Thread.sleep(2000);
			name = ProfilePageName.getText();
			System.out.println("Profile page: " + name);
			hm2.put("name", name.split(" ")[0]);
			allDetails = ProfilePageHeight.getText().concat(ProfilePageCommunity.getText())
					.concat(ProfilePageLocation.getText());
			hm2.put("details", allDetails.replaceAll("[,\\s+]", ""));
			sa.assertTrue(hm1.equals(hm2), "Name and details don't match on Profile Page");
		} else {
			// Get details of profile on More matches landing page
			String nameBefore = StaticText.get(1).getText();
			System.out.println("First page: " + nameBefore);

			// navigate to profile page of recent visitor
			Point p = StaticText.get(1).getLocation();
			Dimension d = StaticText.get(1).getSize();
			BasePageActions.clickOnPoint((p.x + d.width / 2), (p.y - d.height));

			String nameAfter = StaticText1.get(0).getText();
			sa.assertEquals(nameAfter, nameBefore, "Name and details don't match on Profile Page");
		}
		sa.assertAll();

	}

	public void initiateChatFromProfilePage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		// waitForSometime(3000);
		click(OnlineStatus, "Click on Online Status button", "");
		// OnlineStatus.click();
		// waitForSometime(2000);
		waitForElementToBeDisplayed(ClickWriteMsg, "Wait for chat window to open", "");
		sa.assertTrue(isDisplayed(ClickWriteMsg),
				"Chat screen not displayed after clicking on the Online Icon on profile page");

		if (isDisplayed(ChatbackButton)) {
			ChatbackButton.click();
		}

		boolean isAppRatingVisible = false;
		isAppRatingVisible = isDisplayed(AppRatingLayer);
		System.out.println(isAppRatingVisible);
		if (isAppRatingVisible) {
			Thread.sleep(1000);
			driver.navigate().back();

		}
		Thread.sleep(1000);
		// changed from button online to UserName
		if (!isDisplayedAfterWait(UserName, 3)) {
			System.out.println("Online Button not seen hence clicking once more");
			ChatbackButton.click();
		}

		sa.assertAll();

	}

	public void viewConversationStarterFromProfilePage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		int count = 0;
		while (!BasePageActions.isDisplayedAfterWait(ConversationStarter, 3)) {
			// Thread.sleep(2000);
			// SwipeNext.click();
			click(SwipeNext, "Click on next swipe button", "");
			count++;
			if (count == 3) {
				System.out.println("No Profile found with conversation starter");
				break;
			}
		}
		// Thread.sleep(2000);
		// ConversationStarter.click();
		click(ConversationStarter, "Click on conversation Starter", "");
		sa.assertTrue(BasePageActions.isDisplayed(ConversationStarterTitle),
				"Conversation starter screen not displayed");
		ConversationStarterTitle.getLocation();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			driver.navigate().back();
		} else {

			WebElement getHunkyDory = driver.findElement(By.className("XCUIElementTypeImage"));
			tapByCoordinate(getHunkyDory.getLocation().x, getHunkyDory.getLocation().y - 40);

		}

		sa.assertAll();

	}

	public void verifySwipeOnProfilePage() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		String name1, name2;
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			waitForElementToBeDisplayed(ProfilePageName, "Wait for Profile to be visible", "");
			name1 = ProfilePageName.getText();
			Thread.sleep(1000);
			BasePageActions.swipeLeft();
			name2 = ProfilePageName.getText();
		} else {
			name1 = BasePageActions.getText(StaticText.get(2), "Get Member name");
			BasePageActions.click(ProfilePageNext, "Click on Next button", "verifySwipeOnProfilePage_RecentVisitor");
			name2 = BasePageActions.getText(StaticText.get(2), "Get Member name");
		}

		sa.assertFalse(name1.contentEquals(name2), "Swipe not performed on Profile page");
		System.out.println("name1: " + name1 + "\n" + "name2: " + name2);

		// verify prev and next buttons
		sa.assertTrue(BasePageActions.isDisplayed(ProfilePagePrev), "Previous button is not displayed");
		sa.assertTrue(BasePageActions.isDisplayed(ProfilePageNext), "Next button is not displayed");

		// navigate back to More Matches
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			Thread.sleep(1000);
			driver.navigate().back();
		} else {
			BasePageActions.click(ProfilePageBack, "Click Back", "verifySwipeOnProfilePage_RecentVisitor");
		}

		sa.assertAll();
	}

	public void verifySwipeOnRecentlyViewedSections(WebElement element) throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		String name1 = null, name2 = null;
		BasePageActions.waitForElementToBeDisplayed(element, "Wait till RecentVisitorsSection is displayed",
				"swipeRecentVisitorsSection");

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {

			name1 = lblName.get(lblName.size() - 1).getText();

			System.out.println("Before scroll name: " + name1);
			Thread.sleep(2000);
			BasePageActions.scrollFromOneElementToAnother(lblName.get(lblName.size() - 1),
					lblName.get(lblName.size() - 2));
			name2 = lblName.get(lblName.size() - 1).getText();

			System.out.println("After scroll name: " + name2);
			sa.assertFalse(name1.equalsIgnoreCase(name2), "Swipe not successful on Recently viewed section");
		} else {
			Point p = StaticText.get(1).getLocation();
			System.out.println("First profile location:" + p.getX() + p.getY());
			Dimension d = driver.manage().window().getSize();
			BasePageActions.scrollFromOnePointToAnother(d.getWidth() * 0.85, p.getY(), d.getWidth() * 0.15, p.getY());
			Point p1 = StaticText.get(1).getLocation();
			System.out.println("First profile location after swipe:" + p1.getX() + p1.getY());
			sa.assertNotSame(p1.getX(), p.getX(), "Swipe not successful");
		}

		sa.assertAll();

	}

	public void verifyRecentlyViewedSectionsCount(String sectionCount) {

		SoftAssert sa = new SoftAssert();
		int seeallcount = 0;

		List<WebElement> seeall = driver.findElements(By.id("com.shaadi.android:id/btn_see_all"));
		if (seeall.size() > 1) {
			seeallcount = 1;
		}
		BasePageActions.click(seeall.get(seeallcount), "Click on See All", "verifyRecentVisitorsCount");

		String text = BasePageActions.getText(RecentVisitorsListCount, "Get element text");
		System.out.println("RecentVisitorsListCount: " + text);
		String count = text.replaceAll("[^0-9]", "");
		System.out.println("Count on listing  " + count);
		if (Integer.parseInt(sectionCount) == 999) {
			sa.assertTrue(Integer.parseInt(count) > Integer.parseInt(sectionCount), "Count on page doesn't match");
		} else {
			sa.assertEquals(count, sectionCount, "Count on Recent Visitors page doesn't match");
		}
		sa.assertAll();

	}

	public void verifyNavigationToProfilePageFromMatchesListing() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			Thread.sleep(2000);
			scrollDownToElement(ProfilePageName);
			waitForElementToBeDisplayed(ProfilePageName, "Wait for profile to be visible", "");
			String nameonlisting = ProfilePageName.getText().split(" ")[0];

			System.out.println("Profile name on Matches Listing " + nameonlisting);

			click(ProfilePageName, "Wait for profile page to load", "");
			waitForElementToBeDisplayed(ProfilePage, "wait for Profile page to load", "");
			scrollDownToElement(ProfilePageName);
			waitForElementToBeDisplayed(ProfilePageName, "", "");
			String nameonProfilePage = ProfilePageName.getText().split(" ")[0];

			System.out.println("Profile name on Matches Profile page " + nameonProfilePage);
			sa.assertTrue(nameonlisting.equalsIgnoreCase(nameonProfilePage), "Name don't match on Profile Page");
			// navigate back to Recent Visitors list
			Thread.sleep(1500);
			driver.navigate().back();
		} else {
			String nameBefore = BasePageActions.getText(StaticText.get(1), "Get Member name"); // get first
																								// member name
																								// on Recent
																								// Visitors
																								// listing
			BasePageActions.click(StaticText.get(1), "Click on first member",
					"navigateToProfilePageFromRecentVisitorsList");
			String nameAfter = BasePageActions.getText(ProfilePageName, "Get Member name"); // get member name
																							// on Profile page
			sa.assertEquals(nameAfter, nameBefore, "Name and details don't match on Profile Page");
			// navigate back to Recent Visitors list
			BasePageActions.click(ProfilePageBack1, "Click on Back button to land on more matches page", "");
		}

		sa.assertAll();

	}

	public void verifyNavigationToProfilePageFromListing() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			Thread.sleep(2000);
			scrollDownToElement(ProfilePageName);
			Thread.sleep(2000);
			String nameonlisting = ProfilePageName.getText().split(" ")[0];

			System.out.println("Profile name on Matches Listing " + nameonlisting);

			ProfilePageName.click();

			Thread.sleep(2000);
			waitForElementToBeDisplayed(ProfilePage, "wait for Profile page to load", "");

			scrollDownToElement(ProfilePageName);
			waitForElementToBeDisplayed(ProfilePageName, "", "");
			String nameonProfilePage = ProfilePageName.getText().split(" ")[0];

			System.out.println("Profile name on Matches Profile page " + nameonProfilePage);

			sa.assertTrue(nameonlisting.equalsIgnoreCase(nameonProfilePage), "Name don't match on Profile Page");
			// navigate back to Recent Visitors list
			Thread.sleep(3000);
			driver.navigate().back();
		} else {
			String nameBefore = BasePageActions.getText(StaticText.get(1), "Get Member name"); // get first
																								// member name
																								// on Recent
																								// Visitors
																								// listing
			BasePageActions.click(StaticText.get(1), "Click on first member",
					"navigateToProfilePageFromRecentVisitorsList");
			String nameAfter = BasePageActions.getText(ProfilePageName, "Get Member name"); // get member name
																							// on Profile page
			sa.assertEquals(nameAfter, nameBefore, "Name and details don't match on Profile Page");
			// navigate back to Recent Visitors list
			BasePageActions.click(ProfilePageBack1, "Click on Back button to land on more matches page", "");
		}

		// navigate back to More Matches
		Thread.sleep(2000);
		// driver.navigate().back();
		backButton.click();

		sa.assertAll();

	}

	public void verifyMembersYouMayLikeSectionDetails() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		BasePageActions.scrollDownToElement(RecentVisitors);

		// scroll to members you may like
		Thread.sleep(2000);
		BasePageActions.scrollFromOneElementToAnother(SectionTitle.get(1), SectionTitle.get(0));

		// verify sub-title
		waitForElementToBeDisplayed(SectionSubTitle.get(0), "wait for members you may like section to load",
				"More matches");
		String subTitle = BasePageActions.getText(SectionSubTitle.get(0), "Get sub-title text");
		sa.assertEquals(subTitle, "Other profiles you might like", "Members you may like sub-title text doesn't match");
		sa.assertTrue(lblName.get(0).isDisplayed(), "Name not displayed");
		sa.assertTrue(lblDetails1.get(0).isDisplayed(), "1st line details not displayed");
		sa.assertTrue(lblDetails2.get(0).isDisplayed(), "2nd line details not displayed");
		sa.assertTrue(lblDetails3.get(0).isDisplayed(), "3rd line details not displayed");
		sa.assertTrue(llConnect.get(0).isDisplayed(), "Connect Now button not displayed");
		sa.assertAll();

	}

	public void verifyMembersLookingForMeSection() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		Thread.sleep(2000);
		scrollDown();
		scrollDown();

		// verify sub-title
		waitForElementToBeDisplayed(SectionSubTitle.get(0), "", "");
		String subTitle = BasePageActions.getText(SectionSubTitle.get(0), "Get sub-title text");
		sa.assertEquals(subTitle, "Members looking for matches like you",
				"Members looking for me sub-title text doesn't match");
		sa.assertTrue(lblName.get(lblName.size() - 1).isDisplayed(), "Name not displayed");
		sa.assertTrue(lblDetails1.get(lblDetails1.size() - 1).isDisplayed(), "1st line details not displayed");
		sa.assertTrue(lblDetails2.get(lblDetails2.size() - 1).isDisplayed(), "2nd line details not displayed");
		sa.assertTrue(lblDetails3.get(lblDetails3.size() - 1).isDisplayed(), "3rd line details not displayed");
		sa.assertTrue(llConnect.get(llConnect.size() - 1).isDisplayed(), "Connect Now button not displayed");
		sa.assertAll();
	}

	public String sendConnectFromListing(String usrType, WebElement userName) throws InterruptedException

	{
		String userNameToConnect;

		if (SendConectFromListingTest.scrollFlag == true) {
			SendConectFromListingTest.btm_obj.MatchesTab.click();
		}

		if (chckElementPresent(txt_FirstNameInList_premium) == true) {
			scrollDownToElement(txt_FirstNameInList_premium);
		}

		else {
			scrollDownToElement(txt_SecondNameInList_premium);
		}
		if (usrType.equalsIgnoreCase("Free")) {
			scrollDownToElement(userName);
			Thread.sleep(2000);
			userNameToConnect = userName.getText();
			Thread.sleep(1000);
			scrollDownToElement(btn_ConnectNow_Free);
			btn_ConnectNow_Free.click();
		} else {

			// added because the username is visible and scroll is not performed
			Thread.sleep(2000);
			userNameToConnect = userName.getText();
			scrollDownToElement(btn_ConnectNow_Premium);
			btn_ConnectNow_Premium.click();
			sendMessageOnConnectPremium();
		}

		return userNameToConnect;

	}

	public void checkifConnectSend(String userName) throws InterruptedException {

		inb_page.inbox.click();
		boolean profileFound;

		Thread.sleep(2000);

		if (isDisplayed(inb_page.CloseStackicon)) {
			Thread.sleep(6000);
			inb_page.CloseStackicon.click();
		}

		Thread.sleep(2000);

		inb_page.btnSentItemsTab.click();

		Thread.sleep(3000);
		// Compulsory scroll added to check if profile is load after page refresh
		// this scroll will also help us navigate back up to first profile
		scrollUp();

		if (RunEnvironment.equals("iOSLocal")) {

			Thread.sleep(5000);

			@SuppressWarnings("unchecked")
			List<WebElement> profileName = driver
					.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']"));

			if (profileName.size() > 0) {

				System.out.println("Number of profile found " + profileName.size());

				profileFound = true;
			}

			else {

				System.out.println("\nEnetring 90 seconds wait since profile is not found\n");

				Thread.sleep(90000);

				scrollUp();

				Thread.sleep(5000);
				;
				if (driver.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']"))
						.size() > 0) {

					System.out.println("Number of profile found after 90 seconds wait " + driver
							.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']")).size());

					profileFound = true;
				}

				else {
					profileFound = checkAcceptDelete(userName);
				}

			}

			System.out.println("\nProfile Found is " + profileFound + "\n");

			Assert.assertTrue(profileFound, "Profile was seen in Send TAB");

		} else {
			// Added because off banner visibility
			scrollDownToElement(inb_page.profileNameOnSentItemsListing);

		}
	}

	public boolean checkAcceptDelete(String userName) throws InterruptedException {

		boolean profileFound = false;

		inb_page.btnAcceptedTab.click();

		Thread.sleep(3000);

		if (driver.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']")).size() > 0) {

			System.out.println("Number of profile found in Accepted Tab "
					+ driver.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']")).size());

			profileFound = true;
		}

		else {

			inb_page.btnSentItemsTab.click();

			inb_page.btnDeletedTab.click();

			Thread.sleep(3000);

			if (driver.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']")).size() > 0) {

				System.out.println("Number of profile found in Deleted Tab " + driver
						.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']")).size());

				profileFound = true;
			}

		}

		// TODO: handle exception

		return profileFound;
	}

	public void sendConnectFromPhotoAlbum() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (isDisplayedAfterWait(AlbumConnect, 5)) {
			click(AlbumConnect, "Send Connect from Photo Album", "MT14");
			sendMessageOnConnectPremium();

			if (BaseTest.UserType.contains("premium")) {
				if (isDisplayedAfterWait(InvitationSent, 3)) {
					if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
						sa.assertTrue(InvitationSent.getText().equalsIgnoreCase("Message Sent")
								|| InvitationSent.getText().equalsIgnoreCase("You are filtered out"));

					} else {
						sa.assertTrue(InvitationSent.getText().equalsIgnoreCase("Invitation Sent")
								|| InvitationSent.getText().equalsIgnoreCase("You are filtered out")
								|| InvitationSent.getText().equalsIgnoreCase("Message Sent"));

					}

				}
			} else {
				if (isDisplayedAfterWait(InvitationSent, 3)) {
					sa.assertEquals(InvitationSent.getText(), "Invitation Sent", "Invitation Sent text not displayed");
					sa.assertEquals(UpgradeBtn.getText(), "Upgrade Now", "Upgrade Now text not displayed");
					click(UpgradeBtn, "click on upgrade now button", "DR");
					Thread.sleep(2000);
					driver.navigate().back();
				}

			}
		}
		Thread.sleep(1000);

		driver.navigate().back();
		sa.assertAll();

	}

	public void reportUserFromProfilePage(WebElement dropdownButton) throws InterruptedException {

		scrollUpToElement(SwipeNext);
		SoftAssert sa = new SoftAssert();
		Thread.sleep(1000);
		click(SwipeNext, "Click on next profile button on profile page", "");
		Thread.sleep(500);
		click(dropdownButton, "Click on dropdown button", "");

		waitForElementToBeClickable(ReportProfile, "Wait for report profile option to be clickable", "");
		ReportProfile.click();
		sa.assertTrue(isDisplayed(reasonForReporting),
				"Report profile page not visible after clicking Report Profile from profile page dropdown");
		sa.assertTrue(FakeMisleadingProfileInformation.isDisplayed(),
				"Fake/Misleading Profile Information - option not visible on Report Profile Page");
		sa.assertTrue(MultipleProfile.isDisplayed(), "Multiple Profile - option not visible on Report Profile Page");
		sa.assertTrue(Phonenumberisincorrect.isDisplayed(),
				"Phonenumber is incorrect - option not visible on Report Profile Page");
		sa.assertTrue(Photosarefakeorobscene.isDisplayed(),
				"Photos are fake or obscene - option not visible on Report Profile Page");
		sa.assertTrue(HassentabusiveEmailsChats.isDisplayed(),
				"Has sent Abusive Emails/Chats - option not visible on Report Profile Page");
		sa.assertTrue(Isalreadymarriedengaged.isDisplayed(),
				"Is already married/engaged - option not visible on Report Profile Page");
		sa.assertTrue(Askingformoneyscammer.isDisplayed(),
				"Asking for money scammer - option not visible on Report Profile Page");
		sa.assertTrue(Othermisusereasons.isDisplayed(),
				"Other misuse reasons - option not visible on Report Profile Page");
		sa.assertTrue(reportUserRadioButton.isDisplayed(), "Radio Button present on Report Profile page");
		click(ChatbackButton, "click on back button", "'");
		sa.assertAll();

	}

}