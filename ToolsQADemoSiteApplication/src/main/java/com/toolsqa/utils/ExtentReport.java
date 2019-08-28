package com.toolsqa.utils;

import java.io.File;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	public ExtentReports report;
	public ExtentTest test;
	public ITestResult result;
	
	public  void report(String testname,String msg )  {
    String reportPath = new File("").getAbsolutePath().toString().trim()+"/Reports/";
	report = new ExtentReports(reportPath+this.getClass().getSimpleName()+".html", false);
	test = report.startTest(testname,msg);
	test.log(LogStatus.INFO, testname);
	test.log(LogStatus.PASS, testname);
	report.endTest(test);
	report.flush();
	}
	
}
