package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import android.shaadi.BasePageActions;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChatPageObjects extends BasePageActions {

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.shaadi.android:id/toolbar']/android.widget.TextView")
	public WebElement profileNameOnChatPage;

	@FindBy(id = "com.shaadi.android:id/btn_shaadi_chat")
	public WebElement shaadiChatButtonPremium;

	@FindBy(id = "com.shaadi.android:id/tv_upgrade_msg_header")
	public WebElement upgradeNowLinkOnChatWindow;

	@FindBy(id = "com.shaadi.android:id/tvDashboard")
	public WebElement chatWindowHeaderText;

	@FindBy(className = "androidx.appcompat.app.ActionBar$b")
	public List<WebElement> chatWindowOptions;

	@FindBy(id = "com.shaadi.android:id/txt_matches_carousal_title")
	public WebElement myMatchesCarousalOnRecentchatTab;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.shaadi.android:id/rvRecentChat_carousal']/android.widget.RelativeLayout")
	public List<WebElement> profilesOnMyMatchesCarousal;

	@FindBy(className = "android.widget.TextView")
	public List<WebElement> listOfTextOnChatWindow;

	@FindBy(id = "com.shaadi.android:id/menu_view_contact")
	public WebElement viewContactButtonChatTab;

	@AndroidFindBy(id = "com.shaadi.android:id/cpb_view_plan")
	public WebElement ViewPlansOnBottomSheet;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_mobile_no")
	public WebElement MaskedNum;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_email")
	public WebElement MaskedEmail;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_header")
	public WebElement BottomSheetText;

	@AndroidFindBy(id = "com.shaadi.android:id/iv_cancel")
	public WebElement CloseIcon;

	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage")
	public WebElement shaadiChatButton;

	@AndroidFindBy(id = "com.shaadi.android:id/menu_chat")
	public WebElement menuButtonChatTab;

	@AndroidFindBy(id = "com.shaadi.android:id/title")
	public WebElement viewprofileText;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_name")
	public WebElement profileName;

	@AndroidFindBy(id = "com.shaadi.android:id/text_age_height")
	public WebElement txtAgeHeight;

	@AndroidFindBy(id = "com.shaadi.android:id/profession")
	public WebElement profession;

	@AndroidFindBy(id = "com.shaadi.android:id/msg")
	public WebElement messageStatus;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public WebElement ChatbackButton;

	@FindBy(id = "com.shaadi.android:id/msgtext")
	public WebElement ClickWriteMsg;

	@FindBy(id = "com.shaadi.android:id/send_btn")
	public WebElement SendMsgBtn;

	@FindBy(id = "com.shaadi.android:id/design_bottom_sheet")
	public WebElement AppRatingLayer;

	@FindBy(id = "com.shaadi.android:id/name")
	public WebElement memberName;

	@FindBy(id = "com.shaadi.android:id/itemOnlineMember_txtLastOnlineStatus")
	public WebElement onlineTextOnActiveTab;

	@FindBy(id = "com.shaadi.android:id/itemOnlineMember_txtName")
	public WebElement onlineMemberName;
}
