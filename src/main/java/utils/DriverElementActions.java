package utils;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class DriverElementActions {

	private MobileDriver<MobileElement> lastUsedMobileDriver;

	public DriverElementActions(MobileDriver<MobileElement> mobile) {
		setLastUsedMobileDriver(mobile);
	}

	public void setLastUsedMobileDriver(MobileDriver<MobileElement> lastUsedMobileDriver) {
		this.lastUsedMobileDriver = lastUsedMobileDriver;
	}

	public MobileDriver<MobileElement> getLastUsedMobileDriver() {
		return lastUsedMobileDriver;
	}

	////////////// Mobile Actions Methods ////////////////////


}
