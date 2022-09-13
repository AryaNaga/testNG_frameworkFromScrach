package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiez.BaseClass;

public class loginPage {
	
	
	public loginPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(name="username")
	public WebElement usernameInputField;
	@FindBy(name="password")
	public WebElement passwordInputField;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	//public WebElement loginInputField;
	//@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	
//	public Object loginButton;
  public WebElement loginButton;
}





