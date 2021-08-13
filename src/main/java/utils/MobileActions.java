package utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileActions {
	static DesiredCapabilities cap = new DesiredCapabilities();
	static MobileDriver<MobileElement> mobile;

	public enum MobileDriverType {
		ANDROID, IOS
	}

	public enum AlertActionType {
		ACCEPT, DISMISS;
	}

	public static void AlertAction(MobileDriver<MobileElement> mobile, AlertActionType alertActionType) {
		Alert alert = mobile.switchTo().alert();

		switch (alertActionType) {
		case ACCEPT:
			alert.accept();
			break;
		case DISMISS:
			alert.dismiss();
			break;
		}
	}

	public static void SetCapabilities(String UDID, String DEVICE_NAME, String PLATFORM_VERSION, String PLATFORM_NAME,
			String APP_PACKAGE, String APP_ACTIVITY, String File_PATH) throws MalformedURLException {

		cap.setCapability(MobileCapabilityType.UDID, UDID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		cap.setCapability("appPackage", APP_PACKAGE);
		cap.setCapability("appActivity", APP_ACTIVITY);

		File file = new File(File_PATH);

		cap.setCapability("app", file.getAbsolutePath());
	}

	public static MobileDriver<MobileElement> InitiateMobileDriver(MobileDriver<MobileElement> mobile,
			MobileDriverType mobileDriverType) {
		switch (mobileDriverType) {
		case ANDROID:
			try {
				mobile = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		case IOS:
			try {
				mobile = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return mobile;
	}

}
