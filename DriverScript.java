package keyworddrivenfwk.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import keyworddrivenfwk.utils.ActionClass;
public class DriverScript {
	private WebDriver driver;
	@Parameters({"browserType"})
	@BeforeClass
	public void invokeBrowser(String browserType)
	{		 		
		if(browserType.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();  
		}
		else if(browserType.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(); 

		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}

	}
	@Test
	public void validateLogin() throws Exception
	{
		/*
		 * param1 : driver
		 * param2 : xlsx filename
		 * param3 : sheet name
		 */
		ActionClass actionClass = new ActionClass();
		boolean result = actionClass.run(driver,"inputData.xlsx","E2E_001");
		Assert.assertTrue(result);

	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}


}
