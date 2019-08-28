package com.toolsqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.toolsqa.helper.Helper;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.utils.CommonUtilityMethods;
import com.toolsqa.utils.ExtentReport;
import com.toolsqa.utils.ReadExcel;

public class HomePage {
	CommonUtilityMethods commonutilityobject=new CommonUtilityMethods();
	Helper helperobject=Helper.getInstance();
	LogReports log=new LogReports();
	ExtentReport extentreport=new ExtentReport();
	public void validateHomePage(WebDriver driver)
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		String homepagetitle=ReadExcel.getCellData("Sheet1", "Expected Title",2);
		commonutilityobject.verifyAssertText(commonutilityobject.getTitle(driver, "homepage.title"), homepagetitle);
		scroll.executeScript("window.scrollBy(0,900)");
		String firstproductname=ReadExcel.getCellData("Sheet1", "product name",2);
		String firstproductprice=ReadExcel.getCellData("Sheet1", "Product Price",2);
		String secondproductname=ReadExcel.getCellData("Sheet1", "product name",3);
		String secondproductprice=ReadExcel.getCellData("Sheet1", "Product Price",3);
		String thirdproductname=ReadExcel.getCellData("Sheet1", "product name",4);
		String thirdproductprice=ReadExcel.getCellData("Sheet1", "Product Price",4);
		String fourthproductname=ReadExcel.getCellData("Sheet1", "product name",5);
		String fourthproductprice=ReadExcel.getCellData("Sheet1", "Product Price",5);
		String fifthproductname=ReadExcel.getCellData("Sheet1", "product name",6);
		String fifthproductprice=ReadExcel.getCellData("Sheet1", "Product Price",6);
		String sixthproductname=ReadExcel.getCellData("Sheet1", "product name",7);
		String sixthproductprice=ReadExcel.getCellData("Sheet1", "Product Price",7);
		validateProduct(driver, "firstproduct.image", firstproductname, firstproductprice, "firstproduct.name", "firstproduct.price");
		validateProduct(driver, "secondproduct.image", secondproductname, secondproductprice, "secondproduct.name", "secondproduct.price");
		validateProduct(driver, "thirdproduct.image", thirdproductname, thirdproductprice, "thirdproduct.name", "thirdproduct.price");
		scroll.executeScript("window.scrollBy(0,920)");
		validateProduct(driver, "fourthproduct.image", fourthproductname, fourthproductprice, "fourthproduct.name", "fourthproduct.price");
		validateProduct(driver, "fifthproduct.image", fifthproductname, fifthproductprice, "fifthproduct.name", "fifthproduct.price");
		validateProduct(driver, "sixthproduct.image", sixthproductname, sixthproductprice, "sixthproduct.name", "sixthproduct.price");
		String testname=ReadExcel.getCellData("Sheet1", "Test Name",2);
		String message=ReadExcel.getCellData("Sheet1", "Message",2);
		extentreport.report(testname, message);
	}
	public void validateProduct(WebDriver driver,String productimage,String productname,String productprice,String productnamexpath,String productpricexpath )
	{
		commonutilityobject.checkImage(driver, productimage);
		commonutilityobject.verifyAssertText(commonutilityobject.getTitle(driver, productnamexpath), productname);
		commonutilityobject.verifyAssertText(commonutilityobject.getTitle(driver, productpricexpath), productprice);
	}
}
