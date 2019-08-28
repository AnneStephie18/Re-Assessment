package com.toolsqa.testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.pages.ProductsPageFilterColor;
import com.toolsqa.testbase.Base;

public class AutomatedProductsPageFilterColor extends Base {
	ProductsPageFilterColor productpagefiltercolorobject=new ProductsPageFilterColor();
	@BeforeTest
	public void preSetup()
	{
		openBrowser();
	}
	@Test
	public void productFilteringByColor()
	{
		productpagefiltercolorobject.applyFilterByColor(driver);
	}
	@AfterTest
	public void tearDown()
	{
		quitBrowser();
	}
}
