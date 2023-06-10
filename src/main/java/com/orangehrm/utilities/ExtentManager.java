package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
	public static ExtentReports extent =new ExtentReports();
	public static ExtentSparkReporter sparkreporter;
	public static ExtentTest test;
	
	
	public static void setExtent() throws IOException {
		sparkreporter =new ExtentSparkReporter(new File(System.getProperty("user.dir")+"\\report\\myreport.html"));
		sparkreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("HostName", "PardeeP-PC");
		extent.setSystemInfo("Window", "Os-10");
		extent.setSystemInfo("Project", "orange");
	}
	public static void endExtent() {
		extent.flush();
	}
}
