package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"regression","master"})
	public void login()
	{
		logger.info("***** TC002 Started *****");
		
		try {
		
		BookStorePage bp = new BookStorePage(driver);
		bp.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickOnLogin();
		
		ProfilePage pp = new ProfilePage(driver);
		String name=pp.testUsername();
		
		Assert.assertEquals(name, p.getProperty("username"));
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
