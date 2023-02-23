package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class Notifications {
	
	public AppiumDriver driver;

	public Notifications(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Shoal would like to send you notifications\"]")
	private WebElement txtMessage;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"You’ll get important updates about your savings and other information\"]")
	private WebElement txtContent;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Yes, please\"]")
	private WebElement btnYes;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"I'll do it later\"]")
	private WebElement btnDoItLater;
	
	public void enableNotifications() {
		btnYes.click();
	}
	
	public void doItLater() {
		btnDoItLater.click();
	}
	
	
}
