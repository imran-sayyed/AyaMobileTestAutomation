package page.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import android.shaadi.BasePageActions;
import data.LoginData;
import page.actions.BottomMenu;
import page.actions.LoginPage;
import page.actions.MyShaadiPage;

public class LoginTest extends BasePageActions {
	Object[][] liveUser, sandboxUser;
	boolean isSandboxTesting = false;
	LoginPage login;
	BottomMenu menu;
	MyShaadiPage shaadipage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		login = new LoginPage();
		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
	}

	@Test(priority = 0, groups = "", description = "Navigate to sign in page")
	public void SignIn() throws Exception {
		if (RunEnvironment.equals("iOSLocal")) {
			login.Allow();
		}
		login.NavigateSignIn();
	}

	@Test(priority = 1, groups = "", dataProvider = "getData", description = "Verify login functionality")
	public void Login(LoginData logindata) throws Exception {
		login.InputUserNamePassword(logindata.username, logindata.password);
		login.ClickSignIn(logindata.isLogout);
		if (RunEnvironment.equals("iOSLocal")) {
			if (!logindata.headerMessage.isEmpty()) {
				login.VerifyAlertMessage(logindata.headerMessage);
				if (logindata.headerMessage.equals("Not found"))
					login.ClickCancel();
				else
					login.ClickOK();
			}
			if (logindata.isLogout) {
				menu.clickMyShaadiTab();
				shaadipage.ScrollToView_AccountSettings();
				shaadipage.clickOnAccountSettings();
				shaadipage.ClickLogout();
			}
		} else {

			if (!logindata.emailErrorMessage.isEmpty() && !logindata.passwordErrorMessage.isEmpty()) {
				login.VerifyPasswordErrorMessage(logindata.passwordErrorMessage);
				login.VerifyEmailErrorMessage(logindata.emailErrorMessage);
			}
			if (!logindata.passwordErrorMessage.isEmpty()) {
				login.VerifyPasswordErrorMessage(logindata.passwordErrorMessage);
			}
			if (!logindata.emailErrorMessage.isEmpty()) {
				login.VerifyEmailErrorMessage(logindata.emailErrorMessage);
			}

			if (logindata.isLogout) {
				menu.clickMyShaadiTab();
				shaadipage.scrollAndClickOnAccountSettings();
				shaadipage.ClickLogout();
			}
		}

	}

	@DataProvider
	public Object[][] getData() throws FileNotFoundException {
		File login_json;
		try {

			login_json = new File("src/main/java/data/login_android.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(login_json.getAbsolutePath()));
			JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
			List<LoginData> testData = new Gson().fromJson(dataSet, new TypeToken<List<LoginData>>() {
			}.getType());
			liveUser = new Object[testData.size()][1];
			sandboxUser = new Object[testData.size()][1];
			int index = 0;
			for (Object[] each : liveUser) {
				each[0] = testData.get(index++);
			}
			if (isSandboxTesting) {
				for (Object[] each : sandboxUser) {
					each[0] = testData.get(1);
					break;
				}
				return sandboxUser;
			}

		} catch (Exception e) {
			System.out.print(e);
		}
		return liveUser;
	}
}
