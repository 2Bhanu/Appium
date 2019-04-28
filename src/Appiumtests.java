import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Appiumtests {
	
	public static AppiumDriver<WebElement> dr;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.0.0");
		capabilities.setCapability("deviceName","Iphone");
		capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("appPackage", "cordova.LSeCOA.Production");
	    // This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","cordova.LSeCOA.Production.MainActivity");
		capabilities.setCapability("automationName", "UiAutomator2");
		// This is Launcher activity of your app (you can get it from apk info app)
	   //Create RemoteWebDriver instance and connect to the Appium server
		dr = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		System.out.println("Automation Name" + dr.getAutomationName());
		dr.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Set<String> context = dr.getContextHandles();
		System.out.println(context);
		
		for(String thisContext : context) {
			if(!thisContext.equals(dr.getContext()))
			dr.context(thisContext);
		}
		System.out.println(dr.getPageSource());
		
		/*clickElementbyID("com.flipkart.android:id/btn_mlogin");
		clickElementbyID("com.flipkart.android:id/mobileNo");
		clickElementbyID("com.google.android.gms:id/credential_primary_label");
		sendKeys("com.flipkart.android:id/et_password","Icebrst1");
		clickElementbyID("com.flipkart.android:id/btn_mlogin");
		clickElementbyID("com.google.android.gms:id/credential_save_reject");
		//System.out.println("Context " + dr.getContext());
		//System.out.println(dr.getCurrentUrl() + " URL");
		//System.out.println(dr.getDeviceTime() + " DeviceTime");
		//System.out.println(dr.getPageSource() + " PageSource");
		//System.out.println(dr.getSessionDetail() +  " Session Detail");
		try {
		System.out.println(dr.getTitle() + " Title");}
		catch(Exception e) {}
		System.out.println(dr.getAppStringMap() + "AppString Map");
		System.out.println(dr.getWindowHandles() + " WindowHandles");
		System.out.println(dr.getSessionId() + " SessionId");
		System.out.println(dr.getContextHandles()+ " Context Handles");
		System.out.println(dr.isBrowser() + " is browser");*/
		
	}
	
	public static void clickElementbyID(String id) {
		dr.findElementById(id).click();
	}
	
	public static void sendKeys(String id , String value) {
		dr.findElementById(id).sendKeys(value);
	}

}
