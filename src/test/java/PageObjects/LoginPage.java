package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) // constructor
	{
	super(driver);	
	//	this.driver = driver;	
	}
	

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmailAdress;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@value='Login']") 
WebElement btnLogin;

public void setEmail(String email) {
	txtEmailAdress.sendKeys(email);
}

public void setPassword(String password) {
	txtPassword.sendKeys(password);
}

public void Clicklogin( ) {
	btnLogin.click();;
}
	
}
