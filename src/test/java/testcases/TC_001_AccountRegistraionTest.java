package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistraionPage;
import PageObjects.HomePage;
import testBase.BaseClass;
// shubham
public class TC_001_AccountRegistraionTest extends BaseClass{
 
 @Test (groups= {"master","sanity"})
 public void test_accountRegistration()
 {
	 logger.info("*** starting TC_001_AccountRegistrationTest ***");
	 
	 HomePage hp= new HomePage (driver);
	 logger.info("Clicking on MyAccount link");
		hp.clickMyAccount();
		
		logger.info("Clicking on register link");
		hp.clickRegister();
		
		logger.info("Providing customers details");
	 AccountRegistraionPage regPage = new AccountRegistraionPage (driver);
	 
	 regPage.setfirstname(randomString().toUpperCase());
	 regPage.setlastname(randomString().toUpperCase());
	 regPage.setEmail(randomString() +"@gmail.com");
	 regPage.setTelephone(randomNumber());
	 
	 String password = ranodmAlphaNumaric();
	 
	 regPage.setpassword(password);
	 regPage.setConfirmpass(password);
	 regPage.checkpolicy();
	 regPage.clickContinue();
	 
	String confmsg=regPage.getConfirmationMsg();
	if(confmsg.equals("Your Account Has Been Created!"))
	{
	logger.info("Registration successful...");
	Assert.assertTrue(true);
	}
	else
	{
		logger.error("Registration failed");
			Assert.fail();
	}
	logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	 
 }
}
