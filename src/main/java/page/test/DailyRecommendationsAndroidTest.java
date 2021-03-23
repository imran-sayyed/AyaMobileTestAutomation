package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import android.shaadi.BaseTest;
import page.actions.BottomMenu;
import page.actions.MatchesPage;

public class DailyRecommendationsAndroidTest extends BasePageActions {

	MatchesPage matches;
	BottomMenu menu;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		matches = new MatchesPage();
		menu = new BottomMenu();

	}

	@Test(priority = 0, description = "Verify Today's Matches Text and top CTA's on profile page")
	public void verifyLandingOnDRPage() throws InterruptedException {

		matches.verifyLandingOnDRPage_DR(menu);
	}

	@Test(priority = 1, description = "Send top CTA connect")
	public void sendTopCTAConnect() throws InterruptedException {

		matches.sendConnect_DR();

	}

	@Test(priority = 2, description = "Verify CTAs after sending connect ")
	public void verifyCTAAFterConnect() throws InterruptedException {

		matches.verifyCTAAFterConnect_DR();
		Thread.sleep(2000);
		matches.SwipeNext.click();
	}

	@Test(priority = 3, description = "View contact from DR profile page ")
	public void viewContactFromDRPage() throws InterruptedException {

		if (BaseTest.UserType.contains("premium")) {
			SoftAssert sa = new SoftAssert();

			click(matches.btn_viewContact_DR, "Click on top View Contact CTA ", "viewContactFromDRPage");
			if (isDisplayed(matches.ShaadiChatCTA) || isDisplayed(matches.ShaadiChatButtonPhoneNumberHidden)) {
				sa.assertTrue(
						isDisplayed(matches.ShaadiChatCTA) || isDisplayed(matches.ShaadiChatButtonPhoneNumberHidden));
			}
			waitForSometime(2000);
			driver.navigate().back();
			sa.assertAll();
		}
	}

	@Test(priority = 4, description = "Verify CTAs after viewing contact number  ")
	public void verifyCTAAfterViewContact() throws InterruptedException {
		if (BaseTest.UserType.contains("premium")) {

			click(matches.PrevArrowBtn, "Go to previous profile whose contact number we viewed",
					"verifyCTAAfterViewContact");

			matches.verifyCTAAFterConnect_DR();
			Thread.sleep(2000);
			matches.SwipeNext.click();
		}

	}

	@Test(priority = 5, description = "Verify bottom CTAs")
	public void verifyBottomCTA() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		scrollDown();
		scrollDown();
		if (BaseTest.UserType.contains("premium")) {

			while (!isDisplayedAfterWait(matches.btn_connectNow_DR, 3)) {
				Thread.sleep(2000);
				matches.SwipeNext.click();
			}

			sa.assertTrue(isDisplayedAfterWait(matches.btn_viewContact_DR, 3),
					"View contact Button not visible on Bottom of Dr page");
			sa.assertTrue(isDisplayedAfterWait(matches.btn_connectNow_DR, 3),
					"Connect Now Button not visible on Bottom of Dr page");

		} else {

			while (!isDisplayedAfterWait(matches.btn_ConnectNowText, 3)) {
				Thread.sleep(2000);
				matches.SwipeNext.click();
			}
			sa.assertEquals(matches.btn_ConnectNowText.getText(), "Connect Now", "Connect Now CTA is not displayed");

		}
		sa.assertAll();
	}

	@Test(priority = 6, description = "Send connect from bottom CTA's ")
	public void sendConnectFromBottomCTA() throws InterruptedException {

		matches.sendConnect_DR();

	}

	@Test(priority = 7, description = "Verify Bottom CTAs after sending connect ")
	public void verifyBottomCTAAfterConnect() throws InterruptedException {

		matches.verifyCTAAFterConnect_DR();

	}

	@Test(priority = 8, description = "Verify todays matches count decrease after swipe to next profile")
	public void verifyMatchesCountDecreaseOnSwipe() throws InterruptedException {

		matches.verifyMatchesCountDecreaseOnSwipe_DR();
	}

	@Test(priority = 9, description = "Verify add to shortlist and remove from shortlist functionality")
	public void VerifyShortlistProfile() throws InterruptedException {

		if (isDisplayedAfterWait(matches.dropdownArrow, 2)) {
			matches.shortlistUserFromProfilePage(matches.dropdownArrow);

		} else {
			matches.shortlistUserFromProfilePage(matches.dropDownThreeDots);
		}

	}

	@Test(priority = 10, description = "Verify block profile functionality")
	public void verifyBlockProfile() throws InterruptedException {

		if (isDisplayedAfterWait(matches.dropdownArrow, 2)) {
			matches.blockUserFromProfilePage(matches.dropdownArrow);

		} else {
			matches.blockUserFromProfilePage(matches.dropDownThreeDots);
		}
	}

	@Test(priority = 11, description = "report a user from  profile page dropdowm")
	public void verifyReportProfileOnDropDown() throws InterruptedException {

		if (isDisplayedAfterWait(matches.dropdownArrow, 3)) {

			matches.reportUserFromProfilePage(matches.dropdownArrow);
		} else {
			matches.reportUserFromProfilePage(matches.dropDownThreeDots);

		}

	}

	@Test(priority = 12, description = "Send Connect from Photo Album")
	public void sendConnectFromAlbum() throws InterruptedException {

		matches.sendConnectFromAlbum_DR();
	}
}