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

public class SelectCountry {
	AppiumDriver<AndroidElement> driver;
	
	@FindBy(id="in.amazon.mShop.android.shopping:id/anp_drawer_item")
	private WebElement selectCountry;
	
	


	public SelectCountry(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public void setSelectCountry(WebElement selectCountry) {
		this.selectCountry = selectCountry;
	}
	
	
	public boolean verifySelectCountry() {
		return selectCountry.isDisplayed();
	}
	
	public void vSelectCountryClick() {
		selectCountry.click();
	}
		

}

