package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WalletHubReview {
	
	WebDriver driver;

	@FindBy(xpath = "//div[@class='dropdown second']")
	WebElement policyDropdown;

	@FindBy(xpath = "//ul/li[text()='Health Insurance']")
	WebElement dropdownValueSelect;
	
	@FindBy(xpath="//textarea[@class='textarea wrev-user-input validate']")
	WebElement writeReviewLink;
	
	@FindBy(xpath="//div[contains(@class,'sbn-action')]")
	WebElement submitButton;
	
	@FindBy(className="rvc-header")
	WebElement headerTextReview;
	
	@FindBy(className="btn rvc-continue-btn")
	WebElement continueButton;
	

	public WalletHubReview(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	//Click on policy dropdown
	
	public void clickPolicyDropdown() {

		policyDropdown.click();

	}
	
	//Changing the value of dropdown to "Health Insurance"
	
	public void selectValueHealthInsurance() {
		dropdownValueSelect.click();
		
	}
	
	//Clicking on write a review link and write some Random Text
	public void clickWriteReviewLinkAndWriteRandomText(String randomText) {

		writeReviewLink.click();
		writeReviewLink.sendKeys(randomText);

	}
	
	//Click on submit button
	
	public void clickSubmitButton() {

		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(headerTextReview));
		System.out.println(driver.getTitle());
		System.out.println(headerTextReview.getText());

	}
	
	


}
