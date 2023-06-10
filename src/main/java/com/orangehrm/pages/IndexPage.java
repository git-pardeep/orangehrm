package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.action.ActionClass;

public class IndexPage extends BaseClass {
	ActionClass action=new ActionClass();
	@FindBy(name = "username")
	private WebElement usr;
	@FindBy(name = "password")
	private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickbtn;
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void login() throws InterruptedException {
	action.explicitlyWait(usr);
//	Thread.sleep(1000);
	action.sendKeys(usr, "Admin");
	action.explicitlyWait(pwd);
//	Thread.sleep(1000);
	action.sendKeys(pwd, "admin123");
	Thread.sleep(2000);
	clickbtn.click();
	}
}
