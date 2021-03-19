package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class LandinggPage {
AppiumDriver<AndroidElement> driver;
	
	@FindBy(id="in.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo")
	private WebElement vLandingHome;
	
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

}
