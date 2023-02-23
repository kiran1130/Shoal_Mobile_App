package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tests.MainListeners;
import helper.Common;
import io.appium.java_client.AppiumDriver;

public class TermsAndConditions {
	public AppiumDriver driver;

	public TermsAndConditions(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//android.view.View[@content-desc=\"Terms & Conditions\"]")
	private WebElement txtPageLabel;

	@FindBy (xpath = "//android.widget.ImageView[@content-desc=\"I'd like to receive personalised updates \"]")
	private WebElement radioBtnConsent;

	@FindBy (xpath = "//android.view.View[@content-desc=\"Accept\"]")
	private WebElement btnAccept;
	

	
	


	public void acceptTermsAndConditions() throws InterruptedException {
		ProfileConfirmation pf = new ProfileConfirmation(MainListeners.getDriver());
		WebElement letsGo = pf.getBtnLetsGo();
		
		btnAccept.click();
		Thread.sleep(5000);
		System.out.println("Let's Go button displayed: "+letsGo.isDisplayed()); 
		Common.screenshot("Landed on Confirmation screen.");
		
		
	}

	public void swipeUp() throws InterruptedException {

		WebElement source = driver.findElements(By.className("android.widget.ImageView")).get(0);
//		WebElement target = driver.findElements(By.className("android.widget.ImageView")).get(0);
		Rectangle sourceElementRect = source.getRect();
//		Rectangle targetElementRect = target.getRect();
		int centerX = sourceElementRect.x+(sourceElementRect.width/2);
//		double startY = sourceElementRect.y+(sourceElementRect.height*0.9);

		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragNDrop = new Sequence(finger, 1);
		dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
				PointerInput.Origin.viewport(), centerX, 500));
		dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
				PointerInput.Origin.viewport(),centerX, 100));
		dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(dragNDrop));
		
		
	}
	
	public boolean clickable() {
		System.out.println(btnAccept.isEnabled());
		String clickable = btnAccept.getAttribute("checkable");
		System.out.println(clickable);
		if(clickable.toLowerCase().equals("true")) {
			return true;
		}
		
		return false;
		
	}
	
	

}
