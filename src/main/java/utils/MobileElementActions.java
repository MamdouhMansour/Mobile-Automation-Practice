package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class MobileElementActions {

	@SuppressWarnings("unused")
	private MobileDriver<MobileElement> mobile;

	public MobileElementActions(MobileDriver<MobileElement> mobile) {
		this.mobile = mobile;
	}

	public static MobileElementActions click(MobileDriver<MobileElement> mobile, By elementLocator) {
		locatingElementStrategy(mobile, elementLocator);
		mobile.findElement(elementLocator).click();
		return new MobileElementActions(mobile);

	}

	public static MobileElementActions type(MobileDriver<MobileElement> mobile, By elementLocator, String text) {
		locatingElementStrategy(mobile, elementLocator);
		mobile.findElement(elementLocator).sendKeys(text);

		return new MobileElementActions(mobile);
	}

	public static String getText(MobileDriver<MobileElement> mobile, By elementLocator) {
		locatingElementStrategy(mobile, elementLocator);
		String text = mobile.findElement(elementLocator).getText();

		return text;
	}

	/////////////// LocatingElementStrategyMethod ///////////////////////

	private static void locatingElementStrategy(MobileDriver<MobileElement> mobile, By elementLocator) {
		// Check if element is visible
		Helper.getExplicitWait(mobile).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

		// scroll into view for the element to handle special cases of some browser
//		((JavascriptExecutor) mobile).executeScript("arguments[0].scrollIntoView(false);",
//				mobile.findElement(elementLocator));

		// check if the element is displayed
		mobile.findElement(elementLocator).isDisplayed();
	}
}
