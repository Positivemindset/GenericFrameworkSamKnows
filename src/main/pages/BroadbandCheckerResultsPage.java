package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * The Class LoginPage.
 */
public class BroadbandCheckerResultsPage extends BasePage {

	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='summary']/div[2]")
	public WebElement successMessage;


	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	// *********Constructor*********
	public BroadbandCheckerResultsPage(WebDriver driver) {
		super(driver);
	}
	
	
	public BroadbandCheckerResultsPage validateResultsPage(String message) {
		assertEquals(readText(successMessage), message);
		return this;
	}

	

}
