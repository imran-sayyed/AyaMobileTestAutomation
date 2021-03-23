package page.actions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import android.shaadi.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.PP2PageObjects;

public class PP2Page extends PP2PageObjects {

	// Choose Payment method
	public void ChoosePaymentMethod(String PaymentType) throws InterruptedException {
		if (PaymentType.equals("Cash Pickup (Estimated pickup time : 24hrs to 48 hrs)")) {
			scrollTillVisibleText("Shaadi.com Centre");
			click(txtCashPickUp, "Click " + PaymentType + "View", "");
		}
		if (PaymentType.equals("Credit Card")) {
			System.out.println("CREDIT CARD VIEW");
		}
		if (PaymentType.equals("Debit Card") || PaymentType.equals("Net Banking") || PaymentType.equals("UPI")
				|| PaymentType.equals("Payment at Bank") || PaymentType.equals("Shaadi.com Centre")) {
			scrollTillVisibleTextAndClick(PaymentType);
		}
	}

	// Method to verify Debit card and credit card payments
	public void PaymentCreditDebit(String CardType, String CardNumber, String CardHoldersName, String ExpDate,
			String cvv, String TotalAmount, String CardNumberMessage, String CardHoldersNameMessage, String CvvMessage,
			String ExpiryMessage, String totalAmount) throws InterruptedException {


		if (!CardNumber.isEmpty()) {
			InputValue(tvCardNumber, CardNumber, "Input Card Number", "");
			if (BaseTest.AutomationRunName.equals("Appium"))
				BaseTest.driver.hideKeyboard();
		}

		if (!CardHoldersName.isEmpty()) {
			InputValue(tvCardName, CardHoldersName, "Input Card Name", "");
			if (BaseTest.AutomationRunName.equals("Appium"))
				BaseTest.driver.hideKeyboard();
		}

		if (!cvv.isEmpty()) {
			InputValue(tvCVV, cvv, "Input CVV", "");
			if (BaseTest.AutomationRunName.equals("Appium"))
				BaseTest.driver.hideKeyboard();
		}

		if (!ExpDate.isEmpty()) {
			List<String> list = Arrays.asList(ExpDate.split("/"));
			System.out.println(list.get(0));
			click(SpnrMonth, "Select drop down list to select month", "");
			Point locationMonth = listview.getLocation();
			ScrollByLocationSmallView(viewListofAllBanks, 10, locationMonth, list.get(0));
			click(SpnrYear, "Select drop down list to select year", "");
			Point locationYear = listview.getLocation();
			System.out.println(list.get(1));
			ScrollByLocationSmallView(viewListofAllBanks, 10, locationYear, list.get(1));
		}

		if (CardType.equals("Debit Card")) {
			click(btnNextPaymentDebit, "Click on Debit Option Next Button", "");

		} else {
			click(btnNextPayment, "Click Next Payment Button", "");

		}

		if (!CardNumberMessage.isEmpty() && !CardHoldersNameMessage.isEmpty() && !CvvMessage.isEmpty()
				&& !ExpiryMessage.isEmpty()) {
			verifyText(tvErrorPayment.get(0), CardNumberMessage, "Verify CardNumberMessage");
			verifyText(tvErrorPayment.get(1), CardHoldersNameMessage, "Verify CardHoldersNameMessage");
			verifyText(tvErrorPayment.get(2), CvvMessage, "Verify CvvMessage");
		} else if (!CardHoldersNameMessage.isEmpty() && !CvvMessage.isEmpty()) {
			verifyText(tvErrorPayment.get(0), CardHoldersNameMessage, "Verify CardHoldersNameMessage");
			verifyText(tvErrorPayment.get(1), CvvMessage, "Verify CvvMessage");
		} else if (!CardNumberMessage.isEmpty() && !CvvMessage.isEmpty()) {
			verifyText(tvErrorPayment.get(0), CardNumberMessage, "Verify CardNumberMessage");
			verifyText(tvErrorPayment.get(1), CvvMessage, "Verify CvvMessage");
		} else if (!CardNumberMessage.isEmpty() && !CardHoldersNameMessage.isEmpty()) {
			verifyText(tvErrorPayment.get(0), CardNumberMessage, "Verify CardNumberMessage");
			verifyText(tvErrorPayment.get(1), CardHoldersNameMessage, "Verify CardHoldersNameMessage");
		}
	}

	// Method for Emi mode
	public void PaymentEmi(String BankName, String totalAmount, String totalpayabletoBank, String emiTenure,
			String CardNumber, String CardHoldersName, String ExpDate, String cvv, String TotalAmount,
			String CardNumberMessage, String CardHoldersNameMessage, String CvvMessage, String ExpiryMessage) {
	}

	// Method for Netbanking
	public void PaymentNetbanking(String BankName, String totalAmount, String netBankingMessage)
			throws InterruptedException {

		verifyText(tvNetBanking, "Net Banking", "Verify Net Banking text");

		if (!BankName.isEmpty()) {
			switch (BankName) {
			case "hdfc": {
				click(radiobuttonHDFC, "Select HDFC for Net Banking Payment", "");
				break;
			}
			case "icici": {
				click(radiobuttonICICI, "Select ICICI for Net Banking Payment", "");
				break;
			}
			case "axis": {
				click(radiobuttonAXIS, "Select AXIS for Net Banking Payment", "");
				break;
			}
			case "sbi": {
				click(radiobuttonSBI, "Select SBI for Net Banking Payment", "");
				break;
			}
			case "idbi": {
				click(radiobuttonIDBI, "Select IDBI for Net Banking Payment", "");
				break;
			}
			case "pnb": {
				click(radiobuttonPNB, "Select PNB for Net Banking Payment", "");
				break;
			}
			default: {
				click(spnrAllBanks, "Select drop down list to select bank for Net Banking Payment", "");
				Point location = listview.getLocation();
				scrollByLocation(viewListofAllBanks, 200, location, BankName);
				break;
			}
			}
			click(btnNextPayment, "Click Next Payment Button", "");
			Thread.sleep(5000);
//			Set<String> allContext = ((AppiumDriver<MobileElement>) driver).getContextHandles();
//			for (String context : allContext) {
//				if (context.contains("WEBVIEW"))
//					try {
//						driver.context(context);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				System.out.println(context);
//			}

			// changeDriverContextToWeb(BaseTest.driver);
			boolean isExistsImage = waitForPresence(hdfcVerify, 10, "Verify NetBanking Page Exists or Not!",
					"Payments-12");
			if (isExistsImage) {
			//	 changeDriverContextToNative(BaseTest.driver);
				System.out.println("isimage" + isExistsImage);
				Boolean okVisible = false;
				while (!okVisible) {
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					// okVisible = isDisplayed(OkCancel.get(3));
					okVisible = isDisplayed(OK);
					Thread.sleep(2000);
				}
				click(OK, "Click Ok to cancel the transaction", "Payments-12");
			//	changeDriverContextToNative(BaseTest.driver);

			}
		} else {
			click(btnNextPayment, "Click Next Payment Button", "Payments-12");
			verifyText(netBankingError, netBankingMessage, "Verify Net Banking Error Message");
		}
	}

	public void PaymentUPI(String UPI_ID, String errorMessage, boolean isUPIIntent) throws InterruptedException {
		if (!isUPIIntent) {
			InputValue(editTextVPA, UPI_ID, "Input UPI ID", "Payments-14");
			click(btnNextPayment, "Click continue to process VPA Payment request", "Payment-14");
			if (!errorMessage.isEmpty()) {
				verifyText(tvErrorPayment.get(0), errorMessage, "Verify Invalid UPI Address");
			} else {
				//Thread.sleep(12000);
				System.out.println("wait for 12 secs");

			}
		} else {
			String TotalAmount = (txtTotalPayment).getText();

			click(rlUpiIntent, "Click on the UPI Intent option", "Payment-45");
			click(rlUpiIntentOption.get(3), "select upi intent option", "payment-34");

			((AndroidDriver) BaseTest.driver).pressKeyCode(AndroidKeyCode.BACK);
			click(btnOk, "Click Yes on PhonePe confirmation dialogue", "payment-40");
			AssertEquals(txtPhonePeMessage, "shaadicom", "Verify shaadi.com on PhonePe");
			boolean isUPIAppExists = waitForPresence(txtPhonePeMessage, 10, "Verify UPI App is exists", "Payment-44");
			if (!isUPIAppExists) {
				verifyText(txtNoUpiApp, "You have no UPI apps installed on your phone", "Check No UPI Apps text");
				System.out.println("UPI App not found");
			}
		}
	}

	public void PaymentCashPickup(String Name, String ContactNumber, String City, String Address, String nameMessage,
			String cityMessage, String addressMessage) throws InterruptedException {
		if (nameMessage.isEmpty() && cityMessage.isEmpty() && addressMessage.isEmpty()) {
			InputValue(editNameCashPayment, Name, "Input Name in Cash Pickup", "Payments-13");
			if (driver.findElement(By.id("com.shaadi.android:id/et_contactnumber")).getText().isEmpty())
				InputValue(editContactNumberCashPayment, ContactNumber, "Input Contact Number in Cash Pickup",
						"Payments-13");
			if (BaseTest.AutomationRunName.equals("Appium"))
				BaseTest.driver.hideKeyboard();
			click(spnrCity, "Click on Dropdown to view list of cities", "Payments-13");

			scrollTillVisibleTextAndClick(City);
			InputValue(editAddressCashPayment, Address, "Input Address in Cash Pickup", "Payments-13");
			if (BaseTest.AutomationRunName.equals("Appium"))
				BaseTest.driver.hideKeyboard();
			click(btnNextPayment, "Click Next Payment Button", "Payments-13");
			ClickOnPresence(cashPickupOrderPlacedBank, 10, "Display Order Placed Screen Back Button", "Payments-13");
			Thread.sleep(8000);
			ClickOnPresence(tabShaadi, 50, "Click on Shaadi Button to view Dashboard", "Payments-13");
		} else {
			InputValue(editNameCashPayment, Name, "Input Name in Cash Pickup", "Payments-13");

			InputValue(editAddressCashPayment, Address, "Input Address in Cash Pickup", "Payments-13");

			click(btnNextPayment, "Click Next Payment Button", "Payments-13");
			verifyText(tvErrorPayment.get(0), nameMessage, "Verify Name Error Message");
			verifyText(netBankingError, cityMessage, "Verify City Error Message");
			verifyText(tvAddressError, addressMessage, "Verify Address Error Message");

		}
	}

	public void PaymentAtBank(String PayeeName, String PayeeNumber, String Message, String nameMessage)
			throws InterruptedException {
		if (nameMessage.isEmpty()) {
			InputValue(editTextPayeeName, PayeeName, "Input Payee Name", "Payments-15");
			InputValue(editTextPayeeNumber, PayeeNumber, "Input Payee Number", "Payment-15");

			click(btnPlaceOrder, "Click on Place Order button", "Payment-15");

			clickMoreWait(cashPickupOrderPlacedBank, "Display Order Placed Screen Back Button", "Payments-13");
			Thread.sleep(8000);
			clickMoreWait(tabShaadi, "Click on Shaadi Button to view Dashboard", "Payments-15");
		} else {
			InputValue(editTextPayeeName, PayeeName, "Input Payee Name", "Payments-15");

			click(btnPlaceOrder, "Click on Place Order button", "Payment-15");
			verifyText(tvErrorPayment.get(0), nameMessage, "Verify Name Error Message");
		}
	}

	public void ShaadiCentre(String City, String Message, String errorMessage) throws InterruptedException {
		if (errorMessage.isEmpty()) {
			click(spnrCity, "Click on Dropdown to view list of cities", "Payments-16");
			scrollTillVisibleTextAndClick(City);

			isElementDisplayed(textviewShaadiCentreAddress, "Is Shaadi Centre address is displayed or not",
					"Payments-16");
			click(btnNextPayment, "Click Place Order button", "Payments-16");
			verifyText(textViewOrderPlaced, Message, " Verify Thank You Page");
			clickMoreWait(cashPickupOrderPlacedBank, "Display Order Placed Screen Back Button", "Payments-13");
			Thread.sleep(8000);
			clickMoreWait(tabShaadi, "Click on Shaadi Button to view Dashboard", "Payments-15");
		} else {
			click(btnNextPayment, "Click Place Order button", "Payments-16");
			verifyText(netBankingError, errorMessage, "Verify City Error Message");
		}
	}
}
