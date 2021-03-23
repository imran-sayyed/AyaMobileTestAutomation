package android.shaadi;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import page.actions.LoginPage;
import shaadi.utils.AppProperties;
import shaadi.utils.AppStringConstants;
import shaadi.utils.DeviceSetup;
import shaadi.utils.ESClient;
import shaadi.utils.EmailUtils;
import shaadi.utils.ExcelDataUtils;
import shaadi.utils.UserProperty;

public class BaseTest_backup {

	public static ExtentTest extentTest;
	public static String baseDir;
	public static String ScreenshotDirName;
	@SuppressWarnings("rawtypes")
	protected static AppiumDriver driver;
	public static ExtentReports report = null;
	public static AppProperties properties;
	public static String AutomationRunName, AutomationReportMailUser, RunEnvironment, UserType, DeviceName, udid, Url,
			app, Pod, platformName, platformVersion, appiumVersion, appPackage, appActivity, path_to_chromedriver,
			machineOSName, reportFoldername;

	public static String deviceName = "";
	public static ProcessBuilder process_devicename, process_platformversion;
	public static Process prc_devicename, prc_platformversion;

	public static List<String> deviceData = new ArrayList<>();

	ESClient es = new ESClient();
	private SimpleDateFormat f = new SimpleDateFormat("ddMMyyhhmm");
	private String date = f.format(new Date()).toString();
	public static String reportName = null;
	public static boolean isLaunched = false;
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static int testCount = 0;

	@SuppressWarnings("rawtypes")
	@Parameters({ "RunEnvironment" })
	@BeforeSuite(alwaysRun = true)
	public static void setup(@Optional("") String runenv, ITestContext ctx) throws Exception {

		AppProperties.getInstance(); // Initialize properties File
		DeviceSetup.getMachineOSName();
		baseDir = "./Report_Zip/";
		System.out.println("base dir is " + baseDir);
		ScreenshotDirName = "./ScreenShot/";
		System.out.println("base screenshot is " + ScreenshotDirName);
		// System.out.println("Appium version" + DeviceSetup.getAppiumVersion_Unix());
		udid = AppProperties.getProperty(UserProperty.APP_IOS_UDID, null);
		appiumVersion = AppProperties.getProperty(UserProperty.appiumVersion, null);
		Url = AppProperties.getProperty(UserProperty.appiumUrl, null);
		AutomationRunName = UserProperty.automationName;
		AutomationReportMailUser = UserProperty.automationReport;

		// RunEnvironment = DeviceSetup.setTestExecutionPlatform();

		// If the RunEnvironment is present in XML suite then app.properties file is
		// been updated as per the environment in the suite
		if (runenv.equals("") || runenv == null) {
			RunEnvironment = DeviceSetup.setTestExecutionPlatform();
		} else {
			RunEnvironment = runenv;
			if (RunEnvironment.equalsIgnoreCase("androidlocal")) {
				AppProperties.setProperty(UserProperty.APP_BUILD_PATH, "shaadi.apk");
			} else {
				AppProperties.setProperty(UserProperty.APP_BUILD_PATH, "Shaadi.ipa");
			}
		}

		File path_to_apk = new File((AppProperties.getProperty(UserProperty.APP_BUILD_PATH, "")));

		app = path_to_apk.getAbsolutePath();
		testCount = DeviceSetup.getTestCount(ctx);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		try {

			switch (RunEnvironment) {

			case "iOSLocal": {
				DeviceSetup.setIOScapabilities();// sets all the parameters required for IOS capabilities
				DeviceSetup.validateiOSDevice();
				capabilities.setCapability("deviceName", DeviceName);
				capabilities.setCapability("app", app);
				capabilities.setCapability("udid", udid);
				capabilities.setCapability("automationName", "XCUITest");
				capabilities.setCapability("noReset", false);
				capabilities.setCapability("useNewWDA", true);
				capabilities.setCapability("newCommandTimeout", 0);
				capabilities.setCapability("fullReset", true);
				capabilities.setCapability("sendKeyStrategy", "setValue");
				capabilities.setCapability("clearSystemFiles", true);
				capabilities.setCapability("updatedWDABundleId", "com.shaadi.iphone");
				capabilities.setCapability("platformVersion", platformVersion);
				// capabilities.setCapability("bootstrapPath",
				// "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent");
				driver = new IOSDriver(new URL(Url), capabilities);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				isLaunched = true;
				break;
			}

			case "androidLocal": {
				System.out.println("Testing started");
				DeviceSetup.setAndroidcapabilities();// sets all the parameters required for IOS capabilities
				DeviceSetup.validateAndroidDevice();
				capabilities.setCapability("deviceName", DeviceName);
				capabilities.setCapability("platformVersion", platformVersion);
				capabilities.setCapability("newCommandTimeout", 400);
				// capabilities.setCapability("platformName", platformName);
				capabilities.setCapability("appium-version", appiumVersion);
				capabilities.setCapability("noReset", false);
				capabilities.setCapability("fullReset", true);
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("app", app);
				capabilities.setCapability("appPackage", AppStringConstants.ANDROIDAPPPACKAGE);
				capabilities.setCapability("appActivity", AppStringConstants.ANDROIDAPPACTIVITY);
				capabilities.setCapability("forceMjsonwp", true);
				capabilities.setCapability("automationName", AutomationRunName);
				capabilities.setCapability("autowebview", true);
				capabilities.setCapability("chromedriverExecutable", path_to_chromedriver);
				capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
				driver = new AndroidDriver(new URL(Url), capabilities);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				isLaunched = true;
				// Thread.sleep(15000);
				break;
			}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@AfterSuite(alwaysRun = true)
	public static void tearDown(ITestContext ctx) throws Exception {
		try {
			driver.quit();
			driver = null;

			// EmailUtils.sendEmail(reportFoldername, ctx);

		} catch (Exception ex) {

			System.out.println("Some issues while quitting the driver");

		} finally {
			EmailUtils.sendEmail(reportFoldername, ctx);

		}
	}

	@AfterTest(alwaysRun = true)
	public static void tearDown() throws Exception {
		try {

			driver.closeApp();
			if (testCount > 1) {
				driver.resetApp();
				testCount--;
			}

		} catch (Exception ex) {
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void nameBefore(ITestContext ctx, Method method) {

		String testScenario = method.getAnnotation(org.testng.annotations.Test.class).description();
		testScenario = (testScenario == "") ? "scenario not mentioned" : testScenario;

		String testXMLFileName = ctx.getCurrentXmlTest().getSuite().getFileName();
		String methodName = method.getName();
		String testDesription = "(method name = " + methodName + ")" + testXMLFileName;

//		report.loadConfig(new File("D:\\Backup_mobile\\MobileAutomation\\extent-config.xml"));
		report.loadConfig(new File("./extent-config.xml"));
		extentTest = report.startTest(testScenario, testDesription);
		System.out.println("we are in " + method.getName());
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(Method method, ITestResult result) throws ClientProtocolException, IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// GoogleBotAlert.sendData(Pod, result);
			extentTest.log(LogStatus.FAIL, "Test Case Failed: " + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed reason: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed: " + result.getName());
		}
		report.endTest(extentTest);
		report.flush();

		String testScenario = method.getAnnotation(org.testng.annotations.Test.class).description();
		testScenario = (testScenario == "") ? "scenario not mentioned" : testScenario;

//		if (RunEnvironment.equalsIgnoreCase("androidLocal")) {
//			es.insertData(driver, result, DeviceName, platformVersion, platformName, appiumVersion, udid, testScenario,
//					Pod);
//		}
	}

	@Parameters({ "userType", "pod" })
	@BeforeTest(alwaysRun = true)
	public void driverSetup(@Optional("") String userType, @Optional("") String pod, @Optional ITestContext ctx)
			throws JsonIOException, JsonSyntaxException, InterruptedException, InvalidFormatException, IOException {
		String userStatus;
		if (!isLaunched) {
			// this is used in order to check if the application launches even after the
			// test suit execution is finished
			driver.launchApp();
			isLaunched = false;
		}

		if (userType == null || userType.equals("")) {
			System.out.println(this.getClass().getSimpleName());
			List<String> data = new ArrayList<>();
			List<String> data_credInfo = new ArrayList<>();
			// this will return the usertype to be used in test class
			// Also this is useful when user is executing single test class
			data = ExcelDataUtils.getUserType(this.getClass().getSimpleName());
			userType = data.get(0);
			pod = data.get(1);
			// Added this line so that code can create report according to free or premium
			// user when test single test class is executed
			data_credInfo = ExcelDataUtils.getUserData(userType);
			userStatus = data_credInfo.get(2);
			reportName = ctx.getAllTestMethods()[0].getInstance().getClass().getSimpleName() + "_" + userStatus
					+ "_Report" + ".html";

		} else {

			// Report name generated when test class is executed through testng xml suit
			reportName = ctx.getName() + "_Report" + ".html";
		}

		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();

		System.out.println(reportName);
		if (pod.equalsIgnoreCase("Acquisition")) {
//			report = new ExtentReports("./Report/A1/" + reportName);
//			reportFoldername = "A1";
			if (suiteName.contains("Default")) {
				suiteName = ExcelDataUtils.getSuitName(pod);
			}

			report = new ExtentReports("./Report/A1/" + suiteName + "/" + reportName);

			// For A2 module : Different folders are created xml wise for report storage
			reportFoldername = "A1/" + suiteName;

		} else if (pod.equalsIgnoreCase("matchmaking")) {
			if (suiteName.contains("Default")) {
				suiteName = ExcelDataUtils.getSuitName(pod);
			}

			report = new ExtentReports("./Report/A2/" + suiteName + "/" + reportName);

			// For A2 module : Different folders are created xml wise for report storage
			reportFoldername = "A2/" + suiteName;

		} else {

			report = new ExtentReports("./Report/A3/" + reportName);
			reportFoldername = "A3";

		}
		report.addSystemInfo("Test Suite", ctx.getCurrentXmlTest().getSuite().getName());

		// Because acquisition module does not require login feature
		if (pod.equalsIgnoreCase("matchmaking") || pod.equalsIgnoreCase("payment")) {
			extentTest = report.startTest("Login as user", "Login as valid user");

			LoginPage login = new LoginPage();

	 login.quickLogin(userType);
		}

		Pod = pod;
		UserType = userType;

	}

}
