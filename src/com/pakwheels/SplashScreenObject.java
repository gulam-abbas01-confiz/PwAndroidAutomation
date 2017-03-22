package com.pakwheels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.screenids.PWIDs;

public class SplashScreenObject {
	
	@FindBy(id= PWIDs.SplashScreenIDs.BTN_CROSS)
	private WebElement crossButton;
	
	@FindBy(id= PWIDs.SplashScreenIDs.BTN_SIGN_UP)
	private WebElement signUpButton;
	
	@FindBy(id= PWIDs.SplashScreenIDs.BTN_SIGN_IN)
	private WebElement loginButton;
	
	//============================================================================================================================================================//

	
	//Initialize Splash Screen Objects
	public SplashScreenObject(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(remoteWebDriver, this);
	}

	//Getter
	public WebElement getCrossButton (){
		return crossButton;
	}
	public WebElement getSignUpButton (){
		return signUpButton;
	}
	public WebElement getLoginButton (){
		return loginButton;
	}
	
	
	//Setter
	public void setCrossButton(WebElement crossButton){
		this.crossButton = crossButton;
	}
	public void setSignUpButton(WebElement signUpButton){
		this.signUpButton = signUpButton;
	}
	public void setLoginButton(WebElement loginButton){
		this.loginButton = loginButton;
	}
			
	
	
	//============================================================================================================================================================//

	
}
