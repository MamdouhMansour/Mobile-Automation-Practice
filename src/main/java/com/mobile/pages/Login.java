package com.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import utils.Helper;
import utils.MobileElementActions;

public class Login {

	private MobileDriver<MobileElement> mobile;

	private By create_new_account = MobileBy.id("com.jumia.android:id/login_email_create_account");
	private By email_field = MobileBy.AccessibilityId("email");
	private By password_field = MobileBy.AccessibilityId("password");
	private By login_button = MobileBy.id("com.jumia.android:id/login_button_continue");

	public Login(MobileDriver<MobileElement> mobile) {
		this.mobile = mobile;
	}

	public SignUp clickOnCreateNewAccount() {
		MobileElementActions.click(mobile, create_new_account);
		return new SignUp(mobile);
	}

	public Account loginUser(String email, String password) {
		Helper.getExplicitWait(mobile).until(ExpectedConditions.presenceOfElementLocated(email_field));

		MobileElementActions.type(mobile, password_field, password);
		MobileElementActions.type(mobile, email_field, email);
		MobileElementActions.click(mobile, login_button);
		return new Account(mobile);
	}
}
