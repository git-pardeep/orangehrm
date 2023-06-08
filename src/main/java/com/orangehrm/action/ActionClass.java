package com.orangehrm.action;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.base.BaseClass;

public class ActionClass extends BaseClass{
	
	public void explicitlyWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void sendKeys(WebElement ele, String text) {
		ele.sendKeys(text);
		ele.sendKeys(Keys.ENTER);
	}

}
