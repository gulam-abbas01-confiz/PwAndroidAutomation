package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class SignInPageObject {
	//Objects
	private WebElement emailTxt;
	private WebElement passwordTxt;

	@FindBy(id = PWIDs.SignInScreenIDs.BTN_SIGN_IN)
	private WebElement signInBtn;

	@FindBy(id = PWIDs.SignInScreenIDs.TXT_FORGOT_PWD)
	private WebElement forgotPasswordTxtView;

	@SuppressWarnings("rawtypes")
	private AndroidDriver driver = null;

	
	//Initialize SignIn Screen Objects
	@SuppressWarnings("rawtypes")
	public SignInPageObject(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Getter
	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getForgotPasswordTxtView() {
		return forgotPasswordTxtView;
	}

	@SuppressWarnings("rawtypes")
	public AndroidDriver getAndroidDriver() {
		return driver;
	}

	//Setter
	public void setEmailTxt(WebElement emailTxt) {
		this.emailTxt = emailTxt;
	}

	public void setPasswordTxt(WebElement passwordTxt) {
		this.passwordTxt = passwordTxt;
	}

	public void setSignInBtn(WebElement signInBtn) {
		this.signInBtn = signInBtn;
	}

	public void setForgotPasswordTxtView(WebElement forgotPasswordTxtView) {
		this.forgotPasswordTxtView = forgotPasswordTxtView;
	}

	@SuppressWarnings("rawtypes")
	public void setAndroidDriver(AndroidDriver driver) {
		this.driver = driver;
	}
}
