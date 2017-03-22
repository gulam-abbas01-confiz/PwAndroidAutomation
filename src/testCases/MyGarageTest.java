package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pakwheels.helper.GenericHelper;
import com.pakwheels.screenids.PWIDs;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pom.MyGaragePageObject;

public class MyGarageTest extends Base {
	@SuppressWarnings("rawtypes")
	private AndroidDriver thisDriver;
	private WebDriverWait thisWait;
	private MyGaragePageObject obj;
	
	public static final String coolRideNotes = "I was very pleased with the professionalism and reliability of this company. I was traveling to California for the first time with an infant and was very nervous about taking an Uber from the airport because I didn't want to take my baby in the car with a stranger,and so instead I wanted to use a proFessional car company that I could rely on. When I first called LA private car service the man I spoke to sounded so professional and so reliable that I immediately knew that this was going to be my choice.Isaac picked us up at the gate, The car was luxurious and the infant car seat was already installed for me! He transported us safely to my cousins house. He was very courteous and professional and I felt very safe. Reasonably priced for that type of peace of mind. I am a nervous new mom and knowing that he was picking me up put my mind at ease throughout the flight. I will definitely be using this company again.";

	@BeforeTest
	private void init() throws Exception {
		//super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new MyGaragePageObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 30);
		PageFactory.initElements(thisDriver, obj);
	}
	
	@Test
	public void myGarageTest(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SplashScreenIDs.BTN_CROSS)));
		thisDriver.findElementById(PWIDs.SplashScreenIDs.BTN_CROSS).click();
		gotoMyGarage();
		addNewRide();
		addNewServiceLog();
		deleteServiceLog();
		showOffYourRide();
		editRide();
		deleteRide();
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		super.tearDown(thisDriver);
	}
	
	private void gotoMyGarage(){
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
		thisDriver.findElementByName("My Garage").click();
	}

	@SuppressWarnings("unchecked")
	private void addNewRide() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.MyGarageScreenIDs.BTN_ADD_RIDE)));
		thisDriver.findElementById(PWIDs.MyGarageScreenIDs.BTN_ADD_RIDE).click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_TYPE).click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.CAR_RIDE).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_INFO).click();

		List<WebElement> yearList = thisDriver.findElements(By.id(PWIDs.AddRideScreenIDs.MODULE_YEAR));
		yearList.get(GenericHelper.randomIndex(yearList.size())).click();

		List<WebElement> modelList = thisDriver.findElements(By.id(PWIDs.AddRideScreenIDs.MODULE_MODEL));
		modelList.get(GenericHelper.randomIndex(modelList.size())).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.RB_KEEP_IT_PRIVATE).click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SUBMIT).click();
	}

	@SuppressWarnings("unchecked")
	private void addNewServiceLog() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG)));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.ET_SERVICE_DATE).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.ET_SERVICE_TYPE).click();

		List<WebElement> categoryList = thisDriver.findElements(By.className(PWIDs.AddRideScreenIDs.MODULE_SERVICE_CAT));
		categoryList.get(GenericHelper.randomIndex(categoryList.size())).click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CATEGORY).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.ET_COST).sendKeys(GenericHelper.randomIndex(500, 50000));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.ET_MILAGE).sendKeys(GenericHelper.randomIndex(1, 999999));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.ET_SERVICE_NOTE).sendKeys(new String[] { "Hello! This is testing service notes." });
		
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.ET_NEXT_SERVICE_DATE).click();
		List<WebElement> calendarList = thisDriver.findElements(By.className("android.widget.Button"));
		thisDriver.findElementByName(calendarList.get(5).getText()).click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SAVE_SERVICE_LOG).click();
	}

	private void showOffYourRide() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG)));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TV_MENU).click();
		thisDriver.findElementByName("SHOW OFF THIS RIDE").click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_ABOUT_COOL_RIDE).sendKeys(coolRideNotes);
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_NAME).sendKeys(new String[] { "Testing Ride" });
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_ENGINE_SIZE).sendKeys(GenericHelper.randomIndex(400, 2000));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_HORSE_POWER).sendKeys(GenericHelper.randomIndex(99, 999));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_TOP_SPEED).sendKeys(GenericHelper.randomIndex(100, 500));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_ACCELERATION).sendKeys(GenericHelper.randomIndex(6, 20));

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_NEXT).click();
		addPhoto();
	}

	private void addPhoto() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.BTN_ADD_PHOTO)));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_ADD_PHOTO).click();
		thisDriver.findElementByName(PWIDs.UploadPicutreIDs.TXT_AT_CHOICE_DIALOGE).click();
		thisDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_ALBUM).click();
		thisDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_IMAGE).click();
		thisDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_DONE).click();

		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF).click();
	}

	private void editRide() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.TV_MENU)));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TV_MENU).click();
		thisDriver.findElementByName("EDIT").click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_NAME).sendKeys(new String[] { "Testing Ride2" });
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_NEXT).click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.TV_MENU)));
	}

	private void deleteRide() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.TV_MENU)));
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.TV_MENU).click();
		thisDriver.findElementByName("DELETE RIDE").click();
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();
		thisDriver.navigate().back();
		thisDriver.navigate().back();
	}

	private void deleteServiceLog() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG)));
		
		TouchAction action = new TouchAction(thisDriver);
		action.longPress(thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_MILAGE)).perform();
		
		/*TouchActions obj = new TouchActions(thisDriver);
		obj.longPress(thisDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_MILAGE)).perform();*/
		thisDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DELETE_SERVICE_LOG).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG)));
	}
}
