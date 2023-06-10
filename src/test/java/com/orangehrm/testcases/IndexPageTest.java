package com.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.IndexPage;
import com.orangehrm.utilities.Log;

public class IndexPageTest extends BaseClass{
	private IndexPage indexpage;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		Log.info("Close browser");
		getDriver().quit();
	}
	@Test
	public void indexPage() throws InterruptedException {
		indexpage=new IndexPage();
		Log.info("login test start");
		indexpage.login();
		Log.info("login test end");
	}
	
	
}
