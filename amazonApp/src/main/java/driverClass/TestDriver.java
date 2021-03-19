package driverClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.property.GetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import util.GenericMethods;
import util.DataDrivenHelper;
public class TestDriver {
		//public static AndroidDriver<MobileElement> driver;
		public static ExtentReports extentReports;
		public static ExtentTest startTest;
		public String frameworkPath;
		public String tcid;
		GenericMethods genericMethods = new GenericMethods();
		public Object sessionId;
		
		protected String ENV=DataDrivenHelper.getKeyValue("env");
				
		public TestDriver(){
			
				frameworkPath = System.getProperty("user.dir");
				extentReports = new ExtentReports(frameworkPath+"\\Reports\\reportAmazonApp\\AmazonApp_" +getDateTime() + ".html");
			
	
			extentReports.addSystemInfo("Environment", "QA");
			
	  	}
		
		public TestDriver(SessionId sessionId){
			this.sessionId = sessionId;
		}
		
		@BeforeSuite(groups={"Regression","NP"})
		public void setUp() throws MalformedURLException{
			
			System.out.println("in beforesuite");
			//Loading the extent-config file
			URL input = TestDriver.class.getClassLoader().getResource("extent-config.xml");
	        extentReports.loadConfig(input);
	       
	        genericMethods.installAndOpenApp();
	     }
		
		@BeforeMethod(groups={"Regression","NP"})
		public void openAppAfterLaunch(){
			//genericMethods.driver.launchApp();
			SessionId sessionId=genericMethods.driver.getSessionId();
			
			TestDriver testDriver = new TestDriver(sessionId);
			//System.out.println("session id before method "+sessionId);
			GenericMethods.driver.launchApp();
		}
				
		@AfterMethod(groups={"Regression","NP"})
		public void closeApp(ITestResult result) throws Exception{
			if(result.getStatus()==ITestResult.FAILURE){
				try {
				startTest.log(LogStatus.FAIL, "Test case failed", result.getThrowable().toString() + startTest.addScreenCapture(getScreenshot()));
				}catch (Exception e) {
					
				}
				GenericMethods.driver.closeApp();
				GenericMethods.driver.launchApp();
				
			}
			else if(result.getStatus()==ITestResult.SKIP)
				try {
				startTest.log(LogStatus.FAIL, "Test Case Skip", result.getThrowable().toString() + startTest.addScreenCapture(getScreenshot()));
				}catch (Exception e) {
					
				}
			else if(result.getStatus()==ITestResult.SUCCESS)
				startTest.log(LogStatus.PASS, "Test case passed");
			//genericMethods.driver.closeApp();
			extentReports.endTest(startTest);
		}
		
		@AfterClass(groups={"Regression","NP"})
		public void tearDown() throws Exception{
			Thread.sleep(3000);
			extentReports.flush();
		}
		
		@AfterSuite(groups={"Regression","NP"})
		public void closeSuite(){
			extentReports.flush();
			
			genericMethods.driver.quit();
		}
		
		/************  Common methods which support TestDriver  ************/
		public static String getDateTime(){
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyy hh mm ss");
			String format = dateFormat.format(date);
			return format;
		}
		
		public String getScreenshot() throws IOException {
			TakesScreenshot ts = (TakesScreenshot)GenericMethods.driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			String fpath = "file:../../" +"\\Screenshot\\" +getDateTime() + ".png";
			
			if(ENV.equalsIgnoreCase("AWS")) {
				//FOR AWS TEST
				String fpathForAWS = frameworkPath +"/Screenshot/" +getDateTime() + ".png";
				FileUtils.copyFile(screenshotAs, new File(fpathForAWS));
				return fpathForAWS;
			}else {
				FileUtils.copyFile(screenshotAs, new File(fpath));
				return fpath;
			}

			
			
		}
		
		public void moveReportFile(){
			File sourceFile = new File(frameworkPath + "\\Reports\\reportlynxNewsPlanner");
	        File destinationFile = new File(frameworkPath + "\\Reports\\reportLynxNewsPlanner_Old");
	        
	        if (!destinationFile.exists()) {
	            destinationFile.mkdirs();
	        }
			/* Check weather source exists and it is folder. */
	        if (sourceFile.exists() && sourceFile.isDirectory()) {
				/* Get list of the files and iterate over them */
	            File[] listOfFiles = sourceFile.listFiles();
	            if (listOfFiles != null) {
	                for (File child : listOfFiles) {
						/* Move files to destination folder */
	                    child.renameTo(new File(destinationFile + "\\" + child.getName()));
	                    
	                }

	            }
	        }
		}
		
}
