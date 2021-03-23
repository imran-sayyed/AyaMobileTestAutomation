package page.test;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;

public class Hide_Profile_test extends BasePageActions {

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
		AssertEquals(shaadipage.MyShaadiHeaderTextAndroid, "My Shaadi", "Verfiy successful landing on Myshaadi page");

	}

	@Test(priority = 1, description = "Scroll and click on Account settings")
	public void scrollAndClickOnAccountSettings() throws InterruptedException {

		shaadipage.scrollAndClickOnAccountSettings();
		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "", "");
		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "", "");
		AssertEquals(shaadipage.AlertsTabText, "Alerts", "");

		boolean flag = shaadipage.PushNotificationButton.getText().equals("Push Notifications & Sounds")
				|| shaadipage.PushNotificationButton.getText().equals("Push Notifications and Sounds");
		Assert.assertTrue(flag);

	}

	@Test(priority = 2, description = "Scroll and click on Hide/Delete profile on Account Settings page")
	public void scrollAndClickOnHide_Delete_Profile() throws InterruptedException {

		shaadipage.scrollAndClickOnHideDelete();
		waitForElementToBeDisplayed(shaadipage.HideTitle, "", "");
		AssertEquals(shaadipage.HideTitle, "Hide Profile", "");

	}

	@Test(priority = 3, description = "Hide profile for 1 week")
	public void hideProfile() throws InterruptedException {
		shaadipage.clickOnHide();
		shaadipage.clickOnSave();
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			waitForElementToBeDisplayed(shaadipage.HideTitle, "", "");
			AssertEquals(shaadipage.HideTitle, "Unhide Profile", "");
			String text = shaadipage.profileStatus.getText();
			boolean flag = text.contains("Your Profile is hidden until");
			Assert.assertTrue(flag);
		} else {
			waitForElementToBeDisplayed(shaadipage.unHideTitle, "", "");
			AssertEquals(shaadipage.unHideTitle, "Unhide Profile", "");

		}

		waitForElementToBeDisplayed(shaadipage.backButton, "", "");
		click(shaadipage.backButton, "click on back button", "");
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test(priority = 4, description = "verify profile hidden on My shaadi dashboard")
	public void verifyProfileHidden() throws InterruptedException {
		menu.clickMyShaadiTab();
		Thread.sleep(90000);
		scrollUp();// refresh the page
		scrollUp();// refresh the page
		waitForSometime(1000);
		shaadipage.scrolltillpremiummatches();
		shaadipage.ClickGotit();
		waitForSometime(2000);
		scrollDownToElement(shaadipage.profileCurrentlyHidden);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(shaadipage.profileCurrentlyHidden));
		Assert.assertEquals(shaadipage.profileCurrentlyHidden.getText(), "Your profile is currently hidden");
	}

	@Test(priority = 5, description = "Unhide the profile and verify by going to Hide/Delete tab under account Settings")
	public void unhideProfile() throws InterruptedException {
		click(shaadipage.unHideNow, "", "tc");
		click(shaadipage.unHide, "description", "tc");
		click(shaadipage.okButton, "", "");

		// Go again and check whether the profile is unhidden
		menu.clickMyShaadiTab();
		shaadipage.scrollAndClickOnAccountSettings();
		waitForElementToBeDisplayed(shaadipage.AlertsTabText, "", "");
		shaadipage.scrollAndClickOnHideDelete();
		waitForElementToBeDisplayed(shaadipage.HideTitle, "", "");
		AssertEquals(shaadipage.HideTitle, "Hide Profile", "");

	}

}
