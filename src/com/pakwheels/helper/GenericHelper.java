package com.pakwheels.helper;


import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pakwheels.DDT.PWData;
import com.pakwheels.screenids.PWIDs;

public class GenericHelper {
	private static WebDriverWait webDriverWait = null;
	
	//0,1,2
	//0 = by id		, 		1 = by name 	,		2 = by className
	public static void waitForElement(RemoteWebDriver remoteWebDriver, String element){
		webDriverWait = new WebDriverWait(remoteWebDriver, 60);
		int status = detectNature(element);
		if(status == 0){
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		}
		else if (status == 1){
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
		}
		else if (status == 2){
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
		}
		else{
			System.out.println("Unable to detect nature of id.");
		}
	}
	
	private static int detectNature(String element){
		element = element.trim();
		if(element.startsWith("com.pakwheels:id/") && !element.contains(" ")){
			//System.out.println("Id is detected.");
			return 0;//Find by id detect.
		}
		else if((!element.startsWith("com.pakwheels:id/")) && (element.contains(" ") || !element.contains(" ")) && !element.contains(":")){
			//System.out.println("Name is detected.");
			return 1;//Find by Name detect.
		}
		else if(element.contains(".") && !element.contains(":") && !element.contains("_") && !element.contains(" ")){
			//System.out.println("className is detected.");
			return 2;//Find by className detect.
		}
		else{
			//System.out.println("Id is not detectable. Please see the function's logic : GenericHelper > detectNature()");
			return 3;
		}
	}
	
	public static void TakeScreenShot(RemoteWebDriver remoteWebDriver, String imageName) {
		try {
			File scrFile = ((TakesScreenshot) remoteWebDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\MyData\\ScreenShoots\\" + imageName + ".png"));
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void Logout(RemoteWebDriver remoteWebDriver){
		
		try{
			System.out.println("Start logging out...");
			remoteWebDriver.findElementByName("Settings").click();
			/*List<WebElement>moreList = remoteWebDriver.findElements(By.className("android.widget.TextView"));
			for(int i = 0 ; i < moreList.size() ; i++){
				System.out.println("Index : " + i + " , value : " + moreList.get(i).getText());
			}
			moreList.get(17).click();*/
			
			/*waitForElement(remoteWebDriver, "com.pakwheels:id/relativeLayoutMyLocationBlock_user_settings_activity");
			List<WebElement>settingsList = remoteWebDriver.findElements(By.className("android.widget.TextView"));
			for(int i = 0 ; i < settingsList.size() ; i++){
				System.out.println("Index : " + i + " , value : " + settingsList.get(i).getText());
			}
			//settingsList.get(8).click();*/
			remoteWebDriver.findElementByName("Logout").click();
			
			PWData.SignIn.email = "";
			PWData.SignIn.pwd = "";
			System.out.println("Logout successfully.");
			System.out.println("***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
	}
	
	public static int randomIndex(int size){
		if(size > 0){
			Random rand = new Random();
			try{
				int  n = rand.nextInt(size); //'size-1' is the maximum and the 0 is our minimum 
				/*System.out.println("Total size = " + size);
				System.out.println("Range from 0 = " + (size-1));
				System.out.println("Randon generated index = " + n);
				System.out.println("***********************************************************************************");*/
				return n;
			}catch(Exception e){
				randomIndex(size);
			}
		}
		System.out.println("Error! Array size is less than 1.");
		return 0;
	}
	public static String randomIndex(int l_Limit, int u_limit){
		if(l_Limit > u_limit){
			int junk = l_Limit;
			l_Limit = u_limit;
			u_limit = junk;
		}
		
		Random rand = new Random();
		int  n = rand.nextInt(u_limit) + l_Limit; //'u_limit' is the maximum and the l_limit is our minimum 
		/*System.out.println("lower limit = " + l_Limit + " , upper limit = " + u_limit);
		System.out.println("Randon generated index = " + n);
		System.out.println("***********************************************************************************");*/
		return Integer.toString(n);
	}
	
	public static void calculateExecutionTime(Date start , Date end){
		long diff = end.getTime() - start.getTime();
		System.out.println("Execution Starts at : " + start.toString());
        String dateFormat="Total Duration of Execution : ";
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        if(diffDays>0){
            dateFormat+=diffDays+" day ";
        }
        diff -= diffDays * (24 * 60 * 60 * 1000);

        int diffhours = (int) (diff / (60 * 60 * 1000));
        if(diffhours>0){
            dateFormat+=diffhours+" hour ";
        }
        diff -= diffhours * (60 * 60 * 1000);

        int diffmin = (int) (diff / (60 * 1000));
        if(diffmin>0){
            dateFormat+=diffmin+" min ";
        }
        diff -= diffmin * (60 * 1000);

        int diffsec = (int) (diff / (1000));
        if(diffsec>0){
            dateFormat+=diffsec+" sec";
        }
        System.out.println(dateFormat);
        System.out.println("Execution End at : " + end.toString());
	}
	
	@SuppressWarnings("resource")
	public static void waitForScrolling(String element){
		try {
			Scanner sc=new Scanner(System.in);
			System.out.print("Scroll down to the " + element + " and press enter to continue : ");
			sc.nextLine();
		} catch (Exception e) {
			System.out.println("Exception occur in Driver --> waitForScrolling(String element) ");
			e.printStackTrace();
		}
	} 
	
	public static void takePictureFromEmulator(RemoteWebDriver remoteWebDriver){
		//Make things to Upload pictures.
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.LLVIEW_CHOOSE_IMAGE);
		remoteWebDriver.findElementById(PWIDs.SellYourCarScreenIDs.LLVIEW_CHOOSE_IMAGE).click();
		remoteWebDriver.findElementByName(PWIDs.UploadPicutreIDs.TXT_AT_CHOICE_DIALOGE).click();
		remoteWebDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_ALBUM).click();
		remoteWebDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_IMAGE).click();
		remoteWebDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_DONE).click();
	}
	
	public static void selectCityForSellForm(RemoteWebDriver remoteWebDriver, WebElement cityTxt){
		//Select City
		WebElement cityElement = remoteWebDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_CITY));
		cityTxt = cityElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_CITY));
		cityTxt.click();
		
		List<WebElement>cityList = remoteWebDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();
		
		List<WebElement>cityAreaList = remoteWebDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_CITY_AREA));
		if(cityAreaList.size() > 0){
			cityAreaList.get(GenericHelper.randomIndex(cityAreaList.size())).click();
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.MODULE_CITY);
			System.out.println("City Information : " + cityTxt.getText().toString());
		}
		else{
			remoteWebDriver.navigate().back();
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.MODULE_CITY);
			System.out.println("City Information : " + cityTxt.getText().toString() + " , City Area : " +  "No City Area.");
		}
	}
	
	public static void selectRegCityForSellForm(RemoteWebDriver remoteWebDriver, WebElement regCityTxt){
		//Select Registration city
		WebElement regCityElement = remoteWebDriver.findElementById(PWIDs.SellYourCarScreenIDs.MODULE_REG_CITY);
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.MODULE_REG_CITY);
		regCityTxt = regCityElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_REG_CITY));
		regCityTxt.click();
		
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.MODULE_REG_AREA);
		List<WebElement>regCityList = remoteWebDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_REG_AREA));
		regCityList.get(GenericHelper.randomIndex(regCityList.size())).click();
		
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.MODULE_REG_CITY);
		System.out.println("Registration City : " + regCityTxt.getText().toString());
	}
	
	public static void selectMileageForSellForm(RemoteWebDriver remoteWebDriver, WebElement mileageTxt){
		WebElement milageElement = remoteWebDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_MILAGE));
		mileageTxt = milageElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_MILAGE));
		mileageTxt.clear();
		mileageTxt.sendKeys(GenericHelper.randomIndex(1, 999999));
		
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourCarScreenIDs.MODULE_MILAGE);
		System.out.println("Mileage : " + mileageTxt.getText().toString());
	}
	
	public static void selectDescriptionForSellForm(RemoteWebDriver remoteWebDriver, WebElement descriptionTxt, String category){
		//Description
		WebElement descriptionElement = remoteWebDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_DESCRIPTION));
		descriptionTxt = descriptionElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_DESCRIPTION));
		descriptionTxt.clear();
		descriptionTxt.sendKeys(category + " posted : " + PWData.AdDescription.carDescription);
		
		System.out.println("Description : " + PWData.AdDescription.carDescription);
	}
	
	public static void selectPriceForSellForm(RemoteWebDriver remoteWebDriver, WebElement priceTxt){
		WebElement priceElement = remoteWebDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_PRICE));
		priceTxt = priceElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_PRICE));
		priceTxt.clear();
		priceTxt.sendKeys(GenericHelper.randomIndex(400000, 10000000));
		
		System.out.println("Price : " + priceTxt.getText().toString());
	}
	
	public static void selectPersonalInfoForSellForm(RemoteWebDriver remoteWebDriver, WebElement nameTxt, WebElement phoneTxt, Boolean userState ){
		//Personal Information
		WebElement nameElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_NAME));
		nameTxt = nameElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_NAME));
		
		WebElement phoneElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_PHONE));
		phoneTxt = phoneElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_PHONE));
		
		if(!isLoggedIn(remoteWebDriver, phoneTxt)){
			userState = false;
			// Name
			nameTxt.clear();
			nameTxt.sendKeys(new String[] { "Testing Post" });
			
			/*// Email
			WebElement emailElement = remoteWebDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_EMAIL));
			emailTxt = emailElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_EMAIL));
			emailTxt.clear();
			emailTxt.sendKeys(PWData.SignUp.EMAIL);*/
			
			// Phone
			phoneTxt.clear();
			phoneTxt.sendKeys(PWData.SignUp.PHONE);
			
			System.out.println("Name : " + nameTxt.getText());
			//System.out.println("Email : " + emailTxt.getText());
			System.out.println("Phone : " + phoneTxt.getText());
		}
		else{
			userState = true;
			System.out.println("Name : " + nameTxt.getText());
			//System.out.println("Email : " + emailTxt.getText());
			System.out.println("Phone : " + phoneTxt.getText());
		}
	}
	private static boolean isLoggedIn(RemoteWebDriver remoteWebDriver, WebElement phoneTxt){
		try{
			if(getIndex(remoteWebDriver, "Enter Name") == -1 || getIndex(remoteWebDriver, "Enter Mobile Number") == -1){
				System.out.println("returning true i.e user is logged in. ");
				if(phoneTxt.getText().trim().equals("Enter Mobile Number")){
					phoneTxt.clear();
					phoneTxt.sendKeys(PWData.SignUp.PHONE);
				}
				return true;
			}
			System.out.println("returning false i.e user is not logged in. ");
			return false;
		}catch(Exception ex){
			System.out.println("Exception occur. HINT: " + ex);
		}
		return false;
	}
	private static int getIndex(RemoteWebDriver remoteWebDriver, String value){
		List<WebElement> fieldList = remoteWebDriver.findElements(By.id("com.pakwheels:id/et_input_text"));
		for(int i = 0 ; i < fieldList.size() ; i++){
			if(fieldList.get(i).getText().toLowerCase().equals(value.toLowerCase())){
				return i;
			}
		}
		return -1;
	}
}
