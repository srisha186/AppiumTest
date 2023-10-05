package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	@SuppressWarnings("rawtypes")
	protected AppiumDriver driver;

	@SuppressWarnings("rawtypes")
	public BasePage(AppiumDriver driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		
	}

}
