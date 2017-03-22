package com.pakwheels;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.DDT.PWData;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.helper.NavigationHelper;
import com.pakwheels.screenids.PWIDs;

public class MyProfileScreenObject {
	// Object
	@FindBy(id = PWIDs.MyProfileScreenIDs.BTN_DONE)
	private WebElement doneBtn;

	@FindBy(id = PWIDs.MyProfileScreenIDs.IV_PROFILE_PIC)
	private WebElement profilePictureIV;
	
	@FindBy(id = PWIDs.MyProfileScreenIDs.S_PROFILE)
	private WebElement profileSection;
	
	//Change password
	private WebElement oldPwdTxt;
	private WebElement newPwdTxt;
	private WebElement confirmPwdTxt;
	
	@FindBy(id = PWIDs.ForgetPasswordScreenIDs.BTN_DONE)
	private WebElement savePwdBtn;

	private RemoteWebDriver remoteWebDriver = null;

	// ============================================================================================================================================================//

	// Initialize Sell your bike Screen Objects
	public MyProfileScreenObject(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
	}

	// Getter
	public WebElement getDoneBtn() {
		return doneBtn;
	}
	public WebElement getProfileSection() {
		return profileSection;
	}
	public WebElement getOldPwdTxt() {
		return oldPwdTxt;
	}
	public WebElement getNewPwdTxt() {
		return newPwdTxt;
	}
	public WebElement getConfirmPwdTxt() {
		return confirmPwdTxt;
	}
	public RemoteWebDriver getRemoteWebDriver() {
		return remoteWebDriver;
	}
	
	// Setter
	public void setDoneBtn(WebElement doneBtn) {
		this.doneBtn = doneBtn;
	}
	public void setProfileSection(WebElement profileSection) {
		this.profileSection = profileSection;
	}
	public void setOldPwdTxt(WebElement oldPwdTxt) {
		this.oldPwdTxt = oldPwdTxt;
	}
	public void setConfirmPwdTxt(WebElement confirmPwdTxt) {
		this.confirmPwdTxt = confirmPwdTxt;
	}
	public void setNewPwdTxt(WebElement newPwdTxt) {
		this.newPwdTxt = newPwdTxt;
	}
	public void setRemoteWebDriver(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
	}

	// ===========================================================================================================================================================//
	// Methods
	public void editProfile(){
		
		try{
			System.out.println("Start Profile editing...");
			NavigationHelper.homeToMyProfileScreen(remoteWebDriver);
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.MyProfileScreenIDs.S_PROFILE);
			remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.S_PROFILE).click();
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.MyProfileScreenIDs.BTN_DONE);
			
			changeDisplayName();
			changeEmail();
			changeLocation();
			changeDOB();
			changePassword();
			
			remoteWebDriver.navigate().back();
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
			System.out.println("Profile has been updated successfully.");
			System.out.println("***********************************************************************************");
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
		
		
		
	}
	private void changeDisplayName(){
		String oldName = remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TXT_DISPLAY_NAME).getText().trim();
		oldName = oldName + " New";
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TXT_DISPLAY_NAME).clear();
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TXT_DISPLAY_NAME).sendKeys(oldName);
		commonOperationAfterDone();
		System.out.println("Display Name is updated.");
	}
	/*private void changePicture(){
		remoteWebDriver.findElementById(PWIDs.MyProfileIDs.IV_PROFILE_PIC).click();
		remoteWebDriver.findElementByName("Select a Photo").click();
		
	}*/
	private void changeDOB(){
		//Change DOB
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_DOB).click();
		List<WebElement> calendarList = remoteWebDriver.findElements(By.className("android.widget.Button"));
		
		remoteWebDriver.findElementByName(calendarList.get(5).getText()).click();
		remoteWebDriver.findElementById(PWIDs.AddRideScreenIDs.BTN_DONE_CALENDAR).click();
		
		commonOperationAfterDone();
		//save DOB
		PWData.Profile.DOB = remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_DOB).getText();
		System.out.println(PWData.Profile.DOB);
		System.out.println("DOB is updated.");
	}
	/*private void changeGender(){
			
	}*/
	private void changeEmail(){
		String oldEmail = remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_EMAIL).getText().toLowerCase();
		String[] aray = oldEmail.split("@");
		String junk = aray[0] + "2@";
		oldEmail = junk + aray[1];
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_EMAIL).clear();
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_EMAIL).sendKeys(oldEmail);
		commonOperationAfterDone();
		System.out.println("Email is update.");
	}
	private void changeLocation(){
		String oldCity = remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_LOCATION).getText().toLowerCase();
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.TV_LOCATION).click();
		List<WebElement>cityList = remoteWebDriver.findElements(By.id(PWIDs.SellYourCarScreenIDs.MODULE_CITY_AREA));
		if(oldCity.equals("lahore")){
			cityList.get(1).click();
			//System.out.println("City was Lahore.");
		}
		else{
			cityList.get(2).click();
			//System.out.println("City was Karachi.");
		}
		commonOperationAfterDone();
		System.out.println("Location is updated.");
	}
	
	private void changePassword(){
		System.out.println("Start changing password...");
		remoteWebDriver.navigate().back();
		remoteWebDriver.findElementByName("Settings").click();
		remoteWebDriver.findElementByName("Change Password").click();
		
		WebElement oldPwdElement = remoteWebDriver.findElement(By.id(PWIDs.ForgetPasswordScreenIDs.MODULE_OLD_PWD));
		oldPwdTxt = oldPwdElement.findElement(By.id(PWIDs.ForgetPasswordScreenIDs.TXT_OLD_PWD));

		WebElement newPwdElement = remoteWebDriver.findElement(By.id(PWIDs.ForgetPasswordScreenIDs.MODULE_NEW_PWD));
		newPwdTxt = newPwdElement.findElement(By.id(PWIDs.ForgetPasswordScreenIDs.TXT_NEW_PWD));
		
		WebElement confirmPwdElement = remoteWebDriver.findElement(By.id(PWIDs.ForgetPasswordScreenIDs.MODULE_CONFIRM_PWD));
		confirmPwdTxt = confirmPwdElement.findElement(By.id(PWIDs.ForgetPasswordScreenIDs.TXT_CONFIRM_PWD));

		oldPwdTxt.clear();
		oldPwdTxt.sendKeys(PWData.SignUp.PWD);
		newPwdTxt.clear();
		newPwdTxt.sendKeys(PWData.SignUp.PWD + "7");
		confirmPwdTxt.clear();
		confirmPwdTxt.sendKeys(PWData.SignUp.PWD + "7");
		
		remoteWebDriver.findElementById(PWIDs.ForgetPasswordScreenIDs.BTN_DONE).click();
		GenericHelper.waitForElement(remoteWebDriver, "OK");
		remoteWebDriver.findElementByName("OK").click();
		
		System.out.println("Password has been updated.");
		remoteWebDriver.navigate().back();
	}
	
	private void commonOperationAfterDone(){
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.MyProfileScreenIDs.BTN_DONE);
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.BTN_DONE).click();
		GenericHelper.waitForElement(remoteWebDriver, PWIDs.MyProfileScreenIDs.BTN_DONE);
		
		remoteWebDriver.navigate().back();
		remoteWebDriver.findElementById(PWIDs.MyProfileScreenIDs.S_PROFILE).click();
	}
}

