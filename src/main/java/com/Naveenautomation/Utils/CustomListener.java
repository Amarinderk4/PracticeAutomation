package com.Naveenautomation.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Naveenautomation.Base.TestBase;

public class CustomListener extends TestBase implements ITestListener{

			
	

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("!!!!!!!!!!!!!!Test Case Fail: " + result.getMethod().getMethodName() + " Taking Screenshot!!!!!!!!!!!!!!!!!!!!");
       Utils.takeFailedTestScreenShot(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("??????????????????Test Case skipped: " + result.getMethod().getMethodName() + "????????????????");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("*****************Test Case started: " + result.getMethod().getMethodName()
				+ "***********************");
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("**********************Test Case Passed: " + result.getMethod().getMethodName()
				+ "****************************");
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
