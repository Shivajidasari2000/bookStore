package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//label[@id='userName-value']")
	WebElement username;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement btnlogout;
	


	public String testUsername()
	{
		String name=username.getText();
		return name;
	}
	
	public void clickLogout()
	{
	         safeClick(btnlogout);
	}
	
}
