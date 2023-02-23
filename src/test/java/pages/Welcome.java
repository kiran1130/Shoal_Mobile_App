package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class Welcome {
	public AppiumDriver driver;

	public Welcome(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.view.View[@content-desc=\"Login\"]")
	private WebElement lnkLogin;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Already have an account? \"]")
	private WebElement txtExistingUser;


	@FindBy (xpath = "//android.view.View[@content-desc=\"Sign up\"]")
	private WebElement btnSignUp;

	public WebElement getLnkLogin() {
		return lnkLogin;
	}


	public void setLnkLogin(WebElement lnkLogin) {
		this.lnkLogin = lnkLogin;
	}


	public WebElement getTxtExistingUser() {
		return txtExistingUser;
	}


	public void setTxtExistingUser(WebElement txtExistingUser) {
		this.txtExistingUser = txtExistingUser;
	}


	public WebElement getBtnSignUp() {
		return btnSignUp;
	}


	public void setBtnSignUp(WebElement btnSignUp) {
		this.btnSignUp = btnSignUp;
	}

	public void clickSignUp() {
		btnSignUp.click();

	}
	
	public void clickLoginLnk() {
		lnkLogin.click();
	}



}
