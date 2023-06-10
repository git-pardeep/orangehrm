package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
//	public static ThreadLocal<WebDriver> driver =new ThreadLocal<>();
	public static WebDriver driver;
//	String Browser="chrome";
	public static Properties prop=new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void loadConfirg() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		prop.load(fis);
	}
	
	public void launchBrowser() {
//		if (System.getProperty("Browser").equalsIgnoreCase("chrome")) {
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}
		if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public void closeBrowser() {
		driver.close();
	}

}
