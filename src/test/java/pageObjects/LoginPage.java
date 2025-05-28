package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//button[@id='newUser']")
	WebElement btnnewuser;
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement txtusername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@id='login']")
	WebElement btnlogin;
	
	//action methods
	public void clickOnNewUser()
	{
		safeClick(btnnewuser);
	}
	public void setUsername(String username)
	{
		txtusername.clear();
		txtusername.sendKeys(username);
	}
	public void setPassword(String password)
	{
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}
	public void clickOnLogin()
	{
		safeClick(btnlogin);
	}
}
