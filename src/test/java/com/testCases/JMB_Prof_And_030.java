package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.AndroidContactDetails;
import com.pageObjects.AndroidLogin;
import com.utilities.MyScreenRecorder;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class JMB_Prof_And_030 extends BaseClass {

	@Test(priority=1)
	//Valid contact Number
	public void validContactnum() throws Exception {
		//AndroidDriver<AndroidElement> driver = setup();
		//service=startServer();
		MyScreenRecorder.startRecording("validContactnum");

		AndroidLogin log = new AndroidLogin(driver);
		log.loginbutton();
		log.setlogincredentials(username1, password);
		log.popupAllow();
		log.clickprofileIcon();
		AndroidContactDetails cont=new AndroidContactDetails(driver);

		//log.contactDetails();
		cont.validcontactNum();
		
		SoftAssert softAssert=new SoftAssert();
		if(cont.phonetext.isDisplayed()) {//Valid phone number is displayed in Profile page
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, contact detail phone number is displayed in Home Page");
		}
		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver,"validContactnum");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();

		//driver.navigate().back();
		log.backbutton.click();
		//service.stop();
		MyScreenRecorder.stopRecording();

	}
}
