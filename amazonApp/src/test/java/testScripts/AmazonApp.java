package testScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import driverClass.TestDriver;
import io.appium.java_client.MobileElement;
import pages.ChangeCountry;
import pages.HamburgerPage;
import pages.LandinggPage;
import pages.SelectCountry;
import util.AppHelpers;
import util.CommonHelpers;
import util.GenericMethods;
import util.TestDataFromExcel;

import static util.GenericMethods.driver;

import java.io.IOException;
import java.util.Map;

public class AmazonApp extends TestDriver {
	
	public static GenericMethods genericMethods;
	public AmazonApp(){
		genericMethods = new GenericMethods();
	}
	Logger logger = Logger.getLogger(AmazonApp.class);
	
	
	@Test(dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=1)
	public void launchApp(Map hm) throws Exception{
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		LandinggPage landinggPage = new LandinggPage(driver);
		if(landinggPage.verifyHome()==true) {
			logger.info("Test case "+tcid+" passed");
			startTest.log(LogStatus.PASS, "Application Launch successful");
		}
	}
	
	
	@Test(dependsOnMethods = {"launchApp"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=2)
	public void verifyHamburgerClick(Map hm)throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		HamburgerPage hamburgerPage = new HamburgerPage(driver);
		
		hamburgerPage.clickHamburg();
	}
	
	
	
	@Test(dependsOnMethods = {"verifyHamburgerClick"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression"}, priority=2)
	public void clickOnSettings(Map hm) throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		AppHelpers aha = new AppHelpers();	
		logger.info("Starting execution of the test case for - " +tcid);
		HamburgerPage hamburgerPage = new HamburgerPage(driver);
		hamburgerPage.clickHamburg();
		aha.scrollAndClick("Settings");
		/*
		 * MobileElement el1 = (MobileElement) driver.findElementById(
		 * "in.amazon.mShop.android.shopping:id/glow_subnav_ingress"); el1.click();
		 * aha.scrollAndClick("Australia (English)");
		 */
		
		
	}
	
	@Test(dependsOnMethods = {"clickOnSettings"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression"}, priority=3)
	public void verifyCountryList(Map hm) throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		AppHelpers aha = new AppHelpers();
		String acountry = hm.get("country").toString();
		String asettings = hm.get("Settings").toString();
		SelectCountry selectCountry = new SelectCountry(driver);
		HamburgerPage hamburgerPage = new HamburgerPage(driver);
		hamburgerPage.clickHamburg();
		aha.scrollAndClick(asettings);
		Assert.assertEquals(selectCountry.verifySelectCountry(), true);
		selectCountry.vSelectCountryClick();
		aha.scrollAndClick(acountry);
		
	}
	
	@Test(dependsOnMethods = {"verifyCountryList"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression"}, priority=4)
	public void changeCountry(Map hm) throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		AppHelpers aha = new AppHelpers();
		String achangecountry = hm.get("ChangeCountryText").toString();
		String asettings = hm.get("Settings").toString();
		String acountry = hm.get("country").toString();
		SelectCountry selectCountry = new SelectCountry(driver);
		ChangeCountry changeCountry = new ChangeCountry(driver);
		HamburgerPage hamburgerPage = new HamburgerPage(driver);
		hamburgerPage.clickHamburg();
		aha.scrollAndClick(asettings);
		Assert.assertEquals(selectCountry.verifySelectCountry(), true);
		selectCountry.vSelectCountryClick();
		aha.scrollAndClick(acountry);
		
		String atect = changeCountry.verifyChangeCountry();
		System.out.println("text on Change Country is "+atect);
		Assert.assertEquals(atect, achangecountry);
		Assert.assertEquals(changeCountry.verifyContinue(), true);
		changeCountry.clickContinue();
		
	}
	

}
