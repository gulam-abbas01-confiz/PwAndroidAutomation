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
import pom.SellBikePageObject;

public class BikeAdPostTest extends Base {

	@SuppressWarnings("rawtypes")
	private AndroidDriver thisDriver;
	private WebDriverWait thisWait;
	private SellBikePageObject obj;

	@BeforeTest
	private void init() throws Exception {
		super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new SellBikePageObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 300);
		PageFactory.initElements(thisDriver, obj);
	}

	@Test
	public void BikeAdPost() {
		gotoSellForm();
		chooseCity();
		chooseBikeMakeYear();
		chooseBikeModel();
		setPrice();
		chooseRegCity();
		setMileage();
		chooseEngineType();
		setDescription();
		chooseFeature();
		setName();
		setPhoneNumber();
		submitAd();
		afterAdPostingToHome(false, 2);
	}

	@AfterTest
	public void tearDown() throws Exception {
		super.tearDown(thisDriver);
	}

	private void gotoSellForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SplashScreenIDs.BTN_CROSS)));
		thisDriver.findElementById(PWIDs.SplashScreenIDs.BTN_CROSS).click();
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_BIKE_TAB).click();
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_SELL_FORM).click();
	}

	private void chooseCity() {
		WebElement cityElement = thisDriver.findElement(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_CITY));
		obj.setCityTxt(cityElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_CITY)));
		obj.getCityTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> cityList = thisDriver.findElements(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();

		thisDriver.navigate().back();
	}

	private void chooseBikeMakeYear() {
		WebElement bikeElement = thisDriver.findElementById(PWIDs.SellYourBikeScreenIDs.MODULE_MAKE);
		obj.setBikeInfoTxt(bikeElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_BIKE_INFO)));
		obj.getBikeInfoTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> yearList = thisDriver.findElements(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_MODEL));
		yearList.get(GenericHelper.randomIndex(yearList.size())).click();
	}

	private void chooseBikeModel() {
		@SuppressWarnings("unchecked")
		List<WebElement> versionList = thisDriver.findElements(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_VERSION));
		if (versionList.size() > 0) {
			versionList.get(GenericHelper.randomIndex(versionList.size())).click();
		} else {
			driver.navigate().back();
		}
	}

	private void setPrice() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_PRICE)));
		WebElement priceElement = thisDriver.findElement(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_PRICE));
		obj.setPriceTxt(priceElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_PRICE)));
		obj.getPriceTxt().clear();
		obj.getPriceTxt().sendKeys(GenericHelper.randomIndex(400000, 10000000));
	}

	private void chooseRegCity() {
		WebElement regCityElement = thisDriver.findElementById(PWIDs.SellYourBikeScreenIDs.MODULE_REG_CITY);
		obj.setRegCityTxt(regCityElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_REG_CITY)));
		obj.getRegCityTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> regCityList = thisDriver.findElements(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_REG_AREA));
		regCityList.get(GenericHelper.randomIndex(regCityList.size())).click();
	}

	private void setMileage() {
		WebElement milageElement = thisDriver.findElement(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_MILAGE));
		obj.setMileageTxt(milageElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_MILAGE)));
		obj.getMileageTxt().clear();
		obj.getMileageTxt().sendKeys(GenericHelper.randomIndex(1, 999999));
	}

	private void chooseEngineType() {
		WebElement engTypeElement = thisDriver.findElementById(PWIDs.SellYourBikeScreenIDs.MODULE_ENGINE_TYPE);
		obj.setEngineTypeTxt(engTypeElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_ENGINE_TYPE)));
		obj.getEngineTypeTxt().click();
		@SuppressWarnings("unchecked")
		List<WebElement> typeList = thisDriver.findElements(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_ENG_TYPE_LIST));
		typeList.get(1).click();
	}

	private void setDescription() {
		WebElement descriptionElement = thisDriver.findElement(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_DESCRIPTION));
		obj.setDescriptionTxt(descriptionElement.findElement(By.id(PWIDs.SellYourBikeScreenIDs.TXT_DESCRIPTION)));
		obj.getDescriptionTxt().clear();
		obj.getDescriptionTxt().sendKeys(PWData.AdDescription.carDescription);
	}

	private void chooseFeature() {
		@SuppressWarnings("unchecked")
		List<WebElement> featureList = thisDriver.findElements(By.id(PWIDs.SellYourBikeScreenIDs.MODULE_FEATURE));
		featureList.get(0).click();
		featureList.get(2).click();
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
		driver.findElementById(PWIDs.SellYourBikeScreenIDs.BTN_DONE).click();
	}
}
