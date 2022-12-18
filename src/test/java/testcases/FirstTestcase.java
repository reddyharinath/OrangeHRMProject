package testcases;

import org.testng.annotations.Test;

import base.BaseClass;

public class FirstTestcase extends BaseClass {
	
	
	@Test
	public void testcase() {
		System.out.println("Test case execution will start");
		test = reports.createTest("Sample test").assignAuthor("Hari").assignCategory("Testcase execution will start from here");
		String titleOfPage = driver.getTitle();
		test.info("the title of the page is--"+titleOfPage);
		System.out.println("captured title of the applciation--->"+driver.getTitle());
		System.out.println("Test case exeution got completed");
	}

}
