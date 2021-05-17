package com.cmr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cmr.qa.base.TestBase;
import com.cmr.qa.pages.HomePage;
import com.cmr.qa.pages.LoginPage;
import com.cmr.qa.pages.TimePage;
import com.crm.qa.util.TestUtil;

public class TimePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TimePage timePeriodPage;
	TestUtil testUtil;

	public TimePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		timePeriodPage = new TimePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		timePeriodPage = homePage.ClickOnTimePage();
	}
	@Test(priority=1)
	public void verifyTimePagePageTitle(){
		boolean timePeriodPagePageTitle = timePeriodPage.verifyTimePageTitle();
		Assert.assertTrue(timePeriodPagePageTitle,"HomePage not matched");
	}
	@Test(priority=2)
	public void selectTimePageNameTest(){
		timePeriodPage.selectTimePageName("Charlie Carter");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}