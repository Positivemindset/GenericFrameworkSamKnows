package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import com.aventstack.extentreports.ExtentTest;

import pages.LandingPage;

/**
 * The Class LoginTest.
 */
@Execution(ExecutionMode.CONCURRENT)
public class BroadbandCheckerTest extends BaseTest {
	public String bcResultsSuccessMessage = "Congratulations, you are in a broadband enabled area.";
	/**
	 * Invalid login test invalid user name invalid password.
	 */
	@Test
	public void searchByPostcode() {
		ExtentTest exTest =  extent.createTest("searchByPostcode");
		test.set(exTest);
		page.getPage(LandingPage.class).givenIAmAtLandingPage(url).gotoBBCheckerPage().searchByPostCode(postCode);
		test.get().pass("Searched by postcode");
	}

	@Test
	public void bcSearchResultsPageForValidPost() {
		ExtentTest exTest =  extent.createTest("bcSearchResultsPageForValidPost");
		test.set(exTest);
		try {
		page.getPage(LandingPage.class).givenIAmAtLandingPage(url).gotoBBCheckerPage().searchByPostCode(postCode)
				.searchByPostCodeResults().validateResultsPage(bcResultsSuccessMessage);
		test.get().pass("Results Page displayed with validmessage");

		}catch (Exception e ) {
			test.get().fail("Results Page is not displayed with validmessage");

		}

	}
}
