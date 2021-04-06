package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductPage {
	
	AppiumDriver<AndroidElement> driver;
	
	@FindBy(className="android.webkit.WebView")
	private WebElement vProductTitle;
	
	@FindBy(className="android.widget.Button")
	private WebElement vProductPrice;
	
	@FindBy(className="add-to-cart-button")
	private WebElement vProductAddToCart;
	
	@FindBy(className="a-autoid-2-announce")
	private WebElement vProductProceedToCart;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_image")
	private WebElement vCart;
	
	public WebElement getvCart() {
		return vCart;
	}

	public void setvCart(WebElement vCart) {
		this.vCart = vCart;
	}

	public WebElement getvCartProdTitle() {
		return vCartProdTitle;
	}

	public void setvCartProdTitle(WebElement vCartProdTitle) {
		this.vCartProdTitle = vCartProdTitle;
	}

	public WebElement getvCartProdPrice() {
		return vCartProdPrice;
	}

	public void setvCartProdPrice(WebElement vCartProdPrice) {
		this.vCartProdPrice = vCartProdPrice;
	}

	@FindBy(className="android.widget.TextView")
	private WebElement vCartProdTitle;
	
	@FindBy(className="android.view.View")
	private WebElement vCartProdPrice;
	
	public WebElement getvProductAddToCart() {
		return vProductAddToCart;
	}

	public void setvProductAddToCart(WebElement vProductAddToCart) {
		this.vProductAddToCart = vProductAddToCart;
	}

	public WebElement getvProductProceedToCart() {
		return vProductProceedToCart;
	}

	public void setvProductProceedToCart(WebElement vProductProceedToCart) {
		this.vProductProceedToCart = vProductProceedToCart;
	}

	
	
	

	public ProductPage(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getvProductTitle() {
		return vProductTitle;
	}

	public void setvProductTitle(WebElement vProductTitle) {
		this.vProductTitle = vProductTitle;
	}
	
	public WebElement getvProductPrice() {
		return vProductPrice;
	}

	public void setvProductPrice(WebElement vProductPrice) {
		this.vProductPrice = vProductPrice;
	}
	

}
