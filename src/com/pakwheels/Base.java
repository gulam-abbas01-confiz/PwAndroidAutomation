package com.pakwheels;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pakwheels.helper.GenericHelper;
import com.pakwheels.helper.Helpers;
import com.pakwheels.helper.NavigationHelper;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class Base {

	public AndroidDriver driver;
	
	public static WebElement wait(By locator) {
        return Helpers.wait(locator);
    }
	
	/*public void executeSanity()  {
		//rough
		wait(By.id(PWIDs.SplashScreenIDs.BTN_CROSS));
		driver.findElementById(PWIDs.SplashScreenIDs.BTN_CROSS).click();

		SellYourCarScreenObject sellYourCarScreenObject = new SellYourCarScreenObject();
		sellYourCarScreenObject.postAdWithoutPic();
		
		System.out.println("Sanity has been done.");
	}*/
	
	@Before
	public void launchApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("deviceName", "emulator-5554");

		// Project's .apk file path
		capabilities.setCapability("app", "E:\\Softwares\\Automation\\PakWheelsApp\\APKs\\pakwheels50.apk");
		capabilities.setCapability("app-package", "com.pakwheels");
		capabilities.setCapability("app-activity", "com.pakwheels.activities.others.SplashScreenActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Helpers.init(driver);
	}
	
	public void afterAdPostingToHome(boolean userState, int flag) {
		try {
			if (userState && flag == 1) {//Logged in user ad posting for car
				wait(By.id("Bundle Offer"));
				if (driver.findElementByName("Bundle Offer").isDisplayed()) {
					driver.findElementByName("Bundle Offer").click();
					driver.findElementById("com.pakwheels:id/btn_feature_my_ad").click();
					wait(By.id("OK"));
					driver.findElementByName("OK").click();
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			}
			else if(userState && flag == 2){//Logged in user ad posting for bike/part
				wait(By.id(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY));
				if (driver.findElementById(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY).isDisplayed()) {
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			}
			else if(!userState && flag == 1) {//Non logged in user ad posting for car
				wait(By.id(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY));
				if (driver.findElementById(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY).isDisplayed()) {
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			}
			else if(!userState && flag == 2){//Non logged in user ad posting for bike/part
				wait(By.id(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY));
				if (driver.findElementById(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY).isDisplayed()) {
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occur in Driver --> afterAdPostingTo_Home(boolean userState, int flag) ");
			e.printStackTrace();
		}
	}
	@After
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }
}
