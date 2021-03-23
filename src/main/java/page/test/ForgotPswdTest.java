package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.ForgetPasswordPage;
import page.actions.LoginPage;
import shaadi.utils.AppStringConstants;

public class ForgotPswdTest extends BasePageActions {
	LoginPage login;
	ForgetPasswordPage fppage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		login = new LoginPage();
		fppage = new ForgetPasswordPage();

	}

	@Test(priority = 0, description = "Verify on the click of Forgot password link, user is navigated to the first page of Forgot password")
	public void FP01() {
		SoftAssert sa = new SoftAssert();
		if (RunEnvironment.equals("iOSLocal")) {
			login.Allow();
		}

		click(login.btnNavigateSignIn, "Click on Login Button to navigate to Login Page", "");
		click(login.btnContinueWithPassword, "Click on continue with password", "");
		waitForElementToBeDisplayed(login.editTextUserName,"wait for Login page to load", "");
		login.editTextUserName.clear();
		sa.assertTrue(getText(login.tvForgotPswd, "Get Forgot password text").contains("Forgot Password?")
				|| getText(login.tvForgotPswd, "Get Forgot password text").contains("Forgot password?"));
		click(login.tvForgotPswd, "Click on Forgot password Button", "");
		sa.assertEquals(getText(login.forgotPasswordTitle, "Get Forgot password page Title text"), "Forgot Password",
				"Forgot Password text on Title doesn't match");

		sa.assertAll();
	}

	@Test(priority = 1, description = "Verify on the click of Forgot password link, user is navigated to the first page of Forgot password")
	public void FP02() {
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(getText(fppage.txtHeader1, "Get Forgot password page Heading text"),
				"Enter Mobile No. or Email ID", "Forgot Password text on Heading doesn't match");
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			sa.assertEquals(getText(fppage.txtSubHeader, "Get Forgot password page sub-heading text"),
					"We will send you an OTP to reset your password",
					"Forgot Password text on sub-heading doesn't match");
		}
		fppage.edEmailOrPhone.clear();
		sa.assertTrue(getText(fppage.edEmailOrPhone, "Get Forgot password page sub-heading text")
				.contains("Mobile No. / Email ID")
				|| getText(fppage.txtSubHeader, "Get Forgot password page sub-heading text")
						.contains("Enter Mobile No. / Email ID"));

		sa.assertTrue(isElementDisplayed(fppage.btnSendOTP), "Send OTP button is not displayed");
		driver.navigate().back(); // navigate back to Login page

		sa.assertAll();
	}

	@Test(priority = 2, description = "Verify an email id entered on Login page is displayed on Forgot Password page")
	public void FP03() {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.validEmailFP1, "Enter a username on Login page", "");
		click(login.tvForgotPswd, "Click on Forgot password Button", "");
		sa.assertEquals(getText(fppage.edEmailOrPhone, "get username text on Forgot Password page"),
				AppStringConstants.validEmailFP1, "Username entered on Login page doesn't match");

		sa.assertAll();
	}

	@Test(priority = 3, description = "Verify user can clear the username and enter a new one on Forgot Password page")
	public void FP04() {
		SoftAssert sa = new SoftAssert();

		// clear the entered username and enter a new one
		fppage.edEmailOrPhone.clear();

		sa.assertTrue(getText(fppage.edEmailOrPhone, "get username text on Forgot Password page")
				.contains("Mobile No. / Email ID")
				|| getText(fppage.txtSubHeader, "Get Forgot password page sub-heading text")
						.contains("Enter Mobile No. / Email ID"));

		InputValue(fppage.edEmailOrPhone, AppStringConstants.dummyEmail, "Enter a new username on Forgot Password page",
				"FP04");
		sa.assertEquals(getText(fppage.edEmailOrPhone, "get username text on Forgot Password page"),
				AppStringConstants.dummyEmail, "new username text doesn't match");

		sa.assertAll();
	}

	@Test(priority = 4, description = "Verify new username entered on Forgot Password page doesn't replace the username entered on Login page")
	public void FP05() {
		SoftAssert sa = new SoftAssert();

		// verify that username deleted from Forgot Password page doesn't deletes the
		// username entered on Login page
		driver.navigate().back(); // navigate back to Login page
		sa.assertEquals(getText(login.editTextUserName, "get username text on Login page"),
				AppStringConstants.validEmailFP1, "username text on Login page doesn't match");

		sa.assertAll();
	}

	@Test(priority = 5, description = "Verify the validation error message when email id is blank")
	public void FP06() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		click(login.tvForgotPswd, "Click on Forgot password Button", "");
		fppage.edEmailOrPhone.clear();
		click(fppage.btnSendOTP, "click on Send OTP button", "");
		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("No details entered");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"), "Enter Email ID or Mobile No.",
					"Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 6, description = "Verify the validation error message when email id is incorrect format")
	public void FP07() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.edEmailOrPhone, AppStringConstants.invalidEmail,
				"Enter an incorrect email id on Forgot Password page", "");
		click(fppage.btnSendOTP, "click on Send OTP button", "");

		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Invalid Email ID");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"Incorrect email address format. Please type a valid email address. Example username@example.com",
					"Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 7, description = "Verify the validation error message when unregistrered email id is entered")
	public void FP08() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.edEmailOrPhone, AppStringConstants.dummyEmail,
				"Enter an unregistered username on Forgot Password page", "FP07");
		click(fppage.btnSendOTP, "click on Send OTP button", "FP07");

		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Email ID not registered");
			login.ClickOK();

		} else {

			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"This Email ID is not registered with us", "Error messsage doesn't match");
			sa.assertEquals(getText(fppage.NewToShaadi, "Get message text"), "New to Shaadi.com?",
					"New to Shaadi text doesn't match");
			sa.assertTrue(isElementDisplayed(fppage.SignUpFree), "Sign Up Free link is not displayed");

			sa.assertAll();
		}
	}

	@Test(priority = 8, description = "Verify the validation error message when mobile no is incorrect")
	public void FP09() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.edEmailOrPhone, AppStringConstants.invalidMobile,
				"Enter an incorrect mobile number on Forgot Password page", "");
		click(fppage.btnSendOTP, "click on Send OTP button", "");
		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Invalid Mobile No.");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"Incorrect mobile no. Please enter valid mobile no.", "Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 9, description = "Verify the validation error message when unregistrered mobile no is entered")
	public void FP10() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.edEmailOrPhone, AppStringConstants.dummyMobile,
				"Enter an unregistered mobile number on Forgot Password page", "");
		click(fppage.btnSendOTP, "click on Send OTP button", "");

		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Mobile no. not registered");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"This Mobile no. is not registered with us", "Error messsage doesn't match");
			sa.assertEquals(getText(fppage.NewToShaadi, "Get message text"), "New to Shaadi.com?",
					"New to Shaadi text doesn't match");
			sa.assertTrue(isElementDisplayed(fppage.SignUpFree), "Sign Up Free link is not displayed");

			sa.assertAll();
		}
	}

	@Test(priority = 10, description = "Verify the validation error message when unverified mobile no is entered")
	public void FP11() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.edEmailOrPhone, AppStringConstants.unverifiedMobile,
				"Enter an unverified mobile number on Forgot Password page", "");
		click(fppage.btnSendOTP, "click on Send OTP button", "");
		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Mobile no. not registered");
			login.ClickOK();

		} else {
			boolean result = getText(fppage.txtErrorMsg, "Get error message text")
					.equals("This Mobile no. has not been verified. Try Login with Email ID")
					|| getText(fppage.txtErrorMsg, "Get error message text")
							.equals("This Mobile no. is not registered with us");
			sa.assertTrue(result);
			sa.assertAll();
		}
	}

	@Test(priority = 11, description = "Verify the validation error message when mobile no used for multiple profiles is entered")
	public void FP12() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.edEmailOrPhone, AppStringConstants.multipleProfilesMobile,
				"Enter amobile number that is used for multiple profiles on Forgot Password page", "");
		click(fppage.btnSendOTP, "click on Send OTP button", "");

		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("This no. is already in use");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"This Mobile no. has been used for multiple Profiles. Please login using Email ID",
					"Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 12, description = "Verify 2nd page of Forgot Password is shown when valid email id is entered")
	public void FP13() throws InterruptedException {
		String maskedEmailExpected = null;

		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {

		InputValue(fppage.edEmailOrPhone, AppStringConstants.validEmailFP1,
				"Enter an valid email id on Forgot Password page", "");
		 maskedEmailExpected = AppStringConstants.validEmailFP1.replaceAll("(^[^@]{0}|(?!^)\\G)[^@]", "X"); // mask
		}
		else {
			InputValue(fppage.edEmailOrPhone, AppStringConstants.validEmailFP2,
					"Enter an valid email id on Forgot Password page", "");
		}
		// all
		click(fppage.btnSendOTP, "click on Send OTP button", "");
																								// characters
																												// upto		click(fppage.btnSendOTP, "click on Send OTP button", "FP12");
		sa.assertTrue(isDisplayedAfterWait(fppage.tvEdit, 10), "Edit button is not displayed");

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			waitForElementToBeDisplayed(fppage.txtOTPSentHeader, "Wait for 2nd page to be displayed", "");
			String maskedEmailActual = getText(fppage.txtOTPSentHeader, "Get masked email id text");
			sa.assertTrue(maskedEmailActual.contains(maskedEmailExpected), "Email id is not masked as per requirement");
		}

		sa.assertEquals(getText(fppage.txtEnterOTP, "Get text"), "Enter OTP", "Enter OTP text doesn't match");
		sa.assertTrue(isElementDisplayed(fppage.tvOTP1), "tvOTP1 field is not displayed");
		sa.assertTrue(isElementDisplayed(fppage.tvOTP2), "tvOTP2 field is not displayed");
		sa.assertTrue(isElementDisplayed(fppage.tvOTP3), "tvOTP3 field is not displayed");
		sa.assertTrue(isElementDisplayed(fppage.tvOTP4), "tvOTP4 field is not displayed");
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			sa.assertEquals(getText(fppage.tvProgressMsg, "Get text"), "Auto-reading OTP",
					"Auto-reading OTP text doesn't match");
			sa.assertTrue(isDisplayed(fppage.tvOTPReadInfo), "Resend OTP counter is not displayed");

		}
		sa.assertTrue(isDisplayed(fppage.tvOTPReadInfo), "Resend OTP counter is not displayed");
		Thread.sleep(30000); // wait to counter to get lapsed
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			sa.assertEquals(getText(fppage.tvOTPAutoReadError, "Get text"),
					"Couldn’t read OTP, enter manually or try again", "OTP auto-read error text doesn't match");
			sa.assertTrue(getText(fppage.tvOTPReadInfo, "Get text").contains("Didn’t receive OTP? Resend") , "Resend OTP text does not match");

		} else {
		//	sa.assertTrue(getText(fppage.OTPResendIOS, "Get text").contains("Didn’t receive OTP? Resend"));
			waitForElementToBeDisplayed(fppage.OTPResendIOS, "", "");
			sa.assertEquals(getText(fppage.OTPResendIOS, "Get text"), "Didn’t recieve OTP?");

		}

		sa.assertAll();
	}

	@Test(priority = 13, description = "Verify the validation error when incorrect OTP is entered")
	public void FP14() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.tvOTP1, "1", "Enter OTP1", "");
		InputValue(fppage.tvOTP2, "2", "Enter OTP2", "");
		InputValue(fppage.tvOTP3, "3", "Enter OTP3", "");
		InputValue(fppage.tvOTP4, "4", "Enter OTP4", "");
		if (RunEnvironment.equals("iOSLocal")) {
			waitForElementToBeDisplayed(fppage.IncorrectOTPAlertBox, "Wait for OTP error message", "");
			sa.assertEquals(getText(fppage.IncorrectOTPAlertBox, "Get text"), "Incorrect OTP, please try again",
					"Incorrect OTP error text doesn't match");
			login.ClickOK();

		} else {
			waitForElementToBeDisplayed(fppage.tvOTPAutoReadError, "Wait for OTP error message", "");
			Thread.sleep(2000);
			sa.assertEquals(getText(fppage.tvOTPAutoReadError, "Get text"), "Incorrect OTP, please try again",
					"Incorrect OTP error text doesn't match");

		}
		sa.assertAll();
	}

	@Test(priority = 14, description = "Verify the validation error when incorrect OTP is entered" , enabled = false)
	public void FP15() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		click(fppage.tvEdit, "Click on Edit", "");
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
		InputValue(fppage.edEmailOrPhone, AppStringConstants.validEmailFP3,
				"Enter another username on Forgot Password page", "");
		}
		else {
			InputValue(fppage.edEmailOrPhone, AppStringConstants.validEmailFP4,
					"Enter another username on Forgot Password page", "");
		}
		click(fppage.btnSendOTP, "click on Send OTP button", "");
		sa.assertTrue(isDisplayedAfterWait(fppage.tvEdit, 10), "Edit button is not displayed");
		if (!RunEnvironment.equals("iOSLocal")) {
			waitForElementToBeDisplayed(fppage.txtOTPSentHeader, "Wait for 2nd page to be displayed", "");
		}
		sa.assertEquals(getText(fppage.txtEnterOTP, "Get text"), "Enter OTP", "Enter OTP text doesn't match");

		sa.assertAll();
	}



}
