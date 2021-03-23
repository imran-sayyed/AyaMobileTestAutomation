package page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;

public class Alert_and_VerificationbadgeTest extends BasePageActions {

	BottomMenu menu;
	MyShaadiPage shaadipage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();

	}

	@Test(priority = 0, description = "Navigate to MyShaadi page")
	public void navigateToMyShaadiPage() throws InterruptedException {

		menu.clickMyShaadiTab();
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verify successful landing on Myshaadi page");

	}

	@Test(priority = 1, description = "Scroll and click on Account settings")
	public void scrollAndClickOnAccountSettings() throws InterruptedException {

		shaadipage.ScrollToView_AccountSettings();
		shaadipage.clickOnAccountSettings();
		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "Wait for Account Settings page to load", "");
		AssertEquals(shaadipage.AlertsTabText, "Alerts", "Verify Alert text on Account settings page");
		
		boolean flag = shaadipage.PushNotificationButton.getText().equals("Push Notifications & Sounds")
				|| shaadipage.PushNotificationButton.getText().equals("Push Notifications and Sounds");
		Assert.assertTrue(flag);

	}

	@Test(priority = 2, description = "click on Alerts")
	public void clickOnAlerts() throws InterruptedException {

		shaadipage.clickOnAlerts();

	}

	@Test(priority = 3, description = "Turn OFF all the alerts is ON")
	public void turnOFFAllAlerts() throws InterruptedException {

		shaadipage.turnOffAlerts();
		click(shaadipage.backButton, "click on back button", "");

	}

	@Test(priority = 4, description = "Verify all the alerts are OFF")
	public void verifyAllAlertOFF() throws InterruptedException {

		shaadipage.clickOnAlerts();

		shaadipage.verifyAndAssertAlertOFF();
			
			
		}

	

	@Test(priority = 5, description = "Turn ON  all alerts")
	public void turnONAllAlerts() throws InterruptedException {
		scrollUp();
		shaadipage.turnOnAlerts();
		waitForElementToBeClickable(shaadipage.backButton, "Wait for back button to be visible", "");
		click(shaadipage.backButton, "click on back button", "");

	}

	@Test(priority = 6, description = "scroll and click on verification badge button")
	public void clickOnVerificationBadgeTab() throws InterruptedException {

		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "wait for Account Settings page to load", "");
		shaadipage.scrollAndClickOnVerificationBadge();
		AssertEquals(shaadipage.verificationBadge, "Verification Badge", "Verifying if verification badge visible");

	}

	@Test(priority = 7, description = "Click on visible and not visible")
	public void verifyVerficationBadgeRadioButton() throws InterruptedException {

		shaadipage.verifyAndAssertVerificationBadge();

	}

}
