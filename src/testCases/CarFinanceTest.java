package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pakwheels.DDT.PWData;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.screenids.PWIDs;

import io.appium.java_client.android.AndroidDriver;
import pom.CarFinancePageObject;

public class CarFinanceTest extends Base {
	@SuppressWarnings("rawtypes")
	private AndroidDriver thisDriver;
	private WebDriverWait thisWait;
	private CarFinancePageObject obj;

	@BeforeTest
	private void init() throws Exception {
		super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new CarFinancePageObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 30);
		PageFactory.initElements(thisDriver, obj);
	}
	
	@BeforeTest
	private void init2() throws Exception {
		//super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new CarFinancePageObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 30);
		PageFactory.initElements(thisDriver, obj);
	}

	@Test
	public void requestCarFinanceNonLogin() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SplashScreenIDs.BTN_CROSS)));
		thisDriver.findElementById(PWIDs.SplashScreenIDs.BTN_CROSS).click();
		
		gotoFinanceScreen();
		calculatePriceNewCar();
		applyForFinance();
		calculatePriceUsedCar();
		applyForFinance();
		thisDriver.navigate().back();
		
		super.tearDown(thisDriver);
	}
	
	@Test
	public void requestCarFinanceLoggedIn() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SplashScreenIDs.BTN_CROSS)));
		thisDriver.findElementById(PWIDs.SplashScreenIDs.BTN_CROSS).click();
		
		gotoFinanceScreen();
		calculatePriceNewCar();
		applyForFinance();
		calculatePriceUsedCar();
		applyForFinance();
		thisDriver.navigate().back();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		super.tearDown(thisDriver);
	}
	
	private void gotoFinanceScreen() throws Exception{
		thisDriver.findElementByName("Car Finance").click();
	}
	
	private void calculatePriceNewCar() {
		carInformation();
		chooseCity();
		setTenure();
		setDownPayment();
		thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_CALCULATE).click();
	}

	private void calculatePriceUsedCar() {
		thisDriver.findElementByName("USED CARS").click();
		setPrice();
		setModelYear();
		//setTenure();
		WebElement tenureElement = thisDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_TENURE_LIST));
		obj.setTenureTxt(tenureElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY)));
		obj.getTenureTxt().click();
		thisDriver.findElementByName("1 Year").click();
		
		//setDownPayment();
		WebElement percentageElement = thisDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_PERCENTAGE_LIST));
		obj.setPercentageTxt(percentageElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY)));
		obj.getPercentageTxt().click();
		thisDriver.findElementByName("45%").click();
		
		thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_CALCULATE).click();
	}

	private void carInformation() {
		chooseCarModel();
		chooseCarVersion();
	}

	@SuppressWarnings("unchecked")
	private void chooseCarModel() {
		WebElement carElement = thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_MAKE_NEW_CAR);
		obj.setCarInfoTxt(carElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_CAR_INFO)));
		obj.getCarInfoTxt().click();

		List<WebElement> modelList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_MODEL));
		modelList.get(GenericHelper.randomIndex(modelList.size())).click();
	}

	private void chooseCarVersion() {
		@SuppressWarnings("unchecked")
		List<WebElement> versionList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_VERSION));
		if (versionList.size() > 0) {
			versionList.get(GenericHelper.randomIndex(versionList.size())).click();
		} else {
			thisDriver.navigate().back();
		}
	}

	private void chooseCity() {
		WebElement cityElement = thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_CITY);
		obj.setCityTxt(cityElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY)));
		obj.getCityTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> cityList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();
	}

	@SuppressWarnings("unchecked")
	private void setTenure() {
		WebElement tenureElement = thisDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_TENURE_LIST));
		obj.setTenureTxt(tenureElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY)));
		obj.getTenureTxt().click();

		List<WebElement> tenureList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		tenureList.get(GenericHelper.randomIndex(tenureList.size())).click();
	}

	@SuppressWarnings("unchecked")
	private void setDownPayment() {
		WebElement percentageElement = thisDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_PERCENTAGE_LIST));
		obj.setPercentageTxt(percentageElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY)));
		obj.getPercentageTxt().click();

		List<WebElement> percentageList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		percentageList.get(GenericHelper.randomIndex(percentageList.size())).click();
	}

	private void setPrice() {
		WebElement priceElement = thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_PRICE);
		obj.setPriceTxt(priceElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CAR_INFO)));
		obj.getPriceTxt().clear();
		obj.getPriceTxt().sendKeys("1200000");
	}

	@SuppressWarnings("unchecked")
	private void setModelYear() {
		WebElement carElement = thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.MODULE_YEAR_LIST);
		obj.setCarInfoTxt(carElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CAR_INFO)));
		obj.getCarInfoTxt().click();

		thisDriver.findElementByName("2015").click();
	}

	// -------------------------------------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	private void applyForFinance() {
		if (!resultFound()) {
			thisDriver.navigate().back();
		} 
		else {
			List<WebElement> bankList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.BTN_APPLY_NOW));
			if (bankList.size() > 0) {
				bankList.get(0).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.CarFinanceScreenIDs.BTN_SUBMIT)));
				fillFinanceForm();
			} else {
				thisDriver.navigate().back();
			}
		}
	}

	private boolean resultFound() {
		try {
			if (thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_APPLY_NOW).isDisplayed()) {
				System.out.println("Result Found.");
				return true;
			} else if (thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.IV_NO_RESULT).isDisplayed()
					&& thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.TV_TEXT_NO_RESULT).isDisplayed()
					&& thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.TV_TITLE_NO_RESULT).isDisplayed()) {
				System.out.println("No Result Found.");
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Expection in CarFinanceScreenObject --> resultFound();");
			thisDriver.navigate().back();
			thisDriver.navigate().back();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private void fillFinanceForm() {
		List<WebElement> fieldList = thisDriver.findElements(By.id(PWIDs.CarSureScreenIDs.TXT_CAR_INFO));

		if (fieldList.get(0).getText().trim().equals("Enter Name")) {
			// Name
			WebElement nameElement = thisDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_NAME));
			obj.setNameTxt(nameElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_NAME)));
			obj.getNameTxt().clear();
			obj.getNameTxt().sendKeys(new String[] { "Testing Request" });
		}

		if (fieldList.get(1).getText().trim().equals("Enter Email")) {
			// Email
			WebElement emailElement = thisDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_EMAIL));
			obj.setEmailTxt(emailElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_EMAIL)));
			obj.getEmailTxt().clear();
			obj.getEmailTxt().sendKeys(new String[] { "automation@mailinator.com" });
		}

		// Select City
		WebElement cityElement = thisDriver.findElement(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_FORM));
		obj.setCityTxt(cityElement.findElement(By.id(PWIDs.CarFinanceScreenIDs.TXT_CITY)));
		obj.getCityTxt().click();
		
		List<WebElement>cityList = thisDriver.findElements(By.id(PWIDs.CarFinanceScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();

		if (fieldList.get(3).getText().trim().equals("Enter Mobile Number")) {
			// Phone
			WebElement phoneElement = thisDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_PHONE));
			obj.setPhoneTxt(phoneElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_PHONE)));
			obj.getPhoneTxt().clear();
			obj.getPhoneTxt().sendKeys(PWData.SignUp.PHONE);
		}

		thisDriver.findElementById(PWIDs.CarFinanceScreenIDs.BTN_SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.CarFinanceScreenIDs.BTN_APPLY_NOW)));
		thisDriver.navigate().back();
	}
}
