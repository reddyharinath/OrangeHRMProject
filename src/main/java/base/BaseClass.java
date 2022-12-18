package base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helpers.*;

public class BaseClass {
	
	
	public WebDriver driver;
	//Browser
	//AppURL
	
	public ExtentReports reports = new ExtentReports();
	public ExtentSparkReporter reporter = new ExtentSparkReporter("reports/OrangeHRM_Report_At_"+getCurrentTime()+".html");
	public ExtentTest test;
	
	@Parameters({"Browser","AppURL"})
	@BeforeTest
	public void setUp(String Browser,String AppURL) {
		System.out.println(" this is setup method to launch browser and navigate Application URL");
		
		reports.attachReporter(reporter);
		test = reports.createTest("Orange HRM project using - "+Browser).assignAuthor("Hari").assignCategory("Base class");
		test.info("About to start test validation with -- "+Browser);
		driver	= BrowserFactory.navigateApplication(driver, Browser, AppURL);
		System.out.println("Application got launched");
		test.info("Application got loaded and the URL is--"+driver.getCurrentUrl());
		System.out.println("Current url of application is ---> "+driver.getCurrentUrl());
	
	}

	
	
	@AfterTest
	public void tearDown() {
		test.info("Driver Will close...");
		reports.flush();
		System.out.println("Driver will close");
		BrowserFactory.quitDriver(driver);
		System.out.println("Driver closed");
		
	}
	
	
	public static String getCurrentTime() {		
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy hh_MM_ss");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);		
	}
	
	public static String takeScreenShot(WebDriver driver) throws IOException {
		String screenShotsPath = "screenshots/OrangeHRM_Screenshot_At_"+getCurrentTime()+".png";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(screenShotsPath));		
		return screenShotsPath;
		
	}
}
