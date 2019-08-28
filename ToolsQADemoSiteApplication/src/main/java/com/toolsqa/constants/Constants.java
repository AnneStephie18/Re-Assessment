
package com.toolsqa.constants;
/**
 * This class contains the path of the log ,properties file,implicit wait,page load timeout
 */
import java.io.File;

public class Constants {
    public final static String PROJECT_BASE_PATH= System.getProperty("user.dir");
	public final static long IMPLICIT_WAIT = 10;
	public final static long WEB_DRIVER_WAIT = 10;
	public final static String PROJECT_SCREENSHOT_PATH=Constants.PROJECT_BASE_PATH+File.separator+"Screenshots"+File.separator+"Screenshot"+System.currentTimeMillis()+".png";
	public final static String PROJECT_CHROMEPATH=PROJECT_BASE_PATH+File.separator+"lib"+File.separator+"chromedriver.exe";
	public final static String PROJECT_FIREFOXPATH=PROJECT_BASE_PATH+File.separator+"lib"+File.separator+"geckodriver.exe";
	public final static String PROJECT_INTERNETEXPLORERPATH=PROJECT_BASE_PATH+File.separator+"lib"+File.separator+"IEDriverServer.exe";
	public final static String PROJECT_CONFIGURATION_PATH = PROJECT_BASE_PATH+File.separator+"resources"+File.separator+"config.properties";
	public final static String PROJECT_LOG_PATH=PROJECT_BASE_PATH+File.separator+"resources"+File.separator+"log.properties";
	public final static String PROJECT_HOMEPAGE_PATH=PROJECT_BASE_PATH + File.separator+"resources"+File.separator+"locators"+File.separator+"homepage.properties";
	public final static String PROJECT_PRODUCTPAGE_FILTERBY_COLOR_PATH=PROJECT_BASE_PATH + File.separator+"resources"+File.separator+"locators"+File.separator+"productpagefiltercolor.properties";
	public final static String PROJECT_PRODUCTPAGE_FILTERBY_COLORANDPRICE_PATH=PROJECT_BASE_PATH + File.separator+"resources"+File.separator+"locators"+File.separator+"productpagefiltercolorandprice.properties";
	public final static String PROJECT_TESTDATA_PATH=PROJECT_BASE_PATH + File.separator+"resources"+File.separator+"testdata"+File.separator+"ProductTestData.xlsx";
}

