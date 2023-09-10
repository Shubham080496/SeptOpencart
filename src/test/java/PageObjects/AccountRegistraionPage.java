package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistraionPage  extends BasePage{

	WebDriver driver;
	
	public AccountRegistraionPage(WebDriver driver)
	{
	super(driver);	
	//	this.driver = driver;	
	}
	// Elements------>
	
@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtFirstName;

@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtconfirmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkdpolicy;

@FindBy(xpath="//input[@value='Continue']") 
WebElement btncontinue;


@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
WebElement MsgConfirmation;

//Action methods------>

public void setfirstname(String fname) {
	txtFirstName.sendKeys(fname);
}

public void setlastname(String lname) {
	txtLastName.sendKeys(lname);
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
}

public void setpassword(String pass) {
	txtpassword.sendKeys(pass);
}

public void setConfirmpass(String confirmpass) {
	txtconfirmpassword.sendKeys(confirmpass);
}

public void checkpolicy() {
	chkdpolicy.click();
}

public void clickContinue() {
	    //sol1 
	       btncontinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
}

public String getConfirmationMsg() {
	try {
		return(MsgConfirmation.getText());
		
	}catch (Exception e) {
		return (e.getMessage());
	}
	
}
}
