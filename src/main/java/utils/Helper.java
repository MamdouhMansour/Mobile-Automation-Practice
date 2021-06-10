package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Helper {

	private static final int TIMEOUT = Integer
			.parseInt(PropertiesReader.getPropertyValue("MobileProperties.properties", "MobileDriver.Wait"));

	public static WebDriverWait getExplicitWait(MobileDriver<MobileElement> mobile) {
		return new WebDriverWait(mobile, TIMEOUT);
	}

	public static void implicitWait(MobileDriver<MobileElement> mobile) {
		mobile.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
}
