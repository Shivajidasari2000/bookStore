package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"sanity", "master"})
	public void account_register() throws InterruptedException
	{
		logger.info("***** TC001 Started *****");
		
		try {
		
		BookStorePage bp = new BookStorePage(driver);
		bp.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.clickOnNewUser();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.setFirstname(randomeString());
		rp.setLastname(randomeString());
		rp.setUsername(randomeString());
		rp.setPassword(randomeAlphaNumberic());
		Thread.sleep(5000);
		rp.clickRegister();
		Thread.sleep(3000);
		String text=rp.acceptAndGetAlertText();
		Thread.sleep(3000);
		Assert.assertEquals(text, "User Register Successfully.");
		
		logger.info("***** Successfull ******");
		}
		catch(Exception e)
		{
			logger.error("error");
			logger.debug("debug");
			Assert.fail();
		}
	}
}
