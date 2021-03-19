package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GenericMethods {
		public static AndroidDriver<AndroidElement> driver;
		public String frameworkPath;
		
		protected String ENV=DataDrivenHelper.getKeyValue("env");
		
		public GenericMethods(){
			frameworkPath = System.getProperty("user.dir");
		}
		
		public void installAndOpenApp() throws MalformedURLException{
			File f = new File(frameworkPath);
	 
	        DesiredCapabilities cap = new DesiredCapabilities();
	      	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");	
	      	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy On7 Prime");
	        cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "in.amazon.mShop.android.shopping");
	        cap.setCapability("appPackage","in.amazon.mShop.android.shopping");
	        cap.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				
				cap.setCapability("noReset", "true");
				cap.setCapability("newCommandTimeout","10000");
				cap.setCapability("adbExecTimeout", "35000");
				
			
	        	
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

}
