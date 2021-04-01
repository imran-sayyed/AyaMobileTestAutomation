package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import io.appium.java_client.remote.HideKeyboardStrategy;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.objects.AyaCareAppObjects;

public class AyaOOPTest extends BasePageActions {

	AyaCareAppObjects locators ;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		locators = new AyaCareAppObjects();

	}
	
	@Test(priority = 0, description = "Send an oop claim")
	public void out_Of_Pocket_Claim_Submission() throws InterruptedException {

		//locators.plus.click();// Clicking on plus sign
		locators.addoop.click();//Choose option out of pocket
		locators.tick1.click();//choose first tick option
		locators.tick2.click();//choose second tick option
		locators.cont.click();//click on continue
		locators.no_receipt.click();//choose option no receipt
		locators.ok_button.click();//click ok Button
		
		
		Thread.sleep(3000);
		
		//String claimID=getClaimIDFromString(locators.draftClaim.getText());//Save Claim ID 
		locators.total_amount_paid.sendKeys("1");//enter amount paid
		locators.amount_you_wish_to_claim.sendKeys("1");// enter amount wished to claim
		locators.continue_Claim_button.click();// enter continue claim button
		locators.who_was_this_item_for.click();
		locators.employee.click();
		locators.continue_employee.click();
		locators.what_was_this_item_for.click();
		locators.prescription_Drugs.click();
		locators.prescription_Drugs_continue.click();
		locators.cancer_treatment.click();
		scrollDown();//scroll till continue
		locators.Continue_button.click();
		Thread.sleep(3000);
	try {
		locators.amount_paid_for_item.sendKeys("1");//amount paid for item
	}	
	catch(Exception e) {
		
		}
		
	driver.hideKeyboard();
	
	try{locators.cont.click();}//continue not working
		catch(Exception e) {
			
			System.out.println("element not found");
		}
		scrollDown();
		scrollDown();
		locators.attest_checkbox.click();
		try{locators.cont.click();}//not working
		catch(Exception e) {System.out.println("not found");}
		Thread.sleep(10000);//continue and wait
		try {
		String s=locators.ayaCareClaimText.getText();	
			System.out.println(s);
		}
		catch(Exception e){
			System.out.println("Not found");
			
		}
		locators.pop_up_OK.click();//click on Ok pop up no exception
		
		locators.done_Final.click();//click on done
		
		
		
		
	}
	
	public static  String getClaimIDFromString(String s) {
		
		
		String[] claim_split=s.split("#");
		String claimID=claim_split[1].trim();
		
		return claimID;
		
		
		
	}
}