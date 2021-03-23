package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;
import page.actions.PP1Page;
import page.actions.PP2Page;

public class PaymentPageTest extends BasePageActions {

	PP1Page pp1;
	PP2Page pp2;
	BottomMenu menu;
	MyShaadiPage shaadipage;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {
		pp1 = new PP1Page();
		pp2 = new PP2Page();
		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();

	}

	@Test(priority = 0, description = "Navigate to MyShaadi page")
	public void navigateToMyShaadiPage() throws InterruptedException {

		menu.clickMyShaadiTab();
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verfiy successful landing on Myshaadi page");

	}

	@Test(priority = 1, description = "Click on Upgrade Now button and navigate to PP1 page")
	public void clickOnUpgradeNowButton() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		waitForElementToBeDisplayed(shaadipage.btnUpgradeNow, "", "");
		if (shaadipage.btnUpgradeNow.getText().equalsIgnoreCase("Upgrade Now")) {
			sa.assertEquals(shaadipage.btnUpgradeNow.getText(), "Upgrade Now");
		} else {
			sa.assertEquals(shaadipage.btnUpgradeNow.getText(), "RENEW PREMIUM");
		}
		click(shaadipage.btnUpgradeNow, "Click on Upgrade Now button on MyShaadi page", "");
		sa.assertAll();

	}

	@Test(priority = 2, description = "Verify Gold Plan for the user")
	public void verifyGoldPlan() throws InterruptedException {

		Thread.sleep(3000);

		pp1.verifyGoldPlan();

	}

	@Test(priority = 3, description = "Verify Gold Plus Plan for the user")
	public void verifyGoldPlusPlan() throws InterruptedException {

		pp1.verifyGoldPlusPlan();

	}

	@Test(priority = 4, description = "Verify Diamond Plan for the user")
	public void verifyDiamondPlan() throws InterruptedException {

		pp1.verifyDiamondPlan();

	}

	@Test(priority = 5, description = "Verify Diamond Plus Plan for the user")
	public void verifyDiamondPlusPlan() throws InterruptedException {

		pp1.verifyDiamondPlusPlan();

	}

	@Test(priority = 6, description = "Verify Platinum Plus Plan for the user")
	public void verifyPlatinumPlusPlan() throws InterruptedException {

		pp1.verifyPlatinumPlusPlan();

	}

	@Test(priority = 7, description = "Verify Payment Option for User")
	public void verifyPaymentOption() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			pp1.verifyPaymentWindow();
		}

	}

	@Test(priority = 8, description = "Verify Select Shaadi for the User")
	public void verifySelectShaadi() throws InterruptedException {

		Thread.sleep(2000);
		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			scrollDownToElement(pp1.btn_ViewPlansSelectShaadi);
			pp1.verifySelectShaadi();
		} else {
			pp1.verifySelectShaadiAndroid();
		}

	}

}
