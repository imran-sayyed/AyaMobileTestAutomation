package page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import android.shaadi.BasePageActions;
import page.actions.BottomMenu;
import page.actions.InboxPage;

public class SentRequestTest extends BasePageActions {
	
	BottomMenu menu;
	InboxPage inbox;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		
		menu = new BottomMenu();
		inbox = new InboxPage();
		
	}
	
	
	@Test(priority = 0, groups = "")
	public void Sent_Request() throws Exception
	{   
		
			menu.ClickInbox();
			inbox.ClickRequest();
			
			inbox.RequestActions();
			scrollUpToDown();
			inbox.RequestActionsWithoutAction();
		
			
	}
	}