package com.pakwheels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.DDT.PWData;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.screenids.PWIDs;

public class CarSureScreenObjects {
	// Object
	@FindBy(id = PWIDs.CarSureScreenIDs.BTN_CAR_SURE)
	private WebElement requestCarSureBtn;
	
	private WebElement carInfoTxt;
	private WebElement cityTxt;
	private WebElement nameTxt;
	private WebElement emailTxt;
	private WebElement phoneTxt;

	private RemoteWebDriver remoteWebDriver = null;

	// ============================================================================================================================================================//

	// Initialize Sell your bike Screen Objects
	public CarSureScreenObjects(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
	}

	// Getter
	public RemoteWebDriver getRemoteWebDriver() {
		return remoteWebDriver;
	}

	// Setter
	public void setRemoteWebDriver(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
	}

	// ===========================================================================================================================================================//
	// Methods
	public void carSureRequest(){
		try{
			System.out.println("Start CarSure requesting from Landing card...");
			remoteWebDriver.findElementByName("CarSure Inspection").click();
			remoteWebDriver.findElementById(PWIDs.CarSureScreenIDs.BTN_CAR_SURE_PRODUCT).click();
			fillForm();
			remoteWebDriver.navigate().back();
			System.out.println("CarSure requesting from Landing card has been posted successfully.");
			System.out.println("***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
	}
	private void fillForm(){
		//Select Car information
		WebElement carElement = remoteWebDriver.findElementById(PWIDs.CarSureScreenIDs.MODULE_MAKE_MODEL);
		carInfoTxt = carElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_CAR_INFO));
		carInfoTxt.click();

		List<WebElement>yearList = remoteWebDriver.findElements(By.id(PWIDs.CarSureScreenIDs.MODULE_YEAR));
		yearList.get(GenericHelper.randomIndex(yearList.size())).click();
		
		List<WebElement>modelList = remoteWebDriver.findElements(By.id(PWIDs.CarSureScreenIDs.MODULE_MODEL));
		modelList.get(GenericHelper.randomIndex(modelList.size())).click();
		
		List<WebElement>versionList = remoteWebDriver.findElements(By.id(PWIDs.CarSureScreenIDs.MODULE_VERSION));
		if(versionList.size() > 0){
			versionList.get(GenericHelper.randomIndex(versionList.size())).click();
			System.out.println("Car Information (Year/Model/Version) : " + carInfoTxt.getText().toString());
		}
		else{
			//remoteWebDriver.navigate().back();
			System.out.println("No version for selected car.");
		}
		
		// Select City
		WebElement cityElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_CITY));
		cityTxt = cityElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_CITY));
		cityTxt.click();
		
		List<WebElement>cityList = remoteWebDriver.findElements(By.id(PWIDs.CarSureScreenIDs.MODULE_CITY_LIST));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();
		System.out.println("City : " + cityTxt.getText().toString());
		
		List<WebElement> fieldList = remoteWebDriver.findElements(By.id(PWIDs.CarSureScreenIDs.TXT_CAR_INFO));
		
		if(fieldList.get(2).getText().trim().equals("Enter Name")){
			// Name
			WebElement nameElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_NAME));
			nameTxt = nameElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_NAME));
			nameTxt.clear();
			nameTxt.sendKeys(new String[] { "Testing Request" });
		}
		
		
		if(fieldList.get(3).getText().trim().equals("Enter Email")){
			// Email
			WebElement emailElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_EMAIL));
			emailTxt = emailElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_EMAIL));
			emailTxt.clear();
			emailTxt.sendKeys(new String[] { "carsure@mailinator.com" });
		}
		
		
		if(fieldList.get(4).getText().trim().equals("Enter Mobile Number")){
			// Phone
			WebElement phoneElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_PHONE));
			phoneTxt = phoneElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_PHONE));
			phoneTxt.clear();
			phoneTxt.sendKeys(PWData.SignUp.PHONE);
		}
		
		remoteWebDriver.findElementById(PWIDs.CarSureScreenIDs.BTN_SUBMIT).click();
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.CarSureScreenIDs.BTN_CAR_SURE_PRODUCT);
	}
}
