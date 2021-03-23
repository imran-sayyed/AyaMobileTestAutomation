package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class MatchesProfilePageTest extends BasePageActions{

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
	
	
	@Test(priority = 1, description = "Verify connect now on profile on from profile page")
	public void verifyProfileFromProfilePage_connect() throws InterruptedException {

		matchespage.verifyProfileFromProfilePageConnectNow();
	}

	@Test(priority = 2, description = "Verify view contact on profile on from profile page")
	public void verifyProfileFromProfilePage_viewContact() throws InterruptedException {

		matchespage.verifyProfileFromProfilePageViewContact();
	}

	@Test(priority = 3, description = "Verify Trust badge from profile page")
	public void verifyTrustBadgesOnProfilePage() throws InterruptedException {

		matchespage.verifyTrustBadgesOnProfilePage();

	}

	@Test(priority = 4, description = "Verify photo Album from profile page")
	public void verifyPhotoAlbumOnProfilePage() throws InterruptedException {

		matchespage.verifyPhotoAlbumOnProfilePage();

	}

	@Test(priority = 5, description = "Verify Shortlist profile from profile page")
	public void verifyShortlistFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.shortlistUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.shortlistUserFromProfilePage(matchespage.dropDownThreeDots);

		}
	}

	@Test(priority = 6, description = "Verify Block profile from profile page")
	public void verifyBlockFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.blockUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.blockUserFromProfilePage(matchespage.dropDownThreeDots);

		}
	}
	
	@Test(priority = 7, description = "report a user from  profile page dropdowm")
	public void verifyReportProfileOnDropDown() throws InterruptedException {


		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {

		matchespage.reportUserFromProfilePage(matchespage.dropdownArrow);
		}
		else {
			matchespage.reportUserFromProfilePage(matchespage.dropDownThreeDots);

		}
		
	}

	@Test(priority = 8, description = "Verify Ignore profile from profile page" , enabled = false)
	public void verifyIgnoreFromProfilePage() throws InterruptedException {

		if(isDisplayedAfterWait(matchespage.dropdownArrow, 3)) {
			matchespage.ignoreUserFromProfilePage(matchespage.dropdownArrow);
		}
	}
	
	
}
