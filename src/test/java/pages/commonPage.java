package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiez.BaseClass;

public class commonPage {

	public commonPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='app']/div/div/header/div/div[2]/ul/li/span")
	public WebElement accountDropDownButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li")
	public List<WebElement> accountDropDownList;
	
//	
//	cP.accountDropDownButton.click();
//	 lp.loginButton)).click();
	public void userDropDownOption(String option) {
		
		accountDropDownButton.click();
		for (WebElement eachOption : accountDropDownList) {
			if (eachOption.getText().equalsIgnoreCase(option)) {
				eachOption.click();
				break;
			}
		}

	}

}
