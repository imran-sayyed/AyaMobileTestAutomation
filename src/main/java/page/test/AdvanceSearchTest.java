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
import data.AdvanceSearchData;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class AdvanceSearchTest extends BasePageActions {

	BottomMenu menu;
	MatchesPage matches;
	Object[][] returnValue;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		menu = new BottomMenu();
		matches = new MatchesPage();

	}

	@Test(priority = 0, description = "Navigate to search tab")
	public void navigateToSearchTab() throws InterruptedException {

		menu.clickOnMatches();
		matches.clickSearch();
	}

	@Test(priority = 1, groups = "", enabled = true, dataProvider = "searchData", description = "Verify Advance search functionality")
	public void verifyAdvanceSearch(AdvanceSearchData searchData) throws Exception {

		waitForSometime(2000);
		matches.verifyAdvanceSearchNew(searchData);


	}

	@Test(priority = 2, description = "check profile ID search")
	public void profileIDsearch() throws InterruptedException {

		menu.clickOnMatches();
		matches.verifyProfileSearch();

	}

	@DataProvider
	public Object[][] searchData() throws FileNotFoundException {

		try {
			File search_json = new File("src/main/java/data/advanceSearch.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(search_json.getAbsolutePath()));
			JsonElement searchDataSet = jsonData.getAsJsonObject().get("searchSet");
			List<AdvanceSearchData> searchData = new Gson().fromJson(searchDataSet,
					new TypeToken<List<AdvanceSearchData>>() {
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
