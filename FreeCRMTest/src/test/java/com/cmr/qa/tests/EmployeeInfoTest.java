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
import com.crm.qa.util.TestUtil;

public class EmployeeInfoTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TimePage timePeriodPage;
	EmployeeInfo employeeInfo;
	TestUtil testUtil;

	public EmployeeInfoTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		employeeInfo = new EmployeeInfo();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		employeeInfo = homePage.EmployeeInformation();
	}
	@Test(priority=1)
	public void verifyEmployeePageTitle(){
		boolean employeePageTitle = employeeInfo.verifyEmployeetitle();
		Assert.assertTrue(employeePageTitle,"HomePage not matched");
	}
	@Test(priority=2)
	public void selectEmployeeNameTest(){
		employeeInfo.selectEmployeeName("Odis");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}