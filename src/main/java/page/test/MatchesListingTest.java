package page.test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class MatchesListingTest extends BasePageActions {

	BottomMenu menu;
	MyShaadiPage shaadipage;
	MatchesPage matchespage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		matchespage = new MatchesPage();
	}

	@Test(priority = 0, description = "Navigate to My Matches tab")
	public void navigateToMyMatchesTab() throws InterruptedException {

		matchespage.navigateAndVerifyMyMatchesTab(menu);

	}

	@Test(priority = 1, description = "Verify refine button on my matches tab")
	public void verifyRefineButtonOnMyMathcesTab() throws InterruptedException {

		matchespage.verifyRefineButtonOnMatchesTab();

	}

	@Test(priority = 2, description = "Verify Matches carousal on my matches tab")
	public void verifyMyMatchesCarousal() throws InterruptedException {

		matchespage.verifyMyMatchescarousal();
	}

	@Test(priority = 3, description = "Verify 'Mobile number Verified' text is shown when user clicks on Trust Badge icon")
	public void verifyTrustbadgesOnProfileOnMyMatchesTab() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfileListing();
	}

	@Test(priority = 4, description = "Verify photo album On profile My Matches Listing page")
	public void verifyPhotoAlbumOnProfileCardOnMyMatchesTab() throws InterruptedException {

		matchespage.verifyPhotoAlbumOnListingPage();
	}

	@Test(priority = 5, description = "Verify dropdown options on My matches listing")
	public void verifyDropdownOptionsOnMymatchesListing() throws InterruptedException {

		matchespage.verifyDropDownOptions();

	}

	@Test(priority = 6, description = "Verify connect now on profile on my matches listing tab")
	public void verifyProfileFromMyMatchesTabListing_connect() throws InterruptedException {

		matchespage.verifyProfileFromListingPageConnectNow();

	}

	@Test(priority = 7, description = "Verify view contact on profile on my matches listing tab")
	public void verifyProfileFromMyMatchesTabListing_viewContact() throws InterruptedException {

		matchespage.verifyProfileFromListingPageViewContact();

	}

	@Test(priority = 8, description = "Verify user can navigate to profile page from My Matches listing")
	public void navigateToProfilePageFromMyMatchesListing() throws InterruptedException {

		matchespage.verifyNavigationToProfilePageFromMatchesListing();

	}

	@Test(priority = 9, description = "Navigate to Near me tab")
	public void navigateToNearMeTab() throws InterruptedException {

		matchespage.navigateAndVerifyNearMeTab(menu);

	}

	@Test(priority = 10, description = "Verify refine button on Near me tab")
	public void verifyRefineButtonOnNearMeTab() throws InterruptedException {

		matchespage.verifyRefineButtonOnNewMatchesTab();

	}

	@Test(priority = 11, description = "Verify 'Mobile number Verified' text is shown when user clicks on Trust Badge icon")
	public void verifyTrustbadgesOnProfileOnNearMeTab() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfileListing();
	}

	@Test(priority = 12, description = "Verify the count of the uploaded photos")
	public void verifyPhotoCountOnProfileCardNearMeListing() throws InterruptedException {

		matchespage.verifyPhotoAlbumOnListingPage();
	}

	@Test(priority = 13, description = "Verify banner after third profile on listing page")
	public void verifyBannerOnListingPageNearMeListing() throws InterruptedException {

		matchespage.verifyBannerOnListingpage();
	}

	@Test(priority = 14, description = "Verify dropdown options on Near me listing")
	public void verifyDropdownOptionsOnNearmeListing() throws InterruptedException {

		matchespage.verifyDropDownOptions();

	}

	@Test(priority = 15, description = "Verify connect now on profile on Near me listing tab")
	public void verifyProfileFromNearMeTabListing_connect() throws InterruptedException {

		matchespage.verifyProfileFromListingPageConnectNow();

	}

	@Test(priority = 16, description = "Verify view contact on profile on Near me listing tab")
	public void verifyProfileFromNearMeTabListing_viewContact() throws InterruptedException {

		matchespage.verifyProfileFromListingPageViewContact();

	}

	@Test(priority = 17, description = "Verify user can navigate to profile page from Near Me Matches listing")
	public void navigateToProfilePageFromNearMeMatchesListing() throws InterruptedException {

		matchespage.verifyNavigationToProfilePageFromMatchesListing();

	}

	@Test(priority = 18, description = "Navigate to New Matches tab")
	public void navigateToNewMatchesTab() throws InterruptedException {

		matchespage.navigateAndVerifyNewMatchesTab(menu);

	}

	@Test(priority = 19, description = "Verify refine button on New matches tab")
	public void verifyRefineButton() throws InterruptedException {

		matchespage.verifyRefineButtonOnNewMatchesTab();

	}

	@Test(priority = 20, description = "Verify 'Mobile number Verified' text is shown when user clicks on Trust Badge icon")
	public void verifyTrustbadgesOnProfile() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfileListing();
	}

	@Test(priority = 21, description = "Verify the count of the uploaded photos")
	public void verifyPhotoCountOnProfileCard() throws InterruptedException {

		matchespage.verifyPhotoAlbumOnListingPage();
	}

	@Test(priority = 22, description = "Verify banner after third profile on listing page")
	public void verifyBannerOnListingPage() throws InterruptedException {

		matchespage.verifyBannerOnListingpage();
	}

	@Test(priority = 23, description = "Verify dropdown options on New matches listing")
	public void verifyDropdownOptionsOnNewmatchesListing() throws InterruptedException {

		matchespage.verifyDropDownOptions();

	}

	@Test(priority = 24, description = "Verify connect now on profile on New matches listing tab")
	public void verifyProfileFromNewMatchesTabListing_connect() throws InterruptedException {

		matchespage.verifyProfileFromListingPageConnectNow();

	}

	@Test(priority = 25, description = "Verify view contact on profile on New matches listing tab")
	public void verifyProfileFromNewMatchesTabListing_viewContact() throws InterruptedException {

		matchespage.verifyProfileFromListingPageViewContact();

	}

	@Test(priority = 26, description = "Verify user can navigate to profile page from New Matches listing")
	public void navigateToProfilePageFromNewMatchesListing() throws InterruptedException {

		matchespage.verifyNavigationToProfilePageFromMatchesListing();

	}

}
