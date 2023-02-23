package helper;

import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class Sample {

public static void main(String[] args) {
    String url="https://mobilecloud-uk.quinnox.info:443/wd/hub";
  
    DesiredCapabilities caps= new DesiredCapabilities();
    caps.setCapability("appium:AuthToken", "8c85142a-2175-452d-a637-8411c6a06df6");
    caps.setCapability("appium:SessionName", "MobileBrowser");
    caps.setCapability("browserName", "Chrome");
   
    caps.setCapability("deviceName", "XPH5T19325004213");
    caps.setCapability("platformName", "Android");
    
    caps.setCapability("udid", "XPH5T19325004213");
   
      //caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
      LoggingPreferences logPrefs=new LoggingPreferences();
      logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
      //logPrefs.enable(LogType.BROWSER, Level.ALL);
        //For getting network logs from chrome browser
        //caps.setCapability("appium:loggingPrefs", logPrefs);
        System.out.println("Capabilities are "+ caps.toString());
        System.out.println("URL is "+ url);
        
        IOSDriver driver=null;
   try {
     driver= new IOSDriver(new URL(url), caps);
     driver.get("https://www.google.com");
     //loggingRoutine(driver);
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
 }
  driver.quit();
 }
 public static void loggingRoutine(IOSDriver driver) {
    driver.get("https://appiumpro.com/test");
    driver.executeScript("window.onerror=console.error.bind(console)");
    driver.executeScript("console.log('foo.');");
    driver.executeScript("console.warn('bar?');");
    

    for (LogEntry entry : driver.manage().logs().get("performance")) {
        System.out.println(entry.getMessage());
    }
}
}
