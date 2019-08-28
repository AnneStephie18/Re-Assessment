package com.toolsqa.pages;

import org.openqa.selenium.WebDriver;

import com.toolsqa.helper.Helper;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.utils.CommonUtilityMethods;
import com.toolsqa.utils.ExtentReport;
import com.toolsqa.utils.ReadExcel;

public class ProductsPageFilterColorAndPrice {
	ProductsPageFilterColor productpagefiltercolorobject=new ProductsPageFilterColor();
	CommonUtilityMethods commonutilityobject=new CommonUtilityMethods();
	Helper helperobject=Helper.getInstance();
	LogReports log=new LogReports();
	ExtentReport extentreport=new ExtentReport();
	public void applyFilterByColorAndPrice(WebDriver driver)
	{
		productpagefiltercolorobject.openProductsPage(driver);
		productpagefiltercolorobject.scroll.executeScript("window.scrollBy(0,300)");
		String productcolor=ReadExcel.getCellData("Sheet1", "product color",7);
		String expectedproductcolor=ReadExcel.getCellData("Sheet1", "Expected Title",5);
		commonutilityobject.selectDropdownMenu(driver, "shop.product.color", productcolor);
		commonutilityobject.listOfProduct(driver, "productslist",expectedproductcolor);
		String productprice=ReadExcel.getCellData("Sheet1", "Filter By Price",2);
		productpagefiltercolorobject.scroll.executeScript("window.scrollBy(0,300)");
		commonutilityobject.selectDropdownMenu(driver, "shop.product.sortbyprice", productprice);
		String firstproductsortedprice=ReadExcel.getCellData("Sheet1", "Filter By Price",3);
		String secondproductsortedprice=ReadExcel.getCellData("Sheet1", "Filter By Price",4);
		commonutilityobject.listOfProduct(driver, "productslist",firstproductsortedprice);
		commonutilityobject.listOfProduct(driver, "productslist",secondproductsortedprice);
		String testname=ReadExcel.getCellData("Sheet1", "Test Name",4);
		String message=ReadExcel.getCellData("Sheet1", "Message",4);
		extentreport.report(testname, message);
	}
}
