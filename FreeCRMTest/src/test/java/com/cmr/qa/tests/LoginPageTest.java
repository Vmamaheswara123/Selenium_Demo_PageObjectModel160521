package com.cmr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cmr.qa.base.TestBase;
import com.cmr.qa.pages.HomePage;
import com.cmr.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority=1)
	public void LoginPagetitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test(priority=2)
	public void CrmLogoImageTest(){
		boolean flag = loginPage.validateCrmLogImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}