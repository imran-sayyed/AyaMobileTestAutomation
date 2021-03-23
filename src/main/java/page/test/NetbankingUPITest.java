package page.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import android.shaadi.BasePageActions;
import data.PaymentRevampData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.actions.BottomMenu;
import page.actions.MyShaadiPage;
import page.actions.PP1Page;
import page.actions.PP2Page;

public class NetbankingUPITest extends BasePageActions {

	Object[][] returnValue;
	PP1Page pp1;
	PP2Page pp2;
	BottomMenu menu;
	MyShaadiPage shaadipage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
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
		waitForElementToBeDisplayed(shaadipage.btnUpgradeNow,
				"Wait for Upgrade Now button to be visible on MYshaadi page", "");
		if (shaadipage.btnUpgradeNow.getText().equalsIgnoreCase("Upgrade Now")) {
			sa.assertEquals(shaadipage.btnUpgradeNow.getText(), "Upgrade Now");
		} else {
			sa.assertEquals(shaadipage.btnUpgradeNow.getText(), "RENEW PREMIUM");
		}
		click(shaadipage.btnUpgradeNow, "", "");
		sa.assertAll();

	}

	@Test(priority = 2, dataProvider = "getPaymentRevampData", description = "Verify Net Banking and UPI payments type with different set of data")
	public void verifyNetBankingAndUPIPayments(PaymentRevampData ppData) throws Exception {

		if (!isDisplayed(pp1.btnContinue)) {
			scrollDown();
		}
		pp1.clickContinueButton();
		boolean isButtonProceedDisplayed = false;
		isButtonProceedDisplayed = isDisplayed(pp1.btn_Proceed);
		if (isButtonProceedDisplayed) {
			pp1.OrderSummaryView(ppData.orderSummary, ppData.planMonthlyAmount, ppData.paymentPlans,
					ppData.profileBooster, ppData.profileBoosterValue, ppData.contributeToShaadiCares,
					ppData.contributeToShaadiCaresValue, ppData.totalAmount);
		}

		for (int i = 0; i < ppData.paymentType.size(); i++) {
			pp2.ChoosePaymentMethod(ppData.paymentType.get(i).cardType);
			if (ppData.paymentType.get(i).cardType.equals("Net Banking")) {
				pp2.PaymentNetbanking(ppData.paymentType.get(i).bankName, ppData.totalAmount,
						ppData.paymentType.get(i).netbankingMessage);
			}
			if (ppData.paymentType.get(i).cardType.equals("UPI")) {
				pp2.PaymentUPI(ppData.paymentType.get(i).upiName, ppData.paymentType.get(i).upiErrorMessage,
						ppData.paymentType.get(i).isUPIIntent);
			}
		}

		boolean isContinueButtonFound = false;
		while (!isContinueButtonFound) {
			Thread.sleep(1000);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			isContinueButtonFound = isDisplayed(pp1.btnContinue) || isDisplayed(pp1.planPrice);
		}

	}

	@DataProvider
	public Object[][] getPaymentRevampData() throws FileNotFoundException {
		try {
			File PP1_json = null;
			PP1_json = new File("src/main/java/data/netbankingupi.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(PP1_json.getAbsolutePath()));
			JsonElement dataSet = jsonData.getAsJsonObject().get("ppData");
			List<PaymentRevampData> testData = new Gson().fromJson(dataSet, new TypeToken<List<PaymentRevampData>>() {
			}.getType());
			returnValue = new Object[testData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = testData.get(index++);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return returnValue;
	}

}
