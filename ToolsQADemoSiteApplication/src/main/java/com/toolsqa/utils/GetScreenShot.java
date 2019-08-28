	package com.toolsqa.utils;
	
	import java.io.File;
	import java.io.IOException;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

import com.toolsqa.constants.Constants;
import com.toolsqa.logreports.LogReports;
	
	
	public class GetScreenShot  {
		 LogReports log=new LogReports();
		
		public  String getScreenshot(WebDriver driver)
		{
		TakesScreenshot takescreenshot =(TakesScreenshot) driver;
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotpath=Constants.PROJECT_SCREENSHOT_PATH;
		File destination=new File(screenshotpath);
		try
		{
	
		FileUtils.copyFile(source, destination);
		log.info("capture success");
		}
		catch(IOException e)
		{
		log.info("capture failed"+e.getMessage());
	
		}
		return screenshotpath;
		}
	}
