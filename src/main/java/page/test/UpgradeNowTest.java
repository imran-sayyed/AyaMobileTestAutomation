package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class UpgradeNowTest extends BasePageActions {

	BottomMenu menu;
	MyShaadiPage shaadipage;
	MatchesPage matches;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
		matches = new MatchesPage();

	}

	@Test(priority = 0, groups = "")
	public void Upgrade_Now_Cta() throws Exception {

			verifyText(menu.MyShaadiTab, "My Shaadi", " Verify My Matches Text");
			//click(menu.MyShaadiTab, "Click on My Shaadi tab DASHBOARD ", "Test-02");
			menu.clickMyShaadiTab();
			verifyText(shaadipage.btnUpgradeNow, "Upgrade Now", " Verify Upgrade Now Text");
			click(shaadipage.btnUpgradeNow, "Click on Upgrade Now ", "Test-02");
			Thread.sleep(2000);
			//((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			driver.navigate().back();
			verifyText(menu.MatchesTab, "Matches", " Verify My Matches Text");
			click(menu.MatchesTab, "Click on Matches tab DASHBOARD ", "Test-02");
			Thread.sleep(2000);
			//((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Upgrade Now\"));").click();
			
			scrollDownToElement(matches.btn_UpgradeNow);
			
			Thread.sleep(2000);
			//((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			driver.navigate().back();



	}

}
