package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class SellBikePageObject {
	//Objects
	@FindBy(id = PWIDs.SellYourBikeScreenIDs.BTN_DONE)
	private WebElement doneBtn;
	@FindBy(id = PWIDs.SellYourBikeScreenIDs.LLVIEW_CHOOSE_IMAGE)
	private WebElement chooseImageLlView;
	private WebElement cityTxt;
	private WebElement bikeInfoTxt;
	private WebElement priceTxt;
	private WebElement regCityTxt;
	private WebElement mileageTxt;
	private WebElement engineTypeTxt;
	private WebElement descriptionTxt;
	private WebElement featureTxt;
	private WebElement nameTxt;
	private WebElement emailTxt;
	private WebElement phoneTxt;
	@SuppressWarnings("rawtypes")
	private AndroidDriver driver = null;
	

	//Initialize Sell your bike Screen Objects
	@SuppressWarnings("rawtypes")
	public SellBikePageObject(AndroidDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	//Getter
	public WebElement getDoneBtn() {
		return doneBtn;
	}

	public WebElement getChooseImageLlView() {
		return chooseImageLlView;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getBikeInfoTxt() {
		return bikeInfoTxt;
	}

	public WebElement getPriceTxt() {
		return priceTxt;
	}

	public WebElement getRegCityTxt() {
		return regCityTxt;
	}

	public WebElement getMileageTxt() {
		return mileageTxt;
	}

	public WebElement getEngineTypeTxt() {
		return engineTypeTxt;
	}

	public WebElement getDescriptionTxt() {
		return descriptionTxt;
	}

	public WebElement getFeatureTxt() {
		return featureTxt;
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

	// Setter
	public void setDoneBtn(WebElement doneBtn) {
		this.doneBtn = doneBtn;
	}

	public void setChooseImageLlView(WebElement chooseImageLlView) {
		this.chooseImageLlView = chooseImageLlView;
	}

	public void setCityTxt(WebElement cityTxt) {
		this.cityTxt = cityTxt;
	}

	public void setBikeInfoTxt(WebElement bikeInfoTxt) {
		this.bikeInfoTxt = bikeInfoTxt;
	}

	public void setPriceTxt(WebElement priceTxt) {
		this.priceTxt = priceTxt;
	}

	public void setRegCityTxt(WebElement regCityTxt) {
		this.regCityTxt = regCityTxt;
	}

	public void setMileageTxt(WebElement mileageTxt) {
		this.mileageTxt = mileageTxt;
	}

	public void setEngineTypeTxt(WebElement engineTypeTxt) {
		this.engineTypeTxt = engineTypeTxt;
	}

	public void setDescriptionTxt(WebElement descriptionTxt) {
		this.descriptionTxt = descriptionTxt;
	}

	public void setFeatureTxt(WebElement featureTxt) {
		this.featureTxt = featureTxt;
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
