package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MatchesPageObjects extends BasePageActions {
	
	@AndroidFindBy(id = "com.shaadi.android:id/radioButton")
	public WebElement reportUserRadioButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Other misuse reasons')]")
	public WebElement Othermisusereasons;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Asking for money / scammer')]")
	public WebElement Askingformoneyscammer;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Is already married / engaged')]")
	public WebElement Isalreadymarriedengaged;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Has sent abusive Emails / Chats')]")
	public WebElement HassentabusiveEmailsChats;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Photos are fake or obscene')]")
	public WebElement Photosarefakeorobscene;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Phone number is incorrect')]")
	public WebElement Phonenumberisincorrect;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Multiple Profiles')]")
	public WebElement MultipleProfile;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Fake / Misleading Profile Information')]")
	public WebElement FakeMisleadingProfileInformation;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reason for Reporting']")
	@iOSFindBy(name = "Reason for reporting")
	public WebElement reasonForReporting;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text , 'Report')]")
	@iOSFindBy(id="Report Profile/Photo")
	public WebElement ReportProfile;
	
	@AndroidFindBy(accessibility  = "Navigate up")
	public WebElement paymentPageBackButton;

	@AndroidFindBy(id = "com.shaadi.android:id/button_first_cta")
	public WebElement btn_viewContact_DR;

	@AndroidFindBy(id = "com.shaadi.android:id/button_third_cta")
	public WebElement btn_connectNow_DR;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_other_messages")
	public WebElement blockedText_new;

	@AndroidFindBy(id = "com.shaadi.android:id/imageView_single_photo")
	public WebElement Dr_Image_free;

	@AndroidFindBy(id = "com.shaadi.android:id/lblActionDoneText")
	@iOSFindBy(id = "labelSectionSubTitle_blocked")
	public WebElement blockedText_miniProfile;

	@AndroidFindBy(id = "android:id/button2")
	@iOSFindBy(id = "OK")
	public WebElement btn_OK;

	@AndroidFindBy(id = "com.shaadi.android:id/btnUnblock")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonBlocked Member\"])[1]")
	public WebElement btn_unblock;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	@iOSFindBy(id = "arrow left white")
	public WebElement btn_back_recentlyViewed;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_upgrade_continue")
	public WebElement btn_UpgradeNow;

	@AndroidFindBy(id = "com.shaadi.android:id/chkTooltip")
	public WebElement connectRejectedToolTip;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_youher_filteredOut")
	public WebElement youAndHerFilteredOut;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaMessage")
	public WebElement connectRejectedText1;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaMessage_line2")
	public WebElement connectRejectedText2;

	@AndroidFindBy(id = "com.shaadi.android:id/imageView27")
	public WebElement ExclamationAfterConnect;

	@AndroidFindBy(id = "com.shaadi.android:id/Btn_Refine_Textview")
	public WebElement RefineSearchButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_go_premium")
	public WebElement goPremiumUprgadeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text ='Profiles you Ignored']")
	@iOSFindBy(id = "labelSectionSubTitle_ignored")
	public WebElement profilesYouIgnored;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text ='Profiles you Blocked']")
	@iOSFindBy(id = "labelSectionSubTitle_blocked")
	public WebElement profilesYouBlocked;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text ='Profiles you recently Viewed']")
	@iOSFindBy(id = "labelSectionSubTitle_recently_viewed")
	public WebElement profilesYouRecentlyViewed;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_upgrade_title")
	@iOSFindBy(name = "Upgrade to Premium")
	public WebElement upgradePageHeader;

	@iOSFindBy(id = "buttonBack")
	public WebElement btn_BackFromUpgrade;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_call_now")
	@iOSFindBy(id = "Call now")
	public WebElement callButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_whatsapp")
	@iOSFindBy(id = "WhatsApp")
	public WebElement whatsAppButton;

	@AndroidFindBy(id = "com.shaadi.android:id/et_send_sms")
	@iOSFindBy(id = "textviewInput")
	public WebElement sendMessagetextBox;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_call_now")
	public WebElement callNowButtonPremium;

	@FindBy(id = "com.shaadi.android:id/tvAge")
	public WebElement txt_ageSearchPage;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMinAge")
	public WebElement txt_minAgeSearchpage;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMaxAge")
	public WebElement txt_maxAgeSearchpage;

	@AndroidFindBy(id = "com.shaadi.android:id/tvHeight")
	public WebElement txt_heightSearchPage;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMinHeight")
	public WebElement txt_minHeightSearchpage;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMaxHeight")
	public WebElement txt_maxHeightSearchpage;

	@AndroidFindBy(xpath = "//*[contains(@text , 'Show')]")
	@iOSFindBy(id = "Don't show me this Profile again")
	public WebElement dd_ignoreProfile;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	public WebElement btn_dd_Cancel;

	@AndroidFindBy(xpath = "//*[@text ='Add to Shortlist']")
	@iOSFindBy(id = "Add to Shortlist")
	public WebElement dd_shortlistProfile;

	@AndroidFindBy(xpath = "//*[contains(@text , 'Report')]")
	@iOSFindBy(id = "Report Profile/Photo")
	public WebElement dd_reportProfile;

	// @AndroidFindBy(xpath = "//*[@text='Block this Profile']")
	@AndroidFindBy(xpath = "//*[contains(@text , 'Block')]")
	@iOSFindBy(id = "Block Profile")
	public WebElement dd_blockProfile;
	
	@AndroidFindBy(xpath = "//*[contains(@text , 'Unblock')]")
	@iOSFindBy(id = "Block Profile")
	public WebElement dd_UnblockProfile;

	@iOSFindBy(id = "Decline")
	public WebElement dd_DeclineProfile;

	@iOSFindBy(id = "arrow left white")
	public WebElement btn_backArrow;

	@AndroidFindBy(xpath = "//*[@text='Remove from Shortlist']")
	@iOSFindBy(id = "Remove from Shortlist")
	public WebElement dd_removeshortlist;

	@AndroidFindBy(xpath = "//*[@text='Search Options']")
	public WebElement searchOptionsText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_message_sent")
	public WebElement messageSentText;

	@AndroidFindBy(id = "com.shaadi.android:id/ib_options_details")
	@iOSFindBy(id = "profile options down arrow")
	public WebElement dropDownThreeDots;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_shaadi_chat")
	@iOSFindBy(id = "Shaadi Chat")
	public WebElement ShaadiChatButtonPhoneNumberHidden;

	@AndroidFindBy(id = "com.shaadi.android:id/rbIncomeDoesntMatter")
	public WebElement doesNotMatterSearchpageAndroid;

	@AndroidFindBy(xpath = "//*[@content-desc = 'Profile ID Search']")
	public WebElement ProfileIDSearchTabAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/btGotToProfile")
	public WebElement goToProfileButtonAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/etSearchById")
	public WebElement profileIDSearchAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/button4")
	public WebElement viewContactButtonOnListingPageAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/button6")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonConnect Now\"])[1]")
	public WebElement connectNowButtonOnListingPageAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement connectNowTextOnListingPageAndroid;

	@FindBy(id = "com.shaadi.android:id/camera")
	public WebElement btnCamera;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtHeading")
	public List<WebElement> txtProfilephoto;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_imgAvatar")
	public WebElement imgNoPhoto;

	@FindBy(id = "com.shaadi.android:id/imaglayoutProfileWithoutProfile_imgOptions")
	public WebElement photoCardOptions;

	@FindBy(id = "com.shaadi.android:id/imaglayoutProfileWithoutProfile_imgSheild")
	public WebElement photoCardSHeild;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtName")
	public WebElement txtName;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtOnlineStatus")
	public WebElement txtOnlineStatus;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtAgeAndHeight")
	public WebElement txtAgeAndHeight;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtLanguageReligion")
	public WebElement txtReligion;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtProfession")
	public WebElement txt_Profession;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtPlace")
	public WebElement txt_Place;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtButtonHeading")
	public WebElement txtButtonHeading;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_btnAddPhoto")
	public WebElement btnAddPhoto;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_txtHeading")
	public WebElement txtHeadingTwo;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_txtSubHeading")
	public WebElement txtSubHeadingTwo;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_imgProfileCardRight")
	public WebElement imgProfileRight;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_imgProfileCardLeft")
	public WebElement imgProfileLeft;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_imgLike")
	public WebElement imgLike;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_imgDislike")
	public WebElement imgDislike;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_imgAvatarRight")
	public WebElement imgAvatarRight;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_imgAvatarLeft")
	public WebElement imgAvatarLeft;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_btnAddPhoto")
	public WebElement btnAddPhotoTwo;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfileTwo_txtButtonHeading")
	public WebElement txtButtonHeadingTwo;

	@FindBy(id = "com.shaadi.android:id/layoutProfileWithoutProfile_txtSubHeading")
	public WebElement txtSubHeading;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement cameraAcceptButton;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_tab_home_title")
	public List<WebElement> todayMatchesCount;

	@AndroidFindBy(xpath = "//*[contains(@text , 'Today')]")
	public WebElement todayMatchesCount_DR;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement ToContactdirectlytext;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_connect_status")
	public WebElement connectSentText;

	@AndroidFindBy(xpath = "//*[@text = 'Connect Request sent']")
	public WebElement txt_connectSent;

	@AndroidFindBy(xpath = "//*[@text = 'Contact not viewed']")
	public WebElement txt_contactNotViewed;

	@AndroidFindBy(id = "com.shaadi.android:id/btnUpgrade")
	public WebElement UpgradeNowLink;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage")
	@iOSFindBy(name = "buttonLeftAction")
	public WebElement ShaadiChatCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMessage")
	@iOSFindBy(name = "labelLeft")
	public WebElement ShaadiChatText;

//	@iOSFindBy(id="Limit Exceeded")
//	@AndroidFindBy(xpath="//*[@id = 'com.shaadi.android:id/alertTitle']")
//	public WebElement tx_LimitExceeded;
//	
//	@AndroidFindBy(id = "android:id/button1")
//	@iOSFindBy(id = "Cancel")
//	public WebElement btn_Cancel;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWhatsapp")
	@iOSFindBy(name = "buttonCenterAction")
	public WebElement WhatsappCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_whatsapp")
	@iOSFindBy(name = "labelCenter")
	public WebElement WhatsappText;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaViewContact")
	@iOSFindBy(name = "buttonRightAction")
	public WebElement CallCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_view_contact")
	@iOSFindBy(name = "labelRight")
	public WebElement CallText;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonShaadiChat\"])[1]")
	public WebElement ShaadiChatCTA_OnProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonShaadi Chat\"])[1]")
	public WebElement ShaadiChatCTA_OnProfile_premium;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMessage")
	@iOSFindBy(name = "labelWhatsApp")
	public WebElement ShaadiChatText_OnProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWhatsapp")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonWhatsApp\"])[1]")
	public WebElement WhatsappCTA_OnProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_whatsapp")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value='WhatsApp']")
	public WebElement WhatsappText_OnProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaViewContact")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonCall\"])[1]")
	public WebElement CallCTA_OnProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_view_contact")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value='Call']")
	public WebElement CallText_OnProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/imgInvites")
	public WebElement inboxNav;

	@iOSFindBy(id = "imgClose.label")
	public WebElement closeUpgradeBanner;

	@AndroidFindBy(className = "androidx.appcompat.app.ActionBar$b")
	public List<WebElement> acceptedtab;

	@AndroidFindBy(id = "com.shaadi.android:id/item_inbox_profile_tv_name")
	public WebElement VerifyUserName;

	@AndroidFindBy(id = "com.shaadi.android:id/drop_down_options")
	public WebElement DropdownAccepted;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_exit_stack")
	public WebElement CloseStackicon;

	@iOSFindBy(id = "closeWhite")
	@AndroidFindBy(id = "com.shaadi.android:id/iv_cancel")
	public WebElement CloseIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/cpb_view_plan")
	@iOSFindBy(id = "buttonViewPlans")
	public WebElement ViewPlansOnBottomSheet;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_mobile_no")
	public WebElement MaskedNum;

	@iOSFindBy(name = "labelLeftDescription")
	public WebElement MaskedNum_partOne_iOS;

	@iOSFindBy(name = "labelPhone")
	public WebElement MaskedNum_partOne_iOS_B;

	@iOSFindBy(name = "labelRightDescription")
	public WebElement MaskedNum_partTwo_iOS;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_email")
	public WebElement MaskedEmail;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value='**********']")
	public WebElement MaskedEmail_partOne_iOS;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value='@gmail.com']")
	public WebElement MaskedEmail_partTwo_iOS;

	@iOSFindBy(id = "labelEmail")
	public WebElement MaskedEmail_partTwo_iOS_B;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_header")
	@iOSFindBy(id = "labelHeader")
	public WebElement BottomSheetText;

	@FindBy(id = "com.shaadi.android:id/design_bottom_sheet")
	public WebElement AppRatingLayer;

	@AndroidFindBy(id = "com.shaadi.android:id/textView7")
	public WebElement txtLayerheader;

	@iOSFindBy(className = "XCUIElementTypeStaticText")
	public List<WebElement> StaticText;

	@iOSFindBy(className = "XCUIElementTypeStaticText")
	public List<WebElement> StaticText1;

	@FindBy(id = "com.shaadi.android:id/etMaritalStatus")
	public WebElement maritialStatusDropdown;

	@FindBy(id = "Search")
	public WebElement search;

	@FindBy(id = "com.shaadi.android:id/rlMatches")
	public WebElement MyMatches;

//	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
//	public List<WebElement> actionBarItemSearch;

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	public List<WebElement> actionBarItemSearch;

	@FindBy(id = "com.shaadi.android:id/etMaritalStatus")
	public WebElement martialStatus;

	@FindBy(id = "com.shaadi.android:id/btn_apply")
	public WebElement applyButton;

	@FindBy(id = "com.shaadi.android:id/etReligion")
	public WebElement religion;

	@iOSFindBy(className = "XCUIElementTypeText")
	public List<WebElement> Text1;

	@iOSFindBy(className = "XCUIElementTypeText")
	public List<WebElement> Text;

	@FindBy(id = "com.shaadi.android:id/etCommunity")
	public WebElement community;

	@FindBy(id = "com.shaadi.android:id/etMotherTongue")
	public WebElement motherTongue;

	@FindBy(id = "com.shaadi.android:id/etManglikChevvaiDosham")
	public WebElement manglik;

	@FindBy(id = "com.shaadi.android:id/etCountryLivingIn")
	public WebElement country;

	@FindBy(id = "com.shaadi.android:id/etState")
	public WebElement state;

	@FindBy(id = "com.shaadi.android:id/etCountryGrewIN")
	public WebElement countryGrewUpIn;

	@FindBy(id = "com.shaadi.android:id/etPhotoSettings")
	public WebElement photoSettings;

	@FindBy(id = "com.shaadi.android:id/tvMoreSearchOptions")
	public WebElement moreSearchOptions;

	@FindBy(id = "com.shaadi.android:id/etEducation")
	public WebElement education;

	@FindBy(id = "com.shaadi.android:id/etEducationArea")
	public WebElement educationArea;

	@FindBy(id = "com.shaadi.android:id/etWorkingWith")
	public WebElement workingWith;

	@FindBy(id = "com.shaadi.android:id/etProfessionalArea")
	public WebElement professionalArea;

	@FindBy(id = "com.shaadi.android:id/rbIncomeDoesntMatter")
	public WebElement incomeDoesntMatter;

	@FindBy(id = "com.shaadi.android:id/rbIncomeSpecifyRange")
	public WebElement incomeSpecifyRange;

	@FindBy(id = "com.shaadi.android:id/etCurrencyType")
	public WebElement currencyType;

	@FindBy(id = "com.shaadi.android:id/etIncomeFrom")
	public WebElement incomeFrom;

	@FindBy(id = "com.shaadi.android:id/etIncomeTo")
	public WebElement incomeTo;

	@FindBy(id = "com.shaadi.android:id/cbIncome")
	public WebElement cbIncomech;

	@FindBy(id = "com.shaadi.android:id/etDiet")
	public WebElement diet;

	@FindBy(id = "com.shaadi.android:id/etSmoke")
	public WebElement smoke;

	@FindBy(id = "com.shaadi.android:id/etDrink")
	public WebElement drink;

	@FindBy(id = "com.shaadi.android:id/etBodyType")
	public WebElement bodyType;

	@FindBy(id = "com.shaadi.android:id/etSkinTone")
	public WebElement skinType;

	@FindBy(id = "com.shaadi.android:id/etProfileCreatedBy")
	public WebElement ProfileCreatedBy;

	@FindBy(id = "com.shaadi.android:id/etHasHoroscope")
	public WebElement HasHoroscope;

	@FindBy(id = "com.shaadi.android:id/scIncludeFilteredMeOutProfile")
	public WebElement IncludeFilteredMeOutProfile;

	@FindBy(id = "com.shaadi.android:id/scIncludeAlreadyViewedProfile")
	public WebElement IncludeAlreadyViewedProfile;

	@FindBy(id = "com.shaadi.android:id/btSearchNow")
	public WebElement SearchNow;

	@iOSFindBy(id = "labelTitle")
	public WebElement txt_noResult;

	@iOSFindBy(name = "REFINE")
	public WebElement btn_Refine;

	public MobileElement religionDropDownMobileElement() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etReligion"));
		return categories;
	}

	public MobileElement MaritalDropDownMobileElement() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etMaritalStatus"));
		return categories;
	}

	public MobileElement searchOptions() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/tvAge"));
		return categories;
	}

	public MobileElement educationAndProfessionalDetails() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/tvEducationProfessionalDetails"));
		return categories;
	}

	public MobileElement cityDropdown() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etCity"));
		return categories;
	}

	public MobileElement professDropdown() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etProfessionalArea"));
		return categories;
	}

	public MobileElement educationDropdown() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etEducation"));
		return categories;
	}

	public MobileElement workingAs() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etWorkingAs"));
		return categories;
	}

	public MobileElement countryLivingInMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etCountryLivingIn"));
		return categories;
	}

	public MobileElement communityMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/tvCommunity"));
		return categories;
	}

	public MobileElement cityMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etCity"));
		return categories;
	}

	public MobileElement photoSettingsMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etPhotoSettings"));
		return categories;
	}

	public MobileElement residencystatusMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etResidencyStatus"));
		return categories;
	}

	public MobileElement dietMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etDiet"));
		return categories;
	}

	public MobileElement professionMobile() {
		MobileElement categories = ((AndroidDriver<AndroidElement>) driver)
				.findElement(MobileBy.id("com.shaadi.android:id/etProfessionalArea"));
		return categories;
	}

	@FindBy(id = "com.shaadi.android:id/btSearchNow")
	public WebElement searchNowButton;

	@FindBy(id = "com.shaadi.android:id/scIncludeFilteredMeOutProfile")
	public WebElement IncludeProfilesthathaveFilteredmeoutaswell;

	@FindBy(id = "com.shaadi.android:id/scIncludeAlreadyViewedProfile")
	public WebElement IncludeProfilesthatIhavealreadyviewed;

	@FindBy(className = "android.widget.ImageButton")
	public WebElement backButton;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_images")
	public WebElement DRprofilePage;

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement ViewContactTopPremium;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement WriteMsgTopPremium;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement ConnectNowTopPremium;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement SendPremiumMsg;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	public WebElement NextArrowBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_prev")
	@iOSFindBy(id = "buttonMoveToPreviousProfile")
	public WebElement PrevArrowBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_header")
	public WebElement ViewContactHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(id = "lblHyperlinkedHeader.label")
	public WebElement InvitationSentTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(id = "Your Request may not be visible in his Inbox.")
	public WebElement filtered_out_Txt;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement YesBtn;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public List<WebElement> Chatback;

	@AndroidFindBy(className = "android.widget.ImageButton")
	@iOSFindBy(id = "arrow left white")
	public WebElement ChatbackButton;

	@FindBy(id = "com.shaadi.android:id/msgtext")
	@iOSFindBy(xpath = "//XCUIElementTypeTextView[@value='Type a Message']")
	public WebElement ClickWriteMsg;

	@FindBy(id = "com.shaadi.android:id/send_btn")
	public WebElement SendMsgBtn;

	@FindBy(id = "com.shaadi.android:id/messageDaily10")
	public WebElement ThankyouPremium;

	@FindBy(id = "com.shaadi.android:id/goBackText")
	public WebElement GobackToRecommendations;

	@FindBy(id = "com.shaadi.android:id/layoutViewContact_btnMessage")
	public WebElement SMSicon;

	@FindBy(id = "android:id/button1")
	public WebElement sendsmsok;

	@FindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement BottomViewContactPremium;

	@FindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement BottomWriteMsgPremium;

	@FindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement BottomConnectNowPremium;

	@FindBy(id = "com.shaadi.android:id/tv_view_horoscope")
	public WebElement ViewDetails;

	@FindBy(id = "com.shaadi.android:id/textView50")
	public WebElement EmptyCaseText;

	@FindBy(id = "com.shaadi.android:id/textView51")
	public WebElement EmptyCaseText1;

	@FindBy(id = "com.shaadi.android:id/noDR_btnSearch")
	public WebElement SearchNowBtn;// Search Now

	@FindBy(id = "com.shaadi.android:id/tv_title")
	public WebElement OnMyMatchesPage;

	@FindBy(id = "com.shaadi.android:id/ll_todays_matches")
	public WebElement GoToDR;

	@FindBy(className = "com.shaadi.android:id/btnGotIt")
	public WebElement MyMatchesGotIt;

	@AndroidFindBy(id = "com.shaadi.android:id/fragProfleDetail_chip")
	public WebElement Capsule;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_matches_count")
	public WebElement DRcount;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic")
	public WebElement LikeThisProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelProfileName")
	public WebElement UserName;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelDisplayName_0")
	public WebElement UserName_OnListing;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelDisplayName_1")
	public WebElement UserName_OnListing_FreeUser;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'labelDisplayName_')]")
	public WebElement UserName_NearMe;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	public WebElement AgeHeight;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	public WebElement profession;

	@AndroidFindBy(id = "com.shaadi.android:id/tv__contact_details")
	public WebElement ContactDetailsHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/ll_astro_items")
	public List<WebElement> MaskedNumber;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_bottom_contact_details_one")
	public WebElement UpgradeNowToViewDetails;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	@iOSFindBy(id = "buttonMoreMenu_0")
	public WebElement DropDownArrow;

	@AndroidFindBy(id = "android:id/title")
	@iOSFindBy(className = "XCUIElementTypeButton")
	public List<WebElement> DropDownValue;

	@AndroidFindBy(id = "android:id/button1")
	@iOSFindBy(id = "Confirm")
	public WebElement OKblock;

	@iOSFindBy(id = "Limit Exceeded")
	@AndroidFindBy(xpath = "//*[@id = 'com.shaadi.android:id/alertTitle' and @text = 'Limit Exceeded']")
	public WebElement tx_LimitExceeded;

	@AndroidFindBy(id = "android:id/button1")
	@iOSFindBy(id = "Cancel")
	public WebElement btn_Cancel;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelBlocked Member\"])[1]")
	public WebElement BlockedMemberTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/rl_user_album")
	@iOSFindBy(id = "buttonPhotoAlbum_1")
	public WebElement PicCount;

	@AndroidFindBy(id = "com.shaadi.android:id/button3")
	@iOSFindBy(id = "buttonCTA")
	public WebElement AlbumConnect;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(id = "lblHyperlinkedHeader.label")
	public WebElement InvitationSent;

	@AndroidFindBy(id = "com.shaadi.android:id/textView40")
	public WebElement ThankYouPage;

	@AndroidFindBy(id = "com.shaadi.android:id/textView40")
	public WebElement connectNowText;

	@AndroidFindBy(id = "com.shaadi.android:id/btnUpgrade")
	public WebElement ThankYouPageUpgrade;

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement ViewContactAfterConnect;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement WriteMsgtAfterConnect;

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement ViewContactAfterBottomConnect;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement WriteMsgtAfterBottomConnect;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement ConnectNowBottomCTA;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_profile_cta_connect_now")
	public WebElement ConnectNowBottomText;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement ConnectNowTopCTA;

	@iOSFindBy(accessibility = "More Matches")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"More Matches\")")
	public WebElement MoreMatches;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Today's Matches\")")
	public WebElement todayMatchesTabAndroid;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"New\")")
	public WebElement newMatchesTabAndroid;

	@iOSFindBy(xpath = "//XCUIElementTypeText[contains(@name, \"Recent Visitors\")]")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Recent Visitors\")")
	public WebElement RecentVisitors;

	@iOSFindBy(xpath = "//XCUIElementTypeText[contains(@name, \"Members you may like\")]")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Members you may like\")")
	public WebElement MembersYouMayLike;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Members you may like\").fromParent(new UiSelector().resourceId(\"com.shaadi.android:id/layout_PremiumMatches\")).childSelector(new UiSelector().resourceId(\"com.shaadi.android:id/btnSeeAll\"))")
	public WebElement SeeAll_MembersYouMayLike;

	@iOSFindBy(xpath = "//XCUIElementTypeText[contains(@name, \"Members looking for me\")]")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Members looking for me\")")
	public WebElement MemberslookingforMe;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	public List<WebElement> SectionTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_subtitle")
	public List<WebElement> SectionSubTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/imageView12")
	public List<WebElement> imgProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/lblName")
	public List<WebElement> lblName;

	@AndroidFindBy(id = "com.shaadi.android:id/lblDetails1")
	public List<WebElement> lblDetails1;

	@AndroidFindBy(id = "com.shaadi.android:id/lblDetails2")
	public List<WebElement> lblDetails2;

	@AndroidFindBy(id = "com.shaadi.android:id/lblDetails3")
	public List<WebElement> lblDetails3;

	@AndroidFindBy(id = "com.shaadi.android:id/llConnect")
	public List<WebElement> llConnect;

	@iOSFindBy(accessibility = "Members who recently Viewed your Profile")
	public WebElement RecentVisitorSubsection;

	@AndroidFindBy(id = "com.shaadi.android:id/progress_bar")
	public WebElement ProgressBar;

	@iOSFindBy(accessibility = "Connect Now")
	public List<WebElement> ConnectNow;

	@AndroidFindBy(id = "com.shaadi.android:id/profile_card")
	public WebElement ProfilePage;

	@iOSFindBy(id = "labelProfileName")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	public WebElement ProfilePageName;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	public WebElement ProfilePageHeight;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_community")
	public WebElement ProfilePageCommunity;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	public WebElement ProfilePageLocation;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_back")
	@iOSFindBy(id = "btnBackBarButtonItem")
	public WebElement ProfilePageBack;

	@iOSFindBy(id = "arrow left white")
	public WebElement ProfilePageBack1;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_prev")
	@iOSFindBy(id = "previous navigator")
	public WebElement ProfilePagePrev;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	@iOSFindBy(id = "next navigator")
	public WebElement ProfilePageNext;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_onlinestatus")
	@iOSFindBy(id = "buttonProfileOnline")
	public WebElement OnlineStatus;

	@AndroidFindBy(id = "com.shaadi.android:id/msg")
	public WebElement ChatMessage;

	@AndroidFindBy(id = "com.shaadi.android:id/chat_header_view")
	@iOSFindBy(id = "ChatWindowView")
	public WebElement ChatHeaderView;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_youher")
	@iOSFindBy(id = "buttonProfileMatchingData")
	public WebElement ConversationStarter;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"You &\")")
	@iOSFindBy(id = "labelTitle")
	public WebElement ConversationStarterTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/view_gradient")
	public WebElement RecentVisitorsListProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/rl_profile_card_container")
	public WebElement ProfilePageCard;

	@iOSFindBy(id = "See All")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_see_all")
	public List<WebElement> SeeAll;

	@iOSFindBy(id = "See All")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_see_all")
	public WebElement seeAllButton;

	@AndroidFindBy(id = "com.shaadi.android:id/btnGotIt")
	public WebElement GotIt;

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeText")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Profiles\")")
	public WebElement RecentVisitorsListCount;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public WebElement matchesGotit;

	@FindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	public WebElement dismissButton;

	@FindBy(id = "com.shaadi.android:id/tv_title")
	public WebElement matchesAsPerYour;

	@FindBy(id = "com.shaadi.android:id/textView_sub_title")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Shortlisted Members\"])[1]")
	public WebElement myMatchesHeaderTextAndroid;
	
	@iOSFindBy(id = "Matching your Preferences")
	public WebElement matchingPreferences;

	@FindBy(id = "com.shaadi.android:id/ll_most_pm_filter")
	public WebElement refineButton;

	@FindBy(id = "com.shaadi.android:id/textView_matches_refine")
	@iOSFindBy(id="REFINE")
	public WebElement myMatchesRefineButtonAndroid;

	@FindBy(id = "com.shaadi.android:id/fab_matches_refine")
	public WebElement refineButtonOnListing;

	@FindBy(id = "com.shaadi.android:id/tv_include_more_matches")
	public WebElement includeMoreMatches;

	@FindBy(id = "com.shaadi.android:id/sw_most_preferred")
	public WebElement toggleButton;

	@FindBy(id = "com.shaadi.android:id/switch_more_matches")
	public WebElement toggleButtonAndroid;

	@FindBy(id = "com.shaadi.android:id/tv_more_matches_status")
	public WebElement getMoreMatchesButtonAndroid;

	@FindBy(id = "com.shaadi.android:id/rv_premium_carousal")
	public WebElement premiumCarousal;

	@FindBy(id = "com.shaadi.android:id/tv_profile_membership")
	public WebElement plusSign;

	@FindBy(id = "com.shaadi.android:id/tv_premium_header_name")
	public WebElement carousalName;

	@FindBy(id = "com.shaadi.android:id/btn_morph_connect_now")
	public WebElement connectCarousal;

	@FindBy(id = "android:id/button1")
	public WebElement sendButton;

	@FindBy(id = "com.shaadi.android:id/btn_send_message")
	@iOSFindBy(id = "buttonAction")
	public WebElement sendMessageButtonAndroid;

	@FindBy(id = "com.shaadi.android:id/constraint_layout_main")
	public List<WebElement> premiumlayout;

	@FindBy(id = "com.shaadi.android:id/btn_morph_connect_now")
	public List<WebElement> connectCarousalList;

	public WebElement premiumCarousalSeeAll() {

		WebElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByXPath("//android.widget.TextView[@text='See All']");
		return element;

	}

	@FindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic")
	public WebElement likeThisProfile;

	@FindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement likeThisProfileListingPageAndroid;

	@FindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement connectNow;

	@FindBy(xpath = "//*[@text = 'Connect Now']")
	public WebElement btn_ConnectNowText;

	@FindBy(id = "com.shaadi.android:id/SimilarProfile__tv_profile_count")
	public WebElement suggestedProfile;

	@FindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement viewContact;

	@FindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement writeMessage;

	@FindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement invitationSent;

	@FindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement contactHimDirectly;

	@FindBy(id = "com.shaadi.android:id/btnUpgrade")
	public WebElement upgrade;

	@iOSFindBy(id = "buttonSubNav3")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My Matches (99+)\")")
	public WebElement MyMatchestabIOS;

	@iOSFindBy(id = "buttonSubNav4")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Near Me (99+)\")")
	public WebElement NearMetabIOS;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	@iOSFindBy(name = "Members around your city")
	public WebElement NearMeHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_sub_title")
	public WebElement nearMeHeaderAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_sub_title")
	@iOSFindBy(name = "Profiles you recently Viewed")
	public WebElement subTitleText;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_sub_title")
	@iOSFindBy(name = "Profiles you Ignored")
	public WebElement subTitleText_1;

	@AndroidFindBy(id = "com.shaadi.android:id/textView_sub_title")
	@iOSFindBy(name = "Profiles you Blocked")
	public WebElement subTitleText_2;

	@iOSFindBy(id = "Refine")
	public WebElement RefineBtnIOS;

	@iOSFindBy(id = "Near Me")
	public WebElement NearMeFieldIOS;

	@iOSFindBy(name = "REFINE")
	public WebElement REFINEBtn;

	@iOSFindBy(name = "Refine")
	public MobileElement RefineText;

	@iOSFindBy(id = "buttonDualCTARight")
	public WebElement WriteMsgCTAonlisting;

	@iOSFindBy(id = "btnSearch.label")
	public WebElement ApplyCTAonRefine;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Near Me\")")
	@iOSFindBy(className = "new UiSelector().textContains(\"Near Me\")")
	public WebElement NearMeTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My Matches\")")
	@iOSFindBy(id = "buttonSubNav3")
	public WebElement myMatchesTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"New\")")
	public WebElement newTab;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Recently Viewed\")")
	@iOSFindBy(id = "buttonSubNav7")
	public WebElement recentlyViewedTab;

	@iOSFindBy(className = "XCUIElementTypeSegmentedControl")
	public WebElement SC;

	@iOSFindBy(id = "buttonChatBubble")
	public WebElement ChatBubble;

	@iOSFindBy(id = "filter_dark")
	public WebElement filtericon;

	@iOSFindBy(id = "drawer arrow")
	public WebElement drawerBackArrow;

	@iOSFindBy(id = "buttonLeftCaption")
	public WebElement ViewContactCTAonlisting;

	@iOSFindBy(id = "buttonYouAndProspect")
	public WebElement buttonYouAndProspect;

	@iOSFindBy(id = "labelSecondLeft")
	public WebElement labelSecondLeft;

	@iOSFindBy(id = "labelDisplayName")
	public WebElement UserNameonList;

	@iOSFindBy(id = "buttonMoreMenu_2")
	public MobileElement buttonMoreMenu;

	@iOSFindBy(xpath = "//XCUIElementTypeText[@name=\"labelDisplayName\"])[1]")
	public MobileElement NameonlIST;

	@iOSFindBy(id = "buttonSingleCTARight")
	public WebElement buttonSingleCTARight;

	@iOSFindBy(id = "Block Profile")
	public WebElement BlockProfileOption;

	@iOSFindBy(id = "Add to Shortlist")
	public WebElement AddtoShortlistOption;

	@iOSFindBy(id = "Report Profile/Photo")
	public WebElement ReportProfilePhotoOption;

	@iOSFindBy(id = "Cancel")
	public WebElement CancelOption;

	@iOSFindBy(className = "XCUIElementTypeText")
	public WebElement TypeCell;

	@AndroidFindBy(id = "android:id/title")
	@iOSFindBy(className = "XCUIElementTypeButton")
	public List<WebElement> DropdownText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_text")
	@iOSFindBy(name = "No Photo Added")
	public WebElement NoPhotoAddedTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/button6")
	@iOSFindBy(className = "buttonRightActionForConnectView")
	public WebElement ConnectOnListBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement txt_ConnectBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/rl_user_album")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'buttonPhotoAlbum_')]")
	public WebElement PhotoAlbum;

	@AndroidFindBy(id = "com.shaadi.android:id/rl_user_album")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name= 'buttonPhotoAlbum_3']")
	public WebElement PhotoAlbum_trial;

	@AndroidFindBy(id = "com.shaadi.android:id/rl_user_album")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name= 'labelSecondRight_3']")
	public WebElement location_trial;

	@AndroidFindBy(id = "com.shaadi.android:id/textView31")
	@iOSFindBy(id = "labelCTA")
	public WebElement likethisprofiletxt;

	@iOSFindBy(id = "labelLikeThisProfileForConnectView")
	public WebElement likethisprofiletxtiOS;

	@iOSFindBy(id = "labelConnectView")
	public WebElement ConnectListingiOStEXT;

	@iOSFindBy(id = "buttonRightActionForConnectView")
	public WebElement ConnectListingiOSBtn;

	@iOSFindBy(id = "arrow down dark")
	public WebElement SuggestedProfBariOS;

	@iOSFindBy(className = "XCUIElementTypeCell")
	public WebElement OpenProfile;

	@iOSFindBy(id = "buttonUpgrade")
	public WebElement buttonUpgradeiOS;

	@iOSFindBy(id = "buttonCentreActionForUpgradeView")
	public WebElement ViewContactBtniOS;

	@iOSFindBy(id = "labelCentreActionForUpgradeView")
	public WebElement ViewContactTextiOS;

	@iOSFindBy(id = "buttonRightActionForUpgradeView")
	public WebElement WriteMsgBtniOS;

	@iOSFindBy(id = "labelRightActionForUpgradeView")
	public WebElement WriteMsgTextiOS;

	@iOSFindBy(id = "buttonClose")
	@AndroidFindBy(id = "Close")
	public WebElement CloseUpgradePopUp;

	@AndroidFindBy(id = "com.shaadi.android:id/button3")
	@iOSFindBy(id = "buttonCTA")
	public WebElement ConnectFrmAlbumBtn;

	@iOSFindBy(id = "Refine")
	public WebElement RefineBtn;

	@iOSFindBy(id = "Near Me")
	public WebElement NearMeField;

	@AndroidFindBy(id = "com.shaadi.android:id/btnUpgradeNow")
	@iOSFindBy(id = "btnHyperLinked.label")
	public WebElement UpgradeBtn;

	@AndroidFindBy(className = "com.shaadi.android:id/ll_most_pm_filter")
	public List<WebElement> Refine;

	@AndroidFindBy(id = "com.shaadi.android:id/bt_req_photo")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'buttonPhotoAdd_')]")
	public WebElement ReqPhotoBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/button6")
	public WebElement btnConnectOnList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Conversation Starters']")
	public WebElement txt_ConvoStarter;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement BlockOKBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_text")
	@iOSFindBy(id = "Upgrade to View Photo")
	public WebElement VisbleToPremiumTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_gender_check")
	public WebElement ViewPlansPhotobtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_text")
	public WebElement VisibleOnAcceptBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	@iOSFindBy(id = "labelFirstLeft_1")
	public WebElement UserAgeHeight;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_community")
	@iOSFindBy(id = "labelSecondLeft_1")
	public WebElement UserCommunity;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_youher")
	@iOSFindBy(name = "You & Him")
	public WebElement YouAndHer;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	@iOSFindBy(id = "labelTitle")
	public WebElement YouAndHerHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/name")
	@iOSFindBy(className = "ShYouAndHerCellSectionHeaderID")
	public List<WebElement> YouAndHerValue;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_career")
	@iOSFindBy(id = "labelFirstRight_1")
	public WebElement UserCareer;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	@iOSFindBy(id = "labelSecondRight_1")
	public WebElement UserLocation;

	@AndroidFindBy(id = "com.shaadi.android:id/imb_verification")
	@iOSFindBy(id = "buttonTrustBadge_3")
	public WebElement TrustBadgeIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_verification")
	@iOSFindBy(id = "buttonTrustBadge_2")
	public WebElement trustBadgeButtonAndroid;

	@iOSFindBy(id = "buttonTrustBadge_1")
	public WebElement TrustBadgeGrayIcon;

	@iOSFindBy(id = "trustBadgeGreen")
	public WebElement TrustBadgeGreenIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_verification1")
	public WebElement TrustBadgeValue1;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public List<WebElement> ChatBack;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_verification2")
	public WebElement TrustBadgeValue2;

	@AndroidFindBy(id = "com.shaadi.android:id/imb_verification3")
	public WebElement TrustBadgeValue3;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	@iOSFindBy(id = "profile options down arrow")
	public WebElement DropDownIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/ib_options")
	public WebElement dropDownIconAndroid;

	@iOSFindBy(id = "profile option")
	public WebElement DropDownIconiOS;

	@AndroidFindBy(className = "android.widget.LinearLayout")
	public List<WebElement> DropDownValues;

	@AndroidFindBy(id = "com.shaadi.android:id/imgMatches")
	public WebElement MyMatchesNav;

	@AndroidFindBy(id = "com.shaadi.android:id/lblSectionSubTitle")
	public WebElement IgnoredProfileTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/lblName")
	public WebElement IgnoredUserName;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_like_this_profile_header")
	public WebElement IgnoredMemTxt;// Ignored Member

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_message")
	public WebElement ChangedMindTxt;// Changed your mind?

	@AndroidFindBy(id = "com.shaadi.android:id/tv_cta_clickable_text")
	public WebElement UnblockHim;

	@AndroidFindBy(id = "com.shaadi.android:id/alertTitle")
	@iOSFindBy(name = "Oops!")
	public WebElement OopsTxt;// Oops!!

	@AndroidFindBy(id = "android:id/message")
	@iOSFindBy(id = "Member can be unblocked only after 48 hours.")
	public WebElement BlockPopupTxt; // Member can be unblocked only after 48 hours

	@AndroidFindBy(id = "com.shaadi.android:id/alertTitle")
	@iOSFindBy(id = "OK")
	public WebElement OkbTN;// OK

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement ViewContactListing;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement WriteMsgListing;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_header")
	public WebElement UpgradePopUptxt;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_plan")
	public WebElement ViewPlansCTA;

	@iOSFindBy(id = "arrow left white")
	public WebElement iOSbackArrow;

	@AndroidFindBy(id = "com.shaadi.android:id/imgButtonCancel")
	public WebElement ClosePopUp;

	@AndroidFindBy(id = "com.shaadi.android:id/btnUpgrade")
	public WebElement UpgradeOnminicard;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	@iOSFindBy(id = "buttonMoveToNextProfile")
	public WebElement SwipeNext;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_prev")
	@iOSFindBy(name = "buttonMoveToPreviousProfile")
	public WebElement SwipePrev;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement ToContactHimHerTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/SimilarProfile__tv_profile_count")
	public WebElement SuggestedProfHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/fl_border")
	public WebElement OpenprofilePge;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_images")
	public WebElement OpenprofilePgePremium;

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement WriteMsgPremium;

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement ViewContactPremium;

	@FindBy(id = "com.shaadi.android:id/send_btn")
	public WebElement SendMsgBtn1;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtIgnored")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelLikeThisProfileForConnectView\"])[1]")
	public WebElement IgnoredMemText;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtChangeYourMind")
	public WebElement ChangedYrMindTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	public WebElement BlockedMemText;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaHeading")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"lblHyperlinkedHeader.label\"])[1]")
	public WebElement IgnoredMemPremium;

	@AndroidFindBy(id = "com.shaadi.android:id/txtCtaMessage")
	public WebElement ChangedTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/profile_name")
	public WebElement ReportingUser;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic")
	public WebElement LikeprofileTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	public WebElement LikeprofileTxt_premium;

	@AndroidFindBy(id = "com.shaadi.android:id/textView33")
	public WebElement WriteMsgHeader;

	@AndroidFindBy(id = "com.shaadi.android:id/edtMessage")
	public WebElement PremiumMsg;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement SendBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement ViewContactOnAlbum;

	@AndroidFindBy(id = "android:id/message")
	public WebElement ViewContactOnPermissn;

	@AndroidFindBy(id = "android.widget.Button")
	public List<WebElement> ViewNumYesBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutViewContact_btnOK")
	public WebElement OKbtn;

	@AndroidFindBy(id = "com.shaadi.android:id/textView1")
	public WebElement NoMatchesTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/textView2")
	public WebElement NoMatchesTxt1;

	@AndroidFindBy(id = "com.shaadi.android:id/modifysearchbtn")
	public WebElement DiscoverMatches;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	public WebElement MembersUmayLike;

	@AndroidFindBy(id = "com.shaadi.android:id/fl_border")
	public WebElement OpenProfilePage;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"New\")]")
	@AndroidFindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> newMatchesTab;

	@AndroidFindBy(className = "android.widget.TextView")
	public List<WebElement> txtRefineYourMatches; // Refine your matches

	@AndroidFindBy(className = "android.widget.TextView")
	public List<WebElement> txtRefineYourResults;// Tap to refine your results by Education, Profession, Location
													// & much more

	@AndroidFindBy(id = "com.shaadi.android:id/textView")
	public WebElement txtRefine; // Refine

	@AndroidFindBy(id = "com.shaadi.android:id/btnGotIt")
	public WebElement btnGotIt; // GOT IT

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	@iOSFindBy(id = "labelSection_recently_viewed")
	public WebElement tvTitle_RV;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	@iOSFindBy(id = "labelSection_ignored")
	public WebElement tvTitle_Ignored;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	@iOSFindBy(id = "labelSection_blocked")
	public WebElement tvTitle_Blocked;

	@iOSFindBy(className = "XCUIElementTypeNavigationBar")
	public WebElement txtNavBar;

	@AndroidFindBy(className = "android.widget.TextView")
	public List<WebElement> lnkRefine;

	@AndroidFindBy(id = "com.shaadi.android:id/img_mostpm_filterbtn")
	public WebElement imgRefineIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/ll_most_pm_filter")
	public WebElement lnkRefineIcon; // Refine plus icon

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	public WebElement imgOptnSelectionIcon;// Icon to take an action

	@AndroidFindBy(id = "com.shaadi.android:id/imb_verification")
	public WebElement imgIDVerificationIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_piccount")
	@iOSFindBy(id = "buttonPhotoAlbum_1")
	public WebElement tvPicCount;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_photo_count")
	public WebElement profilePhotoCountAndroid;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	@iOSFindBy(id = "labelDisplayName_1")
	public WebElement tvListingUserName;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_age_height")
	@iOSFindBy(id = "labelFirstLeft_1")
	public WebElement tvListingAgeHeight;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_community")
	@iOSFindBy(id = "labelSecondLeft_1")
	public WebElement tvListingCommunity;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_onlinestatus")
	public WebElement tvListingOnlineStatus;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_youher")
	public WebElement tvListingYouHer;/// Not Compulsory element

	@AndroidFindBy(id = "com.shaadi.android:id/tv_career")
	public WebElement tvListingCareer;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_location")
	@iOSFindBy(id = "labelSecondRight_1")
	public WebElement tvListingLocation;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic")
	public WebElement tvListingLikeThisProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement btnListingConnectNow;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerUpgrade_txtSubject")
	public WebElement txtListingBannerSubject; // Get 10 times better response by calling directly!

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerUpgrade_btnViewPlans")
	public WebElement btnListingViewPlans; // View Plans

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerUpgrade_txtOffers")
	public WebElement txtListingOffer; // Save up to 55% today!

	@AndroidFindBy(id = "android:id/title")
	public WebElement txtTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	public WebElement optnSelection;

	@AndroidFindBy(id = "com.shaadi.android:id/imb_verification")
	public WebElement imbIDVerification;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_verification1")
	public WebElement tvIDVerification; // Mobile number Verified

	@AndroidFindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption")
	@iOSFindBy(id = "labelShaadiChat")
	public WebElement txtCaption; // To contact him directly

	@AndroidFindBy(id = "com.shaadi.android:id/btn_next")
	public WebElement btnNext;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_prev")
	public WebElement btnPrevious;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonRightActionForConnectView\"])[1]")
	public WebElement btnConnectNowProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Changed your mind? Connect Now\"])[1]")
	public WebElement btnConnectNowProfile_Premium;

	@iOSFindBy(xpath = "(//XCUIElementTypeText[@name=\"labelLikeThisProfileForConnectView\"])[1]")
	public List<WebElement> likeThisProfileIOS;

	@iOSFindBy(id = "lblViewContact")
	public WebElement viewContactIOS;

	@iOSFindBy(xpath = "(//XCUIElementTypeText[@name=\"lblViewContact\"])[1]")
	public List<WebElement> viewContacts;

	@iOSFindBy(name = "btnConnectNow")
	public WebElement connectNowButton;

	@iOSFindBy(id = "profile option")
	public WebElement profileOptions;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"trustBadge\")]")
	@AndroidFindBy(className = "android.support.v7.app.ActionBar$Tab")
	public List<WebElement> trustBadge;

//

	@iOSFindBy(name = "Members who joined recently")
	public WebElement memberWhoJoinedrecently;

	@iOSFindBy(name = "buttonRightActionForConnectView")
	public WebElement connectNowSingleCta;

	@iOSFindBy(name = "buttonRightActionForUpgradeView")
	public List<WebElement> writeMessageFreeCTA;

	@iOSFindBy(name = "buttonCentreActionForUpgradeView")
	public List<WebElement> viewContactFreeCTA;

	@iOSFindBy(name = "buttonUpgrade")
	public List<WebElement> buttonUpgrade;

	@iOSFindBy(name = "btnWriteMessage")
	public WebElement writeMesageCTA;

	@iOSFindBy(name = "btnViewContact")
	public WebElement viewContactCTA;

	@iOSFindBy(id = "buttonSubNav1")
	public WebElement btnNewMatchesTab;

	@iOSFindBy(id = "buttonSubNav2")
	public WebElement btnNewMatchesTodays;

	@iOSFindBy(name = "viewBottomDock.label")
	@FindBy(id = "com.shaadi.android:id/btn_search")
	public WebElement btnSearchNow;

	@FindBy(id = "com.shaadi.android:id/img_cta_connect_now")
	public WebElement btnConnectNow;

	@FindBy(className = "com.shaadi.android:id/rl_cta_connect_layout")
	public List<WebElement> searchlistcardlayout;

	@iOSFindBy(id = "labelTitle_MaritalStatus")
	@FindBy(id = "com.shaadi.android:id/set_marital_status")
	public static WebElement dropDownMartialStatusList;

	@iOSFindBy(id = "labelOption_MaritalStatus")
	public WebElement opt_MaritialStatus;

	@iOSFindBy(id = "labelTitle_HaveChildren")
	public WebElement drodropDownChildStatusList;

	@iOSFindBy(id = "labelOption_PhotoSettings")
	@FindBy(id = "com.shaadi.android:id/set_photo")
	public WebElement dropDownPhotoSettingsList;

	@iOSFindBy(id = "labelTitle_Religion")
	@FindBy(id = "com.shaadi.android:id/set_religion")
	public static WebElement dropDownReligion;

	@iOSFindBy(id = "labelOption_Religion")
	public WebElement opt_Religion;

	@iOSFindBy(id = "labelTitle_MotherTongue")
	@FindBy(id = "com.shaadi.android:id/set_display_language")
	public WebElement dropDownMotherTongue;

	@iOSFindBy(id = "labelOption_MotherTongue")
	public WebElement opt_MotherTongue;

	@iOSFindBy(id = "labelTitle_Community")
	@FindBy(id = "com.shaadi.android:id/set_caste")
	public WebElement dropDownCommunity;

	@iOSFindBy(id = "labelTitle_Countrylivingin")
	@FindBy(id = "com.shaadi.android:id/set_country")
	public static WebElement dropDownCountry;

	@iOSFindBy(id = "labelOption_Countrylivingin")
	public WebElement opt_CountryLiving;

	@iOSFindBy(id = "labelTitle_Statelivingin")
	@FindBy(id = "com.shaadi.android:id/set_state")
	public WebElement dropDownState;

	@iOSFindBy(id = "labelOption_Statelivingin")
	public WebElement opt_State;

	@iOSFindBy(id = "labelTitle_City/District")
	@FindBy(id = "com.shaadi.android:id/set_city")
	public WebElement dropDownCity;

	@iOSFindBy(id = "labelOption_City/District")
	public WebElement opt_City;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[9]/XCUIElementTypeText")
	@FindBy(id = "com.shaadi.android:id/set_manglik")
	public WebElement dropDownManglik;

	@iOSFindBy(id = "labelTitle_PhotoSettings")
	@FindBy(id = "com.shaadi.android:id/set_photo")
	public WebElement dropDownPhoto;

	// @FindBy(className="android.widget.TextView")
	// public List<WebElement> classTextView;

	@iOSFindBy(id = "viewToggle_2")
	@FindBy(id = "com.shaadi.android:id/set_visible_photos2")
	public WebElement filterToggle;

	@iOSFindBy(id = "viewToggle_3")
	@FindBy(id = "com.shaadi.android:id/set_visible_photos3")
	public WebElement profilesViewedToggle;

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name, 'Search Results')]")
	public WebElement txtSearchResult;

	@iOSFindBy(name = "Members matching your search criteria")
	public WebElement txtMatchConfirmation;

	@FindBy(id = "com.shaadi.android:id/label")
	public List<WebElement> textViewData;

	@iOSFindBy(name = "Done")
	@FindBy(id = "com.shaadi.android:id/tv_apply")
	public WebElement textViewApply;

	@iOSFindBy(id = "labelOption_HaveChildren")
	@FindBy(id = "com.shaadi.android:id/set_kid_status")
	public WebElement dropDownChildrenlist;

	@iOSFindBy(id = "imageViewBanner")
	public WebElement btncloseLayer;

	@iOSFindBy(name = "btnSkip.label")
	public WebElement btnSkipInvitation;

	@iOSFindBy(name = "More Search Options")
	public WebElement btnMoreSearch;

	@iOSFindBy(name = "arrow left white")
	public WebElement btnNavBack;

	@iOSFindBy(id = "Search")
	public WebElement fldSearchText;

	@iOSFindBy(id = "buttonSubNav3")
	public WebElement MyMatchestab;

	@iOSFindBy(id = "buttonSubNav4")
	public WebElement NearMetab;

	@iOSFindBy(id = "buttonSubNav5")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"More Matches (99+)\")")
	public WebElement MoreMatchestab;

	@iOSFindBy(id = "buttonSubNav6")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Shortlist\")")
	public WebElement ShortlistTab;

	@iOSFindBy(id = "buttonSubNav7")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Recently Viewed\")")
	public WebElement RVTab;

	@iOSFindBy(id = "buttonSeeAll_ignored")
	public WebElement btnSeeAllIgnored;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Shortlist\")")
	@iOSFindBy(id = "buttonSubNav6")
	public WebElement Shortlists;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Recently Viewed\")")
	public WebElement RecentlyViewed;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_title")
	public WebElement ShortlistedMembers;

	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_selection")
	@iOSFindBy(id = "profile options down arrow")
	public WebElement dropdownArrow;

	@AndroidFindBy(id = "android:id/title")
	public List<WebElement> dropdownOptions;

	@AndroidFindBy(id = "android:id/title")
	public List<WebElement> shortlistsDropdownOptions;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Mobile number Verified\")")
	public WebElement mobileNumberVerified;

	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect")
	public WebElement imgListingConnectNow;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic")
	public WebElement txtLikeThisProfile;

	@AndroidFindBy(id = "com.shaadi.android:id/btnUpgrade")
	@iOSFindBy(id = "labelShaadiChat")
	public WebElement btnUpgrade; // Upgrade

	@AndroidFindBy(id = "com.shaadi.android:id/btnViewContact")
	public WebElement btnViewContact; // View Contact

	@AndroidFindBy(id = "com.shaadi.android:id/ctaViewContact")
	public WebElement callButtonAndroid; // View Contact

	@AndroidFindBy(id = "com.shaadi.android:id/btnWrite")
	public WebElement btnWriteMsg; // Write Message

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage")
	public WebElement shaadiChatButtonAndroid; // Write Message

	@AndroidFindBy(id = "com.shaadi.android:id/txt_header")
	public WebElement txtBannerPlan;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_name")
	public WebElement memberNameUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_mobile")
	public WebElement mobileFieldUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_mobile_no")
	public WebElement mobileValueUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_email")
	public WebElement emailFieldUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_email_id")
	public WebElement emailValueUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/tvPremiumBenefits")
	public WebElement premiumBenefitsTitleUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/textView10")
	public WebElement premiumBenefitsUpgradeBanner1;

	@AndroidFindBy(id = "com.shaadi.android:id/textView")
	public WebElement premiumBenefitsUpgradeBanner2;

	@AndroidFindBy(id = "com.shaadi.android:id/tvPromoteYourProfiles")
	public WebElement premiumBenefitsUpgradeBanner3;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_percent")
	public WebElement premiumPlansOfferUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_plan")
	public WebElement viewPlansBtnUpgradeBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/imgButtonCancel")
	public WebElement imgCloseBanner;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtOffer")
	public WebElement cardBannerPersonalized_txtOffer;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_btnViewPlans")
	public WebElement cardBannerPersonalized_btnViewPlans;
	
	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerUpgrade_btnRenewPremium")
	public WebElement cardBannerPersonalized_btnRenewPlans;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtContact")
	public WebElement cardBannerPersonalized_txtContact;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtContactTitle")
	public WebElement cardBannerPersonalized_txtContactTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtName")
	public WebElement cardBannerPersonalized_txtName;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_imgAvatar")
	public WebElement cardBannerPersonalized_imgAvatar;

	@AndroidFindBy(id = "com.shaadi.android:id/cardBannerPersonalized_txtHeading")
	public WebElement cardBannerPersonalized_txtHeading;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_option")
	public List<WebElement> dropDownOptionsAndroid;

	@iOSFindBy(id = "pp chips cancel")
	public WebElement btn_cancelSelection;

	@iOSFindBy(id = "labelDisplayName_5")
	public WebElement txt_SecondNameInList;

	@iOSFindBy(id = "labelDisplayName_1")
	public WebElement txt_SecondNameInList_premium;

	@iOSFindBy(id = "labelDisplayName_0")
	public WebElement txt_FirstNameInList_premium;

	@iOSFindBy(id = "buttonSingleCTARight_0")
	public WebElement btn_ConnectNow_Free;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonDualCTARight_0\"])[1]")
	public WebElement btn_ConnectNow_Premium;

	@iOSFindBy(id = "labelDisplayName_1")
	public WebElement txt_SecondNameInList_myMatches;

	@iOSFindBy(id = "buttonSeeAll_discovery_recent_visitors")
	public WebElement btn_SeeAll_RV;

	@iOSFindBy(id = "buttonSeeAll_broader")
	public WebElement btn_SeeAll_MemberYouMayLike;

	@iOSFindBy(id = "buttonSeeAll_reverse")
	public WebElement btn_SeeAll_MemberLookingForMe;

	@iOSFindBy(id = "buttonSeeAll_recently_viewed")
	public WebElement btn_SeeAll_recently_viewed;

	@iOSFindBy(id = "buttonSeeAll_ignored")
	public WebElement btn_SeeAll_Ignored;

	@iOSFindBy(id = "buttonSeeAll_blocked")
	public WebElement btn_SeeAll_blockedMember_RV;
	
	@iOSFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "com.shaadi.android:id/img_cancel")
	public WebElement imgVIPShaadiCancel;
	

}
