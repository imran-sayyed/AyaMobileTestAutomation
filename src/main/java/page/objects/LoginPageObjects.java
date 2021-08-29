package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import shaadi.utils.AppStringConstants;

public class LoginPageObjects extends BasePageActions {

	@AndroidFindBy(id = "com.shaadi.android:id/gmail")
	public WebElement googleLoginButton;


	@iOSFindBy(id = "Login with password")
	@AndroidFindBy(id = "com.shaadi.android:id/tvLoginWithPassword")
	public WebElement txt_loginWithPassword;

	@AndroidFindBy(id = "com.shaadi.android:id/tvFooterServerError")
	public WebElement txt_OtpLimitExceedFooterServerError;

	@AndroidFindBy(id = "com.shaadi.android:id/tvFooterError")
	public WebElement txt_OtpLimitExceedFooterError;

	@iOSFindBy(id = AppStringConstants.OTPExceededLimit)
	@AndroidFindBy(id = "com.shaadi.android:id/tvLimitExceedError")
	public WebElement txt_OtpLimitExceedError;

//	@iOSFindBy(id = "Login with OTP")
//	@AndroidFindBy(id = "com.shaadi.android:id/btn_login_with_otp")
//	public WebElement LoginWithOTPButton;
	
	@iOSFindBy(accessibility = "buttonsendOTP")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_login_with_otp")
	public WebElement LoginWithOTPButton;

	@iOSFindBy(id = "Try again")
	public WebElement try_AgainButton;

	@iOSFindBy(id = "Allow")
	public WebElement Allow_notifications;

	@iOSFindBy(accessibility = "buttonSignIn")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Login']")
	public WebElement btnNavigateSignIn;
	
	@iOSFindBy(accessibility = "buttonPassword")
	public WebElement btnContinueWithPassword;
	
	@iOSFindBy(accessibility = "buttonOTP")
	public WebElement btnContinueWithOTP;
	
	
	

	@iOSFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "com.shaadi.android:id/img_cancel")
	public WebElement imgVIPShaadiCancel;

	@iOSFindBy(accessibility = "buttonSignIn")
	public WebElement btnNavigateSignIniOS; // NEW SPLASH SCREEN LOGIN BUTTON

	@iOSFindBy(id = "textfieldemailMobileField")
	 @AndroidFindBy(xpath="//android.widget.EditText")
	public WebElement editTextUserName;

	@iOSFindBy(id = "textfieldpasswordField")
	@AndroidFindBy(xpath="//android.widget.EditText")
	public WebElement editTextPassword;

	//@iOSFindBy(id = "buttonsignInButton")
	@iOSFindBy(id = "buttonsignInWithPassword")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Submit']")
	public WebElement btnMainSignIn;

	@iOSFindBy(accessibility = "buttonForgotPassword")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_forgot_password")
	public WebElement textviewForgotPassword;

	@iOSFindBy(className = "XCUIElementTypeAlert")
	public WebElement Alert;

	@iOSFindBy(className = "XCUIElementTypeSheet")
	public WebElement BottomAlert;

	@iOSFindBy(id = "OK")
	public WebElement Ok;

	@iOSFindBy(id = "Cancel")
	public WebElement Cancel;

	@AndroidFindBy(id = "com.shaadi.android:id/til_username")
	public WebElement LayoutEmail;

	@AndroidFindBy(id = "com.shaadi.android:id/til_password")
	public WebElement Layoutpassword;

	@iOSFindBy(accessibility = "btnRegisterFree.label")
	public WebElement btnSignUp;

	@iOSFindBy(id = "buttonSignUp")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_morph_sign_up")
	public WebElement btnSignupFree;
	
	@iOSFindBy(id="buttoncreateForFree")
	public WebElement btn_SignUpFreeOnLogin;

	@iOSFindBy(id = "buttonsignUpFree")
	public WebElement btn_SignupOnLoginPage;

//	@iOSFindBy(id = "Forgot password?")
//	@AndroidFindBy(id = "com.shaadi.android:id/tv_forgot_password")
//	public WebElement tvForgotPswd;
	
	@iOSFindBy(accessibility = "buttonforgotPasswordButton")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_forgot_password")
	public WebElement tvForgotPswd;

	@iOSFindBy(accessibility = "buttonForgotPassword")
	@AndroidFindBy(id = "com.shaadi.android:id/forgotPw_text")
	public WebElement btnForgotPswd;

	@FindBy(className = "android.widget.TextView")
	public WebElement txtForgotPswd;

	@iOSFindBy(className = "XCUIElementTypeStaticText")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Forgot Password\")")
	public WebElement forgotPasswordTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/menu_skip")
	public static WebElement paymentSkip;

	@AndroidFindBy(id = "com.shaadi.android:id/lbl_skip")
	public static WebElement connectionSkip;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_skip")
	public static WebElement acceptStopPageSkip;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public static WebElement paymentArrowBack;

	@FindBy(id = "com.shaadi.android:id/textView_upgrade_title")
	public static WebElement upgradeToPremiumNow;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public static WebElement btnGotIt;
	
	
	@FindBy(id = "com.google.android.gms:id/add_account_chip_title")
	public WebElement addAnotherAccount;
	
	@FindBy( id = "com.google.android.gms:id/account_name")
	public WebElement existingEmailIdGoogleSignUp;
	
	@FindBy(xpath = "//android.widget.Button[@text = 'ACCEPT']")
	public WebElement acceptBtnGoogleSignUpPage;
	
	@FindBy(id = "signinconsentNext")
	public WebElement iAgreeButtonGoogleSignupPage;
	
	@FindBy(id = "passwordNext")
	public WebElement passwordNextGoogleSignupPage;
	
	@FindBy(xpath = "//android.view.View[@id='password']/android.view.View/android.view.View/android.widget.EditText")
	public WebElement passwordTextBoxGmail;

	//@FindBy(id = "identifierId")
	@AndroidFindBy(xpath = "//input[@type = 'email']")
	public WebElement gmailTextBox;
	
	@FindBy(id = "identifierNext")
	public WebElement nextGoogleSignUpPage;
	
	@AndroidFindBy(id = "com.shaadi.android:id/gsignin")
	public WebElement GoogleSignUpBtn;


	@AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
    public MobileElement continueButton;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Forgot Password']")
    public MobileElement forgotPasswordLink;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter your email']")
	public WebElement enterYourEmail;
	
}
