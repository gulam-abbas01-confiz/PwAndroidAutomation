package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class SellPartPageObject {
	//Objects
	@FindBy(id = PWIDs.SellYourPartScreenIDs.BTN_DONE)
	private WebElement doneBtn;
	@FindBy(id = PWIDs.SellYourPartScreenIDs.LLVIEW_CHOOSE_IMAGE)
	private WebElement chooseImageLlView;
	private WebElement cityTxt;
	private WebElement partInfoTxt;
	private WebElement titleTxt;
	private WebElement priceTxt;
	private WebElement descriptionTxt;
	private WebElement nameTxt;
	private WebElement emailTxt;
	private WebElement phoneTxt;
	@SuppressWarnings("rawtypes")
	private AndroidDriver driver = null;
	

	//Initialize Sell your car Screen Objects
	@SuppressWarnings("rawtypes")
	public SellPartPageObject(AndroidDriver driver) {
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

	public WebElement getPartInfoTxt() {
		return partInfoTxt;
	}

	public WebElement getTitleTxt() {
		return titleTxt;
	}

	public WebElement getPriceTxt() {
		return priceTxt;
	}

	public WebElement getDescriptionTxt() {
		return descriptionTxt;
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

	//Setter
	public void setDoneBtn(WebElement doneBtn) {
		this.doneBtn = doneBtn;
	}

	public void setChooseImageLlView(WebElement chooseImageLlView) {
		this.chooseImageLlView = chooseImageLlView;
	}

	public void setCityTxt(WebElement cityTxt) {
		this.cityTxt = cityTxt;
	}

	public void setPartInfoTxt(WebElement partInfoTxt) {
		this.partInfoTxt = partInfoTxt;
	}

	public void setTitleTxt(WebElement titleTxt) {
		this.titleTxt = titleTxt;
	}

	public void setPriceTxt(WebElement priceTxt) {
		this.priceTxt = priceTxt;
	}

	public void setDescriptionTxt(WebElement descriptionTxt) {
		this.descriptionTxt = descriptionTxt;
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
