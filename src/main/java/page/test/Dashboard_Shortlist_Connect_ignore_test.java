package page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class Dashboard_Shortlist_Connect_ignore_test extends BasePageActions {

	public static BottomMenu menu;
	public static MyShaadiPage shaadipage;
	public static MatchesPage matchespage;
	public static InboxPage inboxpage;
	SoftAssert softAssertion = new SoftAssert();
	public static String ignoredProfile = "";
	public static String shortlistedProfile = "";
	public static String[] connectSentSplit;
	SoftAssert sa = new SoftAssert();

	public static String connectSendPorfileName, shortListedProfileName;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
		matchespage = new MatchesPage();
		inboxpage = new InboxPage();
	}

	@Test(priority = 0, description = "Navigate to MyShaadi page")
	public void navigateToMyShaadiPage() throws InterruptedException {

		menu.clickMyShaadiTab();
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verfiy successful landing on Myshaadi page");

	}

	@Test(priority = 1, description = "scroll down to premium matches section and click on see all")
	public void scrollDownAndClickOnPremiummatches() throws InterruptedException {
		shaadipage.scrolltillpremiummatches();
	}

	@Test(priority = 2, description = "Go to profile page and click On Don't Show Again to ignore member" , enabled = false)
	public void openprofilepageAndIgnoreMember() throws InterruptedException {

		scrollDownToElement(shaadipage.profileName);
		waitForElementToBeDisplayed(shaadipage.profileName, "", "");
		click(shaadipage.profileName, "open profile page", "");
		Thread.sleep(2000);

		if (RunEnvironment.equals("iOSLocal")) {

			boolean isIgnoreSeen = matchespage.verifyIgnoreOptionIOS();

			Assert.assertFalse(isIgnoreSeen, "Ignore Option should not be visible on iOS");

		} else {

			ignoredProfile = matchespage.ignoreUserFromProfilePage(matchespage.dropdownArrow);

		}

	}

	@Test(priority = 3, description = "Add member to shorlist by click on Add to Shorlist from dropdown")
	public void addMemberToShortlist() throws InterruptedException {
		scrollDownToElement(shaadipage.profileName);
		waitForElementToBeDisplayed(shaadipage.profileName, "", "");
		click(shaadipage.profileName, "open profile page", "");
		Thread.sleep(1000);
		if (RunEnvironment.equals("iOSLocal")) {
			// Go back to Myshaadi dashboard
			shortlistedProfile = matchespage.selectDropdown(matchespage.dropDownThreeDots,
					matchespage.dd_shortlistProfile, "shortlist", sa);

			while (chckElementPresent(matchespage.btn_backArrow)) {
				matchespage.btn_backArrow.click();
				driver.navigate().back();
			}
		} else {

			if (isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

				shortlistedProfile = matchespage.shortlistUserFromProfilePage(matchespage.dropdownArrow);
			} else {
				shortlistedProfile = matchespage.shortlistUserFromProfilePage(matchespage.dropDownThreeDots);

			}
			waitForSometime(2000);
			driver.navigate().back();
			waitForSometime(2000);
			driver.navigate().back();

		}

		sa.assertAll();

	}

	@Test(priority = 4, description = "Click on connect now button to send connect")
	public void sendConnectToProfile() throws InterruptedException {

		matchespage.sendConnectToProfile();

	}

	@Test(priority = 5, description = "verify Connect sent in Inbox sent tab")
	public void verifyConnectSent() throws Exception {

		menu.ClickInbox();

		if (chckElementPresent(menu.CloseStackicon)) {
			menu.CloseStackicon.click();
		}
		hortizonalSwipe();
		inboxpage.clickOnSentItems();
		scrollUp();
		matchespage.verifyConnectSentToProfile();

	}

	@Test(priority = 6, description = "verify member is shortlisted from matches shortlist tab ")
	public void verifyShorlistedMember() throws Exception {

		matchespage.verifyShortlistedMember(menu, shortlistedProfile);

	}

	@Test(priority = 7, description = "verify member is Ignored from matches Recebtly Viewed tab " , enabled = false)
	public void verifyIgnoredMember() throws Exception {
		if (BaseTest.UserType.contains("premium")) {

			matchespage.verifyIgnoreMember(ignoredProfile);
		}
	}
}
