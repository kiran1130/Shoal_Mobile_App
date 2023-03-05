package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Login{

	public AppiumDriver driver;

	public Login(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (className = "android.widget.EditText")
	private WebElement txtMobileNumber;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Login\"]")
	private WebElement btnLogin;

	public WebElement getTxtMobileNumber() {
		return txtMobileNumber;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}


	public void login() {
		txtMobileNumber.click();
		txtMobileNumber.sendKeys("7893932988");
		Common.screenshot("Entered Mobile number.");
		btnLogin.click();
		Common.enterPIN(); //PIN Entered

	}

}
