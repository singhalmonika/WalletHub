package testscripts;

import org.testng.annotations.Test;

import pages.WalletHubSignUp;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SignUpWalletHub {
	String driverPath = "chromedriver";

	WebDriver driver;
	
	WalletHubSignUp objSignUp;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wallethub.com/join/light");
	}

	@Test
	public void f() throws InterruptedException {
		objSignUp = new WalletHubSignUp(driver);
		objSignUp.SignUpWalletHub("qngsjfnt@supersave.net", "walletHub@123");
		
		}

	@AfterTest
	public void afterTest() {
	}

}
