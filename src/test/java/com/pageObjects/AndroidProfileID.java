package com.pageObjects;

import org.apache.http.conn.ConnectTimeoutException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import com.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidProfileID extends BasePage  {
	public Actions action;
	public WebDriverWait wait;
	
//public WebDriver ldriver;
	
	//Constructor
	/*public ForgotPassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/
	
		public AndroidProfileID(AppiumDriver driver)
		{
			super(driver);
		}

	/*public AndroidLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/

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
		
		@AndroidFindBy(xpath = "//*[@text='Govt. Issued Photo ID']")
		public WebElement govtphotoclicktext;

		@AndroidFindBy(className = "android.widget.ListView/android.widget.LinearLayout")
		public List<WebElement> govtphotoclickbDropdown;
		// android.widget.TextView[@text='Select Govt. Issued photo ID']

		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Health Card']")
		public WebElement healthcardoption;

		@AndroidFindBy(id = "com.jombone.jombone:id/govtId")
		public WebElement govtIdclickTextbox;

		@AndroidFindBy(id = "com.jombone.jombone:id/govtIdLL")
		public List<WebElement> govtIdclickDropdown;
		
		@AndroidFindBy(xpath = "//*[@text='Govt. Issued Photo ID']")
		public WebElement govtIssueIdtextdisplay;
		
		@AndroidFindBy(id = "(com.jombone.jombone:id/govtPhotoId")
		public WebElement govtphotoTxt;
		
		@AndroidFindBy(id = "com.jombone.jombone:id/govtId")
		public WebElement govtIssueIDTxt;
		
		@AndroidFindBy(id = "com.jombone.jombone:id/exit_cross_image")
		public WebElement exitpage;
		
		@AndroidFindBy(id = "com.jombone.jombone:id/toolbar_title")
		public WebElement pageTitle;
		
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='ID Detail']")
		public WebElement pageTitle2;
		


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
		

		@SuppressWarnings({ "unchecked" })
		public void profileID() throws InterruptedException, TimeoutException {
			// wait = new WebDriverWait(driver, 10);
			// wait.until(ExpectedConditions.visibilityOf(idDetailsplusIcon));
			((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"ID Details\"));");

			idDetailsplusIcon.click();
			System.out.println("Id plus icon is clicked");
			//Thread.sleep(3000);
			/*System.out.println("Govt Issue photo id Dropdown is Displayed: "+govtphotoclicktext.isDisplayed());
			System.out.println("Govt Issue photo id Dropdown is Displayed: "+govtphotoclicktext.getText());
			
			System.out.println("Govt Issue photo id Dropdown is Displayed: "+govtIssueIdtextdisplay.isDisplayed());
			System.out.println("Govt Issue photo id Dropdown is Displayed: "+govtIssueIdtextdisplay.getText());*/


			
		}


}