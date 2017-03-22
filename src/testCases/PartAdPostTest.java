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
import pom.SellPartPageObject;

public class PartAdPostTest extends Base {

	@SuppressWarnings("rawtypes")
	private AndroidDriver thisDriver;
	private WebDriverWait thisWait;
	private SellPartPageObject obj;

	@BeforeTest
	private void init() throws Exception {
		super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new SellPartPageObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 300);
		PageFactory.initElements(thisDriver, obj);
	}

	@Test
	public void PartAdPost() {
		gotoSellForm();
		chooseCity();
		chooseCategory();
		setTitle();
		setPrice();
		setDescription();
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
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_PART_TAB).click();
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_SELL_FORM).click();
	}

	private void chooseCity() {
		WebElement cityElement = thisDriver.findElement(By.id(PWIDs.SellYourPartScreenIDs.MODULE_CITY));
		obj.setCityTxt(cityElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_CITY)));
		obj.getCityTxt().click();

		@SuppressWarnings("unchecked")
		List<WebElement> cityList = thisDriver.findElements(By.id(PWIDs.SellYourPartScreenIDs.MODULE_CITY_AREA));
		cityList.get(GenericHelper.randomIndex(cityList.size())).click();

		thisDriver.navigate().back();
	}

	private void chooseCategory() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY)));
		WebElement partElement = thisDriver.findElementById(PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY);
		obj.setPartInfoTxt(partElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_PART_INFO)));
		obj.getPartInfoTxt().click();

		GenericHelper.waitForElement(thisDriver, PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY_LIST);
		@SuppressWarnings("unchecked")
		List<WebElement> yearList = thisDriver.findElements(By.id(PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY_LIST));
		if (yearList.size() > 0) {
			yearList.get(GenericHelper.randomIndex(yearList.size())).click();
		} else {
			thisDriver.navigate().back();
		}
	}

	private void setTitle() {
		WebElement titleElement = thisDriver.findElement(By.id(PWIDs.SellYourPartScreenIDs.MODULE_TITLE));
		obj.setTitleTxt(titleElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_TITLE)));
		obj.getTitleTxt().clear();
		obj.getTitleTxt().sendKeys(new String[] { "Automated Post" });
	}

	private void setPrice() {
		WebElement priceElement = thisDriver.findElement(By.id(PWIDs.SellYourPartScreenIDs.MODULE_PRICE));
		obj.setPriceTxt(priceElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_PRICE)));
		obj.getPriceTxt().clear();
		obj.getPriceTxt().sendKeys(GenericHelper.randomIndex(400000, 10000000));
	}

	private void setDescription() {
		WebElement descriptionElement = thisDriver.findElement(By.id(PWIDs.SellYourPartScreenIDs.MODULE_DESCRIPTION));
		obj.setDescriptionTxt(descriptionElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_DESCRIPTION)));
		obj.getDescriptionTxt().clear();
		obj.getDescriptionTxt().sendKeys(PWData.AdDescription.carDescription);
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
		driver.findElementById(PWIDs.SellYourPartScreenIDs.BTN_DONE).click();
	}
}
