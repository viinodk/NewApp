package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {

	AppiumDriver<AndroidElement> driver;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	private WebElement vLoginAlreadyCust;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText")
	private WebElement vLoginEnterEmail;
	
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")
	private WebElement vLoginContinueButton;
	
	@FindBy(id="auth-signin-show-password-checkbox")
	private WebElement vLoginUnCheckBox;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[2]/android.widget.EditText")
	private WebElement vLoginEnterPwd;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[6]/android.widget.Button")
	private WebElement vLoginSignIn;
	
	
	public LoginPage(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public WebElement getvLoginAlreadyCust() {
		return vLoginAlreadyCust;
	}

	public void setvLoginAlreadyCust(WebElement vLoginAlreadyCust) {
		this.vLoginAlreadyCust = vLoginAlreadyCust;
	}

	public WebElement getvLoginEnterEmail() {
		return vLoginEnterEmail;
	}

	public void setvLoginEnterEmail(WebElement vLoginEnterEmail) {
		this.vLoginEnterEmail = vLoginEnterEmail;
	}

	public WebElement getvLoginContinueButton() {
		return vLoginContinueButton;
	}

	public void setvLoginContinueButton(WebElement vLoginContinueButton) {
		this.vLoginContinueButton = vLoginContinueButton;
	}

	public WebElement getvLoginUnCheckBox() {
		return vLoginUnCheckBox;
	}

	public void setvLoginUnCheckBox(WebElement vLoginUnCheckBox) {
		this.vLoginUnCheckBox = vLoginUnCheckBox;
	}

	public WebElement getvLoginEnterPwd() {
		return vLoginEnterPwd;
	}

	public void setvLoginEnterPwd(WebElement vLoginEnterPwd) {
		this.vLoginEnterPwd = vLoginEnterPwd;
	}

	public WebElement getvLoginSignIn() {
		return vLoginSignIn;
	}

	public void setvLoginSignIn(WebElement vLoginSignIn) {
		this.vLoginSignIn = vLoginSignIn;
	}
	
	public void loginToApp(String uname, String upwd) {
		getvLoginAlreadyCust().click();
		getvLoginEnterEmail().sendKeys(uname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getvLoginContinueButton().click();
//		getvLoginUnCheckBox().click();
		getvLoginEnterPwd().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getvLoginEnterPwd().sendKeys(upwd);
		getvLoginSignIn().click();
		
		
		
		
	}

	
	
	
}

