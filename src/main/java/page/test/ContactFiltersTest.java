package page.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import android.shaadi.BasePageActions;
import data.MatchmakingDashboardData;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class ContactFiltersTest extends BasePageActions {

	BottomMenu menu;
	MyShaadiPage shaadipage;
	MatchesPage matches;
	Object[][] returnValue;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
		matches = new MatchesPage();

	}

	@Test(priority = 0, description = "Navigate to MyShaadi page")
	public void navigateToMyShaadiPage() throws InterruptedException {

		menu.clickMyShaadiTab();
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verfiy successful landing on Myshaadi page");

	}

	@Test(priority = 1, description = "Scroll on MyShaadi page and click on Contact Filters button")
	public void scrollAndClickOnContactFilters() throws InterruptedException {

		SoftAssert sa = new  SoftAssert();
		shaadipage.ScrollToView_AccountSettings();
		shaadipage.clickOnContactFilters();
		waitForElementToBeDisplayed(shaadipage.contactFiltersHeaderText, "Wait for Contact Filters page to load", "");

		sa.assertTrue(isDisplayed(shaadipage.contactFiltersHeaderText));
		
		sa.assertTrue(isDisplayed(shaadipage.contactFiltersFooterText));

		sa.assertAll();
		
	}

	@Test(priority = 2, description = "Verfiy contact filter functionality", dataProvider = "DashboardsearchData")
	public void verfiyContactFiltersTab(MatchmakingDashboardData DashboardsearchData) throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		waitForElementToBeDisplayed(shaadipage.religionDropdownTextContactFilters(),
				"Wait for Contact filters page to load", "");
		shaadipage.selectingParameters_contactFilters(shaadipage.martialStatusDropdownTextContactFilters(),
				DashboardsearchData.maritalStatus);
		shaadipage.selectingParameters_contactFilters(shaadipage.religionDropdownTextContactFilters(),
				DashboardsearchData.religion);
		scrollDownToElement(shaadipage.moreFiltersContactFilters);
		Thread.sleep(1000);
		shaadipage.moreFiltersContactFilters.click();
		shaadipage.selectingParameters_contactFilters(shaadipage.communityDropdownTextContactFilters(),
				DashboardsearchData.community);
		Thread.sleep(2000);
		scrollDown();
		shaadipage.selectingParameters_contactFilters(shaadipage.motherTongueDropdownTextContactFilters(),
				DashboardsearchData.motherTongue);

		shaadipage.selectingParameters_contactFilters(shaadipage.countryDropdownTextContactFilters(),
				DashboardsearchData.country);

		click(shaadipage.btn_saveContactFilter, "Click on SAVE button on Contact Filters page", "");
		if (isDisplayed(shaadipage.SendConnectBtn)) {
			click(shaadipage.SendConnectBtn, "click on continue button", "");
		}
		boolean flag = isDisplayed(shaadipage.myShaadi);
		sa.assertTrue(flag, "Back to Myshaadi page");
		sa.assertAll();

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
