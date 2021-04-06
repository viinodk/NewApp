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

public class AmazonApp extends TestDriver {
	
	public static GenericMethods genericMethods;
	public AmazonApp(){
		genericMethods = new GenericMethods();
	}
	Logger logger = Logger.getLogger(AmazonApp.class);
	
	/*
	 * launches amazon app
	 */
	@Test(dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=1)
	public void launchApp(Map hm) throws Exception{
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		LoginPage loginPage = new LoginPage(driver);
		LandinggPage landinggPage = new LandinggPage(driver);
		AppHelpers.loginToApp();
		if(landinggPage.verifyHome()==true) {
			logger.info("Test case "+tcid+" passed");
			startTest.log(LogStatus.PASS, "Application Launch successful");
		}
	}
	
	/*
	 * Verify Hamburger menu item after app is launched
	 */
	@Test(dependsOnMethods = {"launchApp"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=2)
	public void verifyHamburgerClick(Map hm)throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		logger.info("Starting execution of the test case for - " +tcid);
		HamburgerPage hamburgerPage = new HamburgerPage(driver);
		
		hamburgerPage.clickHamburg();
	}
	
	
	/*
	 * Click on settings after scroll down dynamically to Settings
	 */
	@Test(dependsOnMethods = {"verifyHamburgerClick"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression"}, priority=3)
	public void clickOnSettings(Map hm) throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		AppHelpers aha = new AppHelpers();	
		logger.info("Starting execution of the test case for - " +tcid);
		HamburgerPage hamburgerPage = new HamburgerPage(driver);
		hamburgerPage.clickHamburg();
		aha.scrollAndClick("Settings");
		
		
	}
	/*
	 * Click on settings to change country
	 */
	@Test(dependsOnMethods = {"clickOnSettings"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression"}, priority=4)
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
	
	/*
	 * click on confirm settings after selecting Austraila as country
	 */
	@Test(dependsOnMethods = {"verifyCountryList"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression"}, priority=5)
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
		logger.info("Test case "+tcid+" passed");
		
	}
	
	@Test(dependsOnMethods = {"launchApp"}, dataProvider = "commondata", dataProviderClass = TestDataFromExcel.class, groups={"Regression","NP"}, priority=6)
	public void aSearchItem(Map hm) throws Exception {
		String tcid = CommonHelpers.initReports(hm);
		String aprod = hm.get("Product").toString();
		AppHelpers aha = new AppHelpers();
		LoginPage loginPage = new LoginPage(driver);
		LandinggPage landinggPage = new LandinggPage(driver);
		ProductPage productPage = new ProductPage(driver);
		landinggPage.searchItem(aprod);
		//driver.pressKeyCode(AndroidKeyCode.ENTER);
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
		aha.clickSearch();
		String prodtext = productPage.getvProductTitle().getText();
		System.out.println("text on prod is "+prodtext);
		String prodprice = productPage.getvProductPrice().getText();
		System.out.println("text on prod price is "+prodprice);

		productPage.getvProductAddToCart().click();
		productPage.getvProductProceedToCart().click();
		
		productPage.getvCart().click();
		String cartProdTitle = productPage.getvCartProdTitle().getText();
		String cartProdPrice = productPage.getvCartProdPrice().getText();
		if(prodtext.contains(cartProdTitle)) {
			System.out.println("title is same in search and cart");
		}
		
		if(prodprice.contains(cartProdPrice)) {
			System.out.println("price is same in search and cart");
		}
		
	}
	

}
