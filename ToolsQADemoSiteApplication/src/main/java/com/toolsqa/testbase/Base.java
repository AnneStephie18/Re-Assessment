package com.toolsqa.testbase;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.toolsqa.constants.Constants;
import com.toolsqa.helper.Helper;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.utils.GetScreenShot;
/**
 * This class is used for creation of driver(Chrome,Firefox,Internt Explorer) and close the driver 
 * @author Anne.Sivakumar
 *
 */
public class Base {
	public WebDriver driver;
	public Properties properties;
	LogReports log=new LogReports();
	Helper helperobject = Helper.getInstance();
	public ITestResult result;
	GetScreenShot getscreenShot=new GetScreenShot();
    /**
     * creation of chrome ,firefox, internet explorer driver 
     */
	public void openBrowser() 
	{ 
		
		if (helperobject.getValue("browser").equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",Constants.PROJECT_CHROMEPATH);
			this.driver  = new ChromeDriver();
			log.info(""+driver);
		} 
		else if (helperobject.getValue("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",Constants.PROJECT_FIREFOXPATH);
			driver = new FirefoxDriver();
			log.info(""+driver);
		}

		else if (helperobject.getValue("browser").equalsIgnoreCase("internetexplorer")) 
		{
			System.setProperty("webdriver.ie.driver",Constants.PROJECT_INTERNETEXPLORERPATH);
			driver = new InternetExplorerDriver();
			log.info(""+driver);
		}
		driver.get(helperobject.getValue("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}

   //close the driver
	public void quitBrowser()  
	{
		driver.quit();
	}
//take screenshot on successful attempt
	@AfterMethod
	public void getResult(ITestResult result)
	{

	if(result.getStatus()==ITestResult.SUCCESS)
	{

	getscreenShot.getScreenshot(driver);

	}
	}

}
