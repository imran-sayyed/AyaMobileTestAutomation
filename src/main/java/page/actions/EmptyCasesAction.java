package page.actions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import data.ReactRegData;
import page.objects.EmptyCasesObject;
import page.test.EmptyCasesTest;
import shaadi.utils.AppStringConstants;

public class EmptyCasesAction extends EmptyCasesObject {

	RegistrationPage reg_page = new RegistrationPage();
	Object[][] returnValue;

	public void regpage1(ReactRegData reg1Data) throws InterruptedException {

		reg_page.InputUseNamePassword(reg1Data.userName, reg1Data.password);

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDown();
			reg_page.MobileNumber(reg1Data.contactNumber);
		}

		reg_page.Posted();
		reg_page.PostedByOptions("Self");
		reg_page.InputFirstNameLastName(reg1Data.firstName, reg1Data.lastName);
		reg_page.Gender(reg1Data.gender);
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			scrollDown();
		}

		reg_page.selectDOB(reg1Data.day, reg1Data.month, reg1Data.year);

		reg_page.Religion();
		reg_page.SelectReligion(reg1Data.religion);
		reg_page.Community();
		reg_page.SelectCommunity(reg1Data.motherTongue);
		reg_page.LivingIn();
		reg_page.SelectLivingIn(reg1Data.livingIn);
		reg_page.Submit();
		waitForElementToBeDisplayed(reg_page.stateOfResidence, "wait for next page to load", "");

	}

	public void regpage2(ReactRegData reg1Data) throws InterruptedException {
		// added to store the value in global variable for further action

		Thread.sleep(2000);
		reg_page.State();
		reg_page.SelectStateLivingIn(reg1Data.stateLivingIn);
		reg_page.city();
		reg_page.SelectCity(reg1Data.cityLivingIn);

		reg_page.SelectLivingSince(reg1Data.livingSince, reg1Data.livingIn);
		reg_page.SelectGrewUpIn(reg1Data.grewUpIn);
		reg_page.SelectResidencyStatus(reg1Data.residencyStatus);

		reg_page.MaritalStatus(reg1Data.maritialStatus);
		reg_page.selectAnyChildren(reg1Data.children, reg1Data.maritialStatus);
		reg_page.selectNoOfChildren(reg1Data.noOfChildren);

		reg_page.selectDiet(reg1Data.diet);
		reg_page.Height(reg1Data.height);

		reg_page.selectCommunity(reg1Data.subcommunity);
		reg_page.Continue();
		waitForElementToBeDisplayed(reg_page.webEducationLevel, "", "");
		Thread.sleep(2000);

	}

	public void regpage3(ReactRegData reg1Data) throws InterruptedException {

		reg_page.Education(reg1Data.eductionLevel);
		// EducationField(reg1Data.educationField);
		reg_page.Income(reg1Data.annualIncome);
		reg_page.Continue();
		Thread.sleep(2000);

	}

	public void regpage4(ReactRegData reg1Data) throws InterruptedException {

		if (isDisplayed(reg_page.createProfileButton)) {
			if (isDisplayed(reg_page.webContactNumber)) {
				reg_page.createProfileButton.click();

				reg_page.MobileNumber(reg1Data.contactNumber);
			}
			reg_page.createProfileButton.click();

		} else {

			reg_page.selectDiet(reg1Data.diet);
			reg_page.Height(reg1Data.height);
			Thread.sleep(3000);
			// mobile number check needed for ios regflow
			if (isDisplayed(reg_page.webContactNumber)) {
				reg_page.MobileNumber(reg1Data.contactNumber);
			}
			reg_page.Continue();
			Thread.sleep(3000);
			reg_page.createProfileButton.click();

		}

	}

	public void performReg(ReactRegData reg1Data) throws InterruptedException {
		regpage1(reg1Data);
		regpage2(reg1Data);
		regpage3(reg1Data);
		regpage4(reg1Data);

		System.out.println("Done with Reg");

		Thread.sleep(5000);

		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			reg_page.changeContext("NATIVE_APP");
		}

		System.out.println("Context changed to Native");

		reg_page.completeRegFlow();
	}

	public void checkEmptyMessages(WebElement invitationHeader, WebElement titleMessageElement,
			WebElement subtitleMessageEelement, String TitleMessage, String subtitleMessage) {
		boolean pendinInvitaion;

		@SuppressWarnings("unused")
		String actualTitle, actualSubTitle;

		actualTitle = titleMessageElement.getText();

		actualSubTitle = subtitleMessageEelement.getText();

		pendinInvitaion = isDisplayed(invitationHeader);

		Assert.assertTrue(pendinInvitaion, "The headear for the TAB is seen");

		Assert.assertEquals(titleMessageElement.getText().trim(), TitleMessage.trim());

		if (RunEnvironment.equalsIgnoreCase("iosLocal")) {
			// added because the string on android and iOS for View Today's Matches on
			// Received tab is different
			if (EmptyCasesTest.receivedFlag == true) {
				Assert.assertEquals(subtitleMessageEelement.getText().trim(),
						AppStringConstants.viewTodaysMatchesRecievedIOS);

			} else {
				Assert.assertEquals(subtitleMessageEelement.getText().trim(), subtitleMessage);
			}

		}

		else {
			// added this because there is difference in narration on ios and android
			// platform for received TAB
			if (EmptyCasesTest.receivedFlag == false) {
				if (EmptyCasesTest.shortlistTab == true) {
					// short list tab has some other message in android
					Assert.assertEquals(subtitleMessageEelement.getText().trim(), subtitleMessage);
				} else {
					Assert.assertEquals(subtitleMessageEelement.getText().trim(),
							AppStringConstants.noPendingInvitationAcceptedANDROID);

				}
			}

			else {
				Assert.assertEquals(subtitleMessageEelement.getText().trim(), subtitleMessage.trim());
			}
		}

	}

	public void checkEmptyMessages_RequestTab(WebElement invitationHeader, WebElement titleMessageElement,
			String subtitleMessage) {
		boolean pendinInvitaion;

		@SuppressWarnings("unused")
		String actualTitle, actualSubTitle;

		actualTitle = titleMessageElement.getText();

		pendinInvitaion = isDisplayed(invitationHeader);

		if (RunEnvironment.equalsIgnoreCase("iosLocal")) {
			Assert.assertTrue(pendinInvitaion, "The headear for the TAB is seen");
			Assert.assertEquals(titleMessageElement.getText(), subtitleMessage);
		}

		else {

			Assert.assertEquals(titleMessageElement.getText(), AppStringConstants.noPendingRequestRequestAndroid);

		}

	}

}
