package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pakwheels.SignInScreenObject;
import com.pakwheels.DDT.PWData;
import com.pakwheels.screenids.PWIDs;
import io.appium.java_client.android.AndroidDriver;

public class SignInTest extends Base {
	@SuppressWarnings("rawtypes")
	private AndroidDriver thisDriver;
	private WebDriverWait thisWait;
	private SignInScreenObject obj;

	@BeforeTest
	private void init() throws Exception {
		super.launchApp();
		thisDriver = driver;
		thisDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj = new SignInScreenObject(thisDriver);
		thisWait = wait;
		thisWait = new WebDriverWait(thisDriver, 30);
		PageFactory.initElements(thisDriver, obj);
	}

	@Test
	public void signIn() {
		gotoSignInScreen();
		login();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.HomeScreenIDs.BTN_CAR_TAB)));
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_CAR_TAB).click();
	}

	private void gotoSignInScreen() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.HomeScreenIDs.BTN_MORE_TAB)));
		thisDriver.findElementById(PWIDs.HomeScreenIDs.BTN_MORE_TAB).click();
		thisDriver.findElementById(PWIDs.MyProfileScreenIDs.S_PROFILE).click();
	}
	
	private void login(){
		thisDriver.findElementById(PWIDs.LoginOrCreateAnAccountScreenIDs.BTN_SIGN_IN).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PWIDs.SignInScreenIDs.MODULE_USERNAME)));

		WebElement userNameElement = thisDriver.findElement(By.id(PWIDs.SignInScreenIDs.MODULE_USERNAME));
		obj.setEmailTxt(userNameElement.findElement(By.id(PWIDs.SignInScreenIDs.TXT_EMAIL)));
		obj.getEmailTxt().clear();
		obj.getEmailTxt().sendKeys(PWData.SignUp.EMAIL);
		
		WebElement passwordElement = thisDriver.findElement(By.id(PWIDs.SignInScreenIDs.MODULE_PWD));
		obj.setPasswordTxt(passwordElement.findElement(By.id(PWIDs.SignInScreenIDs.TXT_PWD)));
		obj.getPasswordTxt().clear();
		obj.getPasswordTxt().sendKeys(PWData.SignUp.PWD);
		
		// Save email and password.
		PWData.SignIn.email = PWData.SignUp.EMAIL;
		PWData.SignIn.pwd = PWData.SignUp.PWD;

		// Click SignIn button to perform logIn.
		thisDriver.findElement(By.id(PWIDs.SignInScreenIDs.BTN_SIGN_IN)).click();
	}
}
