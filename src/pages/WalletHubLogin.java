package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WalletHubLogin {
	WebDriver driver;

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(@class,'reg-tabs-bt touch-element-cl')]")
	WebElement loginButton;
	
	public WalletHubLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set user name in text box
	 * @param strUserName
	 */
	public void setUserName(String strUserName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys(strUserName);
	}

	/**
	 * Set password in password text box
	 * @param strPassword
	 */
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	/**
	 * Click on login button
	 */
	public void clickLoginButton() {
		loginButton.click();
	}

	/**
	 * This method will SignUp on WalletHub
	 * 
	 * @param strUserName
	 * @param strPasword
	 */
	public void loginWalletHub(String strUserName, String strPasword) {
		// Fill Username
		this.setUserName(strUserName);
		// Fill Password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLoginButton();
	}

}
