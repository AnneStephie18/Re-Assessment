package com.toolsqa.testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.pages.HomePage;
import com.toolsqa.testbase.Base;
import com.toolsqa.utils.ExtentReport;

public class AutomatedHomePage extends Base {
	HomePage homepageobject=new HomePage();
	
	@BeforeTest
	public void preSetup()
	{
		openBrowser();
	}
	@Test
	public void HomePageValidation()
	{
		homepageobject.validateHomePage(driver);	
	}
	@AfterTest
	public void tearDown()
	{
		quitBrowser();
	}
}
