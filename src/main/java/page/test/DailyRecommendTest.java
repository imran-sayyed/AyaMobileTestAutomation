package page.test;

import org.testng.annotations.Test;

import page.actions.DailyRecommendActions;
import page.objects.DailyRecommendObjects;

public class DailyRecommendTest extends DailyRecommendActions {
	
	public static String profileName;
	
	@Test(priority = 0, groups = "")
	public void VerifyCTAs() throws Exception
	{
		CTAAsserts();
		System.out.println("Test Case 1 Completed..");
	}
	
	@Test(priority = 1, groups = "")
	public void SendConnect() throws Exception
	{
		ClickConnect();
		
		System.out.println("Test Case 2 Completed..");
	}
	
	@Test(priority = 2, groups = "")
	public void VerifyConnectandViewContact() throws Exception
	{
		ClickPreviousProfile();
		AssertInvitation();
		ClickViewContact();
		VerifyContactDetails(true);
		System.out.println("Test Case 3 Completed..");
	}
	
	@Test(priority = 3, groups = "")
	public void ProfileProof() throws Exception
	{
		VerifyProfileData(DailyRecommendObjects.labelProfileName);
		VerifyProfileData(DailyRecommendObjects.labelProfileAge);
		VerifyProfileData(DailyRecommendObjects.labelProfileLanguage);
		VerifyProfileData(DailyRecommendObjects.labelProfileProfession);
		VerifyProfileData(DailyRecommendObjects.labelProfileAddress);
		System.out.println("Test Case 4 Completed..");
	}
	
	@Test(priority = 4, groups = "")
	public void ViewContactData() throws Exception
	{
		VerifyContactDetails(false);
		System.out.println("Test Case 5 Completed..");
	}
	
	@Test(priority = 5, groups = "")
	public void VerifyBottomCTAView() throws Exception
	{
		VerifyBottomCTA();
	}
	
	@Test(priority = 6, groups = "")
	public void BottomConnect() throws Exception
	{
		SendBottomConnect();
	}
	
	@Test(priority = 7, groups = "")
	public void AddtoShortlist() throws Exception
	{
		ClickProfileOptions();
		Thread.sleep(2000);
		ClickShortlist();
		Thread.sleep(2000);
		//ScrollToolBarNew("Recently Viewed");
		//ScrollToolBarNew("Recently Viewed");
		//ClickShortlists();
	}
	
	@Test(priority = 8, groups = "")
	public void OnlineAndMatchingData() throws Exception
	{
		Thread.sleep(2000);
		ClickButtonProfileOnline();
		Thread.sleep(2000);
		ClickChatBackArrow();
		Thread.sleep(2000);
		ClickButtonProfileMatchingData();
		Thread.sleep(2000);
		ClickGreenTick();
		Thread.sleep(2000);
	//	ClickProfileProofIcon();
	}
	
	@Test(priority = 9, groups = "")
	public void SendConnectFromPhotoProfile() throws Exception
	{
		String TCID = "DR-9";
		GotoPhotoProifle(TCID);
		ClickButtonContextual(TCID);
		VerifyAndSendPhotoProfileConnect(TCID);
	}
	
	@Test(priority = 10, groups = "")
	public void VerifyTodayMatchesCount() throws Exception {
		
		String TCID = "DR-10";
		
		String actualCnt=VerifyTodayCount(TCID);
		
	    ClickNextTillLastProfile(actualCnt,TCID);
	
	}

	@Test(priority = 11, groups = "")
	public void VerifyThankYouPage() throws Exception {
		String TCID = "DR-11";
	}
}
