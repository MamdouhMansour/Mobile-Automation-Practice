package com.mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.MobileElementActions;

public class CountryScreen {
	private MobileDriver<MobileElement> mobile;

	private String profileIconExperssion = "(//*[@index='%d'])";
	private String languageSelection = "//*[contains(@text, '%s')]//parent::*";

	public CountryScreen(MobileDriver<MobileElement> mobile) {
		this.mobile = mobile;
	}

	public CountryScreen clickOnCountry(int index) {
		MobileElementActions.click(mobile, By.xpath(String.format(profileIconExperssion, index)));
		return this;
	}

	public Home clickOnLanguage(String language) {
		MobileElementActions.click(mobile, By.xpath(String.format(languageSelection, language)));
		return new Home(mobile);
	}
}
