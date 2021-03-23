package page.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import android.shaadi.BasePageActions;
import io.appium.java_client.ios.IOSElement;
import page.objects.DashboardObjects;
import page.test.DashboardTest;
import shaadi.utils.AppStringConstants;

public class DashboardActions extends BasePageActions {

	public static void ClickPartnerpreferences() {
		click(DashboardObjects.rlSettingsRow.get(0), "Click on partner Preferences", "PP-01");
	}

	public static String setMyUser() {

		String userType = null;

		System.out.println(DashboardObjects.usrAcntType.getAttribute("label"));

		try {
			if (DashboardObjects.usrAcntType.getAttribute("label").trim()
					.equalsIgnoreCase(AppStringConstants.txtFreeUser)) {

				userType = "Free";

			} else {
				userType = "Premium";
			}
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

		return userType;
	}

	public void addHoroScopeDetails(String countryName, String birthCty, String dsplyLang, String format)
			throws InterruptedException {

		Thread.sleep(2000);
		DashboardObjects.btnSelectOption.get(0).click();// clicked on countryName
		Thread.sleep(2000);
		DashboardObjects.searchFieldAstro.sendKeys(countryName);//

		// added beacuse click by id for contry name and other parameters is not working
		driver.findElement(By.className("XCUIElementTypeCell")).click();

		// driver.findElement(By.id(countryName)).click();

		DashboardObjects.btnSelectOption.get(1).click();// clicked on City of Birth
		Thread.sleep(2000);
		DashboardObjects.searchFieldAstro.sendKeys(birthCty);
		Thread.sleep(2000);
		driver.findElement(By.className("XCUIElementTypeCell")).click();
		// driver.findElement(By.name(birthCty)).click();// click on the birth city

		DashboardObjects.btnSelectOption.get(2).click();

		addTimeOfBirth("03", "25", "PM", "Exact");

		DashboardObjects.btnDone.click();

		DashboardObjects.btnSelectOption.get(3).click();// clicked on language of Display
		Thread.sleep(2000);
		driver.findElement(By.className("XCUIElementTypeCell")).click();
		// driver.findElement(By.name(dsplyLang)).click();// clicked on required
		// langauge

		DashboardObjects.btnSelectOption.get(4).click();// clicked on language of Display

		driver.findElement(By.name(format)).click();

		DashboardObjects.btnSaveAstro.click();

	}

	public void addTimeOfBirth(String hrs, String mins, String period, String confirmation) {

		selectValueFromPickerWheel(hrs, false);
		selectValueFromPickerWheel_Astro(mins, false, 2);
		selectValueFromPickerWheel_Astro(period, false, 3);
		selectValueFromPickerWheel_Astro(confirmation, false, 4);

	}

	public static void selectValueFromPickerWheel_Astro(String selectStr, boolean isclick, int index) {
		// isclick added because some picker wheel values will require click event when
		// in frame
		WebDriver wd = driver;

		IOSElement picker = (IOSElement) new WebDriverWait(wd, 60).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//XCUIElementTypePicker[@name=\"pickerTimeSelector.label\"]/XCUIElementTypePickerWheel["
						+ index + "]")));

		picker.setValue(selectStr);

		if (isclick) {
			picker.click();
		}

		System.out.println(picker.getText());

	}

	public void genericChkConn(WebElement connType, String message) throws InterruptedException {

		boolean chkcInvitaion = false;

		try {
			if (DashboardTest.setScrollFlag == true) {// added for condition based scroll
				scrollDownToElement(connType);
			}

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

		if (DashboardTest.setUserType.equals("Free")) {

			// connType.click();

			Thread.sleep(3000);

			// if(isDisplayed(DashboardTest.mat_obj.CloseUpgradePopUp))

			chkcInvitaion = chckElementPresent(connType);

			Assert.assertTrue(chkcInvitaion, "Connect Now button is seen");

		} else {

			connType.click();

			Thread.sleep(2000);

			DashboardTest.matchPage.sendMessageOnConnectPremium();

		}
	}

	public void checkToggleStatus(WebElement toggleName) {

		boolean changedTglSts;

		String tgleStatus1 = toggleName.getAttribute("value");

		System.out.println("Initial toggle status is" + tgleStatus1);

		toggleName.click();

		String tglStatus2 = toggleName.getAttribute("value");

		driver.navigate().back();

		DashboardObjects.btnPushNotification.click();

		String tglStatus3 = toggleName.getAttribute("value");// status of toggle when user tries to navigate back after
																// changing initial toggle status

		if (tglStatus3.equals(tglStatus2)) {// comparing changed and latest status

			changedTglSts = true;

			Assert.assertTrue(changedTglSts, "Toggle Status has changes when the click is Performed");

		} else {

			changedTglSts = false;

			Assert.assertTrue(changedTglSts, "Toggle Status has  not changed when the click is Performed");
		}
	}

}
