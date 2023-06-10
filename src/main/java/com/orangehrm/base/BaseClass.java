package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ThreadLocal<RemoteWebDriver> driver =new ThreadLocal<>();
//	String Browser="chrome";
	public static Properties prop=new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void loadConfirg() throws IOException {
		DOMConfigurator.configure("Log4j.xml");
		fis = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		prop.load(fis);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public void launchBrowser() {
//		if (System.getProperty("Browser").equalsIgnoreCase("chrome")) {
		
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver.set( new ChromeDriver());
		Log.info("Chrome launch browser");
		}
		if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			}
		if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			}
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public void closeBrowser() {
		
		getDriver().close();
	}

}
