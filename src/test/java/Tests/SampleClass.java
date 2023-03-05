package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class SampleClass {
	
	private AndroidDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		stagingS9();
		// prodPixel3();
		// prodOneplus();
		// prodS10();
	}

	public void stagingS9() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "XPH5T19325004213");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appActivity", "uk.co.joinshoal.MainActivity");
		desiredCapabilities.setCapability("appPackage", "uk.co.joinshoal.qa");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("platformVersion", "10.0");
//		desiredCapabilities.setCapability("appium:Authentication",
//				"YXgvTEkyeGp5NTIvTVdpeHNxd3JWK3JBOGZJUGhQUmtZZmUwNTlCRVBCSWxXMVFVZ01CWXpoRzZwdVZZeHA0SGtBLzMvVmJh");
		desiredCapabilities.setCapability("udid", "XPH5T19325004213"); // android
		// desiredCapabilities.setCapability("browserName","android");
		desiredCapabilities.setCapability("app",
				"https://ctc-device-farm-uk-qyrus.s3.amazonaws.com/shoal/lambdaStorage/01e77088-481d-4491-86c7-f5b20c07e420/01e77088481d449186c7f5b20c07e420.apk");
		desiredCapabilities.setCapability("appium:AuthToken", "29710491-5f12-4e11-88b0-9e227b1c1e0f");
		desiredCapabilities.setCapability("appium:SessionName", "ShoalAutomation");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		URL remoteUrl = new URL("https://mobilecloud-uk.quinnox.info:443/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}
	
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		System.out.println(driver.getSessionId());

		Thread.sleep(15000);
		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
		driver.findElement(By.id("com.ctclogindemo:id/et_username")).sendKeys("admin");
		// driver.findElement(By.id("com.ctclogindemo:id/et_username")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("com.ctclogindemo:id/et_password")).sendKeys("admin");
		// driver.findElement(By.id("com.ctclogindemo:id/et_password")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("com.ctclogindemo:id/btn_login")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void tapModule() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(By.className("android.widget.RadioButton")).click();
		driver.findElement(By.id("com.ctclogindemo:id/StateDropdown")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(By.id("com.ctclogindemo:id/next_module_btn")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 3)
	public void swipeModule() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(By.id("com.ctclogindemo:id/onOffSwitch")).click();
		driver.findElement(By.className("android.widget.ImageView")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 4)
	public void mapModule() throws InterruptedException {

		driver.findElement(By.id("com.ctclogindemo:id/title")).click();
		Thread.sleep(10000);
		driver.findElement(By.className("android.widget.ImageView")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 5)
	public void logout() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(By.className("android.widget.ImageView")).click();
		driver.findElement(By.className("android.widget.FrameLayout")).click();
		Thread.sleep(10000);

	}

	@AfterTest
     public void tearDown() {
       driver.quit();
    

	}

}
