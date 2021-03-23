
package page.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import android.shaadi.BasePageActions;
import data.SearchData;
import page.actions.MatchesPage;
import page.objects.MatchesPageObjects;

public class SearchTest extends BasePageActions {

	Object[][] returnValue;

	MatchesPage matches;

	public static SoftAssert asrtSrch = new SoftAssert();

	static boolean setFlag = false;

	public static boolean clickFlag = true;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {

		matches = new MatchesPage();
		// closeUnWantedPage();
		matches.clickSearch();
		Thread.sleep(6000);

	}

	@Test(priority = 1, groups = "", dataProvider = "getSearchData", description = "Search test using Different Data Set")
	public void BaseSearchTest(SearchData searchData) throws Exception {

		matches.checkMaritialStatus(searchData);

		matches.checkChildrenStatus(searchData);

		matches.checkReligionStatus(searchData);

//		matches.checkComunityStatus(searchData);//Page Source not available

		scrollDownToElement(MatchesPage.dropDownCountry);

//		matches.checkMotherTongue(searchData);

		matches.checkCountryStatus(searchData);

		matches.checkStateStatus(searchData);

//		matches.checkCityStatus(searchData);

//	    checkManglikStatus(searchData);//Page source not available

		scrollDownToElement(matches.dropDownPhotoSettingsList);

		matches.checkPhotoStatus(searchData);

		// Should be performed only for the first data set
		if (setFlag == false) {
			scrollDownToElement(matches.btnMoreSearch);

			matches.btnMoreSearch.click();

			setFlag = true;
		}

		BasePageActions.scrollToTextIos("Annual Income");// Name identifier for Annual Income

		scrollDownToElement(matches.filterToggle);

		matches.filterToggle.click();

		matches.profilesViewedToggle.click();

		matches.btnSearchNow.click();

		matches.checkSearchResultPage();

		matches.btnNavBack.click();

		asrtSrch.assertAll();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		scrollUpToElement(MatchesPageObjects.dropDownMartialStatusList);

		// ClickListConnect();

//		Thread.sleep(5000);
//		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	@DataProvider
	public Object[][] getSearchData() throws FileNotFoundException {
		try {
			File search_json = new File("src/main/java/data/search_ios.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(search_json.getAbsolutePath()));
			JsonElement searchDataSet = jsonData.getAsJsonObject().get("searchSet");
			List<SearchData> searchData = new Gson().fromJson(searchDataSet, new TypeToken<List<SearchData>>() {
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
