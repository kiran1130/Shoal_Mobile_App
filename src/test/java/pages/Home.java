package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Home {
	public AppiumDriver driver;

	public Home(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Add funds\"]")
	private WebElement btnAddFunds;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Withdraw\"]")
	private WebElement btnWithdraw;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Save\"]")
	private WebElement btnSave;
	
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Add £1000\"]")
	private WebElement lnkFund;
	

	public WebElement getBtnAddFunds() {
		return btnAddFunds;
	}

	public WebElement getBtnWithdraw() {
		return btnWithdraw;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public void addFunds() throws InterruptedException {
		
		btnAddFunds.click();
		lnkFund.click();
		Thread.sleep(6000);
		Common.screenshot("Fund Added");
		
	}

}
