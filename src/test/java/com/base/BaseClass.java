package com.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.utilities.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig(); // Creating object
	// Integrating data from ReadConfig
	public String username1 = readconfig.getUsername1();
	public String password = readconfig.getPassword();
	public String device = readconfig.getDevice();

	public static Logger logger;
	public static AndroidDriver<AndroidElement> driver;

	public static AppiumDriverLocalService service;
	
	
/*	public static AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}*/

	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\startEmulator.bat");
		Thread.sleep(9000);
	}
	public void startServer() {
		//path to server: C:\Users\karth\AppData\Roaming\npm\node_modules\appium\build\lib\main.js
		 service = new AppiumServiceBuilder().withAppiumJS(new File("c:\\Users\\karth\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();

	}
	
	@BeforeSuite
	// @BeforeClass

	public AndroidDriver<AndroidElement> setup() throws Exception {
		// AppiumSeverUtilities.startAppiumServer();
		// Initialization // Logger initiated within the setup method
		startServer();
		Thread.sleep(1000);
		startEmulator();
		logger = Logger.getLogger("Mobile_Freshii");// Project Name
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		/*
		 * System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		 * driver = new ChromeDriver(); driver.get(baseURL);
		 * driver.manage().window().maximize();
		 */
		File f = new File("src");
		File fs = new File(f, "app-release-87.apk");
		DesiredCapabilities dc = new DesiredCapabilities();
		/*
		 * if(device.contains("NexusS")) { startEmulator(); }
		 */
		dc.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, device);

		dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	@AfterSuite
	// @AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
		service.stop();
	}

	public void captureScreen(AndroidDriver<AndroidElement> driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the
																			// specified values passed
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values
																		// passed
		return (generatedString2);
	}

}