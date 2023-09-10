package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{	
		super (driver);
	// 	this.driver = driver;	
	}
	
// Elements
	
@FindBy(xpath="//span[@class='caret']") 
WebElement linkmyaccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement linkRegister;

@FindBy(xpath="//a[normalize-space()='Login']") 
WebElement loginlink;

// Action Methods ----->

public void clickMyAccount() {
	linkmyaccount.click();
}

public void clickRegister() {
	linkRegister.click();
}

public void clickLoginLink() {
	loginlink.click();}
}
