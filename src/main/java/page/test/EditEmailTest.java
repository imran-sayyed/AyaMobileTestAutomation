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
import data.EmailData;
import page.actions.MyShaadiPage;
import page.actions.BottomMenu;

public class EditEmailTest extends BasePageActions {

	Object[][] returnValue;
	BottomMenu menu;
	MyShaadiPage shaadipage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();

	}

	@Test(priority = 0, groups = "", description = "Navigate to Myshaadi tab and Click on Account Settings")
	public void NavigateAccountSettings() throws InterruptedException {
		menu.clickMyShaadiTab();
		shaadipage.ScrollToView_AccountSettings();
		shaadipage.clickOnAccountSettings();
		if (RunEnvironment.equals("iOSLocal")) {
			waitForElementToBeDisplayed(shaadipage.EditEmailButton, "wait for page to load", "");
			shaadipage.EditEmailButton.click();
		}
		shaadipage.VerifyExitsingEmailID();
		if (RunEnvironment.equals("iOSLocal")) {

			Assert.assertFalse(enabled(shaadipage.btnSubmit,
					"Check whether SAVE button in disbaled when email field is blank", "EditEmail-06"));
		}
	}

	@Test(priority = 1, groups = "", dataProvider = "getEmailData", description = "Validate email id and password field with multiple data set")
	public void EditEmailVerification(EmailData emailData) throws InterruptedException {

		shaadipage.UpdateAndSubmitEmailID(emailData.emailId, emailData.emailErrorMessage, emailData.password,
				emailData.passwordErrorMessage, emailData.forgotPassword);

	}

	@DataProvider
	public Object[][] getEmailData() throws FileNotFoundException {
		try {
			File email_json = new File("src/main/java/data/email_id.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(email_json.getAbsolutePath()));
			JsonElement emailDataSet = jsonData.getAsJsonObject().get("emailData");
			List<EmailData> emailData = new Gson().fromJson(emailDataSet, new TypeToken<List<EmailData>>() {
			}.getType());
			returnValue = new Object[emailData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = emailData.get(index++);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return returnValue;
	}

}