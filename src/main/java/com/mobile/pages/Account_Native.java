package com.mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.MobileElementActions;

public class Account_Native {
	private MobileDriver<MobileElement> mobile;

	private By login_account = MobileBy.id("com.jumia.android:id/button_top_login");
	private By email_subtitle_welcome = MobileBy.id("com.jumia.android:id/subtitle_welcome");

	public Account_Native(MobileDriver<MobileElement> mobile) {
		this.mobile = mobile;
	}

	public Login_Native clickOnLogin() {
		new MobileElementActions(mobile);
		MobileElementActions.click(mobile, login_account);
		return new Login_Native(mobile);
	}

	public String getAccountEmail() {
		return MobileElementActions.getText(mobile, email_subtitle_welcome);
	}
}
