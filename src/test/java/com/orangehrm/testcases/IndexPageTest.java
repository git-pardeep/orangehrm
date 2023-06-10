package com.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.IndexPage;

public class IndexPageTest extends BaseClass{
	private IndexPage indexpage;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	@Test
	public void indexPage() throws InterruptedException {
		indexpage=new IndexPage();
		indexpage.login();
	}
	
	
}
