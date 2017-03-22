package com.pakwheels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pakwheels.screenids.PWIDs;

public class LoginOrCreateAnAccountScreenObject {

	@FindBy(id = PWIDs.LoginOrCreateAnAccountScreenIDs.BTN_CONNECT_WITH_FB)
	private WebElement connectWithFBBtn;

	@FindBy(id = PWIDs.LoginOrCreateAnAccountScreenIDs.BTN_SIGN_IN)
	private WebElement signInBtn;

	@FindBy(id = PWIDs.LoginOrCreateAnAccountScreenIDs.BTN_SIGN_UP)
	private WebElement signUpBtn;
	
	@FindBy(id = PWIDs.LoginOrCreateAnAccountScreenIDs.IMG_CANCEL)
	private WebElement crossImg;
	
	// Initialize Login or Create an Account Screen Objects
	public LoginOrCreateAnAccountScreenObject(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(remoteWebDriver, this);
	}
	
	//Getter
	public WebElement getConnectWithFBBtn (){
		return connectWithFBBtn;
	}
	public WebElement getSignInBtn (){
		return signInBtn;
	}
	public WebElement getSignUpBtn (){
		return signUpBtn;
	}
	public WebElement getCrossImg (){
		return crossImg;
	}
	
	
	//Setter
	public void setConnectWithFBBtn(WebElement connectWithFBBtn){
		this.connectWithFBBtn = connectWithFBBtn;
	}
	public void setSignInBtn(WebElement signInBtn){
		this.signInBtn = signInBtn;
	}
	public void setSignUpBtn(WebElement signUpBtn){
		this.signUpBtn = signUpBtn;
	}
	public void setCrossImg(WebElement crossImg){
		this.crossImg = crossImg;
	}
		

}
