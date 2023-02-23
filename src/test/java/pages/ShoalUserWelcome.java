package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ShoalUserWelcome {
	public AppiumDriver driver;

	public ShoalUserWelcome(AppiumDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Shoal\"]")
	private WebElement headerTxtShoal;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Welcome,\r\n"
			+ " Uday!\"]")
	private WebElement txtWelcome;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Here are your next steps\"]")
	private WebElement txtContent1;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Complete your registration and open a Shoal account\"]")
	private WebElement txtContent2 ;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Top up your account and create your first savings pot\"]")
	private WebElement txtContent3 ;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Complete registration\"]")
	private WebElement btnCompleteRegistration ;
	
	@FindBy (xpath = "//android.view.View[@content-desc=\"Explore app\"]")
	private WebElement btnExploreApp ;
	
	
	
	
	
	public void clickOnExploreApp() {
		
		Properties prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/resources/assertions.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
//		String expectedHeader = prop.getProperty("shoalUserWelcome.header");
//		String expectedtxtcontent1 = prop.getProperty("shoalUserWelcome.content1");
//		String expectedtxtcontent2 = prop.getProperty("shoalUserWelcome.content2");
//		String expbtntxtcompleteregistration = prop.getProperty("shoalUserWelcome.btntxtcompleteregistration");
//		
		
		
		
//		assertEquals(headerTxtShoal.getAttribute("content-desc"), expectedHeader);
//		assertEquals(txtContent1.getAttribute("content-desc"), expectedtxtcontent1);
//		assertEquals(txtContent2.getAttribute("content-desc"), expectedtxtcontent2);
//		assertEquals(txtContent3.getAttribute("content-desc"), expbtntxtcompleteregistration);
		btnExploreApp.click();
	}
	
	public void clickOnCompleteRegistration() {
		btnCompleteRegistration.click();
	}
}
