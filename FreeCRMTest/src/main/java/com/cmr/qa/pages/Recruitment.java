package com.cmr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cmr.qa.base.TestBase;

public class Recruitment extends TestBase {
	@FindBy(xpath = "//b[contains(text(),'Recruitment')]")
	WebElement Candidates;

	public Recruitment() {
		PageFactory.initElements(driver,this);
	}
	public boolean verifyRecruitmentTitle() {
		return Candidates.isDisplayed();
	}
	public void selectRecruitmentName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
}
