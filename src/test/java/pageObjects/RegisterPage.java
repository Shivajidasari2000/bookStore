package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	//constructor
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='firstname']")
	WebElement txtfname;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement txtlname;
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement txtuname;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//button[@id='register']")
	WebElement btnregister;
	
	@FindBy(xpath="//button[@id='gotologin']")
	WebElement btnbacktologin;
	
	//action methods
	public void setFirstname(String fname)
	{
		txtfname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtlname.sendKeys(lname);
	}
	public void setUsername(String uname)
	{
		txtuname.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	public void clickRegister()
	{
		btnregister.click();
	}
	public String acceptAndGetAlertText()
	{
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		
		return alertText;
	}
	public void clickOnBacktoLogin()
	{
		safeClick(btnbacktologin);
	}
	
	
	
	
}
