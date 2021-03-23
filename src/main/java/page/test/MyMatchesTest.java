package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class MyMatchesTest extends BasePageActions {

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
	public void verifyRefineButton() throws InterruptedException {

		matchespage.verifyRefineButtonOnMatchesTab();

	}

	@Test(priority = 2, description = "Verify Matches carousal on my matches tab")
	public void verifyMatchesCarousal() throws InterruptedException {

		matchespage.verifyMyMatchescarousal();
	}

	@Test(priority = 3, description = "Verify 'Mobile number Verified' text is shown when user clicks on Trust Badge icon")
	public void verifyTrustbadgesOnProfile() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfileListing();
	}

	@Test(priority = 4, description = "Verify photo album On profile Listing page")
	public void verifyPhotoAlbumOnProfileCard() throws InterruptedException {

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

	@Test(priority = 8, description = "Verify user can navigate to profile page from Matches listing")
	public void navigateToProfilePageFromMatchesListing() throws InterruptedException {

		matchespage.verifyNavigationToProfilePageFromListing();

	}

}
