package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WalletHubProfile {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='pr-rec-texts-container']/a")
	WebElement reviewLink;

	@FindBy(xpath = "//div[contains(@class,'brgm-user')]/span[@class='brgm-list-title']")
	WebElement userButton;

	@FindBy(xpath = "//div[contains(@class,'brgm-user-list')]/a[contains(@class,brgm-list-it) and contains(@href,'profile')]")
	WebElement profileLink;

	public WalletHubProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verify the review on the profile page
	 * 
	 * @param profileText
	 */
	public void verifyProfilePage(String profileText) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userButton));
		Actions action = new Actions(driver);
		action.moveToElement(userButton).perform();
		profileLink.click();
		wait.until(ExpectedConditions.visibilityOf(reviewLink));
		Assert.assertTrue(reviewLink.getText().contains(profileText));
	}

}
