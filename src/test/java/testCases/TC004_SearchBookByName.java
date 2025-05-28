package testCases;

import org.testng.annotations.Test;

import pageObjects.BookStorePage;

public class TC004_SearchBookByName extends BaseClass {

	@Test
	public void searchBook() throws InterruptedException
	{
	
		BookStorePage bp = new BookStorePage(driver);
		Thread.sleep(3000);
		bp.clickOnBook();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
	}
}
