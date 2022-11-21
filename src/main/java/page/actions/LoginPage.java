package page.actions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import page.objects.LoginPageObjects;
import shaadi.utils.ExcelDataUtils;

public class LoginPage extends LoginPageObjects {

	public static String username;
	public static String password;

	public void Allow() {
		ClickNoException(Allow_notifications, 3, "Click Allow Notifications", "Login-01");
	}

	public void NavigateSignIn() {
		click(btnNavigateSignIn, "Click on SignIn Button to Navigate Login Page", "Login-01");
		
//		if (RunEnvironment.equalsIgnoreCase("iosLocal")) {
//			click(btnContinueWithPassword, "Click on Continue with password Button to Navigate Login Page", "Login-01");
//		}
	}

	public void NavigateSignIniOS() {
		click(btnNavigateSignIniOS, "Click on SignIn Button to Navigate Login Page", "Login-01");
	}

	public void InputUserNamePassword(String UserName, String Password) throws InterruptedException {

		driver.hideKeyboard();

		InputValue(editTextUserName, UserName, "Input Valid UserName", "Login-02");
        click(continueButton, "clicking continue Button", "");
       Thread.sleep(1000);
		InputValue(editTextPassword, Password, "Input Valid Password", "Login-03");
		
//		   if (BaseTest.AutomationRunName.equals("Appium"))
		if (RunEnvironment.equals("androidLocal")) {
			driver.hideKeyboard();
		}

	}

	public void ClickSignIn(boolean islogout) throws InterruptedException {

		click(btnMainSignIn, "Click on SignIn Button to View Home Screen","");

		if (islogout)
			Thread.sleep(5000);
	}

	public void VerifyEmailErrorMessage(String ExpectedText) throws InterruptedException {
		driver.hideKeyboard();
		AssertEquals(
				LayoutEmail.findElement(By.className("android.widget.LinearLayout"))
						.findElement(By.id("com.shaadi.android:id/textinput_error")),
				ExpectedText, "Verify invalid password message");
	}

	public void VerifyAlertMessage(String ExpectedText) throws InterruptedException {
		if (isDisplayedAfterWait(Alert, 2))
			Assert.assertEquals(Alert.getText(), ExpectedText);
		else
			Assert.assertEquals(BottomAlert.getText(), ExpectedText);

	}

	public void ClickOK() throws InterruptedException {
		if (isDisplayedAfterWait(Ok, 4))
			click(Ok, "Click Ok to close alert!", "Login-10");
		else if (isDisplayedAfterWait(Cancel, 3))
			click(Cancel, "Click Try Again button to close alert!", "Login-10");
		else
			click(try_AgainButton, "Click Try Again button to close alert!", "Login-10");

	}

	public void ClickCancel() throws InterruptedException {
		click(Cancel, "Click Cancel to close alert!", "Login-11");
	}

	public void VerifyPasswordErrorMessage(String ExpectedText) throws InterruptedException {
		Thread.sleep(1000);

		driver.hideKeyboard();
		AssertEquals(
				Layoutpassword.findElement(By.className("android.widget.LinearLayout"))
						.findElement(By.id("com.shaadi.android:id/textinput_error")),
				ExpectedText, "Verify invalid password message");

	}

	public void NavigateSignUpFree() throws InterruptedException {

		waitForElementToBeDisplayed(btnSignupFree, "wait for sign up button to be visible", "RegTest");
		click(btnSignupFree, "Click on Signup for free button", "Reg-01");
	}

	public void ClickVIPShaadiCancelIcon() {
		ClickNoException(imgVIPShaadiCancel, 5, "Click on VIP Image", "Login-07");
	}

	public void quickLogin(String userType)
			throws InterruptedException, JsonIOException, JsonSyntaxException, InvalidFormatException, IOException {

		username = ExcelDataUtils.getUserData(userType).get(0);
		password = ExcelDataUtils.getUserData(userType).get(1);
		if (RunEnvironment.equals("iOSLocal")) {
			Allow();
		}

		NavigateSignIn();

		this.InputUserNamePassword(username, password);
		this.ClickSignIn(true);
		Thread.sleep(7000);
	}

	
	public  void ClickAcceptStopPageSkip() {
		 ClickNoException(acceptStopPageSkip, 5, "Click on Skip on Accept Stop Page", "Login-06");
	 }
	 
	 public  void ClickPaymentSkip() {
		  ClickNoException(paymentSkip, 5, "Click Skip on payment stoppage", "Login-06");
		 }
	 
	 public  void ClickConnectSkip() {
		  ClickNoException(connectionSkip, 5, "Click on Connection stoppage skip", "Login-07");
		 }

	

	 public  void ClickPaymentActionBarBack() throws Exception{
		try {
			 if(upgradeToPremiumNow.isDisplayed()) {
				 
				 ClickNoException(paymentArrowBack, 5, "Click on Payment Arrow Back", "Login-07");
			 }
		}
		
		catch(Exception e){
			System.out.println("");
		}
		 
	 }
	public  void ClickGotit() {
	  ClickNoException(btnGotIt, 5, "Click on Button Got it", "Login-06");
	 }

	
	
}
