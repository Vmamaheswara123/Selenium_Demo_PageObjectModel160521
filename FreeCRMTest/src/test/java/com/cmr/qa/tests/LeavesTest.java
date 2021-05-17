package com.cmr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cmr.qa.base.TestBase;
import com.cmr.qa.pages.HomePage;
import com.cmr.qa.pages.Leaves;
import com.cmr.qa.pages.LoginPage;
import com.cmr.qa.pages.TimePage;
import com.crm.qa.util.TestUtil;

public class LeavesTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TimePage timePeriodPage;
	Leaves leaves;
	TestUtil testUtil;

	public LeavesTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		leaves = new Leaves();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		leaves = homePage.LeaveInformation();
	}
	@Test(priority=1)
	public void verifyLeavesPageTitle(){
		boolean leavesPageTitle = leaves.verifyLeavesTitle();
		Assert.assertTrue(leavesPageTitle,"HomePage not matched");
	}
	@Test(priority=2)
	public void selectLeavesNameTest(){
		leaves.selectLeavesName("Orange Test");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}