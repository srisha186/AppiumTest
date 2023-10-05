package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;
import java.util.concurrent.TimeoutException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.base.BasePage;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidLogin extends BasePage {
	@SuppressWarnings("rawtypes")
	public TouchAction t;
	public WebDriverWait wait;

//public WebDriver ldriver;

	// Constructor
	/*
	 * public ForgotPassword(WebDriver driver) { super(driver); // TODO
	 * Auto-generated constructor stub }
	 */

	@SuppressWarnings("rawtypes")
	public AndroidLogin(AppiumDriver driver) {
		super(driver);
	}

	/*
	 * public AndroidLogin(WebDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */

	@AndroidFindBy(id = "com.jombone.jombone:id/tvLoginSignUp")
	public WebElement clickLogin;

	@AndroidFindBy(id = "com.jombone.jombone:id/edLoginEmail")
	public WebElement userName;

	@AndroidFindBy(id = "com.jombone.jombone:id/edLoginPassword")
	public WebElement password;

	@AndroidFindBy(id = "com.jombone.jombone:id/email_sign_in_button")
	public WebElement submitLoginBtn;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement popupAllowBtn;
	// com.android.packageinstaller:id/permission_allow_button
	// "//android.widget.Button[@Text='ALLOW']"

	@AndroidFindBy(id = "com.jombone.jombone:id/profile_image")
	public WebElement profileimg;

	@AndroidFindBy(id = "com.jombone.jombone:id/edit_contact_icon_layout")
	public WebElement contactIcon;

	@AndroidFindBy(id = "com.jombone.jombone:id/homePhoneEdit")
	public WebElement homePhoneEdit;

	@AndroidFindBy(id = "com.jombone.jombone:id/emergencyContactEdit")
	public WebElement emergencyContactName;

	@AndroidFindBy(id = "com.jombone.jombone:id/enerygencyNumberEdit")
	public WebElement emergencyContactNumber;

	@AndroidFindBy(id = "com.jombone.jombone:id/btnSaveChanges")
	public WebElement savechanges;

	@AndroidFindBy(id = "com.jombone.jombone:id/home_phone_value")
	public WebElement phonetext;

	@AndroidFindBy(id = "com.jombone.jombone:id/edit_id_icon_layout")
	public WebElement idDetailsplusIcon;

	// @AndroidFindBy(xpath =
	// "com.jombone.jombone:id/govtPhotoIdLL/child::android.widget.TextView[@text='Select
	// Govt. Issued photo ID']")
	// public WebElement govtphotoclickbtn;
	// String xpath =
	// “//android.widget.ListView/descendant::android.widget.LinearLayout

	// @AndroidFindBy(id = "com.jombone.jombone:id/govtPhotoIdLL']")
	// public WebElement govtphotoclickbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Citizenship Card']")
	public WebElement dropdowncitizen;

	// @AndroidFindBy(xpath = "//android.widget.TextView")
	// public List<WebElement> govtphotoclickbtn;

	// @AndroidFindBy(xpath =
	// "//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='0']")
	// public WebElement govtphotoclickbtn;

	// @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[1]")
	// public WebElement govtphotoclickbtn;

	// id = "com.jombone.jombone:id/govtPhotoId"

	@AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
	public WebElement govtphotoclickbtn;

	// @AndroidFindBy(className = "android.widget.RelativeLayout")
	// public List<WebElement> govtphotoclickbtn;

	// @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
	// public WebElement govtphotoclickbtn;

	@AndroidFindBy(className = "android.widget.ListView/android.widget.LinearLayout")
	public List<WebElement> govtphotoclickbDropdown;
	// android.widget.TextView[@text='Select Govt. Issued photo ID']

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Health Card']")
	public WebElement healthcardoption;

	@AndroidFindBy(id = "com.jombone.jombone:id/govtId")
	public WebElement govtIdclickTextbox;

	@AndroidFindBy(id = "com.jombone.jombone:id/govtIdLL")
	public List<WebElement> govtIdclickDropdown;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backbutton;
	
	
	/*
	 * @AndroidFindBy(id = "com.jombone.jombone:id/btnSaveChanges") public
	 * WebElement savechanges;
	 * 
	 * @AndroidFindBy(id = "com.jombone.jombone:id/btnSaveChanges") public
	 * WebElement savechanges;
	 * 
	 * @AndroidFindBy(id = "(com.jombone.jombone:id/btnSaveChanges)[3]") public
	 * WebElement savechanges;
	 */

// ==================Action methods===========================//
	// Validate Logout functionality by sign off.

	@SuppressWarnings("rawtypes")
	public void loginbutton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(clickLogin));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(clickLogin))).perform();

		System.out.println("success");

	}

	public void setlogincredentials(String email, String pwd) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(email);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pwd);
		// driver.hideKeyboard();
		submitLoginBtn.click();

	}

	@SuppressWarnings("rawtypes")
	public void popupAllow() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(popupAllowBtn));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(popupAllowBtn))).perform();

		// popupAllowBtn.click();
	}

	public void clickprofileIcon() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(profileimg));
		profileimg.click();
	}

	@SuppressWarnings("unchecked")
	public void contactDetails() {
		// wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(contactIcon));
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"element\"));");
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();

		homePhoneEdit.clear();
		homePhoneEdit.sendKeys("3653246385");
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactName));
		emergencyContactName.clear();
		emergencyContactName.sendKeys("Karthi");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNumber));
		emergencyContactNumber.clear();
		emergencyContactNumber.sendKeys("3653246385");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();

	}

	@SuppressWarnings("unchecked")
	public void validcontactNum() throws InterruptedException {
		// wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(contactIcon));
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"element\"));");
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();
		homePhoneEdit.clear();
		homePhoneEdit.sendKeys("3653246385");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
		// driver.navigate().forward();
		// Thread.sleep(3000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(phonetext));
		System.out.println(driver.switchTo().activeElement().getText());
		// ((FindsByAndroidUIAutomator<MobileElement>)
		// driver).findElementByAndroidUIAutomator(
		// "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Home Phone
		// Number\"));");
		System.out.println("the value is displayed in homepage is : " + phonetext.getText());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void profileID() throws InterruptedException, TimeoutException {
		// wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOf(idDetailsplusIcon));
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"ID Details\"));");

		idDetailsplusIcon.click();
		Thread.sleep(2000);
		// govtphotoclickbtn.get(0).click();
		// govtphotoclickbtn.click();

		// driver.findElement(MobileBy.AndroidUIAutomator(
		// "new UiScrollable(new
		// UiSelector().resourceId(\"com.jombone.jombone:id/content_frame\")).scrollIntoView(new
		// UiSelector().textMatches(\"Govt. Issued Photo ID\").instance(0))"));
		govtphotoclickbtn.click();
	//	TouchAction t = new TouchAction(driver);
	//	t.tap(tapOptions().withElement(element(govtphotoclickbtn.get(1)))).perform();
		System.out.println("clicked");
		Thread.sleep(2000);
		//driver.findElement(MobileBy.
		  //AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"+Health Card+\").instance(0))"));
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Health Card\"));");

		System.out.println(govtphotoclickbDropdown.size());
		for (int i = 1; i < govtphotoclickbDropdown.size(); i++) {
			String value = govtphotoclickbDropdown.get(i).getText();
			if (value.equalsIgnoreCase("Health Card")) {
				govtphotoclickbDropdown.get(i).click();
				Thread.sleep(2000);

			} else {
				System.out.println("error");
			}
			System.out.println("The value clicked is: " + govtphotoclickbDropdown.get(i).getText());

		}
		/*
		 * t.longPress(longPressOptions().withElement(element(govtphotoclickbtn)).
		 * withDuration(ofSeconds(3))).release() .perform(); Thread.sleep(2000); /*
		 * String text = "your_text"; driver.findElement(MobileBy
		 * .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" +
		 * "new UiSelector().text(\""+text+"\"));"))
		 * 
		 * //System.out.println(dropdowncitizen.isDisplayed()); //
		 * govtphotoclickbtn.click(); System.out.println("dropdown success"); // wait =
		 * new WebDriverWait(driver, 10); //
		 * wait.until(ExpectedConditions.elementToBeClickable(govtphotoclickbtn)); // t
		 * = new TouchAction(driver); //
		 * t.tap(tapOptions().withElement(element(govtphotoclickbtn))).perform(); /* try
		 * { //driver.switchTo().frame(govtphotoclickbtn);
		 * //govtphotoclickbtn.get(1).click(); govtphotoclickbtn.click();
		 * System.out.println("clicked"); }catch(Exception e) {
		 * System.out.println("error"); } //govtphotoclickbtn.get(2).click();
		 * 
		 * 
		 * Thread.sleep(3000); //System.out.println(govtphotoclickbDropdown.size());
		 * System.out.println(healthcardoption.getText()); healthcardoption.click();
		 * 
		 * //if(govtphotoclickbDropdown.equals(healthcardoption)) {
		 * 
		 * //} //driver.findElement(MobileBy.
		 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches("" + Health Card + "
		 * \").instance(0))"));
		 * 
		 * // driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		 * //((FindsByAndroidUIAutomator<MobileElement>) driver).
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Health Card\"));"
		 * );
		 * 
		 * /* System.out.println(govtphotoclickbDropdown.size()); for (int i = 0; i
		 * <govtphotoclickbDropdown.size(); i++) { String value =
		 * govtphotoclickbDropdown.get(i).getText();
		 * if(value.equalsIgnoreCase("Health Card")) {
		 * govtphotoclickbDropdown.get(i).click();
		 * System.out.println("The value clicked is: " +
		 * govtphotoclickbDropdown.get(i)); } else { System.out.println("error"); } }
		 */

	}

}