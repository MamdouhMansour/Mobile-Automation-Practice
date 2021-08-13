package com.tests.appium;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobile.pages.Account_Native;
import com.mobile.pages.CountryScreen_Native;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.MobileActions;
import utils.MobileActions.MobileDriverType;

public class TestAppiumNative {
	private MobileDriver<MobileElement> mobile;

	private String englishLanguage = "English";
	private String email = "testA7QA@tes.com";
	private String password = "Aa12345#";
	private int countryIndex = 2;
	private String emaulatorUDID = "emulator-5554";

	@Test
	public void checkSuccessRegistration() {
		new CountryScreen_Native(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
				.clickOnAccount().clickOnLogin().clickOnCreateNewAccount()
				.fillRegistrationForm("Test1", "Test1", email, password);

		Assert.assertEquals(new Account_Native(mobile).getAccountEmail(), email);
	}

	@Test(dependsOnMethods = { "checkSuccessfulRegistration" })
	public void checkSuccessfulLogin() {
		new CountryScreen_Native(mobile)
		.clickOnCountry(countryIndex)
		.clickOnLanguage(englishLanguage)
		.dismissAlert()
		.clickOnAccount()
		.clickOnLogin()
		.loginUser(email, password);

		Assert.assertEquals(new Account_Native(mobile).getAccountEmail(), email);
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		mobile = MobileActions.InitiateMobileDriver(mobile, MobileDriverType.ANDROID);
		MobileActions.SetCapabilities(emaulatorUDID, "Test Mobile", "8.1", "Android", "com.jumia.android",
				"com.mobile.view.SplashScreenActivity", "src/test/resources/jumia-7-5-1.apk");
	}

	@AfterMethod
	public void afterMethod() {
		mobile.quit();
	}
}
