import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class Calculator {
WebDriver driver;
@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "7.0.0");
	capabilities.setCapability("deviceName","Iphone");
	capabilities.setCapability("platformName","Android");
    capabilities.setCapability("appPackage", "com.flipkart.android");
    // This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.flipkart.android.SplashActivity"); // This is Launcher activity of your app (you can get it from apk info app)
   //Create RemoteWebDriver instance and connect to the Appium server
   //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public void testCal() throws Exception {
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/btn_mlogin']")).click();
	Thread.sleep(1000);
	clickMobileElement("com.flipkart.android:id/mobileNo");
	Thread.sleep(1000);
	
   clickMobileElement("com.google.android.gms:id/credential_primary_label");
   Thread.sleep(1000);
	
   sendKeys("com.flipkart.android:id/et_password", "Icebrst1");
   Thread.sleep(1000);
	
   clickMobileElement("com.flipkart.android:id/btn_mlogin");
	
}

public void clickMobileElement(String id) {
	driver.findElement(By.xpath("//*[@resource-id='" + id + "']")).click();
}

public void sendKeys(String id, String value) {
	driver.findElement(By.xpath("//*[@resource-id='" + id + "']")).sendKeys(value);
}
@AfterClass
public void teardown(){
	//close the app
	driver.quit();
}
}
