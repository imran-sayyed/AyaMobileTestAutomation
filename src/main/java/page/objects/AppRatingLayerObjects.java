package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AppRatingLayerObjects {


	
	  @AndroidFindBy(id="com.shaadi.android:id/textView7")
	  public static WebElement txtLayerheader;
	  
	  @AndroidFindBy(id="com.shaadi.android:id/btnNotSatisfied")
	  public static WebElement btnnotsatisfiled;
	  
	  @AndroidFindBy(id="com.shaadi.android:id/btnSatisfied")
	  public static WebElement btnsatisfield;

	  
	  @AndroidFindBy(id="com.shaadi.android:id/txtTop")
	  public static WebElement textnotyethader;
	  
	 
	  @AndroidFindBy(id=" com.shaadi.android:id/txtTitle")
	  public static WebElement texttitle;
	  
	  @AndroidFindBy(id="com.shaadi.android:id/edtComment")
	  public static WebElement textcommentbox;
	  
	  @AndroidFindBy(id="com.shaadi.android:id/btnSubmit")
	  public static WebElement btnsubmit;
	 
	  @FindBy(id="com.shaadi.android:id/rlMyShaadi")
		public static WebElement myShaadi;
	   
	  @FindBy(id="com.shaadi.android:id/btnback")
		public static WebElement back;
	  
	  @FindBy(id="com.shaadi.android:id/txtTop")
		public static WebElement txtsatisfiedheader;
	  
	  @FindBy(id="com.shaadi.android:id/txtTitle")
	  public static WebElement txtsatisfiedtitle;
		  
	 
	 
	 
	  
	  
	  @FindBy(id="com.shaadi.android:id/btnRateNow")
		public static WebElement btnratenow;
	  
	  @FindBy(id="com.android.vending:id/title_title")
		public static WebElement playstoretitle;
	  
	  
	  
	@iOSFindBy(name="Inbox")
	@AndroidFindBy(id = "com.shaadi.android:id/rlInvite")
	public static WebElement inbox;
	
	@iOSFindBy(className="XCUIElementTypeSegmentedControl")
	public static WebElement SC;
	
	
	@iOSFindBy(name="labelAwaitingMembers")
	@AndroidFindBy(id="com.shaadi.android:id/tv_count_heading")
	public static WebElement QuickResponseHeader;
	
	
	@iOSFindBy(name="buttonClose")
	@AndroidFindBy(id="com.shaadi.android:id/iv_exit_stack")
	public static WebElement CloseStackicon;

    @iOSFindBy(name="labelProfileName")
    @AndroidFindBy(id="com.shaadi.android:id/item_inbox_profile_tv_name")
    public static WebElement profileCardName;	
    
    @iOSFindBy(name="labelProfileDetails1")
    @AndroidFindBy(id="com.shaadi.android:id/item_inbox_profile_tv_physical_caste_detail")
    public static WebElement tvCasteDetail;
   
    @iOSFindBy(name="labelProfileDetails2")
    @AndroidFindBy(id="com.shaadi.android:id/item_inbox_profile_tv_location_education")
    public static WebElement tvEducationLocDetails;
    
    @iOSFindBy(name="labelProfileDetails3")
    @AndroidFindBy(id="com.shaadi.android:id/item_inbox_profile_tv_profession_earning")
    public static WebElement tvProfession;
    
    @iOSFindBy(name="labelActionStatus")
    @AndroidFindBy(id="com.shaadi.android:id/item_inbox_profile_tv_active_duration")
    public static WebElement tvDate;

    
    
    
   
    
   @iOSFindBy(name="btnHyperLinked.label")
    public static WebElement acceptLinkIOS;
    
    @iOSFindBy(name="buttonCenterAction")
    public static WebElement btnConnectNowiOS;
    
    @iOSFindBy(name="btnHyperLinked.label")
    public static WebElement accepLinkiOS;
    
   // @iOSFindBy(name="labelReadMore")
   // public static WebElement CannedMsgInListingios;
    
    @iOSFindBy(name="btnBackBarButtonItem")
    public static WebElement btnBackBarButtonItem;
    
    
    @iOSFindBy(name="buttonCancel")
    public static WebElement btnCancelSendingMsgiOS;

    @iOSFindBy(name="buttonSend")
    public static WebElement btnSendMsgiOS;
    
    @iOSFindBy(name="labelTitle")
    public static WebElement txtDeletedHeader;
    
    
   // @iOSFindBy(name="Send")
	//public static WebElement SendBtn;

    @iOSFindBy(name="lblSendEmail.label")
    public static WebElement lblSendEmailiOS;

    @iOSFindBy(name="textviewMessage")
    public static WebElement txtEnterMsgiOS;

    @iOSFindBy(name="buttonDefaultMessage")
    public static WebElement cbSetDefaultMSgiOS;

    @iOSFindBy(name="labelDefaultMessage")
    public static WebElement lblSetDefaultMSgiOS;

    @iOSFindBy(name="labelTitle")
    public static WebElement lblTitleiOS;
    
    @iOSFindBy(name="labelUserStatus")
    public static WebElement lblUserStatusText;
    
    
    
    
    
    

/////////////////////////////////////////////////////////////////////////////////////////////////////////////


	    
	    
      @FindBy(id = "com.shaadi.android:id/itemRefine_rootview")
    public static List < WebElement > viewgroupInbox;

    @FindBy(id = "com.shaadi.android:id/item_refine_btn")
    public static WebElement filterPremium;

    @FindBy(id = "com.shaadi.android:id/item_refine_btn")
    public static WebElement filterMatchingPreference;

    @FindBy(className = "androidx.appcompat.app.ActionBar$b")
    public static List < WebElement > actionBarItemSearch;

    @FindBy(id = "com.shaadi.android:id/bt_got_it")
    public static WebElement btnGotIt;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
    public static WebElement btnAccept;

    @FindBy(id = "com.shaadi.android:id/tv_button3")
    public static WebElement btnAcceptProfile;

    @FindBy(id = "com.shaadi.android:id/tv_button1")
    public static WebElement btnDeclinetProfile;


    @iOSFindBy(id="buttonLeftAction")
    @AndroidFindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
    public static WebElement btnDecline;
   
    @FindBy(id = "com.shaadi.android:id/tv_name")
    public static WebElement profilePagedName;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button1")
    public static WebElement btnViewcontactUpgradeprofile;

    @FindBy(id = "com.shaadi.android:id/btn_plan")
    public static WebElement btnupgradelayerprofile;


    
    @iOSFindBy(id="buttonClose")
    @AndroidFindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
    public static WebElement closeAcceptStopPagebtn;


    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtProfileName")
    public static WebElement nameAcceptStopPage;

    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_rootView")
    public static WebElement acceptStopPage;

   
    
    @iOSFindBy(name="btnClose.label")
    @AndroidFindBy(id = "com.shaadi.android:id/inbox_card_upgrade_close")
    public static WebElement upgradeacceptbannerclose;

    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnViewPlans")
    public static WebElement upgradeAcceptStopPage;

    //@FindBy(className="android.widget.ImageButton")
    //public static webelement backProfilePage;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
    public static WebElement featuredDeclineButton;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
    public static WebElement featuredAceeptButton;

    @FindBy(id = "com.shaadi.android:id/carrouselFragment_tv_contact")
    public static WebElement featuredInvitationContacttext;

    @FindBy(id = "com.shaadi.android:id/carrouselFragment_tv_upgrade_now")
    public static WebElement featuredInvitationupgrade;

    @FindBy(id = "com.shaadi.android:id/carrouselFragment_tv_percent")
    public static WebElement featuredInvitationPercent;

    @FindBy(id = "com.shaadi.android:id/carrouselFragment_txtName")
    public static WebElement featuredInvitationName;


    @FindBy(id = "com.shaadi.android:id/tv_cta_header")
    public static WebElement featuredDeclinedMemberText;

    @FindBy(id = "com.shaadi.android:id/tv_cta_message")
    public static WebElement featuredChangedmindText;

    @FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
    public static WebElement featuredAcceptInvitationText;

    @FindBy(id = "com.shaadi.android:id/tv_no_invitations")
    public static WebElement receivedEmptyCaseText;

    @FindBy(id = "com.shaadi.android:id/tv_click_matches")
    public static WebElement receivedEmptyCaseLink;


    @FindBy(id = "com.shaadi.android:id/tv_profile_button2")
    public static WebElement btnBottomAcceptProfile;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button0")
    public static WebElement btnBottomDeclinetProfile;

    @FindBy(className = "android.widget.RelativeLayout")
    public static List < WebElement > layout;

    @FindBy(className = "android.widget.RelativeLayout")
    public static List < WebElement > featuredcardlayout;

    @FindBy(className = "android.widget.LinearLayout")
    public static List < WebElement > profilelayout;

    /* upgrade card*/
    @FindBy(id = "com.shaadi.android:id/txtBottomStr")
    public static WebElement receivedUpgradecardText;

    @FindBy(id = "com.shaadi.android:id/inbox_AddFreeUpgrader")
    public static WebElement btnreceivedUpgradecard;

    @FindBy(id = "com.shaadi.android:id/inbox_card_upgrade_close")
    public static WebElement reeceivedUpgradecardclose;

    @FindBy(className = "android.widget.LinearLayout")
    public static List < WebElement > upgradelayout;

    @FindBy(id = "com.shaadi.android:id/inbox_img_in_accpeted")
    public static WebElement upgradecard;

    //block
    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_iv_avatar")
    public static WebElement imgClick;

    @FindBy(id = "com.shaadi.android:id/img_arrow")
    public static WebElement imgArrow;

    @FindBy(id = "com.shaadi.android:id/title")
    public static WebElement txtTitle;

    @FindBy(className = "android.widget.LinearLayout")
    public static List < WebElement > clkBlock;

    @FindBy(id = "com.shaadi.android:id/alertTitle")
    public static WebElement txtBlockAlert;

    @FindBy(id = "com.shaadi.android:id/textView4")
    public static WebElement txtBlockInfo;

    @FindBy(id = "com.shaadi.android:id/tv_report_misuse")
    public static WebElement txtReportMisuse;

    @FindBy(id = "android:id/button1")
    public static WebElement btnBlockOK;

    @FindBy(id = "com.shaadi.android:id/tv_cta_header")
    public static WebElement txtBlockProfile;
    // premium

    @FindBy(id = "com.shaadi.android:id/actItsAMatchPremium_btnDismiss")
    public static WebElement closePremiumAcceptStopPagebtn;

    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_parent")
    public static WebElement receivedcard;

  
    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_message_info_layer")
    public static WebElement tvInfo;

    @FindBy(id = "com.shaadi.android:id/alertTitle")
    public static WebElement SelfPhotoMissingtxt;

    @FindBy(id = "android:id/message")
    public static WebElement PhotoMissinginfo;

    @FindBy(id = "android:id/button1")
    public static WebElement Addphotobtn;

    @FindBy(id = "android:id/button2")
    public static WebElement CancelbtnPhotorequest;


    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_rl_two_party_pay_message")
    public static WebElement LockedMsg2wayListing;

    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_upgrade_now")
    public static WebElement UpgradeNow2wayListing;

    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_facebook")
    public static WebElement FBlink2wayListing;

    @FindBy(id = "com.shaadi.android:id/img_two_way")
    public static WebElement Open2wayProfilepage;

    @FindBy(id = "com.shaadi.android:id/profile_detail_sent")
    public static WebElement LockedMsg2wayProfilepage;

    @FindBy(id = "com.shaadi.android:id/profile_detail_sent_upgrade_panel")
    public static WebElement UpgradeNowORfbon2wayProfilepage;

    //accept stop page

    @FindBy(id = "com.shaadi.android:id/layoutItsAMatct_txtHeading")
    public static WebElement AcceptStopPageHeadingText;

    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtSubHeadingMsg")
    public static WebElement AcceptStopPageSubHeadingText;

    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtButtonHeading")
    public static WebElement AcceptStopPageText1;


    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_txtUpgradeMessage")
    public static WebElement AcceptStopPageText2;


    @FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnViewPlans")
    public static WebElement AcceptStopPageUpgrade;


    @FindBy(className = "android.widget.ListView")
    public static List < WebElement > FilterLayer;


    @FindBy(id = "android:id/text1")
    public static WebElement Layerfilteroutoption;

    //upgrade card after stop page

    @FindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtHeading")
    public static WebElement Upgradebannertext1;



    @FindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtName")
    public static WebElement Upgradebannertext2;

    @FindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtContactTitle")
    public static WebElement Upgradebannertext3;

    /*
    @FindBy(id="com.shaadi.android:id/cardBannerPersonalized_txtContact")
    public static WebElement Upgradebannertext4;

    @FindBy(id="com.shaadi.android:id/cardBannerPersonalized_btnViewPlans")
    public static WebElement Upgradebtntext5;

    @FindBy(id="com.shaadi.android:id/cardBannerPersonalized_txtOffer")
    public static WebElement Upgradebannertext6;
    */

    @FindBy(className = "android.view.ViewGroup")
    public static List < WebElement > upgradecardafteraccept;



    @FindBy(id = "com.shaadi.android:id/inboxFragmentRecycleView")
    public static WebElement fragmentview;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button0")
    public static WebElement btnprofileBottomcta1;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button1")
    public static WebElement btnprofileBottomcta2;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button2")
    public static WebElement btnprofileBottomcta3;

    //premium

    @FindBy(id = "com.shaadi.android:id/tv_button1")
    public static WebElement btnprofilpremiumedecline;
    @FindBy(id = "com.shaadi.android:id/tv_button02")
    public static WebElement btnprofilepremiumviewcontact;
    @FindBy(id = "com.shaadi.android:id/tv_button3")
    public static WebElement btnprofilepremiumaccept;

    @FindBy(id = "android:id/message")
    public static WebElement ViewingNumAlertTxt;

    @FindBy(id = "android:id/button1")
    public static WebElement ViewNumYesBtn;

    @FindBy(id = "com.shaadi.android:id/txt_header")
    public static WebElement ViewContactHeaderTxt;

    @FindBy(id = "com.shaadi.android:id/txt_mobile_label")
    public static WebElement MobileHeaderTxt;

    @FindBy(id = "com.shaadi.android:id/mobileNo")
    public static WebElement MobileNumberVerification;

    @FindBy(id = "com.shaadi.android:id/txt_mobile_sms")
    public static WebElement SmsIcon;

    @FindBy(id = "com.shaadi.android:id/edt_message")
    public static WebElement SMStext;

    @FindBy(id = "android:id/button1")
    public static WebElement OkBtn1;

    @FindBy(id = "com.shaadi.android:id/alertTitle")
    public static WebElement SndMsgTxt; // Send a text message

    @FindBy(id = "com.shaadi.android:id/edt_message")
    public static WebElement Actualsms;

    @FindBy(id = "com.shaadi.android:id/txt_success_msg")
    public static WebElement SmsSentSuccessfully; // Your SMS has been sent successfully.

    @FindBy(id = "android:id/button1")
    public static WebElement OkSMS;

    @FindBy(id = "com.shaadi.android:id/alertTitle")
    public static WebElement NumNotVerifiedTitle;

    @FindBy(id = "android:id/button1")
    public static WebElement SendInterestBtn; //Send Interest

    @FindBy(id = "com.shaadi.android:id/alertTitle")
    public static WebElement RequestSentTitle;

    @FindBy(id = "android:id/message")
    public static WebElement RequestSentTxt;

    @FindBy(id = "android:id/button2")
    public static WebElement OkBtn2;

    @FindBy(id = "com.shaadi.android:id/txt_mobile_call")
    public static WebElement CallIcon;

    @FindBy(id = "android:id/message")
    public static WebElement ActualContactNumber;

    @FindBy(id = "android:id/button1")
    public static WebElement CallBtn;

    @FindBy(id = "android:id/message")
    public static WebElement NumNtVerifiedTxt;

    @FindBy(id = "com.shaadi.android:id/txt_email_header")
    public static WebElement EmailHeaderTxt;

    @FindBy(id = "com.shaadi.android:id/email")
    public static WebElement UserEmailId;

    @FindBy(id = "com.shaadi.android:id/txt_name_header")
    public static WebElement ContactPersonHeaderTxt;

    @FindBy(id = "com.shaadi.android:id/contactName")
    public static WebElement ContactPersonName;

    @FindBy(id = "com.shaadi.android:id/txt_count_header")
    public static WebElement ContactsAvailableHdrTxt;

    @FindBy(id = "com.shaadi.android:id/txt_count")
    public static WebElement ActualContactsAvailable;

    @FindBy(id = "com.shaadi.android:id/txt_ok")
    public static WebElement OkBtnOnViewCOntact;

    @FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnPrev")
    public static WebElement btnPrevious;

    @FindBy(id = "com.shaadi.android:id/msgtext")
    public static WebElement ClickWriteMsg;

    @FindBy(id = "com.shaadi.android:id/send_btn")
    public static WebElement SendMsgBtn1;


    @FindBy(id = "com.shaadi.android:id/tv_button02")
    public static WebElement PremiumViewContact;

    @FindBy(id = "com.shaadi.android:id/tv_button3")
    public static WebElement PremiumWriteMsg;

    @FindBy(id = "com.shaadi.android:id/tv_button1")
    public static WebElement PremiumCancel; // Cancel

    @FindBy(id = "com.shaadi.android:id/tv_button1")
    public static WebElement PremiumDecline; // Decline


    @FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
    public static WebElement PremiumConnectNowLInk; // Connect Now

    @FindBy(id = "android:id/button1")
    public static WebElement PremiumSendPremiumMSg; // SEND

    @FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
    public static WebElement PremiumAcceptLink;

    @FindBy(id = "com.shaadi.android:id/composeemail")
    public static WebElement PremiumMsgText;

    @FindBy(id = "com.shaadi.android:id/composeemail")
    public static WebElement txtDefaultMsg;

    @AndroidFindBy(id = "com.shaadi.android:id/alertTitle")
	public static WebElement WriteMsgHeader;
    
    @FindBy(id = "com.shaadi.android:id/cb_save_draft")
    public static WebElement cbSaveDraft;
    
    @FindBy(id = "com.shaadi.android:id/actItsAMatchPremium_edtMessage")
    public static WebElement StopPageText;
    
    @FindBy(id = "com.shaadi.android:id/actItsAMatchPremium_btnSendMessage")
    public static WebElement StopPagebtn;
    
    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
    public static WebElement acceptbtn;
    
    @FindBy(id = " com.shaadi.android:id/customPanel")
    public static WebElement frameLayout;
    
   
    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
    public static WebElement btnpremiumfeatureAccept;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
    public static WebElement btnpremiumfeatureDecline;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
    public static WebElement btnpremiumfeatureviewcontact;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
    public static WebElement btnpremiumfeaturewritemessage;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button0")
    public static WebElement btnpremiumprofilebottomdecline;

    @FindBy(id = "com.shaadi.android:id/tv_profile_button2")
    public static WebElement btnpremiumprofilebottomaccept;


    //@FindBy(id="com.shaadi.android:id/alertTitle")
    //public static WebElement txtDailyLimitExceeded;

    @FindBy(id = "android:id/message")
    public static WebElement txtDailyLimitExceededInfo;

    @FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_premium_message")
    public static WebElement tvPremiumMsg;


    @FindBy(id = "com.shaadi.android:id/tv_button3")
    public static WebElement tvPremiumProfileRemindCTA;

    @FindBy(id = "com.shaadi.android:id/tv_button1")
    public static WebElement tvPremiumProfileCancelCTA;

    @FindBy(id = "com.shaadi.android:id/tv_button02")
    public static WebElement tvPremiumProfileViewContactCTA;

    @FindBy(id = "android:id/button2")
    public static WebElement btnDailyLimitExceededOK;

    @FindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
    public static WebElement tvPremiumProfileViewContact;

    @FindBy(id = "com.shaadi.android:id/fragmentProfileDetail_btnPrev")
    public static WebElement imgPremiumProfileSwipePrev;

    @FindBy(id = "android:id/button2")
    public static WebElement CancelBtn;

    @FindBy(id = "com.shaadi.android:id/alertTitle")
    public static WebElement DailyLimitReached;

    @FindBy(id = "android:id/message")
    public static WebElement DailyLimitReachediNFO;

    @FindBy(id = "android:id/button2")
    public static WebElement DailyLimitReachedOkBtn;

    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
    public static WebElement btnpremiumwritemessage;

    @FindBy(id = "com.shaadi.android:id/tv_pht_request")
    public static WebElement requestphoto;
    
    @FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
    public static WebElement deletebtn;
    
    @FindBy(id = "com.shaadi.android:id/iv_exit_stack")
    public static WebElement responseclosebtn;
    
    //Panchsheela module -canned msg in listing 
    
    @iOSFindBy(name="labelProfileMessage")
   	@FindBy(id="com.shaadi.android:id/item_inbox_profile_tv_premium_message")
   	public static WebElement CannedMsgInListing;
       
     
	@FindBy(id="com.shaadi.android:id/noresultheading")
	public static WebElement emptyheading;
	
	@FindBy(id="com.shaadi.android:id/noresultmsg")
	public static WebElement emptytxt;
	
	@FindBy(id="com.shaadi.android:id/viewrecentmatches")
	public static WebElement emptylink;
	
	
	
	
}
