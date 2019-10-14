package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.PageGenerator;

/**
 * The Class BaseTest.
 */
public class BaseTest {

	/** The driver. */
	public WebDriver driver;

	/** The wait. */
	public WebDriverWait wait;

	/** The page. */
	public PageGenerator page;
	public String url = "https://availability.samknows.com/broadband/";
	public String postCode = "RG1 3FJ";
	public static ExtentReports extent;
	public ThreadLocal<ExtentTest> test;


	/**
	 * Class level setup.
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void classLevelSetup() {
		System.setProperty("webdriver.chrome.driver", "mac-driver/chromedriver");
		driver = new ChromeDriver();;
		wait = new WebDriverWait(driver, 15);
		page = new PageGenerator(driver);
		extent = PageGenerator.extent;
		test = PageGenerator.test;
		
	}

	/**
	 * Teardown.
	 */
	@AfterEach
	public void teardown() {
		driver.quit();
		PageGenerator.extent.flush();
	}
	

}
