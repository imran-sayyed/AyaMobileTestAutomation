package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AyaCareAppObjects extends BasePageActions {
	
	

	@AndroidFindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	@iOSFindBy(id = "Skip")
	public WebElement AcceptBannerdissmiss;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMatches")
	@iOSFindBy(id="Matches")
	public WebElement MatchesTab;

	

}
