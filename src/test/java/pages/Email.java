package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Email {
	public AppiumDriver driver;

	public Email(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//android.view.View[@content-desc=\"What is your email address?\"]")
	private WebElement txtMessage;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"We'll use it to set up your profile\"]")
	private WebElement txtContent;
	
	@FindBy (className = "android.widget.EditText")
	private WebElement txtEmailID;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement btnContinue;
	
	
	public void enterEmail(String email) {
		txtEmailID.click();
		txtEmailID.sendKeys(email);
		Common.screenshot("E-mail entered successfully.");
		btnContinue.click();
	}
	
	
}
