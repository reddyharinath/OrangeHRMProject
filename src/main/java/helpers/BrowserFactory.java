package helpers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory {

	public static WebDriver navigateApplication(WebDriver driver, String browserName, String applicationURL) {
		
		Reporter.log("the exeuctable broseer is -- "+browserName);
		System.out.println("the exeuctable broseer is -- "+browserName);
		if (browserName.equalsIgnoreCase("chrome")||browserName.equalsIgnoreCase("chromedriver")) {
			driver= new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")||browserName.equalsIgnoreCase("firefoxdriver")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")||browserName.equalsIgnoreCase("edgedriver")) {
			driver = new EdgeDriver();
		}else {
			System.out.println(" we will not support this browser, please use supported browser -->"+browserName);
		}
		
		driver.manage().window().maximize();
		driver.get(applicationURL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
	}
	
	
	public static void quitDriver(WebDriver driver) {
		driver.quit();
	}
}
