package page.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.ChatPage;

public class ChatWindowTest extends BasePageActions {

	BottomMenu menu;
	ChatPage chat;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		menu = new BottomMenu();
		chat = new ChatPage();
	}

	@Test(priority = 0, description = "Naigate to chat window")
	public void navigateToChatWindow() throws Exception {

		menu.clickChatTab();
		waitForElementToBeDisplayed(chat.chatWindowOptions.get(0), "Wait for Chat page to load", "");

	}

	@Test(priority = 1, description = "Verify recent chat window")
	public void verfiyRecentChatTab() throws InterruptedException {

		click(chat.chatWindowOptions.get(0), "Click on recent chats", "");
		waitForElementToBeDisplayed(chat.memberName, "Wait for Recent Chat window to be visible", "");
		chat.memberName.click();
		chat.verifyViewContactButton();
		chat.verifyViewProfileOnChatPage();
		chat.verifyProfileInfo();
		chat.sendMessage();
	}

	@Test(priority = 2, description = "Verify MyMatches carousal on recent chat window")
	public void verfiyMyMachesCarousalRecentChatsTab() throws InterruptedException {

		click(chat.chatWindowOptions.get(0), "Click on recent chats", "");
		if (isDisplayed(chat.myMatchesCarousalOnRecentchatTab)) {
			String text = chat.myMatchesCarousalOnRecentchatTab.getText();
			System.out.println(text);
			Assert.assertTrue(text.contains("My Matches"));
		}

		// Open chat window by clicking on my matches carousal profile
		click(chat.profilesOnMyMatchesCarousal.get(0), "open chat window", "");

		chat.verifyViewContactButton();
		chat.verifyViewProfileOnChatPage();
		chat.verifyProfileInfo();
		chat.sendMessage();
	}

	@Test(priority = 3, description = "Verify Active chat window")
	public void verfiyActiveChatWindow() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		click(chat.chatWindowOptions.get(1), "Click on recent chats", "");// Navigate to recent chat window
		sa.assertEquals(chat.onlineTextOnActiveTab.getText(), "Online" , "Online text not present on recent chat window");
		click(chat.onlineMemberName, "Click on online profile", "");
		chat.verifyViewContactButton();
		chat.verifyViewProfileOnChatPage();
		chat.verifyProfileInfo();
		chat.sendMessage();
		sa.assertAll();
		
	}

}
