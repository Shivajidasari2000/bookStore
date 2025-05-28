package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends BasePage {

	//constructor
	public BookStorePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//button[@id='login']")
	WebElement btnlogin;
	
	@FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-0']")
	WebElement loginlist;
	
	@FindBy(xpath="//a[normalize-space()='Learning JavaScript Design Patterns']")
    WebElement lnkbook;
	
	@FindBy(xpath="//input[@id='searchBox']")
	WebElement search;
	
	
	//action methods
	public void clickOnLogin()
	{
		safeClick(btnlogin);
	}
	
	public void clickOnLoginList()
	{
		safeClick(loginlist);
	}
	
	public void clickOnBook()
	{
		safeClick(lnkbook);
	}
	
	public void clickOnSearch()
	{
		search.click();
	}
}
