package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mongodb.diagnostics.logging.Logger;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HamburgerPage {
	AppiumDriver<AndroidElement> driver;
	
	@FindBy(id="in.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon")
	private WebElement vHamburger;
	
	
	


	public HamburgerPage(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement getvHamburger() {
		return vHamburger;
	}


	public void setvHamburger(WebElement vHamburger) {
		this.vHamburger = vHamburger;
	}
	
	public void clickHamburg() {
		vHamburger.click();
	}
	
	
		

}

