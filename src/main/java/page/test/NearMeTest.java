package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class NearMeTest extends BasePageActions {
	MatchesPage matches;
	BottomMenu menu;

	public static boolean premFlag = false;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {

		matches = new MatchesPage();
		menu = new BottomMenu();

		
		
		menu.clickOnMatches();

		
		matches.nearMeHeader();
			
        
		
		System.out.println(driver.getPageSource());
		
		Thread.sleep(2000);
		
		
		
	}

	@Test(priority = 0, groups = "", description = "Verify user is able to see Profile on Near Me TAB")
	public void nearMe_ProfileCheck() throws InterruptedException {
		switch (UserType) {
		case "inboxaccepted":
			matches.profileInfo();
			matches.trustBadge();
			matches.dropDownValues();
			matches.photoCase();
			break;

		case "savedraft":
			matches.profileInfo();
			matches.trustBadge();
			matches.dropDownValuesPremium();
			matches.photoCaseforPremium();

			break;

		default:
			break;
		}
	}

	@Test(priority = 1, groups = "", description = "Verfiy Shortlist on Near Me Tab")
	public void shortList_NearMeTab() throws InterruptedException {
		switch (UserType) {
		case "inboxaccepted":
			matches.UserName_NearMe.click();
			matches.shortlistUserFromProfilePage();
			break;

		case "savedraft":
			matches.shortlistUserFromProfilePage();
			break;

		default:
			break;
		}
	}

	@Test(priority = 2, groups = "", description = "Verfiy Ignore User on Near Me Tab")
	public void ignoreUser_NearMeTab() throws InterruptedException {
		switch (UserType) {
		case "inboxaccepted":
			matches.ignoreUserFromProfilePage();
			break;

		case "savedraft":
			matches.ignoreUserFromProfilePage();
			break;

		default:
			break;
		}
	}

	@Test(priority = 3, groups = "", description = "Verfiy Block on Near Me Tab")
	public void blockUser_NearMeTab() throws InterruptedException {
		switch (UserType) {
		case "inboxaccepted":
			matches.blockUserFromProfilePage();
			break;

		case "savedraft":
			matches.blockUserFromProfilePage();
			break;

		default:
			break;
		}
	}

	@Test(priority = 4, groups = "", description = "Verfiy Block on Near Me Tab")
	public void connectUsingBottomCTA_NearMeTab() throws InterruptedException {

		switch (UserType) {

		case "inboxaccepted":

			matches.profileInfo();

			waitForSometime(2000);

			scrollDownToElement(matches.txt_ConvoStarter);

			matches.BottomCTA(matches.LikeprofileTxt);

			scrollDownToElement(matches.btnConnectOnList);

			matches.connectOnList();

			break;

		case "savedraft":
			premFlag = true;

			matches.profileInfo();

			waitForSometime(2000);

			scrollDownToElement(matches.txt_ConvoStarter);

			matches.BottomCTA(matches.LikeprofileTxt_premium);

			scrollDownToElement(matches.btnConnectOnList);

			matches.connectOnList();

			break;

		default:
			break;
		}
	}

}
