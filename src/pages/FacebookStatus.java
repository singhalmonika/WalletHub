package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookStatus {
	WebDriver driver;

	@FindBy(xpath = "//span[contains(normalize-space(text()),'on your mind')]")
	WebElement statusBox;

	@FindBy(xpath = "//div[contains(@aria-describedby,'placeholder')]//div[@data-block='true']")
	WebElement createStatusBox;

	@FindBy(xpath = "//div[@aria-label='Post']//span[@dir='auto']")
	WebElement postButton;

	public FacebookStatus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * This method will post status on Facebook
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 * 
	 */
	public void postStatusMessage(String status) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.visibilityOf(statusBox));

		// Click on Facebook status box
		executor.executeScript("arguments[0].click();", statusBox);

		// Create Facebook Status
		wait.until(ExpectedConditions.visibilityOf(createStatusBox));
		executor.executeScript("arguments[0].click();", createStatusBox);
		createStatusBox.sendKeys(status);

		// Post Facebook Status
		wait.until(ExpectedConditions.elementToBeClickable(postButton));
		executor.executeScript("arguments[0].click();", postButton);
	}

}
