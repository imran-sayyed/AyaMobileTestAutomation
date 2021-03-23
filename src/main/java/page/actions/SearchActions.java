package page.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import android.shaadi.BasePageActions;
import data.SearchData;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import page.objects.SearchObjects;

public class SearchActions extends BasePageActions {

	public static void TextFoundAndClick(List<WebElement> Locator, String ExpectedText, String Description,
			String TCID) {
		boolean found = false;
		String strExpected = ExpectedText;
		while (!found) {
			int size = 0;
			size = size + Locator.size();
			for (int i = 0; i < size; i++) {
				String strActual = Locator.get(i).getText();
				if (strActual.equals(strExpected)) {
					System.out.print("Text: " + Locator.get(i).getText());
					click(Locator.get(i), Description, TCID);
					found = true;
					break;
				}
			}
			if (!found) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(350, 1000).moveTo(350, 980).release().perform();
			}
		}
	}

	public static void ClickSearch() {
		if (RunEnvironment.equals("iOSLocal")) {

			// WebElement newtopnav = driver.findElementByAccessibilityId("New");
			// click(newtopnav, "Click new in top Tab", "search-01");
			WebElement searchtopnav = driver.findElementByAccessibilityId("Search");
			click(searchtopnav, "Click search in top nav", "search-02");
		} else

			click(SearchObjects.actionBarItemSearch.get(0), "Click on Search", "Search-01");
	}

	public static void clickPreferenceField(String statusValue, int index) {
		if (RunEnvironment.equals("iOSLocal")) {

			// Should be able to select the cell for table structure implemented
			@SuppressWarnings("unchecked")
			List<WebElement> SearchList = driver.findElements(By.xpath("//XCUIElementTypeCell"));

			SearchList.get(index).findElement(By.xpath("//XCUIElementTypeStaticText")).click();

		}

		else {
			boolean found = false;
			while (!found)
				found = isElementFoundAndClickable(SearchObjects.dropDownMartialStatusList, "Click on Marital Status",
						"Search-02");
		}
	}

	public static void selectStatusValue(String statusValue, int size) throws InterruptedException

	{
		if (RunEnvironment.equals("iOSLocal")) {

			if (!statusValue.equals("Doesn't Matter")) {

				SearchObjects.fldSearchText.sendKeys(statusValue);

				driver.findElement(By.name("" + statusValue)).click();

			} else {

				driver.findElement(By.name("" + statusValue)).click();
			}

		}

		else {

			for (int i = 0; i < size; i++) {
				ScrollToText(SearchObjects.textViewData, statusValue, "Click" + statusValue, "Search-03");
				i++;
			}
		}
	}

	public void assertSelectedStatus(String Maritalstatus, WebElement elementName) {
		if (RunEnvironment.equals("iOSLocal")) {

			String expStatus = elementName.getText();

			String[] actualStatus = Maritalstatus.replace(";", "").trim().split(",");

			String[] expectedStatus = expStatus.replace(";", "").trim().split(",");

			removeWhiteSpaces(actualStatus);

			removeWhiteSpaces(expectedStatus);

			Arrays.sort(actualStatus);

			Arrays.sort(expectedStatus);

			Assert.assertEquals(actualStatus, expectedStatus);

		}

		else {
			AssertEquals(SearchObjects.dropDownMartialStatusList, Maritalstatus, "Assert Marital Status Text");
		}

	}

	public String[] removeWhiteSpaces(String[] temp) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].trim();

		}
		return temp;
	}

	public static void ClickHaveChildren(String HaveChildren) {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownChildrenlist, "Click on kid status", "Search-07");
	}

	public void AssertHaveChildren(String HaveChildren) {
		AssertEquals(SearchObjects.dropDownChildrenlist, HaveChildren, "Assert Children Status Text");
	}

	public static void SelectHaveChildrenValue(String HaveChildren, int size) {

		if (RunEnvironment.equals("iOSLocal")) {

			// Generic code written to select value from picker wheel in iOS
			selectValueFromPickerWheel(HaveChildren);

		} else {
			for (int i = 0; i < size; i++) {
				ScrollToText(SearchObjects.textViewData, HaveChildren, "Click" + HaveChildren, "Search-03");
				i++;
			}
		}

	}

	public static void selectValueFromPickerWheel(String selectStr) {
		WebDriver wd = driver;

		IOSElement picker = (IOSElement) new WebDriverWait(wd, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypePickerWheel")));

		picker.setValue(selectStr);
	}

	public static void ClickReligion() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownReligion, "Click on Religion", "Search-03");
	}

	public static void SelectReligionValue(String Religion, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, Religion, "Click" + Religion, "Search-03");
			i++;
		}
	}

	public void AssertReligion(String Religion) {
		AssertEquals(SearchObjects.dropDownReligion, Religion, "Assert Religion");
	}

	public static void ClickCommunity(String Community) {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownCommunity, "Click on Community", "Search-04");
	}

	public static void ClickMotherTongue() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownMotherTongue, "Click on Mothertongue",
					"Search-05");
	}

	public static void SelectMotherTongueValue(String MotherTongue, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, MotherTongue, "Click" + MotherTongue, "Search-03");
			i++;
		}
	}

	public void AssertMotherTongue(String Mothertongue) {
		AssertEquals(SearchObjects.dropDownMotherTongue, Mothertongue, "Assert Mother Tongue");
	}

	public static void ClickCommunity() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownCommunity, "Click on Community", "Search-04");
	}

	public static void SelectCommunityValue(String Community, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, Community, "Click" + Community, "Search-03");
			i++;
		}
	}

	public void AssertCommunity(String Community) {
		AssertEquals(SearchObjects.dropDownCommunity, Community, "Assert Community");
	}

	public static void ClickCountry() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownCountry, "Click on Country", "Search-06");
	}

	public static void SelectCountryValue(String Country, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, Country, "Click" + Country, "Search-03");
			i++;
		}
	}

	public void AssertCountry(String Country) {
		AssertEquals(SearchObjects.dropDownCountry, Country, "Assert Country");
	}

	public static void ClickState() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownState, "Click on State", "Search-06");
	}

	public static void SelectStateValue(String State, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, State, "Click" + State, "Search-03");
			i++;
		}
	}

	public void AssertState(String State) {
		AssertEquals(SearchObjects.dropDownState, State, "Assert State");
	}

	public static void ClickCity() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownCity, "Click on City", "Search-06");

	}

	public static void SelectCityValue(String City, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, City, "Click" + City, "Search-03");
			i++;
		}
	}

	public void AssertCity(String City) {
		AssertEquals(SearchObjects.dropDownCity, City, "Assert City");
	}

	public static void ClickManglik() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownManglik, "Click on Manglik", "Search-07");
	}

	public static void SelectManglikValue(String Manglik, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, Manglik, "Click" + Manglik, "Search-03");
			i++;
		}
	}

	public void AssertManglik(String Manglik) {
		AssertEquals(SearchObjects.dropDownManglik, Manglik, "Assert Manglik");
	}

	public static void ClickPhotoSettings() {
		boolean found = false;
		while (!found)
			found = isElementFoundAndClickable(SearchObjects.dropDownPhoto, "Click on Photo Settings", "Search-07");
	}

	public static void SelectPhotoValue(String PhotoSettings, int size) {
		for (int i = 0; i < size; i++) {
			ScrollToText(SearchObjects.textViewData, PhotoSettings, "Click" + PhotoSettings, "Search-07");
			i++;
		}
	}

	public void AssertPhotoSettings(String PhotoSettings) {
		AssertEquals(SearchObjects.dropDownPhoto, PhotoSettings, "Assert Photo");
	}

	public static void ClickFilterOutToggle() {
		ScrollTill(SearchObjects.filterToggle, "Scroll till filter toggle", "Search-03");
	}

	public static void ClickProfileViewedToggle() {
		ScrollTill(SearchObjects.profilesViewedToggle, "Scroll till Profile Viewed toggle", "Search-03");

	}

	public static void ClickApply() {
		click(SearchObjects.textViewApply, "Click on Apply", "Search-05");
	}

	public static void ScrollTo_Search() throws InterruptedException {
		scrollUpToDown();
		Thread.sleep(3000);
		scrollUpToDown();
		Thread.sleep(3000);
		scrollUpToDown();

	}

	/*
	 * public static void ClickSearchNow1()
	 * 
	 * { click(SearchObjects.btnSearchNow,"Click on Search Now","Search-10"); }
	 * 
	 */
	public static void ClickListConnect()

	{
		click(SearchObjects.btnConnectNow, "Click on Connect", "Search-11");
		// SearchObjects.searchlistcardlayout.get(0).findElement(By.id("com.shaadi.android:id/img_cta_connect_now")).click();;
	}

	public static void ClickSearchNow() {
		ScrollTill(SearchObjects.btnSearchNow, "Scroll Search Button", "Search-12");
	}

	public String convertToStr(ArrayList<Object> statusField, int size) {
		Set<String> strBuilder = new HashSet<>();
		String strConcat = null;

		for (int j = 0; j < size; j++) {
			;
			String primaryStr = statusField.get(j).toString().trim();
			strBuilder.add(primaryStr);
			strConcat = String.join(",", strBuilder);

		}
		return strConcat;
	}

	public void checkSearchResultPage() {
		Assert.assertTrue(isDisplayed(SearchObjects.txtSearchResult), "Search Page is Visible to the user");
		Assert.assertTrue(isDisplayed(SearchObjects.txtMatchConfirmation), "Search Page is Visible to the user");

	}

	public void checkMaritialStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 3);// index for maritial status is 3

		selectStatusValue("Doesn't Matter", 1);

		ClickApply();

		clickPreferenceField("", 3);

		for (int i = 0; i < searchData.maritalStatus.size(); i++) {
			selectStatusValue(searchData.maritalStatus.get(i).toString(), searchData.maritalStatus.size());
		}

		ClickApply();

		if (searchData.maritalStatus.size() > 1) {

			assertSelectedStatus(convertToStr(searchData.maritalStatus, searchData.maritalStatus.size()),
					SearchObjects.dropDownMartialStatusList);

		}

		else {

			assertSelectedStatus(searchData.maritalStatus.get(0).toString(), SearchObjects.dropDownMartialStatusList);
		}
	}

	public void checkChildrenStatus(SearchData searchData) {
		clickPreferenceField("", 4);// clicking on have children field

		SelectHaveChildrenValue("Doesn't Matter", 1);// selecting value from pickerwheel iOS

		ClickApply();

		clickPreferenceField("", 4);// clicking on have children again

		for (int i = 0; i < searchData.haveChildren.size(); i++) {
			// the below code cannot work on ioS since at a time only one value can be
			// selected
			// from the picker wheel ,which is not the same in the case of Android

			SelectHaveChildrenValue(searchData.haveChildren.get(i).toString(), searchData.haveChildren.size());

			// selectStatusValue(searchData.haveChildren.get(i).toString(),
			// searchData.haveChildren.size());
		}

		ClickApply();

		if (searchData.haveChildren.size() > 1) {
			AssertHaveChildren("Multiple Selected");
		} else {
			AssertHaveChildren(searchData.haveChildren.get(0).toString());
		}
	}

	public void checkReligionStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 5);// CLICKING RELIGION FIELD WITH INDEX 5
		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR RELEGION
		ClickApply();
		clickPreferenceField("", 5);
		for (int i = 0; i < searchData.religion.size(); i++) {
			selectStatusValue(searchData.religion.get(i).toString(), searchData.religion.size());// REPLACED WITH
																									// GENERIC BEHAVIOUR

		}

		ClickApply();

		if (searchData.religion.size() > 1) {

			assertSelectedStatus(convertToStr(searchData.religion, searchData.religion.size()),
					SearchObjects.dropDownReligion);// REPLACED WITH GENERIC
			// BEHAVIOUR

		} else {
			assertSelectedStatus(searchData.religion.get(0).toString(), SearchObjects.dropDownReligion);
		}

	}

	public void checkComunityStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 6); // CLICKING Community FIELD WITH INDEX 6

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR Community

		ClickApply();

		clickPreferenceField("", 6);

		for (int i = 0; i < searchData.community.size(); i++) {
			selectStatusValue(searchData.community.get(i).toString(), searchData.community.size());// REPLACED WITH
			// GENERIC BEHAVIOUR
		}

		ClickApply();

		if (searchData.community.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.religion, searchData.religion.size()),
					SearchObjects.dropDownCommunity);// REPLACED WITH GENERIC
			// BEHAVIOUR
		} else {
			assertSelectedStatus(searchData.community.get(0).toString(), SearchObjects.dropDownCommunity);
		}
	}

	public void checkMotherTongue(SearchData searchData) throws InterruptedException {

		clickPreferenceField("", 7);// CLICKING MOTHER TOUGUE FIELD WITH INDEX 5

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR MOTHER TOUNGE

		ClickApply();

		clickPreferenceField("", 7);

		for (int i = 0; i < searchData.motherTongue.size(); i++) {
		
			selectStatusValue(searchData.motherTongue.get(i).toString(), searchData.motherTongue.size());

		}

		ClickApply();

		if (searchData.motherTongue.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.motherTongue, searchData.motherTongue.size()),
					SearchObjects.dropDownMotherTongue);// REPLACED WITH
			// GENERIC
			// BEHAVIOUR

		} else {
			AssertMotherTongue(searchData.motherTongue.get(0).toString());
		}
	}

	public void checkCountryStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 9);// CLICKING COUNTRY FIELD WITH INDEX 9

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR COUNTRY

		ClickApply();

		clickPreferenceField("", 9);

		for (int i = 0; i < searchData.country.size(); i++) {
			selectStatusValue(searchData.country.get(i).toString(), searchData.country.size());// REPLACED WITH GENERIC
																								// BEHAVIOUR

		}

		ClickApply();

		if (searchData.country.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.country, searchData.country.size()),
					SearchObjects.dropDownCountry);// REPLACED WITH GENERIC
			// BEHAVIOUR

		} else {
			AssertCountry(searchData.country.get(0).toString());
		}
	}

	public void checkStateStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 10);// CLICKING STATE FIELD WITH INDEX 10

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR STATE

		ClickApply();

		clickPreferenceField("", 10);// CLICKING STATE FIELD WITH INDEX 10

		for (int i = 0; i < searchData.state.size(); i++) {
			selectStatusValue(searchData.state.get(i).toString(), searchData.state.size());// REPLACED WITH GENERIC
																							// BEHAVIOUR

		}

		ClickApply();

		if (searchData.state.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.state, searchData.state.size()), SearchObjects.dropDownState);// REPLACED
																														// WITH
																														// GENERIC
			// BEHAVIOUR

		} else {
			AssertState(searchData.state.get(0).toString());
		}

		// scrollUpToDown();
	}

	public void checkCityStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 11);// CLICKING City FIELD WITH INDEX 11

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR STATE

		ClickApply();

		clickPreferenceField("", 11);// CLICKING STATE FIELD WITH INDEX 11

		for (int i = 0; i < searchData.city.size(); i++) {
			selectStatusValue(searchData.city.get(i).toString(), searchData.city.size());// REPLACED WITH GENERIC
																							// BEHAVIOUR

		}
		ClickApply();

		if (searchData.city.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.city, searchData.city.size()), SearchObjects.dropDownCity);// REPLACED
																													// WITH
																													// GENERIC
			// BEHAVIOUR

		} else {
			AssertCity(searchData.city.get(0).toString());
		}
	}

	public void checkManglikStatus(SearchData searchData) {
		ClickManglik();

		SelectManglikValue("Doesn't Matter", 1);

		ClickApply();

		ClickManglik();

		for (int i = 0; i < searchData.Manglik.size(); i++) {
			SelectManglikValue(searchData.Manglik.get(i).toString(), searchData.Manglik.size());
		}

		ClickApply();

		if (searchData.Manglik.size() > 1) {
			AssertManglik("Multiple Selected");
		} else {
			AssertManglik(searchData.Manglik.get(0).toString());
		}

	}

	public void checkPhotoStatus(SearchData searchData) throws InterruptedException {
		clickPreferenceField("", 14);// CLICKING PHOTO FIELD WITH INDEX 14

		selectStatusValue("Doesn't Matter", 1);// SELECTING VALUE FOR PHOTO

		ClickApply();

		clickPreferenceField("", 14);// CLICKING PHOTO FIELD WITH INDEX 14

		for (int i = 0; i < searchData.PhotoSettings.size(); i++) {
			selectStatusValue(searchData.PhotoSettings.get(i).toString(), searchData.PhotoSettings.size());// REPLACED
																											// WITH
																											// GENERIC
																											// BEHAVIOUR
		}

		ClickApply();

		if (searchData.PhotoSettings.size() > 1) {
			assertSelectedStatus(convertToStr(searchData.PhotoSettings, searchData.PhotoSettings.size()),
					SearchObjects.dropDownPhotoSettingsList);// REPLACED
			// WITH
			// GENERIC
			// BEHAVIOUR

		}

		else {
			AssertPhotoSettings(searchData.PhotoSettings.get(0).toString());
		}
	}
}