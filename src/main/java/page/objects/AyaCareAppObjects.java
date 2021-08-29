package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AyaCareAppObjects extends BasePageActions {
	
	

	@AndroidFindBy(id = "com.shaadi.android:id/layoutItsAMatch_btnDismiss")
	@iOSFindBy(id = "Skip")
	public WebElement AcceptBannerdissmiss;

	@AndroidFindBy(id = "com.shaadi.android:id/tvMatches")
	@iOSFindBy(id="Matches")
	public WebElement MatchesTab;
	
	    @AndroidFindBy(xpath  = "//android.view.ViewGroup[@content-desc=\"middleAddIconUnique\"]/android.widget.ImageView")
	    public  MobileElement plus;
	    
	    @AndroidFindBy(xpath="//*[contains(@text,'Add Out Of')]")
	    public MobileElement addoop;
	    
	    @AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	    public MobileElement tick1;
	    
//	    @AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
//	    public MobileElement tick2;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Continue →']")
	    public MobileElement cont;
	    
	    @AndroidFindBy(xpath="//*[contains(@text,'have a receipt')]")
	    public MobileElement no_receipt;
	    
	    @AndroidFindBy(xpath="//*[@text='Ok']")
	    public MobileElement ok_button;
	    
	    @AndroidFindBy(xpath="(//android.widget.TextView)[0]")
	    public MobileElement draftClaim;
	    
	    @AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	    public MobileElement total_amount_paid;
	    
	    @AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	    public MobileElement amount_you_wish_to_claim;
	    
	    @AndroidFindBy(xpath="(//android.view.ViewGroup)[4]")
	    public MobileElement 	continue_Claim_button;
	    
	    
	    //Claim Items Objects
	    
	    @AndroidFindBy(xpath="//*[@text='Who was this item for?']")
	    public MobileElement who_was_this_item_for;
	    
	    @AndroidFindBy(xpath="//*[@text='What was this item for?']")
	    public MobileElement what_was_this_item_for;
//	    
//	    @AndroidFindBy(xpath="//android.widget.EditText[@text='$0.00']")
//	    public MobileElement 	amount_paid_for_item;
	    
	    @AndroidFindBy(xpath="(//android.widget.EditText)[1]")
	    public MobileElement 	amount_paid_for_item;
	    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Employee')]")
	    public MobileElement employee;
	    
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	    public MobileElement continue_employee;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Prescription Drugs  ']")
	    public MobileElement prescription_Drugs;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
	    public MobileElement prescription_Drugs_continue;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Cancer Treatment  ']")
	    public MobileElement cancer_treatment;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='The information above is correct.']")
	   public MobileElement attest_checkbox;
	    
	    
	    @AndroidFindBy(id="android:id/message")
	    public MobileElement ayaCareClaimText;
	    
	    @AndroidFindBy(id="android:id/button1")
	    public MobileElement pop_up_OK;
	    
	    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Done')]")
	    public MobileElement done_Final;
	    
	    //add receipt
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Add receipt']")
	    public MobileElement Addreceiptbtn;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Choose Existing']")
	    public MobileElement ChooseExisting;
	    
	    @AndroidFindBy(xpath="//android.widget.Button[@text='Allow']")
	    public MobileElement Allowclick;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Photos')]")
	    public MobileElement photo1;
	    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Pictures')]")
	    public MobileElement Pictures;
	    @AndroidFindBy(xpath="(//android.view.ViewGroup)[5]")
	    public MobileElement pic1;
	    
	    
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='+ Attach another PDF']")
	    public MobileElement Attachpdf;
	    
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='c4611_sample_explain.pdf']")
	    public MobileElement pdf1;
	    
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
	    public MobileElement Continue_button;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, ' + Add another item ')]")
	    public MobileElement addAnotherItems;
	    
	    @AndroidFindBy(xpath="//android.widget.TextView[@text=' Continue →']")
	    public MobileElement Continue_claim_form;
	    
	
@AndroidFindBy(xpath="//android.widget.TextView[@text=' Continue →']")
public MobileElement continue_claim_submission;

@AndroidFindBy(xpath="//android.widget.TextView[@text='PLAN DETAILS']")
public MobileElement planDetails;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Current Account Balance']")
public MobileElement current_Account_Balance;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Current Account Balance']/following-sibling::android.widget.TextView")
public MobileElement current_Account_Balance_amount;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Current Plan Year Begin']")
public MobileElement current_Plan_Year_Begin;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Current Plan Year End']")
public MobileElement current_Plan_Year_End;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Annual Contribution']")
public MobileElement annual_Contribution;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Contribution Frequency']")
public MobileElement contribution_Frequency;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Dependents']")
public MobileElement dependents;

@AndroidFindBy(xpath="//android.widget.TextView[@text='HSA Current Balance']")
public MobileElement hsaCurrentBalance;

@AndroidFindBy(xpath="//android.widget.TextView[@text='HSA Current Balance']/following-sibling::android.widget.TextView")
public MobileElement hsaCurrentBalanceAmount;

@AndroidFindBy(xpath="//android.widget.TextView[@text='WSA Opening Balance']")
public MobileElement wsaCurrentBalance;

@AndroidFindBy(xpath="//android.widget.TextView[@text='WSA Opening Balance']/following-sibling::android.widget.TextView")
public MobileElement wsaCurrentBalanceAmount;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Menu']")
public MobileElement menu;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Signout']")
public MobileElement signOut;


}
