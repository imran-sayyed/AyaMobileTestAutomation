package shaadi.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import android.shaadi.BasePageActions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MinAccess extends BasePageActions {
	
	public static WebDriver chromedriver;
	public static String status = "InActive";
	
	
	public static String removeEmailFromMin() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
		chromedriver = new ChromeDriver(options);
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromedriver.get("http://min.shaadi.com/login"); // Navigate to MIN URL
		Thread.sleep(3000);
		
		//Perform Login
		chromedriver.findElement(By.id("login")).sendKeys("rahulg");
		chromedriver.findElement(By.id("password")).sendKeys("People#35");
		chromedriver.findElement(By.id("submit")).click();
		
		//Deactivate the profile
		new WebDriverWait(chromedriver, 10).until(ExpectedConditions.visibilityOf(chromedriver.findElement(By.xpath("//a[text() = 'Member']"))));
		chromedriver.findElement(By.xpath("//a[text() = 'Member']")).click();
		Thread.sleep(2000);
		chromedriver.findElement(By.id("profileid")).sendKeys(AppStringConstants.googleSignInEmail);
		chromedriver.findElement(By.id("Go")).click();
			
		Thread.sleep(2000);
					
		List<WebElement> list = chromedriver.findElements(By.xpath("//li[text() = 'Member does not exist']"));
//			if(isDisplayedAfterWait(chromedriver.findElement(By.xpath("//li[text() = 'Member does not exist']")), 5))
//			{
//			status = "Active";
//			chromedriver.quit();
//			return status;
//		}
		
		if(list.size() > 0)
		{
		status = "Active";
		chromedriver.quit();
		return status;
	}
		
		
		System.out.println("outside return status");
		
		 status = chromedriver.findElement(By.xpath("//th[text() = 'Status']/following-sibling::td")).getText();
		
		
		if(status.equalsIgnoreCase("Active")) {
		
		List<WebElement> tableLinks = chromedriver.findElements(By.xpath("//table[@class = 'curve_table_border']/tbody/tr/td[2]/a"));
		for(WebElement a : tableLinks) {
			if(a.getAttribute("href").contains("deactivate")) {
				a.click();
				break;
			}
			Thread.sleep(3000);
		}
		
		chromedriver.findElement(By.id("remark")).sendKeys("Test Profile........");
		Thread.sleep(2000);

		Select select = new Select(chromedriver.findElement(By.id("reason")));
		select.selectByValue("No I Proof");
		Thread.sleep(2000);
		
		chromedriver.findElement(By.xpath("(//a[text() = 'Deactivate'])[2]")).click();
		Thread.sleep(4000);

		
		
		
		
		
		//Unblock email id
		new WebDriverWait(chromedriver, 10).until(ExpectedConditions.visibilityOf(chromedriver.findElement(By.xpath("//a[text() = 'Member']"))));
		chromedriver.findElement(By.xpath("//a[text() = 'Member']")).click();
		Thread.sleep(2000);
		chromedriver.findElement(By.id("profileid")).sendKeys(AppStringConstants.googleSignInEmail);
		chromedriver.findElement(By.id("Go")).click();
		
		Thread.sleep(5000);

		
		List<WebElement> tableLinks1 = chromedriver.findElements(By.xpath("//table[@class = 'curve_table_border']/tbody/tr/td[2]/a"));
		for(WebElement a : tableLinks1) {
			if(a.getAttribute("href").contains("unblock")) {
				a.click();
				break;

			}
			Thread.sleep(2000);

		}
		
		
		
		//Confirm if the email id is removed
		new WebDriverWait(chromedriver, 10).until(ExpectedConditions.visibilityOf(chromedriver.findElement(By.xpath("//a[text() = 'Member']"))));
		chromedriver.findElement(By.xpath("//a[text() = 'Member']")).click();
		Thread.sleep(2000);
		chromedriver.findElement(By.id("profileid")).sendKeys(AppStringConstants.googleSignInEmail);
		chromedriver.findElement(By.id("Go")).click();
		
		Thread.sleep(2000);
		List<WebElement> list1 = chromedriver.findElements(By.xpath("//li[text() = 'Member does not exist']"));

		
//			if(isDisplayedAfterWait(chromedriver.findElement(By.xpath("//li[text() = 'Member does not exist']")), 5)) {
		if(list1.size() > 0)
		{

			System.out.println("Email id removed successfully");
		}
		else {
			
			System.out.println("Email id not removed from MIN , please try again......");
			
		}
		
		}
		
		chromedriver.quit();
		
		return status;
		
		
	}
	


	public static void main(String[] args) throws InterruptedException {
		
		String s = removeEmailFromMin();
		
		System.out.println(s);
		
	}
		// TODO Auto-generated method stub
	

}
