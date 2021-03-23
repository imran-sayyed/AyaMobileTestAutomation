package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ForgotPasswordPageObjects extends BasePageActions {

	@iOSFindBy(id = "Incorrect OTP, please try again")
	public WebElement IncorrectOTPAlertBox;
	
	@FindBy(id = "com.shaadi.android:id/edt_username")
	public WebElement edUserName;

	@iOSFindBy(id = "labelTopHeader")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_heading")
	public WebElement txtHeader1;

	@iOSFindBy( id = "labelSecondHeader")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_sub_heading")
	public WebElement txtSubHeader;

	@FindBy(id = "com.shaadi.android:id/til_email_or_mobile")
	public WebElement txtTitle;

	@iOSFindBy( id = "textfieldEnterEmail")
	@AndroidFindBy(id = "com.shaadi.android:id/ed_email_or_phone")
	public WebElement edEmailOrPhone;

	@iOSFindBy( id = "buttonSendOtp")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_send_otp")
	public WebElement btnSendOTP;

	@FindBy(id = "com.shaadi.android:id/textinput_error")
	public WebElement txtErrorMsg;

	@iOSFindBy(id = "labelMessage")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_header")
	public WebElement txtOTPSentHeader;

	@iOSFindBy(id = "buttonEdit")
	@AndroidFindBy(id = "com.shaadi.android:id/tvEditUsername")
	public WebElement tvEdit;

	@iOSFindBy(id = "labelTopHeader")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_heading")
	public WebElement txtEnterOTP;

	@iOSFindBy(id = "textfieldFirst")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_otp_1")
	public WebElement tvOTP1;

	@iOSFindBy(id = "textfieldSecond")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_otp_2")
	public WebElement tvOTP2;

	@iOSFindBy(id = "textfieldThird")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_otp_3")
	public WebElement tvOTP3;

	@iOSFindBy(id = "textfieldFourth")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_otp_4")
	public WebElement tvOTP4;

	@iOSFindBy(id = "labelPreSeconds")
	@AndroidFindBy(id = "com.shaadi.android:id/tvCounterAndResend") // id changed
	public WebElement tvOTPReadInfo;
	
	@iOSFindBy(id = "labelResend")
	public WebElement OTPResendIOS;

	@FindBy(id = "com.shaadi.android:id/tv_error")
	public WebElement tvOTPAutoReadError;

	@FindBy(id = "com.shaadi.android:id/textinput_error")
	public WebElement txtAttemptsExceeded;

	
	@AndroidFindBy(id = "com.shaadi.android:id/tvProgressMessage")
	public WebElement tvProgressMsg;

	@FindBy(id = "com.shaadi.android:id/tv_heading")
	public WebElement txtHeading;

	@FindBy(id = "com.shaadi.android:id/ed_password")
	public WebElement edNewPswd;

	@FindBy(id = "com.shaadi.android:id/tvHideAndShowPassword")
	public WebElement tvHideAndShowPswd;

	@FindBy(id = "com.shaadi.android:id/ed_confirm_password")
	public WebElement edConfirmPswd;

	@FindBy(id = "com.shaadi.android:id/tvHideAndShowConfirmPassword")
	public WebElement tvHideAndShowConfirmPswd;

	@FindBy(id = "com.shaadi.android:id/btn_confirm")
	public WebElement btnConfirm;

	@FindBy(id = "com.shaadi.android:id/tv_heading")
	public WebElement txtPswdReset;

	@FindBy(id = "com.shaadi.android:id/tv_sub_heading")
	public WebElement txtLoginUsingNewPswd;

	@FindBy(id = "com.android.packageinstaller:id/permission_message")
	public WebElement tvPermission;

	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	public WebElement btnDeny;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement btnAllow;

	@FindBy(id = "com.shaadi.android:id/tvFooterError")
	public WebElement tvFooterError;

	@FindBy(id = "com.shaadi.android:id/tvFooterServerError")
	public WebElement tvFooterServerError;

	@AndroidFindBy(id = "com.shaadi.android:id/tvSignUpNew")
	public WebElement NewToShaadi;

	@AndroidFindBy(id = "com.shaadi.android:id/tvSignUp")
	public WebElement SignUpFree;

}
