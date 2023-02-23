package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Review {
	
	public AppiumDriver driver;

	public Review(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath =   "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;

	@FindBy (xpath =   "//android.view.View[@content-desc=\"Confirm \"]")
	private WebElement btnConfirm;
	
	@FindBy (xpath =   "//android.view.View[@content-desc=\"Got it\"]")
	private WebElement btnGotIt;
	
	
	public void clickOnContinue() throws InterruptedException {
		
		btnContinue.click();
		btnConfirm.click();
		Thread.sleep(3000);
		Common.screenshot("Deposit Successful");
		btnGotIt.click();
		Thread.sleep(3000);
		Common.screenshot("Landed on Home screen");
	}
	
	

}
