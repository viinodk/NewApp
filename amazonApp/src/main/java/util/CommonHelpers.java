package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverClass.TestDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;

public class CommonHelpers extends TestDriver{
	
		
		public static String initReports(Map hm) throws IOException{
			String tcid = hm.get("TC_ID").toString();
			String testDescription = hm.get("testDescription").toString();
			startTest = extentReports.startTest(tcid+"_"+testDescription);
			
			
			InputStream input = null;
			Properties prop = new Properties();
			input = DataDrivenHelper.class.getClassLoader().getResourceAsStream("log4j.properties");
			prop.load(input);
			PropertyConfigurator.configure(prop);
			
			return tcid;
		}
		
		
}
