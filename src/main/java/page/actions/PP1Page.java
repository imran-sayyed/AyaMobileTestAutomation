package page.actions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.PP1PageObjects;
import shaadi.utils.AppStringConstants;

public class PP1Page extends PP1PageObjects {

	public SoftAssert ppAssert = new SoftAssert();

	public void clickContinueButton() {

		click(btnContinue, "Click on the Payment Plan Continue button", "");

	}

	public void clickproceedButton() {

		click(btn_Proceed, "Click on Proceed button", "Payments-08");
	}

	public void OrderSummaryView(String orderSummary, String planMonthlyAmount, String PaymentPlans,
			Boolean ProfileBooster, String ProfileBoosterValue, Boolean ContributetoShaadiCares,
			String ContributetoShaadiCaresValue, String TotalAmount) {

		if (ContributetoShaadiCares) {
			enabled(cbContributeShaadiCares, "Click Contribute to Shaadi Cares", "Payments-07");
		}

		clickproceedButton();
	}

	public void scrollDownTillContinue() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.30)).waitAction(4000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public void swipeLeftOnPaymentpage() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press((int) (size.getWidth() * 0.85), size.getHeight() / 2).waitAction(2000)
				.moveTo((int) (size.getWidth() * 0.15), size.getHeight() / 2).release().perform();

	}

	public void verifyPaymentPlan(WebElement planLocater, WebElement planName, WebElement planDuration,
			WebElement buttonContinue, String plName, String plDuration, String msg) throws InterruptedException {

		planLocater.click();

		ppAssert.assertEquals(planName.getText(), plName, "The Plan With this name is seen");

		ppAssert.assertEquals(planDuration.getText(), plDuration, "The Plan duration is verified");

		if (!isDisplayed(buttonContinue)) {
			scrollDownTillContinue();
		}

		ppAssert.assertTrue(chckElementPresent(buttonContinue), "Continue Button for this Plan is also seen");

		ppAssert.assertAll();

	}

	public void verifyTextNarration(WebElement benefits, String checkNarration, String msg)

	{

		assertEquals(benefits.getText(), checkNarration, msg);
		System.out.println(benefits.getText());

	}

	public void verifySelectShaadi() throws InterruptedException {

		btn_ViewPlansSelectShaadi.click();

		scrollDownToElement(txt_FAQ);

		scrollUpToElement(txt_ChoosePlanSelectShaadi);

		Thread.sleep(3000);

		assertEquals(txt_ChoosePlanSelectShaadi.getText(), "Choose Your Plan", "Select Shaadi Plan Selection is seen");

		verifyTextNarration(txt_ThreeMonthsPlan, "3 MONTHS", "Three months Plans for Select shaadi is seen");
		verifyTextNarration(txt_Price_ThreeMonthsPlan, "₹29,900",
				"Price for Three months Plans for Select shaadi is seen");

		verifyTextNarration(txt_SixMonthsPlan, "6 MONTHS", "Six months Plans for Select shaadi is seen");
		verifyTextNarration(txt_Price_SixMonthsPlan, "₹54,900",
				"Price for Three months Plans for Select shaadi is seen");

	}

	public void verifyPlanAmount() {
		String amount = planPrice.getText();
		if (!isDisplayed(btnContinue)) {
			scrollDownTillContinue();

		}
		btnContinue.click();
		waitForElementToBeDisplayed(btn_Proceed, "", "");
		click(btn_Proceed, "", "");
		waitForElementToBeDisplayed(creditCardPP2Android, "", "");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void verifySelectShaadiAndroid() {
		String text = "";
		boolean flag = false;
		scrollDownToElement(viewPlansButtonAndroid);

		// click on view plans button for select shaadi
		click(viewPlansButtonAndroid, "click on view plans button", "");

		// Verify 3 month plan
		waitForElementToBeDisplayed(SelectShaadiPlanDuartion.get(0), "", "");
		verifyTextNarration(SelectShaadiPlanDuartion.get(0), "3 months",
				"Three months Plans for Select shaadi is seen");
		click(SelectShaadiPlanDuartion.get(0), "", "");
		String planAmount = SelectShaadiPlanAmount.get(0).getText();
		scrollDownToElement(selectShaadiContinueButton);
		click(selectShaadiContinueButton, "", "");
		waitForElementToBeDisplayed(btn_Proceed, "", "");
		AssertEquals(txtAmount, planAmount, "");
		click(btn_Proceed, "", "");
		waitForElementToBeDisplayed(creditCardPP2Android, "", "");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);

		// verify 6 month plan
		waitForElementToBeDisplayed(SelectShaadiPlanDuartion.get(1), "", "");
		verifyTextNarration(SelectShaadiPlanDuartion.get(1), "6 months", "Six months Plans for Select shaadi is seen");
		click(SelectShaadiPlanDuartion.get(1), "", "");
		String planAmount1 = SelectShaadiPlanAmount.get(1).getText();
		click(selectShaadiContinueButton, "", "");
		waitForElementToBeDisplayed(btn_Proceed, "", "");
		AssertEquals(txtAmount, planAmount1, "");
		click(btn_Proceed, "", "");
		waitForElementToBeDisplayed(creditCardPP2Android, "", "");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void verifyPaymentWindow() throws InterruptedException {
		btn_PPlusContinue.click();

		Thread.sleep(3000);

		waitForElementToBeDisplayed(txt_ConfirmPurchase, "Purchase POP UP Should be seen", "TC 07");

		verifyTextNarration(txt_ConfirmPurchase, "Confirm Your In‑App Purchase",
				"Purchase Confirmation POP-UP is seen  ");
		verifyTextNarration(btn_BuyPurchase, "Buy", "Buy button is seen for the user");

		Thread.sleep(3000);

		btn_CancelPurchase.click();

		verifyTextNarration(txt_PaymentCancel, "Payment Cancelled", "Payment Cancelled Pop up is seen");

		verifyTextNarration(txt_ItuneConnectFailed, "Cannot connect to iTunes Store",
				"Cannot connect to iTunes Store is seen");
		Thread.sleep(3000);

		btn_OK.click();

	}

	public void verifyGoldPlan() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			verifyPaymentPlan(btn_GProd, lbl_GProdName, lbl_GProdDuration, btn_GContinue, "GOLD", "3 MONTHS",
					"Gold Plan is Veriffied");

			verifyTextNarration(lbl_GProdDesc_0, AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_GProdDesc_1, AppStringConstants.txtViewContact75,
					"The Described Benefits for this plan is seen");

		}

		else {

			verifyPaymentPlan(planTabList.get(1), planName, planDuration, btnContinue, "GOLD", "3 MONTHS",
					"Gold Plan is Veriffied");

			verifyTextNarration(benefitDescription.get(0), AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(1), AppStringConstants.txtViewContact75,
					"The Described Benefits for this plan is seen");
			
			verifyTextNarration(benefitDescription.get(2), AppStringConstants.videoCallMatches,
					"The Described Benefits for this plan is seen");
			
			verifyPlanAmount();

		}

	}

	public void verifyGoldPlusPlan() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
			verifyPaymentPlan(btn_GPlusProd, lbl_GPlusProdName, lbl_GPlusProdDuration, btn_GPlusContinue, "GOLD PLUS",
					"3 MONTHS", "Gold Plus Plan is Veriffied");

			verifyTextNarration(lbl_GPlusProdDesc_10, AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_GPlusProdDesc_11, AppStringConstants.txtViewContact150,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_GPlusProdDesc_12, AppStringConstants.txtStandOut,
					"The Described Benefits for this plan is seen");
		}

		else {

			verifyPaymentPlan(planTabList.get(2), planName, planDuration, btnContinue, "GOLD PLUS", "3 MONTHS",
					"Gold Plus Plan is Veriffied");

			verifyTextNarration(benefitDescription.get(0), AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(1), AppStringConstants.txtViewContact150,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(2), AppStringConstants.videoCallMatches,
					"The Described Benefits for this plan is seen");
			
			verifyTextNarration(benefitDescription.get(3), AppStringConstants.txtStandOut,
					"The Described Benefits for this plan is seen");

			verifyPlanAmount();

		}

	}

	public void verifyDiamondPlan() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			verifyPaymentPlan(btn_DProd, lbl_DProdName, lbl_DProdDuration, btn_DContinue, "DIAMOND", "6 MONTHS",
					"Diamond Plan is Veriffied");

			verifyTextNarration(lbl_DProdDesc_20, AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_DProdDesc_21, AppStringConstants.txtViewContact150,
					"The Described Benefits for this plan is seen");
		}

		else {

			verifyPaymentPlan(planTabList.get(3), planName, planDuration, btnContinue, "DIAMOND", "6 MONTHS",
					"Diamond Plan is Veriffied");

			verifyTextNarration(benefitDescription.get(0), AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(1), AppStringConstants.txtViewContact150,
					"The Described Benefits for this plan is seen");
			
			verifyTextNarration(benefitDescription.get(2), AppStringConstants.videoCallMatches,
					"The Described Benefits for this plan is seen");
			
			

			verifyPlanAmount();

		}
	}

	public void verifyDiamondPlusPlan() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			verifyPaymentPlan(btn_DPlusProd, lbl_DPlusProdName, lbl_DPlusProdDuration, btn_DPlusContinue,
					"DIAMOND PLUS", "6 MONTHS", "Diamond  Plus Plan is Veriffied");

			verifyTextNarration(lbl_DPlusProdDesc_30, AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_DPlusProdDesc_31, AppStringConstants.txtViewContact300,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_DPlusProdDesc_32, AppStringConstants.txtStandOut,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_DPlusProdDesc_33, AppStringConstants.txtLetMacthesContact,
					"The Described Benefits for this plan is seen");
		}

		else {

			verifyPaymentPlan(planTabList.get(4), planName, planDuration, btnContinue, "DIAMOND PLUS", "6 MONTHS",
					"Diamond  Plus Plan is Veriffied");

			verifyTextNarration(benefitDescription.get(0), AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(1), AppStringConstants.txtViewContact300,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(2), AppStringConstants.videoCallMatches,
					"The Described Benefits for this plan is seen");
			
			verifyTextNarration(benefitDescription.get(3), AppStringConstants.txtStandOut,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(4), AppStringConstants.txtLetMacthesContact,
					"The Described Benefits for this plan is seen");

			verifyPlanAmount();

		}
	}

	public void verifyPlatinumPlusPlan() throws InterruptedException {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {

			verifyPaymentPlan(btn_PPlusProd, lbl_PPlusProdName, lbl_PPlusProdDuration, btn_PPlusContinue,
					"PLATINUM PLUS", "12 MONTHS", "Platinum Plus Plan is Veriffied");

			verifyTextNarration(lbl_PPlusProdDesc_40, AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_PPlusProdDesc_41, AppStringConstants.txtViewContact600,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_PPlusProdDesc_42, AppStringConstants.txtStandOut,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(lbl_PPlusProdDesc_43, AppStringConstants.txtLetMacthesContact,
					"The Described Benefits for this plan is seen");
		} else {

			verifyPaymentPlan(planTabList.get(5), planName, planDuration, btnContinue, "PLATINUM PLUS", "12 MONTHS",
					"Platinum Plus Plan is Veriffied");

			verifyTextNarration(benefitDescription.get(0), AppStringConstants.txtSendBenifits,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(1), AppStringConstants.txtViewContact600,
					"The Described Benefits for this plan is seen");
			
			verifyTextNarration(benefitDescription.get(2), AppStringConstants.videoCallMatches,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(3), AppStringConstants.txtStandOut,
					"The Described Benefits for this plan is seen");

			verifyTextNarration(benefitDescription.get(4), AppStringConstants.txtLetMacthesContact,
					"The Described Benefits for this plan is seen");

			verifyPlanAmount();

		}
	}

}
