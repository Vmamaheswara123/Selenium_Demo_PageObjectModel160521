package com.cmr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cmr.qa.base.TestBase;
import com.cmr.qa.pages.EmployeeInfo;
import com.cmr.qa.pages.HomePage;
import com.cmr.qa.pages.LoginPage;
import com.cmr.qa.pages.TimePage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TimePage timePeriodPage;
	EmployeeInfo employeeInfo;

	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		timePeriodPage = new TimePage();
		employeeInfo = new EmployeeInfo();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"OrangeHRM","HomePage not matched");
	}
	@Test(priority=2)
	public void verifyWelcometxst(){
		employeeInfo = homePage.EmployeeInformation();
	}
	@Test(priority=3)
	public void VerifyTimePeriod(){
		timePeriodPage = homePage.ClickOnTimePage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}