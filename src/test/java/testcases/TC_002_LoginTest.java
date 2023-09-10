package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test (groups= {"regression","master"})
	public void test_Login() 
	{
		logger.info("Starting TC_002_LoginTest");
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.Clicklogin();
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
    	boolean targetPage = 	macc.isMyAccountPageExists();	
		Assert.assertEquals(targetPage, true);
		} catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("End TC_002_LoginTest");
	}

}
