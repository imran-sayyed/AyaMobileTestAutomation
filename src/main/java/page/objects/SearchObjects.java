package page.objects;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;
import org.openqa.selenium.WebElement;

public class SearchObjects {

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	public static List<WebElement> actionBarItemSearch;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public static WebElement btnGotIt;

	@iOSFindBy(name="viewBottomDock.label")
	@FindBy(id = "com.shaadi.android:id/btn_search")
	public static WebElement btnSearchNow;

	@FindBy(id = "com.shaadi.android:id/img_cta_connect_now")
	public static WebElement btnConnectNow;

	@FindBy(className = "com.shaadi.android:id/rl_cta_connect_layout")
	public static List<WebElement> searchlistcardlayout;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_marital_status")
	public static WebElement dropDownMartialStatusList;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[15]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_photo")
	public static WebElement dropDownPhotoSettingsList;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[6]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_religion")
	public static WebElement dropDownReligion;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[8]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_display_language")
	public static WebElement dropDownMotherTongue;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[7]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_caste")
	public static WebElement dropDownCommunity;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_country")
	public static WebElement dropDownCountry;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[11]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_state")
	public static WebElement dropDownState;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[12]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_city")
	public static WebElement dropDownCity;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[9]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_manglik")
	public static WebElement dropDownManglik;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[15]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_photo")
	public static WebElement dropDownPhoto;

	// @FindBy(className="android.widget.TextView")
	// public static List<WebElement> classTextView;
 
	@iOSFindBy(xpath="//XCUIElementTypeSwitch[contains(@name, 'Include Profiles')]")
	@FindBy(id = "com.shaadi.android:id/set_visible_photos2")
	public static WebElement filterToggle;

	@iOSFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Include Profiles that I have  already viewed\"]")
	@FindBy(id = "com.shaadi.android:id/set_visible_photos3")
	public static WebElement profilesViewedToggle;
	
	@iOSFindBy(xpath="//XCUIElementTypeNavigationBar[contains(@name, 'Search Results')]")
	public static WebElement txtSearchResult;
	
	@iOSFindBy(name="Members matching your search criteria")
	public static WebElement txtMatchConfirmation;

	@FindBy(id = "com.shaadi.android:id/label")
	public static List<WebElement> textViewData;

	@iOSFindBy(name = "Done")
	@FindBy(id = "com.shaadi.android:id/tv_apply")
	public static WebElement textViewApply;

	@iOSFindBy(xpath = "//XCUIElementTypeCell[5]/XCUIElementTypeStaticText")
	@FindBy(id = "com.shaadi.android:id/set_kid_status")
	public static WebElement dropDownChildrenlist;

	@iOSFindBy(id = "imageViewBanner")
	public static WebElement btncloseLayer;

	@iOSFindBy(name = "btnSkip.label")
	public static WebElement btnSkipInvitation;

	@iOSFindBy(name = "More Search Options")
	public static WebElement btnMoreSearch;
	
	@iOSFindBy(name="arrow left white")
	public static WebElement btnNavBack;
	
	@iOSFindBy(name="Search")
	public static WebElement fldSearchText;

	// @FindBy(id="com.shaadi.android:id/btnSearchByID")
	// public static WebElement btnGoToProfile;

	// @FindBy(id="com.shaadi.android:id/rangebar_height")
	// public static WebElement imageViewRangeBarHeight;

}
