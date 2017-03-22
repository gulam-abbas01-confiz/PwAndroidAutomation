package com.pakwheels;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.DDT.PWData;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.helper.NavigationHelper;
import com.pakwheels.screenids.PWIDs;

public class CarFinanceScreenObject {
	// Object
	@FindBy(id = PWIDs.CarFinanceScreenIDs.BTN_CALCULATE)
	private WebElement calculateBtn;
	
	@FindBy(id = PWIDs.CarFinanceScreenIDs.BTN_SUBMIT)
	private WebElement submitBtn;
	
	private WebElement carInfoTxt;
	private WebElement cityTxt;
	private WebElement priceTxt;
	private WebElement tenureTxt;
	private WebElement percentageTxt;
	private WebElement nameTxt;
	private WebElement emailTxt;
	private WebElement phoneTxt;
	
	private RemoteWebDriver remoteWebDriver = null;
	
	// ============================================================================================================================================================//

	// Initialize Sell your bike Screen Objects
	public CarFinanceScreenObject(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
	}

	// Getter
	public WebElement getCalculateBtn() {
		return calculateBtn;
	}
	public RemoteWebDriver getRemoteWebDriver() {
		return remoteWebDriver;
	}

	// Setter
	public void setCalculateBtn(WebElement calculateBtn) {
		this.calculateBtn = calculateBtn;
	}
	public void setRemoteWebDriver(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
	}

	// ===========================================================================================================================================================//
	// Methods
	public void calculatePrice_RequestFinance(){
		
		try{
			System.out.println("		* Start Requesting for Car Finance... *");
			NavigationHelper.homeToCarFinanceScreen(remoteWebDriver);
			forNewCar();
			forUsedCar();
			remoteWebDriver.navigate().back();
			System.out.println("		* Car Finance requesting has been done successfully. *");
			System.out.println("        ***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
	}
	private void forNewCar(){
		System.out.println("Applying New Car Finance...");
		//Select Car information
		WebElement carElement = remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_MAKE_NEW_CAR);
		carInfoTxt = carElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CAR_INFO));
		carInfoTxt.click();
		
		List<WebElement>modelList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_MODEL));
		modelList.get(GenericHelper.randomIndex(modelList.size())).click();
		
		List<WebElement>versionList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_VERSION));
		if(versionList.size() > 0){
			versionList.get(GenericHelper.randomIndex(versionList.size())).click();
			System.out.println("Car Information (Year/Model/Version) : " + carInfoTxt.getText().toString());
		}
		else{
			//remoteWebDriver.navigate().back();
			System.out.println("No version for selected car.");
		}
		
		//Select City
		WebElement cityElement = remoteWebDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY));
		cityTxt = cityElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY));
		cityTxt.click();
		List<WebElement>cityList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();
		System.out.println("City : " + cityTxt.getText().toString());
		
		//Select Tenure
		WebElement tenureElement = remoteWebDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_TENURE_LIST));
		tenureTxt = tenureElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY));
		tenureTxt.click();
		List<WebElement>tenureList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		tenureList.get(GenericHelper.randomIndex(tenureList.size())).click();
		System.out.println("Tenure : " + tenureTxt.getText().toString());
				
		//Select Percentage
		WebElement percentageElement = remoteWebDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_PERCENTAGE_LIST));
		percentageTxt = percentageElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY));
		percentageTxt.click();
		List<WebElement>percentageList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		percentageList.get(GenericHelper.randomIndex(percentageList.size())).click();
		System.out.println("Down Payment : " + percentageTxt.getText().toString());
		
		remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_CALCULATE).click();
		
		applyForFinance();
		System.out.println("Applied.");
		System.out.println("***********************************************************************************");
	}
	private void forUsedCar(){
		System.out.println("Applying Used Car Finance...");
		remoteWebDriver.findElementByName("USED CARS").click();
		
		//Set price
		WebElement priceElement = remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_PRICE);
		priceTxt = priceElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CAR_INFO));
		priceTxt.clear();
		priceTxt.sendKeys(GenericHelper.randomIndex(100000, 99999999));
		System.out.println("Price : " + priceTxt.getText().toString());
		
		
		//Select Model year
		WebElement carElement = remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_YEAR_LIST);
		carInfoTxt = carElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CAR_INFO));
		carInfoTxt.click();
		
		List<WebElement>yearList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_MODEL));
		yearList.get(GenericHelper.randomIndex(yearList.size())).click();
		
		System.out.println("Model year : " + carInfoTxt.getText().toString());
		
		//Select Tenure
		WebElement tenureElement = remoteWebDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_TENURE_LIST));
		tenureTxt = tenureElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY));
		tenureTxt.click();
		List<WebElement>tenureList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		tenureList.get(GenericHelper.randomIndex(tenureList.size())).click();
		System.out.println("Tenure : " + tenureTxt.getText().toString());
				
		//Select Percentage
		WebElement percentageElement = remoteWebDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_PERCENTAGE_LIST));
		percentageTxt = percentageElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY));
		percentageTxt.click();
		List<WebElement>percentageList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		percentageList.get(GenericHelper.randomIndex(percentageList.size())).click();
		System.out.println("Down Payment : " + percentageTxt.getText().toString());
		
		remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_CALCULATE).click();
		applyForFinance();
		System.out.println("Applied.");
	}
	
	private void applyForFinance(){
		if(!resultFound()){
			remoteWebDriver.navigate().back();
		}
		else{
			List<WebElement> bankList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.BTN_APPLY_NOW));
			if(bankList.size() > 0){
				bankList.get(0).click();
				GenericHelper.waitForElement(remoteWebDriver, PWIDs.CarFinanceScreenIDs.BTN_SUBMIT);
				fillFinanceForm();
			}
			else{
				remoteWebDriver.navigate().back();
			}
		}
	}
	
	private boolean resultFound(){
		try{
			remoteWebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_APPLY_NOW).isDisplayed()){
				System.out.println("Result Found.");
				return true;
			}
			else if(remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.IV_NO_RESULT).isDisplayed() && remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.TV_TEXT_NO_RESULT).isDisplayed() && remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.TV_TITLE_NO_RESULT).isDisplayed()){
				System.out.println("No Result Found.");
				return false;
			}
		}
		catch(Exception ex){
			System.out.println("Expection in CarFinanceScreenObject --> resultFound();");
		}
		return false;
	}
	
	private void fillFinanceForm(){
		System.out.println("Start Filling form...");
		List<WebElement> fieldList = remoteWebDriver.findElements(By.id(PWIDs.CarSureScreenIDs.TXT_CAR_INFO));
		/*for(int i = 0 ; i < fieldList.size(); i++){
			System.out.println(fieldList.get(i).getText());
		}*/
		
		if(fieldList.get(0).getText().trim().equals("Enter Name")){
			// Name
			WebElement nameElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_NAME));
			nameTxt = nameElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_NAME));
			nameTxt.clear();
			nameTxt.sendKeys(new String[] { "Testing Request" });
		}
		
		
		if(fieldList.get(1).getText().trim().equals("Enter Email")){
			// Email
			WebElement emailElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_EMAIL));
			emailTxt = emailElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_EMAIL));
			emailTxt.clear();
			emailTxt.sendKeys(new String[] { "carsure@mailinator.com" });
		}
		
		//Select City
		WebElement cityElement = remoteWebDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_FORM));
		cityTxt = cityElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY));
		cityTxt.click();
		List<WebElement>cityList = remoteWebDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();
		System.out.println("City : " + cityTxt.getText().toString());
		
		
		if(fieldList.get(3).getText().trim().equals("Enter Mobile Number")){
			// Phone
			WebElement phoneElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_PHONE));
			phoneTxt = phoneElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_PHONE));
			phoneTxt.clear();
			phoneTxt.sendKeys(PWData.SignUp.PHONE);
		}
		
		System.out.println("Form Filled.");
		remoteWebDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_SUBMIT).click();
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.CarFinanceScreenIDs.BTN_APPLY_NOW);
		remoteWebDriver.navigate().back();
	}
}

