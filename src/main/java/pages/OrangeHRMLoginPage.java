package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;
import helpers.GeneralHealerClass;

public class OrangeHRMLoginPage {
	WebDriver driver;
	GeneralHealerClass healperClass = new GeneralHealerClass();
	
	public OrangeHRMLoginPage(WebDriver ldriver) {
		this.driver=ldriver;		
	}

	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement userPasswordfield;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement companyLogo;
	
	@FindBy(linkText = "//p[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-footer-sm']")
	WebDriver footers;
	
	@FindBy(xpath = "//div[@class='orangehrm-copyright-wrapper']")
	WebElement footerTextCopyWrite;
	
	public void iscompanyLogoElementDispley() {
		System.out.println("logo vlidation");
		companyLogo.isDisplayed();
		System.out.println("logo displayed");
	}
	
	public void isForgotPasswordLinkElementDispley() {
		System.out.println("forgot link vlidation");
		forgotPasswordLink.isDisplayed();
		System.out.println("forgot link is displayed");
	}
	
	public void isfootersElementDispley() {
		System.out.println("footer link vlidation");
		forgotPasswordLink.isDisplayed();
		System.out.println("footer link is displayed");
	}
	
	public void isfooterTextCopyWriteElementDispley() {
		System.out.println("copy right link vlidation");
		footerTextCopyWrite.isDisplayed();
		System.out.println("copy right link is displayed");
	}
	
	public void loginToApplication(String uName, String uPassword) throws InterruptedException {
		if (userNameField.isDisplayed()) {
			System.out.println("username feild displayed....");
			userNameField.clear();
			System.out.println("username feild data cleared....");
			userNameField.sendKeys(uName);
			System.out.println("username feild data entered....");
		} else {
			System.out.println("username feild not displayed....");
		}
		
		
		if (userPasswordfield.isDisplayed()) {
			System.out.println("password feild displayed....");
			userPasswordfield.clear();
			System.out.println("password feild data cleared....");
			userPasswordfield.sendKeys(uPassword);
			System.out.println("password feild data entered....");
		} else {
			System.out.println("password feild not displayed....");
		}
		
		if (submitButton.isDisplayed()) {
			System.out.println("Submit button displayed");
			submitButton.click();
			System.out.println("submit button got clicked....");
			Thread.sleep(5000);
		} else {
			System.out.println("Submit button not displayed");
		}
		
	}
	
	
	
	
	
}
