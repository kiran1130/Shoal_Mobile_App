package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Biometrics {
	public AppiumDriver driver;

	public Biometrics(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.view.View[@content-desc=\"Do you want to enable Touch ID or Face ID?\"]")
	private WebElement txtMessage;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Yes, please\"]")
	private WebElement btnYesPlease;

	@FindBy (xpath = "//android.view.View[@content-desc=\"I'll do it later\"]")
	private WebElement btnDoItLater;

	public WebElement getBtnDoItLater() {
		return btnDoItLater;
	}

	public WebElement getTxtMessage() {
		return txtMessage;
	}

	public void setTxtMessage(WebElement txtMessage) {
		this.txtMessage = txtMessage;
	}

	public void enableBiometrics() {
		Common.screenshot("Landed on Biometrics screen");
		btnYesPlease.click();
	}

	public void doItLater() {
		Common.screenshot("Landed on Biometrics screen");
		btnDoItLater.click();
	}
}

