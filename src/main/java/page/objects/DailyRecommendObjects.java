package page.objects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class DailyRecommendObjects {

	@iOSFindBy(name = "lblLeftAction.label")
	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public static WebElement labelContact;

	@iOSFindBy(name = "lblCenterAction.label")
	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public static WebElement labelWriteMessage;

	@iOSFindBy(name = "lblRightAction.label")
	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public static WebElement labelConnectNow;

	@iOSFindBy(accessibility = "btnConnect.label")
	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public static WebElement btnConnect;

	@iOSFindBy(accessibility = "tblProfileDetails")
	public static WebElement tblProfileDetails;

	@iOSFindBy(name = "labelProfileName")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	public static WebElement labelProfileName;

	@iOSFindBy(accessibility = "labelProfileDetailsLeft1")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	public static WebElement labelProfileAge;

	@iOSFindBy(accessibility = "labelProfileDetailsLeft2")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_community")
	public static WebElement labelProfileLanguage;

	@iOSFindBy(accessibility = "labelProfileDetailsRight1")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_career")
	public static WebElement labelProfileProfession;

	@iOSFindBy(accessibility = "labelProfileDetailsRight2")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	public static WebElement labelProfileAddress;

	@iOSFindBy(accessibility = "View Details")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_view_horoscope")
	public static WebElement btnAction;

	@iOSFindBy(name = "YES")
	@AndroidFindBy(id = "android:id/button1")
	public static WebElement btnYes;

	@iOSFindBy(name = "My Shaadi")
	public static WebElement tabMyShaadi;

	@iOSFindBy(name = "Matches")
	public static WebElement tabMatches;

	@iOSFindBy(name = "OK")
	public static WebElement btnOk;

	@iOSFindBy(accessibility = "lblSendEmail.label")
	@AndroidFindBy(id = "com.shaadi.android:id/textView33")
	public static WebElement labelSendEmail;

	@iOSFindBy(accessibility = "textviewMessage")
	@AndroidFindBy(id = "com.shaadi.android:id/edtMessage")
	public static WebElement textviewMessage;

	@iOSFindBy(accessibility = "buttonSend")
	@AndroidFindBy(id = "android:id/button1")
	public static WebElement btnSend;

	@iOSFindBy(accessibility = "buttonCancel")
	public static WebElement btnCancel;

	@iOSFindBy(accessibility = "previous navigator")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_prev")
	public static WebElement buttonMoveToPreviousProfile;

	@iOSFindBy(accessibility = "next navigator")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	public static WebElement buttonMoveToNextProfile;

	@iOSFindBy(accessibility = "lblHyperlinkedHeader.label")
	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public static WebElement labelInvitationSent;

	@iOSFindBy(accessibility = "btnHyperLinked.label")
	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public static WebElement labelViewContact;

	@iOSFindBy(accessibility = "viewHeader")
	public static WebElement viewHeader;

	@iOSFindBy(accessibility = "tableviewCallSMS")
	public static WebElement cellViewContact;

	@iOSFindBy(name = "Daily Limit Reached")
	public static WebElement labelDailyLimitReached;

	// @iOSFindBy(accessibility="buttonProfileAlbumRedirection")
	@iOSFindBy(xpath = "//XCUIElementTypeTable[@name=\"tblProfileDetails\"]/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]")
	@AndroidFindBy(id="com.shaadi.android:id/rl_user_album")
	public static WebElement buttonProfileAlbumRedirection;

	@iOSFindBy(name = "Okay, Got it!")
	public static WebElement btnOkGotIt;

	@iOSFindBy(accessibility = "ButtonClose")
	@AndroidFindBy(id="com.shaadi.android:id/cancel")
	public static WebElement ButtonClose;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Like')]")
	public static WebElement lblLikeThisProfile;

	@iOSFindBy(accessibility = "CTA SendInterest")
	@AndroidFindBy(id="com.shaadi.android:id/button3")
	public static WebElement btnCTASendInterest;

	@iOSFindBy(accessibility = "buttonDefaultMessage")
	public static WebElement buttonDefaultMessage;

	@iOSFindBy(className = "XCUIElementTypeSegmentedControl")
	public static WebElement segmentedcontrolSubNav;

	@iOSFindBy(name = "Online")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_onlinestatus")
	public static WebElement btnOnline;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'ago')]")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ago')]")
	public static WebElement btnPstOnLineSts;

	@iOSFindBy(name = "You & Him")
	@AndroidFindBy(id="com.shaadi.android:id/tv_youher")
	public static WebElement btnProfileMatchingData;

	@iOSFindBy(name = "ShYouAndHerCellSectionHeaderID")
	public static WebElement btnGreenTick;

	@iOSFindBy(name = "trustBadgeGreen")
	public static WebElement btnTrustBadge;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtMobile")
	public static MobileElement txtMobileHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/layout_ViewContact_txtMobileNumber")
	public static WebElement txtMobileNum;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtEmail")
	public static WebElement txtEmailId;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtLabelEmail")
	public static WebElement txtEmailHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtLabelContactPerson")
	public static WebElement txtCntPerson;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtContactPerson")
	public static WebElement txtContactPerson;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtLabelContactsAvailable")
	public static WebElement txtLblConAvail;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_txtContactsAvailable")
	public static WebElement txtConAvail;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_btnOK")
	public static WebElement btnOK_ViewContact;

	@iOSFindBy(accessibility = "profile options down arrow")
	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	public static WebElement btnProfileOptions;

	@iOSFindBy(accessibility = "Add to Shortlist")
	@AndroidFindBy(id = "android:id/title")
	public static WebElement btnAddToShrtLst;
	
	@iOSFindBy(accessibility ="arrow left white")
	@AndroidFindBy(className="android.widget.ImageButton")
    public static WebElement btnChatBackArrw;
	
	@AndroidFindBy(id="com.shaadi.android:id/tv_matches_count")
	public static WebElement txtMatchCnt;
}