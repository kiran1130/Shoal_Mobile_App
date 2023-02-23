package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tests.MainListeners;
import io.appium.java_client.AppiumDriver;

public class SetNewPin {
	public AppiumDriver driver;

	public SetNewPin(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//android.view.View[@content-desc=\"Set new PIN\"]")
	private WebElement pageLabel;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Time to set your new PIN\"]")
	private WebElement txtHeader;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Confirm\"]")
	private WebElement btnConfirm;

	public void setNewPin() {
		SecurityPIN pfSecurityPin = new SecurityPIN(MainListeners.getDriver());
		btnConfirm.click();
		pfSecurityPin.setNewPIN();
		pfSecurityPin.confirmPIN();
	}
}

