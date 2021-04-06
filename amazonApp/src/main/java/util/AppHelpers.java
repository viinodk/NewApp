package util;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.LoginPage;

public class AppHelpers extends GenericMethods {
	
	public void scrollByID(String Id, int index) {

        try {

             driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance("+index+"));")); 

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
	
	/*
	 * username and password is taken from credentials.properties file
	 */
	public static void loginToApp() throws Exception {
		LoginPage safeLoginPage = new LoginPage(driver);
		String uname = getUnamePwd("username");
		String pwd = getUnamePwd("password");
		safeLoginPage.loginToApp(uname, pwd);
	}
	
	
	public static String getUnamePwd(String key) throws Exception {
		
		InputStream input = null;
		Properties properties = new Properties();
		input = DataDrivenHelper.class.getClassLoader().getResourceAsStream("credentials.properties");
		properties.load(input);
		return properties.getProperty(key);
	}
	
	public void scrollAndClick(String visibleText) {
     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
        }
	
	public void swipeAmazonApp() throws InterruptedException {
		System.out.println("SWIPE");
		// TouchAction action = new TouchAction(driver);
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
		int x = driver.manage().window().getSize().getWidth() / 2;
		int yStart = (int) (driver.manage().window().getSize().getHeight() * 0.8);
		int yEnd = (int) (driver.manage().window().getSize().getHeight() * 0.2);
		for (int i = 0; i <= 8; i++) {
			action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(x, yStart)))
			.moveTo(PointOption.point(x, yEnd)).release().perform();
			Thread.sleep(2000);
		}
	}
	
	public void clickSearch() {
		//List<WebElement> ares = driver.findElements(ById("com.amazon.mShop.android.shopping:id/rs_vertical_stack_view"));
		AndroidElement searchtree = driver.findElement(By.className("android.widget.ListView"));
		System.out.println("search e;lements are "+searchtree);
		List<MobileElement> childres = searchtree.findElements(By.className("android.widget.LinearLayout"));
		for(int i=2;i<childres.size()-1;i++) {
			scrollAndClick("Sony Bravia 164 cm");
			break;
		}
		
	}
	
    }


