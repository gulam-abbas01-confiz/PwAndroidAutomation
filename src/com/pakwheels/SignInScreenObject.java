package com.pakwheels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.DDT.PWData;
import com.pakwheels.helper.GenericHelper;
import com.pakwheels.helper.NavigationHelper;
import com.pakwheels.screenids.PWIDs;
public class SignInScreenObject {
	
	// Object
	private WebElement emailTxt;
	private WebElement passwordTxt;

	@FindBy(id = PWIDs.SignInScreenIDs.BTN_SIGN_IN)
	private WebElement signInBtn;

	@FindBy(id = PWIDs.SignInScreenIDs.TXT_FORGOT_PWD)
	private WebElement forgotPasswordTxtView;
	

	private RemoteWebDriver remoteWebDriver = null;	
	//============================================================================================================================================================//
	
	// Initialize SignIn Screen Objects
	public SignInScreenObject(RemoteWebDriver remoteWebDriver) {
		this.remoteWebDriver = remoteWebDriver;
		PageFactory.initElements(remoteWebDriver, this);
	}
	
	//Getter
		public WebElement getEmailTxt (){
			return emailTxt;
		}
		public WebElement getPasswordTxt (){
			return passwordTxt;
		}
		public WebElement getSignInBtn (){
			return signInBtn;
		}
		public WebElement getForgotPasswordTxtView (){
			return forgotPasswordTxtView;
		}
		public RemoteWebDriver getRemoteWebDriver (){
			return remoteWebDriver;
		}
		
		//Setter
		public void setEmailTxt(WebElement emailTxt){
			this.emailTxt = emailTxt;
		}
		public void setPasswordTxt(WebElement passwordTxt){
			this.passwordTxt = passwordTxt;
		}
		public void setSignInBtn(WebElement signInBtn){
			this.signInBtn = signInBtn;
		}
		public void setForgotPasswordTxtView(WebElement forgotPasswordTxtView){
			this.forgotPasswordTxtView = forgotPasswordTxtView;
		}
		public void setRemoteWebDriver(RemoteWebDriver remoteWebDriver){
			this.remoteWebDriver = remoteWebDriver;
		}
	

	//===========================================================================================================================================================//
	// Methods
		
	//You may call this method from app start, or directly call this function when you reach explicitly SignIn form.
	public void signIn() {
		try{
			System.out.println("Start logging in...");
			NavigationHelper.homeToSignInScreen(remoteWebDriver);
			remoteWebDriver.findElementById(PWIDs.LoginOrCreateAnAccountScreenIDs.BTN_SIGN_IN).click();
			
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.SignInScreenIDs.MODULE_USERNAME);
			
			// As userName & password has the same id's, so there is trick to get them.
			WebElement userNameElement = remoteWebDriver.findElement(By.id(PWIDs.SignInScreenIDs.MODULE_USERNAME));
			emailTxt = userNameElement.findElement(By.id(PWIDs.SignInScreenIDs.TXT_EMAIL));

			WebElement passwordElement = remoteWebDriver.findElement(By.id(PWIDs.SignInScreenIDs.MODULE_PWD));
			passwordTxt = passwordElement.findElement(By.id(PWIDs.SignInScreenIDs.TXT_PWD));

			//Send keys to the fields. This can be done from excel sheet.
			emailTxt.clear();
			emailTxt.sendKeys(PWData.SignUp.EMAIL);
			passwordTxt.clear();
			passwordTxt.sendKeys(PWData.SignUp.PWD);

			//Save email and password.
			PWData.SignIn.email = PWData.SignUp.EMAIL;
			PWData.SignIn.pwd = PWData.SignUp.PWD;
			
			//Click SignIn button to perform logIn.
			remoteWebDriver.findElement(By.id(PWIDs.SignInScreenIDs.BTN_SIGN_IN)).click();
			GenericHelper.waitForElement(remoteWebDriver, PWIDs.HomeScreenIDs.BTN_CAR_TAB);
			System.out.println("Login Sucessfully.");
			System.out.println("***********************************************************************************");
			remoteWebDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
		}catch(Exception ex){
			System.out.println("***********************************************************************************");
			System.out.println("*****************************Error!!! Test case fail.******************************");
			System.out.println("***********************************************************************************");
		}
	}
}
