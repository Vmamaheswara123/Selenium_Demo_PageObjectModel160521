package com.cmr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cmr.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR;
	@FindBy(xpath = "//input[contains(@name,'txtUsername')]")
	WebElement username;
	
	@FindBy(xpath="//input[contains(@type,'password')]")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@name,'Submit')]")
	WebElement inputbtn;
	
	@FindBy(id="divLogo")
	WebElement crmlogo;
	
	//initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCrmLogImage(){
		return crmlogo.isDisplayed();
	} 
	public HomePage login(String usrnm, String paswrd) {
		username.sendKeys(usrnm);
		password.sendKeys(paswrd);
		inputbtn.click();
		
		return new HomePage();
	}
}