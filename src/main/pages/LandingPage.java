package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * The Class HomePage.
 */
public class LandingPage extends BasePage {

	
	@FindBy(how = How.XPATH, using = "//*[@id=\'left-side\']/div[2]/a[2]/h4")
	public WebElement bbCheckerLink;

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	// *********Constructor*********
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	// *********Page Methods*********
	/**
	 * Given I am at Landing page.
	 *
	 * @return the Landing page
	 */
	// Go to Landingpage
	public LandingPage givenIAmAtLandingPage(String url) {
		//test.get().info("In givenIAmAtLandingPage");
		driver.get(url);
		takeScreenshot("givenIAmAtLandingPage");
		return this;
	}

	
	

	public BroadbandCheckerPage gotoBBCheckerPage() {
		test.get().info("In gotoBBCheckerPage");
		takeScreenshot("gotoBBCheckerPage");
		click(bbCheckerLink);
		return new PageFactory().initElements(driver, BroadbandCheckerPage.class);
	}
}