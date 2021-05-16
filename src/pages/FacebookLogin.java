package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLogin {

	WebDriver driver;

	@FindBy(id = "email")

	WebElement userName;

	@FindBy(id = "pass")

	WebElement password;

	@FindBy(xpath = "//button[@data-testid='royal_login_button']")

	WebElement login;

	public FacebookLogin(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

	// Set user name in text box

	public void setUserName(String strUserName) {

		userName.sendKeys(strUserName);
	}

	// Set password in password text box

	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	/**
	 * 
	 * This method will login on Facebook
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @return
	 * 
	 */

	public void loginToFacebook(String strUserName, String strPasword) {

		// Fill Username

		this.setUserName(strUserName);

		// Fill Password 

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}

}
