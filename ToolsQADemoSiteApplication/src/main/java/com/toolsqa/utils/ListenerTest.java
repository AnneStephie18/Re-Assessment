package com.toolsqa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.toolsqa.logreports.LogReports;

public class ListenerTest implements ITestListener {
	LogReports log = new LogReports();

	public void onTestStart(ITestResult result) {
		log.info(result.getName() + " test case started");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("The name of the testcase passed is :" + result.getName());
	}

	public void onTestFailure(ITestResult result) {

		log.info("The name of the testcase failed is :" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("The name of the testcase Skipped is :" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
