package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;

public class PP2PageObjects extends BasePageActions {

	@FindBy(xpath = "//*[@text='OK']")
	public WebElement OK;

	@FindBy(id = "com.shaadi.android:id/tv_cash_pickup")
	public WebElement txtCashPickUp;

	@FindBy(id = "com.shaadi.android:id/card_number")
	public WebElement tvCardNumber;

	@FindBy(id = "com.shaadi.android:id/edit_text")
	public WebElement tvCardName;

	@FindBy(id = "com.shaadi.android:id/txt_cvv")
	public WebElement tvCVV;

	@FindBy(id = "com.shaadi.android:id/spnr_month")
	public WebElement SpnrMonth;

	@FindBy(id = "com.shaadi.android:id/spnr_year")
	public WebElement SpnrYear;

	@FindBy(className = "android.widget.ListView")
	public WebElement listview;

	@FindBy(className = "android.widget.TextView")
	public List<WebElement> OkCancel;

	@FindBy(id = "android:id/text1")
	public List<WebElement> viewListofAllBanks;

	@FindBy(id = "com.shaadi.android:id/btn_next_debit")
	public WebElement btnNextPaymentDebit;

	@FindBy(className = "android.widget.Image")
	public WebElement verifyWebBankImage;

	@FindBy(id = "android:id/button1")
	public WebElement btnOk;

	@FindBy(id = "com.shaadi.android:id/btn_next")
	public WebElement btnNextPayment;

	@FindBy(className = "android.widget.Image")
	public WebElement hdfcVerify;

	@FindBy(id = "com.shaadi.android:id/tv_cityerror")
	public WebElement netBankingError;

	@FindBy(id = "android:id/button2")
	public WebElement btnCancel;

	@FindBy(id = "com.shaadi.android:id/et_vpa")
	public WebElement editTextVPA;

	@FindBy(id = "com.shaadi.android:id/btn_continue")
	public WebElement btnContinueVPA;

	@FindBy(id = "com.shaadi.android:id/et_name")
	public WebElement editTextPayeeName;

	@FindBy(id = "com.shaadi.android:id/et_contact_number")
	public WebElement editTextPayeeNumber;

	@FindBy(id = "com.shaadi.android:id/btn_placeorder")
	public WebElement btnPlaceOrder;

	@FindBy(id = "com.shaadi.android:id/tv_sub_state")
	public WebElement textViewOrderPlaced;

	@FindBy(id = "com.shaadi.android:id/textinput_error")
	public List<WebElement> tvErrorPayment;

	@FindBy(id = "com.shaadi.android:id/txt_payable_amnt")
	public WebElement txtTotalPayment;

	@FindBy(id = "com.shaadi.android:id/textView__emi_info")
	public WebElement emiInfo;

	@FindBy(id = "com.shaadi.android:id/img_upi_main_arrow")
	public WebElement rlUpiVpa;

	@FindBy(id = "com.shaadi.android:id/rl_upi_intent_flow")
	public WebElement rlUpiIntent;

	@FindBy(id = "com.shaadi.android:id/rl_main")
	public List<WebElement> rlUpiIntentOption;

	@FindBy(id = "com.phonepe.app:id/et_amount")
	public WebElement txtPhonePeAmount;

	@FindBy(id = "com.phonepe.app:id/tv_transaction_details_tag_comment")
	public WebElement txtPhonePeMessage;

	@FindBy(id = "com.shaadi.android:id/tv_no_upi_apps_found")
	public WebElement txtNoUpiApp;

	@FindBy(id = "com.shaadi.android:id/tv_addresserror")
	public WebElement tvAddressError;

	@FindBy(id = "com.shaadi.android:id/et_contactnumber")
	public WebElement editContactNumberCashPayment;

	@FindBy(id = "com.shaadi.android:id/spnr_city")
	public WebElement spnrCity;

	@FindBy(id = "com.shaadi.android:id/et_address")
	public WebElement editAddressCashPayment;

	@FindBy(id = "com.shaadi.android:id/miCompose")
	public WebElement cashPickupOrderPlacedBank;

	@FindBy(id = "com.shaadi.android:id/rlMyShaadi")
	public WebElement tabShaadi;

	@FindBy(id = "com.shaadi.android:id/et_name")
	public WebElement editNameCashPayment;

	@FindBy(id = "com.shaadi.android:id/tv_netbanking")
	public WebElement tvNetBanking;

	@FindBy(id = "com.shaadi.android:id/rb_hdfc")
	public WebElement radiobuttonHDFC;

	@FindBy(id = "com.shaadi.android:id/rb_icici")
	public WebElement radiobuttonICICI;

	@FindBy(id = "com.shaadi.android:id/rb_axis")
	public WebElement radiobuttonAXIS;

	@FindBy(id = "com.shaadi.android:id/rb_sbi")
	public WebElement radiobuttonSBI;

	@FindBy(id = "com.shaadi.android:id/rb_idbi")
	public WebElement radiobuttonIDBI;

	@FindBy(id = "com.shaadi.android:id/rb_pnb")
	public WebElement radiobuttonPNB;

	@FindBy(id = "com.shaadi.android:id/spnr_banks")
	public WebElement spnrAllBanks;

	@FindBy(id = "com.shaadi.android:id/rv_address")
	public WebElement textviewShaadiCentreAddress;
}
