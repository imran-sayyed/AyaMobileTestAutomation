package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class RegistrationPageObjects extends BasePageActions {

	//there is space in Skip button on ioS 
	@AndroidFindBy(xpath = "//*[@text = 'SKIP']")
	@iOSFindBy(accessibility ="  Skip")
	public WebElement upgradePageSkip;
	
	@FindBy(id="errmsg_height")
	@iOSFindBy(id = "Please specify Height")
	public WebElement heightErrorMessage;

	@FindBy(id="errmsg_annualincome")
	@iOSFindBy(id = "Please specify Annual Income")
	public WebElement annualIncomeErrorMessage;

	@FindBy(id="errmsg_educationfield")
	@iOSFindBy(id = "Relevant relationship information is mandatory.")
	public WebElement educationFieldErrorMessage;

	@FindBy(id="errmsg_educationlevel")
	@iOSFindBy(id = "Please specify education level")
	public WebElement educationLevelErrorMessage;

	@FindBy(id="errmsg_no_of_kids")
	public WebElement noOfChildrenErrorMessage;

	@FindBy(id="errmsg_havechildren")
	public WebElement childrenErrorMessage;

	@FindBy(id="errmsg_caste")
	public WebElement communityErrorMessage;

	@FindBy(id="errmsg_maritalstatus")
	@iOSFindBy(id = "Please specify Marital Status")
	public WebElement maritalStatusErrorMessage;
    
	@FindBy(id="errmsg_display_city")
	@iOSFindBy(id = "Please enter the city living in")
	public WebElement cityErrorMessage;
	
	@FindBy(id="errmsg_state")
	@iOSFindBy(id = "Please enter the state living in")
    public WebElement stateErrorMessage;
	
	@FindBy(id="errmsg_mother_tongue")
	@iOSFindBy(id = "Community is mandatory.")
	public WebElement motherTongueErrorMessage;
	
	@FindBy(id="errmsg_community")
	@iOSFindBy(id = "Religion is mandatory.")
    public WebElement religionErrorMessage;
    
	@FindBy(id="errmsg_dateofbirth")
	@iOSFindBy(id = "Date of birth is mandatory.")
	public WebElement dobErrorMessage;
	
	@FindBy(id="errmsg_gender")
	@iOSFindBy(id = "Gender is mandatory.")
    public WebElement genderErrorMessage;
	
	@FindBy(id="errmsg_last_name")
	@iOSFindBy(id = "Valid surname is mandatory.")
	public WebElement lastNameErrorMessage;
	
	@FindBy(id="errmsg_first_name")
	@iOSFindBy(id = "Valid name is mandatory.")
	public WebElement firstNameErrorMessage;
	
	@FindBy(id="errmsg_postedby")
	@iOSFindBy(id = "Relevant relationship information is mandatory.")
	public WebElement postedByErrorMessage;
	
	@iOSFindBy(id = "Password is mandatory.")
	@FindBy(id="errmsg_password1")
	public WebElement passwordErrorMessage;
	
	@FindBy(id="errmsg_contact_mobile_number")
	@iOSFindBy(id = "Please specify Mobile Number")
	public WebElement mobileNoErrorMessage;
	
	@iOSFindBy(id = "Your email address is mandatory.")
	@FindBy(id="errmsg_email")
	public WebElement emailErrorMessage;
	
	@FindBy(id="create_profile_btn")
	@iOSFindBy(name = "Create Profile")
	public WebElement createProfileButton;

	@iOSFindBy(className = "XCUIElementTypeTextView")
	public WebElement txt_Area_AboutYourSelf;

	@FindBy(id="reg_continue_2_1")
	@iOSFindBy(accessibility ="reg_continue_2_1")
	public WebElement continue_button_2_1;

	@FindBy(id="display_city")
	@iOSFindBy(accessibility ="display_city")
	public WebElement city;

	@FindBy(id="stateofresidence")
	@iOSFindBy(accessibility="stateofresidence")
	public WebElement stateOfResidence;

	@FindBy(id = "email")
	@iOSFindBy(accessibility = "email")
	public WebElement webEmail;

	@FindBy(id="password1")
	@iOSFindBy(accessibility="password1")
	public WebElement webPassword;

	@FindBy(id="postedby")
	@iOSFindBy(accessibility="postedby")
	public WebElement webPostedBy;

	@FindBy(id="android:id/text1")
	public List<WebElement> WebPostedByOption;

	@FindBy(id="first_name")
	@iOSFindBy(accessibility="first_name")
	public WebElement webFirstName;

	@FindBy(id="last_name")
	@iOSFindBy(accessibility="last_name")
	public WebElement webLastName;

	@FindBy(xpath = "//*[@class='android.widget.ListView")
	public WebElement listview;

	@FindBy(id="gender")
	@iOSFindBy(accessibility="gender")
	public WebElement webGender;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectGender;

	@FindBy(id="day")
	@iOSFindBy(accessibility="day")
	public WebElement webDay;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectDay;

	@FindBy(id="month")
	@iOSFindBy(accessibility="month")
	public WebElement webMonth;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectMonth;

	@FindBy(id="year")
	@iOSFindBy(accessibility="year")
	public WebElement webYear;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectYear;

	@FindBy(id="community")
	//@iOSFindBy(xpath = "//XCUIElementTypeOther[@value='Select")
	public WebElement webReligion;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectReligion;

	@FindBy(id="mother_tongue")
	@iOSFindBy(accessibility="mother_tongue")
	public WebElement webMotherTongue;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectMotherTongue;

	@FindBy(id="countryofresidence")
	@iOSFindBy(id = "countryofresidence")
	public WebElement webLivinIn;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectLivigIn;

	@FindBy(xpath = "//android.view.View[@content-desc='Submit ' and @index='13")
	public WebElement webBtnSubmit;

	@FindBy(id="zip_code")
	public WebElement ZipCode;

	@FindBy(id="zipcode_checkbox")
	public WebElement webZipCodeCheckbox;

	@FindBy(id="living_since")
	@iOSFindBy(accessibility ="living_since")
    public WebElement webLivingSince;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectLivingSince;

	@FindBy(id="grew_up_in")
	@iOSFindBy(accessibility="grew_up_in")
	public WebElement webGrewUpIn;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectGrewUpIn;

	@FindBy(id="residencystatus")
	@iOSFindBy(accessibility="residencystatus")
	public WebElement webResidencyStatus;

	@FindBy(id="android:id/text1")
	public List<WebElement> webSelectResidencyStatus;

	// @AndroidFindBy(className="android.widget.ListView")
	// public WebElement listview;

	@FindBy(xpath = "//*[@class='android.view.View")
	public List<WebElement> webDrawer;

	@FindBy(id="state")
	public WebElement webStateLivingIn;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectStateLivingIn;

	@FindBy(id="places")
	public WebElement webCityLivingIn;

	@FindBy(id="focused-input")
	public WebElement webSelectCityLivingIn;

	@FindBy(id="places")
	public WebElement webLivingWihFamily;

	@FindBy(id="maritalstatus")
	@iOSFindBy(accessibility ="maritalstatus")
	public WebElement webMaritialStatus;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectMaritialStatus;

	@FindBy(id="children")
	@iOSFindBy(accessibility="children")
	public WebElement webChildren;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectChildren;

	@FindBy(id="no_of_kids")
	@iOSFindBy(accessibility="no_of_kids")
	public WebElement webNoOfChildren;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectNoOfChildren;

	@FindBy(id="caste")
	@iOSFindBy(accessibility ="caste")
	public WebElement webCommunity;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectCommunity;

	@FindBy(id="subcaste")
	@iOSFindBy(id="subcaste")
	public WebElement WebSubCommunity;

	@FindBy(id="caste_no_bar")
	@iOSFindBy(id="caste_no_bar")
	public WebElement WebNoCasteBar;

	@FindBy(id="gotra")
	@iOSFindBy(id="gotra")
	public WebElement WebGotra;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectGotra;

	@FindBy(id="nakshatra")
	public WebElement Webnakshatra;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectNakshatra;

	@FindBy(id="reg_continue_2_1")
	@iOSFindBy(accessibility ="reg_continue_2_1")
	public WebElement webContinue2_1;

	@FindBy(id="educationlevel")
	@iOSFindBy(accessibility ="educationlevel")
	public WebElement webEducationLevel1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectEducationLevel;

	@FindBy(id="educationfield")
	@iOSFindBy(accessibility ="educationfield")
	public WebElement webEducationField1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectEducationField;

	@FindBy(id = "working_with")
	public WebElement webWorkingWith1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectWorkingWith;

	@FindBy(id="occupation")
	public WebElement webWorkingAs1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectWorkingAs;

	@FindBy(id="annualincome")
	@iOSFindBy(accessibility ="annualincome")
	public WebElement webAnnualIncome;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectAnnualIncome;

	@FindBy(id="college1")
	public WebElement webFisrtCollege;

	@FindBy(id="college2")
	public WebElement webSecondCollege;

	@FindBy(id="diet")
	@iOSFindBy(accessibility ="diet")
	public WebElement webDiet1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectDiet;

	@FindBy(id="smoke")
	public WebElement webSmoke;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectSmoke;

	@FindBy(id="drink")
	public WebElement webDrink;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectDrink;

	@FindBy(id="height")
	@iOSFindBy(accessibility ="height")
	public WebElement webHeight1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectHeight;

	@FindBy(id="bodytype")
	public WebElement webBodyType1;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectBodyType;

	@FindBy(id = "//*[@id='complexion")
	public WebElement webComplexion;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectComplexion;

	@FindBy(id="country_code")
	public WebElement webcountry_code;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectcountry_code;

	@FindBy(id="contact_mobile_number")
	@iOSFindBy(accessibility = "contact_mobile_number")
	public WebElement webContactNumber;

	@FindBy(id="helpmetowritethis")
	public WebElement webHelpMeToWrite;

	@FindBy(id="specialcases")
	public WebElement webSpecialCase;

	@AndroidFindBy(id = "android:id/text1")
	public List<WebElement> webSelectSpecialCase;

	@AndroidFindBy(className = "android.view.View")
	public List<WebElement> webAndroidView;

	@AndroidFindBy(id = "com.shaadi.android:id/skip_button")
	public WebElement btn_SkipPhoto;

	@AndroidFindBy(id = "com.shaadi.android:id/upload_photo_now_btn")
	public WebElement btn_UploadPhoto;

	@AndroidFindBy(id = "com.shaadi.android:id/gallery_photo")
	public WebElement btn_GalleryUpload;

	@AndroidFindBy(id = "com.shaadi.android:id/camera_photo")
	public WebElement btn_CameraUpload;

	@AndroidFindBy(id = "com.shaadi.android:id/facebook_photo")
	public WebElement btn_FacebookUpload;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_skip_family_dtl")
	public WebElement btn_SkipFamilyDetails;

	@AndroidFindBy(id = "com.shaadi.android:id/btnContinue")
	public WebElement btn_ContinueFamilyDetails;

	@iOSFindBy(accessibility = "sign-up-btn")
	@FindBy(id = "sign-up-btn")
	public WebElement btnSubmitReg1;

	@FindBy(id="submit-form-basic")
	public WebElement btnSubmitReg1_1;

	@FindBy(id="educationlevel")
	@iOSFindBy(accessibility="educationlevel")
	public WebElement webEducationLevel;

	@FindBy(id="educationfield")
	@iOSFindBy(accessibility="educationfield")
	public WebElement webEducationField;

	@FindBy(id="working_with")
	public WebElement webWorkingWith;

	@FindBy(id="occupation")
	public WebElement webWorkingAs;

	@FindBy(id="annualincome")
	@iOSFindBy(accessibility="annualincome")
	public WebElement webIncome;

	@FindBy(id="submit-form-biodata")
	public WebElement btnSubmitRegBiodata;

	@AndroidFindBy(id = "diet")
	public WebElement webDiet;

	@FindBy(id="height")
	@iOSFindBy(accessibility ="height")
	public WebElement webHeight;

	@AndroidFindBy(id = "bodytype")
	public WebElement webBodyType;

	@AndroidFindBy(id = "smokeHabbit")
	public WebElement webSmokingHabbit;

	@AndroidFindBy(className = "android.widget.Button")
	public WebElement webButton;

	@AndroidFindBy(id = "drinkHabbit")
	public WebElement webDrinkHabbit;

	@AndroidFindBy(id = "submit-form-lifestyle")
	public WebElement btnSubmitRegLifeStyle;

	@FindBy(id="about-me-help")
	public WebElement webHelpMe;

	@FindBy(id="btn-about-me-cta")
	public WebElement webCopyThis;

	@AndroidFindBy(id = "mobileNumber")
	public WebElement webMobileNumber;

	@AndroidFindBy(id = "submit-form-description")
	public WebElement btnSubmitCreateProfile;

	// Whatsapp Optin

	@AndroidFindBy(id = "com.shaadi.android:id/upload_msg")
	public WebElement UploaPhotoText;

	@AndroidFindBy(id = "com.shaadi.android:id/detail_row2")
	public WebElement PhotoPrivacytxt;

	@AndroidFindBy(id = "com.shaadi.android:id/skip_button")
	public WebElement skipPhotoUpload;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_skip_family_dtl")
	public WebElement SkipFamilyDetails;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement AllowPermission;

	@AndroidFindBy(id = "com.shaadi.android:id/lbl_num_verification_title_txt")
	public WebElement SmsVerificationtxt;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_reg_user_name")
	public WebElement UserNameGreet;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_number_verified")
	public WebElement NumVerifiedTxt;// Your number has been successfully verified.

	@AndroidFindBy(id = "com.shaadi.android:id/tv_whatsapp_opt_in_description")
	public WebElement WhatsappText;// Get your Shaadi recommendations on WhatsApp

	@AndroidFindBy(id = "com.shaadi.android:id/btn_whatsapp_opt_in")
	public WebElement OkSureBtn;// Ok, sure

	@AndroidFindBy(id = "com.shaadi.android:id/btn_do_later")
	public WebElement IldoLaterbTN;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_save")
	public WebElement SavePP;

	@AndroidFindBy(id = "com.shaadi.android:id/miCompose")
	public WebElement SkipUpgradePge;

	@AndroidFindBy(id = "com.shaadi.android:id/onboarding_show_more_matches")
	public WebElement ShowMoreMatchesBtn;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMyShaadi")
	public WebElement MyShadiTab;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_stay_connected")
	public WebElement stayConnected;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_whatsapp_opt_in")
	public WebElement GetYrMatchesonWatspTxt;

	@AndroidFindBy(id = "com.shaadi.android:id/check_whatsapp_opt_in")
	public WebElement WatsappToggle;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
	public WebElement wheelNextButton;

	@iOSFindBy(id = "Done")
	public WebElement wheelDoneButton;

	@iOSFindBy(xpath = "//XCUIElementTypeLink[@name=\"Submit\"]")
	public WebElement btnSubmit;

	//@AndroidFindBy(xpath = "//android.widget.TextView[text() = 'Add Photos Later")
	@AndroidFindBy(id =  "com.shaadi.android:id/skip_button")
	@iOSFindBy(id = "Add Photos Later")
	public WebElement btnAddPhotosLater;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_not_now")
	@iOSFindBy(id = "buttonNotNow")
	public WebElement btnNotNow_photo;

	
	@AndroidFindBy(id = "com.shaadi.android:id/tvDoThisLater")
	@iOSFindBy(id = "I'll do this later")
	public WebElement btn_verifyNumberLater;

	@AndroidFindBy(id = "com.shaadi.android:id/btn_save")
	@iOSFindBy(id = "viewBottomDock.label")
	public WebElement btn_savePP;

	@AndroidFindBy(id = "com.shaadi.android:id/txt_skip_family_dtl")
	@iOSFindBy(id = "split page arrow")
	public WebElement btn_skipFamily;

	@AndroidFindBy(id = "com.shaadi.android:id/miCompose")
	@iOSFindBy(id = "split page arrow")
	public WebElement btn_SplitPage;
	
	@iOSFindBy(id = "Skip")
	@AndroidFindBy(id = "com.shaadi.android:id/menu_skip_with_arrow")
	public WebElement btn_SkipConnect;
	
	@iOSFindBy(id="closeOnBoarding")
	public WebElement btn_OnBoarding;
	
	@iOSFindBy(name="OK")
	public WebElement btn_OK;
	
	@iOSFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "com.shaadi.android:id/img_cancel")
	public WebElement imgVIPShaadiCancel;
	
	
	
}
