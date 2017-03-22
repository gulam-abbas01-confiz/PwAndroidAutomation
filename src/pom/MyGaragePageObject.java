package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class MyGaragePageObject {
	// Objects
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

	@FindBy(id = PWIDs.AddRideScreenIDs.CAR_RIDE)
	private WebElement carRideET;

	@FindBy(id = PWIDs.AddRideScreenIDs.BIKE_RIDE)
	private WebElement bikeRideET;

	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_ADD_NEW_SERVICE_LOG)
	private WebElement addNewServiceLogBtn;

	@FindBy(id = PWIDs.AddRideScreenIDs.ET_SERVICE_DATE)
	private WebElement serviceDateET;

	@FindBy(id = PWIDs.AddRideScreenIDs.ET_SERVICE_TYPE)
	private WebElement serviceTypeET;

	@FindBy(id = PWIDs.AddRideScreenIDs.ET_COST)
	private WebElement costET;

	@FindBy(id = PWIDs.AddRideScreenIDs.ET_MILAGE)
	private WebElement milageET;

	@FindBy(id = PWIDs.AddRideScreenIDs.ET_SERVICE_NOTE)
	private WebElement serviceNoteET;

	@FindBy(id = PWIDs.AddRideScreenIDs.ET_NEXT_SERVICE_DATE)
	private WebElement nextServiceDateET;

	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_SAVE_SERVICE_LOG)
	private WebElement saveServiceLogBtn;

	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_ADD_PHOTO)
	private WebElement addPhotoBtn;

	@FindBy(id = PWIDs.AddRideScreenIDs.TV_MENU)
	private WebElement menuTV;

	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF)
	private WebElement submitShowOffBtn;

	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_SUBMIT_SHOW_OFF)
	private WebElement milageServiceLogTxt;

	@FindBy(id = PWIDs.AddRideScreenIDs.BTN_DELETE_SERVICE_LOG)
	private WebElement deleteServiceLogBtn;

	@SuppressWarnings("rawtypes")
	private AndroidDriver driver = null;

	
	
	// Initialize Sell your car Screen Objects
	@SuppressWarnings("rawtypes")
	public MyGaragePageObject(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Getter
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

	@SuppressWarnings("rawtypes")
	public AndroidDriver getAndroidDriver() {
		return driver;
	}

	// Setter
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

	@SuppressWarnings("rawtypes")
	public void setAndroidDriver(AndroidDriver driver) {
		this.driver = driver;
	}

	public void setCarRideET(WebElement carRideET) {
		this.carRideET = carRideET;
	}

	public void setBikeRideET(WebElement bikeRideET) {
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
}
