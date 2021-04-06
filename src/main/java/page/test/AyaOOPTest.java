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
import android.shaadi.BaseTest;
import data.AdvanceSearchData;
import data.OOP_Claim_data;
import io.appium.java_client.remote.HideKeyboardStrategy;
import page.actions.BottomMenu;
import page.actions.MatchesPage;
import page.objects.AyaCareAppObjects;

public class AyaOOPTest extends BasePageActions {

	AyaCareAppObjects locators ;
	Object[][] returnValue;
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		locators = new AyaCareAppObjects();
		

	}
	
	@Test(priority = 0, description = "Send an oop claim", dataProvider = "searchData")
	public void out_Of_Pocket_Claim_Submission(OOP_Claim_data searchData) throws InterruptedException {

		locators.plus.click();// Clicking on plus sign
		locators.addoop.click();//Choose option out of pocket
		locators.tick1.click();//choose first tick option
		locators.tick2.click();//choose second tick option
		locators.cont.click();//click on continue
		locators.no_receipt.click();//choose option no receipt
		locators.ok_button.click();//click ok Button
		
		
		Thread.sleep(3000);
		
		//String claimID=getClaimIDFromString(locators.draftClaim.getText());//Save Claim ID 
		locators.total_amount_paid.sendKeys(searchData.total_amount_paid.get(0).toString());//enter amount paid
		locators.amount_you_wish_to_claim.sendKeys(searchData.amount_you_wish_to_claim.get(0).toString());// enter amount wished to claim
		locators.continue_Claim_button.click();// enter continue claim button
		locators.who_was_this_item_for.click();
		scrollAndClickPartialVisibleText(searchData.who_was_this_item_for.get(0).toString());
		//locators.employee.click();
		//scrollTillPartialVisibleText("Continue");
		locators.continue_employee.click();
		locators.what_was_this_item_for.click();
		scrollAndClickPartialVisibleText(searchData.what_was_this_item_for.get(0).toString());
		//locators.prescription_Drugs.click();
		//scrollTillPartialVisibleText("Continue");
		locators.prescription_Drugs_continue.click();
		//locators.cancer_treatment.click();
		scrollAndClickPartialVisibleText(searchData.subcategory.get(0).toString());
		//scrollAndClickPartialVisibleText("Continue");
		scrollDown();//scroll till continue
		locators.Continue_button.click();
		Thread.sleep(3000);
	try {locators.amount_paid_for_item.sendKeys(searchData.amount_paid_for_the_item.get(0).toString());}//amount paid for item}	
	catch(Exception e) {}
		
	driver.hideKeyboard();
	
	try{locators.Continue_claim_form.click();}//continue not working
		catch(Exception e) {System.out.println("element not found");}
	
		scrollDown();
		scrollDown();
		scrollDown();
		locators.attest_checkbox.click();
		try{locators.continue_claim_submission.click();}//not working
		catch(Exception e) {System.out.println("not found");}
		waitForElementToBeDisplayed(locators.ayaCareClaimText, "Waiting for the pop up to appear", "OOP claim ");
		
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
	@DataProvider
	public Object[][] searchData() throws FileNotFoundException {

		try {
			File search_json = new File("src/main/java/data/OOP_claim.json");
			JsonElement jsonData = new JsonParser().parse(new FileReader(search_json.getAbsolutePath()));
			JsonElement searchDataSet = jsonData.getAsJsonObject().get("searchSet");
			List<OOP_Claim_data> searchData = new Gson().fromJson(searchDataSet,
					new TypeToken<List<OOP_Claim_data>>() {
					}.getType());
			returnValue = new Object[searchData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = searchData.get(index++);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return returnValue;
	}
	
}