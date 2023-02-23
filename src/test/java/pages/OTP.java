package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Tests.MainListeners;
import helper.Common;
import io.appium.java_client.AppiumDriver;

public class OTP {
	public AppiumDriver driver;
	public int i;

	public OTP(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public void enterOTP() {
		for(int i=1;i<7;i++) {
			MainListeners.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\""+i+"\"]")).click();
		}
		
		Common.screenshot("OTP entered successfully.");
	}
	

}
