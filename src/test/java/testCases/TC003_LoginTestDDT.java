package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass {

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "dataDriven")
	public void login(String uname,String pwd,String exp)
	{
		logger.info("***** TC002 Started *****");
		
		try {
		
		BookStorePage bp = new BookStorePage(driver);
		Thread.sleep(3000);
		bp.clickOnLoginList();
			
		//driver.get("https://demoqa.com/login");
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		lp.setUsername(uname);
		Thread.sleep(3000);
		lp.setPassword(pwd);
		Thread.sleep(3000);
		lp.clickOnLogin();
		
		Thread.sleep(3000);
		
		
		String url=driver.getCurrentUrl();
		ProfilePage pp = new ProfilePage(driver);
		//String name=pp.testUsername();
		
		//Assert.assertEquals(name, uname);
		
		if(exp.equalsIgnoreCase("Success"))
		{
			if(url.contains("/books") || url.contains("/profile"))
			{	
				pp.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Failure"))
		{
			if(url.contains("/books") || url.contains("/profile"))
			{
				Thread.sleep(3000);
				pp.clickLogout();
				Thread.sleep(3000);
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			logger.error("error");
			logger.debug("debug");
			Assert.fail();
	    }
		logger.info("****** Finished TC_002_LoginTest *****");
	
	}
}
