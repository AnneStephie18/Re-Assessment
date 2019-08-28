package com.toolsqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.toolsqa.helper.Helper;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.utils.CommonUtilityMethods;
import com.toolsqa.utils.ExtentReport;
import com.toolsqa.utils.ReadExcel;

public class ProductsPageFilterColor {
	CommonUtilityMethods commonutilityobject=new CommonUtilityMethods();
	Helper helperobject=Helper.getInstance();
	LogReports log=new LogReports();
	ExtentReport extentreport=new ExtentReport();
	public JavascriptExecutor scroll;
	public void applyFilterByColor(WebDriver driver)
	{
		
		openProductsPage(driver);
		scroll.executeScript("window.scrollBy(0,1500)");
		commonutilityobject.click(driver, "shop.3rdpage.icon");
		String shopthirdpagetitle=ReadExcel.getCellData("Sheet1", "Expected Title",4);
		commonutilityobject.verifyAssertText(commonutilityobject.getTitle(driver, "shop.3rdpage.text"), shopthirdpagetitle);
		scroll.executeScript("window.scrollBy(0,300)");
		String productcolor=ReadExcel.getCellData("Sheet1", "product color",6);
		commonutilityobject.selectDropdownMenu(driver, "shop.product.color", productcolor);
		String sortbycolortitle=ReadExcel.getCellData("Sheet1", "Expected Title",6);
		commonutilityobject.verifyAssertText(commonutilityobject.getTitle(driver, "sortbycolor.pagenavigation"), sortbycolortitle);
		String testname=ReadExcel.getCellData("Sheet1", "Test Name",3);
		String message=ReadExcel.getCellData("Sheet1", "Message",3);
		extentreport.report(testname, message);	
	}
     public void openProductsPage(WebDriver driver)
     {
    	 scroll = (JavascriptExecutor) driver;
    	 commonutilityobject.navigateTo(driver);
 		String shoppagetitle=ReadExcel.getCellData("Sheet1", "Expected Title",3);
 		commonutilityobject.verifyAssertText(commonutilityobject.getTitle(driver, "shop.pagetitle"), shoppagetitle);
     }
}

