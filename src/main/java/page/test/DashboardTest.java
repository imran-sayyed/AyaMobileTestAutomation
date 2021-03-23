package page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.actions.DashboardActions;
import page.actions.MatchesPage;
import page.objects.DashboardObjects;
import page.objects.MatchesPageObjects;
import shaadi.utils.AppStringConstants;

public class DashboardTest extends DashboardActions {

	public static String setUserType;
	public static boolean setScrollFlag = true;
	public static DashboardObjects dsh_obj;
	public static MatchesPageObjects mat_obj;
	public static MatchesPage matchPage;

	@BeforeClass(alwaysRun = true)
	public void handleConditions() throws InterruptedException {
		dsh_obj = new DashboardObjects();
		matchPage = new MatchesPage();
		mat_obj = new MatchesPageObjects();
		Thread.sleep(5000);
		if (isDisplayed(mat_obj.imgVIPShaadiCancel)) {
			mat_obj.imgVIPShaadiCancel.click();
		}
		DashboardObjects.btnMyShaadiTab.click();
//		closeUnWantedPage();
	}

	@Test(priority = 0, groups = "", description = "Check account type of the user")
	public void chckProfileType_Free() throws Exception {

		setUserType = setMyUser();

		if (setUserType.equals("Free")) {

			System.out.println("Account type of User is Free");

			Assert.assertEquals(DashboardObjects.usrAcntType.getText().trim(), AppStringConstants.txtFreeUser,
					"Free user label is displayed on the dashboard");
		} else {
			System.out.println("User is of type Premium Hence Test case not valid");

		}
	}

	@Test(priority = 1, groups = "", description = "check profile type is premium")
	public void chckProfileType_Premium() {

		if (setUserType.equals("Free")) {

			System.out.println("User is of type Free Hence Test case not valid");

		} else {

			Assert.assertTrue(
					DashboardObjects.usrAcntType.getAttribute("label").contains(AppStringConstants.txtGenericAccnt),
					"Account Type is displayed on the dashboard as " + DashboardObjects.usrAcntType.getText());

		}
	}

	@Test(priority = 2, groups = "", description = "check if the user can see edit option and navigate to it")
	public void chckEdtProfile() throws InterruptedException {
		DashboardObjects.btnEdtProfile.click();

		Assert.assertTrue(chckElementPresent(DashboardObjects.txtMyProfile),
				"Edit Profile is clickable and My Porfile Header is seen");

		driver.navigate().back();

	}

	@Test(priority = 3, groups = "", description = "check if the user see upgrdae button according to profile tyoe")
	public void chckUpgrdBtn_FreeUser() throws InterruptedException {

		boolean setVisible = false;

		if (setUserType.equals("Free")) {

			if (chckElementPresent(DashboardObjects.btnRewnPremium) == true
					|| chckElementPresent(DashboardObjects.btnUpgrdNw) == true) {

				setVisible = true;

				Assert.assertTrue(setVisible, "Renew Button or Upgrade Now Button for Free User is Seen");
			}

		}

		else {

			System.out.println("The user is Premium User and Renew or Upgrade Button is not Seen");
		}
	}

	@Test(priority = 4, groups = "", description = "Check account expiry if Applicapble")
	public void checkAcntExpry_PremiumUser() throws InterruptedException {

		boolean setExpiry = false;

		if (setUserType.equals("Free")) {

			System.out.println("The user is free user hence Expiry date will not be seen");

		} else {

			setExpiry = chckElementPresent(DashboardObjects.txtExpiryDate);

			Assert.assertTrue(setExpiry,
					"The account and Expiry Date is as" + DashboardObjects.txtExpiryDate.getText());

			System.out.println(
					"The account is Premium and Expiry Date is as Follows " + DashboardObjects.txtExpiryDate.getText());

		}
	}

	@Test(priority = 5, groups = "")
	public void checkTrustBadge() throws InterruptedException {

		if (chckElementPresent(DashboardObjects.btnTrustBadge) == true) {

			System.out.println("The user is already verified and hence Test case is not Needed");

		} else {

			DashboardObjects.verifyProfile.click();

			Thread.sleep(3000);

			if (chckElementPresent(DashboardObjects.navVerifyProfile) == true) {
				Assert.assertTrue(chckElementPresent(DashboardObjects.navVerifyProfile),
						"Verify Profile Window is Open");

			} else {
				Assert.assertTrue(chckElementPresent(DashboardObjects.navVerifyProfile_Number),
						"Verify Mobile Number  Window is Open");

			}

		}
	}

	@Test(priority = 6, groups = "", description = "Verify mobile option is seen or not")
	public void verifyMobileNumber() throws InterruptedException {

		driver.navigate().back();

		if (chckElementPresent(DashboardObjects.verifyCnct) == true) {

			DashboardObjects.verifyCnct.click();

			Assert.assertTrue(chckElementPresent(DashboardObjects.navVerifyNumber), "Verify Phone Number Page is Open");

			Assert.assertTrue(chckElementPresent(DashboardObjects.btnReqstPin), "Verify Request Pin Button is seen");

			Assert.assertTrue(chckElementPresent(DashboardObjects.btnVerify), "Check if Verify Button is  seen");

		}
	}

	@Test(priority = 7, groups = "", description = "check if user is able to see upload option and perform photo upload")
	public void verifyPhotoUpload() throws InterruptedException {

		driver.navigate().back();

		if (chckElementPresent(DashboardObjects.txtUploadPics) == true) {
			DashboardObjects.txtUploadPics.click();
			Thread.sleep(3000);
			DashboardObjects.btnUseCamera.click();
			// ADDED TAP BY Coordinate for the time being since click on id is not workng
			// for now
			// DashboardObjects.txtClickPic.click();
			// tapByCoordinate(70, 649);
			Thread.sleep(2000);
			if (chckElementPresent(DashboardObjects.btnOk) == true) {
				DashboardObjects.btnOk.click();
			}

			DashboardObjects.btnFrntCamera.click();
			Thread.sleep(2000);
			DashboardObjects.btnPhtCapture.click();
			Thread.sleep(2000);
			DashboardObjects.btnUsePhoto.click();

			Assert.assertTrue(chckElementPresent(DashboardObjects.txtUploadProg), "Uploading Photo Pop Up is seen ");

			Assert.assertTrue(chckElementPresent(DashboardObjects.txtUploadProgrs),
					"Upload in BackGround Text is seen");

		}

		else {
			System.out.println("The profile does not have upload photo options since it has already uploaded photo");
		}
	}

	@Test(priority = 8, groups = "", description = "check is astro details is seen for the user")
	public void checkAstroDetails() throws InterruptedException {
		Thread.sleep(3000);

		if (chckElementPresent(DashboardObjects.txtAstroDtls) == true) {

			DashboardObjects.txtAstroDtls.click();

			addHoroScopeDetails("India", "Mumbai", "English", "South Indian");

			Thread.sleep(3000);

			Assert.assertTrue(chckElementPresent(DashboardObjects.txtAstroConfirmation),
					"Confirmation Pop Up for astro details is seen");

			DashboardObjects.btnOk.click();

			Assert.assertTrue(chckElementPresent(DashboardObjects.btnViewHoroScp),
					"Confirmation Pop Up for astro details is seen");

			driver.navigate().back();

		}

		else {
			System.out.println("The user does not have an option to add astro details hence no Run");
		}

	}

	@Test(priority = 9, groups = "", description = "check the user's Premium matches")
	public void checkPremiumMatchesCarousal() throws InterruptedException {
		Thread.sleep(3000);
		// added this condition since Dashboard page automatically scroll up or down on
		if (chckElementPresent(DashboardObjects.txtHelp)) {
			scrollUpToElement(DashboardObjects.btnSeeAll_premium);

		} else {
			scrollDownToElement(DashboardObjects.btnSeeAll_premium);

		}

		genericChkConn(DashboardObjects.bntConnectNow_Premium,
				"The connection button from Premium Matches Section is Working Fine");

	}

	@Test(priority = 10, groups = "", description = "Check the Premium see all section")
	public void chckSeeAllSection_PM() throws InterruptedException {

		Thread.sleep(3000);

		if (chckElementPresent(DashboardObjects.txtHelp)) {
			scrollUpToElement(DashboardObjects.btnSeeAll_premium);
			DashboardObjects.btnSeeAll_premium.click();

		} else {
			scrollDownToElement(DashboardObjects.btnSeeAll_premium);
			DashboardObjects.btnSeeAll_premium.click();
		}

		Thread.sleep(8000);

		Assert.assertEquals(DashboardObjects.txtPremiumMatchesTab.getText(), "Recently upgraded Premium members",
				"See All button Nagivates to all the Premium Macthes Page");

	}

	@Test(priority = 11, groups = "", description = "Check the RecentlyJoinedCarousal")
	public void checkRecentlyJoinedCarousal() throws InterruptedException {

		setScrollFlag = false;

		Thread.sleep(3000);

		DashboardObjects.btn_back.click();// To Bring the page back to Home Page

		Thread.sleep(7000);

		if (chckElementPresent(DashboardObjects.txtHelp)) {
			scrollUpToElement(DashboardObjects.btnSeeAllNewlyJoined);

		} else {
			scrollDownToElement(DashboardObjects.btnSeeAllNewlyJoined);

		}

		// scrollDownToElement(DashboardObjects.btnSeeAllNewlyJoined);

		genericChkConn(DashboardObjects.btnConnectNow_RecentlyJoined,
				"The connection button from Recently Joined Matches Section is Working Fine");

	}

	@Test(priority = 12, groups = "", description = "Check the RecentlyJoinedCarousal See all Section")
	public void chckSeeAllSection_RecentlyJoined() throws InterruptedException {

		// added this condition since Dashboard page automatically scroll up or down on
		// back navigation
		Thread.sleep(7000);
		if (chckElementPresent(DashboardObjects.txtHelp)) {
			scrollUpToElement(DashboardObjects.btnSeeAllNewlyJoined);
			Thread.sleep(2000);
			DashboardObjects.btnSeeAllNewlyJoined.click();
		} else {
			scrollDownToElement(DashboardObjects.btnSeeAllNewlyJoined);
			Thread.sleep(2000);
			DashboardObjects.btnSeeAllNewlyJoined.click();
		}

		Thread.sleep(9000);

		Assert.assertEquals(DashboardObjects.txtRecentlyJoinedTab.getText(), "Members who joined recently",
				"See All button Nagivates to all the Recently Joined Macthes Page");

	}

	@Test(priority = 13, groups = "", description = "Check the RecentlyVisitorCarousal")
	public void checkRecentVisitorsCarousal() throws InterruptedException {

		setScrollFlag = false;// set to false since no more scroll is required

		DashboardObjects.btn_back.click();// To Bring the page back to Home Page

		Thread.sleep(7000);

		scrollDownToElement(DashboardObjects.txtHelp);

		genericChkConn(DashboardObjects.btnConnectNow_RecentlyVisitors,
				"The connection button from Recent Visited Matches Section is Working Fine");

	}

	@Test(priority = 14, groups = "", description = "Check the RecentlyVisitorCarousal See all Section")
	public void chckSeeAllSection_RecentVisitors() throws InterruptedException {

		Thread.sleep(2000);
		DashboardObjects.btnSeeAllRecentVisitors.click();

		Thread.sleep(3000);

		Assert.assertEquals(DashboardObjects.txtRecentVisitorsTab.getText(), "Members who visited your Profile",
				"See All button Nagivates to all the Recent Visitors Macthes Page");

	}

	@Test(priority = 15, groups = "", description = "Check the PP page of the user")
	public void chckPartnerPreference() throws InterruptedException {

		DashboardObjects.btn_back.click();

		Thread.sleep(5000);

		scrollDownToElement(DashboardObjects.txtHelp);

		DashboardObjects.txtPartnerPreferences.click();

		Thread.sleep(8000);

		Assert.assertEquals(DashboardObjects.txtPartnerPref.getText(),
				"Tell us what you are looking for in a life partner", "Navigation bar for Partner Preference is seen ");

	}

	@Test(priority = 16, groups = "", description = "Check the Contact Filter ")
	public void chckContactFilters() throws InterruptedException {

		DashboardObjects.btn_back.click();

		Thread.sleep(2000);

		scrollDownToElement(DashboardObjects.txtHelp);

		Thread.sleep(2000);

		DashboardObjects.txtContactsFilter.click();

		Thread.sleep(3000);

		Assert.assertTrue(chckElementPresent(DashboardObjects.txtMoreFilterCriteria),
				"Contact Filter Page is accessible");

	}

	@Test(priority = 17, groups = "", description = "Check the Push notification")
	public void chckAccountSetting_PushNotification() throws InterruptedException {

		DashboardObjects.btn_back.click();

		Thread.sleep(3000);

		scrollDownToElement(DashboardObjects.txtHelp);

		DashboardObjects.txtAcntSettings.click();

		Thread.sleep(2000);

		DashboardObjects.btnPushNotification.click();

		checkToggleStatus(DashboardObjects.swtchNewInvitations);

		checkToggleStatus(DashboardObjects.swtchRecommendations);

		checkToggleStatus(DashboardObjects.swtchShortlists);

	}

	@Test(priority = 18, groups = "", description = "Check the Email ID edit option")
	public void chckAccountSetting_EdtEmailId() throws InterruptedException {

		DashboardObjects.btn_back.click();

		Thread.sleep(5000);

		click(DashboardObjects.edtEmailField, "Click on Edit Email button", "18");

		Thread.sleep(3000);

		Assert.assertTrue(chckElementPresent(DashboardObjects.newEmailIdField), "Edit Email Field is seen");

		Assert.assertTrue(chckElementPresent(DashboardObjects.newPasswordField), "New Password Feild is seen");

	}

	@Test(priority = 19, groups = "", description = "Check the Notification Tabs")
	public void checkNotificationTab() throws InterruptedException {

		DashboardObjects.btnCancelEdit.click();// performing this operation here incase Email Test case fails

		Thread.sleep(2000);

		driver.navigate().back();

		Thread.sleep(3000);

		scrollDownToElement(DashboardObjects.txtNotifications);

		click(DashboardObjects.txtNotifications, "Click on Notification button", "19");

		Thread.sleep(3000);

		Assert.assertEquals(DashboardObjects.navNotificationsTab.getAttribute("name"), "Notifications",
				"Notification Page is seen ");

	}

	@Test(priority = 20, groups = "",description = "Check the Help and Support Tabs")
	public void checkHelpTab_isSeen() throws InterruptedException {

		driver.navigate().back();

		Thread.sleep(5000);

		Assert.assertTrue(chckElementPresent(DashboardObjects.txtHelp), "Help & Support Option is Seen");

	}

}
