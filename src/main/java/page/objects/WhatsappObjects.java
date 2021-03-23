

package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class WhatsappObjects {


	@AndroidFindBy(id = "com.shaadi.android:id/img_profile_images") 
	public static WebElement DRprofilePage;
	
	@AndroidFindBy(id = "com.shaadi.android:id/layoutNotContacted_txtClassic") 
	public static WebElement LikeThisProfile;
	
	@AndroidFindBy(id = "com.shaadi.android:id/btnConnect") 
	public static WebElement ConnectNowTopCTA;
	
	@AndroidFindBy(id = "com.shaadi.android:id/layoutMemberContacted_txtCaption") 
	public static WebElement ToContactdirectlytext;
	
	@AndroidFindBy(id = "com.shaadi.android:id/btnUpgrade") 
	public static WebElement UpgradeNowLink;
	
	@AndroidFindBy(id = "com.shaadi.android:id/ctaWriteMessage") 
	public static WebElement ShaadiChatCTA;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tvMessage") 
	public static WebElement ShaadiChatText;
	
	@AndroidFindBy(id = "com.shaadi.android:id/ctaWhatsapp") 
	public static WebElement WhatsappCTA;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_whatsapp") 
	public static WebElement WhatsappText;
	
	@AndroidFindBy(id = "com.shaadi.android:id/ctaViewContact") 
	public static WebElement CallCTA;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_view_contact") 
	public static WebElement CallText;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_header") 
	public static WebElement BottomSheetText;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_mobile_no") 
	public static WebElement MaskedNum;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tv_email") 
	public static WebElement MaskedEmail;
	
	@AndroidFindBy(id = "com.shaadi.android:id/cpb_view_plan") 
	public static WebElement ViewPlansOnBottomSheet;
	
	@AndroidFindBy(id = "com.shaadi.android:id/iv_cancel") 
	public static WebElement CloseIcon;
	
	@AndroidFindBy(id = "com.shaadi.android:id/imgInvites")
	public static WebElement inboxNav;
	
	@AndroidFindBy(className="androidx.appcompat.app.ActionBar$b")
	public static List<WebElement> acceptedtab;
	
	@AndroidFindBy(id="com.shaadi.android:id/item_inbox_profile_tv_name")
	public static WebElement VerifyUserName;
	
	@AndroidFindBy(id="com.shaadi.android:id/drop_down_options")
	public static WebElement DropdownAccepted;
	
	@AndroidFindBy(id="com.shaadi.android:id/iv_exit_stack")
	public static WebElement CloseStackicon;
	
	
}