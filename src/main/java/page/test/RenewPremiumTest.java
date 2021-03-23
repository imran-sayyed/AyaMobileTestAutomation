package page.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.actions.MyShaadiPage;

public class RenewPremiumTest extends BasePageActions {

	Object[][] returnValue;
	BottomMenu menu;
	MyShaadiPage shaadipage;
	MatchesPage matches;

	@BeforeClass(alwaysRun = true)
	public void initialize() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();
		matches = new MatchesPage();

	}

	@Test(priority = 0, groups = "" , description = "Verify Renew Premium Tab on Myshaadi Dashboard")
	public void Renew_Premium() throws Exception {

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			menu.clickMyShaadiTab();
			shaadipage.renewPremium();
			menu.clickOnMatches();
			matches.navigateToMyMatches();
			shaadipage.RenewPremiumonBanner();

	}

}
