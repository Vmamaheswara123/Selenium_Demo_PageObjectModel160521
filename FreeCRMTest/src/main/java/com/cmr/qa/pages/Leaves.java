package com.cmr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cmr.qa.base.TestBase;

public class Leaves extends TestBase {
	@FindBy(xpath = "//b[contains(text(),'Leave')]")
	WebElement LeaveList;

	public Leaves() {
		PageFactory.initElements(driver,this);
	}
	public boolean verifyLeavesTitle() {
		return LeaveList.isDisplayed();
	}
	public void selectLeavesName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
}
