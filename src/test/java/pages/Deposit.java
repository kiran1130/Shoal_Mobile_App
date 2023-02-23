package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tests.MainListeners;
import helper.Common;
import io.appium.java_client.AppiumDriver;

public class Deposit {
	public AppiumDriver driver;

	public Deposit(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (className =  "android.widget.EditText")
	private WebElement txtAmount;

//	@FindBy (xpath = "//android.widget.Button[@content-desc=\"3.34% AER\r\n"
//			+ "2 days\"]")
//	private WebElement btnTerm2Days;

	@FindBy (xpath = "//android.widget.Button[@content-desc=\"3.94% AER\r\n"
			+ "3 months\"]")
	private WebElement btnTerm3Months;
	
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"4.79% AER\r\n"
			+ "12 months\"]")
	private WebElement btnTerm12Months;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"I would like to save\"]")
	private WebElement txtMessage;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Review\"]")
	private WebElement btnReview;
	
	
	private WebElement getTermTab() {
		
		WebElement btnTerm2Days = driver.findElements(By.className("android.widget.Button")).get(0);
		return btnTerm2Days;
		
	}
	
	
	public void makeDeposit(String deposit) throws InterruptedException {
		
		
		Home pfHome = new Home(MainListeners.getDriver());
		Review pfReview = new Review(MainListeners.getDriver());
		WebElement btnSave = pfHome.getBtnSave();
		btnSave.click();
		txtAmount.click();
		txtAmount.sendKeys(deposit);
		Common.screenshot("Entered Amount");
		txtMessage.click();
		getTermTab().click();
		Common.screenshot("Term Selected");
		btnReview.click();	
		pfReview.clickOnContinue();
		
	}

}
