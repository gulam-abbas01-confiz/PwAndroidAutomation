package com.pakwheels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.screenids.PWIDs;

public class HomeScreenObject {

	@FindBy(id = PWIDs.HomeScreenIDs.BTN_CAR_TAB)
	private WebElement carTab;

	@FindBy(id = PWIDs.HomeScreenIDs.BTN_BIKE_TAB)
	private WebElement bikeTab;
	
	@FindBy(id = PWIDs.HomeScreenIDs.BTN_PART_TAB)
	private WebElement partTab;
	
	@FindBy(id = PWIDs.HomeScreenIDs.BTN_MORE_TAB)
	private WebElement moreTab;
	
	// Initialize Home Screen Objects
	public HomeScreenObject(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(remoteWebDriver, this);

	}
	
	//Getter
	public WebElement getCarTab (){
		return carTab;
	}
	public WebElement getBikeTab (){
		return bikeTab;
	}
	public WebElement getPartsTab (){
		return partTab;
	}
	public WebElement getMoreTab (){
		return moreTab;
	}
	
	//Setter
	public void setCarTab(WebElement carTab){
		this.carTab = carTab;
	}
	public void setBikeTab(WebElement bikeTab){
		this.bikeTab = bikeTab;
	}
	public void setPartsTab(WebElement partsTab){
		this.partTab = partsTab;
	}
	public void setMoreTab(WebElement moreTab){
		this.moreTab = moreTab;
	}
	
}
