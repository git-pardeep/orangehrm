package com.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.IndexPage;
import com.orangehrm.utilities.ExtentManager;
import com.orangehrm.utilities.Log;

public class IndexPageTest extends BaseClass {
	private IndexPage indexpage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@AfterMethod
	public void tearDown() {

		getDriver().quit();
		Log.info("Close browser");
	}

	@Test
	public void indexPage() throws InterruptedException {
		indexpage = new IndexPage();
		ExtentManager.test=(ExtentManager.extent).createTest("login test verified ");
		Log.info("login test start");
		(ExtentManager.test).log(Status.INFO,"verfied ");
		indexpage.login();
		(ExtentManager.test).log(Status.INFO,"login test  ");
		Log.info("login test end");
	}

}
