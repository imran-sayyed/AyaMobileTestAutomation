package page.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.OOP_Claim_data;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import page.objects.AyaCareAppObjects;
import page.objects.BottomMenuPageObjects;

public class AyaCareAppActions extends AyaCareAppObjects {
	
	
	
	public static String extractClaimID(String s) {
		
		
String claimID="";
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(s);

		while(m.find()) {
		    claimID=m.group(1);
		}
		return claimID;
	}

public static  String getClaimIDFromString(String s) {
		
		
		String[] claim_split=s.split("#");
		String claimID=claim_split[1].trim();
		
		return claimID;
		
		
		
	}

public  void enterItemDetails (AyaCareAppObjects locators, OOP_Claim_data searchData,int i) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,15);
	
	wait.until(ExpectedConditions.visibilityOf(locators.who_was_this_item_for));
	locators.who_was_this_item_for.click();
	scrollAndClickPartialVisibleText(searchData.who_was_this_item_for.get(i).toString());
	//locators.employee.click();
	//scrollTillPartialVisibleText("Continue");
	wait.until(ExpectedConditions.visibilityOf(locators.continue_employee));
	locators.continue_employee.click();
	
	wait.until(ExpectedConditions.visibilityOf(locators.what_was_this_item_for));
	locators.what_was_this_item_for.click();
	scrollAndClickPartialVisibleText(searchData.what_was_this_item_for.get(i).toString());
	//locators.prescription_Drugs.click();
	//scrollTillPartialVisibleText("Continue");
	wait.until(ExpectedConditions.visibilityOf(locators.prescription_Drugs_continue));
	locators.prescription_Drugs_continue.click();
	//locators.cancer_treatment.click();
	scrollAndClickPartialVisibleText(searchData.subcategory.get(i).toString());
	//scrollAndClickPartialVisibleText("Continue");
	scrollDown();//scroll till continue
	wait.until(ExpectedConditions.visibilityOf(locators.Continue_button));
	locators.Continue_button.click();
	Thread.sleep(3000);
try {locators.amount_paid_for_item.sendKeys(searchData.amount_paid_for_the_item.get(i).toString());}//amount paid for item}	
catch(Exception e) {}
	
driver.hideKeyboard();
	
}

@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Login\"])[2]")
@AndroidFindBy(xpath="//android.widget.TextView[@text='Login']")
public WebElement btnNavigateSignIn;
	
@AndroidFindBy(xpath="//android.widget.TextView[@text='Forgot Password']")
public MobileElement forgotPasswordLink;	


@iOSFindBy(accessibility = "loginEmailInput")
@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter your email']")
public WebElement enterYourEmail;

@iOSFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Continue\"])[2]")
@AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
public WebElement continuebutton;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Send Code']")
public WebElement sendCodeButton;

@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'get the email')]")
public WebElement didntemail;

}
