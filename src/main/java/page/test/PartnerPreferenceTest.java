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
import data.MatchmakingDashboardData;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;

public class PartnerPreferenceTest extends BasePageActions  {
	
	
	
	BottomMenu menu;
	MyShaadiPage shaadipage;
	Object[][] returnValue;


	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();

	}
	
	@Test(priority = 0 , description = "Navigate to MyShaadi page")
	public void navigateToMyShaadiPage() throws InterruptedException {
		
		menu.clickMyShaadiTab();	
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verfiy successful landing on Myshaadi page");
		
	}
	
	
	
	@Test(priority = 1 , description = "Scroll on MyShaadi page and click on Partner Preferences button")
	public void scrollAndClickOnPartnerPreferences() throws InterruptedException {
		
		shaadipage.ScrollToView_AccountSettings();
		shaadipage.clickOnPartnerPreferences();
		waitForElementToBeDisplayed(shaadipage.partnerPreferenceHeaderText, "Wait for PP page to load", "");
		AssertEquals(shaadipage.partnerPreferenceHeaderText, "Tell us what you are looking for in a life partner", "Verify PP page Header text");
	
	}
	
	@Test(priority = 2 , description = "Verfiy partner preferences functionality",dataProvider = "DashboardsearchData")
	public void verfiyPartnerPreferencesTab(MatchmakingDashboardData DashboardsearchData) throws InterruptedException {


		shaadipage.selectingParametersForPP(shaadipage.martialstatusdropdowntext, DashboardsearchData.maritalStatus);

		shaadipage.selectingParametersForPP(shaadipage.religiondropdowntext, DashboardsearchData.religion);

		shaadipage.selectingParametersForPP(shaadipage.communitydropdowntext, DashboardsearchData.community);

		shaadipage.selectingParametersForPP(shaadipage.mothertonguedropdowntext, DashboardsearchData.motherTongue);
		
		Thread.sleep(1000);
		scrollDownToElement(shaadipage.moreLink);
		waitForElementToBeDisplayed(shaadipage.moreLink, "Wait for MORE link on the page to be visible", "");	
		shaadipage.moreLink.click();
		
		scrollDownToElement(shaadipage.countrydropdowntext);
		Thread.sleep(1000);
		shaadipage.selectingParametersForPP(shaadipage.countrydropdowntext, DashboardsearchData.country);

		shaadipage.selectingParametersForPP(shaadipage.statedropdowntext, DashboardsearchData.state);

		scrollDownToElement(shaadipage.qualificationdropdowntext);
		Thread.sleep(1000);
		shaadipage.selectingParametersForPP(shaadipage.qualificationdropdowntext, DashboardsearchData.education);
		shaadipage.selectingParametersForPP(shaadipage.workingwithDropdowntext, DashboardsearchData.workingWith);
		shaadipage.selectingParametersForPP(shaadipage.professionDropdowntext, DashboardsearchData.ProfessionArea);
		
		
		shaadipage.selectingParametersForPP(shaadipage.dietDropdowntext, DashboardsearchData.diet);

		
		//shaadipage.selectingParametersForPP(shaadipage.mothertonguedropdowntext, DashboardsearchData.motherTongue);

		
		click(shaadipage.saveButton, "Click on SAVE button on PP page", "");
		
		waitForElementToBeDisplayed(menu.MyShaadiTab, "Wait for MYShaadi tab to be visible", "");
	}
	
	@DataProvider
	public Object[][] DashboardsearchData() throws FileNotFoundException {
		try {
			File search_json = new File("src/main/java/data/dashboard.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(search_json.getAbsolutePath()));
			JsonElement searchDataSet = jsonData.getAsJsonObject().get("searchSet");
			List<MatchmakingDashboardData> searchData = new Gson().fromJson(searchDataSet,
					new TypeToken<List<MatchmakingDashboardData>>() {
					}.getType());
			returnValue = new Object[searchData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = searchData.get(index++);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return returnValue;
	}
	

}
