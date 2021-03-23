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

public class ReactReg_NRITest extends BasePageActions {

	Object[][] returnValue;
	LoginPage login; 
	RegistrationPage register;
	BottomMenu menu;
	MyShaadiPage shaadipage;	

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		login = new LoginPage();
		register = new RegistrationPage();
		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
		if (RunEnvironment.equals("iOSLocal")) {
			login.Allow();
		}

	}


	@Test(priority = 0, description = "verify the Registration flow", dataProvider = "getReactRegData")
	public void RegistrationTest(ReactRegData reg1Data) throws InterruptedException {

		Thread.sleep(2000);



		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			if (isDisplayedAfterWait(login.btnSignupFree, 5)) {
				login.btnSignupFree.click();

			}
			
			Thread.sleep(4000);
			
			if (isDisplayedAfterWait(login.btnSignupFree, 5)) {
				login.btnSignupFree.click();

			}
			
			register.changeContext("WEBVIEW_com.shaadi.android");
		}
		
		else {
			
			if (isDisplayed(login.btnSignupFree)) {
				login.btnSignupFree.click();
			}
			
			else {
				if (isDisplayed(login.btn_SignupOnLoginPage)) {
					login.btn_SignupOnLoginPage.click();
				}
			}

			
		}


		Thread.sleep(4000);

		register.regpage1(reg1Data);
		register.regpage2(reg1Data);
		register.regpage3(reg1Data);
		register.regpage4(reg1Data);
		Thread.sleep(5000);

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			register.changeContext("NATIVE_APP");
		}
		
		
		System.out.println("Context changed to native");

		//Thread.sleep(5000);

			register.completeRegFlow();
		
		menu.clickMyShaadiTab();
		scrollDownToElement(shaadipage.AccountSettingsIOS);
		shaadipage.clickOnAccountSettings();

		if (isDisplayedAfterWait(shaadipage.lblEmailID, 10)) {
			if (RunEnvironment.equalsIgnoreCase("ioslocal")) {
				shaadipage.lblEmailID.click();
				Assert.assertEquals(shaadipage.lbl_exisitngEmail.getText(), register.username);
				driver.navigate().back();
			} else {
				Assert.assertEquals(shaadipage.lblEmailID.getText(), register.username);
			}

		}

		shaadipage.ClickLogout();
		
		Thread.sleep(3000);
		
		if(RunEnvironment.equalsIgnoreCase("iosLocal"))
		{
			if(isDisplayed(login.btn_SignupOnLoginPage))
			{
				login.btn_SignupOnLoginPage.click();
			}
		}

	}

	@DataProvider
	public Object[][] getReactRegData() throws FileNotFoundException {
		try {
			File ReactPage1_json = new File("src/main/java/data/reactreg_NRI.json");
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
