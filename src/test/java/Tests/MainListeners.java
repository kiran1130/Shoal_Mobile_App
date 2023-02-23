package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class MainListeners implements ITestListener {

	static ExtentReports extentReport;
	static ExtentSparkReporter spark;
	static ExtentTest extentTest;

	private static AppiumDriver driver;
//	private static ITestResult result;
//
//	public static ITestResult getResult() {
//		return result;
//	}

	public static AppiumDriver getDriver() {
		return driver;
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static void setDriver(AppiumDriver driver) {
		MainListeners.driver = driver;
	}

	public void onTestStart(ITestResult res) {
		System.out.println("Started test case is " + res.getName());

		extentTest = extentReport.createTest(res.getMethod().getMethodName(), res.getMethod().getMethodName());

	}

	public void onStart(ITestContext res) {
		spark = new ExtentSparkReporter("./test-output/Spark Reports/spark"+System.currentTimeMillis()+".html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);

		Properties prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/resources/config.properties");
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
		

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName",prop.getProperty("qdeviceName") );
		caps.setCapability("udid", prop.getProperty("qudid"));
		caps.setCapability("platformName", prop.getProperty("qplatformName"));
		caps.setCapability("platformVersion", prop.getProperty("qplatformVersion"));
		caps.setCapability("appPackage", prop.getProperty("qappPackage"));
		caps.setCapability("appActivity", prop.getProperty("qappActivity"));
		caps.setCapability("automationName", prop.getProperty("qautomationName"));
		caps.setCapability("appium:AuthToken", prop.getProperty("qAuthToken"));
		caps.setCapability("appium:SessionName", prop.getProperty("qSessionName"));
		caps.setCapability("noReset", prop.getProperty("noReset"));
  
		
		long elementTimeout = Long.parseLong(prop.getProperty("elementTimeout"));

		try {
			driver = new AndroidDriver(new URL(prop.getProperty("qurl")), caps);
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementTimeout));

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Session:" + driver.getSessionId());
	}

	public void onFinish(ITestContext res) {

		extentReport.flush();
		driver.quit();
	}

	// Run when the test case passed successfully
	public void onTestSuccess(ITestResult res) {
		System.out.println("Test case passed is " + res.getName());
		

	}

	// Run when the test case fails
	public void onTestFailure(ITestResult res) {
		Throwable throwvar = res.getThrowable();
		System.out.println("Test case failed is " + res.getName());
		try {

			extentTest.addScreenCaptureFromPath(capture(MainListeners.getDriver())).log(Status.FAIL, throwvar.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(capture(MainListeners.getDriver())).build());
			System.out.println("Test Failed:" + res.getMethod().getMethodName());

		} catch (Exception ex) {

			System.out.println("Error Message:" + ex.getMessage());
		} finally {

			// driver.quit();
		}
	}

	// Run when test case pass with some failures
	public void onTestFailedButWithinSuccessPercentage(ITestResult res) {
		System.out.println("Test case passed with failure is " + res.getName());
	}

	// Run when the test case is skipped
	public void onTestSkipped(ITestResult res) {
		System.out.println("Test case skipped is :" + res.getName());
	}

	private String capture(AppiumDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:/Images/" + System.currentTimeMillis() + ".png");
		String errssflpath = Dest.getAbsolutePath();

		Files.copy(scrFile.toPath(), Dest.toPath());
		return errssflpath;
	}

}
