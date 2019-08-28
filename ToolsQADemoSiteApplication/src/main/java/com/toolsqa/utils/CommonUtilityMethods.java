package com.toolsqa.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.toolsqa.helper.Helper;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.testbase.Base;

/**
 * This class is used to perform operations such as click, mouse over, get
 * title, verify assert, navigate to, count read more button, count hyper link
 * present
 * 
 * @author Anne.Sivakumar
 *
 */
public class CommonUtilityMethods {
	LogReports log = new LogReports();
	Base base = new Base();
	Helper helperobject = Helper.getInstance();

	// return the title of the page
	public String getTitle(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(helperobject.getValue(xpath))).getText().replace("₹", "");
	}

	// verify with the actual and expected title is same
	public void verifyAssertText(String actual, String expected) {
		Assert.assertEquals(actual, expected, "passed");
		log.info("Actual Text :" + actual);
		log.info("Expected Text :" + expected);
	}

	// perform click operation by passing xpath as parameter
	public void click(WebDriver driver, String clickxpath) {
		helperobject.explixitWait(driver, clickxpath);
		driver.findElement(By.xpath(helperobject.getValue(clickxpath))).click();
		log.info("click operation is performed");
	}

	// navigate to the previous page
	public void navigateTo(WebDriver driver) {
		driver.navigate().to(helperobject.getValue("producturl"));
		
	}

	// select option from dropdown list
	public void selectDropdownMenu(WebDriver driver, String xpath, String optionvalue) {
		Select dropdownmenu = new Select(driver.findElement(By.name(helperobject.getValue(xpath))));
		dropdownmenu.selectByVisibleText(optionvalue);
		log.info("selected option: " + optionvalue);
	}

	// perform keyboard function
	public void sendKeys(WebDriver driver, String xpath, String key) {
		driver.findElement(By.xpath(helperobject.getValue(xpath))).sendKeys(helperobject.getValue(key));
		driver.findElement(By.xpath(helperobject.getValue(xpath))).sendKeys(Keys.ENTER);

	}
	
	public void checkImage(WebDriver driver,String xpath) {
		WebElement ImageFile = driver.findElement(By.xpath(helperobject.getValue(xpath)));

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
		if (!ImagePresent) {
			log.info("Image is not present");
		} else {
			log.info("Image is present");
		}
	}

	public void listOfProduct(WebDriver driver,String xpath,String expected)
	{
		String list = null;
	List<WebElement> listofproduct= driver.findElements(By.xpath(helperobject.getValue(xpath)));
	for(WebElement price:listofproduct)
	{
		list = price.getText().replace("₹", "");
	}
	log.info("Product Details"+list);
	Boolean expectedtext=list.contains(expected);
	Assert.assertTrue(expectedtext);
	}

}
