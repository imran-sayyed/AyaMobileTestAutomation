package page.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import android.shaadi.BasePageActions;
import data.ReactRegData;
import page.actions.BottomMenu;
import page.actions.EmptyCasesAction;
import page.actions.InboxPage;
import page.actions.LoginPage;
import page.actions.MyShaadiPage;
import page.actions.RegistrationPage;
import page.objects.MatchesPageObjects;
import shaadi.utils.AppStringConstants;

public class EmptyCasesTest extends BasePageActions {

	Object[][] returnValue;
	LoginPage login;
	EmptyCasesAction empty_obj;
	RegistrationPage register;
	InboxPage inbox;
	BottomMenu menu;
	MyShaadiPage shaadipage;
	MatchesPageObjects matches_obj;

	public static boolean receivedFlag = false, shortlistTab = false;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {

		login = new LoginPage();
		matches_obj = new MatchesPageObjects();
		empty_obj = new EmptyCasesAction();
		register = new RegistrationPage();
		menu = new BottomMenu();
		inbox = new InboxPage();
		shaadipage = new MyShaadiPage();
		if (RunEnvironment.equals("iOSLocal")) {
			login.Allow();
		}

	}

	@Test(priority = 1, description = "verify the Registration flow", dataProvider = "getReactRegData")
	public void perforReg(ReactRegData reg1Data) throws InterruptedException {

		waitForElementToBeDisplayed(login.btnSignupFree, "wait for sign up button to be visible", "regpage1");

		login.btnSignupFree.click();
		Thread.sleep(5000);
		
		if (RunEnvironment.equalsIgnoreCase("androidlocal")) {
			
			System.out.println("Changing context to web");

			register.changeContext("WEBVIEW_com.shaadi.android");
		}

		empty_obj.performReg(reg1Data);
	}

	@Test(priority = 2, description = "Verify Empty case on Recieved TAB")
	public void checkEmptyCase_RecievedTab() throws Exception {

		receivedFlag = true;

		//InboxReceivedObjects.btnInboxTab.click();
		menu.ClickInbox();

		Thread.sleep(3000);

		empty_obj.checkEmptyMessages(empty_obj.txt_PendingInvitaion, empty_obj.txt_NoInvitation_RecievedTab,
				empty_obj.txt_TodayMatches, AppStringConstants.noPendingInvitationRecieved,
				AppStringConstants.viewTodaysMatchesRecieved);

	}

	@Test(priority = 3, description = "Verify Empty case on Accepted TAB")
	public void checkEmptyCase_AcceptedTab() throws Exception {

		receivedFlag = false;
		menu.clickOnlyOnInbox();

		empty_obj.btn_Tab_Accepted.click();
		
		Thread.sleep(5000);

		empty_obj.checkEmptyMessages(empty_obj.txt_GotoInbox_AcceptTab, empty_obj.txt_NoInvitaion_Generic,
				empty_obj.txt_NoInviteMessag_Generic, AppStringConstants.noInvitationTextGeneric,
				AppStringConstants.noPendingInvitationAccepted);
	}

	@Test(priority = 4, description = "Verify Empty case on Request TAB")
	public void checkEmptyCase_RequestTab() throws Exception {
		menu.clickOnlyOnInbox();

		empty_obj.bnt_Tab_Request.click();

		Thread.sleep(3000);

		empty_obj.checkEmptyMessages_RequestTab(empty_obj.txt_PendingReq_RequestTab,
				empty_obj.txt_NoPendingReq_RequestTab, AppStringConstants.noPendingRequest);
	}

	@Test(priority = 5, description = "Verify Empty case on Sent TAB")
	public void checkEmptyCase_SentTab() throws Exception {

		menu.clickOnlyOnInbox();

		inbox.btnSentItemsTab.click();
		Thread.sleep(2000);
		empty_obj.checkEmptyMessages(empty_obj.txt_GotoMyMacthes_SentTab, empty_obj.txt_NoInvitaion_Generic,
				empty_obj.txt_NoInviteMessag_Generic, AppStringConstants.noInvitationTextGeneric,
				AppStringConstants.noPendingResponseSent);

	}

	@Test(priority = 6, description = "Verify Empty case on Sent TAB")
	public void checkEmptyCase_DeleteTab() throws Exception {
		menu.clickOnlyOnInbox();

		inbox.btnDeletedTab.click();
		Thread.sleep(2000);
		empty_obj.checkEmptyMessages(empty_obj.txt_GotoMyMacthes_SentTab, empty_obj.txt_NoInvitaion_Generic,
				empty_obj.txt_NoInviteMessag_Generic, AppStringConstants.noInvitationTextGeneric,
				AppStringConstants.noPendingInvitationDelete);
	}

	@Test(priority = 7, description = "Verify Empty case on Sent TAB")
	public void checkEmptyCase_ShortlistedTab() throws InterruptedException {

		shortlistTab=true;
		
		//menu.MatchesTab.click();
		
		menu.clickOnMatches();

		matches_obj.MyMatchestabIOS.click();
		matches_obj.NearMetabIOS.click();
		Thread.sleep(5000);
		matches_obj.MoreMatchestab.click();
		matches_obj.ShortlistTab.click();

		Thread.sleep(2000);

		if (RunEnvironment.equalsIgnoreCase("androidlocal")) {
			empty_obj.checkEmptyMessages(empty_obj.btn_SearchForProfile_ShortlistTab,
					empty_obj.txt_NoMoreMatches_ShortlistTab, empty_obj.txt_NoMoreMatchesMSg_ShortlistTab,
					AppStringConstants.noProfilesShortlistAndroid.trim(),
					AppStringConstants.NoProfilesMsgShortlistAndroid.trim());
		} else {
			empty_obj.checkEmptyMessages(empty_obj.txt_NoInvitaion_Generic, empty_obj.txt_NoInvitaion_Generic,
					empty_obj.txt_NoInviteMessag_Generic, AppStringConstants.noProfilesShortlist.trim(),
					AppStringConstants.noProfilesMsgShortlist.trim());

		}

	}

	@Test(priority = 8, description = "Verify Empty case on Recently Viewed  TAB")
	public void checkEmptyCase_RVTab() throws InterruptedException {

		boolean isBlockedMemberPresent, isIgnoredMemberPresent;
		
		Thread.sleep(3000);
		
		matches_obj.RVTab.click();

		Thread.sleep(2000);

		isBlockedMemberPresent = isDisplayed(empty_obj.txt_MembersBlockedç);

		isIgnoredMemberPresent = isDisplayed(empty_obj.txt_MembersIgnored);

		Assert.assertFalse(isBlockedMemberPresent, "Blocked Member Block should not be  seen");

		Assert.assertFalse(isIgnoredMemberPresent, "Ignored Member Block should not be seen");

	}
	
	@Test(priority = 9,description = "Check if new user is able to navigate to Chat Window")
	public void checkChatWindow_Nav() throws Exception
	{
		
		menu.clickChatTab();
		
		Thread.sleep(2000);
		
		String chatWindowWarning=empty_obj.txt_ChatWindowError.getText();
		
		empty_obj.btnOkChatWindow.click();
		
		Assert.assertEquals(chatWindowWarning, AppStringConstants.chatWindowWarningText,"Chat window warning for new user does not match");
			
	}
	
	@Test(priority = 10,description = "Verify user is able to Naviagate to Today's Matches from Recevied Tab")
	public void verifyNavToTodaysMatches() throws Exception
	{
		
		menu.ClickInbox();
		empty_obj.btn_Tab_Accepted.click();
		Thread.sleep(1000);
		empty_obj.btn_Tab_Recieved.click();
		Thread.sleep(4000);
		empty_obj.txt_TodayMatches.click();
		Thread.sleep(2000);
		Assert.assertTrue(chckElementPresent(empty_obj.btn_todaysMatches),"Today's Macthes Tab is seen to the user");
		
		
		
	}
	
	@Test(priority = 11,description = "Verify user is able to Naviagate to Inbox from Accepted Tab")
	public void verifyNavToInbox() throws Exception
	{
		menu.ClickInbox();
		empty_obj.btn_Tab_Accepted.click();
		Thread.sleep(1000);
		empty_obj.txt_GotoInbox_AcceptTab.click();
		Thread.sleep(2000);
		Assert.assertTrue(chckElementPresent(empty_obj.txt_PendingInvitaion),"Recieved TAB is seen to the user");
		
		
		
	}
	
	@Test(priority = 12,description = "Verify user is able to Naviagate to My Macthes Tab from Sent Tab")
	public void verifyNavMyMatchesTab_SentTab() throws InterruptedException
	{
		inbox.btnSentItemsTab.click();
		Thread.sleep(3000);
		empty_obj.txt_GotoMyMacthes_SentTab.click();
		Thread.sleep(2000);
		Assert.assertTrue(empty_obj.txtHeaderOnMyMatches.getText().contains("Matching your Preferences"),"My Matches Tab is seen to the user");
		
		
		
	}
	
	@Test(priority = 13,description = "Verify user is able to Naviagate to My Macthes Tab from Delete Tab")
	public void verifyNavMyMatchesTab_DeleteTab() throws Exception
	{
		menu.ClickInbox();
		Thread.sleep(1000);
		inbox.btnDeletedTab.click();
		Thread.sleep(3000);
		empty_obj.txt_GotoMyMacthes_SentTab.click();
		Thread.sleep(2000);
		Assert.assertTrue(empty_obj.txtHeaderOnMyMatches.getText().contains("Matching your Preferences"),"My Matches Tab is seen to the user");
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getReactRegData() throws FileNotFoundException {
		try {
			File ReactPage1_json = new File("src/main/java/data/reactreg_EmptyCase.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(ReactPage1_json.getAbsolutePath()));
			JsonElement dataSet = jsonData.getAsJsonObject().get("Reg1Data");
			List<ReactRegData> testData = new Gson().fromJson(dataSet, new TypeToken<List<ReactRegData>>() {
			}.getType());
			returnValue = new Object[testData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = testData.get(index++);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return returnValue;
	}

}
