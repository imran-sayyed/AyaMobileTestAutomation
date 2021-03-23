package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.ForgetPasswordPage;
import page.actions.LoginPage;
import shaadi.utils.AppStringConstants;

public class OTPLoginTest extends BasePageActions {
	LoginPage login;
	ForgetPasswordPage fppage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		login = new LoginPage();
		fppage = new ForgetPasswordPage();

	}

	@Test(priority = 0, description = "Verify Login with OTP link is present in Login Page")
	public void OTP01() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		if (RunEnvironment.equals("iOSLocal")) {
			login.Allow();
		}

		waitForElementToBeDisplayed(login.btnNavigateSignIn, "wait for Sign in page to load", "OTP");
		login.btnNavigateSignIn.click();
		click(login.btnContinueWithOTP, "Click on Continue with OTP", "");
		waitForElementToBeDisplayed(login.editTextUserName, "wait for Login page to load", "OTP");
		login.editTextUserName.clear();

		sa.assertTrue(isDisplayedAfterWait(login.LoginWithOTPButton, 3),
				"Verify Login with OTP button is present on Login page");

		sa.assertAll();
	}

	@Test(priority = 1, description = "Verify the validation error message when email id is blank")
	public void OTP02() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");
		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("No details entered");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"), "Enter Email ID or Mobile No.",
					"Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 2, description = "Verify the validation error message when email id is incorrect format")
	public void OTP03() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.invalidEmail,
				"Enter an incorrect email id on Login with OTP page", "");
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");

		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Invalid Email ID");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"Enter correct email ID. Example - username@example.com", "Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 3, description = "Verify the validation error message when unregistrered email id is entered")
	public void OTP04() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.dummyEmail,
				"Enter an unregistered username on Login with OTP page", "OTP");
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");

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

	@Test(priority = 4, description = "Verify the validation error message when mobile no is incorrect")
	public void OTP05() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.invalidMobile,
				"Enter an incorrect mobile number on Login with OTP page", "OTP");
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");
		if (RunEnvironment.equals("iOSLocal")) {
			login.VerifyAlertMessage("Invalid Mobile No.");
			login.ClickOK();

		} else {
			sa.assertEquals(getText(fppage.txtErrorMsg, "Get error message text"),
					"Incorrect mobile no. Please enter valid mobile no.", "Error messsage doesn't match");

			sa.assertAll();
		}
	}

	@Test(priority = 5, description = "Verify the validation error message when unregistrered mobile no is entered")
	public void OTP06() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.dummyMobile,
				"Enter an unregistered mobile number Login with OTP page", "OTP");
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");

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

	@Test(priority = 6, description = "Verify the validation error message when unverified mobile no is entered")
	public void OTP07() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.unverifiedMobile,
				"Enter an unverified mobile number on Login with OTP page", "OTP");
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");

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

	@Test(priority = 7, description = "Verify the validation error message when mobile no used for multiple profiles is entered")
	public void OTP08() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(login.editTextUserName, AppStringConstants.multipleProfilesMobile,
				"Enter amobile number that is used for multiple profiles on Login with OTP page", "OTP");
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");

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

	@Test(priority = 8, description = "Verify 2nd page of Login with OTP is shown when valid email id is entered")
	public void OTP09() throws InterruptedException {
		String maskedEmailExpected = null;
		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			InputValue(login.editTextUserName, AppStringConstants.validEmailOTP1,
					"Enter an valid email id on Login with OTP page", "OTP");
			maskedEmailExpected = AppStringConstants.validEmailOTP1.replaceAll("(^[^@]{0}|(?!^)\\G)[^@]", "X"); // mask
		} else {
			InputValue(login.editTextUserName, AppStringConstants.validEmailOTP2,
					"Enter an valid email id on Login with OTP page", "OTP");
		}
		// all
		// need to change since taking too much time on ios
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}
		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");

		sa.assertTrue(isDisplayedAfterWait(fppage.tvEdit, 10), "Edit button is not displayed");

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			waitForElementToBeDisplayed(fppage.txtOTPSentHeader, "Wait for 2nd page to be displayed", "OTP");
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

			waitForElementToBeDisplayed(fppage.OTPResendIOS, "", "");
			sa.assertEquals(getText(fppage.OTPResendIOS, "Get text"), "Didn’t recieve OTP?" , "");

		}

		sa.assertAll();
	}

	@Test(priority = 9, description = "Verify the validation error when incorrect OTP is entered")
	public void OTP10() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		InputValue(fppage.tvOTP1, "1", "Enter OTP1", "OTP");
		InputValue(fppage.tvOTP2, "2", "Enter OTP2", "OTP");
		InputValue(fppage.tvOTP3, "3", "Enter OTP3", "OTP");
		InputValue(fppage.tvOTP4, "4", "Enter OTP4", "OTP");
		if (RunEnvironment.equals("iOSLocal")) {
			waitForElementToBeDisplayed(fppage.IncorrectOTPAlertBox, "Wait for OTP error message", "");
			sa.assertEquals(getText(fppage.IncorrectOTPAlertBox, "Get text"), "Incorrect OTP, please try again",
					"Incorrect OTP error text doesn't match");
			login.ClickOK();

		} else {
			waitForElementToBeDisplayed(fppage.tvOTPAutoReadError, "Wait for OTP error message", "");
			sa.assertEquals(getText(fppage.tvOTPAutoReadError, "Get text"), "Incorrect OTP, please try again",
					"Incorrect OTP error text doesn't match");

		}
		sa.assertAll();
	}

	@Test(priority = 10, description = "Verify the validation error when incorrect OTP is entered more than 3 times")
	public void OTP11() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {

			InputValue(fppage.tvOTP1, "1", "Enter OTP1", "OTP");
			InputValue(fppage.tvOTP2, "2", "Enter OTP2", "OTP");
			InputValue(fppage.tvOTP3, "3", "Enter OTP3", "OTP");

		} else {
			while (!isDisplayedAfterWait(login.txt_loginWithPassword, 2)) {
				InputValue(fppage.tvOTP1, "1", "Enter OTP1", "OTP");
				if (isDisplayedAfterWait(login.Ok, 2))
					login.Ok.click();
			}
		}

		if (RunEnvironment.equals("iOSLocal")) {
			waitForElementToBeDisplayed(login.txt_OtpLimitExceedError, "Wait for OTP error message", "");
			login.VerifyAlertMessage("Cannot resend OTP");
			sa.assertEquals(getText(login.txt_OtpLimitExceedError, "Get text"),
					"You have exceeded the maximum number of attempts in a day. Please try again later.",
					"Incorrect OTP error text doesn't match");
			click(login.txt_loginWithPassword, "click on login wih password link", "");

		} else {
			waitForElementToBeDisplayed(login.txt_OtpLimitExceedError, "Wait for OTP error message", "");
			sa.assertEquals(getText(login.txt_OtpLimitExceedError, "Get text"),
					"You have exceeded the maximum number of attempts in a day. Please try again later.",
					"Incorrect OTP error text doesn't match");

			sa.assertEquals(login.txt_loginWithPassword.getText(), "Login with password");
			click(login.txt_loginWithPassword, "click on login wih password link", "");
			sa.assertTrue(isDisplayed(login.editTextUserName));

		}
		sa.assertAll();
	}

	@Test(priority = 11, description = "Verify the email id should be present when we go back on login page")
	public void OTP12() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		waitForElementToBeDisplayed(login.editTextUserName, "wait for login page to load", "");
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			sa.assertEquals(login.editTextUserName.getText(), AppStringConstants.validEmailOTP1 , "Email id does not match on the Login page");
		} else {
			sa.assertEquals(login.editTextUserName.getText(), AppStringConstants.validEmailOTP2 , "Email id does not match on the Login page");

		}

		sa.assertAll();
	}

	@Test(priority = 12, description = "Verify the OTP should not be generated from loginpage for the email id which have exceeded the OTP limit")
	public void OTP13() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		click(login.LoginWithOTPButton, "click on Login witth OTP button", "");
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			sa.assertEquals(login.txt_OtpLimitExceedFooterError.getText(), "Cannot resend OTP",
					"Footer error on login page does not match");
			sa.assertEquals(login.txt_OtpLimitExceedFooterServerError.getText(),
					"You have exceeded the maximum number of attempts in a day. Please try again later.",
					"Footer server error on login page does not match");
		} else {
			waitForElementToBeDisplayed(login.txt_OtpLimitExceedError, "Wait for OTP error message", "");
			login.VerifyAlertMessage("Cannot resend OTP");
			sa.assertEquals(getText(login.txt_OtpLimitExceedError, "Get text"),
					"You have exceeded the maximum number of attempts in a day. Please try again later.",
					"Incorrect OTP error text doesn't match");
			click(login.Ok, "click on login wih password link", "");

		}
		sa.assertAll();
	}

}
