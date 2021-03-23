package page.actions;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import android.shaadi.BaseTest;
import data.ReactRegData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.RegistrationPageObjects;
import shaadi.utils.AppStringConstants;

public class RegistrationPage extends RegistrationPageObjects {

	public String username;
	public static boolean setOtherCountryFlag = false;

	public void SwitchtoWebView() throws InterruptedException {
		changeDriverContextToWeb(driver);
	}

	public void SwitchtoNativeView() {
		changeDriverContextToNative(driver);
	}

	public void InputUseNamePassword(String UserName, String Password) {
		if (RunEnvironment.equals("iOSLocal")) {// create instance of Random class

			// Generate random integers in range 0 to 999
			Random rand = new Random();
			int rand_int1 = rand.nextInt(10000);

			username = rand_int1 + UserName;
			
			System.out.println(username + "  This is the user Being Registered");

			// Added the type field which need to be searched
			webEmail.sendKeys(username);

			wheelDoneButton.click();
			webPassword.sendKeys(Password);

			wheelDoneButton.click();

		}

		else {
			// create instance of Random class
			Random rand = new Random();

			// Generate random integers in range 0 to 999
			int rand_int1 = rand.nextInt(10000);

			username = rand_int1 + UserName;
			
			System.out.println("Email id created -- " + username);

			InputValue(webEmail, username, "EmailId text", "Reg-02");
			if (BaseTest.AutomationRunName.equals("Appium"))
				driver.hideKeyboard();
			InputValue(webPassword, Password, "Enter Password", "Reg-03");
			if (BaseTest.AutomationRunName.equals("Appium"))
				driver.hideKeyboard();
		}
	}
	
	
	public void InputPassword(String Password) {
		if (RunEnvironment.equals("iOSLocal")) {// create instance of Random class

			// Generate random integers in range 0 to 999

			webPassword.sendKeys(Password);

			wheelDoneButton.click();

		}

		else {
			// create instance of Random class

			InputValue(webPassword, Password, "Enter Password", "Reg-03");
			if (BaseTest.AutomationRunName.equals("Appium"))
				driver.hideKeyboard();
		}
	}

	public void Posted() {
		if (RunEnvironment.equals("iOSLocal")) {

			webPostedBy.click();

		}

		else {
			if (isDisplayed(webPostedBy)) {
				click(webPostedBy, "Click on Posted By Dropdown", "Reg-04");

			}
		}
	}

	public void PostedByOptions(String postedBy) {
		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(postedBy, false);
			wheelDoneButton.click();
		} else {

			if (isDisplayed(webPostedBy)) {
				Select s = new Select(webPostedBy);
				s.selectByValue(postedBy);
			}
		}
	}

	public void insertIosDetails(int indexValue, String dataSet, String classNameType) {

		@SuppressWarnings("unchecked")

		List<WebElement> textFields = driver.findElements(By.className(classNameType));
		textFields.get(indexValue).sendKeys(dataSet);
	}

	public void selectDropDown(int indexValue, String className) {

	}

	public void InputFirstNameLastName(String FirstName, String LastName) {

		if (RunEnvironment.equals("iOSLocal")) {// create instance of Random class

			// Generate random integers in range 0 to 999
			// Added the type field which need to be searched
	
			webFirstName.sendKeys(FirstName);
			wheelDoneButton.click();
			webLastName.sendKeys(LastName);

			wheelDoneButton.click();
		} else {
			if (isDisplayed(webFirstName)) {
				InputValue(webFirstName, FirstName, "Enter First Name", "Reg-06");
				InputValue(webLastName, LastName, "Enter Last Name", "Reg-07");
				if (BaseTest.AutomationRunName.equals("Appium"))
					driver.hideKeyboard();
			}
		}

	}

	public void Gender(String gender) {

		if (RunEnvironment.equalsIgnoreCase("iOSLocal")) {
			webGender.click();
			selectValueFromPickerWheel(gender, false);
			wheelDoneButton.click();

		} else {
			if (isDisplayed(webGender)) {
				click(webGender, "Click on Gender dropdown", "Reg-08");
				selectDropDownValue(webGender, gender);
			}
		}

	}


	public void Day() {
		if (isDisplayed(webDay))
			click(webDay, "Click on Day Dropdown", "Reg-10");
	}


	public void SelectDay(String day) {

		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(day, false);
			wheelDoneButton.click();
		} else {
			if (isDisplayed(webDay))
				selectDropDownValue(webDay, day);

		}

	}

	public void Month() {

		if (isDisplayed(webMonth))
			click(webMonth, "Click on Month Dropdown", "Reg-12");
	}

	public void SelectMonth(String month) {

		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(month, false);
			wheelDoneButton.click();
		} else {
			if (isDisplayed(webMonth))
				selectDropDownValue(webMonth, month);
		}
	}



	public void Year() {

		if (isDisplayed(webYear))
			click(webYear, "Click on Year Dropdown", "Reg-14");
	}

	public void SelectYear(String year) {

		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(year, false);
			wheelDoneButton.click();
		}

		else {
			if (isDisplayed(webYear))
				selectDropDownValue(webYear, year);
		}

	}



	public void Religion() {

		if (RunEnvironment.equals("iOSLocal")) {
			webReligion.click();
		} else {
			if (isDisplayed(webReligion)) {
				click(webReligion, "Clik on Religion dropdown", "Reg-14");
			}
		}

	}

	public void SelectReligion(String Religion) {

		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(Religion, false);
			wheelDoneButton.click();
		} else {
			// ScrollToText(webSelectYear, Religion, "Select Year", "Reg-15");
			if (isDisplayed(webReligion)) {

				selectDropDownValue(webReligion, Religion);
			}

		}
	}


	public void Community() throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {
			webMotherTongue.click();
			Thread.sleep(2000);

		} else {
			if (isDisplayed(webMotherTongue)) {
				click(webMotherTongue, "clikc on Mother Tongue dropdown", "Reg-16");
			}
		}

	}

	public void SelectCommunity(String MotherTongue) throws InterruptedException {

		if (RunEnvironment.equals("iOSLocal")) {
			Thread.sleep(2000);
			selectValueFromPickerWheel(MotherTongue, true);
			Thread.sleep(2000);
			wheelDoneButton.click();
		}

		else {
			if (isDisplayed(webMotherTongue)) {
				selectDropDownValue(webMotherTongue, MotherTongue);
			}

		}
	}


	public void LivingIn() {
		if (isDisplayed(webLivinIn))
			webLivinIn.click();
	}

	public void SelectLivingIn(String LivingIn) {
		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(LivingIn, true);
			wheelDoneButton.click();
		}

		else {
			if (isDisplayed(webLivinIn))
				selectDropDownValue(webLivinIn, LivingIn);
		}

	}

	public void Submit() {

		btnSubmitReg1.click();
	}

	public void State() {
		if (isDisplayed(stateOfResidence))
			stateOfResidence.click();
	}

	public void SelectStateLivingIn(String LivingSince) {

		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(LivingSince, true);
			wheelDoneButton.click();
		}

		else {
			if (isDisplayed(stateOfResidence))
				selectDropDownValue(stateOfResidence, LivingSince);
		}

	}

	public void SelectLivingSince(String LivingSince, String countryLivingIn) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webLivingSince) && !countryLivingIn.equalsIgnoreCase("India")) {
				webLivingSince.click();
				selectValueFromPickerWheel(LivingSince, true);
				wheelDoneButton.click();
				setOtherCountryFlag = true;
			}

		}

		else {
			if (isDisplayed(webLivingSince)) {
				click(webLivingSince, "click living since", "Reg-21");
				selectDropDownValue(webLivingSince, LivingSince);
			}
		}

	}

	public void SelectGrewUpIn(String grewupin) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webGrewUpIn) && setOtherCountryFlag) {
				webGrewUpIn.click();
				selectValueFromPickerWheel(grewupin, true);
				wheelDoneButton.click();
			}
		} else {
			if (isDisplayed(webGrewUpIn)) {
				click(webGrewUpIn, "click living since", "Reg-21");
				selectDropDownValue(webGrewUpIn, grewupin);
			}
		}

	}

	public void SelectResidencyStatus(String residencyStatus) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webResidencyStatus) && setOtherCountryFlag) {
				webResidencyStatus.click();
				selectValueFromPickerWheel(residencyStatus, false);
				wheelDoneButton.click();
			}
		} else {
			if (isDisplayed(webResidencyStatus)) {
				click(webResidencyStatus, "click living since", "Reg-21");
				selectDropDownValue(webResidencyStatus, residencyStatus);
			}
		}

	}

	public void city() {
		if (isDisplayed(city))
			click(city, "Click on City dropdown", "Reg22");
	}

	public void SelectCity(String city1) {
		if (RunEnvironment.equals("iOSLocal")) {
			selectValueFromPickerWheel(city1, true);
			wheelDoneButton.click();
		} else {
			if (isDisplayed(city))
				selectDropDownValue(city, city1);
		}

	}


	public void LivesWithFamily()

	{
		driver.findElementById("livesWithFamilyOption").findElements(By.className("android.widget.Button")).get(0)
				.click();
	}

	public void MaritalStatus(String status) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webMaritialStatus)) {
				webMaritialStatus.click();
				selectValueFromPickerWheel(status, false);
				wheelDoneButton.click();
			}
		} else {
			if (isDisplayed(webMaritialStatus)) {
				click(webMaritialStatus, "Click on the marital status dropdown", "Reg-23");
				selectDropDownValue(webMaritialStatus, status);
			}
		}

	}

	public void caste() {
		click(webCommunity, "Click on Caste dropdown", "Reg-24");
	}

	public void Continue() {
		click(continue_button_2_1, "Click on Continue button", "Reg-25");
	}

	public void Education(String education) {

		if (RunEnvironment.equals("iOSLocal")) {
			webEducationLevel.click();
			selectValueFromPickerWheel(education, true);
			wheelDoneButton.click();
		}

		else {
			if (isDisplayed(webEducationLevel)) {
				click(webEducationLevel, "Clikc on Education level dropdown", "Reg-26");
				selectDropDownValue(webEducationLevel, education);
			}
		}

	}

	public void EducationField(String field) {
		if (isDisplayed(webEducationField)) {
			click(webEducationField, "Click on Education field dropdown", "Reg-27");
			selectDropDownValue(webEducationField, field);
		}
	}

	public void Income(String income) {

		if (RunEnvironment.equals("iOSLocal")) {
			webIncome.click();
			selectValueFromPickerWheel(income, false);
			wheelDoneButton.click();
		}

		else {
			if (isDisplayed(webIncome)) {
				click(webIncome, "click on income dropdown", "Reg_28");
				selectDropDownValue(webIncome, income);
			}
		}

	}

	public void Submit_biodata() {
		click(btnSubmitRegBiodata, "click on continue button", "Reg-29");
	}

	public void Height(String height) {
		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webHeight)) {
				webHeight.click();
				selectValueFromPickerWheel(height, false);
				wheelDoneButton.click();
			}
		} else {
			if (isDisplayed(webHeight)) {
				click(webHeight, "click on Height dropdown", "Reg-30");
				selectDropDownValue(webHeight, height);
			}
		}

	}

	public void Smoke() {
		driver.findElementById("smokeHabbit").findElements(By.className("android.widget.Button")).get(0).click();
		// webSmokingHabbit.findElements(By.className("android.widget.Button")).get(0).click();
		// click(webSmokingHabbit,"click on smoke habbits", "Reg-31");
	}

	public void Drink() {
		webDrinkHabbit.findElements(By.className("android.widget.Button")).get(0).click();
	}

	public void Submit_lifestyle() {
		click(btnSubmitRegLifeStyle, "click on smoke habbits", "Reg-33");
	}

	public void HelpMe() {
		click(webHelpMe, "click on smoke habbits", "Reg-34");
	}

	public void CopyThis() {
		click(webCopyThis, "click on smoke habbits", "Reg-35");
	}

	public void MobileNumber(String contactNumber) {
		if (isDisplayed(webContactNumber)) {
			InputValue(webContactNumber, contactNumber, "Mobile text", "Reg-37");
			if (BaseTest.AutomationRunName.equals("Appium"))
				driver.hideKeyboard();
		}
	}

	public void CreateProfile() {
		AssertEquals(btnSubmitCreateProfile, "Create Profile", "Verify the text Create Profile");
		click(btnSubmitCreateProfile, "click Create Profile", "Reg-36");

	}

	// WhatsApp_Optin

	public void SkipNativePages() throws InterruptedException {

		AssertEquals(UploaPhotoText, "Upload Photo and get 12 times more response",
				"Verify the text for Upload Photo and get 12 times more response");
		AssertEquals(PhotoPrivacytxt, "100% Privacy Options Available", "Verify the text for 0 invitations");
		AssertEquals(skipPhotoUpload, "I'll do this later", "Verify the text for I'll do this later");
		click(skipPhotoUpload, "Click on skip Photo Upload", "Test-01");
		click(AllowPermission, "Click on Allow Permission", "Test-01");
		Thread.sleep(20000);
		AssertEquals(SkipFamilyDetails, "Skip", "Verify the text for Skip");
		click(SkipFamilyDetails, "Click on skip Photo Upload", "Test-01");


		AssertEquals(NumVerifiedTxt, "Your number has been successfully verified.", "Verify the text ");
		AssertEquals(WhatsappText, "Get your Shaadi recommendations on WhatsApp", "Verify the text");

		AssertEquals(OkSureBtn, "Ok, sure", "Verify the text");
		click(OkSureBtn, "Click on Ok Sure Btn", "Test-01");

		Thread.sleep(5000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);

		click(MyShadiTab, "Click on My Shaadi Tab", "Test-01"); // myshaaditab should come from that page
		Thread.sleep(3000);

	}

	public void selectDropDownValue(WebElement element, String option) {

		Select s = new Select(element);
		s.selectByVisibleText(option);
	}

	public void selectDiet(String diet) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webDiet1)) {
				webDiet1.click();
				selectValueFromPickerWheel(diet, false);
				wheelDoneButton.click();
			}
		} else {
			if (isDisplayed(webDiet1)) {
				click(webDiet1, "", "");
				selectDropDownValue(webDiet1, diet);
			}
		}

	}

	public void selectCommunity(String community) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webCommunity)) {
				webCommunity.click();
				selectValueFromPickerWheel(community, true);
				wheelDoneButton.click();
			}
		}

		else {
			if (isDisplayed(webCommunity)) {
				click(webCommunity, "", "");
				selectDropDownValue(webCommunity, community);
			}
		}

	}

	public void selectAnyChildren(String data, String maritialStatus) {

		if (RunEnvironment.equals("iOSLocal")) {
			// adding check to see if the field is displayed when user selects never married
			if (isDisplayed(webChildren) && !maritialStatus.equalsIgnoreCase("Never Married")) {
				webChildren.click();
				selectValueFromPickerWheel(data, false);
				wheelDoneButton.click();

			}
		} else {
			if (isDisplayed(webChildren)) {
				click(webChildren, "", "");
				selectDropDownValue(webChildren, data);
			}
		}

	}

	public void selectNoOfChildren(String data) {

		if (RunEnvironment.equals("iOSLocal")) {
			if (isDisplayed(webNoOfChildren)) {
				webNoOfChildren.click();
				selectValueFromPickerWheel(data, false);
				wheelDoneButton.click();
			}
		} else {

			if (isDisplayed(webNoOfChildren)) {
				click(webNoOfChildren, "", "");
				selectDropDownValue(webNoOfChildren, data);
			}
		}

	}

	public void regpage1(ReactRegData reg1Data) throws InterruptedException {

		InputUseNamePassword(reg1Data.userName, reg1Data.password);

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDown();
			MobileNumber(reg1Data.contactNumber);
		}

		Posted();
		PostedByOptions("Self");
		InputFirstNameLastName(reg1Data.firstName, reg1Data.lastName);
		Gender(reg1Data.gender);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDown();
		}

		selectDOB(reg1Data.day, reg1Data.month, reg1Data.year);

		Religion();
		SelectReligion(reg1Data.religion);
		Community();
		SelectCommunity(reg1Data.motherTongue);
		LivingIn();
		SelectLivingIn(reg1Data.livingIn);
		Submit();
		waitForElementToBeDisplayed(stateOfResidence, "wait for next page to load", "");

	}
	
	
	
	public void regpage1_GoogleSinup(ReactRegData reg1Data) throws InterruptedException {

		waitForElementToBeDisplayed(webEmail, "", "");
		InputPassword(reg1Data.password);
		
		Assert.assertEquals(webEmail.getAttribute("value"), AppStringConstants.googleSignInEmail);

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDown();
			MobileNumber(reg1Data.contactNumber);
		}

		Posted();
		PostedByOptions("Self");
		InputFirstNameLastName(reg1Data.firstName, reg1Data.lastName);
		Gender(reg1Data.gender);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDown();
		}

		selectDOB(reg1Data.day, reg1Data.month, reg1Data.year);

		Religion();
		SelectReligion(reg1Data.religion);
		Community();
		SelectCommunity(reg1Data.motherTongue);
		LivingIn();
		SelectLivingIn(reg1Data.livingIn);
		Submit();
		waitForElementToBeDisplayed(stateOfResidence, "wait for next page to load", "");

	}

	public void regpage2(ReactRegData reg1Data) throws InterruptedException {
		// added to store the value in global variable for further action

		Thread.sleep(3000);
		Continue();
		AssertEquals(stateErrorMessage, "Please enter the state living in", "");
		AssertEquals(cityErrorMessage, "Please enter the city living in", "");
		AssertEquals(maritalStatusErrorMessage, "Please specify Marital Status", "");
		if (isDisplayed(heightErrorMessage)) {
			AssertEquals(heightErrorMessage, "Please specify Height", "");
		}

		State();
		SelectStateLivingIn(reg1Data.stateLivingIn);
		city();
		SelectCity(reg1Data.cityLivingIn);

		SelectLivingSince(reg1Data.livingSince, reg1Data.livingIn);
		SelectGrewUpIn(reg1Data.grewUpIn);
		SelectResidencyStatus(reg1Data.residencyStatus);

		MaritalStatus(reg1Data.maritialStatus);
		selectAnyChildren(reg1Data.children, reg1Data.maritialStatus);
		selectNoOfChildren(reg1Data.noOfChildren);

		selectDiet(reg1Data.diet);
		Height(reg1Data.height);

		selectCommunity(reg1Data.subcommunity);
		Continue();
		waitForElementToBeDisplayed(webEducationLevel, "", "");

	}

	public void regpage3(ReactRegData reg1Data) throws InterruptedException {
		Continue();
		AssertEquals(educationLevelErrorMessage, "Please specify education level", "");

		AssertEquals(annualIncomeErrorMessage, "Please specify Annual Income", "");

		Education(reg1Data.eductionLevel);
		// EducationField(reg1Data.educationField);
		Income(reg1Data.annualIncome);
		Continue();
		Thread.sleep(2000);

	}

	public void regpage4(ReactRegData reg1Data) throws InterruptedException {

		if (isDisplayed(createProfileButton)) {
			if (isDisplayed(webContactNumber)) {
				createProfileButton.click();
				AssertEquals(mobileNoErrorMessage, "Please specify Mobile Number", "");

				MobileNumber(reg1Data.contactNumber);
			}

			createProfileButton.click();

		} else {
			Continue();
			AssertEquals(heightErrorMessage, "Please specify Height", "Please specify Height");
			selectDiet(reg1Data.diet);
			Height(reg1Data.height);
			Thread.sleep(3000);
			// mobile number check needed for ios regflow
			if (isDisplayed(webContactNumber)) {
				AssertEquals(mobileNoErrorMessage, "Please specify Mobile Number", "");
				MobileNumber(reg1Data.contactNumber);
			}
			Continue();
			Thread.sleep(3000);

			createProfileButton.click();
			Thread.sleep(5000);
		}
		

	}

	public void ios_DD(int index) {

		@SuppressWarnings("unchecked")
		List<WebElement> selectList = driver.findElements(By.xpath("//XCUIElementTypeOther[@value='Select']"));
		selectList.get(index).click();

	}

	public void completeRegFlow() throws InterruptedException {

		if (isDisplayedAfterWait(btnAddPhotosLater, 5)) {
			btnAddPhotosLater.click();
			waitForElementToBeDisplayed(btnNotNow_photo, "wait for Not Now button to be visible", "");
			btnNotNow_photo.click();

		}

		if (isDisplayedAfterWait(btn_skipFamily, 10)) {
			btn_skipFamily.click();
		}

		if (isDisplayed(btn_verifyNumberLater)) {
			btn_verifyNumberLater.click();
		}

		if (isDisplayed(btn_savePP)) {
			btn_savePP.click();
		}

		if (isDisplayed(btn_SkipConnect)) {
			btn_SkipConnect.click();
		}

		if (isDisplayed(btn_SplitPage)) {
			btn_SplitPage.click();
		}

		if (isDisplayed(upgradePageSkip)) {
			upgradePageSkip.click();
		}

		Thread.sleep(5000);

		if (isDisplayed(btn_OnBoarding)) {
			Thread.sleep(2000);

			btn_OnBoarding.click();

			Thread.sleep(2000);

			if (isDisplayed(btn_OK)) {
				btn_OK.click();
			}

			Thread.sleep(3000);

			if (isDisplayed(btn_OK)) {
				btn_OK.click();
			}

		}

		if (isDisplayed(imgVIPShaadiCancel)) {
			imgVIPShaadiCancel.click();
		}

	}

	public void fieldValidation_RP1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("performing scroll down");
		scrollDownToElement(btnSubmitReg1);
		Submit();
		scrollUp();
		System.out.println("performing scroll up");
		AssertEquals(emailErrorMessage, "Your email address is mandatory.", "");
		AssertEquals(passwordErrorMessage, "Password is mandatory.", "");
		if (isDisplayed(mobileNoErrorMessage)) {
			AssertEquals(mobileNoErrorMessage, "Mobile number is mandatory.", "");
		}
		AssertEquals(postedByErrorMessage, "Relevant relationship information is mandatory.", "");
		AssertEquals(firstNameErrorMessage, "Valid name is mandatory.", "");
		AssertEquals(lastNameErrorMessage, "Valid surname is mandatory.", "");
		scrollDown();
		AssertEquals(genderErrorMessage, "Gender is mandatory.", "");
		AssertEquals(dobErrorMessage, "Date of birth is mandatory.", "");
		AssertEquals(religionErrorMessage, "Religion is mandatory.", "");
		AssertEquals(motherTongueErrorMessage, "Community is mandatory.", "");
		Submit();
		Thread.sleep(2000);

	}

	public void changeContext(String context) {

		// WEBVIEW_com.shaadi.android

		@SuppressWarnings("unchecked")
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context(context); // set context to WEBVIEW_1

		System.out.println("Context changed");
	}

	public void selectDOB(String dd, String mm, String yy) {

		Year();
		SelectYear(yy);
		Month();
		SelectMonth(mm);
		Day();
		SelectDay(dd);

	}
	
	
	
	public void performReg(ReactRegData reg1Data) throws InterruptedException {
		Thread.sleep(4000);
		regpage1_GoogleSinup(reg1Data);
		regpage2(reg1Data);
		regpage3(reg1Data);
		regpage4(reg1Data);
		
		System.out.println("Done with Reg");
		
		Thread.sleep(5000);

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			changeContext("NATIVE_APP");
		}

		System.out.println("Context changed to Native");

		completeRegFlow();
	}

}
