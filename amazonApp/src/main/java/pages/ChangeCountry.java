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

public class ChangeCountry {
	AppiumDriver<AndroidElement> driver;
	
	@FindBy(id="in.amazon.mShop.android.shopping:id/switch_country_dialog_title")
	private WebElement changeCountry;
	
	@FindBy(id="in.amazon.mShop.android.shopping:id/switch_country_dialog_continue_button")
	private WebElement vCountinue;
	
	
	public WebElement getvCountinue() {
		return vCountinue;
	}


	public void setvCountinue(WebElement vCountinue) {
		this.vCountinue = vCountinue;
	}


	public ChangeCountry(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

	public WebElement getChangeCountry() {
		return changeCountry;
	}



	public void setChangeCountry(WebElement changeCountry) {
		this.changeCountry = changeCountry;
	}
	
	public String verifyChangeCountry() {
		return changeCountry.getText();
	}
	
	public boolean verifyContinue() {
		return vCountinue.isDisplayed();
	}
	
	public void clickContinue() {
		vCountinue.click();
	}
	
	

}

