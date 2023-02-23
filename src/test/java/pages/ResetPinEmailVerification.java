package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tests.MainListeners;
import helper.Common;
import io.appium.java_client.AppiumDriver;

public class ResetPinEmailVerification {
	public AppiumDriver driver;

	public ResetPinEmailVerification(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Email verification\"]")
	private WebElement pageLabel;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Next, enter the verification code we've sent you via email\"]")
	private WebElement txtHeader;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Enter the code we sent to your email \"]")
	private WebElement txtEmail;
	
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Resend code\"]")
	private WebElement lnkResend;
	
	public WebElement getPageLabel() {
		return pageLabel;
	}

	public WebElement getTxtHeader() {
		return txtHeader;
	}

	public WebElement getLnkResend() {
		return lnkResend;
	}
	
	public void enterOTP() {
		for(int i=1;i<7;i++) {
			MainListeners.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\""+i+"\"]")).click();
		}
		
		Common.screenshot("OTP entered successfully.");
	}
}
