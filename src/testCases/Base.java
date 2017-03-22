package testCases;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.pakwheels.screenids.PWIDs;

import io.appium.java_client.android.AndroidDriver;

public class Base {
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	public static WebDriverWait wait;

	@SuppressWarnings("rawtypes")
	//@BeforeSuite
	public void launchApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("deviceName", "emulator-5554");

		//Project's .apk file path
		capabilities.setCapability("app", "E:\\Softwares\\Automation\\PakWheelsApp\\APKs\\Ppakwheels51.apk");
		capabilities.setCapability("app-package", "com.pakwheels");
		capabilities.setCapability("app-activity", "com.pakwheels.activities.others.SplashScreenActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 300);
	}

	public void afterAdPostingToHome(boolean userState, int flag) {
		try {
			if (userState && flag == 1) {// Logged in user ad posting for car
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Bundle Offer")));
				if (driver.findElementByName("Bundle Offer").isDisplayed()) {
					driver.findElementByName("Bundle Offer").click();
					driver.findElementById("com.pakwheels:id/btn_feature_my_ad").click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OK")));
					driver.findElementByName("OK").click();
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			} else if (userState && flag == 2) {// Logged in user ad posting for bike/part
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY)));
				if (driver.findElementById(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY).isDisplayed()) {
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			} else if (!userState && flag == 1) {// Non logged in user ad posting for car
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY)));
				if (driver.findElementById(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY).isDisplayed()) {
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			} else if (!userState && flag == 2) {// Non logged in user ad posting for bike/part
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY)));
				if (driver.findElementById(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY).isDisplayed()) {
					driver.navigate().back();
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

	@SuppressWarnings("rawtypes")
	@AfterSuite
	public void tearDown(AndroidDriver androidDriver) throws Exception {
		if (androidDriver != null)
			androidDriver.quit();
	}
}
