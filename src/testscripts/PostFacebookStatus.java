package testscripts;

import org.testng.annotations.Test;

import pages.FacebookLogin;
import pages.FacebookStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PostFacebookStatus {
	String driverPath = "chromedriver";

	// Please provide your username and password for testing
	String userName = "";
	String password = "";
	String faceBookStatus = "Hello World";

	WebDriver driver;

	FacebookLogin objLogin;

	FacebookStatus objStatus;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void loginAndPostFacebookStatus() {
		objLogin = new FacebookLogin(driver);

		// Calling login method of Facebook Login Class
		objLogin.loginToFacebook(userName, password);
		objStatus = new FacebookStatus(driver);

		// Calling post status message of Facebook Status Class to post Status message
		// "Hello World" on Facebook
		objStatus.postStatusMessage(faceBookStatus);

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
