package com.pakwheels.helper;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.pakwheels.screenids.PWIDs;

public class NavigationHelper {
	public static RemoteWebDriver remoteWebDriver = null;

	public static void homeToLogoutScreen(RemoteWebDriver remoteWebDriver) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.HomeScreenIDs.BTN_MORE_TAB);
		remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
	}

	public static void moreToLogoutScreen(RemoteWebDriver remoteWebDriver) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
	}

	public static void homeToMyProfileScreen(RemoteWebDriver remoteWebDriver) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
	}

	public static void homeToMyGarageScreen(RemoteWebDriver remoteWebDriver) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
		/*
		 * GenericHelper.waitForElement(remoteWebDriver, "My Garage" , 1);
		 * List<WebElement>moreList =
		 * remoteWebDriver.findElements(By.className("android.widget.TextView"))
		 * ; moreList.get(11).click();
		 */
		remoteWebDriver.findElementByName("My Garage").click();
	}

	public static void homeToCarFinanceScreen(RemoteWebDriver remoteWebDriver) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		remoteWebDriver.findElementByName("Car Finance").click();
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.CarFinanceScreenIDs.BTN_CALCULATE);
	}

	public static void homeToSignInScreen(RemoteWebDriver remoteWebDriver) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.S_PROFILE).click();
	}

	public static void afterAdPostingToHome(RemoteWebDriver remoteWebDriver, boolean userState, int flag) {
		/*if (NavigationHelper.remoteWebDriver == null) {
			NavigationHelper.remoteWebDriver = remoteWebDriver;
		}*/
		NavigationHelper.remoteWebDriver = remoteWebDriver;
		try {
			if (userState && flag == 1) {
				GenericHelper.waitForElement(remoteWebDriver, "Bundle Offer");
				if (remoteWebDriver.findElementByName("Bundle Offer").isDisplayed()) {
					remoteWebDriver.findElementByName("Bundle Offer").click();
					remoteWebDriver.findElementById("com.pakwheels:id/btn_feature_my_ad").click();
					GenericHelper.waitForElement(remoteWebDriver, "OK");
					remoteWebDriver.findElementByName("OK").click();
					remoteWebDriver.navigate().back();
					remoteWebDriver.navigate().back();
					remoteWebDriver.navigate().back();
				}
			}
			else if(userState && flag == 2){
				GenericHelper.waitForElement(remoteWebDriver, PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY);
				if (remoteWebDriver.findElementById(PWIDs.VerifyNumberDialogueIDs.BTN_VERIFY).isDisplayed()) {
					remoteWebDriver.navigate().back();
					remoteWebDriver.navigate().back();
					remoteWebDriver.navigate().back();
				}
			}
			else if(!userState && flag == 1) {
				GenericHelper.waitForElement(remoteWebDriver, PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY);
				if (remoteWebDriver.findElementById(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY).isDisplayed()) {
					remoteWebDriver.navigate().back();
					remoteWebDriver.navigate().back();
					if (remoteWebDriver.findElementById(PWIDs.confirmNavigateDialogueIDs.BTN_YES).isDisplayed()) {
						remoteWebDriver.findElementById(PWIDs.confirmNavigateDialogueIDs.BTN_YES).click();
					}
				}
			}
			else if(!userState && flag == 2){
				GenericHelper.waitForElement(remoteWebDriver, PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY);
				if (remoteWebDriver.findElementById(PWIDs.VerifyMobileNumberScreenIDs.BTN_VERIFY).isDisplayed()) {
					remoteWebDriver.navigate().back();
					remoteWebDriver.navigate().back();
					if (remoteWebDriver.findElementById(PWIDs.confirmNavigateDialogueIDs.BTN_YES).isDisplayed()) {
						remoteWebDriver.findElementById(PWIDs.confirmNavigateDialogueIDs.BTN_YES).click();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occur in Driver --> afterAdPostingTo_Home(RemoteWebDriver remoteWebDriver) ");
			//e.printStackTrace();
		}
	}
}
