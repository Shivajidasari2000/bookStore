package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //for parallel testing
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	
//	public static WebDriver getDriver()
//	{
//		return driver.get();
//	}
	
	
	
	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
	{
		//loading config.properties file
	    FileReader file = new FileReader("./src//test//resources//config.properties");
	    p = new Properties();
	    p.load(file);
		
	    logger = LogManager.getLogger(this.getClass()); //log4j2
		
	    //browser
	    switch(br.toLowerCase())
	    {
	    case "chrome" : driver =new ChromeDriver();break;
	    case "edge"   : driver= new EdgeDriver();break;
	    case "firefox" : driver=new FirefoxDriver();break;
	    default : System.out.println("Invalid browser");return;
	    }
	    
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"sanity","regression","master"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	//common utilities for account registration
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomeAlphaNumberic()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	//screenshot
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
