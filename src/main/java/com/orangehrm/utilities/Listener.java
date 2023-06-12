package com.orangehrm.utilities;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseClass;

public class Listener extends ExtentManager implements ITestListener {

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("test started : " + result.getName());
		test = extent.createTest("test started :" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"test is fail "+result.getName());
		Date date =new Date();
		String timestamp=date.toString().replace(":","-").replace(" ","-");
		File screenshot=((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot,new File("http://localhost:8082/job/orangeHRM/ws/Screenshot/"+timestamp+ " " +result.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,"test is skiiped : "+result.getName());
		}

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,"test is passed :" +result.getName());
	}

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,"test is finish:" +result.getName());
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,"test is start:" +result.getName());
	}
}
