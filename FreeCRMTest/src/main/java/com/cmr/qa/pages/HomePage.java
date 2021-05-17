package com.cmr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cmr.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - OR;
	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	WebElement EmployeeInf;

	@FindBy(xpath = "//b[contains(text(),'Leave')]")
	WebElement LeaveList;

	@FindBy(xpath = "//b[contains(text(),'Recruitment')]")
	WebElement Candidates;

	@FindBy(xpath ="//input[@value='Add'and@id='btnAdd']")
	WebElement CandidatesAdd;

	@FindBy(xpath = "//input[@id='addCandidate_firstName']")
	WebElement CandidatesfirstName;

	@FindBy(xpath = "//input[@id='addCandidate_middleName']")
	WebElement CandidatesmiddleName;

	@FindBy(xpath = "//input[@id='addCandidate_lastName']")
	WebElement CandidateslastName;

	@FindBy(id = "addCandidate_contactNo")
	WebElement CandidatecontactNo;

	@FindBy(id = "addCandidate_vacancy")
	WebElement Candidatevacancy;

	@FindBy(id = "addCandidate_appliedDate")
	WebElement CandidateappliedDate;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement CandidatesSave;

	@FindBy(xpath = "//b[contains(text(),'Time')]")
	WebElement TimePeriod;

	public HomePage() {
		PageFactory.initElements(driver,this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public EmployeeInfo EmployeeInformation() {
		EmployeeInf.click();
		return new EmployeeInfo();
	}

	public Leaves LeaveInformation() {
		LeaveList.click();
		return new Leaves();
	}

	public Recruitment RecruitmentInformation() {
		Candidates.click();
		return new Recruitment();
	}

	public void createNewCondidate
	(String fstNm,String midNm,String lstNm,String role) {
		Candidates.click();
		CandidatesAdd.click();
		CandidatesfirstName.sendKeys(fstNm);
		CandidatesmiddleName.sendKeys(midNm);
		CandidateslastName.sendKeys(lstNm);
		//CandidatecontactNo.sendKeys(i);
		Select drndwn = new Select(Candidatevacancy);
		drndwn.selectByVisibleText(role);
		//CandidateappliedDate.sendKeys(j);
		CandidatesSave.click();
	}
	public TimePage ClickOnTimePage() {
		TimePeriod.click();
		return new TimePage();
	}
}