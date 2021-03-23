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
import data.UploadPhotoCardData;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class UploadPhotoCardTest extends BasePageActions {
	BottomMenu menu;
	MatchesPage matches;
	Object[][] returnValue;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		menu = new BottomMenu();
		matches = new MatchesPage();
	}

	@Test(priority = 0, groups = "", description = "Verify landing on My Matches page and validate the photo upload card")
	public void UploadPhoto() throws Exception {
		menu.clickOnMatches();
		BasePageActions.navigateToMatchesTab(matches.myMatchesTab);
		matches.ScrolTillPhotoCard();
		// scrollDownToUp();
		// matches.VerifyCardDetails();
		matches.ClickPhoto();
		// ClickPhotoShutterButton();
	}

	@DataProvider
	public Object[][] UploadPhotoCardData() throws FileNotFoundException {
		try {
			File UploadPhotoCard_json = new File("src/main/java/data/UploadPhotoCard.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(UploadPhotoCard_json.getAbsolutePath()));
			JsonElement dataSet = jsonData.getAsJsonObject().get("UploadPhotoCardData");
			List<UploadPhotoCardData> testData = new Gson().fromJson(dataSet,
					new TypeToken<List<UploadPhotoCardData>>() {
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
