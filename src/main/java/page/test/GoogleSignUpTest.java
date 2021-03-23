package page.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import android.shaadi.BasePageActions;
import data.ReactRegData;
import page.actions.BottomMenu;
import page.actions.LoginPage;
import page.actions.MyShaadiPage;
import page.actions.RegistrationPage;
import shaadi.utils.AppStringConstants;
import shaadi.utils.MinAccess;

public class GoogleSignUpTest extends BasePageActions {

	String userStatus;
	LoginPage login;
	BottomMenu menu;
	MyShaadiPage shaadipage;
	RegistrationPage register;
	Object[][] returnValue;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {

		login = new LoginPage();
		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
		register = new RegistrationPage();
		
		userStatus = MinAccess.removeEmailFromMin();
	}

	@Test(priority = 0, groups = "", description = "Navigate to Google sign up page")
	public void clickOnGoogleSignUp() throws Exception {
		
		if(userStatus.equalsIgnoreCase("Active")) {
		if (RunEnvironment.equals("iOSLocal")) {
			login.Allow();
		}

		waitForElementToBeDisplayed(login.GoogleSignUpBtn, "", "");
		login.GoogleSignUpBtn.click();
		}
		else {
			
			Assert.fail("Cannot run the test as the user still exist");
			
		}

	}

	@Test(priority = 1, groups = "", description = "select the available email id from the google sign up page" , dependsOnMethods = {"clickOnGoogleSignUp"})
	public void selectEmailFromGoogleSignUpPage() throws Exception {

		waitForElementToBeDisplayed(login.existingEmailIdGoogleSignUp, "Wait for email id to be present", "");

		if (login.existingEmailIdGoogleSignUp.getText().equalsIgnoreCase(AppStringConstants.googleSignInEmail)) {
			login.existingEmailIdGoogleSignUp.click();

		}

		else {
			Assert.assertTrue(false, "Required email id does not exist");
		}

	}

	@Test(priority = 2, groups = "", description = "Complete Reg flow with the selected gmail account", dataProvider = "getReactRegData" , dependsOnMethods = {"selectEmailFromGoogleSignUpPage"})
	public void completeRegFlow(ReactRegData reg1Data) throws Exception {

		Thread.sleep(15000);

		if (RunEnvironment.equalsIgnoreCase("androidlocal")) {

			System.out.println("Changing context to web");

			register.changeContext("WEBVIEW_com.shaadi.android");
		}

		register.performReg(reg1Data);
		
		menu.clickMyShaadiTab();
		scrollDownToElement(shaadipage.AccountSettingsIOS);
		shaadipage.clickOnAccountSettings();

		if (isDisplayedAfterWait(shaadipage.lblEmailID, 10)) {
			if (RunEnvironment.equalsIgnoreCase("ioslocal")) {
				shaadipage.lblEmailID.click();
				Assert.assertEquals(shaadipage.lbl_exisitngEmail.getText(), AppStringConstants.googleSignInEmail ,  "Mail id does not match after registration");
				driver.navigate().back();
			} else {
				Assert.assertEquals(shaadipage.lblEmailID.getText(), AppStringConstants.googleSignInEmail , "Mail id does not match after registration");
			}

		}

		shaadipage.ClickLogout();
		Thread.sleep(3000);

	}
	
	@Test(priority = 2, groups = "", description = "verify Google Sign in functionality" , dependsOnMethods = {"completeRegFlow"})
	public void verifyGoogleSinIn() throws Exception {
		
			Thread.sleep(3000);
			waitForElementToBeDisplayed(login.googleLoginButton, "Wait for login with Google button", "");
			login.googleLoginButton.click();
			waitForElementToBeDisplayed(login.existingEmailIdGoogleSignUp, "Wait for email id to be present", "");

			if (login.existingEmailIdGoogleSignUp.getText().equalsIgnoreCase(AppStringConstants.googleSignInEmail)) {
				login.existingEmailIdGoogleSignUp.click();

			}

			else {
				Assert.assertTrue(false, "Required email id does not exist");
			}
			
			
			Thread.sleep(15000);
			menu.clickMyShaadiTab();
			scrollDownToElement(shaadipage.AccountSettingsIOS);
			shaadipage.clickOnAccountSettings();

			if (isDisplayedAfterWait(shaadipage.lblEmailID, 10)) {
				if (RunEnvironment.equalsIgnoreCase("ioslocal")) {
					shaadipage.lblEmailID.click();
					Assert.assertEquals(shaadipage.lbl_exisitngEmail.getText(), AppStringConstants.googleSignInEmail , "Mail id does not match after Google Sign in");
					driver.navigate().back();
				} else {
					Assert.assertEquals(shaadipage.lblEmailID.getText(), AppStringConstants.googleSignInEmail , "Mail id does not match after Google Sign in");
				}

			}

			shaadipage.ClickLogout();
			Thread.sleep(3000);
		
	}
	

	@DataProvider
	public Object[][] getReactRegData() throws FileNotFoundException {
		try {
			File ReactPage1_json = new File("src/main/java/data/reactreg_EmptyCase.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(ReactPage1_json.getAbsolutePath()));
			JsonElement dataSet = jsonData.getAsJsonObject().get("Reg1Data");
			List<ReactRegData> testData = new Gson().fromJson(dataSet, new TypeToken<List<ReactRegData>>() {
			}.getType());
			returnValue = new Object[testData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = testData.get(index++);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return returnValue;
	}

}
