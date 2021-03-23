package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class MoreMatchesTest extends BasePageActions {

	String RecentVisitorsCount;
	String MembersYouMayLikeCount;
	String MembersLookingforMeCount;

	MatchesPage matches;
	BottomMenu menu;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		matches = new MatchesPage();
		menu = new BottomMenu();
	}

	@Test(priority = 0, description = "Verify landing on More Matches page")
	public void verifyLandingOnMoreMatchespage() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		menu.clickOnMatches();
		BasePageActions.navigateToSpecifiedMatchesTab(matches.MoreMatches, "Navigate to More Matches tab");
		Thread.sleep(2000);
		BasePageActions.scrollUpToElement(matches.RecentVisitors);

		// verify Recent Visitors section
		RecentVisitorsCount = matches.verifyRecentVisitorssection(sa);

		// verify Members you may like section
		MembersYouMayLikeCount = matches.verifyMembersYouMayLikesection(sa);

		// verify Members looking for me section
		MembersLookingforMeCount = matches.verifyMembersLookingforMesection(sa);

		// scroll up to Recent Visitors
		BasePageActions.scrollUpToElement(matches.RecentVisitors);

		sa.assertAll();
	}

	/*-----------------------Recent Visitors section------------------------*/

	@Test(priority = 1, description = "Verify user is able to view Recent Visitors section")
	public void verifyRecentVisitorsSection() {

		matches.verifyRecentVisitorsSections();
	}

	@Test(priority = 2, description = "Verify user can navigate to profile page of recent visitor")
	public void verifyuserNavigationToProfilePageRecentVisitor() throws InterruptedException {

		matches.verifyUserNavigationToProfilePageRecentlyViewed();
	}

	@Test(priority = 3, description = "Verify user can initiate chat with Recent Visitor")
	public void initiateChat_RecentVisitors() throws InterruptedException {

		matches.initiateChatFromProfilePage();
	}

	@Test(priority = 4, description = "Verify user can view the conversation starter")
	public void viewConversationStarter_RecentVisitors() throws InterruptedException {

		matches.viewConversationStarterFromProfilePage();
	}

	@Test(priority = 5, description = "Verify Next / Prev button appears on Profile page opened from Recent Visitor widget")
	public void verifySwipeOnProfilePage_RecentVisitor() throws InterruptedException {

		matches.verifySwipeOnProfilePage();
	}

	@Test(priority = 6, description = "Verify user is able to swipe through the Recent Visitors section")
	public void swipeRecentVisitorsSection() throws InterruptedException {

		matches.verifySwipeOnRecentlyViewedSections(matches.RecentVisitors);
	}

	@Test(priority = 7, description = "Verify user can view the count on Recent Visitor widget")
	public void verifyRecentVisitorsCount() {

		matches.verifyRecentlyViewedSectionsCount(RecentVisitorsCount);

	}

	@Test(priority = 8, description = "Verify user can navigate to profile page of recent visitor from Recent Visitors list")
	public void navigateToProfilePageFromRecentVisitorsList() throws InterruptedException {

		matches.verifyNavigationToProfilePageFromListing();

	}

	/*-----------------------Members you may like section------------------------*/

	@Test(priority = 9, description = "Verify user is able to view Members you may like section")
	public void verifyMembersYouMayLikeSectionDetails() throws InterruptedException {

		matches.verifyMembersYouMayLikeSectionDetails();
	}

	@Test(priority = 10, description = "Verify user can navigate to profile page of Members you may like")
	public void navigateToProfilePageOfMembersYouMayLike() throws InterruptedException {

		matches.verifyUserNavigationToProfilePageRecentlyViewed();

	}

	@Test(priority = 11, description = "Verify user can initiate chat with Members you may like")
	public void initiateChat_MembersYouMayLike() throws InterruptedException {

		matches.initiateChatFromProfilePage();
	}

	@Test(priority = 12, description = "Verify user can view the conversation starter")
	public void viewConversationStarter_MembersYouMayLike() throws InterruptedException {

		matches.viewConversationStarterFromProfilePage();
	}

	@Test(priority = 13, description = "Verify Next / Prev button appears on Profile page opened from Member you may like widget")
	public void verifySwipeOnProfilePage_MembersYouMayLike() throws InterruptedException {

		matches.verifySwipeOnProfilePage();
	}

	@Test(priority = 14, description = "Verify user is able to swipe through the Members you may like section")
	public void swipeMembersYouMayLikeSection() throws InterruptedException {

		matches.verifySwipeOnRecentlyViewedSections(matches.MembersYouMayLike);
	}

	@Test(priority = 15, description = "Verify user can view the count on Member you may like widget")
	public void verifyMembersYouMayLikeCount() {

		matches.verifyRecentlyViewedSectionsCount(MembersYouMayLikeCount);

	}

	@Test(priority = 16, description = "Verify user can navigate to profile page from Members you may like list")
	public void navigateToProfilePageFromMembersYouMayLikeList() throws InterruptedException {

		matches.verifyNavigationToProfilePageFromListing();

	}

	/*-----------------------Members Looking For Me section------------------------*/

	@Test(priority = 17, description = "Verify user is able to view Members looking for me section")
	public void verifyMembersLookingForMeSection() throws InterruptedException {

		matches.verifyMembersLookingForMeSection();
	}

	@Test(priority = 18, description = "Verify user can navigate to profile page of Members looking for me")
	public void navigateToProfilePageOfMembersLookingForMe() throws InterruptedException {

		matches.verifyUserNavigationToProfilePageRecentlyViewed();

	}

	@Test(priority = 19, description = "Verify user can initiate chat with Members looking for me")
	public void initiateChat_MembersLookingForMe() throws InterruptedException {

		matches.initiateChatFromProfilePage();
	}

	@Test(priority = 20, description = "Verify user can view the conversation starter")
	public void viewConversationStarter_MembersLookingForMe() throws InterruptedException {

		matches.viewConversationStarterFromProfilePage();
	}

	@Test(priority = 21, description = "Verify Next / Prev button appears on Profile page opened from Member Looking for you widget")
	public void verifySwipeOnProfilePage_MembersLookingForMe() throws InterruptedException {

		matches.verifySwipeOnProfilePage();
	}

	@Test(priority = 22, description = "Verify user is able to swipe through the Members looking for me section")
	public void swipeMembersLookingForMeSection() throws InterruptedException {

		matches.verifySwipeOnRecentlyViewedSections(matches.MemberslookingforMe);
	}

	@Test(priority = 23, description = "Verify user can view the count on Member looking for you widget")
	public void verifyMembersLookingForMeCount() {

		matches.verifyRecentlyViewedSectionsCount(MembersLookingforMeCount);

	}

	@Test(priority = 24, description = "Verify user can navigate to profile page from Members you may like list")
	public void navigateToProfilePageFromMembersLookingForMeList() throws InterruptedException {

		matches.verifyNavigationToProfilePageFromListing();

	}

}
