package com.pakwheels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.screenids.PWIDs;

public class MyGarageScreenObject {
	// Object
	@FindBy(id = PWIDs.MyGarageScreenIDs.BTN_ADD_RIDE)
	private WebElement addRideBtn;

	/*private RemoteWebDriver remoteWebDriver = null;
	private WebDriverWait webDriverWait = null;*/
	
	//============================================================================================================================================================//
	
	//Initialize Sell your car Screen Objects
	public MyGarageScreenObject(RemoteWebDriver remoteWebDriver) {
		//this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
		
		//For wait until specific element loads.
		//webDriverWait = new WebDriverWait(remoteWebDriver, 500);
	}
	
	//Getter
	
	
	//Setter
		
}
