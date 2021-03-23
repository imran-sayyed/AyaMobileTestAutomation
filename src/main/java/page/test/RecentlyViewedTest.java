package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class RecentlyViewedTest extends BasePageActions {

	BottomMenu menu;
	MatchesPage matchespage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		matchespage = new MatchesPage();
	}

	@Test(priority = 0, description = "Navigate to Recently viewed tab")
	public void navigateToRecentlyViewedTab() throws InterruptedException {

		menu.clickOnMatches();
		BasePageActions.navigateToSpecifiedMatchesTab(matchespage.recentlyViewedTab, "Navigate to Recently Viewed tab");
	}

	@Test(priority = 1, description = "Verify Recently viewed Members section on Recently viewed tab")
	public void verifyRecentlyViewedMembersSection() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equals("androidLocal")) {
			matchespage.verifyRecentlyViewedSections(matchespage.profilesYouRecentlyViewed,
					"Profiles you recently Viewed", "Recently Viewed Members", sa);
		} else {
			matchespage.verifyRecentlyViewedSections_iOS(matchespage.profilesYouRecentlyViewed,
					"Profiles you recently Viewed", "Recently Viewed Members", sa,
					matchespage.btn_SeeAll_recently_viewed, matchespage.subTitleText, matchespage.tvTitle_RV);
		}

		// added this because the index for free and premium usernames startes from 1
		// and 0 respectively in iOS
		if (isDisplayed(matchespage.UserName_OnListing)) {
			scrollDownToElement(matchespage.UserName_OnListing);
		} else {
			scrollDownToElement(matchespage.UserName_OnListing_FreeUser);
		}

		Thread.sleep(2000);
		waitForElementToBeDisplayed(matchespage.btn_back_recentlyViewed, "Wait for back button for recently viewed section", "");
		matchespage.btn_back_recentlyViewed.click();
		Thread.sleep(2000);
		sa.assertAll();

	}

	@Test(priority = 2, description = "Verify Ignored Members section on Recently viewed tab" , enabled = false)
	public void verifyIgnoredMembersSection() throws InterruptedException {

		SoftAssert verifyIgnoredMember = new SoftAssert();

		if (RunEnvironment.equals("androidLocal")) {
			matchespage.verifyRecentlyViewedSections(matchespage.profilesYouIgnored, "Profiles you Ignored",
					"Ignored Members", verifyIgnoredMember);
		} else {
			matchespage.verifyRecentlyViewedSections_iOS(matchespage.profilesYouIgnored, "Profiles you Ignored",
					"Ignored Members", verifyIgnoredMember, matchespage.btn_SeeAll_Ignored, matchespage.subTitleText_1,
					matchespage.tvTitle_Ignored);
		}

		matchespage.sendConnectToIgnoredMember(verifyIgnoredMember);

		verifyIgnoredMember.assertAll();

	}

	@Test(priority = 3, description = "Verify Blocked Members section on Recently viewed tab")
	public void verifyBlockedMembersSection() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equals("androidLocal")) {
			matchespage.verifyRecentlyViewedSections(matchespage.blockedText_miniProfile, "Profiles you Blocked",
					"Blocked Members", sa);
		} else {
			matchespage.verifyRecentlyViewedSections_iOS(matchespage.blockedText_miniProfile, "Profiles you Blocked",
					"Blocked Members", sa, matchespage.btn_SeeAll_blockedMember_RV, matchespage.subTitleText_2,
					matchespage.tvTitle_Blocked);

		}

		matchespage.unblockmember(sa);

		sa.assertAll();

	}

}
