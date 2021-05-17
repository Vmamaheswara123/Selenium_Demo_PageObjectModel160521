package com.cmr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cmr.qa.base.TestBase;
import com.cmr.qa.pages.HomePage;
import com.cmr.qa.pages.LoginPage;
import com.cmr.qa.pages.Recruitment;
import com.crm.qa.util.TestUtil;

public class RecruitmentTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Recruitment recruitment;
	TestUtil testUtil;
	
	String sheetName="Recruitment";

	public RecruitmentTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		recruitment = new Recruitment();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		recruitment = homePage.RecruitmentInformation();
	}
	@Test(priority=1)
	public void verifyEmployeePageTitle(){
		boolean RecruitmentPageTitle = recruitment.verifyRecruitmentTitle();
		Assert.assertTrue(RecruitmentPageTitle,"HomePage not matched");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3, dataProvider="getCRMTestData")
	public void createNewCandidate
	(String CfirstName,String CmidName,String ClastName,String Crole){
		homePage.createNewCondidate(CfirstName,CmidName,ClastName,Crole);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}