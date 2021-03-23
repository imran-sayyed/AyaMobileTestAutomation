package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import shaadi.utils.AppStringConstants;

public class EmptyCasesObject extends BasePageActions {

	@iOSFindBy(id = "Pending Invitations (0)")
	@AndroidFindBy(id="com.shaadi.android:id/layoutRefine_txtTitle")
	public WebElement txt_PendingInvitaion;

	@iOSFindBy(id = "labelMessage")
	@AndroidFindBy(id="com.shaadi.android:id/tv_no_invitations")
	public WebElement txt_NoInvitation_RecievedTab;

	@iOSFindBy(id = "View Today's Matches")
	@AndroidFindBy(id="com.shaadi.android:id/tv_click_matches")
	public WebElement txt_TodayMatches;
	
	@iOSFindBy(id="buttonSubNav2")
	//@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Today's Matches\")")
	@AndroidFindBy(id = "com.shaadi.android:id/imageView_single_photo")
	public WebElement btn_todaysMatches;

	@iOSFindBy(id = "buttonSubNav0")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Received\")")
	public WebElement btn_Tab_Recieved;

	
	@iOSFindBy(id = "buttonSubNav1")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Accepted\")")
	public WebElement btn_Tab_Accepted;

	@iOSFindBy(id = "Go to Inbox")
	@AndroidFindBy(id="com.shaadi.android:id/viewrecentmatches")
	public WebElement txt_GotoInbox_AcceptTab;

	@iOSFindBy(id = "buttonSubNav2")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Requests\")")
	public WebElement bnt_Tab_Request;

	@iOSFindBy(id = "Pending Requests")
	public WebElement txt_PendingReq_RequestTab;

	@iOSFindBy(id = "labelnoRequestLabel")
	@AndroidFindBy(id="com.shaadi.android:id/tv_no_invitations")
	public WebElement txt_NoPendingReq_RequestTab;

	@iOSFindBy(id = "Go to My Matches")
	@AndroidFindBy(id="com.shaadi.android:id/viewrecentmatches")
	public WebElement txt_GotoMyMacthes_SentTab;

	@iOSFindBy(id = "labelTitle")
	@AndroidFindBy(id="com.shaadi.android:id/noresultheading")
	public WebElement txt_NoInvitaion_Generic;

	@iOSFindBy(id = "labelSubTitle")
	@AndroidFindBy(id="com.shaadi.android:id/noresultmsg")
	public WebElement txt_NoInviteMessag_Generic;
	
	@iOSFindBy(id="labelSectionSubTitle_ignored")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profiles you Ignored']")
	public WebElement txt_MembersIgnored;
	
	@iOSFindBy(id="labelSectionSubTitle_blocked")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profiles you Blocked']")
	public WebElement txt_MembersBlockedç;
	
	
	@AndroidFindBy(id="com.shaadi.android:id/textView1")
	public WebElement txt_NoMoreMatches_ShortlistTab;
	
	@AndroidFindBy(id="com.shaadi.android:id/textView2")
	public WebElement txt_NoMoreMatchesMSg_ShortlistTab;
	
	@AndroidFindBy(id="com.shaadi.android:id/modifysearchbtn")
	public WebElement btn_SearchForProfile_ShortlistTab;
	
	@iOSFindBy(xpath = AppStringConstants.chatWindowWarningElement)
	//@AndroidFindBy(xpath = AppStringConstants.ChatWindowWarning_Element_Android)
	@AndroidFindBy(id = "android:id/message")
	public WebElement txt_ChatWindowError;
	
	@iOSFindBy(id="OK")
	@AndroidFindBy(id = "android:id/button1")
	public WebElement btnOkChatWindow;
	
	@iOSFindBy(className = "XCUIElementTypeAlert")//Oops!
	public WebElement alert_Opps;
	
	@AndroidFindBy(id = "com.shaadi.android:id/textView_sub_title")
	@iOSFindBy(name="Matching your Preferences")
	public WebElement txtHeaderOnMyMatches;
	
	

}
