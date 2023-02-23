package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Tests.MainListeners;
import helper.Common;
import io.appium.java_client.AppiumDriver;

public class MobileNumber {
	public AppiumDriver driver;
	private String mobileQuestion = "##, what is your mobile number?"
			+ "We'll use it to set up your profile";
	
	//android.view.View[@content-desc="ss, what is your mobile number?
//	We'll use it to set up your profile"]
	//android.view.View[@content-desc="ss, what is your mobile number?
//	We'll use it to set up your profile"]

	public MobileNumber(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"We'll use it to set up your profile\"]")
	private WebElement txtContent;

	@FindBy (className =  "android.widget.EditText")
	private WebElement txtMobNumber;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Continue\"]" )
	private WebElement btnContinue;

	public void validateHeaderText() {
		StringBuilder sb = new StringBuilder(mobileQuestion);
		
		Name pfName = new Name(MainListeners.getDriver());
		String name = pfName.getCustomerName();
		System.out.println(name);
		sb.replace(0, 2, name);
		
		System.out.println(sb.toString());
		String locatorValue = "//android.view.View[@content-desc=\""+sb.toString()+"\"]";
		System.out.println(locatorValue);
		
		
		WebElement txtHeader = Common.GetElement("xpath",locatorValue);
		String expectedText = "\""+name+"\", what is your mobile number?";
		Assert.assertEquals(txtHeader.getAttribute("content-desc"), expectedText);
		

	}

	public void enterMobNumber(String mobNumber) {

		txtMobNumber.click();
		txtMobNumber.sendKeys(mobNumber);
		Common.screenshot("Mobile number entered successfully.");
		btnContinue.click();
	}



}
