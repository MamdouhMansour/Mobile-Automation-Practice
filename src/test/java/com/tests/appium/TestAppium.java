package com.tests.appium;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobile.pages.Account;
import com.mobile.pages.CountryScreen;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.MobileActions;
import utils.MobileActions.MobileDriverType;

public class TestAppium {
	private MobileDriver<MobileElement> mobile;

	private String englishLanguage = "English";
	private String email = "test15QA@tes.com";
	private String password = "Aa12345#";
	private int countryIndex = 2;

	@Test
	public void checkSuccessfulRegistration() {
		new CountryScreen(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
				.clickOnAccount().clickOnLogin().clickOnCreateNewAccount()
				.fillRegistrationForm("Test1", "Test1", email, password);

		Assert.assertEquals(new Account(mobile).getAccountEmail(), email);
	}

	@Test(dependsOnMethods = { "checkSuccessfulRegistration" })
	public void checkSuccessfulLogin() {
		new CountryScreen(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
				.clickOnAccount().clickOnLogin().loginUser(email, password);

		Assert.assertEquals(new Account(mobile).getAccountEmail(), email);
	}

	/**
	 * link of how to find app activity & app package:
	 * http://www.automationtestinghub.com/apppackage-and-appactivity-name/
	 * 
	 * 
	 * @throws MalformedURLException
	 */
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		MobileActions.SetCapabilities("emulator-5554", "Nexus_5Android_10", "10", "Android", "com.jumia.android",
				"com.mobile.view.SplashScreenActivity", "D:\\Tutorials\\Appium tutorials\\jumia-7-5-1.apk");
		mobile = MobileActions.InitiateMobileDriver(mobile, MobileDriverType.ANDROID);
	}

	@AfterMethod
	public void afterMethod() {
		mobile.closeApp();
	}
}
