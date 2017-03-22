package com.pakwheels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.DDT.PWData;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.screenids.PWIDs;

public class SignUpScreenObject {
	
	// Object
	private WebElement emailTxt;
	private WebElement nameTxt;
	private WebElement phoneTxt;
	private WebElement passwordTxt;
	

	@FindBy(id = PWIDs.SignUpScreenIDs.CB_SHOW_PWD)
	private WebElement showPwdCB;
	
	@FindBy(id = PWIDs.SignUpScreenIDs.RB_INDIVIDUAL)
	private WebElement individualRB;
	
	@FindBy(id = PWIDs.SignUpScreenIDs.RB_DEALER)
	private WebElement dealerRB;
	
	@FindBy(id = PWIDs.SignUpScreenIDs.CB_UPDATES)
	private WebElement updatesCB;
	
	@FindBy(id = PWIDs.SignUpScreenIDs.BTN_SIGN_UP)
	private WebElement signUpBtn;
	
	//If user is dealer.
	private WebElement dealershipNameTxt;
	private WebElement officePhoneTxt;
	
	private RemoteWebDriver remoteWebDriver = null;	
	
	//============================================================================================================================================================//

	// Initialize SignUp Screen Objects
	public SignUpScreenObject(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
	}
	
	//Getter
	public WebElement getEmailTxt() {
		return emailTxt;
	}
	public WebElement getNameTxt() {
		return nameTxt;
	}
	public WebElement getPhoneTxt() {
		return phoneTxt;
	}
	public WebElement getPasswordTxt() {
		return passwordTxt;
	}
	public WebElement getShowPwdCB() {
		return showPwdCB;
	}
	public WebElement getIndividualRB() {
		return individualRB;
	}
	public WebElement getDealerRB() {
		return dealerRB;
	}
	public WebElement getUpdatesCB() {
		return updatesCB;
	}
	public WebElement getSignUpBtn() {
		return signUpBtn;
	}
	public WebElement getDealershipNameTxt (){
		return dealershipNameTxt;
	}
	public WebElement getOfficePhoneTxt (){
		return officePhoneTxt;
	}
	
	
	public RemoteWebDriver getRemoteWebDriver (){
		return remoteWebDriver;
	}
	
	//Setter
	public void setEmailTxt(WebElement emailTxt) {
		this.emailTxt = emailTxt;
	}
	public void setNameTxt(WebElement nameTxt) {
		this.nameTxt = nameTxt;
	}
	public void setPhoneTxt(WebElement phoneTxt) {
		this.phoneTxt = phoneTxt;
	}
	public void setPasswordTxt(WebElement passwordTxt) {
		this.passwordTxt = passwordTxt;
	}
	public void setShowPwdCB(WebElement showPwdCB) {
		this.showPwdCB = showPwdCB;
	}
	public void setIndividualRB(WebElement individualRB) {
		this.individualRB = individualRB;
	}
	public void setDealerRB(WebElement dealerRB) {
		this.dealerRB = dealerRB;
	}
	public void setUpdatesCB(WebElement updatesCB) {
		this.updatesCB = updatesCB;
	}
	public void setSignUpBtn(WebElement signUpBtn) {
		this.signUpBtn = signUpBtn;
	}
	public void getDealershipNameTxt (WebElement dealershipNameTxt){
		this.dealershipNameTxt = dealershipNameTxt;
	}
	public void getOfficePhoneTxt (WebElement officePhoneTxt){
		this.officePhoneTxt = officePhoneTxt;
	}
	
	
	public void getRemoteWebDriver (RemoteWebDriver remoteWebDriver){
		this.remoteWebDriver = remoteWebDriver;
	}

	
	//============================================================================================================================================================//
	
	// Methods
	public void signUp() {
		
		try{
			System.out.println("Start Signing up...");
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SplashScreenIDs.BTN_SIGN_IN);
			//webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SplashScreenIDs.BTN_SIGN_UP)));

			// Click SignUp button from splash screen.
			WebElement signUpBtn_on_splash = remoteWebDriver.findElement(By.id(PWIDs.SplashScreenIDs.BTN_SIGN_UP));
			signUpBtn_on_splash.click();

			GenericHelper.waitForElement(remoteWebDriver, "Cancel");
			remoteWebDriver.findElement(By.name("Cancel")).click();

			// As userName & password has the same id's, so there is trick to get them.
			WebElement emailElement = remoteWebDriver.findElement(By.id(PWIDs.SignUpScreenIDs.MODULE_EMAIL));
			emailTxt = emailElement.findElement(By.id(PWIDs.SignUpScreenIDs.TXT_EMAIL));

			WebElement fullNameElement = remoteWebDriver.findElement(By.id(PWIDs.SignUpScreenIDs.MODULE_NAME));
			nameTxt = fullNameElement.findElement(By.id(PWIDs.SignUpScreenIDs.TXT_NAME));
			
			/*WebElement phoneElement = remoteWebDriver.findElement(By.id(PWIDs.SignUpScreenIDs.MODULE_PHONE));
			phoneTxt = phoneElement.findElement(By.id(PWIDs.SignUpScreenIDs.TXT_PHONE));*/

			WebElement passwordElement = remoteWebDriver.findElement(By.id(PWIDs.SignUpScreenIDs.MODULE_PWD));
			passwordTxt = passwordElement.findElement(By.id(PWIDs.SignUpScreenIDs.TXT_PWD));

			// Send keys to the fields. This can be done from excel sheet.
			emailTxt.clear();
			emailTxt.sendKeys(PWData.SignUp.EMAIL);
			
			//Save email
			PWData.SignIn.email = PWData.SignUp.EMAIL;
			
			nameTxt.clear();
			nameTxt.sendKeys(PWData.SignUp.NAME);
			/*phoneTxt.clear();
			phoneTxt.sendKeys(PWData.SignUp.PHONE);*/
			passwordTxt.clear();
			passwordTxt.sendKeys(PWData.SignUp.PWD);
			
			//Save password
			PWData.SignIn.pwd = PWData.SignUp.PWD;
			
			//Enable checkbox to show password.
			/*if(!remoteWebDriver.findElement(By.id("com.pakwheels:id/chckBxshowPwd")).isSelected()){
				remoteWebDriver.findElement(By.id("com.pakwheels:id/chckBxshowPwd")).click();
			}*/
			
			// Click SignUp button to perform logIn.
			remoteWebDriver.findElementById(PWIDs.SignUpScreenIDs.BTN_SIGN_UP).click();
			
			//Verify SignUp successfully or not?
			try{
				GenericHelper.waitForElement(remoteWebDriver, PWIDs.HomeScreenIDs.BTN_CAR_TAB);
				System.out.println("Sign Up Successfully.");
				System.out.println("***********************************************************************************");
			}
			catch(Exception ex){
				System.out.println("Sign Up Failed. Kindly check the screen shoot.");
				System.out.println("***********************************************************************************");
				GenericHelper.TakeScreenShot(remoteWebDriver, "error_SignUp");
				return;
			}
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
		
		
		
	}
}
