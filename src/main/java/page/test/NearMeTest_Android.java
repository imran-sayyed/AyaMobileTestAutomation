package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;

public class NearMeTest_Android extends BasePageActions{

	MatchesPage matchespage;
	InboxPage inboxpage;
	BottomMenu menu;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		inboxpage = new InboxPage();
		matchespage = new MatchesPage();
		menu = new BottomMenu();

	}
	
	@Test(priority = 0, description = "Navigate to Near me tab")
	public void navigateToNearMeTab() throws InterruptedException {

		matchespage.navigateAndVerifyNearMeTab(menu);

	}
	
	@Test(priority = 1, description = "Verify refine button on Near me tab")
	public void verifyRefineButton() throws InterruptedException {

		matchespage.verifyRefineButtonOnNewMatchesTab();

	}
	
	@Test(priority = 2, description = "Verify 'Mobile number Verified' text is shown when user clicks on Trust Badge icon")
	public void verifyTrustbadgesOnProfile() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfileListing();
	}

	@Test(priority = 3, description = "Verify the count of the uploaded photos")
	public void verifyPhotoCountOnProfileCard() throws InterruptedException {

		matchespage.verifyPhotoAlbumOnListingPage();
	}
	
	@Test(priority = 4, description = "Verify banner after third profile on listing page")
	public void verifyBannerOnListingPage() throws InterruptedException {

		matchespage.verifyBannerOnListingpage();
	}
	
	
	@Test(priority = 5, description = "Verify dropdown options on Near me listing")
	public void verifyDropdownOptionsOnNearmeListing() throws InterruptedException {

		matchespage.verifyDropDownOptions();

	}
	


	@Test(priority = 6, description = "Verify connect now on profile on Near me listing tab")
	public void verifyProfileFromNearMeTabListing_connect() throws InterruptedException {

		matchespage.verifyProfileFromListingPageConnectNow();

	}
	
	@Test(priority = 7, description = "Verify view contact on profile on Near me listing tab")
	public void verifyProfileFromNearMeTabListing_viewContact() throws InterruptedException {

		matchespage.verifyProfileFromListingPageViewContact();

	}

	@Test(priority = 8, description = "Verify connect now on profile on from profile page")
	public void verifyProfileFromProfilePage_connect() throws InterruptedException {

		matchespage.verifyProfileFromProfilePageConnectNow();
	}
	
	@Test(priority = 9, description = "Verify view contact on profile on from profile page")
	public void verifyProfileFromProfilePage_viewContact() throws InterruptedException {

		matchespage.verifyProfileFromProfilePageViewContact();
	}
	
	
	@Test(priority = 10, description = "Verify Trust badge from profile page")
	public void verifyTrustBadgesOnProfilePage() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfilePage();

	}
	
	@Test(priority = 11, description = "Verify photo count from profile page")
	public void verifyPhotoCountOnProfilePage() throws InterruptedException {

		matchespage.verifyPhotoAlbumOnProfilePage();

	}

	@Test(priority = 12, description = "Verify Shortlist profile from profile page")
	public void verifyShortlistFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.shortlistUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.shortlistUserFromProfilePage(matchespage.dropDownThreeDots);

		}
	}

	@Test(priority = 13, description = "Verify Block profile from profile page")
	public void verifyBlockFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.blockUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.blockUserFromProfilePage(matchespage.dropDownThreeDots);

		}
	}
	
	@Test(priority = 14, description = "report a user from  profile page dropdowm")
	public void verifyReportProfileOnDropDown() throws InterruptedException {


		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.reportUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.reportUserFromProfilePage(matchespage.dropDownThreeDots);

		}
		
	}

	@Test(priority = 15, description = "Verify Ignore profile from profile page" , enabled = false)
	public void verifyIgnoreFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {
			matchespage.ignoreUserFromProfilePage(matchespage.dropdownArrow);
		}
	}

	
	
	
	
}
