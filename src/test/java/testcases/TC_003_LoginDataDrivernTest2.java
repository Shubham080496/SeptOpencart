package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivernTest2 extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_Login(String email, String pwd, String expres) 
	{
		logger.info("Starting TC_003_LoginDataDrivernTest2");
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.Clicklogin();
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
    	boolean targetPage = macc.isMyAccountPageExists();	
		
    	if(expres.equalsIgnoreCase("valid")) {
    		
    		if(targetPage==true)
    		{
    			macc.ClickLogout();
    			Assert.assertTrue(true);
    		}
    		else {
    			Assert.assertTrue(false);
    		}
    		
    	   	if(expres.equalsIgnoreCase("Invalid")) {
        		
        		if(targetPage==true)
        		{
        			macc.ClickLogout();
        			Assert.assertTrue(false);
        		}
        		else {
        			Assert.assertTrue(true);
        		}
    		
    	   	}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("End TC_003_LoginDataDrivernTest2");
	}

}
