package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class CarFinancePageObject {
	// Objects
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

	@SuppressWarnings("rawtypes")
	private AndroidDriver driver = null;

	// Initialize Sell your bike Screen Objects
	@SuppressWarnings("rawtypes")
	public CarFinancePageObject(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Getters
	public WebElement getCalculateBtn() {
		return calculateBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCarInfoTxt() {
		return carInfoTxt;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getPriceTxt() {
		return priceTxt;
	}

	public WebElement getTenureTxt() {
		return tenureTxt;
	}

	public WebElement getPercentageTxt() {
		return percentageTxt;
	}

	public WebElement getNameTxt() {
		return nameTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPhoneTxt() {
		return phoneTxt;
	}

	@SuppressWarnings("rawtypes")
	public AndroidDriver getAndroidDriver() {
		return driver;
	}

	// Setters

	public void setCalculateBtn(WebElement calculateBtn) {
		this.calculateBtn = calculateBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

	public void setCarInfoTxt(WebElement carInfoTxt) {
		this.carInfoTxt = carInfoTxt;
	}

	public void setCityTxt(WebElement cityTxt) {
		this.cityTxt = cityTxt;
	}

	public void setPriceTxt(WebElement priceTxt) {
		this.priceTxt = priceTxt;
	}

	public void setTenureTxt(WebElement tenureTxt) {
		this.tenureTxt = tenureTxt;
	}

	public void setPercentageTxt(WebElement percentageTxt) {
		this.percentageTxt = percentageTxt;
	}

	public void setNameTxt(WebElement nameTxt) {
		this.nameTxt = nameTxt;
	}

	public void setEmailTxt(WebElement emailTxt) {
		this.emailTxt = emailTxt;
	}

	public void setPhoneTxt(WebElement phoneTxt) {
		this.phoneTxt = phoneTxt;
	}

	@SuppressWarnings("rawtypes")
	public void setAndroidDriver(AndroidDriver driver) {
		this.driver = driver;
	}
}
