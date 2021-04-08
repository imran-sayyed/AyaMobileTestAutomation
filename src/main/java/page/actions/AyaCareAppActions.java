package page.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import page.objects.AyaCareAppObjects;
import page.objects.BottomMenuPageObjects;

public class AyaCareAppActions extends AyaCareAppObjects {
	
	public static String extractClaimID(String s) {
		
		
String claimID="";
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(s);

		while(m.find()) {
		    claimID=m.group(1);
		}
		return claimID;
	}

public static  String getClaimIDFromString(String s) {
		
		
		String[] claim_split=s.split("#");
		String claimID=claim_split[1].trim();
		
		return claimID;
		
		
		
	}
	
	
}
