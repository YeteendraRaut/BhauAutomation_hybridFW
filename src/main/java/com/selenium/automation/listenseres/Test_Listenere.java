package com.selenium.automation.listenseres;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.automation.utilty.Utility;

public class Test_Listenere implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() +" - TestCase Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() +" - testCase End");
	}

	public void onTestFailure(ITestResult result) {
		try {
			Utility.TakeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result.getName() +"- TestCase Fail");	
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() +" - TestCase Skipped");
	}

	

}
