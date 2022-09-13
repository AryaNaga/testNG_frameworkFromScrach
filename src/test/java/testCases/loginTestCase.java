package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilitiez.BaseClass;
import utilitiez.PageInitializer;
public class loginTestCase extends PageInitializer {

	@Test
	public void userLoginsInSuccessfully() {

		BaseClass.getDriver();

		lp.usernameInputField.sendKeys(BaseClass.getUserProperty("Username"));
		lp.passwordInputField.sendKeys(BaseClass.getUserProperty("Password"));
	    lp.loginButton.click();
	    
    	
		cP.userDropDownOption(BaseClass.getUserProperty("LogoutText"));
//		cP.accountDropDownButton.click();
//		for (WebElement eachOption : cP.accountDropDownList) {
//
//			if (eachOption.getText().equalsIgnoreCase("Logout")) {
//
//				eachOption.click();
//				break;

	Assert.assertEquals(BaseClass.getDriver().getCurrentUrl(), BaseClass.getConfigProperty("url"));
	
	}
}
