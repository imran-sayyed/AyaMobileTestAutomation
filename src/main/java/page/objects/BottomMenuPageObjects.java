package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BottomMenuPageObjects extends BasePageActions {
	
	@AndroidFindBy(id = "com.shaadi.android:id/progress_bar")
	public static WebElement ProgressBar;

	@AndroidFindBy(id = "com.shaadi.android:id/design_bottom_sheet")
	public WebElement AppRatingLayer;

	@AndroidFindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	@iOSFindBy(id = "Skip")
	public WebElement AcceptBannerdissmiss;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMatches")
	@iOSFindBy(id="Matches")
	public WebElement MatchesTab;

	@AndroidFindBy(id = "com.shaadi.android:id/rlMatches")	
	@iOSFindBy(id="Matches")
	public WebElement MyMatches;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_exit_stack")
	@iOSFindBy(id = "buttonClose")
	public WebElement CloseStackicon;

	@AndroidFindBy(id = "com.shaadi.android:id/rlInvite")
	@iOSFindBy(id = "Inbox")
	public WebElement inbox;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_count_heading")
	public WebElement QuickResponseHeader;


	@AndroidFindBy(id = "com.shaadi.android:id/rlMyShaadi")
	@iOSFindBy(id="My Shaadi")
	public WebElement MyShaadiTab;

	@AndroidFindBy(id = "com.shaadi.android:id/rlChat")
	@iOSFindBy(id="Chat")
	public WebElement chatTabAndroid;
	
	@iOSFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "com.shaadi.android:id/img_cancel")
	public WebElement imgVIPShaadiCancel;

}
