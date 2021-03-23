package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PP1PageObjects extends BasePageActions {

	@AndroidFindBy(id = "com.shaadi.android:id/textView_upgrade_plan_tabs")
	public List<WebElement> planTabList;

	@FindBy(id = "com.shaadi.android:id/textView_upgrade_title")
	public WebElement pp1PageTitleText;

	@FindBy(id = "com.shaadi.android:id/cb_contribute_shaadicares")
	public WebElement shaadicaresCheckBoxAndroid;

	@FindBy(id = "com.shaadi.android:id/tv_creditcard")
	public WebElement creditCardPP2Android;

	@FindBy(id = "com.shaadi.android:id/btn_continue")
	public WebElement selectShaadiContinueButton;

	@FindBy(id = "com.shaadi.android:id/tv_plan_duration")
	public List<WebElement> SelectShaadiPlanDuartion;

	@FindBy(id = "com.shaadi.android:id/tv_plan_amount")
	public List<WebElement> SelectShaadiPlanAmount;

	@FindBy(id = "com.shaadi.android:id/tv_button")
	public WebElement viewPlansButtonAndroid;

	@FindBy(id = "com.shaadi.android:id/tv_primium_benefits")
	public WebElement AllPremiumBenefitsTextAndroid;

	@FindBy(id = "com.shaadi.android:id/tv_handpicked_matches")
	public WebElement IntroductionsAndMeetingsTextAndroid;

	@FindBy(id = "com.shaadi.android:id/tv_handpicked_match")
	public WebElement HandpickedMatchesTextAndroid;

	@FindBy(id = "com.shaadi.android:id/tv_relationships_advisor")
	public WebElement RelationshipAdvisorTextAndroid;

	@FindBy(id = "com.shaadi.android:id/textView_plan_name")
	public WebElement planName;

	@FindBy(id = "com.shaadi.android:id/textView_plan_duration")
	public WebElement planDuration;

	@FindBy(id = "com.shaadi.android:id/textView_plan_price")
	public WebElement planPrice;

	@FindBy(id = "com.shaadi.android:id/textView_per_month")
	public WebElement planPerMonthPrice;

	@FindBy(id = "com.shaadi.android:id/textView_plan_tags")
	public WebElement txtPlanTag;

	@FindBy(id = "com.shaadi.android:id/textView_benefit_description")
	public List<WebElement> benefitDescription;

	@FindBy(id = "com.shaadi.android:id/btn_upgrade_continue")
	@iOSFindBy(id = "buttonContinue_1")
	public WebElement btnContinue;

	@FindBy(id = "com.shaadi.android:id/btn_proceed")
	public WebElement btn_Proceed;

	@FindBy(id = "com.shaadi.android:id/tv_profilebooster")
	public WebElement tvAddProfileBooster;

	@FindBy(id = "com.shaadi.android:id/tv_shaadicare")
	public WebElement tvContributetoShaadiCares;

	@FindBy(id = "com.shaadi.android:id/cb_add_prfl_booster")
	public WebElement cbAddPrflBooster;

	@FindBy(id = "com.shaadi.android:id/cb_contribute_shaadicares")
	public WebElement cbContributeShaadiCares;

	@FindBy(id = "com.shaadi.android:id/tv_profile_booster_amnt")
	public WebElement tvProfileBoosterAmnt;

	@FindBy(id = "com.shaadi.android:id/tv_shaadi_cares_amnt")
	public WebElement tvShaadiCaresAmnt;

	@FindBy(id = "com.shaadi.android:id/tv_ttl_amount_currency")
	public WebElement tvTotalAmountCurrency;

	@FindBy(id = "com.shaadi.android:id/tv_productname")
	public WebElement txtProductName;

	@FindBy(className = "android.widget.LinearLayout")
	public List<WebElement> orderSummary;

	@FindBy(id = "com.shaadi.android:id/tv_savings")
	public WebElement txtSaving;

	@FindBy(id = "com.shaadi.android:id/tv_saving_amnt")
	public WebElement txtSavingAmt;

	@FindBy(id = "com.shaadi.android:id/tv_profile_booster_amnt")
	public WebElement txtBoosterAmt;

	@FindBy(id = "com.shaadi.android:id/tv_shaadi_cares_amnt")
	public WebElement txtShaadiCareAmt;

	@FindBy(id = "com.shaadi.android:id/tv_price")
	public WebElement txtAmount;

	@iOSFindBy(name = "buttonGProduct")
	public WebElement btn_GProd;

	@iOSFindBy(name = "buttonG+Product")
	public WebElement btn_GPlusProd;

	@iOSFindBy(name = "buttonDProduct")
	public WebElement btn_DProd;

	@iOSFindBy(name = "buttonD+Product")
	public WebElement btn_DPlusProd;

	@iOSFindBy(name = "buttonP+Product")
	public WebElement btn_PPlusProd;

	@iOSFindBy(id = "labelProductName_0")
	public WebElement lbl_GProdName;

	@iOSFindBy(id = "labelDuration_0")
	public WebElement lbl_GProdDuration;

	@iOSFindBy(id = "buttonContinue_0")
	public WebElement btn_GContinue;

	@iOSFindBy(id = "labelDescription_0")
	public WebElement lbl_GProdDesc_0;

	@iOSFindBy(id = "labelDescription_1")
	public WebElement lbl_GProdDesc_1;

	@iOSFindBy(id = "labelProductName_1")
	public WebElement lbl_GPlusProdName;

	@iOSFindBy(id = "labelDuration_1")
	public WebElement lbl_GPlusProdDuration;

	@iOSFindBy(id = "labelDescription_10")
	public WebElement lbl_GPlusProdDesc_10;

	@iOSFindBy(id = "labelDescription_11")
	public WebElement lbl_GPlusProdDesc_11;

	@iOSFindBy(id = "labelDescription_12")
	public WebElement lbl_GPlusProdDesc_12;

	@iOSFindBy(id = "buttonContinue_1")
	public WebElement btn_GPlusContinue;

	@iOSFindBy(id = "labelProductName_2")
	public WebElement lbl_DProdName;

	@iOSFindBy(id = "labelDuration_2")
	public WebElement lbl_DProdDuration;

	@iOSFindBy(id = "labelDescription_20")
	public WebElement lbl_DProdDesc_20;

	@iOSFindBy(id = "labelDescription_21")
	public WebElement lbl_DProdDesc_21;

	@iOSFindBy(id = "buttonContinue_2")
	public WebElement btn_DContinue;

	@iOSFindBy(id = "labelProductName_3")
	public WebElement lbl_DPlusProdName;

	@iOSFindBy(id = "labelDuration_3")
	public WebElement lbl_DPlusProdDuration;

	@iOSFindBy(name = "TOP SELLER")
	public WebElement lbl_DPlus_TopSeller;

	@iOSFindBy(id = "labelDescription_30")
	public WebElement lbl_DPlusProdDesc_30;

	@iOSFindBy(id = "labelDescription_31")
	public WebElement lbl_DPlusProdDesc_31;

	@iOSFindBy(id = "labelDescription_32")
	public WebElement lbl_DPlusProdDesc_32;

	@iOSFindBy(id = "labelDescription_33")
	public WebElement lbl_DPlusProdDesc_33;

	@iOSFindBy(id = "buttonContinue_3")
	public WebElement btn_DPlusContinue;

	@iOSFindBy(id = "labelProductName_4")
	public WebElement lbl_PPlusProdName;

	@iOSFindBy(id = "labelDuration_4")
	public WebElement lbl_PPlusProdDuration;

	@iOSFindBy(id = "labelDescription_40")
	public WebElement lbl_PPlusProdDesc_40;

	@iOSFindBy(id = "labelDescription_41")
	public WebElement lbl_PPlusProdDesc_41;

	@iOSFindBy(id = "labelDescription_42")
	public WebElement lbl_PPlusProdDesc_42;

	@iOSFindBy(id = "labelDescription_43")
	public WebElement lbl_PPlusProdDesc_43;

	@iOSFindBy(id = "buttonContinue_4")
	public WebElement btn_PPlusContinue;

	@iOSFindBy(id = "buttonViewPlans")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_button")
	public WebElement btn_ViewPlansSelectShaadi;

	@iOSFindBy(id = "Choose Your Plan")
	public WebElement txt_ChoosePlanSelectShaadi;

	@iOSFindBy(id = "labelMonth_0")
	public WebElement txt_ThreeMonthsPlan;

	@iOSFindBy(id = "labelTotalAmount_0")
	public WebElement txt_Price_ThreeMonthsPlan;

	@iOSFindBy(id = "labelMonth_1")
	public WebElement txt_SixMonthsPlan;

	@iOSFindBy(id = "labelTotalAmount_1")
	public WebElement txt_Price_SixMonthsPlan;

	@iOSFindBy(id = "Frequently Asked Questions")
	public WebElement txt_FAQ;

	@iOSFindBy(name = "Upgrade to Premium")
	public WebElement txt_UpgradeToPremium;

	@iOSFindBy(id = "labelHeader")
	public WebElement txt_MatchGuarentee;

	@iOSFindBy(name = "Confirm Your In‑App Purchase")
	public WebElement txt_ConfirmPurchase;

	@iOSFindBy(id = "Cancel")
	public WebElement btn_CancelPurchase;

	@iOSFindBy(id = "Buy")
	public WebElement btn_BuyPurchase;

	@iOSFindBy(id = "OK")
	public WebElement btn_OK;

	@iOSFindBy(id = "Payment Cancelled")
	public WebElement txt_PaymentCancel;

	@iOSFindBy(id = "Cannot connect to iTunes Store")
	public WebElement txt_ItuneConnectFailed;

	@iOSFindBy(id = "Add Photos Later")
	public WebElement btn_AddPhotosLater;

	@iOSFindBy(id = "buttonNotNow")
	public WebElement btn_Photos_NotNow;

}
