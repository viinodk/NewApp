package testScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.relevantcodes.extentreports.LogStatus;

import driverClass.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import pages.ChangeCountry;
import pages.HamburgerPage;
import pages.LandinggPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SelectCountry;
import util.AppHelpers;
import util.CommonHelpers;
import util.GenericMethods;
import util.TestDataFromExcel;

import static util.GenericMethods.driver;

import java.io.IOException;
import java.util.Map;

public class LoginScript extends TestDriver {
	
	public static GenericMethods genericMethods;
	public LoginScript(){
		genericMethods = new GenericMethods();
	}
	Logger logger = Logger.getLogger(LoginScript.class);
	
	/*
	 * launches amazon app with valid login credentials
	 */
	@Test(description = "Login with valid credentials", dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=1)
	public void validLogin(Map hm) throws Exception{
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		LoginPage loginPage = new LoginPage(driver);
		LandinggPage landinggPage = new LandinggPage(driver);
		AppHelpers.loginToApp();
		if(landinggPage.verifyHome()==true) {
			logger.info("Test case "+tcid+" passed");
			logger.info("App logged in  - " +tcid+" with username"+AppHelpers.getUnamePwd("username")+" and password "+AppHelpers.getUnamePwd("password"));
			startTest.log(LogStatus.PASS, "Application Launch successful");
		}
	}
	
	@Test(description = "Login with valid username and invalid password", dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=2)
	public void invalidLoginA(Map hm) throws Exception{
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		LoginPage loginPage = new LoginPage(driver);
		LandinggPage landinggPage = new LandinggPage(driver);
		AppHelpers.invalidloginToApp_1();
		if(landinggPage.verifyHome()==true) {
			logger.info("Test case "+tcid+" passed");
			startTest.log(LogStatus.PASS, "Application Launch successful");
		}else {
			logger.info("App not logged in  - " +tcid+" with username"+AppHelpers.getUnamePwd("username")+" and password "+AppHelpers.getUnamePwd("npassword"));
		}
	}
	
	@Test(description = "Login with invalid username and valid password", dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=2)
	public void invalidLoginB(Map hm) throws Exception{
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		LoginPage loginPage = new LoginPage(driver);
		LandinggPage landinggPage = new LandinggPage(driver);
		AppHelpers.invalidloginToApp_2();
		logger.info("Starting execution of the test case for - " +tcid);
		
		if(landinggPage.verifyHome()==true) {
			logger.info("Test case "+tcid+" passed");
			startTest.log(LogStatus.PASS, "Application Launch successful");
		}else {
			logger.info("App not logged in  - " +tcid+" with username"+AppHelpers.getUnamePwd("nusername")+" and password "+AppHelpers.getUnamePwd("password"));
		}
	}
	
	
	
		
	}
	


