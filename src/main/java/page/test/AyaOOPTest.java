package page.test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty7.util.log.Log;
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

import data.OOP_Claim_data;
import io.appium.java_client.remote.HideKeyboardStrategy;
import page.actions.AyaCareAppActions;
import page.actions.BottomMenu;
import page.objects.LoginPageObjects;

import page.objects.AyaCareAppObjects;

public class AyaOOPTest extends BasePageActions {

	AyaCareAppObjects locators ;
	LoginPageObjects loginPageObject;
	AyaCareAppActions items;
	Object[][] returnValue;
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		locators = new AyaCareAppObjects();
		items = new AyaCareAppActions();

	}
	
	
	@Test(priority = 0, description = "Send an oop claim", dataProvider = "searchData",enabled = true)
	public void out_Of_Pocket_Claim_Submission(OOP_Claim_data searchData) throws InterruptedException {

	//	for(int j=0; j<Integer.parseInt(searchData.number_of_runs.get(0).toString());j++) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(locators.plus));
		
		locators.plus.click();// Clicking on plus sign
		wait.until(ExpectedConditions.visibilityOf(locators.addoop));
		locators.addoop.click();//Choose option out of pocket
		wait.until(ExpectedConditions.visibilityOf(locators.tick1));
		locators.tick1.click();//choose first tick option
		//locators.tick2.click();//choose second tick option
		locators.cont.click();//click on continue
		
		wait.until(ExpectedConditions.visibilityOf(locators.no_receipt));
		locators.no_receipt.click();//choose option no receipt
		
		wait.until(ExpectedConditions.visibilityOf(locators.ok_button));
		locators.ok_button.click();//click ok Button
		
		
		wait.until(ExpectedConditions.visibilityOf(locators.amount_you_wish_to_claim));
		
		//String claimID=getClaimIDFromString(locators.draftClaim.getText());//Save Claim ID 
		//locators.total_amount_paid.sendKeys(searchData.total_amount_paid.get(0).toString());//enter amount paid
		locators.amount_you_wish_to_claim.sendKeys(searchData.amount_you_wish_to_claim.get(0).toString());// enter amount wished to claim
	//	locators.continue_Claim_button.click();// enter continue claim button
		locators.cont.click();// enter continue claim button
		//Claim Items Page
		
		int numberOfItems=searchData.who_was_this_item_for.size();
		int i=0;
		
		while(numberOfItems>0)
		{			
			items.enterItemDetails(locators,searchData,i);
			numberOfItems--;
			i++;
			if (numberOfItems>0) {
		click(locators.addAnotherItems, "clicking on add another item", "add oop claim");
//if(numberOfItems==1)
	scrollTillPartialVisibleText("Continue");
	Thread.sleep(3000);
			}
			else
				break;
		}
		
		scrollTillPartialVisibleText("Continue");
	try{locators.Continue_claim_form.click();}
		catch(Exception e) {System.out.println("element not found");}
	
	Thread.sleep(3000);
	scrollDownToElement(locators.continue_claim_submission);
	wait.until(ExpectedConditions.visibilityOf(locators.attest_checkbox));
//		scrollDown();
//		scrollDown();
//		scrollDown();
		locators.attest_checkbox.click();
		try{locators.continue_claim_submission.click();}//not working
		catch(Exception e) {System.out.println("not found");}
		waitForElementToBeDisplayedGeneric(locators.ayaCareClaimText, "Waiting for the pop up to appear", "OOP claim ");
		
		try {
			String s=locators.ayaCareClaimText.getText();	
			System.out.println(s);
			String claimID=AyaCareAppActions.extractClaimID(s);
			System.out.println(claimID);
			locators.pop_up_OK.click();//click on Ok pop up no exception
			}
		catch(Exception e){System.out.println("Claim ID pop not found");}
		
		
		//locators.done_Final.click();//click on done
		ClickNoException(locators.done_Final, 20, "clicking on done final", "OOP claim submission");
		
	//	}
		
	}
	
	@SuppressWarnings("deprecation")
//@Test(priority = 1, description = "Plan Detail Test",enabled = true)
	public void plan_Detail() throws InterruptedException{

		click(locators.planDetails, "Clicking on plan details", "Plan Detail Test");
		waitForElementToBeDisplayed(locators.current_Account_Balance, "waiting while loader disappears", "Plan Detail Test");
		AssertEquals(locators.current_Account_Balance, "Current Account Balance", "verify current account balance");
		AssertEquals(locators.current_Plan_Year_Begin, "Current Plan Year Begin", "verifying current plan year begin");
		AssertEquals(locators.current_Plan_Year_End, "Current Plan Year End", "Verifying current plan year End");
		AssertEquals(locators.annual_Contribution, "Annual Contribution", "Verifying annual contribution");
		AssertEquals(locators.contribution_Frequency, "Contribution Frequency", "Verifying contribution frequency");
		AssertEquals(locators.dependents, "Dependents","Verifying dependents");
		click(locators.current_Account_Balance, "Clicking on account balance", "Plan Detail test");
		String current_acount_balance=getText(locators.current_Account_Balance_amount, "Geting current account balance from element");
		String hsabalance =getText(locators.hsaCurrentBalanceAmount, "get HSA balance");
		String wsaBalance= getText(locators.wsaCurrentBalanceAmount, "Get WSA balance");
		
		
		
		assertTrue(isElementDisplayed(locators.hsaCurrentBalance), "Verify if hsa balance is displayed");
		assertTrue(isElementDisplayed(locators.wsaCurrentBalance), "Verify if wsa balance is displayed" );
		
		System.out.println("Current account balance is  "+current_acount_balance);
		System.out.println("HSA balance is "+hsabalance);
		System.out.println("WSA Balance is "+ wsaBalance);
//		System.out.println(locators.hsaCurrentBalanceAmount.getText());
//		System.out.println(locators.wsaCurrentBalanceAmount.getText());
	}
	
	
	//@Test(priority = 2, description = "Forgot password Test",enabled=true)
	public void forgot_password() throws InterruptedException {
		
		click(locators.menu, "Click on menu", "Forgot password Test");
		click(locators.signOut, "Click on sign out", "Forgot password Test");
		click(locators.pop_up_OK, "Click on ok", "Forgot password Test");
		
		click(items.btnNavigateSignIn, "Click on SignIn Button to Navigate Login Page", "Login-01");
		click(items.forgotPasswordLink, "Clicking on forgot password link", "Forgot password Test");
	InputValue(items.enterYourEmail, "qc+prehsa01142021@ayapayments.com", "", "");
		click(items.continuebutton, "", "");
		click(items.sendCodeButton, "", "");
	waitForElementToBeDisplayedGeneric(items.didntemail, "", "");
		
		
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