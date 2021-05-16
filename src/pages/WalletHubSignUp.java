package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletHubSignUp {
	WebDriver driver;

	@FindBy(id = "em-ipt")

	WebElement userName;

	@FindBy(id = "pw1-ipt")

	WebElement password;

	@FindBy(id = "pw2-ipt")

	WebElement confirmPassword;

	@FindBy(xpath = "//label[@class='check']/span")

	WebElement creditCheckbox;

	@FindBy(xpath = "//button[@class='btn blue touch-element-cl']")

	WebElement joinButton;

	public WalletHubSignUp(WebDriver driver) {

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

	// Set password in the Confirm Password text box

	public void setConfirmPassword(String strPassword) {

		confirmPassword.sendKeys(strPassword);

	}

	// Click on join button

	public void clickJoinButton() {

		joinButton.click();

	}

	/**
	 * 
	 * This method will SignUp on WalletHub
	 * 
	 * @param strUserName
	 * 
	 * @param strUserName
	 * 
	 * @return
	 * @throws InterruptedException 
	 * 
	 */

	public void SignUpWalletHub(String strUserName, String strPasword) throws InterruptedException {

		// Fill Username
        Thread.sleep(3000);
		this.setUserName(strUserName);

		// Fill Password

		this.setPassword(strPasword);
		
		//Fill Confirm Password
		
		this.setConfirmPassword(strPasword);
		
		//Uncheck the checkbox to get your free credit score and report
		
		this.creditCheckbox.click();

		// Click Join button

		this.clickJoinButton();

	}

}
