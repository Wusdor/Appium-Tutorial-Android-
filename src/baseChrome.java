import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseChrome {

	public static AndroidDriver<AndroidElement> chromeCap(String device) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();

		switch (device) {

		case ("emulator"):

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Wusdor");
			break;

		case ("real"):

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // if you want to set real
																							// Android device simply
																							// apply this line of code
			break;
		}

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		driver = new AndroidDriver<>(new URL("http://192.168.0.112:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

}
