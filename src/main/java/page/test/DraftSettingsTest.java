package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;

public class DraftSettingsTest extends BasePageActions {

	BottomMenu menu;
	MyShaadiPage shaadipage;
	public static String actualConnectMessage;
	String[] connectMessage = {"Hello, I liked your Profile","Hello, I liked your Profile!!!!"};
	String[] acceptMessage = {"Hello, I liked your Profile too","Hello, I liked your Profile too!!!"};
	String[] remindMessage = {"Hello","Hello!!"};

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		shaadipage = new MyShaadiPage();

	}

	@Test(priority = 1, description = "Navigate to My Shaadi Page")
	public void SD01() throws InterruptedException {

		menu.clickMyShaadiTab();

	}

	@Test(priority = 2, description = "Go to Messages")
	public void SD02() throws InterruptedException {

		shaadipage.ScrollToView_AccountSettings();
		shaadipage.clickOnAccountSettings();
		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "Wait for Account Settings page to load", "");
		AssertEquals(shaadipage.AlertsTabText, "Alerts", "Verify Alert title on Account settings page");
		scrollDownToElement(shaadipage.messageTabShaadiPage);
		shaadipage.messageTabShaadiPage.click();

	}

	@Test(priority = 3, description = "Verify Messages Tab text")
	public void SD03() throws InterruptedException {

		waitForSometime(1000);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			shaadipage.scrollDownTillRemindMessage();
		}

		shaadipage.assertMessageWindow();

	}

	@Test(priority = 4, description = "Edit Connect Message")
	public void SD04() throws InterruptedException {

		shaadipage.editMessage(connectMessage, 0, shaadipage.connectMessageButtonIOS , "Connect");

	}

	@Test(priority = 5, description = "Edit Accept Message")
	public void SD05() throws InterruptedException {

		shaadipage.editMessage(acceptMessage, 1, shaadipage.acceptMessageButtonIOS , "Accept");

	}

	@Test(priority = 6, description = "Edit Reminder Message")
	public void SD06() throws InterruptedException {

		shaadipage.editMessage(remindMessage, 2, shaadipage.reminderMessageButtonIOS , "Remind");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();

	}

	@Test(priority = 7, description = "Send Connect and Verify saved draft text")
	public void SD07() throws InterruptedException {

		menu.clickMyShaadiTabForAppRating();
		shaadipage.verifyConnectMessage(actualConnectMessage);

	}

}
