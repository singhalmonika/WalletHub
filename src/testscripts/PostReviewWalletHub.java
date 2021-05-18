package testscripts;

import org.testng.annotations.Test;

import pages.WalletHubHome;
import pages.WalletHubLogin;
import pages.WalletHubProfile;
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
	WalletHubProfile objProfile;
	String userName = "";
	String password = "";
	String windowTitleReviewConfirmation = "WalletHub - Review Confirmation";
	String headerTextReviewConfirmation = "Awesome!\n" + "Your review has been posted.";
	String txtReviewAuthorField = " Your Review";
	String randomReviewText = RandomStringUtils.randomAlphanumeric(200);
	String profileText = "Test Insurance Company";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://wallethub.com/profile/test_insurance_company/");
	}

	@Test
	public void postReviewWalletHub() {
		// Create object of the Wallethub Home Page
		objHome = new WalletHubHome(driver);

		// click on Navbar login button
		objHome.clickNavbarLoginButton();

		// Login on Wallethub
		objSignIn = new WalletHubLogin(driver);
		objSignIn.loginWalletHub(userName, password);

		/**
		 * Calling the method which will perform following actions Hover over the stars
		 * Validate that the stars are getting lit on hover Click on the fourth star
		 */

		objHome.hoverClickFourthStar();
		objReview = new WalletHubReview(driver);

		// Clicking on the policy dropdown
		objReview.clickPolicyDropdown();

		// Changing the value of dropdown to "Health Insurance"
		objReview.selectValueHealthInsurance();

		// Click on the link “Write a review” and write some random text
		objReview.clickWriteReviewLinkAndWriteRandomText(randomReviewText);

		// Click on submit button
		objReview.clickSubmitButton();

		// Verify Review Confirmation Screen
		objReview.verifyReviewConfirmationScreen(headerTextReviewConfirmation, windowTitleReviewConfirmation);

		// Click on continue button
		objReview.clickContinueButton();

		// Verify that your review is posted on the test insurance company page
		objHome.verifyReviewAuthorField(txtReviewAuthorField);

		// Verify the review on profile page
		objProfile = new WalletHubProfile(driver);
		objProfile.verifyProfilePage(profileText);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
