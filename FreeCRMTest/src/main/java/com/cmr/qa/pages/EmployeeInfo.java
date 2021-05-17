package com.cmr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cmr.qa.base.TestBase;

public class EmployeeInfo extends TestBase{

	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	WebElement EmployeeInf;

	public EmployeeInfo() {
		PageFactory.initElements(driver,this);
	}
	public boolean verifyEmployeetitle() {
		return EmployeeInf.isDisplayed();
	}
	public void selectEmployeeName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
}
