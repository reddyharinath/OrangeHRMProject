package helpers;

import org.openqa.selenium.WebElement;

public class GeneralHealerClass {

	
	public boolean ifWebelementDisplay(WebElement element) {
		System.out.println(element.getText() +" is displayed or not?");
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
