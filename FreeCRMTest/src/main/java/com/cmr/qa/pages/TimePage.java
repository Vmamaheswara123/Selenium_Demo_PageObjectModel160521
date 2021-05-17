package com.cmr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cmr.qa.base.TestBase;

public class TimePage extends TestBase {
	@FindBy(xpath = "//b[contains(text(),'Time')]")
	WebElement TimePeriod;

	@FindBy(xpath = "//input[contains(@value,'Type for hints...')]")
	WebElement EmployeeName;
	
	@FindBy(xpath = "//input[contains(@value,'View')]")
	WebElement viewbtn;
	
	public TimePage() {
		PageFactory.initElements(driver,this);
	}
	public boolean verifyTimePageTitle() {
		return TimePeriod.isDisplayed();
	}
	public void selectTimePageName(String name) {
		EmployeeName.sendKeys(name);
		viewbtn.click();
	}
}
