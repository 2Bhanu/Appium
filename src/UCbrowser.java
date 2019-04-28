import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UCbrowser {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = DesiredCapabilities.android();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Emulator");
		cap.setCapability("appPackage", "com.bluestacks.gamepophome");
		cap.setCapability("appActivity", "org.chromium.chrome.browser.document.chromeLauncherActivity");
	    RemoteWebDriver driver= new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	    //driver.findElement(By.xpath("//*[text()='UC Browser']")).click();

}

}
