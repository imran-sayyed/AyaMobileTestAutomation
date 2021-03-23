package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import android.shaadi.BasePageActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import shaadi.utils.AppStringConstants;

public class MyShaadiPageObjects extends BasePageActions {
	
	
	@AndroidFindBy(id = "com.shaadi.android:id/ll_hide_delete")
	@iOSFindBy(id = "Hide / Delete Profile")
	public WebElement HideDeleteButton;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeImage[@name='arrow_large'])[2]")
	public WebElement reminderMessageButtonIOS;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeImage[@name='arrow_large'])[1]")
	public WebElement acceptMessageButtonIOS;
	
	@iOSFindBy(id = "arrow large")
	public WebElement connectMessageButtonIOS;
	
	@iOSFindBy(id = AppStringConstants.connectMessage)
	public WebElement connectMessageTxtIOS;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='labelSubHeader'])[1]")
	public WebElement acceptMessageTxtIOS;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='labelSubHeader'])[2]")
	public WebElement reminderMessageTxtIOS;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_messages_settings")
	@iOSFindBy(id = "id_detailTextLabel_draft")
	public WebElement messageTabShaadiPage;


	@iOSFindBy(id = "Your profile is visible")
	public WebElement profileVisibletxtIOS;

	@iOSFindBy(name = "Cancel")
	public WebElement CancelButtonIOS;
	
	@iOSFindBy(id = "Not visible to all members")
	public WebElement notVisibleToAllMembersIOS;
	
	@iOSFindBy(id = "Visible to all members")
	public WebElement visibleToAllMembersIOS;
	
	@AndroidFindBy(id = "com.shaadi.android:id/rl_verification_batch")
	@iOSFindBy(id = "Visible to all members")
	public WebElement VerificationBadgeButtonIOS;
	
	@iOSFindBy(id="Not visible to all members")
	public WebElement NotVisible_VerificationBadgeButtonIOS;
	
	@iOSFindBy(id="id_cell_dob")
	public static WebElement btn_DobCell;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_see_all")
	@iOSFindBy(id = "buttonSeeAll_discovery_premium")
	public static  WebElement btnSeeAll_premium;

	
	@iOSFindBy(id = "id_cell_email")
	public WebElement EditEmailButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Account Settings']")
	@iOSFindBy(id = "Account Settings")
	public WebElement AccountSettingsIOS;
	
	@AndroidFindBy(id = "com.shaadi.android:id/btnChatWithUs")
	public WebElement chatWithUsButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnCallUs")
	public WebElement callUsButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnStopSalesCalls")
	public WebElement stopSalesCallButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnContactDetails")
	public WebElement contactDetailsButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnPartnerPreference")
	public WebElement editPartnerPreferencesButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_notMentioned")
	public WebElement notMentioneHereButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView52")
	public WebElement notMentioneHereText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_unableToEditProfile")
	public WebElement unableToEditProfileButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView47")
	public WebElement unableToEditProfileText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_tooManyCalls")
	public WebElement receivingToomanyCallsButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView46")
	public WebElement receivingToomanyCallsText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_nonSeriousProfile")
	public WebElement misUseProfileButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView45")
	public WebElement misUseProfileText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_unhappyWithMatches")
	public WebElement unHappyWithMatchesButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView44")
	public WebElement unHappyWithMatchesText;

	@AndroidFindBy(id = "com.shaadi.android:id/btnDeleteMyProfile")
	public WebElement deleteProfileLink;

	@AndroidFindBy(id = "com.shaadi.android:id/txtTakingBreakTitle")
	public WebElement takingBreakTitleText;

	@AndroidFindBy(id = "android:id/button2")
	public WebElement confirmProfileDeletionAlertCancelButton;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement confirmProfileDeletionAlertDeleteButton;

	@AndroidFindBy(id = "android:id/message")
	public WebElement confirmProfileDeletionAlertText;

	@AndroidFindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement confirmProfileDeletionAlertHeaderText;

	@AndroidFindBy(id = "com.shaadi.android:id/btnDeleteMyProfileSuccess")
	public WebElement foundThroughShaadiPageDeleteButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnAddPhotos")
	public WebElement foundThroughShaadiPageAddPhotosLink;

	@AndroidFindBy(id = "com.shaadi.android:id/edtIdentity")
	public WebElement foundThroughShaadiPagePartnerEmailTextBox;

	@AndroidFindBy(id = "com.shaadi.android:id/edtSummary")
	public WebElement foundThroughShaadiPageTextBox;

	@AndroidFindBy(id = "com.shaadi.android:id/textView57")
	public WebElement foundThroughShaadiPageHeaderText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_foundFromOther")
	public WebElement foundElseWhereButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_foundFromShaadi")
	public WebElement foundThroughShaadiButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView52")
	public WebElement foundElseWhereText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView44")
	public WebElement foundThroughShaadiText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView57")
	public WebElement foundMyMatchPageHeaderText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_ReasonNotMentioned")
	public WebElement reasonNotMentionedButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_unsatisfactoryExperience")
	public WebElement unsatisfactoryExperienceButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_takingABreak")
	public WebElement takingBreakButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_foundAMatch")
	public WebElement foundMyMatchButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView56")
	public WebElement ReasonNotMentionedTextText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView55")
	public WebElement UnsatisfactoryExperienceSubHeadingText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView54")
	public WebElement UnsatisfactoryExperienceText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView53")
	public WebElement TakingBreakSubHeadingText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView52")
	public WebElement TakingBreakText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView49")
	public WebElement FoundMyMatchSubHeadingText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView44")
	public WebElement FoundMyMatchText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView57")
	public WebElement deleteProfilePageHeaderText;

	@AndroidFindBy(id = "com.shaadi.android:id/delete_profile")
	public WebElement deleteProfileButton;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_header_basic")
	public WebElement partnerPreferenceHeaderText;

	@AndroidFindBy(id = "com.shaadi.android:id/profile_status")
	public WebElement profileStatus;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Hide Profile']")
	@AndroidFindBy(id = "com.shaadi.android:id/hide_unhide_title")
	public WebElement HideTitle;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Unhide Profile']")
	public WebElement unHideTitle;
	


	@AndroidFindBy(xpath = "//*[text()='Alerts']")
	public WebElement AlertHeaderTextAndroid;

	@iOSFindBy(id = "Push Notifications and Sounds")
	@AndroidFindBy(id = "com.shaadi.android:id/txt_label_for_push_noti_sound")
	public WebElement PushNotificationButton;

	@iOSFindBy( xpath = "//XCUIElementTypeStaticText[@name='Alerts']")
	@AndroidFindBy(id = "com.shaadi.android:id/textView1")
	public WebElement AlertsTabText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_contact_filter_footer_text")
	public WebElement contactFiltersFooterText;

//	@AndroidFindBy(id = "com.shaadi.android:id/tv_contact_filter_header_text")
//	public WebElement contactFiltersHeaderText;
//	
//	
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_header_basic")
	public WebElement contactFiltersHeaderText;

	@AndroidFindBy(id = "com.shaadi.android:id/tvDashboard")
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"My Shaadi\"]")
	public WebElement MyShaadiHeaderTextAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/button6")
	public WebElement connectNowButtonListingAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_username")
	@iOSFindBy(id="labelSectionTitle_discovery_premium")
	public WebElement myShaadiPageUsername;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	public WebElement NextArrowBtn;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnViewPlans")
	public WebElement AcceptBanner;

	@FindBy(id = "com.shaadi.android:id/imgInvites")
	public WebElement inboxNav1;

	@FindBy(id = "com.shaadi.android:id/tv_count_heading")
	public WebElement QuickResponseHeader;

	@FindBy(id = "com.shaadi.android:id/iv_exit_stack")
	public WebElement CloseStackicon;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button2")
	public WebElement FirstAccept;

	@FindBy(id = "com.shaadi.android:id/tv_upgrade_now")
	public WebElement btnRenewPremium;

	@iOSFindBy(accessibility = "btnLogin")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_logout")
	public WebElement btnLogout;

	@AndroidFindBy(id = "com.shaadi.android:id/lblConnect")
	public WebElement shaadiChatButton;

	@AndroidFindBy(id = "com.shaadi.android:id/label_me")
	public WebElement messageText;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public WebElement btnGotIt;

	@FindBy(id = "com.shaadi.android:id/tv_upgrade_now")
	@iOSFindBy(id="buttonUpgradeNow")
	public WebElement btnUpgradeNow;

	@FindBy(id = "com.shaadi.android:id/rl_settings_row")
	public List<WebElement> RlSettingsRow;

//	@iOSFindBy(id = "existing_email")
    @iOSFindBy(id="id_textLabel_email")
	@AndroidFindBy(id = "com.shaadi.android:id/lbl_email_id")
	public WebElement lblEmailID;
    
    @iOSFindBy(id="existing_email")
    @AndroidFindBy(id = "com.shaadi.android:id/lbl_email_id")
    public WebElement lbl_exisitngEmail;

	@FindBy(id = "com.shaadi.android:id/lbl_email_edit")
	public WebElement lblEditEmailID;

	@FindBy(id = "com.shaadi.android:id/rlMyShaadi")
	public WebElement rlMyShaadiTab;

	@FindBy(id = "com.shaadi.android:id/rl_settings_row")
	public List<WebElement> rlSettingsRow;

	@iOSFindBy(id = "textedit_newemail")
	@AndroidFindBy(id = "com.shaadi.android:id/ed_email")
	public WebElement edEmailID;

	@iOSFindBy(id = "button_save")
	@FindBy(id = "com.shaadi.android:id/btn_submit")
	public WebElement btnSubmit;

	@iOSFindBy(id = "textfield_password")
	@AndroidFindBy(id = "com.shaadi.android:id/ed_password")
	public WebElement edPassword;

	@FindBy(id = "com.shaadi.android:id/btn_cancel")
	public WebElement btnCancel;

	@FindBy(id = "com.shaadi.android:id/textinput_error")
	public WebElement txtValidationError;

	@FindBy(id = "com.shaadi.android:id/textView35")
	public WebElement lnkForgotPassword;

	@FindBy(id = "com.shaadi.android:id/textView14")
	public WebElement txtPasswordResetLinkSent;

	@FindBy(id = "com.shaadi.android:id/textView36")
	public WebElement txtUpdatedSuccessfully;

	@iOSFindBy(id = "OK")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_submit")
	public WebElement btnOK;

	@FindBy(id = "com.shaadi.android:id/btnSeeAll")
	public WebElement premiumMatchesSeeAll;

	@FindBy(id = "com.shaadi.android:id/img_profile_selection")
	public WebElement img_profile_selection;

	@FindBy(id = "com.shaadi.android:id/title")
	public List<WebElement> addToShortlist;

	@AndroidFindBy(id = "android:id/title")
	public List<WebElement> dropdownOptions;

	@FindBy(id = "com.shaadi.android:id/rlMatches")
	public WebElement MyMatches;

	@FindBy(id = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> shortlisted;

	@FindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id="labelDisplayName_1")
	public WebElement profileName;

	@FindBy(id = "com.shaadi.android:id/profilename")
	public WebElement shortlistedProfileName;

	@FindBy(id = "com.shaadi.android:id/btnConnect")
	@iOSFindBy(id="buttoncallToAction_discovery_premium_0")
	public WebElement connectNowCarausal;
	
	@FindBy(id = "com.shaadi.android:id/btnConnect")
	@iOSFindBy(id="buttoncallToAction_discovery_premium_1")
	public WebElement connectNowCarausal_1;
	
	@iOSFindBy(id="buttonAction")
	public WebElement btn_SendMsg;

	@FindBy(id = "com.shaadi.android:id/lblName")
	public WebElement profileNameOncarousal;

	@FindBy(id = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> sentItems;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	public WebElement profileListedInsentItems;

	@FindBy(id = "com.shaadi.android:id/lblActionDoneText")
	public WebElement ignornedMember;

	@FindBy(id = "com.shaadi.android:id/lblName")
	public WebElement ignornedMemberProfileName;

	@FindBy(id = "com.shaadi.android:id/rlMyShaadi")
	public WebElement myShaadi;
	// com.shaadi.android:id/lblName

	@iOSFindBy(id = "arrow left white")
	@AndroidFindBy(className = "android.widget.ImageButton")
	public WebElement backButton;

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	public List<WebElement> horizontalTabs;
	// driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab")

	@FindBy(how = How.XPATH, using = ("//android.widget.TextView[contains(text(),‘Shortlists’)]"))
	public WebElement shortlists;

	@FindBy(id = "android:id/button1")
	public WebElement blockHimOk;

	@FindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	public WebElement profileNameOnSentItemsListing;

	@FindBy(id = "android:id/button1")
	public WebElement sendButton;

	@FindBy(id = "com.shaadi.android:id/rlInvite")
	public WebElement inbox;

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	@iOSFindBy(id="Sent Items")
	public List<WebElement> inboxSent;
	
	@FindBy(id = "com.shaadi.android:id/rl_settings_row")
	public List<WebElement> settingsRow;

	
	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='New Invitations']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_interest")
	public WebElement newInvitations;

	@iOSFindBy(id = "Matches, Invitations & Accepts, Receive and respond to your matches directly on whatsapp.")
	@AndroidFindBy(id = "com.shaadi.android:id/check_whatsapp_opt_in")
	public WebElement whatsapp_alert_toggle;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='New Accepts']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_accepts")
	public WebElement newAccepts;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='Recommendations']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_daily_Recc")
	public WebElement recommendations;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='New Matches']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_newMatches")
	public WebElement newMatches;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='Shortlists']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_shortlist")
	public WebElement shortlistsAlerts;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='Recent Visitors']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_recent_visitor")
	public WebElement recentVisitors;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='Premium Matches']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_premiumMatches")
	public WebElement premiumMatches;

	@iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name='Pending Invitations']")
	@AndroidFindBy(id = "com.shaadi.android:id/check_pendinginterest")
	public WebElement pendingInvitations;

	@FindBy(id = "com.shaadi.android:id/txt_user_id")
	public WebElement shID;

	@FindBy(id = "com.shaadi.android:id/rl_hide_delete")
	public WebElement hideDeleteProfile;

	@FindBy(id = "com.shaadi.android:id/save_hide")
	public WebElement saveHideProfileButton;

	@iOSFindBy(id = "buttonHideProfile")
	@FindBy(id = "com.shaadi.android:id/btnHideMyProfile")
	public WebElement hideProfileButton;

	@FindBy(id = "android:id/button1")
	public WebElement unHideOkButton;

	@iOSFindBy(id = "Verification Badge")
	@AndroidFindBy(id = "com.shaadi.android:id/alertTitle")
	public WebElement verificationBadge;

	@FindBy(id = "android:id/text1")
	public List<WebElement> badgeOptions;

	@FindBy(id = "android:id/button1")
	public WebElement badgeOkButton;

	public String maritalStatusId = "com.shaadi.android:id/tv_mothertonguelabel";

//	@FindBy(id = "com.shaadi.android:id/tv_martialstatusdropdowntext")
//	public WebElement martialstatusdropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Marital Status']")
	public WebElement martialstatusdropdowntext;

	@FindBy(id = "com.shaadi.android:id/btn_apply")
	public WebElement applyButton;
	
	@FindBy(id = "com.shaadi.android:id/tv_apply")
	public WebElement applyButtonPP;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_apply")
	public WebElement applyButtonContactFilters;
	
	@FindBy(id = "com.shaadi.android:id/tv_childrendropdowntext")
	public WebElement childrendropdowntext;

	/*
	 * @FindBy(id = "com.shaadi.android:id/tv_religiondropdowntext") public
	 * WebElement religiondropdowntext;
	 */
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Religion']")
	public WebElement religiondropdowntext;

//	@FindBy(id = "com.shaadi.android:id/tv_communitydropdowntext")
//	public WebElement communitydropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Community']")
	public WebElement communitydropdowntext;

//	@FindBy(id = "com.shaadi.android:id/tv_mothertonguedropdowntext")
//	public WebElement mothertonguedropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Mother Tongue']")
	public WebElement mothertonguedropdowntext;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Country living in']")
	public WebElement countrydropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'State living in']")
	public WebElement statedropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Qualification']")
	public WebElement qualificationdropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Working With']")
	public WebElement workingwithDropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Profession Area']")
	public WebElement professionDropdowntext;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Diet']")
	public WebElement dietDropdowntext;
	
	@FindBy(id = "android:id/button2")
	public WebElement NoBtnPP;
	
	
	@FindBy(id = "com.shaadi.android:id/tv_countrylivinglabel")
	public WebElement countryLivingdropdowntext;
	
	@FindBy(id = "com.shaadi.android:id/tv_statelivinglabel")
	public WebElement stateLivingdropdowntext;
	
	@FindBy(id = "com.shaadi.android:id/tv_educationlabel")
	public WebElement educationdropdowntext;
	
	@FindBy(id = "com.shaadi.android:id/tv_workingwithlabel")
	public WebElement workingwithdropdowntext;
	
	@FindBy(id = "com.shaadi.android:id/tv_professionarealabel")
	public WebElement professiondropdowntext;
	
	

	


	@FindBy(id = "com.shaadi.android:id/txt_title")
	public List<WebElement> contactFilterParamaters;

	public MobileElement religionDropdownText() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Religion']"));
		return categories;
	}

	public MobileElement martialStatusDropdownText() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Age']"));
		return categories;
	}

	@FindBy(id = "com.shaadi.android:id/tv_more_filter")
	public WebElement moreLink;

	public MobileElement locationDetails() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Location Details']"));
		return categories;
	}

	public MobileElement martialStatus() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Marital Status']"));
		return categories;
	}

	public MobileElement motherTongue() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Mother Tongue']"));
		return categories;
	}

	public MobileElement partnerPreference() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.xpath("//android.widget.TextView[@text = 'Partner Preferences']"));
		return categories;
	}

	@FindBy(id = "com.shaadi.android:id/tv_countrylivingdropdowntext")
	public WebElement countryLiving;

	@FindBy(id = "com.shaadi.android:id/tv_statelivingdropdowntext")
	public WebElement stateLiving;

	@FindBy(id = "com.shaadi.android:id/tv_educationdropdowntext")
	public WebElement educationDropdown;

	@FindBy(id = "com.shaadi.android:id/tv_workingwithdropdowntext")
	public WebElement workingWith;

	@FindBy(id = "com.shaadi.android:id/tv_professionareadropdowntext")
	public WebElement professionalArea;

	@FindBy(id = "com.shaadi.android:id/rbtn_income_doesntmatter")
	public WebElement annualIncomeDosentMatter;

	@FindBy(id = "com.shaadi.android:id/rbtn_income_specifyrange")
	public WebElement specifyAnIncomeRange;

	@FindBy(id = "com.shaadi.android:id/item_invite_cta_tv_button1")
	public WebElement cancelButton;

	@FindBy(id = "com.shaadi.android:id/iv_exit_stack")
	public WebElement closeAnnimation;

	@FindBy(id = "com.shaadi.android:id/btn_save")
	public WebElement saveButton;

	@FindBy(id = "com.shaadi.android:id/txt_title")
	public List<WebElement> contactFiltersParameters;

	public WebElement religionDropdownTextContactFilters() {
		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("(//android.widget.TextView[@text='Religion'])");
		return element;

	}

	public WebElement communityDropdownTextContactFilters() {
		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("(//android.widget.TextView[@text='Community'])");
		return element;

	}

	public WebElement motherTongueDropdownTextContactFilters() {
		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("(//android.widget.TextView[@text='Mother Tongue'])");
		return element;

	}

	public WebElement martialStatusDropdownTextContactFilters() {
		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("(//android.widget.TextView[@text='Marital Status'])");
		return element;

	}

	public WebElement countryDropdownTextContactFilters() {
		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("(//android.widget.TextView[@text='Country'])");
		return element;

	}

	public WebElement countryGrewUpInDropdownTextContactFilters() {
		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("(//android.widget.TextView[@text='Country Grew up in'])");
		return element;

	}

	@FindBy(id = "com.shaadi.android:id/tv_more_filter")
	public WebElement moreFiltersContactFilters;

	@FindBy(id = "com.shaadi.android:id/search")
	public WebElement saveButtonContactFilter;
	
	@FindBy(id = "com.shaadi.android:id/btn_save")
	public WebElement btn_saveContactFilter;

	@FindBy(id = "com.shaadi.android:id/tv_title")
	public WebElement matchesAsPerYour;

	@FindBy(id = "com.shaadi.android:id/ll_most_pm_filter")
	public WebElement refineButton;

	@FindBy(id = "com.shaadi.android:id/tv_include_more_matches")
	public WebElement includeMoreMatches;

	@FindBy(id = "com.shaadi.android:id/sw_most_preferred")
	public WebElement toggleButton;

	@FindBy(id = "com.shaadi.android:id/rv_premium_carousal")
	public WebElement premiumCarousal;

	@FindBy(id = "com.shaadi.android:id/tv_profile_membership")
	public WebElement plusSign;

	@FindBy(id = "com.shaadi.android:id/tv_premium_header_name")
	public WebElement carousalName;

	@FindBy(id = "com.shaadi.android:id/btn_morph_connect_now")
	public WebElement connectCarousal;

	@FindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement connectNow;

	@FindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic")
	public WebElement likeThisProfile;

	@FindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement contactHimDirectly;

	@FindBy(id = "com.shaadi.android:id/btnUpgrade")
	public WebElement upgrade;

	@FindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement viewContact;

	@FindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement writeMessage;

	@FindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement invitationSent;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public WebElement matchesGotit;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	public WebElement dismissButton;

	@FindBy(id = "com.shaadi.android:id/SimilarProfile__tv_profile_count")
	public WebElement suggestedProfile;

	@FindBy(id = "com.shaadi.android:id/tv_premium_header_name")
	public WebElement myMatchesCarousalSeeAll;

	public WebElement premiumCarousalSeeAll() {

		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("//android.widget.TextView[@text='See All']");
		return element;

	}

	

	@FindBy(className = "android.widget.LinearLayout")
	public List<WebElement> dropdownOptons;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMyShaadi")
	public WebElement ClickonMyShaadi;

	@AndroidFindBy(id = "com.shaadi.android:id/rl_settings_row")
	public List<WebElement> AccountSettings;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_messages_settings")
	public WebElement Messages;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_draft_title")
	public List<WebElement> ConnectMessageText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_draft_title")
	public List<WebElement> AcceptMessageText;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_edit")
	public List<WebElement> EditBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/lblConnect")
	public WebElement ConnectNowBtn;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement SendConnectBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/edtMessage")
	public WebElement ConnectDraftText;

	@iOSFindBy(id = "textviewText")
	@AndroidFindBy(id = "com.shaadi.android:id/edit_draft")
	public WebElement EditBox;

	@iOSFindBy(id = "buttonSave")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_save_draft")
	public WebElement SaveMessageBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_draft_content")
	public List<WebElement> DraftContentTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_draft_description")
	public List<WebElement> MsgInfo;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_draft_title")
	public List<WebElement> ReminderMessageText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_messages_settings_description")
	public WebElement MessagesSubText;

	@FindBy(className = "android.widget.RelativeLayout")
	public List<WebElement> contactFiltersparams;

	@FindBy(id = "com.shaadi.android:id/btnUnhide")
	public WebElement unHideNow;

	@FindBy(id = "com.shaadi.android:id/change_profile_status")
	public WebElement unHide;

	@FindBy(id = "android:id/button1")
	public WebElement okButton;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Your profile is currently hidden'])[1]")
	@FindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement profileCurrentlyHidden;
	
	
	@iOSFindBy(id = "buttonSeeAll_discovery_premium")
	public WebElement seeAllButtonIOS;
	
	@iOSFindBy(id = "Help & Support")
	//@AndroidFindBy(id = "")
	public  WebElement txtHelp;
	
	@iOSFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "com.shaadi.android:id/img_cancel")
	public WebElement imgVIPShaadiCancel;
	
	


}
