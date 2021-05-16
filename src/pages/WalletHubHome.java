package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WalletHubHome {
	WebDriver driver;

	@FindBy(xpath = "//span[contains(@class,'brgm-signup-login')]")
	WebElement navbarloginButton;

	@FindBy(xpath = "//div[contains(@class,'review-action ')]//div[@class='rating-box-wrapper']/*[name()='svg']")
	List<WebElement> reviewStars;
	

	public WalletHubHome(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// Click on Login button on Navbar

	public void clickNavbarLoginButton() {
		navbarloginButton.click();

	}
	
	/** This method will perform following actions
	 * Do the hover 
	 * Make sure the stars inside get lit up when you hover over them
	 * click on the fourth star
	 */
	
	public void hoverClickFourthStar() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElements(reviewStars));
		
		for(int i=0;i<reviewStars.size();i++) {
			Actions action = new Actions(driver);
			
			//Hovering over the stars
	        action.moveToElement(reviewStars.get(i)).perform();
	        
	
	         //Assertion for checking that stars are getting lit on hover
	        Assert.assertEquals(reviewStars.get(i).findElement(By.xpath("./*[name()='g']/*[name()='path'][2]")).getCssValue("stroke"),"rgb(74, 224, 225)","The color of the stroke shoud be blue when star is lit");
	       
	        // Clicking on the fourth star
	        if(i==3) {
	        	action.moveToElement(reviewStars.get(i)).click().perform();
	        	break;
	        }
		}
	}

}
