package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Common;
import helper.Helper;
import io.appium.java_client.AppiumDriver;

public class Name {
	

	public AppiumDriver driver;
	private static String customerName = "";

	
	public Name(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//android.view.View[@content-desc=\"Welcome to Shoal!\r\n"
			+ "What is your name? \"]")
	private WebElement txtWelcome;

	@FindBy (className =  "android.widget.EditText")
	private WebElement txtName;


	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]" )
	private WebElement btnContinue;


	@FindBy (xpath = "//android.view.View[@content-desc=\"You must enter your name to continue.\"]" )
	private WebElement txtError;

	public String getCustomerName() {
		
		return customerName;
	}

	public WebElement getTxtName() {
		return txtName;
	}

	public void enterName() {
		String name = Helper.generateFirstName();
		txtName.click();
		txtName.sendKeys(name);  // Need to be passed through data file.
		Common.screenshot("Name entered successfully.");
		
		String completeText = txtName.getAttribute("text");
		int lastIndex = completeText.indexOf(',');
		String uname = completeText.substring(0, lastIndex);
		System.out.println(uname);
		customerName = uname;
	}
	
	public void tapOnContinue() {
		btnContinue.click();
	}





}
