package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ResetPinConfirm {
	public AppiumDriver driver;

	public ResetPinConfirm(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//android.view.View[@content-desc=\"Done\"]")
	private WebElement btnDone;
	
	public void clickDone() {
		System.out.println(btnDone.getAttribute("content-desc"));
		System.out.println(btnDone.isDisplayed());
		btnDone.click();
		
	}

}
