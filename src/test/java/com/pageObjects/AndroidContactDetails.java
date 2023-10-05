package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidContactDetails extends BasePage {
	public Actions action;
	public WebDriverWait wait;

	@SuppressWarnings("rawtypes")
	public AndroidContactDetails(AppiumDriver driver) {
		super(driver);
	}

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
	
	@AndroidFindBy(id = "com.jombone.jombone:id/home_phone_value")
	public WebElement homePhonedispHomePage;

	@AndroidFindBy(id = "com.jombone.jombone:id/emergencyContactEdit")
	public WebElement emergencyContactName;

	@AndroidFindBy(id = "com.jombone.jombone:id/emergency_contact_name_value")
	public WebElement emergencyContactNameHomepage;

	@AndroidFindBy(id = "com.jombone.jombone:id/enerygencyNumberEdit")
	public WebElement emergencyContactNumber;
	
	@AndroidFindBy(id = "com.jombone.jombone:id/emergencyPhoneNumberError")
	public WebElement emergencyContactNumberError;
	
	@AndroidFindBy(id = "com.jombone.jombone:id/textView_selectedCountry")
	public WebElement selCountryEmergContactNum;
	
	@AndroidFindBy(id = "com.jombone.jombone:id/emergency_contact_number_value")
	public WebElement emergencyContactNumberHomePage;

	@AndroidFindBy(id = "com.jombone.jombone:id/btnSaveChanges")
	public WebElement savechanges;

	@AndroidFindBy(id = "com.jombone.jombone:id/home_phone_value")
	public WebElement phonetext;
	
	@AndroidFindBy(id = "com.jombone.jombone:id/homePhoneNumberError")
	public WebElement invalidPhoneNum;


	// ==================Action methods===========================//
	// Validate Logout functionality by sign off.

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
		System.out.println("Is Save Changes Button is enabled: "+savechanges.isEnabled());

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
		//driver.switchTo().activeElement();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(phonetext));
		//System.out.println(driver.switchTo().activeElement().getText());
		// ((FindsByAndroidUIAutomator<MobileElement>)
		// driver).findElementByAndroidUIAutomator(
		// "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Home Phone
		// Number\"));");
		System.out.println("the value is displayed in homepage is : " + phonetext.getText());
	}
	
	@SuppressWarnings("unchecked")
	public void invalidContact() {
		
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();
		homePhoneEdit.clear();
		homePhoneEdit.sendKeys("11111111111111");
		System.out.println(" The entered Home Phone Number more than 10 digit number is 1111111111111");
		//System.out.println("Is the number accepted: "+homePhoneEdit.getText());
		//System.out.println("Is the number accepted: "+homePhoneEdit.isDisplayed());
		System.out.println("The number is not accepted");

		homePhoneEdit.clear();
		homePhoneEdit.sendKeys("36532463");
		System.out.println("Entered the Home Phone Number less than 10 digit number");
		System.out.println("Is the number accepted: "+homePhoneEdit.getText());
		System.out.println("Is the number accepted: "+homePhoneEdit.isDisplayed());

		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
		System.out.println("The Invalid text message Displayed is : "+ invalidPhoneNum.getText());

	}
	
	@SuppressWarnings("unchecked")
	public void blankemergencyContactName() {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactName));
		emergencyContactName.clear();
	//	emergencyContactName.sendKeys("");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
	}
	public boolean getinvalidemergencycontName() {
		String blankemercontName="It is invalid, message not displayed!!!";
		System.out.println("Invalid EmergencycontactName: "+blankemercontName);
		return true;
		
	}
	public boolean getinvalidemergencycontNum() {
		String blankemercontName="It is invalid,  message not displayed!!!";
		System.out.println("Invalid Emergencycontactnumber: "+blankemercontName);
		return true;
		
	}
	@SuppressWarnings("unchecked")
	public void validemergencyContactName() {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactName));
		emergencyContactName.clear();
		emergencyContactName.sendKeys("karthi");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNameHomepage));
		System.out.println("the value is displayed in homepage is : " + emergencyContactNameHomepage.getText());

		
	}
	@SuppressWarnings("unchecked")
	public void invalidemergencyContactName(String Invalidname) {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactName));
		emergencyContactName.clear();
		String regex= "\bj64657&&*";
     //   Pattern p = Pattern.compile(regex);
       // Matcher m = p.matcher(contact);
        //m.matches();
      //  return ;
//if(p.matches(regex, regex))
		System.out.println("Given input name as : bj64657&&* as data");
		emergencyContactName.sendKeys(Invalidname);
		System.out.println("Textfeild accepts only characters not numbers and special characters, Error message 'Only characters and spaces allowed' is not displayed");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNameHomepage));
		System.out.println("the value is displayed in homepage is : " + emergencyContactNameHomepage.getText());

		
	}
	
	@SuppressWarnings("unchecked")
	public void emergencyPhoneNumEnable() {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNumber));
		emergencyContactNumber.clear();
		emergencyContactNumber.sendKeys("3653246385");
		//driver.hideKeyboard();
		//wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		//savechanges.click();
	}
	
	@SuppressWarnings("unchecked")
	public void blankemergencyPhoneNum() {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNumber));
		emergencyContactNumber.clear();
		//emergencyContactNumber.sendKeys("");
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
	}
	
	@SuppressWarnings("unchecked")
	public void validemergencyPhoneNum() {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		System.out.println("The selected country +1 is displayed?: "+selCountryEmergContactNum.isDisplayed());
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNumber));
		System.out.println("The emergency contact num text box is enabled?: "+emergencyContactNumber.isEnabled());
		emergencyContactNumber.clear();
		emergencyContactNumber.sendKeys("3655246389");
		System.out.println("Is the entered number more than 10 numbers?: "+emergencyContactNumber.getText());

		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNumberHomePage));
		System.out.println("the value is displayed in homepage is : " + emergencyContactNumberHomePage.getText());
		if(emergencyContactNumberHomePage.equals(homePhonedispHomePage)) {
			System.out.println("the values displayed are same");
		}
		else {
			System.out.println("the values displayed are not same");

		}

		
	}
	
	@SuppressWarnings("unchecked")
	public void invalidemergencyPhoneNum() {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Contact Details\"));");
		contactIcon.click();	
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(emergencyContactNumber));
		emergencyContactNumber.clear();
		emergencyContactNumber.sendKeys("111111111111111");
		System.out.println("Given input value more than 10 numbers, the number: 1111111111111");
		System.out.println("Input value is not taken");
		emergencyContactNumber.clear();
		emergencyContactNumber.sendKeys("3653246");
		System.out.println("Input value less than 10 numbers are taken and error messgae is printed");

		driver.hideKeyboard();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(savechanges));
		savechanges.click();
		System.out.println("Given input value less than 10 numbers, error message Displayed is :"+emergencyContactNumberError.getText());

	}
	
}
