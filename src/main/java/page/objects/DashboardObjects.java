package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class DashboardObjects extends BasePageActions {

	@FindBy(id = "com.shaadi.android:id/rl_settings_row")
	public static List<WebElement> rlSettingsRow;

	@iOSFindBy(id = "My Shaadi")
	@AndroidFindBy(id = "")
	public static WebElement btnMyShaadiTab;

//	@iOSFindBy(id = "Account type - Free")
	@iOSFindBy(id = "labelAccountType")
	@AndroidFindBy(id = "")
	public static WebElement usrAcntType;

	@iOSFindBy(id = "labelExpiry")
	@AndroidFindBy(id = " ")
	public static WebElement usr_Profile_Expiry;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Account type -')]")
	@AndroidFindBy(id = "")
	public static WebElement genericAcntType;

	@iOSFindBy(id = "labelExpiry")
	@AndroidFindBy(id = "")
	public static WebElement txtExpiryDate;

	@iOSFindBy(id = "RENEW PREMIUM")
	@AndroidFindBy(id = "")
	public static WebElement btnRewnPremium;

	@iOSFindBy(id = "Upgrade Now")
	@AndroidFindBy(id = "")
	public static WebElement btnUpgrdNw;

	@iOSFindBy(id = "Edit Profile")
	@AndroidFindBy(id = "")
	public static WebElement btnEdtProfile;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'SH')]")
	@AndroidFindBy(id = "")
	public static WebElement txtPrfId;

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"My Profile\"]")
	@AndroidFindBy(id = "")
	public static WebElement txtMyProfile;

	@iOSFindBy(name = "Basic Info")
	@AndroidFindBy(id = "")
	public static WebElement txtBasicInfo;

	@iOSFindBy(id = "trustBadgeGray")
	@AndroidFindBy(id = "")
	public static WebElement btnTrustBadge;

	@iOSFindBy(id = "labelCompletnessTitle_2")
	@AndroidFindBy(id = "")
	public static WebElement verifyProfile;

	@iOSFindBy(id = "This badge will be added to your profile")
	@AndroidFindBy(id = "")
	public static WebElement navVerifyProfile;

	@iOSFindBy(name = "Verify Mobile Number")
	public static WebElement navVerifyProfile_Number;

	@iOSFindBy(id = "Your Matches are unable to reach you")
	@AndroidFindBy(id = "")
	public static WebElement verifyCnct;

	@iOSFindBy(name = "Verify Mobile Number")
	@AndroidFindBy(id = "")
	public static WebElement navVerifyNumber;

	@iOSFindBy(id = "Request PIN")
	@AndroidFindBy(id = "")
	public static WebElement btnReqstPin;

	@iOSFindBy(id = "Verify")
	@AndroidFindBy(id = "")
	public static WebElement btnVerify;

	@iOSFindBy(id = "Upload your photos")
	@AndroidFindBy(id = "")
	public static WebElement txtUploadPics;
	
	@iOSFindBy(id = "buttoncamera")
	@AndroidFindBy(id = "")
	public static WebElement btnUseCamera;

	@iOSFindBy(name = "Click Photo")
	@AndroidFindBy(id = "")
	public static WebElement txtClickPic;

	@iOSFindBy(id = "OK")
	@AndroidFindBy(id = "")
	public static WebElement btnOk;

	@iOSFindBy(id = "FrontBackFacingCameraChooser")
	@AndroidFindBy(id = "")
	public static WebElement btnFrntCamera;

	@iOSFindBy(id = "PhotoCapture")
	@AndroidFindBy(id = "")
	public static WebElement btnPhtCapture;

	@iOSFindBy(id = "Use Photo")
	@AndroidFindBy(id = "Use Photo")
	public static WebElement btnUsePhoto;

	@iOSFindBy(id = "Uploading 1 of 1")
	@AndroidFindBy(id = "")
	public static WebElement txtUploadProg;

	@iOSFindBy(id = "UPLOAD IN BACKGROUND")
	@AndroidFindBy(id = "")
	public static WebElement txtUploadProgrs;

	@iOSFindBy(id = "Add your Astro details")
	@AndroidFindBy(id = "")
	public static WebElement txtAstroDtls;

	@iOSFindBy(id = "Horoscope Details")
	@AndroidFindBy(id = "")
	public static WebElement txtHoroScope;

	@iOSFindBy(name = "lblRightText.label")
	@AndroidFindBy(id = "")
	public static List<WebElement> btnSelectOption;

	@iOSFindBy(className = "XCUIElementTypeTextField")
	@AndroidFindBy(id = "")
	public static WebElement searchFieldAstro;
	
	@iOSFindBy(name="Cancel")
	public static WebElement btnCancelAstro;

	@iOSFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "")
	public static WebElement searchFieldAstro_option;
	
	@iOSFindBy(id = "btnSave.label")
	@AndroidFindBy(id = "")
	public static WebElement btnSaveAstro;

	@iOSFindBy(id = "Your Horoscope is being generated.")
	@AndroidFindBy(id = "")
	public static WebElement txtAstroConfirmation;

	@iOSFindBy(id = "View Horoscope")
	@AndroidFindBy(id = "")
	public static WebElement btnViewHoroScp;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Premium Matches')]")
	@AndroidFindBy(id = "")
	public static WebElement txtPremiumMatches;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Connect Now\"])[2]")
	@AndroidFindBy(id = "")
	public static WebElement btnConnectNow_Prememium;

	@iOSFindBy(id = "buttoncallToAction_discovery_premium_1")
	public static WebElement bntConnectNow_Premium;

	@iOSFindBy(id = "buttoncallToAction_recently-joined_0")
	@AndroidFindBy(id = "")
	public static WebElement btnConnectNow_RecentlyJoined;

	@iOSFindBy(id = "buttoncallToAction_discovery_recent_visitors_0")
	@AndroidFindBy(id = "")
	public static WebElement btnConnectNow_RecentlyVisitors;

	@iOSFindBy(accessibility = "lblSendEmail.label")
	@AndroidFindBy(id = "com.shaadi.android:id/textView33")
	public static WebElement labelSendEmail;

	@iOSFindBy(accessibility = "textviewMessage")
	@AndroidFindBy(id = "com.shaadi.android:id/edtMessage")
	public static WebElement textviewMessage;

	@iOSFindBy(accessibility = "buttonSend")
	@AndroidFindBy(id = "android:id/button1")
	public static WebElement btnSend;

	@iOSFindBy(id = "Invitation Sent")
	@AndroidFindBy(id = "")
	public static WebElement btnInvitationSend;

	@iOSFindBy(id = "buttonSeeAll_discovery_premium")
	@AndroidFindBy(id = "")
	public static WebElement btnSeeAll_premium;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"See All\"])[2]")
	@AndroidFindBy(id = "")
	public static WebElement btnSeeAll_RecentlyJoined;

	@iOSFindBy(name = "Recently upgraded Premium members")
	@AndroidFindBy(id = "")
	public static WebElement txtPremiumMatchesTab;

	@iOSFindBy(id = "Members who joined recently")
	@AndroidFindBy(id = "")
	public static WebElement txtRecentlyJoinedTab;

	@iOSFindBy(id = "Members who visited your Profile")
	@AndroidFindBy(id = "")
	public static WebElement txtRecentVisitorsTab;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name , 'Recently Joined')]")
	@AndroidFindBy(id = "")
	public static WebElement txtRecentlyJoined;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[contains(@name , 'Visitors')]")
	@AndroidFindBy(id = "")
	public static WebElement txtRecentVisitors;

	@iOSFindBy(id = "buttonSeeAll_recently-joined")
	@AndroidFindBy(id = "")
	public static WebElement btnSeeAllNewlyJoined;

	@iOSFindBy(id = "buttonSeeAll_discovery_recent_visitors")
	@AndroidFindBy(id = "")
	public static WebElement btnSeeAllRecentVisitors;

	@iOSFindBy(id = "Options & Settings")
	@AndroidFindBy(id = "")
	public static WebElement txtOptionsSettings;

	@iOSFindBy(id = "Partner Preferences")
	@AndroidFindBy(id = "")
	public static WebElement txtPartnerPreferences;

	@iOSFindBy(id = "Contact Filters")
	@AndroidFindBy(id = "")
	public static WebElement txtContactsFilter;

	@iOSFindBy(name = "Contact Filters")
	@AndroidFindBy(id = "")
	public static WebElement txtMoreFilterCriteria;

	@iOSFindBy(id = "Account Settings")
	@AndroidFindBy(id = "")
	public static WebElement txtAcntSettings;

	@iOSFindBy(id = "Push Notifications and Sounds")
	@AndroidFindBy(id = "")
	public static WebElement btnPushNotification;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"New Invitations\"]")
	@AndroidFindBy(id = "")
	public static WebElement swtchNewInvitations;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Shortlists\"]")
	@AndroidFindBy(id = "")
	public static WebElement swtchShortlists;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Recommendations\"]")
	@AndroidFindBy(id = "")
	public static WebElement swtchRecommendations;

	@iOSFindBy(id = "id_cell_email")
	@AndroidFindBy(id = "")
	public static WebElement edtEmailField;

	@iOSFindBy(id = "textedit_newemail")
	@AndroidFindBy(id = "")
	public static WebElement newEmailIdField;

	@iOSFindBy(id = "textfield_password")
	@AndroidFindBy(id = "")
	public static WebElement newPasswordField;

	@iOSFindBy(id = "button_cancel")
	@AndroidFindBy(id = "")
	public static WebElement btnCancelEdit;

	@iOSFindBy(name = "Notifications")
	@AndroidFindBy(id = "")
	public static WebElement txtNotifications;

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Notifications\"]")
	@AndroidFindBy(id = "")
	public static WebElement navNotificationsTab;

	@iOSFindBy(id = "Help & Support")
	@AndroidFindBy(id = "")
	public static WebElement txtHelp;

	@iOSFindBy(name = "labelTitle")
	@AndroidFindBy(id = "")
	public static WebElement txtPartnerPref;

	@iOSFindBy(id = "More Filter criteria")
	@AndroidFindBy(id = "")
	public static WebElement btnFilterCriteria;

	@iOSFindBy(id = "btnSave.label")
	@AndroidFindBy(id = "")
	public static WebElement btnSaveContcFilter;

	@iOSFindBy(id = "btnLogin")
	@AndroidFindBy(id = "")
	public static WebElement btnLogOut;

	@iOSFindBy(id = "Terms & Conditions")
	@AndroidFindBy(id = "")
	public static WebElement txtTermsConditions;

	@iOSFindBy(name = "Done")
	@AndroidFindBy(id = "")
	public static WebElement btnDone;

	@iOSFindBy(id = "arrow left white")
	public static WebElement btn_back;

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\\\"Settings\\\"]/XCUIElementTypeButton")
	public static WebElement btn_back_setting;

	@iOSFindBy(id = "Shaadi Chat")
	public static WebElement btn_ShaadiChat;

}
