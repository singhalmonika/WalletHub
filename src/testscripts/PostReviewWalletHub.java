package testscripts;

import org.testng.annotations.Test;

import pages.WalletHubHome;
import pages.WalletHubLogin;
import pages.WalletHubReview;

import org.testng.annotations.BeforeTest;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PostReviewWalletHub {
	String driverPath = "chromedriver";

	WebDriver driver;

	WalletHubLogin objSignIn;
	WalletHubHome objHome;
	WalletHubReview objReview;
	String userName = "oikgrh@supersave.net";
	String password = "walletHub@123";
	String randomReviewText = RandomStringUtils.randomAlphanumeric(200);

	


	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://wallethub.com/profile/test_insurance_company/");
	}

	@Test
	public void postReviewWalletHub(){
		//Create object of the Wallethub Home Page
		
		objHome= new WalletHubHome(driver);
		
		//click on Navbar login button
		objHome.clickNavbarLoginButton();
		
		//Login on Wallethub
		
		objSignIn = new WalletHubLogin(driver);
		objSignIn.loginWalletHub(userName, password);
		
		/**Calling the method which will perform following actions
		 * Hover over the stars
		 * Validate that the stars are getting lit on hover
		 * Click on the fourth star
		 */
		
		objHome.hoverClickFourthStar();
		
		objReview = new WalletHubReview(driver);
		
		//Clicking on the policy dropdown
		objReview.clickPolicyDropdown();
		
		//Changing the value of dropdown to "Health Insurance"
		objReview.selectValueHealthInsurance();
		
		//Click on the link “Write a review” and write some random text
		
		objReview.clickWriteReviewLinkAndWriteRandomText(randomReviewText);
		
		//Click on submit button
		
		objReview.clickSubmitButton();
		
		
	}

	@AfterTest
	public void tearDown() {
	}

}
