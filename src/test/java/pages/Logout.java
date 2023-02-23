package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Tests.MainListeners;
import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Logout {

	public AppiumDriver driver;

	public Logout(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.ImageView")
	private WebElement settingsIcon;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Yes\"]")
	private WebElement yesBtn;

	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Log out\"]")
	private WebElement logoutBtn;

	@FindBy (xpath = "//android.view.View[@content-desc=\"No\"]")
	private WebElement noBtn;



	public void logout() {
		Welcome pfWelcomePage = new Welcome(MainListeners.getDriver());

		WebElement txtExistingUser = pfWelcomePage.getTxtExistingUser();

		String expectedText= "Already have an account? ";

		settingsIcon.click();
		logoutBtn.click();
		yesBtn.click();
		Common.screenshot("Logged Out");

		Assert.assertEquals(txtExistingUser.getAttribute("content-desc"), expectedText);

	}



}
