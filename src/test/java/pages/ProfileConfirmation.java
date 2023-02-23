package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileConfirmation {
	
	public RemoteWebDriver driver;

	public ProfileConfirmation(RemoteWebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Let's go\"]")
	private WebElement btnLetsGo;
	

	
	public WebElement getBtnLetsGo() {
		return btnLetsGo;
	}

	public void setBtnLetsGo(WebElement btnLetsGo) {
		this.btnLetsGo = btnLetsGo;
	}

	public void clickOnLetsGo() {
		btnLetsGo.click();
	}


}
