package com.pakwheels;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.helper.NavigationHelper;
import com.pakwheels.screenids.PWIDs;

import io.appium.java_client.android.AndroidDriver;

public class SellYourBikeScreenObject {
	// Object
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
	
	public static boolean userState = false;

	private AndroidDriver driver = null;
	// ============================================================================================================================================================//

	// Initialize Sell your bike Screen Objects
	public SellYourBikeScreenObject(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Getter
	public WebElement getDoneBtn() {
		return doneBtn;
	}public WebElement getChooseImageLlView() {
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
	public RemoteWebDriver getRemoteWebDriver() {
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
	public void setRemoteWebDriver(AndroidDriver driver) {
		this.driver = driver;
	}
}
