package com.pakwheels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.helper.GenericHelper;
import com.pakwheels.helper.NavigationHelper;
import com.pakwheels.screenids.PWIDs;

public class AddRideScreenObject {
	// Object
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_RIDE_TYPE)
	private WebElement rideTypeTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_RIDE_INFO)
	private WebElement rideInfoTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.RB_SHOW_OFF_RIDE)
	private WebElement showOffMyRideRB;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.RB_KEEP_IT_PRIVATE)
	private WebElement keepItPrivateRB;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_SUBMIT)
	private WebElement submitBtn;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_NEXT)
	private WebElement nextBtn;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_ABOUT_COOL_RIDE)
	private WebElement aboutCoolRideTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_RIDE_NAME)
	private WebElement rideNameTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_ENGINE_SIZE)
	private WebElement engineSizeTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_HORSE_POWER)
	private WebElement horsePowerTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_TOP_SPEED)
	private WebElement topSpeedTxt;
	
	@FindBy(id = PWIDs.AddRideScreenIDs.TXT_ACCELERATION)
	private WebElement accelerationTxt;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.CAR_RIDE )
	private WebElement carRideET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BIKE_RIDE )
	private WebElement bikeRideET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG )
	private WebElement addNewServiceLogBtn ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.ET_SERVICE_DATE )
	private WebElement serviceDateET ;
	
	@FindBy (id =PWIDs.AddRideScreenIDs.ET_SERVICE_TYPE )
	private WebElement serviceTypeET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.ET_COST )
	private WebElement costET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.ET_MILAGE )
	private WebElement milageET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.ET_SERVICE_NOTE )
	private WebElement serviceNoteET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.ET_NEXT_SERVICE_DATE )
	private WebElement nextServiceDateET ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BTN_SAVE_SERVICE_LOG )
	private WebElement saveServiceLogBtn ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BTN_ADD_PHOTO )
	private WebElement addPhotoBtn ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.TV_MENU )
	private WebElement menuTV ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF )
	private WebElement submitShowOffBtn ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF )
	private WebElement milageServiceLogTxt ;
	
	@FindBy (id = PWIDs.AddRideScreenIDs.BTN_DELETE_SERVICE_LOG )
	private WebElement deleteServiceLogBtn ;
	
	public static final String coolRideNotes = "I was very pleased with the professionalism and reliability of this company. I was traveling to California for the first time with an infant and was very nervous about taking an Uber from the airport because I didn't want to take my baby in the car with a stranger,and so instead I wanted to use a proFessional car company that I could rely on. When I first called LA private car service the man I spoke to sounded so professional and so reliable that I immediately knew that this was going to be my choice.Isaac picked us up at the gate, The car was luxurious and the infant car seat was already installed for me! He transported us safely to my cousins house. He was very courteous and professional and I felt very safe. Reasonably priced for that type of peace of mind. I am a nervous new mom and knowing that he was picking me up put my mind at ease throughout the flight. I will definitely be using this company again.";

	private RemoteWebDriver remoteWebDriver = null;	
	//============================================================================================================================================================//
	
	//Initialize Sell your car Screen Objects
	public AddRideScreenObject(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
	}

	//Getter
	public WebElement getRideTypeTxt() {
		return rideTypeTxt;
	}
	public WebElement getRideInfoTxt() {
		return rideInfoTxt;
	}
	public WebElement getShowOffMyRideRB() {
		return showOffMyRideRB;
	}
	public WebElement getKeepItPrivateRB() {
		return keepItPrivateRB;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getNextBtn() {
		return nextBtn;
	}
	public WebElement getAboutCoolRideTxt() {
		return aboutCoolRideTxt;
	}
	public WebElement getEngineSizeTxt() {
		return engineSizeTxt;
	}
	public WebElement getRideNameTxt() {
		return rideNameTxt;
	}
	public WebElement getHorsePowerTxt() {
		return horsePowerTxt;
	}
	public WebElement getTopSpeedTxt() {
		return topSpeedTxt;
	}
	public WebElement getAccelerationTxt() {
		return accelerationTxt;
	}
	public WebElement getCarRideET() {
		return carRideET;
	}
	public WebElement getBikeRideET() {
		return bikeRideET;
	}
	public WebElement getAddNewServiceLogBtn() {
		return addNewServiceLogBtn;
	}
	public WebElement getServiceDateET() {
		return serviceDateET;
	}
	public WebElement getServiceTypeET() {
		return serviceTypeET;
	}
	public WebElement getCostET() {
		return costET;
	}
	public WebElement getMilageET() {
		return milageET;
	}
	public WebElement getServiceNoteET() {
		return serviceNoteET;
	}
	public WebElement getNextServiceDateET() {
		return nextServiceDateET;
	}
	public WebElement getSaveServiceLogBtn() {
		return saveServiceLogBtn;
	}
	public WebElement getAddPhotoBtn() {
		return addPhotoBtn;
	}
	public WebElement getMenuTV() {
		return menuTV;
	}
	public WebElement getSubmitShowOffBtn() {
		return submitShowOffBtn;
	}
	public WebElement getMilageServiceLogTxt() {
		return milageServiceLogTxt;
	}
	public WebElement getDeleteServiceLogBtn() {
		return deleteServiceLogBtn;
	}
	public RemoteWebDriver getRemoteWebDriver() {
		return remoteWebDriver;
	}
	
	//Setter
	public void setRideTypeTxt(WebElement rideTypeTxt) {
		this.rideTypeTxt = rideTypeTxt;
	}
	public void setRideInfoTxt(WebElement rideInfoTxt) {
		this.rideInfoTxt = rideInfoTxt;
	}
	public void setShowOffMyRideRB(WebElement showOffMyRideRB) {
		this.showOffMyRideRB = showOffMyRideRB;
	}
	public void setKeepItPrivateRB(WebElement keepItPrivateRB) {
		this.keepItPrivateRB = keepItPrivateRB;
	}
	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}
	public void setNextBtn(WebElement nextBtn) {
		this.nextBtn = nextBtn;
	}
	public void setAboutCoolRideTxt(WebElement aboutCoolRideTxt) {
		this.aboutCoolRideTxt = aboutCoolRideTxt;
	}
	public void setRideNameTxt(WebElement rideNameTxt) {
		this.rideNameTxt = rideNameTxt;
	}
	public void setEngineSizeTxt(WebElement engineSizeTxt) {
		this.engineSizeTxt = engineSizeTxt;
	}
	public void setHorsePowerTxt(WebElement horsePowerTxt) {
		this.horsePowerTxt = horsePowerTxt;
	}
	public void setTopSpeedTxt(WebElement topSpeedTxt) {
		this.topSpeedTxt = topSpeedTxt;
	}
	public void setAccelerationTxt(WebElement accelerationTxt) {
		this.accelerationTxt = accelerationTxt;
	}
	public void setRemoteWebDriver(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
	}
	public void setCarRideET(WebElement carRideET) {
		this.carRideET = carRideET;
	}public void setBikeRideET(WebElement bikeRideET) {
		this.bikeRideET = bikeRideET;
	}
	public void setAddNewServiceLogBtn(WebElement addNewServiceLogBtn) {
		this.addNewServiceLogBtn = addNewServiceLogBtn;
	}
	public void setServiceDateET(WebElement serviceDateET) {
		this.serviceDateET = serviceDateET;
	}
	public void setServiceTypeET(WebElement serviceTypeET) {
		this.serviceTypeET = serviceTypeET;
	}
	public void setCostET(WebElement costET) {
		this.costET = costET;
	}
	public void setMilageET(WebElement milageET) {
		this.milageET = milageET;
	}
	public void setServiceNoteET(WebElement serviceNoteET) {
		this.serviceNoteET = serviceNoteET;
	}
	public void setSaveServiceLogBtn(WebElement saveServiceLogBtn) {
		this.saveServiceLogBtn = saveServiceLogBtn;
	}
	public void setAddPhotoBtn(WebElement addPhotoBtn) {
		this.addPhotoBtn = addPhotoBtn;
	}
	public void setMenu_TV(WebElement menuTV) {
		this.menuTV = menuTV;
	}
	public void setSubmitShowOffBtn(WebElement submitShowOffBtn) {
		this.submitShowOffBtn = submitShowOffBtn;
	}
	public void setMilageServiceLogTxt(WebElement milageServiceLogTxt) {
		this.milageServiceLogTxt = milageServiceLogTxt;
	}
	public void setDeleteServiceLogBtn(WebElement deleteServiceLogBtn) {
		this.deleteServiceLogBtn = deleteServiceLogBtn;
	}
	
	public void setNextServiceDateET(WebElement nextServiceDateET) {
		this.nextServiceDateET = nextServiceDateET;
	}
	
	public void addRide(){
		
		try{
			System.out.println("		* My Garage functionality is starting up... *");
			NavigationHelper.homeToMyGarageScreen(remoteWebDriver);
			addNewRide();
			addNewServiceLog();
			deleteServiceLog();
			showOffYourRide();
			editRide();
			deleteRide();
			remoteWebDriver.navigate().back();
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
			System.out.println("         * My Garage functionality has been updated successfully. *");
			System.out.println("***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
	}
	
	private void addNewRide(){
		//Tap ADD RIDE Button
		System.out.println("Start Adding new ride...");
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.MyGarageScreenIDs.BTN_ADD_RIDE);
		remoteWebDriver.findElementById(PWIDs.MyGarageScreenIDs.BTN_ADD_RIDE).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_TYPE).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.CAR_RIDE).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_INFO).click();
		
		List<WebElement>yearList = remoteWebDriver.findElements(By.id(PWIDs.AddRideScreenIDs.MODULE_YEAR));
		yearList.get(GenericHelper.randomIndex(yearList.size())).click();
		
		List<WebElement>modelList = remoteWebDriver.findElements(By.id(PWIDs.AddRideScreenIDs.MODULE_MODEL));
		modelList.get(GenericHelper.randomIndex(modelList.size())).click();

		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.RB_KEEP_IT_PRIVATE).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SUBMIT).click();
		System.out.println("New Ride has been added successfully.");
		System.out.println("***********************************************************************************");
	}
	private void addNewServiceLog(){
		System.out.println("Start Adding new service log...");
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG);
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.ET_SERVICE_DATE).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.ET_SERVICE_TYPE).click();
		
		List<WebElement>categoryList = remoteWebDriver.findElements(By.className(PWIDs.AddRideScreenIDs.MODULE_SERVICE_CAT));
		categoryList.get(GenericHelper.randomIndex(categoryList.size())).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CATEGORY).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.ET_COST).sendKeys(GenericHelper.randomIndex(500, 50000));
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.ET_MILAGE).sendKeys(GenericHelper.randomIndex(1, 999999));;
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.ET_SERVICE_NOTE).sendKeys(new String[] { "Hello! This is testing service notes." });;
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.ET_NEXT_SERVICE_DATE).click();
		List<WebElement> calendarList = remoteWebDriver.findElements(By.className("android.widget.Button"));
		remoteWebDriver.findElementByName(calendarList.get(5).getText()).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SAVE_SERVICE_LOG).click();
		System.out.println("New Service log has been added successfully.");
		System.out.println("***********************************************************************************");
	}
	private void showOffYourRide(){
		System.out.println("Start Showing off ride...");
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG);
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TV_MENU).click();
		remoteWebDriver.findElementByName("SHOW OFF THIS RIDE").click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_ABOUT_COOL_RIDE).sendKeys(coolRideNotes);
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_NAME).sendKeys(new String[] {"Testing Ride"});
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_ENGINE_SIZE).sendKeys(GenericHelper.randomIndex(400, 2000));
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_HORSE_POWER).sendKeys(GenericHelper.randomIndex(99, 999));
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_TOP_SPEED).sendKeys(GenericHelper.randomIndex(100, 500));
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_ACCELERATION).sendKeys(GenericHelper.randomIndex(6, 20));
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_NEXT).click();
		addPhoto();
		System.out.println("Ride has been showed up successfully.");
		System.out.println("***********************************************************************************");
	}
	private void addPhoto(){
		//Make things to Upload pictures.
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.BTN_ADD_PHOTO);
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_ADD_PHOTO).click();
		remoteWebDriver.findElementByName(PWIDs.UploadPicutreIDs.TXT_AT_CHOICE_DIALOGE).click();
		remoteWebDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_ALBUM).click();
		remoteWebDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_IMAGE).click();
		remoteWebDriver.findElementById(PWIDs.UploadPicutreIDs.BTN_DONE).click();
		
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF).click();
	}
	private void editRide(){
		System.out.println("Start Ride editing...");
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.TV_MENU);
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TV_MENU).click();
		remoteWebDriver.findElementByName("EDIT").click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_RIDE_NAME).sendKeys(new String[] {"Testing Ride2"});
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_NEXT).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF).click();
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.TV_MENU);
		System.out.println("Ride has been edited successfully.");
		System.out.println("***********************************************************************************");
	}
	private void deleteRide(){
		System.out.println("Start Ride Deleting...");
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.TV_MENU);
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TV_MENU).click();
		remoteWebDriver.findElementByName("DELETE RIDE").click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();
		remoteWebDriver.navigate().back();
		remoteWebDriver.navigate().back();
		System.out.println("Ride has been deleted successfully.");
		System.out.println("***********************************************************************************");
	}
	private void deleteServiceLog(){
		System.out.println("Start deleting service log...");
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG);
		TouchActions obj = new TouchActions(remoteWebDriver);
		obj.longPress(remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.TXT_MILAGE)).perform();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DELETE_SERVICE_LOG).click();
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG);
		System.out.println("Service log has been deleted successfully.");
		System.out.println("***********************************************************************************");
	}
}
