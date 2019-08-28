package com.toolsqa.testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.pages.ProductsPageFilterColorAndPrice;
import com.toolsqa.testbase.Base;

public class AutomatedProductsPageFilterColorAndPrice extends Base{
	ProductsPageFilterColorAndPrice productpagefiltercolorandpriceobject=new ProductsPageFilterColorAndPrice();
	@BeforeTest
	public void preSetup()
	{
		openBrowser();
	}
	@Test
	public void productFilteringByColorAndPrice()
	{
		productpagefiltercolorandpriceobject.applyFilterByColorAndPrice(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		quitBrowser();
	}
	
}
