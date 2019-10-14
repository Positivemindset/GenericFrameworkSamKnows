package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

/**
 * The Class LoginPage.
 */
public class BroadbandCheckerPage extends BasePage {

	
	/** The password. */
	@FindBy(how = How.ID, using = "broadband_checker_postcode")
	public WebElement postCodeTextBox;
	@FindBy(how = How.ID, using = "submit-bbchecker")
	public WebElement submitButton;


	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	// *********Constructor*********
	public BroadbandCheckerPage(WebDriver driver) {
		super(driver);
	}

	
	
	
	/**
	 * And ilogin to N 11.
	 *
	 * @param pusername the pusername
	 * @param ppassword the ppassword
	 * @return the login page
	 */
	// *********Page Methods*********
	public BroadbandCheckerPage searchByPostCode(String postCode) {
		test.get().info("In Broaband checker page");
		writeText(postCodeTextBox, postCode);
		click(submitButton);
		takeScreenshot("searchByPostCode");
		test.get().info("clicked submit button");
		return this;
	}

	public BroadbandCheckerResultsPage searchByPostCodeResults() {
 			return new PageFactory().initElements(driver,BroadbandCheckerResultsPage.class);
	}
	

}
