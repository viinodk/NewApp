package util;

import io.appium.java_client.MobileBy;

public class AppHelpers extends GenericMethods {
	
	public void scrollByID(String Id, int index) {

        try {

             driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance("+index+"));")); 

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
	
	
	
	public void scrollAndClick(String visibleText) {
     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
        }
    }


