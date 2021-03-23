package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InboxPageObjects extends BasePageActions {

	
	
	@AndroidFindBy(id = "com.shaadi.android:id/img_exit")
	public WebElement receivedQRCloseButton;
	
	@AndroidFindBy(id = "com.shaadi.android:id/button3")
	public WebElement accept_connect_btn_new;
	
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_other_messages")
	public WebElement txt_message_dropdownactions;
	
	

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_btnViewPlans")
	public WebElement cardBannerPersonalized_btnViewPlans;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_upgrade_title")
	public WebElement upgradePageHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/btnRemind")
	public WebElement btn_Accept;
	
	@AndroidFindBy(id = "com.shaadi.android:id/btnRemind")
	public WebElement btn_Remind;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_changed_your_mind")
	public WebElement changedYourMind;

	@AndroidFindBy(id = "com.shaadi.android:id/btnCancel")
	public WebElement btn_Decline;
	
	
	@AndroidFindBy(id = "com.shaadi.android:id/btnCancel")
	public WebElement btn_Cancel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reason for Reporting']")
	@iOSFindBy(name = "Reason for reporting")
	public WebElement reasonForReporting;

	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Report')]")
	@iOSFindBy(id="Report Profile/Photo")
	public WebElement ReportProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtIgnored")
	public WebElement IgnoredMemText;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(name = "labelBlocked Member")
	public WebElement BlockedMemberTxt;

	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_other_messages")
	public WebElement blockedText_new;
	
	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelDeclined Member\"])[1]")
	public WebElement DeclineMemberTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelLikeThisProfileForConnectView\"])[1]")
	public WebElement CancelMemberTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelCancelled Member\"])[1]")
	public WebElement CancelMemberTxt_Premium;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	@iOSFindBy(id = "profile options down arrow")
	public WebElement DropDownIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/new_message_state")
	@iOSFindBy(name = "labelProfileMessage")
	public WebElement messageAcceptedProfileCard;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutRefine_txtTitle")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Accepted Invitations')]")
	public WebElement acceptedTabSubTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutRefine_txtTitle")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,	'Sent Invitations')]")
	public WebElement sentTabSubTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Request Sent']")
	public WebElement btn_Request_Sent_RequestTab;

	@AndroidFindBy(id = "com.shaadi.android:id/btnDelete")
	public WebElement btn_Delete_ReceivedTab;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_upgrade_continue")
	public WebElement btn_upgradeNow_ReceivedTab;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Decline']")
	public WebElement btn_Decline_ReceivedTab;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Connect Now']")
	public WebElement btn_connectNow_DeleteTab;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Accept']")
	public WebElement btn_Accept_DeleteTab;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Decline']")
	public WebElement btn_Decline_DeleteTab;

	@AndroidFindBy(id = "com.shaadi.android:id/btnResendOtp")
	public WebElement requestPinButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnVerify")
	public WebElement verifyOTPButton;

	@AndroidFindBy(id = "com.shaadi.android:id/tvEditMobileNumber")
	public WebElement editMobileNumberButton;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMobileNumber")
	public WebElement mobileNumber;

	@AndroidFindBy(id = "com.shaadi.android:id/edtOtp")
	public WebElement enterOTPTextBox;

	@AndroidFindBy(id = "com.shaadi.android:id/tvTitle")
	public WebElement verfiyContactDetailsText;

	// @AndroidFindBy(id = "com.shaadi.android:id/tv_other_messages")
	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement blockedMemberText;

	@AndroidFindBy(id = "com.shaadi.android:id/button6")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonDualCTARight_0\"])[1]")
	public WebElement connectNowButtonListingAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement connectNowTextAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_send_message")
	public WebElement sendMessageButtonAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/et_send_sms")
	public WebElement sendMessageOnConnctNowAndroid;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My Matches\")")
	public WebElement myMatchesTab;

	@AndroidFindBy(id = "com.shaadi.android:id/itemAcceptedRequestCard_txtTitle")
	public WebElement acceptedRequestTextAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	@iOSFindBy(id = "buttonMoveToNextProfile")
	public WebElement SwipeNext;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_prev")
	@iOSFindBy(name = "buttonMoveToPreviousProfile")
	public WebElement SwipePrev;

	@AndroidFindBy(id = "android:id/title")
	public List<WebElement> DropdownText;
	
	@iOSFindBy(id="Decline")
	@AndroidFindBy(xpath = "//*[@text = 'Decline']")
	public WebElement dd_DeclineProfile;
	
	@AndroidFindBy(xpath = "//*[contains(@text , 'Remind')]")
	public WebElement dd_Remind;
	
	@iOSFindBy(id="Cancel Request")
	@AndroidFindBy(xpath = "//*[@text = 'Cancel request']")
	public WebElement dd_CancelRequest;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	public WebElement btn_dd_Cancel;

	@FindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement premiumMemberContactedcaptionAndroid;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement cancelButton;

	@FindBy(id = "com.shaadi.android:id/lblName")
	public WebElement ignornedMemberProfileName;

	@FindBy(id = "com.shaadi.android:id/lblActionDoneText")
	public WebElement ignornedMember;

	@FindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'labelDisplayName_')]")
	public WebElement profileName;

	@AndroidFindBy(className = "androidx.appcompat.app.ActionBar$b")
	public List<WebElement> topNavBar;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button0")
	public WebElement btnpremiumprofilebottomdecline;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button2")
	public WebElement btnpremiumprofilebottomaccept;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_profile_pic")
	public WebElement OpenProfilePage;

	// block

	@FindBy(id = "com.shaadi.android:id/tv_cta_header")
	public WebElement txtBlockProfile;

	@FindBy(id = "com.shaadi.android:id/tv_no_invitations")
	public WebElement receivedEmptyCaseText;

	@FindBy(id = "com.shaadi.android:id/tv_click_matches")
	public WebElement receivedEmptyCaseLink;

	@FindBy(id = "com.shaadi.android:id/btn_plan")
	public WebElement btnupgradelayerprofile;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button0")
	public WebElement btnprofileBottomcta1;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement btnpremiumwritemessage;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button1")
	public WebElement btnprofileBottomcta2;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button2")
	public WebElement btnprofileBottomcta3;

	@FindBy(id = "com.shaadi.android:id/design_bottom_sheet")
	public WebElement AppRatingLayer;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtButtonHeading")
	public WebElement AcceptStopPageText1;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtUpgradeMessage")
	public WebElement AcceptStopPageText2;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnViewPlans")
	public WebElement AcceptStopPageUpgrade;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatct_txtHeading")
	public WebElement AcceptStopPageHeadingText;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtSubHeadingMsg")
	public WebElement AcceptStopPageSubHeadingText;

	@iOSFindBy(name = "btnClose.label")
	@AndroidFindBy(id = "com.shaadi.android:id/inbox_card_upgrade_close")
	public WebElement upgradeacceptbannerclose;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnViewPlans")
	public WebElement upgradeAcceptStopPage;

	@iOSFindBy(name = "buttonCenterAction")
	public WebElement btnConnectNowiOS;

	@iOSFindBy(name = "lblSendEmail.label")
	public WebElement lblSendEmailiOS;

	@iOSFindBy(name = "textviewMessage")
	public WebElement txtEnterMsgiOS;

	@iOSFindBy(name = "buttonDefaultMessage")
	public WebElement cbSetDefaultMSgiOS;

	@iOSFindBy(name = "labelDefaultMessage")
	public WebElement lblSetDefaultMSgiOS;

	@iOSFindBy(name = "labelTitle")
	public WebElement lblTitleiOS;

	@iOSFindBy(name = "buttonSend")
	public WebElement btnSendMsgiOS;

	@iOSFindBy(name = "labelTitle")
	public WebElement txtDeletedHeader;

	@iOSFindBy(name = "labelCenter")
	public WebElement txtConnect;

	@iOSFindBy(name = "btnHyperLinked.label")
	public WebElement accepLinkiOS;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"buttonDecline\"][1]")
	public MobileElement BtnDeclineiOSProfilepage;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"buttonCancel\"][1]")
	public MobileElement BtnCanceliOSProfilepage;

	@iOSFindBy(name = "buttonClose")
	public WebElement ClosePaymentPopUp;

	@FindBy(className = "android.widget.TextView")
	public List<WebElement> acceptedtabcount;

	@AndroidFindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement WriteMsgHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/textView33")
	public WebElement WriteMsgHeaderAndroid;

	@FindBy(id = "com.shaadi.android:id/cb_save_draft")
	public WebElement cbSaveDraft;

	@FindBy(id = "com.shaadi.android:id/chkDefault")
	public WebElement cbSaveDraftAndroid;

	@FindBy(className = "android.widget.RelativeLayout")
	public List<WebElement> layout;

	@AndroidFindBy(id = "com.shaadi.android:id/actItsAMatchPremium_edtMessage")
	public WebElement sendMessageTextAreaAccept;

	@FindBy(id = "com.shaadi.android:id/activityItsAMatctPremium_txtHeading")
	public WebElement sendMessageHeaderAccept;

	@FindBy(id = " com.shaadi.android:id/customPanel")
	public WebElement frameLayout;

	@FindBy(className = "android.widget.RelativeLayout")
	public List<WebElement> featuredcardlayout;

	@FindBy(className = "android.widget.LinearLayout")
	public List<WebElement> profilelayout;

	@FindBy(id = "com.shaadi.android:id/composeemail")
	public WebElement txtDefaultMsg;

	@FindBy(id = "com.shaadi.android:id/noresultheading")
	@iOSFindBy(id = "labelTitle")
	public WebElement NoInvitationstext;

	@FindBy(id = "com.shaadi.android:id/noresultmsg")
	@iOSFindBy(id = "labelSubTitle")
	public WebElement Noresponseawaitedtext;

	@FindBy(id = "com.shaadi.android:id/viewrecentmatches")
	@iOSFindBy(id = "Go to Inbox")
	public WebElement Gotoinboxlink;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	@iOSFindBy(name = "labelLeft")
	public WebElement viewcontactbtn;

	@iOSFindBy(name = "buttonRightAction")
	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement btn_ViewContact;

	@iOSFindBy(name = "labelRight")
	public WebElement ViewContactTextiOS;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement writemessagebtn;

	@iOSFindBy(name = "labelRight")
	public WebElement WriteMessageTextiOS;

	@iOSFindBy(name = "buttonRightAction")
	public WebElement BtnWriteMsgiOS;

	@iOSFindBy(name = "labelProfileName")
	public WebElement OpenProfilePageiOS;

	@iOSFindBy(name = "btnBackBarButtonItem")
	public WebElement btnBackBarButton;

	@iOSFindBy(name = "YES")
	public WebElement YesBtn;

	@iOSFindBy(name = "NO")
	public WebElement NoBtn;

	@iOSFindBy(name = "lblTitle.label")
	public WebElement MobileText;

	@iOSFindBy(name = "lblValue.label")
	public WebElement MobileValue;

	@iOSFindBy(name = "OK")
	public WebElement OKBtn;

	@iOSFindBy(name = "buttonPhotoRequest")
	public WebElement ReqAphoto;

	@iOSFindBy(name = "buttonViewPlan")
	@FindBy(id = "com.shaadi.android:id/btn_plan")
	public WebElement verifyupgradenowpage;

	@FindBy(id = "com.shaadi.android:id/msgtext")
	public WebElement ClicktoWriteMsg;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_iv_avatar")
	@iOSFindBy(id = "labelProfileName")
	public WebElement Openprofilepage;

	@iOSFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
	public WebElement ClickonNamenOpn;

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	public WebElement ClickCTA1;

	@FindBy(id = "com.shaadi.android:id/tv_button02")
	public List<WebElement> ClickCTA2;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public List<WebElement> ClickCTA3;

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	public WebElement ConnectNowlink;

	@FindBy(id = "com.shaadi.android:id/tv_cta_contact")
	public WebElement Texttocontacthimherdirectly;

	@FindBy(id = "com.shaadi.android:id/tv_cta_upgrade")
	public WebElement UpgradeLink;

	@FindBy(id = "com.shaadi.android:id/btn_view_contact")
	public WebElement viewcontactonprofilepage;

	@FindBy(id = "com.shaadi.android:id/btn_write_message")
	public WebElement writemsgonprofilepage;

	@FindBy(id = "com.shaadi.android:id/imgButtonCancel")
	public WebElement closeviewplans;

	@FindBy(id = "com.shaadi.android:id/btn_plan")
	public WebElement clickviewplansbtnonprofilepage;

	@FindBy(id = "com.shaadi.android:id/menu_profile_refine_options")
	public WebElement blockarrow;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement DeleteCTA;

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	public WebElement AcceptInvitationLink;

	@FindBy(id = "android.widget.ImageButton")
	public List<WebElement> backarrow;

	@FindBy(className = "android.widget.ImageButton")
	public WebElement backarrowButton;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	public WebElement AcceptBannerdissmiss;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatct_txtHeading")
	public WebElement AcceptBannerdissmissText;

	@FindBy(id = "com.shaadi.android:id/img_arrow")
	public WebElement imgArrow;

	@FindBy(id = "com.shaadi.android:id/img_profile_selection")
	public WebElement imgArrowAndroid;

	@FindBy(id = "com.shaadi.android:id/title")
	public WebElement txtTitle;

	@FindBy(className = "android.widget.LinearLayout")
	public List<WebElement> clkBlock;

	@FindBy(className = "android.widget.LinearLayout")
	public List<WebElement> clickDeclineAndroid;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement txtBlockAlert;

	@FindBy(id = "com.shaadi.android:id/textView4")
	public WebElement txtBlockInfo;

	@FindBy(id = "com.shaadi.android:id/tv_report_misuse")
	public WebElement txtReportMisuse;

	@FindBy(id = "android:id/button1")
	public WebElement btnBlockOK;

	@iOSFindBy(name = "labelProfileName")
	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	public WebElement VerifyUserName;

	@iOSFindBy(name = "labelProfileDetails1")
	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_physical_caste_detail")
	public WebElement Ageheightinfo;

	@iOSFindBy(name = "labelProfileDetails2")
	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_location_education")
	public WebElement Educationinfo;

	@iOSFindBy(name = "labelProfileDetails3")
	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_profession_earning")
	public WebElement ProfessionInfo;

	@iOSFindBy(name = "labelDate")
	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_active_duration")
	public WebElement TimeInfo;

	@iOSFindBy(name = "buttonCenterAction")
	public WebElement DeleteCTABtn;

	@iOSFindBy(name = "labelCenterAction")
	public WebElement DeleteCTAText;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button0")
	public WebElement BottomDecline;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button0")
	public WebElement BottomCancel;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_iv_avatar")
	public WebElement gotoProfilepage;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button1")
	public WebElement BottomViewContactcase;

	@FindBy(id = " com.shaadi.android:id/tv_profile_button2")
	public WebElement BottomAccept;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button2")
	public WebElement BottomWriteMsginCancelcase;

	@FindBy(id = "com.shaadi.android:id/tv_profile_button2")
	public WebElement BottomWriteMsginDeclinecase;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_two_party_pay_message")
	public WebElement LockedMsg2wayListing;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_upgrade_now")
	public WebElement UpgradeNow2wayListing;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_facebook")
	public WebElement FBlink2wayListing;

	@FindBy(id = "com.shaadi.android:id/img_two_way")
	public WebElement Open2wayProfilepage;

	@FindBy(id = "com.shaadi.android:id/profile_detail_sent")
	public WebElement LockedMsg2wayProfilepage;

	@FindBy(id = "com.shaadi.android:id/profile_detail_sent_upgrade_panel")
	public WebElement UpgradeNowORfbon2wayProfilepage;

	// Premium case objects

	@FindBy(id = "android:id/message")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Would you like to view contact details')]")
	public WebElement ViewingNumAlertTxt;

	@FindBy(id = "android:id/message")
	@iOSFindBy(id = "Visit again after 24 hours to send a Reminder.")
	public WebElement txt_RemindOnSentTab;

	@FindBy(id = "android:id/button1")
	@iOSFindBy(id = "YES")
	public WebElement ViewNumYesBtn;

	@iOSFindBy(id = "NO")
	public WebElement btn_ViewNum_No;

	@FindBy(id = "com.shaadi.android:id/txt_header")
	public WebElement ViewContactHeaderTxt;

	@FindBy(id = "com.shaadi.android:id/txt_mobile_label")
	@iOSFindBy(id = "Mobile")
	public WebElement MobileHeaderTxt;

	@FindBy(id = "com.shaadi.android:id/mobileNo")
	public WebElement MobileNumberVerification;

	@FindBy(id = "com.shaadi.android:id/txt_mobile_sms")
	public WebElement SmsIcon;

	@FindBy(id = "com.shaadi.android:id/edt_message")
	public WebElement SMStext;

	@FindBy(id = "android:id/button1")
	public WebElement OkBtn1;

	@FindBy(id = "com.shaadi.android:id/edt_message")
	public WebElement Actualsms;

	@FindBy(id = "com.shaadi.android:id/txt_success_msg")
	public WebElement SmsSentSuccessfully; // Your SMS has been sent
											// successfully.

	@FindBy(id = "android:id/button1")
	public WebElement OkSMS;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement RequestSentTitle;

	@FindBy(id = "android:id/message")
	public WebElement RequestSentTxt;

	@FindBy(id = "android:id/button2")
	@iOSFindBy(id = "OK")
	public WebElement OkBtn2;

	@FindBy(id = "com.shaadi.android:id/txt_mobile_call")
	public WebElement CallIcon;

	@FindBy(id = "android:id/message")
	public WebElement ActualContactNumber;

	@FindBy(id = "android:id/button1")
	public WebElement CallBtn;

	@FindBy(id = "android:id/message")
	public WebElement NumNtVerifiedTxt;

	@FindBy(id = "com.shaadi.android:id/txt_email_header")
	public WebElement EmailHeaderTxt;

	@FindBy(id = "com.shaadi.android:id/email")
	public WebElement UserEmailId;

	@FindBy(id = "com.shaadi.android:id/txt_name_header")
	public WebElement ContactPersonHeaderTxt;

	@FindBy(id = "com.shaadi.android:id/contactName")
	public WebElement ContactPersonName;

	@FindBy(id = "com.shaadi.android:id/txt_count_header")
	public WebElement ContactsAvailableHdrTxt;

	@FindBy(id = "com.shaadi.android:id/txt_count")
	public WebElement ActualContactsAvailable;

	@FindBy(id = "com.shaadi.android:id/txt_ok")
	public WebElement OkBtnOnViewCOntact;

	@FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnPrev")
	@iOSFindBy(id = "buttonLeftBottomArrow")
	public WebElement btnPrevious;

	@FindBy(id = "com.shaadi.android:id/btn_prev")
	public WebElement btnPreviousInboxAndroid;

	@FindBy(id = "com.shaadi.android:id/msgtext")
	public WebElement ClickWriteMsg;

	@FindBy(id = "com.shaadi.android:id/send_btn")
	public WebElement SendMsgBtn1;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement PremiumViewContact;

	@FindBy(id = "com.shaadi.android:id/tv_button02")
	@iOSFindBy(id = "labelMiddleCTA_0")
	public WebElement PremiumViewContactonProfile;

	@FindBy(id = "com.shaadi.android:id/tv_button02")
	@iOSFindBy(id = "buttonMiddleCTA_0")
	public WebElement btn_PremiumViewContactonProfile;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement PremiumWriteMsg;

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	@iOSFindBy(id = "labelLeftCTA_0")
	public WebElement txt_PremiumCancel; // Cancel

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	@iOSFindBy(id = "buttonLeftCTA_0")
	public WebElement btn_PremiumCancel;

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	@iOSFindBy(id = "labelLeftCTA_0")
	public WebElement txt_PremiumDecline; // Decline text

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	@iOSFindBy(id = "buttonLeftCTA_0")
	public WebElement btn_PremiumDecline; // Decline button

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	@iOSFindBy(id = "labelSingleCTARight_0")
	public WebElement txt_PremiumConnectNowLInk;// Connect Now

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	@iOSFindBy(id = "buttonSingleCTARight_0")
	public WebElement btn_PremiumConnectNowLInk;

	@FindBy(id = "android:id/button1")
	public WebElement PremiumSendPremiumMSg;// SEND

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	@iOSFindBy(id = "labelSingleCTARight_0")
	public WebElement txt_PremiumAcceptLink;// accept text after decline

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	@iOSFindBy(id = "buttonSingleCTARight_0")
	public WebElement btn_PremiumAcceptLink;// accept button after decline

	@FindBy(id = "com.shaadi.android:id/composeemail")
	public WebElement PremiumMsgText;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement DailyLimitReached;

	@FindBy(id = "android:id/message")
	public WebElement DailyLimitReachediNFO;

	@FindBy(id = "android:id/button2")
	public WebElement DailyLimitReachedOkBtn;

	@FindBy(id = "android:id/button2")
	public WebElement CancelBtn;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	@iOSFindBy(name = "Number not Verified")
	public WebElement NumNtVerifiedHeader; // Number not Verified

	@FindBy(id = "android:id/message")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'has not verified')]")
	public WebElement NumNtVerifiedText;

	@FindBy(id = "android:id/button1")
	@iOSFindBy(id = "Send Request")
	public WebElement SendRequestTxt; // Send Request

	@iOSFindBy(name = "Request Sent")
	public MobileElement txt_RequestSend;

	@FindBy(id = "android:id/button2")
	@iOSFindBy(id = "Cancel")
	public WebElement CancelTxt; // Cancel

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	@iOSFindBy(name = "Request Sent")
	public WebElement RequestSentHdr; // Request Sent

	@FindBy(id = "android:id/message")
	@iOSFindBy(id = "Your request for verifying contact number has been sent to the member.")
	public WebElement RequestSentText;

	@FindBy(id = "android:id/button2")
	@iOSFindBy(id = "OK")
	public WebElement OKbtnonREqSent; // OK

	// F2F canned msg in inbox listing

	@AndroidFindBy(id = "com.shaadi.android:id/tv_premium_message")
	public WebElement CannedMsgInListingAndroid;

	@iOSFindBy(name = "labelProfileMessage")
	public WebElement CannedMsgInListingios;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_premium_message")
	public WebElement CannedMsgInListing;

	@FindBy(id = "com.shaadi.android:id/id_complete_profile_she_email_header")
	public WebElement EmailHeader;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_premium_message")
	public WebElement CannedOnProfilePage;

	@iOSFindBy(accessibility = "tableviewViewDetails")
	public WebElement cellViewContact;

	@iOSFindBy(accessibility = "labelHeaderTitle")
	public WebElement HeaderViewContact;

	@iOSFindBy(accessibility = "buttonSMS")
	public WebElement buttonSMS;

	@iOSFindBy(accessibility = "lblSmsHeaderText.label")
	public WebElement SMSheader;

	@iOSFindBy(accessibility = "TxtViewSendMsg.label")
	public WebElement SMSTxt;

	@iOSFindBy(accessibility = "btnSmsSend.label")
	public WebElement SMSsendBtn;

	@iOSFindBy(accessibility = "OK")
	public WebElement OKbtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_header")
	public WebElement BottomSheetText;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_header")
	public WebElement bottomSheetText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_mobile_no")
	public WebElement MaskedNum;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_mobile_no")
	public WebElement maskedNum;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_email")
	public WebElement MaskedEmail;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_email_id")
	public WebElement maskedEmail;

	@AndroidFindBy(id = "com.shaadi.android:id/cpb_view_plan")
	public WebElement ViewPlansOnBottomSheet;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_plan")
	public WebElement viewPlansOnBottomSheet;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_cancel")
	public WebElement CloseIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/imgButtonCancel")
	public WebElement closeIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage")
	public WebElement ShaadiChatCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement shaadiChatCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaViewContact")
	public WebElement CallCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement viewContactButton;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_header")
	public WebElement DeclinedCanceledMember;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement declinedMemberTextAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/title")
	public WebElement DeclinedCanceledButton;

	@FindBy(id = "com.shaadi.android:id/inbox_card_upgrade_close")
	@iOSFindBy(id = "imgClose.label")
	public WebElement CloseHunkyDory1;

	@FindBy(id = "com.shaadi.android:id/inbox_card_upgrade_close")
	@iOSFindBy(id = "imgClose.label")
	public WebElement closehunkydoryi;

	@iOSFindBy(id = "buttonSubNav1")
	@AndroidFindBy(id = "Accepted")
	public WebElement AcceptedTab1;

	@FindBy(id = "com.shaadi.android:id/iv_exit_stack")
	public WebElement closeAnnimation;

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	@iOSFindBy(id = "Sent Items")
	public WebElement btninboxSent;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'labelProfileName')]")
	public WebElement profileNameOnSentItemsListing;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	public WebElement closeAcceptStopPagebtn;

	@FindBy(id = "com.shaadi.android:id/tv_count_heading")
	public WebElement QuickResponseHeader;

	@FindBy(id = "com.shaadi.android:id/rlInvite")
	@iOSFindBy(id = "Inbox")
	public WebElement inbox;

	@FindBy(id = "com.shaadi.android:id/itemBadgeWithLabel_txtCount")
	public WebElement viewAllCountbtn;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_message_info_layer")
	public WebElement requestCardText;

	@FindBy(id = "com.shaadi.android:id/itemBadgeWithlabel_txtLabel")
	public WebElement viewAllTextbtn;

	@FindBy(className = "android.support.v7.widget.RecyclerView")
	public List<WebElement> Viewlayout;

	@FindBy(className = "android.view.View")
	public List<WebElement> TextViewlayout;

	@FindBy(id = "com.shaadi.android:id/tv_name")
	public WebElement profilePagedName;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
	public WebElement AcceptedRequestCard;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement AcceptedRequestDeletebtn;

	@FindBy(id = "com.shaadi.android:id/tv_pht_request")
	public WebElement AcceptedRequestRequestbtn;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='labelProfileName']")
	public WebElement profileCardName;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_iv_avatar")
	public WebElement imgClick;

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	public List<WebElement> actionBarItemSearch;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_physical_caste_detail")
	public WebElement tvCasteDetail;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_location_education")
	@iOSFindBy(name = "labelProfileDetails2")
	public WebElement tvEducationLocDetails;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_message_info_layer")
	public WebElement tvInfo;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_active_duration")
	public WebElement tvDate;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_profession_earning")
	public WebElement tvProfession;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement SelfPhotoMissingtxt;

	@FindBy(id = "android:id/message")
	public WebElement PhotoMissinginfo;

	@FindBy(id = "android:id/button1")
	public WebElement Addphotobtn;

	@FindBy(id = "android:id/button2")
	public WebElement CancelbtnPhotorequest;

	@FindBy(id = "com.shaadi.android:id/tv_cta_connect_now")
	public WebElement ProfileConnectbtn;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement btnprofilepremiumaccept;

	@FindBy(id = "android:id/button1")
	public WebElement SendInterestBtn;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement btnAcceptProfile;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Requests\")")
	public WebElement RequestTab;

	@FindBy(id = "com.shaadi.android:id/bt_got_it")
	public WebElement btnGotIt;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	@iOSFindBy(name = "buttonAccept")
	public WebElement btnAccept;

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	public WebElement btnDeclinetProfile;

	@iOSFindBy(id = "buttonLeftAction")
	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement btnDecline;

	@AndroidFindBy(id = "com.shaadi.android:id/textView7")
	public WebElement txtLayerheader;

	@AndroidFindBy(id = "com.shaadi.android:id/btnNotSatisfied")
	public WebElement btnnotsatisfiled;

	@AndroidFindBy(id = "com.shaadi.android:id/btnSatisfied")
	public WebElement btnsatisfield;

	@AndroidFindBy(id = "com.shaadi.android:id/txtTop")
	public WebElement textnotyethader;

	@AndroidFindBy(id = " com.shaadi.android:id/txtTitle")
	public WebElement texttitle;

	@AndroidFindBy(id = "com.shaadi.android:id/edtComment")
	public WebElement textcommentbox;

	@AndroidFindBy(id = "com.shaadi.android:id/btnSubmit")
	public WebElement btnsubmit;

	@FindBy(id = "com.shaadi.android:id/btnback")
	public WebElement back;

	@FindBy(id = "com.shaadi.android:id/txtTop")
	public WebElement txtsatisfiedheader;

	@FindBy(id = "com.shaadi.android:id/txtTitle")
	public WebElement txtsatisfiedtitle;

	@FindBy(id = "com.shaadi.android:id/btnRateNow")
	public WebElement btnratenow;

	@FindBy(id = "com.android.vending:id/title_title")
	public WebElement playstoretitle;

	@iOSFindBy(name = "labelTitle")
	@AndroidFindBy(id = "com.shaadi.android:id/noresultheading")
	public WebElement emptyheading;

	@iOSFindBy(name = "labelSubTitle")
	@AndroidFindBy(id = "com.shaadi.android:id/noresultmsg")
	public WebElement emptytxt;

	@iOSFindBy(name = "buttonLeftAction")
	@AndroidFindBy(id = "com.shaadi.android:id/viewrecentmatches")
	public WebElement emptylink;

	@FindBy(id = "com.shaadi.android:id/txtBottomStr")
	public WebElement receivedUpgradecardText;

	@FindBy(id = "com.shaadi.android:id/inbox_AddFreeUpgrader")
	public WebElement btnreceivedUpgradecard;

	@FindBy(id = "com.shaadi.android:id/inbox_card_upgrade_close")
	public WebElement reeceivedUpgradecardclose;

	@FindBy(className = "android.widget.LinearLayout")
	public List<WebElement> upgradelayout;

	@FindBy(id = "com.shaadi.android:id/inbox_img_in_accpeted")
	public WebElement upgradecard;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement featuredDeclineButton;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement featuredAceeptButton;

	@FindBy(id = "com.shaadi.android:id/carrouselFragment_tv_contact")
	public WebElement featuredInvitationContacttext;

	@FindBy(id = "com.shaadi.android:id/carrouselFragment_tv_upgrade_now")
	public WebElement featuredInvitationupgrade;

	@FindBy(id = "com.shaadi.android:id/carrouselFragment_tv_percent")
	public WebElement featuredInvitationPercent;

	@FindBy(id = "com.shaadi.android:id/carrouselFragment_txtName")
	public WebElement featuredInvitationName;

	@FindBy(id = "com.shaadi.android:id/tv_cta_header")
	public WebElement featuredDeclinedMemberText;

	@FindBy(id = "com.shaadi.android:id/tv_cta_message")
	public WebElement featuredChangedmindText;

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	public WebElement featuredAcceptInvitationText;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement deletebtn;

	@FindBy(id = "com.shaadi.android:id/iv_exit_stack")
	public WebElement responseclosebtn;

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	public WebElement btnprofilpremiumedecline;

	@FindBy(id = "com.shaadi.android:id/tv_button02")
	public WebElement btnprofilepremiumviewcontact;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelProfileName\"])[1]")
	public WebElement tvName;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement tvListingCTA;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement tvListingDeleteCTA;

	@FindBy(id = "com.android.packageinstaller:id/permission_message")
	public WebElement tvPermission;

	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	public WebElement btnDeny;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement btnAllow;

	@FindBy(className = "android.widget.TextView")
	public List<WebElement> photoDrawer;

	@FindBy(id = "com.shaadi.android:id/actPhoto_txtPrivacySettings")
	public WebElement txtPrivacySettings;

	@FindBy(id = "com.shaadi.android:id/setting_msg")
	public WebElement txtVisibleToAllMembers;

	@FindBy(id = "com.shaadi.android:id/photo_settings")
	public WebElement txtEdit;

	@FindBy(id = "com.shaadi.android:id/textView22")
	public WebElement txtToUploadMorePics;

	@FindBy(id = "com.shaadi.android:id/camera")
	public WebElement tvCamera;

	@FindBy(id = "com.shaadi.android:id/textView")
	public WebElement txtPrivacyCtrl;

	@FindBy(id = "com.shaadi.android:id/actPhoto_btnAddMore")
	public WebElement btnAddMore;

	@FindBy(id = "com.shaadi.android:id/gallery")
	public WebElement tvGallery;

	@FindBy(id = "com.shaadi.android:id/facebook")
	public WebElement tvFacebook;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_iv_avatar")
	public WebElement imgProfile;

	@FindBy(id = "com.shaadi.android:id/txt_profile_notification_info")
	public WebElement txtProfileRequest;

	@FindBy(id = "com.shaadi.android:id/txt_notification_btn")
	public WebElement txtProfileCTA;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement tvProfileConnectNow;

	@FindBy(id = "android:id/button1")
	public WebElement SendConnect;

	@FindBy(id = "com.shaadi.android:id/tv_pht_request")
	public WebElement tvPhotoRequest;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement txtSelfPhotoMissing;

	@FindBy(id = "android:id/button1")
	public WebElement btnAddPhoto;

	@AndroidFindBy(id = "android:id/button2")
	@iOSFindBy(id = "Cancel")
	public WebElement btnCancel;

	@FindBy(id = "android:id/message")
	public WebElement txtPhotoMissingInfo;

	@AndroidFindBy(id = "com.shaadi.android:id/button_decline")
	public WebElement DeclineonStack;

	@AndroidFindBy(id = "com.shaadi.android:id/button_accept")
	public WebElement AcceptonStack;

	@AndroidFindBy(id = "com.shaadi.android:id/txtAcceptButtonText")
	public WebElement AcceptonStackText;

	@AndroidFindBy(id = "android.widget.TextView")
	public List<WebElement> ProfileDecline;

	@AndroidFindBy(id = "android.widget.TextView")
	public List<WebElement> ProfileAccept;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	public WebElement Profileusername;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	public WebElement RcvdUserName;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_physical_caste_detail")
	public WebElement RcvdUserAgeHgt;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_location_education")
	public WebElement RcvdUserEduLoc;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_active_duration")
	public WebElement RcvdUserTime;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement RcvdDecline;

	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement RcvdAccept;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	public WebElement CloseStopPge;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
	public WebElement OpenRcvdProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_button1")
	public WebElement DeclineRcvdProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_button02")
	public WebElement ViewContactRcvdProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/imgButtonCancel")
	public WebElement UpgradeNowClose;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_count_heading")
	public WebElement HeaderTextonStack;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_name")
	public WebElement UserNameonStack;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	public WebElement UserAgeHeightonStack;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profession")
	public WebElement UserProfessiononStack;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_occupation")
	public WebElement UserProfessiononStackAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	public WebElement UserLocationonStack;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_received_time")
	public WebElement InvitationRcvdTime;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_profile_pic")
	public WebElement OpenStackProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelProfileName")
	public WebElement NameonProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	@iOSFindBy(id = "labelProfileDetailsLeft1")
	public WebElement AgeHeightProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_community")
	@iOSFindBy(id = "labelProfileDetailsLeft2")
	public WebElement CommunityProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_career")
	@iOSFindBy(id = "labelProfileDetailsRight1")
	public WebElement CareerProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	@iOSFindBy(id = "labelProfileDetailsRight2")
	public WebElement LocationProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_accept")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonAccept\"])[2]")
	public WebElement StackProfileAccept;

	@AndroidFindBy(id = "com.shaadi.android:id/btnAccept")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonAccept\"])[1]")
	public WebElement profileAcceptAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/btnAccept")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonDeclined Member\"])[1]")
	public WebElement btn_AcceptAfterDecline;

	@AndroidFindBy(id = "com.shaadi.android:id/btnDecline")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonDecline\"])[2]")
	public WebElement StackProfileDecline;

	@AndroidFindBy(id = "com.shaadi.android:id/btnDecline")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonDecline\"])[1]")
	public WebElement profileDeclineAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnNext")
	public WebElement BtnNxt;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_quick_response")
	@iOSFindBy(name = "Quick Response")
	public WebElement QuickPhaseBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_quick_response_description")
	public WebElement RespDescriptionAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement AcceptRcvdProfilePge;

	@FindBy(id = "com.shaadi.android:id/tv_hidden_profile")
	public WebElement HiddenProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_accepted_member")
	public WebElement AceeptedMemberTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/text")
	public WebElement AceeptedMemberCount;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_language_region")
	public WebElement LanguageRegionOnDrawer;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_name")
	public WebElement UserNameOnDrawer;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_age_height")
	public WebElement UserAgeHeightOnDrawer;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_free_text1")
	public WebElement ViewContactnOnDrawerTXT;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_cta_free_view_contact")
	public WebElement ViewContactnOnDrawerCta;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_free_text2")
	public WebElement WriteMsgOnDrawerTXT;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_cta_free_send_message")
	public WebElement WriteMsgOnDrawerCta;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_upgrade_proposition")
	public WebElement UpgradeindRAWER;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_premium_text1")
	public WebElement ViewContactPremium;// View Contact

	@AndroidFindBy(id = "com.shaadi.android:id/iv_cta_premium_view_contact")
	public WebElement ViewContactPremiumCTA;// View Contact

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_premium_text2")
	public WebElement WriteMsgPremium;// Write Message

	@AndroidFindBy(id = "com.shaadi.android:id/iv_cta_premium_send_message")
	public WebElement WriteMsgPremiumCTA;// Write Message

	@AndroidFindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement WriteMsgProfilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_upgrade_proposition")
	public WebElement UpgradeNowTop;

	@iOSFindBy(name = "labelTitle")
	@AndroidFindBy(id = "com.shaadi.android:id/noresultheading")
	public WebElement txtNoInvitations;

	@iOSFindBy(name = "labelSubTitle")
	@AndroidFindBy(id = "com.shaadi.android:id/noresultmsg")
	public WebElement txtNoResponsesAwaited;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement myMatchesConnectNow;

	@AndroidFindBy(id = "com.shaadi.android:id/button3")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonSingleCTARight_0\"])[1]")
	public WebElement myMatchesConnectButtonAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelDisplayName_1")
	public WebElement myMatchesMemberName;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelDisplayName_0")
	public WebElement myMatchesMemberName_Premium;

	@AndroidFindBy(id = "com.shaadi.android:id/ivTriangle")
	public WebElement dismissToolTip;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_premium_message")
	public WebElement tvPremiumMsg;

	@iOSFindBy(name = "buttonRightAction")
	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement tvRemind;

	@iOSFindBy(name = "labelRightAction")
	public WebElement txtRemind;

	@iOSFindBy(accessibility = "btnConnect.label") // needs to be changed
	@AndroidFindBy(id = "com.shaadi.android:id/tooltip_txt")
	public WebElement txtOnCTAClick;

	@AndroidFindBy(id = "com.shaadi.android:id/fragmentProfileDetail_rootView")
	public WebElement profileDetailsPage;

	@AndroidFindBy(id = "com.shaadi.android:id/drop_down_options")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"drop down inbox\"])[1]")
	public WebElement dropDownButtonAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/edtMessage")
	public WebElement edtMessage;

	@iOSFindBy(name = "buttonLeftAction")
	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement tvCancel;

	@iOSFindBy(name = "buttonLeftAction")
	public WebElement tvCancelCTAiOS;

	@iOSFindBy(name = "buttonRightAction")
	public WebElement btnRemindCTAiOS;

	@iOSFindBy(name = "labelLeftAction")
	public WebElement txtCancel;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_message_info_layer")
	public WebElement tvDeletedMsg;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_info")
	public WebElement deletedMessageAndroid;

	@FindBy(id = "com.shaadi.android:id/btnRemind")
	@iOSFindBy(id = "buttonCenterAction")
	public WebElement connectNowButtonAndroid;

	@iOSFindBy(name = "buttonCenterAction")
	@AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement tvConnectNow;

	@iOSFindBy(className = "XCUIElementTypeSegmentedControl")
	public WebElement SC;

	@iOSFindBy(id = "Sent Items") // needs to be changed
	public WebElement tabSentItems;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sent\")")
	@iOSFindBy(id = "buttonSubNav3")
	public WebElement sentTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Accepted\")")
	@iOSFindBy(id = "buttonSubNav1")
	public WebElement acceptedTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Received\")")
	public WebElement receivedTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Deleted\")")
	public WebElement DeletedTab;

	@FindBy(id = "android:id/button1")
	public WebElement btnProfileDetailsOK;

	@FindBy(id = "com.shaadi.android:id/tv_cta_header")
	public WebElement tvPremiumProfileInvitationSent;

	@FindBy(id = "com.shaadi.android:id/tv_cta_message")
	public WebElement tvPremiumProfileContactHerDirectly;

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	public WebElement tvPremiumProfileViewContact;

	@FindBy(id = "com.shaadi.android:id/tv_button1")
	public WebElement tvPremiumProfileCancelCTA;

	@FindBy(id = "com.shaadi.android:id/tv_button02")
	public WebElement tvPremiumProfileViewContactCTA;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement tvPremiumProfileRemindCTA;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement txtPremiumProfileCancelInvitation;

	@FindBy(id = "android:id/message")
	public WebElement txtPremiumProfileInfoMsg;

	@FindBy(id = "android.widget.Button")
	public WebElement btnPremiumProfileOK;

	@FindBy(id = "android:id/button1")
	public WebElement btnPremiumProfileBottomOK1;

	@FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnNext")
	public WebElement imgPremiumProfileSwipeNext;

	@FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnPrev")
	public WebElement imgPremiumProfileSwipePrev;

	@FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnNext")
	public WebElement imgPremiumProfileFilteredOutSwipeNext;

	@FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnPrev")
	public WebElement imgPremiumProfileFilteredOutSwipePrev;

	@FindBy(id = "com.shaadi.android:id/tv_hidden_profile")
	public WebElement tvPremiumProfileHiddenOrDeleted;

	@FindBy(id = "com.shaadi.android:id/tv_cta_header")
	public WebElement tvPremiumProfileFilteredOut;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"RefineGrey\"])[1]")
	@AndroidFindBy(id = "com.shaadi.android:id/layouRefine_imgbtn_refine")
	public WebElement btnFilter;

	@iOSFindBy(name = "Expiring Soon")
	public WebElement txt_ExpiryFilter;

	@FindBy(id = "com.shaadi.android:id/tv_cta_message")
	public WebElement tvPremiumProfileFileredOutMsg;

	@FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	public WebElement tvPremiumProfileCancelInterest;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Contacts\")")
	public WebElement PhoneBooktab;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_contacts_viewed_title")
	public WebElement ContactText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_contacts_Viewed_count")
	public WebElement ContactCount;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_name")
	public WebElement UserName;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_created_by")
	public WebElement Profilecreatedby;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_contact_no")
	public WebElement ContactNumber;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_email")
	public WebElement EmailID;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_send_sms")
	public WebElement SendSMS;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement SendSMSOKbtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_sms_sent_history")
	public WebElement ViewSMS;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_sms_content")
	public WebElement SMScontent;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_date")
	public WebElement TimeDate;

	@AndroidFindBy(id = "com.shaadi.android:id/option_menu")
	public WebElement ThreeDots;

	@AndroidFindBy(id = "android:id/title")
	public List<WebElement> BlockanReport;

	@AndroidFindBy(id = "com.shaadi.android:id/actItsAMatchPremium_btnSendMessage")
	public WebElement sendMessageButtonAccept;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_phone_hidden_title")
	public WebElement ContactNotAvailable;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_phone_hidden_sub_title")
	public WebElement YouHveBlocked;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement BlockedMember;

	@FindBy(id = "com.shaadi.android:id/imgInvites")
	public WebElement inboxNav1;

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> clickSentTab;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
	public WebElement clicktoOpenProfilePage;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement RemindbtnonProfile;

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> clickAcceptedTab;

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> clickReceivedTab;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement btnConnectNow;

	@FindBy(id = "com.shaadi.android:id/cb_save_draft")
	public WebElement savecheckbox;

	@FindBy(id = "com.shaadi.android:id/composeemail")
	public WebElement defaultmsg;

	@FindBy(id = "com.shaadi.android:id/imgMatches")
	public WebElement matchesNav;

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> MymatchesTab;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public WebElement btnGotitmymatches;

	@FindBy(id = "com.shaadi.android:id/llImgContainer_QT")
	public WebElement btnGotitPageRefine;

	@FindBy(id = "com.shaadi.android:id/btn_morph_connect_now")
	public WebElement carouselconnect;

	@FindBy(id = "android:id/button1")
	public WebElement SendMsgbtn;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
	public WebElement OpenprofilepageSavedraft;

	@FindBy(id = "com.shaadi.android:id/actItsAMatchPremium_btnSendMessage")
	public WebElement stopPagesendmsgbtn;

	@FindBy(id = "com.shaadi.android:id/imgInvites")
	public WebElement inboxNav;

	@FindBy(id = "com.shaadi.android:id/bt_got_it")
	public WebElement btnGotItinInbox;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement acceptbtn;

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> SentTab;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement Remindbtn;

	@FindBy(id = "com.shaadi.android:id/actItsAMatchPremium_btnSendMessage")
	public WebElement close1stacceptbanner;

	@FindBy(id = "com.shaadi.android:id/imgMyShaadi")
	public WebElement MyShaadiNav;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
	public WebElement ReceivedListing;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement ProfilepageAccept;

	@FindBy(id = "com.shaadi.android:id/iv_exit_stack")
	@iOSFindBy(id = "buttonClose")
	public WebElement CloseStackicon;

	@FindBy(id = "com.shaadi.android:id/tooltip_txt")
	public WebElement RemindToolTip;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement CancelCTA;

	@FindBy(id = "android:id/text1")
	public WebElement FilterOptions;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	public WebElement OpnProfile;

	@FindBy(id = "com.shaadi.android:id/tv_photo_req")
	public WebElement VerifyTextPhotoRequested;

	@FindBy(id = "com.shaadi.android:id/tv_button3")
	public WebElement TakeAction;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_iv_membership_tag")
	public WebElement scrolltillpremium;

	@FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnNext")
	public WebElement NextProfileBtn;

	@FindBy(id = "com.shaadi.android:id/tv_pht_request")
	public WebElement VerifyTextRequestSent;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_message_info_layer")
	public WebElement InfoLayer;

	@FindBy(id = "com.shaadi.android:id/bt_req_photo")
	public WebElement RequestAPhotoBtnonProfilePge;

	@FindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement PhotoRequestSentPopUpHdr;

	@FindBy(id = "android:id/message")
	public WebElement PhotoRequestSentPopUpText;

	@FindBy(id = "com.shaadi.android:id/tv_cta_connect_now")
	public WebElement ConnectNow;

	@FindBy(id = "android:id/button1")
	public WebElement PhotoRequestSentPopUpOKbtn;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement cameraAcceptButton;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_count_heading")
	@iOSFindBy(id = "labelAwaitingMembers")
	public WebElement lbl_Member_Waiting;

	@iOSFindBy(id = "labelAwaitingMembersSubText")
	public WebElement lbl_SubText_Member_Waiting;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelprofileName\"])[2]")
	public WebElement txt_ProfileName;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelprofileDetailsLeft1\"])[2]")
	public WebElement txt_age_height;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelprofileDetailsRight1\"])[2]")
	public WebElement txt_profession;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelprofileDetailsLeft2\"])[2]")
	public WebElement txt_religion;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelprofileDetailsRight2\"])[2]")
	public WebElement txt_location;

	@iOSFindBy(name = "labelSentTime")
	public WebElement txt_SentDate;

	@iOSFindBy(id = "closeWhite")
	public WebElement btn_closeContactPopUp;

	@iOSFindBy(name = "Sent Items")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sent Items\")")
	public WebElement btnSentItemsTab;

	@iOSFindBy(id = "labelExpiry")
	@AndroidFindBy(id = " ")
	public WebElement usr_Profile_Expiry;

	/*-----------------Inbox Received Objects--------------------------------*/

	@iOSFindBy(id = "its_an_accept_red")
	// @AndroidFindBy(id = "")
	public WebElement txtFirstAccept;

	@iOSFindBy(id = "My Shaadi")
	// @AndroidFindBy(id = "")
	public WebElement btnMyShaadiTab;

	@iOSFindBy(id = "buttonClose")
	// @AndroidFindBy(id = "")
	public WebElement btnCloseFrstAcptWindow;

	@iOSFindBy(id = "You have accepted")
	// @AndroidFindBy(id = "")
	public WebElement txtAcceptedMsg;

	@iOSFindBy(id = "labelProfileName")
	// @AndroidFindBy(id = "")
	public WebElement txtProfileName;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelProfileName\"])[2]")
	public WebElement txtProfileName2;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelProfileName\"])[3]")
	public WebElement txtProfileName_3;

	@iOSFindBy(id = "\"'s Invitation\"")
	// @AndroidFindBy(id = "")
	public WebElement txtInvitation;

	@iOSFindBy(id = "Take the next step now")
	// @AndroidFindBy(id = "")
	public WebElement txtNxtStep;

	@iOSFindBy(id = "Upgrade to message or call him directly")
	// @AndroidFindBy(id = "")
	public WebElement txtUpgrd;

	@iOSFindBy(id = "buttonViewPlan")
	// @AndroidFindBy(id = "")
	public WebElement btnViewPlan;

	@iOSFindBy(id = "Inbox")
	@AndroidFindBy(id = "com.shaadi.android:id/tvInvites")
	public WebElement btnInboxTab;

	@iOSFindBy(name = "profile_card_gradient")
	// @AndroidFindBy(id="")
	public WebElement imgPrflCard;

	@iOSFindBy(name = "labelprofileName")
	// @AndroidFindBy(id = "")
	public WebElement txtPrfName;

	@iOSFindBy(name = "labelprofileDetailsLeft1")
	// @AndroidFindBy(id = "")
	public WebElement txt_Age_Height;

	@iOSFindBy(name = "labelprofileDetailsLeft2")
	// @AndroidFindBy(id = "")
	public WebElement txt_Region;

	@iOSFindBy(name = "labelprofileDetailsRight1")
	// @AndroidFindBy(id = "")
	public WebElement txtOccupation;

	@iOSFindBy(name = "labelprofileDetailsRight2")
	// @AndroidFindBy(id = "")
	public WebElement txtReligion;

	@iOSFindBy(id = "labelMessage")
	// @AndroidFindBy(id="")
	public WebElement txtNoPendingInvites;

	@iOSFindBy(id = "buttonQuickResponse")
	// @AndroidFindBy(id="")
	public WebElement btnQuckResponse;

	@iOSFindBy(name = "buttonRightAction")
	// @AndroidFindBy(id="")
	public WebElement btnAcceptOnProfile;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonRightAction\"])[2]")
	// @AndroidFindBy(id="")
	public WebElement btnAcceptOnProfile_2;

	@iOSFindBy(name = "buttonLeftAction")
	// @AndroidFindBy(id="")
	public WebElement btnDeclineOnProfile;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonLeftAction\"])[3]")
	public WebElement btnDeclineOnProfile_generic;

	@iOSFindBy(id = "buttonSubNav1")
	// @AndroidFindBy(id="")
	public WebElement btnAcceptedTab;

	@iOSFindBy(id = "buttonSubNav0")
	// @AndroidFindBy(id="")
	public WebElement btnRecievedTab;

	@iOSFindBy(id = "Deleted")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Deleted\")")
	public WebElement btnDeletedTab;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Pending')]")
	// @AndroidFindBy(id="")
	public WebElement txtPendingCnt;

	@iOSFindBy(id = "Premium")
	// @AndroidFindBy(id="")
	public WebElement btnPremium;

	@iOSFindBy(id = "Matching Preferences")
//	@AndroidFindBy(id="")
	public WebElement btnMatchingPreferences;

	@iOSFindBy(id = "Expiring Soon")
	// @AndroidFindBy(id="")
	public WebElement btnExpiringSoon;

	@iOSFindBy(id = "All Invitations")
	// @AndroidFindBy(id="")
	public WebElement btnAllInvitations;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Viewed')]")
	public WebElement btnViewed_by_Him;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Not Viewed')]")
	public WebElement btnNot_Viewed_by_Him;

	@iOSFindBy(id = "Remind")
	public WebElement btnRemindOnSentTab;

	@iOSFindBy(id = "Cancel Request")
	public WebElement btnCancelRequestSentTab;

	@iOSFindBy(id = "Block Profile")
	public WebElement btnBlockProfileSentTab;

	@iOSFindBy(id = "Report Profile/Photo")
	public WebElement btnReportProfileSentTab;

	@iOSFindBy(id = "Cancel")
	public WebElement btnCancelSentTab;

	@iOSFindBy(id = "imgClose.label")
	// @AndroidFindBy(id="")
	public WebElement btnCloseUpGrdWnd;

}
