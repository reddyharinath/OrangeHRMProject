package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.OrangeHRMLoginPage;

public class OrangeHRMLoginPageTest extends BaseClass {
	
	
	
	
	
	@Parameters({"UserName","Password"})
	@Test
	public void orangeHRMLoginTest(String username, String password) throws InterruptedException {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver,OrangeHRMLoginPage.class);
		loginPage.iscompanyLogoElementDispley();
		//loginPage.isfootersElementDispley();
		loginPage.isfooterTextCopyWriteElementDispley();
		//loginPage.isForgotPasswordLinkElementDispley();		
		loginPage.loginToApplication(username,password);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		System.out.println("Assertion got passed....");
		System.out.println("Home page title--->"+driver.getTitle());
		System.out.println("Homepage URL --->"+driver.getCurrentUrl());
		
		
		
		
		
		/*
		 * System.out.println("Test case execution will start"); test =
		 * reports.createTest("Sample test").assignAuthor("Hari").
		 * assignCategory("Testcase execution will start from here"); String titleOfPage
		 * = driver.getTitle(); test.info("the title of the page is--"+titleOfPage);
		 * System.out.println("captured title of the applciation--->"+driver.getTitle())
		 * ; System.out.println("Test case exeution got completed");
		 */
		
	}

}
