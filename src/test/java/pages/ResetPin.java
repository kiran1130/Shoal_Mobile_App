package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;


public class ResetPin {

	public AppiumDriver driver;

	public ResetPin(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Reset PIN\"]")
	private WebElement pageLabel;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Let's go\"]")
	private WebElement btnLetsGo;

	public void clickLetsGo() {
		btnLetsGo.click();

	}


}
