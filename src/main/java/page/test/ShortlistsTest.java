package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class ShortlistsTest extends BasePageActions {

	MatchesPage matches;
	BottomMenu menu;
	public String shortlistProfileName = "";

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		matches = new MatchesPage();
		menu = new BottomMenu();
	}

	@Test(priority = 0, description = "Verify user is able to navigate to My matches tab and add a profile to shortlist")
	public void navigateToMyMatchesAndShortlistProfile() throws InterruptedException {

		menu.clickOnMatches();
		BasePageActions.navigateToSpecifiedMatchesTab(matches.myMatchesTab, "Navigate to Shortlist tab");
		scrollDownToElement(matches.tvListingUserName);
		//Thread.sleep(2000);
		click(matches.tvListingUserName, "Click on profile to go to profile page", "");
		//Thread.sleep(2000);
		if (isDisplayedAfterWait(matches.dropdownArrow, 3)) {

			shortlistProfileName = matches.shortlistUserFromProfilePage(matches.dropdownArrow);
		} else {
			shortlistProfileName = matches.shortlistUserFromProfilePage(matches.dropDownThreeDots);

		}
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			Thread.sleep(1000);
			driver.navigate().back();
		} else {
			// back button from profile page to myMatchesTab
			matches.ChatbackButton.click();
		}

	}

	@Test(priority = 1, description = "Verify user is able to navigate to Shortlist tab and verify the shortlisted profile is present in Shortlist tab")
	public void navigateToShortlistTabAndVerifyShortlistedProfile() throws InterruptedException {

		matches.verifyProfileShortlisted(shortlistProfileName);

	}

	@Test(priority = 2, description = "Verify user info ")
	public void verifyProfileInfoOnListingPage() {

		matches.verifyProfileInfoOnListingPage();
	}

	@Test(priority = 3, description = "Verify user is able to remove member from Shortlists and  profile does not appear in shortlist tab")
	public void removeProfileFromShortlistAndVerifyProfileRemoved() throws InterruptedException {

		matches.verifyProfileRemovedFromShortlist(menu);
	}

	@Test(priority = 4, description = "Verify dropdown selection options on Shortlists listing")
	public void verifyDropDownOnListingPage() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			matches.verifyDropDownOptions();
		}

	}

	@Test(priority = 5, description = "Verify 'Mobile number Verified' text is shown when user clicks on Trust Badge icon")
	public void verifyTrustbadgesOnProfile() throws InterruptedException {

		matches.verifyTrustBadgesOnProfileListing();
	}

	@Test(priority = 6, description = "Verify the count of the uploaded photos")
	public void verifyPhotoCountOnProfileCard() throws InterruptedException {

		matches.verifyPhotoAlbumOnListingPage();
	}

	@Test(priority = 7, description = "Verify connect now on profile on Shortlist listing tab")
	public void verifyProfileFromMyMatchesTabListing_connect() throws InterruptedException {

		matches.verifyProfileFromListingPageConnectNow();

	}

	@Test(priority = 8, description = "Verify view contact on profile on Shortlist listing tab")
	public void verifyProfileFromMyMatchesTabListing_viewContact() throws InterruptedException {

		matches.verifyProfileFromListingPageViewContact();

	}

	@Test(priority = 9, description = "Verify user can navigate to profile page from Shortlist Tab listing")
	public void navigateToProfilePageShortlistListing() throws InterruptedException {

		matches.verifyNavigationToProfilePageFromMatchesListing();

	}

}
