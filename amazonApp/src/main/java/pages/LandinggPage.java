package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class LandinggPage {
AppiumDriver<AndroidElement> driver;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo")
	private WebElement vLandingHome;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private WebElement vLandingSearch;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/search_right_cam_img")
	private WebElement vLandingSearchImg;
	
	public WebElement getvLandingSearchImg() {
		return vLandingSearchImg;
	}

	public void setvLandingSearchImg(WebElement vLandingSearchImg) {
		this.vLandingSearchImg = vLandingSearchImg;
	}

	public WebElement getvLandingSearch() {
		return vLandingSearch;
	}

	public void setvLandingSearch(WebElement vLandingSearch) {
		this.vLandingSearch = vLandingSearch;
	}

	public LandinggPage(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getvLandingHome() {
		return vLandingHome;
	}

	public void setvLandingHome(WebElement vLandingHome) {
		this.vLandingHome = vLandingHome;
	}
	
	public boolean verifyHome() {
		return vLandingHome.isDisplayed();
	}
	
	public void searchItem(String aitem) {
		getvLandingSearch().click();
		getvLandingSearch().sendKeys(aitem);
	}
	
	public void clickSearch() {
		getvLandingSearchImg().click();
	}

}
