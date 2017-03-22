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

public class SellYourCarScreenObject {
	// Object
	@FindBy(id = PWIDs.SellYourCarScreenIDs.BTN_DONE)
	private WebElement doneBtn;

	@FindBy(id = PWIDs.SellYourCarScreenIDs.LLVIEW_CHOOSE_IMAGE)
	private WebElement chooseImageLlView;
	
	private WebElement cityTxt;
	private WebElement carInfoTxt;
	private WebElement regCityTxt;
	private WebElement mileageTxt;
	private WebElement bodyColorTxt;
	private WebElement descriptionTxt;
	private WebElement engineTypeTxt;
	private WebElement engineCapacityTxt;
	private WebElement featuresTxt;
	private WebElement priceTxt;
	private WebElement nameTxt;
	private WebElement emailTxt;
	private WebElement phoneTxt;
	
	public static boolean userState = false;

	private AndroidDriver driver = null;	
	//============================================================================================================================================================//
	
	//Initialize Sell your car Screen Objects
	public SellYourCarScreenObject(AndroidDriver driver) {
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
	public WebElement getCarInfoTxt() {
		return carInfoTxt;
	}
	public WebElement getRegCityTxt() {
		return regCityTxt;
	}
	public WebElement getMileageTxt() {
		return mileageTxt;
	}
	public WebElement getBodyColorTxt() {
		return bodyColorTxt;
	}
	public WebElement getDescriptionTxt() {
		return descriptionTxt;
	}
	public WebElement getPriceTxt() {
		return priceTxt;
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
	public WebElement getEngineTypeTxt() {
		return engineTypeTxt;
	}
	public WebElement getEngineCapacityTxt() {
		return engineCapacityTxt;
	}
	public WebElement getFeaturesTxt() {
		return featuresTxt;
	}

	public RemoteWebDriver getRemoteWebDriver() {
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
	public void setCarInfoTxt(WebElement carInfoTxt) {
		this.carInfoTxt = carInfoTxt;
	}
	public void setRegCityTxt(WebElement regCityTxt) {
		this.regCityTxt = regCityTxt;
	}
	public void setMileageTxt(WebElement mileageTxt) {
		this.mileageTxt = mileageTxt;
	}
	public void setBodyColorTxt(WebElement bodyColorTxt) {
		this.bodyColorTxt = bodyColorTxt;
	}
	public void setDescriptionTxt(WebElement descriptionTxt) {
		this.descriptionTxt = descriptionTxt;
	}
	public void setPriceTxt(WebElement priceTxt) {
		this.priceTxt = priceTxt;
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
	public void setEngineTypeTxt(WebElement engineTypeTxt) {
		this.engineTypeTxt = engineTypeTxt;
	}
	public void setEngineCapacityTxt(WebElement engineCapacityTxt) {
		this.engineCapacityTxt = engineCapacityTxt;
	}
	public void setFeaturesTxt(WebElement featuresTxt) {
		this.featuresTxt = featuresTxt;
	}
	
	public void setRemoteWebDriver(AndroidDriver driver) {
		this.driver = driver;
	}
}
