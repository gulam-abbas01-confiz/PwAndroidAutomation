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

public class SellYourPartScreenObject {
	// Object
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
	
	public static boolean userState = false;

	private RemoteWebDriver remoteWebDriver = null;
	// ============================================================================================================================================================//

	// Initialize Sell your bike Screen Objects
	public SellYourPartScreenObject(RemoteWebDriver remoteWebDriver) {
			this.remoteWebDriver = remoteWebDriver;
			PageFactory.initElements(remoteWebDriver, this);
		}

	// Getter
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
	public RemoteWebDriver getRemoteWebDriver() {
		return remoteWebDriver;
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
	public void setRemoteWebDriver(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
	}

	// ===========================================================================================================================================================//
	// Methods
	public void postAdWithoutPic() {
		try{
			System.out.println("Start Part Ad posting without image...");
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.HomeScreenIDs.BTN_PART_TAB);
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_PART_TAB).click();
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_SELL_FORM).click();
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.LLVIEW_CHOOSE_IMAGE);
			System.out.println("Start filling data...");
			fillDataInForm();
			System.out.println("Finish filling data.");
			NavigationHelper.afterAdPostingToHome(remoteWebDriver,userState,2);
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
			System.out.println("Part Ad without image has been posted successfully.");
			System.out.println("***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Parts Test case fail.******************************");
			System.out.println("***********************************************************************************");
			ex.printStackTrace();
		}
	}
	public void postAdWithPic() {
		try{
			System.out.println("Start Part Ad posting with image...");
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_PART_TAB).click();
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_SELL_FORM).click();
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.LLVIEW_CHOOSE_IMAGE);
			GenericHelper.takePictureFromEmulator(remoteWebDriver);
			fillDataInForm();
			NavigationHelper.afterAdPostingToHome(remoteWebDriver, userState,2);
			System.out.println("Part Ad with image has been posted successfully.");
			System.out.println("***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Parts Test case fail.******************************");
			ex.printStackTrace();
			System.out.println("***********************************************************************************");
		}
	}
	
	private void fillDataInForm(){
		try{
			//Select City
			GenericHelper.selectCityForSellForm(remoteWebDriver, cityTxt);

			// Select Part information
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY);
			WebElement partElement = remoteWebDriver.findElementById(PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY);
			partInfoTxt = partElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_PART_INFO));
			partInfoTxt.click();
			
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY_LIST);
			List<WebElement> yearList = remoteWebDriver.findElements(By.id(PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY_LIST));
			if(yearList.size() > 0){
				yearList.get(GenericHelper.randomIndex(yearList.size())).click();
				GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY);
				System.out.println("Part Information : " + partInfoTxt.getText().toString());
			}
			else{
				remoteWebDriver.navigate().back();
//				GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.MODULE_CATEGORY);
//				System.out.println("Part Information : " + partInfoTxt.getText().toString() + " , City Area : " +  "No City Area.");
			}
			
			//Title
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SellYourPartScreenIDs.MODULE_TITLE);
			WebElement titleElement = remoteWebDriver.findElement(By.id(PWIDs.SellYourPartScreenIDs.MODULE_TITLE));
			titleTxt = titleElement.findElement(By.id(PWIDs.SellYourPartScreenIDs.TXT_TITLE));
			titleTxt.clear();
			titleTxt.sendKeys(new String[] { "Automated Post" });
			
			//Price
			GenericHelper.selectPriceForSellForm(remoteWebDriver, priceTxt);

			//Description
			GenericHelper.selectDescriptionForSellForm(remoteWebDriver, descriptionTxt, "Accessory");

			//Personal Information
			GenericHelper.selectPersonalInfoForSellForm(remoteWebDriver, nameTxt, phoneTxt, userState);
			
			doneBtn.click();
			
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Parts Test case fail.******************************");
			ex.printStackTrace();
			System.out.println("***********************************************************************************");
		}
		
	}
}
