package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import pom.SellCarPageObject;

public class CarAdPostTest extends Base {

	@SuppressWarnings("rawtypes")
	private AndroidDriver thisDriver;
	private WebDriverWait thisWait;
	private SellCarPageObject obj;

	@BeforeTest
	private void init() throws Exception {
		super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new SellCarPageObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 300);
		PageFactory.initElements(thisDriver, obj);
	}

	@Test
	public void CarAdPost() {
		gotoSellForm();
		chooseCity();
		chooseCarMakeYear();
		chooseCarModel();
		chooseCarVersion();
		chooseRegCity();
		setMileage();
		chooseBodyColor();
		setDescription();
		setPrice();
		chooseEngineType();
		setEngineCapacity();
		chooseTransmissionAndAssembly();
		chooseFeature();
		setName();
		setPhoneNumber();
		submitAd();
		afterAdPostingToHome(false, 1);
	}

	@AfterTest
	public void tearDown() throws Exception {
		super.tearDown(thisDriver);
	}

	private void gotoSellForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SplashScreenIDs.BTN_CROSS)));
		thisDriver.findElementById(PWIDs.SplashScreenIDs.BTN_CROSS).click();
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_SELL_FORM).click();
	}

	private void chooseCity() {
		WebElement cityElement = driver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_CITY));
		obj.setCityTxt(cityElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_CITY)));
		obj.getCityTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> cityList = thisDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();

		thisDriver.navigate().back();
	}

	private void chooseCarMakeYear() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SellYourCarScreenIDs.MODULE_MAKE)));
		WebElement carElement = thisDriver.findElementById(PWIDs.SellYourCarScreenIDs.MODULE_MAKE);
		obj.setCarInfoTxt(carElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_CAR_INFO)));
		obj.getCarInfoTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> yearList = thisDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_MODEL));
		yearList.get(GenericHelper.randomIndex(yearList.size())).click();
	}

	private void chooseCarModel() {
		@SuppressWarnings("unchecked")
		List<WebElement> modelList = thisDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_MODEL));
		modelList.get(GenericHelper.randomIndex(modelList.size())).click();
	}

	private void chooseCarVersion() {
		@SuppressWarnings("unchecked")
		List<WebElement> versionList = thisDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_VERSION));
		if (versionList.size() > 0) {
			versionList.get(GenericHelper.randomIndex(versionList.size())).click();
		} else {
			thisDriver.navigate().back();
		}
	}

	private void chooseRegCity() {
		WebElement regCityElement = thisDriver.findElementById(PWIDs.SellYourCarScreenIDs.MODULE_REG_CITY);
		obj.setRegCityTxt(regCityElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_REG_CITY)));
		obj.getRegCityTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> regCityList = thisDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_REG_AREA));
		regCityList.get(GenericHelper.randomIndex(regCityList.size())).click();
	}

	private void setMileage() {
		WebElement milageElement = thisDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_MILAGE));
		obj.setMileageTxt(milageElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_MILAGE)));
		obj.getMileageTxt().clear();
		obj.getMileageTxt().sendKeys(GenericHelper.randomIndex(1, 999999));
	}

	private void chooseBodyColor() {
		WebElement bodyColorElement = thisDriver.findElementById(PWIDs.SellYourCarScreenIDs.MODULE_BODY_COLOR);
		obj.setBodyColorTxt(bodyColorElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_BODY_COLOR)));
		obj.getBodyColorTxt().click();
		driver.findElement(By.name("Black")).click();
	}

	private void setDescription() {
		WebElement descriptionElement = thisDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_DESCRIPTION));
		obj.setDescriptionTxt(descriptionElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_DESCRIPTION)));
		obj.getDescriptionTxt().clear();
		obj.getDescriptionTxt().sendKeys(PWData.AdDescription.carDescription);
	}

	private void setPrice() {
		WebElement priceElement = thisDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_PRICE));
		obj.setPriceTxt(priceElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_PRICE)));
		obj.getPriceTxt().clear();
		obj.getPriceTxt().sendKeys(GenericHelper.randomIndex(400000, 10000000));
	}

	private void chooseEngineType() {
		WebElement engTypeElement = thisDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_ENGINE_TYPE));
		obj.setEngineTypeTxt(engTypeElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_ENGINE_TYPE)));
		obj.getEngineTypeTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> engTypeList = thisDriver
				.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODUL_ENGINE_TYPE_LIST));
		engTypeList.get(GenericHelper.randomIndex(engTypeList.size())).click();
	}

	private void setEngineCapacity() {
		WebElement engineCapacityElement = thisDriver
				.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_ENGINE_CAPACITY));
		obj.setEngineCapacityTxt(
				engineCapacityElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_ENGINE_CAPACITY)));
		obj.getEngineCapacityTxt().clear();
		obj.getEngineCapacityTxt().sendKeys(GenericHelper.randomIndex(900, 2000));
	}

	private void chooseTransmissionAndAssembly() {
		@SuppressWarnings("unchecked")
		List<WebElement> assemblyCheckBoxList = thisDriver.findElements(By.className("android.widget.RadioButton"));
		assemblyCheckBoxList.get(0).click();
		assemblyCheckBoxList.get(3).click();
	}

	private void chooseFeature() {
		WebElement featureElement = thisDriver.findElement(By.id(PWIDs.SellYourCarScreenIDs.MODULE_FEATURES));
		obj.setFeaturesTxt(featureElement.findElement(By.id(PWIDs.SellYourCarScreenIDs.TXT_FEATURES)));
		if (obj.getFeaturesTxt().getText().trim().equals("Select Features")
				|| obj.getFeaturesTxt().getText().trim().equals("") || obj.getFeaturesTxt().getText().trim() == null) {
			obj.getFeaturesTxt().click();
			@SuppressWarnings("unchecked")
			List<WebElement> featureList = thisDriver.findElements(By.id("com.pakwheels:id/checkbx_features"));
			featureList.get(GenericHelper.randomIndex(featureList.size())).click();
			driver.findElementById(PWIDs.SellYourCarScreenIDs.BTN_TOP_FEATURE_DONE).click();
		}
	}

	private void setName() {
		WebElement nameElement = thisDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_NAME));
		obj.setNameTxt(nameElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_NAME)));
		obj.getNameTxt().clear();
		obj.getNameTxt().sendKeys(new String[] { "Testing Post" });
	}

	private void setPhoneNumber() {
		WebElement phoneElement = thisDriver.findElement(By.id(PWIDs.CarSureScreenIDs.MODULE_PHONE));
		obj.setPhoneTxt(phoneElement.findElement(By.id(PWIDs.CarSureScreenIDs.TXT_PHONE)));
		obj.getPhoneTxt().clear();
		obj.getPhoneTxt().sendKeys(PWData.SignUp.PHONE);
	}

	private void submitAd() {
		driver.findElementById(PWIDs.SellYourCarScreenIDs.BTN_DONE).click();
	}
}