package page.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.BottomMenuPageObjects;

public class BottomMenu extends BottomMenuPageObjects {

	// Click on Myshaadi tab and dismiss the popups
	public void clickMyShaadiTab() throws InterruptedException {
		if (RunEnvironment.equals("iOSLocal")) {
			Thread.sleep(3000);
			if (isDisplayed(imgVIPShaadiCancel)) {
				imgVIPShaadiCancel.click();
			}
			click(MyShaadiTab, "Click MyShaadi Tab", "");
		} else {
			dismissPopUp(MyShaadiTab);
			waitForElementToBeClickable(MyShaadiTab, "Wait for MyShaadi button to be clickable", "");
			click(MyShaadiTab, "Click MyShaadi Tab", "EditEmail-01");
			handleBanner();
			dismissPopUp(MyShaadiTab);

		}
	}

	// Click only on Myshaadi tab,used for AppRating test
	public void clickMyShaadiTabForAppRating() throws InterruptedException {
		if (RunEnvironment.equals("iOSLocal")) {
			WebElement rlMyShaadiTab = driver.findElementByAccessibilityId("My Shaadi");
			click(rlMyShaadiTab, "Click MyShaadi Tab", "EditEmail-01");
		} else {
			dismissPopUp(MyShaadiTab);
			waitForElementToBeClickable(MyShaadiTab, "Wait for MyShaadi button to be clickable", "");
			click(MyShaadiTab, "Click MyShaadi Tab", "EditEmail-01");
		}
	}

	// Click on Inbox tab and dismiss the apprating and accepted popups if available
	public void ClickInbox() throws Exception {
		Thread.sleep(3000);
		dismissPopUp(inbox);
		waitForElementToBeClickable(inbox, "Wait for Inbox button to be clickable", "");
		click(inbox, "Click Inbox Tab", "Inbox-01");
		handleBannerForInbox();

	}

	public void clickOnlyOnInbox() throws Exception {
		dismissPopUp(inbox);
		waitForElementToBeClickable(inbox, "Wait for Inbox button to be clickable", "");
		click(inbox, "Click Inbox Tab", "Inbox-01");
		// handleBanner();

	}

	// Click on MyMatches tab and dismiss the apprating and accepted popups if
	// available
	public void clickOnMatches() throws InterruptedException {
		
		if (RunEnvironment.equals("iOSLocal")) {
			waitForElementToBeDisplayed(MyMatches, "", "");
			click(MyMatches, "click on my matches", "String tc");
		}
		else {
			dismissPopUp(MyMatches);
			waitForElementToBeClickable(MyMatches, "Wait for Matches button to be clickable", "");
			click(MyMatches, "click on my matches", "String tc");
			handleBanner();
		}
		
	}
	
	
//	public void clickOnlyOnMatches() throws InterruptedException {
//		
//		if (RunEnvironment.equals("iOSLocal")) {
//			waitForElementToBeDisplayed(MyMatches, "", "");
//			click(MyMatches, "click on my matches", "String tc");
//		}
//		else {
//			dismissPopUp(MyMatches);
//			waitForElementToBeClickable(MyMatches, "Wait for Matches button to be clickable", "");
//			click(MyMatches, "click on my matches", "String tc");
//			//handleBanner();
//		}
//		
//	}

	public void clickChatTab() throws Exception {
		dismissPopUp(chatTabAndroid);
		waitForElementToBeClickable(chatTabAndroid, "Wait for Chat button to be clickable", "");
		click(chatTabAndroid, "Click Chat Tab", "Inbox-01");
		handleBanner();

	}

	public void dismissPopUp(WebElement locator) throws InterruptedException {
		boolean flag = false;
		while (!flag) {
			if (!isDisplayed(locator)) {
				Thread.sleep(1000);
				driver.navigate().back();
			} else {
				flag = true;
			}
		}

	}

	public void handleBanner() throws InterruptedException {
		

		if (isDisplayedAfterWait(AcceptBannerdissmiss, 4)) {
			AcceptBannerdissmiss.click();
		}

		Boolean isAppRatingVisible = false;
		isAppRatingVisible = isDisplayedAfterWait(AppRatingLayer,3);
		if (isAppRatingVisible) {
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		}

	}
	
	
	public void handleBannerForInbox() throws InterruptedException {
		
		if (isDisplayedAfterWait(AcceptBannerdissmiss, 2)) {
			AcceptBannerdissmiss.click();
		}
		
		if (isDisplayedAfterWait(CloseStackicon , 3)) {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(CloseStackicon));
			CloseStackicon.click();
		}

		if (isDisplayedAfterWait(AcceptBannerdissmiss, 3)) {
			AcceptBannerdissmiss.click();
		}

		Boolean isAppRatingVisible = false;
		isAppRatingVisible = isDisplayedAfterWait(AppRatingLayer,3);
		if (isAppRatingVisible) {
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		}

	}

}
