package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;
import page.actions.MatchesPage;
import page.objects.DashboardObjects;

public class SendConectFromListingTest extends BasePageActions {

	public static String setUserType;
	public static boolean navFlag;
	public InboxPage inb_obj;
	DashboardObjects dsh_obj;
	MatchesPage match_obj;
	public static BottomMenu btm_obj;
	public static String[] connectSentSplit;
	public static boolean scrollFlag = false;
	public static String usrName_MyMatches, usrName_NearMeTab, usrName_Rv, usrName_MembersYouLike,
			usrName_MemberslookingForMe, usrNmae_ShortListed;
	public static String usrName_RecentlyViewed, usrName_Ignored;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {

		match_obj = new MatchesPage();
		dsh_obj = new DashboardObjects();
		btm_obj = new BottomMenu();
		inb_obj = new InboxPage();

		closeUnWantedPage();

		Thread.sleep(3000);

		btm_obj.MyShaadiTab.click();

		closeUnWantedPage();

		setUserType = setMyUser(DashboardObjects.usr_Profile_Expiry);

		System.out.println("\n" + setUserType + " User is Running the test" + "\n");

		btm_obj.MatchesTab.click();

	}

	@Test(priority = 1, description = "\n Send Connect from New TAB and verify if Profile is Visibile in Send TAB\n")
	public void sendConnectFrom_NewTab() throws InterruptedException {

		String userName;
		match_obj.btnNewMatchesTodays.click();

		match_obj.btnNewMatchesTab.click();
		// match_obj.txt_SecondNameInList index is changed to 0 for label display name
		// after new changes are done in iOS build 7.5.0
		if (setUserType.equalsIgnoreCase("Free")) {
			userName = match_obj.sendConnectFromListing(setUserType, match_obj.txt_SecondNameInList);
		}

		else {
			userName = match_obj.sendConnectFromListing(setUserType, match_obj.txt_SecondNameInList_myMatches);
		}

		System.out.println("User Added from New TAB " + userName + "\n");

		match_obj.checkifConnectSend(userName);
	}

	@Test(priority = 2, description = "\n Send Connect from My matches TAB ")
	public void sendConnectFrom_MyMatchesTab() throws InterruptedException {
		scrollFlag = true;

		btm_obj.MatchesTab.click();

		match_obj.MyMatchestabIOS.click();

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_MyMatches = match_obj.sendConnectFromListing(setUserType, match_obj.txt_SecondNameInList_myMatches);
		}

		else {
			usrName_MyMatches = match_obj.sendConnectFromListing(setUserType, match_obj.txt_FirstNameInList_premium);

		}

		System.out.println("User Added from My Matches TAB " + usrName_MyMatches + "\n");

	}

	@Test(priority = 3, description = "\n Send Connect from My matches TAB")
	public void sendConnectFrom_NearMetab() throws Exception {
		btm_obj.inbox.click();

		btm_obj.MatchesTab.click();

		match_obj.NearMetabIOS.click();

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_NearMeTab = match_obj.sendConnectFromListing(setUserType, match_obj.txt_SecondNameInList_myMatches);
		}

		else {
			usrName_NearMeTab = match_obj.sendConnectFromListing(setUserType, match_obj.txt_FirstNameInList_premium);
		}

		System.out.println("User Added from Near Me TAB " + usrName_NearMeTab + "\n");

	}

	@Test(priority = 4, description = "\nConnect send to profile from My Matches should be seen in Sent TAB")
	public void verfiyProfileInSentTab_MyMatches() throws InterruptedException {
		scrollFlag = false;
		match_obj.checkifConnectSend(usrName_MyMatches);

	}

	@Test(priority = 5, description = "\nConnect send to profle from My Matches should be seen in Sent TAB")
	public void verfiyProfileInSentTab_NearMe() throws InterruptedException {

		match_obj.checkifConnectSend(usrName_NearMeTab);

	}

	@Test(priority = 6, description = "\n Send Connect from Recent Visitors under More Macthes TAB")
	public void sendConnectFrom_MM_RVTab() throws Exception {

		btm_obj.inbox.click();

		btm_obj.MatchesTab.click();

		match_obj.MoreMatchestab.click();

		Thread.sleep(5000);

		match_obj.btn_SeeAll_RV.click();

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_Rv = match_obj.sendConnectFromListing(setUserType, match_obj.txt_SecondNameInList_myMatches);
		}

		else {
			usrName_Rv = match_obj.sendConnectFromListing(setUserType, match_obj.txt_FirstNameInList_premium);

		}

		System.out.println("User Added from Recen Visitor TAB under More Matches " + usrName_Rv + "\n");

		driver.navigate().back();

	}

	@Test(priority = 7, description = "Connect send to profle from My Matches should be seen in Sent TAB")
	public void verfiyProfileInSentTab_MM_RV() throws InterruptedException {
		scrollFlag = true;
		match_obj.checkifConnectSend(usrName_Rv);

	}

	@Test(priority = 8, description = "\n Send Connect Members you may like under More Macthes TAB")
	public void sendConnectFrom_MM_MemberYouMayLike() throws Exception {

		scrollFlag = false;

		btm_obj.MatchesTab.click();

		match_obj.MoreMatchestab.click();

		Thread.sleep(3000);

		scrollDownToElement(match_obj.btn_SeeAll_MemberYouMayLike);

		match_obj.btn_SeeAll_MemberYouMayLike.click();
		
		Thread.sleep(3000);

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_MembersYouLike = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_SecondNameInList_myMatches);
		}

		else {
			usrName_MembersYouLike = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_FirstNameInList_premium);

		}

		System.out.println(
				"User Added from Members You May like TAB under More Matches " + usrName_MembersYouLike + "\n");

		driver.navigate().back();

	}

	@Test(priority = 9, description = "\n Send Connect from Member Looking for Me  under More Macthes TAB")
	public void sendConnectFrom_MM_MembersLookingForMe() throws Exception {

		scrollFlag = false;

		Thread.sleep(5000);

		scrollDownToElement(match_obj.btn_SeeAll_MemberLookingForMe);

		match_obj.btn_SeeAll_MemberLookingForMe.click();

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_MemberslookingForMe = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_SecondNameInList_myMatches);
		}

		else {

			usrName_MemberslookingForMe = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_FirstNameInList_premium);

		}

		System.out.println(
				"User Added from Members Looking For Me Tab under More Matches " + usrName_MemberslookingForMe + "\n");

		driver.navigate().back();

	}

	@Test(priority = 10, description = "Connect send to profile from My Matches should be seen in Sent TAB")
	public void verfiyProfileInSentTab_MM_MembersYouMayLike() throws InterruptedException {

		match_obj.checkifConnectSend(usrName_MembersYouLike);

	}

	@Test(priority = 11, description = "Connect send to profile from My Matches should be seen in Sent TAB")
	public void verfiyProfileInSentTab_MM_MembersLookingForMe() throws InterruptedException {

		match_obj.checkifConnectSend(usrName_MemberslookingForMe);

	}

	@Test(priority = 12, description = "\n Send Connect Shortlisted  TAB")
	public void sendConnectFrom_ShortlistedTab() throws Exception {
		scrollFlag = true;

		btm_obj.MatchesTab.click();

		match_obj.ShortlistTab.click();

		Thread.sleep(3000);

		if (setUserType.equalsIgnoreCase("Free")) {
			usrNmae_ShortListed = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_SecondNameInList_myMatches);

		}

		else {

			usrNmae_ShortListed = match_obj.sendConnectFromListing(setUserType, match_obj.txt_FirstNameInList_premium);

		}

		System.out.println("User Added from Shortlisted TAB " + usrNmae_ShortListed + "\n");

	}

	@Test(priority = 13, description = "Connect send to profile from Shortlisted should be seen in Sent TAB")
	public void verfiyProfileInSentTab_ShortlistedTab() throws InterruptedException {
		scrollUp();
		match_obj.checkifConnectSend(usrNmae_ShortListed);

	}

	@Test(priority = 14, description = "\n Send Connect from  Recently Viewed Members TAB")
	public void sendConnectFrom_RecentlyViewedTab_RVMembersSection() throws Exception {
		scrollFlag = false;

		btm_obj.MatchesTab.click();

		Thread.sleep(2000);

		match_obj.RVTab.click();

		Thread.sleep(3000);

		match_obj.btn_SeeAll_recently_viewed.click();

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_RecentlyViewed = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_SecondNameInList_myMatches);

		}

		else {

			usrName_RecentlyViewed = match_obj.sendConnectFromListing(setUserType,
					match_obj.txt_FirstNameInList_premium);

		}

		System.out.println("User Added from Recently Viewed TAB " + usrName_RecentlyViewed + "\n");

		driver.navigate().back();

	}

	@Test(priority = 15, description = "\n Send Connect From Ignored Members  TAB")
	public void sendConnectFrom_RecentlyViewedTab_IgnoredMemberSection() throws Exception {

		scrollDownToElement(match_obj.btn_SeeAll_Ignored);

		Thread.sleep(3000);

		match_obj.btn_SeeAll_Ignored.click();

		if (setUserType.equalsIgnoreCase("Free")) {
			usrName_Ignored = match_obj.sendConnectFromListing(setUserType, match_obj.txt_SecondNameInList_myMatches);

		}

		else {

			usrName_Ignored = match_obj.sendConnectFromListing(setUserType, match_obj.txt_FirstNameInList_premium);

		}

		System.out.println("User Added from Ignored TAB " + usrName_Ignored + "\n");

		driver.navigate().back();

	}

	@Test(priority = 16, description = "Connect send to profile fRecently Viewed Members TAB should be seen in Sent TAB")
	public void verfiyProfileInSentTab_RV_RVMembersSection() throws InterruptedException {
		scrollUp();
		match_obj.checkifConnectSend(usrName_RecentlyViewed);

	}

//	@Test(priority = 17, description = "Connect send to Send Connect From Ignored Members TAB should be seen in Sent TAB")
//	public void verfiyProfileInSentTab_RecentlyViewedTab_IgnoredMemberSection() throws InterruptedException {
//		scrollUp();
//		match_obj.checkifConnectSend(usrName_Ignored);
//
//	}

}
