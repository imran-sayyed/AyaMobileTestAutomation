package android.shaadi;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.relevantcodes.extentreports.LogStatus;

import data.PaymentRevampData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import page.objects.BottomMenuPageObjects;
import page.objects.SearchObjects;

public class BasePageActions extends BaseTest {
	public static String text;
	private static String report_date;
	private static String report_date1;

	public BasePageActions() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static String currentTime() {
		DateFormat dateFormat = new SimpleDateFormat("E-yyyy-MM-dd-'at'-hh-mma");
		// get current date time with Date()
		Date date = new Date();

		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		report_date1 = dateFormat.format(date);
		report_date = report_date1.toLowerCase();
		System.out.println("curent time is" + report_date);
		return report_date;
	}

	public static void scrollTillVisibleText(String text) {
		try {
			((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
		} catch (Exception e) {
			System.out.println("text not visible");

		}
	}

	public static void scrollTillVisibleTextAndClick(String text) {
		try {
			((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));").click();
		} catch (Exception e) {
			System.out.println("text not visible");

		}
	}

	public void scrollAndClickUsingResourceID(String resourceID) {

		try {
			((AndroidDriver<AndroidElement>) driver)
					.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"" + resourceID + "\"));")
					.click();
		} catch (Exception e) {
			System.out.println("element not found");
		}
	}

	public void scrollUsingResourceID(String resourceID) {

		try {
			((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"" + resourceID + "\"));");
		} catch (Exception e) {
			System.out.println("element not found");
		}
	}

	// NOT USED ANYWHERE
	public static void scrollTillPartialVisibleText(String text) {
		try {
			((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"" + text + "\"));");
		} catch (Exception e) {
			System.out.println("text not visible");
		}
	}

	public void scrollAndClickPartialVisibleText(String text) {
		try {
			((AndroidDriver<AndroidElement>) driver)
					.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"" + text + "\"));")
					.click();
		} catch (Exception e) {
			System.out.println("text not visible");
		}
	}

	public void scrollHorizontallyToTextpartial(List<WebElement> Locator, String ExpectedText, String Description,
			String TCID) {
		try {
			boolean found = false;
			String strExpected = ExpectedText;
			while (!found) {
				int size = 0;
				size = size + Locator.size();
				for (int i = 0; i < size; i++) {
					try {
						String strActual = Locator.get(i).findElement(By.className("android.widget.TextView"))
								.getText();

						String[] a = strActual.split(" ");
						if (a[0].equals(strExpected)) {
							System.out.print("Text: "
									+ Locator.get(i).findElement(By.className("android.widget.TextView")).getText());
							click(Locator.get(i), Description, TCID);
							found = true;
							break;
						}

					} catch (Exception e) {
						System.out.println("element not found");

					}
				}
				if (!found) {
					Dimension dim = driver.manage().window().getSize();
					int height = dim.getHeight();
					int width = dim.getWidth();
					int y = (int) (height * 0.10);
					int startx = (int) (width * 0.80);
					int endx = (int) (width * 0.30);
					driver.swipe(startx, y, endx, y, 500);
				}
			}
		} catch (Exception e) {
			System.out.println("Element not found");

		}

	}

	public static void scrollHorizontallyToTextpartial1(List<WebElement> Locator, String ExpectedText,
			String Description, String TCID) {
		try {
			boolean found = false;
			String strExpected = ExpectedText;
			while (!found) {
				int size = 0;
				size = size + Locator.size();
				for (int i = 0; i < size; i++) {
					try {
						String strActual = Locator.get(i).findElement(By.className("android.widget.TextView"))
								.getText();

						String[] a = strActual.split(" ");
						if (a[0].equals(strExpected)) {
							System.out.print("Text: "
									+ Locator.get(i).findElement(By.className("android.widget.TextView")).getText());
							click(Locator.get(i), Description, TCID);
							found = true;
							break;
						}

					} catch (Exception e) {
						System.out.println("element not found");

					}
				}
				if (!found) {
					Dimension dim = driver.manage().window().getSize();
					int height = dim.getHeight();
					int width = dim.getWidth();
					int y = (int) (height * 0.10);
					int startx = (int) (width * 0.80);
					int endx = (int) (width * 0.30);
					driver.swipe(startx, y, endx, y, 500);
				}
			}
		} catch (Exception e) {
			System.out.println("Element not found");

		}

	}

	public static void scrollHorizontallyToTextpartial2(List<WebElement> Locator, String ExpectedText,
			String Description, String TCID) {
		try {
			boolean found = false;
			String strExpected = ExpectedText;
			while (!found) {
				int size = 0;
				size = size + Locator.size();
				for (int i = 0; i < size; i++) {
					try {
						String strActual = Locator.get(i).findElement(By.className("android.widget.TextView"))
								.getText();

						String[] a = strActual.split(" ");
						if (a[0].equals(strExpected)) {
							System.out.print("Text: "
									+ Locator.get(i).findElement(By.className("android.widget.TextView")).getText());
							click(Locator.get(i), Description, TCID);
							found = true;
							break;
						}

					} catch (Exception e) {
						System.out.println("element not found");

					}
				}
				if (!found) {
					Dimension dim = driver.manage().window().getSize();
					int height = dim.getHeight();
					int width = dim.getWidth();
					int y = (int) (height * 0.10);
					int startx = (int) (width * 0.35);
					int endx = (int) (width * 0.85);
					driver.swipe(startx, y, endx, y, 500);
				}
			}
		} catch (Exception e) {
			System.out.println("Element not found");

		}

	}

	public static void swipeOnElement() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.50);
		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.30);
		driver.swipe(startx, y, endx, y, 500);

	}

	public static void scrollHorizontallyToText(List<WebElement> Locator, String ExpectedText, String Description,
			String TCID) {
		boolean found = false;
		String strExpected = ExpectedText;
		while (!found) {
			int size = 0;
			size = size + Locator.size();
			for (int i = 0; i < size; i++) {
				try {
					String strActual = Locator.get(i).findElement(By.className("android.widget.TextView")).getText();
					if (strActual.equals(strExpected)) {
						System.out.print("Text: "
								+ Locator.get(i).findElement(By.className("android.widget.TextView")).getText());
						click(Locator.get(i), Description, TCID);
						found = true;
						break;
					}
				}

				catch (Exception e) {
					System.out.println("element not found");
				}
			}
			if (!found) {
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int y = (int) (height * 0.10);
				int startx = (int) (width * 0.75);
				int endx = (int) (width * 0.35);
				driver.swipe(startx, y, endx, y, 500);
			}
		}
	}

	public static void scrollByLocation(List<WebElement> element, Point location, String City) {
		boolean found = false;
		String strExpected = City;
		while (!found) {
			int size = 0;
			size = size + element.size();
			for (int i = 0; i < size; i++) {
				String strActual = element.get(i).getText();
				if (strActual.equals(strExpected)) {
					System.out.print("Text: " + element.get(i).getText());
					click(element.get(i), "Click" + City, "Payment-13");
					found = true;
					break;
				}
			}
			if (!found) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(location.x + 200, location.y + 200).moveTo(location.x + 200, location.y + 175).release()
						.perform();
			}
		}
	}

	public static void scrollByLocation(List<WebElement> element, int X, Point location, String City) {
		boolean found = false;
		String strExpected = City;
		while (!found) {
			int size = 0;
			size = size + element.size();
			for (int i = 0; i < size; i++) {
				String strActual = element.get(i).getText();
				if (strActual.equals(strExpected)) {
					System.out.print("Text: " + element.get(i).getText());
					click(element.get(i), "Click" + City, "Payment-13");
					found = true;
					break;
				}
			}
			if (!found) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(location.x + X, location.y + X).moveTo(location.x + X, location.y + 175).release()
						.perform();
			}
		}
	}

	public static void ScrollByLocationSmallView(List<WebElement> element, int X, Point location, String City) {
		boolean found = false;
		String strExpected = City;
		while (!found) {
			int size = 0;
			size = size + element.size();
			for (int i = 0; i < size; i++) {
				String strActual = element.get(i).getText();
				if (strActual.equals(strExpected)) {
					System.out.print("Text: " + element.get(i).getText());
					click(element.get(i), "Click" + City, "Payment-13");
					found = true;
					break;
				}
			}
			if (!found) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(location.x + X, location.y + 25).moveTo(location.x + X, location.y).release().perform();
			}
		}
	}

	// NOT USED ANYWHERE
	public static void timeout(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// NOT USED ANYWHERE
	public static void scrollIOS(String Direction) {
		// down,up,left,right
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<Object, Object> scrollObject = new HashMap<Object, Object>();
		scrollObject.put("direction", Direction);
		js.executeScript("mobile: scroll", scrollObject);

	}

	public static void isElementFoundAndClickableiOS(WebElement Locator) {
		try {
			final JavascriptExecutor js = (JavascriptExecutor) driver;
			final HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("element", ((RemoteWebElement) Locator).getId());
			scrollObject.put("toVisible", "true");
			js.executeScript("mobile: scroll", scrollObject);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
	}

	// NOT USED ANYWHERE
	public static void scrollingIOSButton(WebElement Locator) {
		try {
			final JavascriptExecutor js = (JavascriptExecutor) driver;
			final HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("element", ((RemoteWebElement) Locator).getId());
			js.executeScript("mobile: scroll", scrollObject);
		} catch (Exception e) {

			System.out.println("Exception Occured " + e.getMessage());
		}
	}

	public static void scrollingIOS(WebElement Locator, String direction) {
		try {
			final JavascriptExecutor js = (JavascriptExecutor) driver;
			final HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("element", ((RemoteWebElement) Locator).getId());
			scrollObject.put("direction", direction);
			scrollObject.put("toVisible", "true");
			js.executeScript("mobile: scroll", scrollObject);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
	}

	public static void click(WebElement locator, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.click();
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
	}

	public static void waitForElementToBeDisplayed(WebElement locator, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locator));
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
	}

	public static void waitForElementToBeClickable(WebElement locator, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
	}

	public static void clickMoreWait(WebElement locator, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.click();
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
	}

	public static void InputValue(WebElement locator, String data, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.isEnabled();
			if (RunEnvironment.equals("iOSLocal")) {

			Thread.sleep(2000);
			}
			locator.clear();
			if (RunEnvironment.equals("iOSLocal")) {

			Thread.sleep(1000);
			}			
			locator.sendKeys(data);
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
	}

	public static void ContainsText(WebElement locator, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(locator));
			if (!locator.getText().isEmpty()) {
				extentTest.log(LogStatus.PASS, description);
				System.out.println(locator.getText());
			} else {
				extentTest.log(LogStatus.FAIL, description);
			}
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
	}

	public static boolean enabled(WebElement locator, String description, String tc) {

		try {
			if (locator.isEnabled()) {
				extentTest.log(LogStatus.PASS, description);
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		}
		return false;
	}

	public static void changeDriverContextToNative(AppiumDriver<?> driver) {
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("NATIVE")) {
				driver.context(contextName);
			}

		}
	}

	public static void changeDriverContextToWeb(AppiumDriver<MobileElement> driver) throws InterruptedException {

		Thread.sleep(8000);
		Set<String> allContext = ((AppiumDriver<MobileElement>) driver).getContextHandles();
		for (String context : allContext) {
			if (context.contains("WEBVIEW_chrome")) {
				try {
					driver.context(context);
				} catch (Exception e) {
					System.out.println("Exception Occured " + e.getMessage());
				}
				System.out.println(context);
			}
		}
		System.out.println("Completed");
	}

	public static void takeScreenshot(String tcid) {
		try {
			File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(SrcFile, new File(BaseTest.ScreenshotDirName + "/" + tcid + ".PNG"));
		} catch (Exception ex) {
			System.out.println(" path: ./ScreenShot/" + tcid + ".PNG");
			System.out.println("got exeception in screenshoot method");
			System.out.println(ex);
		}
	}

	public static boolean waitForPresence(WebElement locator, int timeLimitInSeconds, String description, String tcid) {
		boolean isElementPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(locator));
			isElementPresent = locator.isDisplayed();
			if (isElementPresent) {
				extentTest.log(LogStatus.PASS, description);
			} else {
				extentTest.log(LogStatus.FAIL, description);
				takeScreenshot(tcid);
			}
			return isElementPresent;
		} catch (Exception e) {
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}

	public static void ClickOnPresence(WebElement locator, int timeLimitInSeconds, String description, String tcid) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.isEnabled();
			locator.click();
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tcid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
		}
	}

	public static void ClickNoException(WebElement locator, int timeLimitInSeconds, String description, String tcid) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.isEnabled();
			locator.click();
			extentTest.log(LogStatus.INFO, description);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());

		}
	}

	public static void WaitTillElementDisplayed(WebElement locator, int timeLimitInSeconds, String description,
			String tcid) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(locator));
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tcid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
		}
	}

	public static void isElementDisplayed(WebElement locator, String description, String tcid) {
		try {
			boolean value = locator.isDisplayed();
			if (value) {
				extentTest.log(LogStatus.INFO, description);
			} else {
				extentTest.log(LogStatus.ERROR, description);
				takeScreenshot(tcid);
			}

		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.ERROR, description);
			takeScreenshot(tcid);
		}
	}

	public static boolean isDisplayed(WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(locator));
			boolean value = locator.isDisplayed();
			if (value) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isDisplayedAfterWait(WebElement locator, int timestamp) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timestamp);
			wait.until(ExpectedConditions.visibilityOf(locator));
			boolean value = locator.isDisplayed();
			if (value) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean chckElementPresent(WebElement elementName) throws InterruptedException {
		boolean setFlag = false;
		try {
			Thread.sleep(2000);
			if (elementName.isDisplayed() == true) {
				setFlag = true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Exception Occured " + e.getMessage());

		}
		return setFlag;
	}

	public static boolean elementPresent_By(By by) {
		boolean visibleFlag = false;

		try {
			driver.findElement(by);
			visibleFlag = true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			visibleFlag = false;
			System.out.println("Exception Occured " + e.getMessage());

		}

		return visibleFlag;
	}

	// NOT USED ANYWHERE
	public static String FeaturedType(WebElement locator, String description, String tcid) {
		String value = locator.getAttribute("name");
		try {
			if (value != null && !isNullOrEmpty(value)) {
				locator.isEnabled();
				locator.click();
			}

		} catch (NoSuchElementException e) {
			takeScreenshot(tcid);
			extentTest.log(LogStatus.FAIL, description);
		}
		return value;
	}

	// NOT USED ANYWHERE
	public static void WebUrl(WebElement locator, String description, String tcid) {
		locator.isEnabled();
		locator.click();
		try {
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
		}
	}

	// NOT USED ANYWHERE
	public static void dataIsPresentNumber(WebElement locator, String description, String tcid) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			boolean value = false;
			double x = locator.getText().length();
			String t = locator.getText();
			if (x > 0 && StringUtils.isNumeric(t))
				value = true;
			else if (x > 0 && t.matches("[0-9.]+")) {
				String[] a = t.split("\\.");
				int decimals = a[1].length();
				if (decimals <= 1)
					value = true;
			}
			System.out.println("boolean value is :" + value);

			if (value == true) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
			}
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);

		}
	}

	// NOT USED ANYWHERE
	public static void dataIsPresent(WebElement locator, String description, String tcid) {
		try {

			boolean value = false;
			double x = locator.getText().length();
			String t = locator.getText();
			if (x > 0 && !t.toLowerCase().contains("null") && !isNullOrEmpty(t) && !isNullOrWhitespace(t))
				value = true;

			System.out.println("boolean value is :" + value);

			if (value == true) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
			}

		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);

		}
	}

	// NOT USED ANYWHERE
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	// NOT USED ANYWHERE
	public static boolean isNullOrWhitespace(String s) {
		return s == null || isWhitespace(s);

	}

	// NOT USED ANYWHERE
	private static boolean isWhitespace(String s) {
		int length = s.length();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				if (!Character.isWhitespace(s.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	// NOT USED ANYWHERE
	public static void CheckImage(WebElement ImageFile, String description, String tcid) {

		try {
			Dimension size = ImageFile.getSize();
			Boolean ImagePresent;
			// String test = ImageFile.getAttribute("visible");

			if (size.height > 0 && size.width > 0 && ImageFile.isDisplayed()) {
				ImagePresent = true;
			} else {
				ImagePresent = false;
			}
			if (!ImagePresent) {
				System.out.println("Image not displayed.");
				extentTest.log(LogStatus.FAIL, description);
				takeScreenshot(tcid);
			} else {
				System.out.println("Image displayed.");
				extentTest.log(LogStatus.PASS, description);
			}
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + ImageFile + description);
			takeScreenshot(tcid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);

		}

	}

	// NOT USED ANYWHERE
	public static void TextFoundAndClickable(List<WebElement> Locator, String ExpectedText, String Description,
			String TCID) {
		boolean found = false;
		String strExpected = ExpectedText;
		while (!found) {
			int size = 0;
			size = size + Locator.size();
			for (int i = 0; i < size; i++) {
				String strActual = Locator.get(i).getText();
				if (strActual.equals(strExpected)) {
					System.out.print("Text: " + Locator.get(i).getText());
					click(Locator.get(i), Description, TCID);
					found = true;
					break;
				}
			}
			if (!found) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(350, 1000).moveTo(350, 980).release().perform();
			}
		}
	}

	public static void verifyText(WebElement locator, String expectedText, String description) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(locator));
			String ActualValue = locator.getText();
			String Actual = ActualValue;
			String expected = expectedText;
			System.out.println("Expected---------> " + expected);
			System.out.println("Actual-------> " + Actual);
			if (Actual.equals(expected)) {
				System.out.println(description + " Verified");
				extentTest.log(LogStatus.PASS, description);
			} else {
				takeScreenshot(description);
				System.out.println("Expected---------> " + expected);
				System.out.println("Actual-------> " + Actual);
				extentTest.log(LogStatus.FAIL, description);
				System.out.println("Fail to verify " + description);
			}
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			extentTest.log(LogStatus.FAIL,
					"<span style='font-weight:bold;'>Failure trace Selenium:" + e.toString() + "</span>");
			System.out.println(description + "not found to verify Text");
		}
	}

	public static String getText(WebElement locator, String description) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(locator));
			text = locator.getText();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			extentTest.log(LogStatus.FAIL,
					"<span style='font-weight:bold;'>Failure trace Selenium:" + e.toString() + "</span>");
			System.out.println(description + "element not found");
		}
		return text;
	}

	public static void AssertEquals(WebElement locator, String expectedText, String description) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(locator));
			String ActualValue = locator.getText();
			String Actual = ActualValue;
			String expected = expectedText;
			System.out.println("Expected---------> " + expected);
			System.out.println("Actual-------> " + Actual);
			assertEquals(Actual, expectedText);
			extentTest.log(LogStatus.PASS, description);
		} catch (AssertionError e) {
			System.out.println("Exception Occured " + e.getMessage());
			extentTest.log(LogStatus.FAIL,
					" <span style='font-weight:bold;'>Failure trace Selenium: " + e.toString() + "</span>");
			System.out.println(description + "not found to verify Text");
		}
	}

	public static void ScrollTill(WebElement Locator, String Description, String TCID) {
		boolean found = false;
		while (!found) {
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (Locator.isDisplayed()) {
					found = true;
					click(Locator, Description, TCID);
					break;
				}
			} catch (Exception e) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(350, 1000).moveTo(350, 900).release().perform();
			}
		}
	}

	// NOT USED ANYWHERE
	public static void ScrollToElement(WebElement Locator) {
		int count = 0;
		while (!Locator.isDisplayed()) {
			TouchActions action = new TouchActions(driver);
			action.scroll(10, 100);
			action.perform();
			count++;
			if (count == 10) {
				System.out.println("Element is not displayed");
				break;
			}
		}

	}

	// NOT USED ANYWHERE
	public static void ScrollFast_Till(WebElement Locator, String Description, String TCID) {
		boolean found = false;
		while (!found) {
			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (Locator.isDisplayed()) {
					found = true;
					click(Locator, Description, TCID);
					break;
				}
			} catch (Exception e) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(400, 900).moveTo(400, 200).release().perform();
			}
		}
	}

	public static boolean isElementFoundAndClickable(WebElement Locator, String Description, String TCID) {
		boolean found = false;
		while (!found) {
			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (Locator.isDisplayed()) {
					found = true;
					click(Locator, Description, TCID);
					break;
				}
			} catch (Exception e) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(350, 1000).moveTo(350, 975).release().perform();
			}
		}
		return found;
	}

	public static void ScrollToText(List<WebElement> Locator, String ExpectedText, String Description, String TCID) {
		boolean found = false;
		String strExpected = ExpectedText;
		while (!found) {
			int size = 0;
			size = size + Locator.size();
			for (int i = 0; i < size; i++) {
				String strActual = Locator.get(i).getText();
				if (strActual.equals(strExpected)) {
					System.out.println("Text: " + Locator.get(i).getText());
					click(Locator.get(i), Description, TCID);
					found = true;
					break;
				}
			}
			if (!found) {
				TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
				action.press(350, 1000).moveTo(350, 980).release().perform();
			}
		}
	}

	public static void scroll(WebElement from) {
		try {
			int x = from.getLocation().getX();
			int y = from.getLocation().getY();
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x, y).moveTo(x, y + 90).release().perform();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			System.out.println("---------SCROLL FAILED--------");
		}
	}

	public static void scrollUpToDown() {
		try {
			int x = 600;
			int y = 700;
			TouchAction action = new TouchAction(driver);
			action.press(x, y).moveTo(x, y - 120).release().perform();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			System.out.println("---------SCROLL FAILED--------");

		}
	}

	// NOT USED ANYWHERE
	public static void scrollDownToUp() {
		try {
			int x = 300;
			int y = 400;
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x, y).moveTo(x, y + 20).release().perform();
		} catch (Exception e) {
			System.out.println("---------SCROLL FAILED--------");

		}
	}

	// NOT USED ANYWHERE
	public static void scrollUpToDownMultiple(List<WebElement> from, int index, int index1, List<WebElement> to) {
		try {

			Point value = from.get(index).getLocation();
			int x = value.x;
			int y = value.y;
			Point value1 = to.get(index1).getLocation();
			int x1 = value1.x;
			int y1 = value1.y;
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x, y).moveTo(x1, y1).release().perform();
		} catch (Exception e) {
			System.out.println("---------SCROLL FAILED--------");
		}

	}

	public static void scrollUpToDown(WebElement from, int index1, int index, WebElement to) {
		try {

			Point value = from.getLocation();
			int x = value.x;
			int y = value.y;
			Point value1 = to.getLocation();
			int x1 = value1.x;
			int y1 = value1.y;
			driver.swipe(x1, y1, x, y, 1200);
		} catch (Exception e) {
			System.out.println("---------SCROLL FAILED--------");
		}
	}

	public static void waitForSometime(int time) {

		try {
			Thread.sleep(time);
			System.out.println("wait for" + time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured " + e.getMessage());
			Thread.currentThread().interrupt();

		}
	}

	public static void scroll_to_right(WebElement from) {
		try {
			int x = from.getLocation().getX();
			int y = from.getLocation().getY();
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x + 50, y).moveTo(x, y).release().perform();
		} catch (Exception e) {
			System.out.println("---------SCROLL FAILED--------");
		}
	}

	// NOT USED ANYWHERE
	public static void generateRandomNumber() {
		// create instance of Random class
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(10000);
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			return false;
		}
	}

	public static void scrollDown() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.60)).waitAction(1000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public static void scrollDownSlow() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.30)).waitAction(1000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public static void scrollDownCustom() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.70)).waitAction(1000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public static void scrollUp() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.30)).waitAction(1000)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.70)).release().perform();
	}

	public static void swipeLeft() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press((int) (size.getWidth() * 0.85), size.getHeight() / 2).waitAction(2000)
				.moveTo((int) (size.getWidth() * 0.15), size.getHeight() / 2).release().perform();
		action.press((int) (size.getWidth() * 0.85), size.getHeight() / 2).waitAction(1000)
				.moveTo((int) (size.getWidth() * 0.15), size.getHeight() / 2).release().perform();

	}

	public static void swipeRight() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press((int) (size.getWidth() * 0.15), size.getHeight() / 2).waitAction(1000)
				.moveTo((int) (size.getWidth() * 0.85), size.getHeight() / 2).release().perform();
	}

	public static void scrollDownToElement(WebElement element) {
		int count = 0;
		while (!isElementDisplayed(element)) {
			// scroll down
			scrollDown();
			count++;
			if (count == 13) {
				System.out.println("Element not found");
				break;
			}
		}
	}

	public static boolean scrollDownToElement_Return(WebElement element) {
		int count = 0;
		boolean foundElement = true;
		while (!isElementDisplayed(element)) {
			// scroll down
			scrollDown();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				foundElement = false;
				break;
			}

		}

		return foundElement;

	}

	public static void scrollDownToElement_recentlyviewed(WebElement element) {
		int count = 0;
		while (!isElementDisplayed(element)) {
			// scroll down
			scrollDownCustom();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				break;
			}
		}
	}

	public static void scrollDownToElement_search(WebElement element) {
		int count = 0;
		while (!isDisplayedAfterWait(element, 3)) {
			// scroll down
			scrollDownSlow();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				break;
			}
		}
	}

	public static boolean scrollDownToElement_By(By by) {
		boolean isfound = true;
		int count = 0;
		while (!isElementDisplayed(driver.findElement(by))) {
			// scroll down
			scrollDown();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				isfound = false;
				break;
			}

		}

		return isfound;
	}

	public static void scrollDownToElement_Duration(WebElement element, int sec) {
		int count = 0;
		while (!isElementDisplayed(element)) {
			// scroll down
			scrollDown_Duration(sec);
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				break;
			}
		}
	}

	public static void scrollDown_Duration(int timeDuration) {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		action.press(size.getWidth() / 2, (int) (size.getHeight() * 0.60)).waitAction(timeDuration)
				.moveTo(size.getWidth() / 2, (int) (size.getHeight() * 0.10)).release().perform();
	}

	public static void scrollUpToElement(WebElement element) throws InterruptedException {
		int count = 0;
		while (!isDisplayed(element)) {
			// scroll up
			scrollUp();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				break;
			}
		}
		BasePageActions.waitForPageToLoad();
	}

	public static void scrollFromOneElementToAnother(WebElement element1, WebElement element2) {
		TouchAction action = new TouchAction(driver);
		action.press(element1).waitAction(4000).moveTo(element2).release().perform();
	}

	public static void scrollFromOnePointToAnother(double startx, int starty, double endx, int endy) {
		TouchAction action = new TouchAction(driver);
		action.press((int) startx, starty).waitAction(4000).moveTo((int) endx, endy).release().perform();
	}

	public static void navigateToMatchesTab(WebElement element) {
		// extentTest.log(LogStatus.INFO, "Navigating to page '" + element.toString() +
		// "'");
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		int count = 0;
		while (!isElementDisplayed(element)) {
			action.press((int) (size.getWidth() * 0.85), (int) (size.getHeight() * 0.05)).waitAction(3000)
					.moveTo((int) (size.getWidth() * 0.15), (int) (size.getHeight() * 0.05)).release().perform();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				extentTest.log(LogStatus.ERROR, "Navigating to page '" + element.toString() + "' failed");
				break;
			}
		}
		// Click on the element once found
		element.click();
	}

	public static void navigateToSpecifiedMatchesTab(WebElement element, String description) {
		extentTest.log(LogStatus.INFO, description);
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		int count = 0;
		while (!isElementDisplayed(element)) {
			action.press((int) (size.getWidth() * 0.85), (int) (size.getHeight() * 0.05)).waitAction(3000)
					.moveTo((int) (size.getWidth() * 0.15), (int) (size.getHeight() * 0.05)).release().perform();
			count++;
			if (count == 10) {
				System.out.println("Element not found");
				extentTest.log(LogStatus.ERROR, description);
				break;
			}
		}
		// Click on the element once found
		element.click();
	}

	public static void waitForPageToLoad() throws InterruptedException {
		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
			int count = 0;
			while (BasePageActions.isElementDisplayed(BottomMenuPageObjects.ProgressBar) && count < 30) {
				// while
				// (BasePageActions.isElementDisplayed(driver.findElement(By.id("com.shaadi.android:id/progress_bar")))
				// && count < 30) {

				System.out.println("Waiting for page to load...");
				Thread.sleep(1000);
				count++;
			}
			if (count == 30) {
				System.out.println("Timeout while waiting for page to load...");
			}
		}

	}

	public static void clickOnPoint(int x, int y) {
		TouchAction action = new TouchAction(driver);
		action.press(x, y).release().perform();
	}

	public static void tapByCoordinate(int x, int y) {
		(new TouchAction(driver)).tap(x, y).perform();
	}

	// NOT USED ANYWHERE
	public static void iosScrollGeneric(String elementName) {
		RemoteWebElement parent = (RemoteWebElement) driver.findElement(By.className("XCUIElementTypeTable")

		); // identifying the parent Table

		String parentID = parent.getId();

		HashMap<String, String> scrollObject = new HashMap<String, String>();

		scrollObject.put("element", parentID);

		// Use the predicate that provides the value of the label attribute

		scrollObject.put("predicateString", "label == '" + elementName + "'");

		driver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
	}

	public static void scrollToTextIos(String text) throws InterruptedException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			HashMap<String, String> scrollObject = new HashMap<String, String>();

			Thread.sleep(3000);
			scrollObject.put("predicateString", "value == '" + text + "'");

			// scrollObject.put("direction", "down");
			Thread.sleep(6000);

			js.executeScript("mobile: scroll", scrollObject);

			Thread.sleep(4000);

		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	public static boolean chkMobileElement(String srchPath, String description, String tc, String action) {
		boolean setVisible = false;
		try {
			MobileElement eleName = (MobileElement) driver.findElementByXPath(srchPath);
			setVisible = true;
			if (action.equals("click")) {
				eleName.click();
			}

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		return setVisible;
	}

	// NOT USED ANYWHERE
	public void closeUnWantedPage() {
		if (isDisplayed(SearchObjects.btncloseLayer)) {
			SearchObjects.btncloseLayer.click();
		} else if (isDisplayed(SearchObjects.btnSkipInvitation)) {
			SearchObjects.btnSkipInvitation.click();
		}
	}

	public static void selectValueFromPickerWheel(String selectStr, boolean isclick) {
		// isclick added because some picker wheel values will require click event when
		// in frame
		WebDriver wd = driver;

		IOSElement picker = (IOSElement) new WebDriverWait(wd, 60)
				.until(ExpectedConditions.elementToBeClickable(By.className("XCUIElementTypePickerWheel")));

		picker.setValue(selectStr);

		if (isclick) {
			picker.click();
		}

		System.out.println(picker.getText());

	}

	public static String setMyUser(WebElement userValue) {

		String userType = null;

		boolean userExpiry;

		try {
			userExpiry = chckElementPresent(userValue);

			if (userExpiry == true) {
				userType = "Premium";

			} else {
				userType = "Free";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Occured " + e.getMessage());
		}

		return userType;
	}

	/*
	 * public static void closeRatingWindowAndroid() { Boolean isAppRatingVisible =
	 * false; isAppRatingVisible = isDisplayed(InboxObjects.AppRatingLayer); if
	 * (isAppRatingVisible) { ((AndroidDriver)
	 * driver).pressKeyCode(AndroidKeyCode.BACK); }
	 * 
	 * }
	 */

	public void hortizonalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.10);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		driver.swipe(startx, y, endx, y, 500);
	}

	public void scrollUsingTouchActionsByElements(MobileElement startElement, MobileElement endElement) {
		TouchAction actions = new TouchAction(driver);
		actions.press(startElement).waitAction(2000).moveTo(endElement).release().perform();
	}

	public void directionScroll(String direction) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", direction);
		js.executeScript("mobile: scroll", scrollObject);

	}

	public void switchContext(String contextName) {
		Set<String> contextnames = driver.getContextHandles();
		System.out.println(contextnames.size());
		for (String contextname : contextnames) {
			System.out.println(contextname);
			if (contextname.contains(contextname)) {
				driver.context(contextname);
			}
		}

	}

	public static boolean Select_Required_Value_From_PickerWheel(String ByClassName_ToFindChildrenInPicker,
			String ExpectedElementToSelect, int PickerWheelIndex) {
		// Initialize return variable
		boolean bln_ExpectedElementToSelect = false;

		try {
			// Get PickerWheel Item
			@SuppressWarnings("unchecked")
			List<MobileElement> wheels = driver.findElements(MobileBy.className("XCUIElementTypePickerWheel"));
			int WheelListSize = wheels.get(PickerWheelIndex)
					.findElements(By.className(ByClassName_ToFindChildrenInPicker)).size();

			for (int i = 0; i < WheelListSize; i++) {

				// Read the selected value
				String strPickerWheelSelectedValue = wheels.get(PickerWheelIndex).getText();
				if (strPickerWheelSelectedValue.contains(ExpectedElementToSelect)) {
					bln_ExpectedElementToSelect = true;
					break;
				}

				// Navigate to next item in the list
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<>();
				params.put("order", "next");
				params.put("offset", 0.15);
				params.put("element", ((RemoteWebElement) wheels.get(PickerWheelIndex)).getId());
				js.executeScript("mobile: selectPickerWheelValue", params);
			}
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

		// Return value
		return bln_ExpectedElementToSelect;
	}

	public Object[][] getDataFromJson(String pathToJson, String dataName, Object[][] returnValue) {

		try {
			File PP1_json = null;
			PP1_json = new File(pathToJson);
			JsonElement jsonData = new JsonParser().parse(new FileReader(PP1_json.getAbsolutePath()));
			JsonElement dataSet = jsonData.getAsJsonObject().get(dataName);
			List<PaymentRevampData> testData = new Gson().fromJson(dataSet, new TypeToken<List<PaymentRevampData>>() {
			}.getType());
			returnValue = new Object[testData.size()][1];
			int index = 0;
			for (Object[] each : returnValue) {
				each[0] = testData.get(index++);
			}
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return returnValue;

	}

	public boolean areElementsOverlapping(WebElement element1, WebElement element2) {
		Rectangle r1 = ((RemoteWebElement) element1).getRect();
		Point topRight1 = r1.getPoint().moveBy(r1.getWidth(), 0);
		Point bottomLeft1 = r1.getPoint().moveBy(0, r1.getHeight());

		Rectangle r2 = ((RemoteWebElement) element2).getRect();
		Point topRight2 = r2.getPoint().moveBy(r2.getWidth(), 0);
		Point bottomLeft2 = r2.getPoint().moveBy(0, r2.getHeight());

		if (topRight1.getY() > bottomLeft2.getY() || bottomLeft1.getY() < topRight2.getY()) {
			return false;
		}
		if (topRight1.getX() < bottomLeft2.getX() || bottomLeft1.getX() > topRight2.getX()) {
			return false;
		}
		return true;
	}

	public static int findProfileInInboxTab(String userName) throws InterruptedException {
		boolean profileFound = false;
		String actualUserName;
		WebElement findProfile = null;
		int setCell = 0;
		waitForSometime(90000);

		scrollUp();
		Thread.sleep(2000);
		scrollUp();

		@SuppressWarnings("unchecked")
		List<WebElement> profileName = driver
				.findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + userName + "']"));

		@SuppressWarnings("unchecked")
		List<WebElement> XCUIElementTypeCell = driver.findElements(By.className("XCUIElementTypeCell"));
		int noOfCells = XCUIElementTypeCell.size();
		for (int i = 1; i <= noOfCells; i++) {

			String profileBuilder = "labelDisplayName_" + i;

			findProfile = driver.findElement(By.id(profileBuilder));

			actualUserName = findProfile.getText();

			if (actualUserName.equalsIgnoreCase(userName)) {
				setCell = i;
				System.out.println("Cell Number found is " + setCell);
				profileFound = true;
				break;
			}

		}

		if (profileName.size() > 0) {

			System.out.println("Number of profile found " + profileName.size());

			profileFound = true;

		}
		if (profileFound == true) {
			scrollDownToElement(findProfile);
		}
		return setCell;
	}

}
