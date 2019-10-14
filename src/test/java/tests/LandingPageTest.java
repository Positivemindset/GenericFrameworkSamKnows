package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import com.aventstack.extentreports.ExtentTest;

import pages.LandingPage;

/**
 * The Class CopyOfLoginTest.
 */
@Execution(ExecutionMode.CONCURRENT)
public class LandingPageTest extends BaseTest {
	/**
	 * Invalid login test invalid user name invalid password 2.
	 */
	@Test
	public void launchURL() {  
		ExtentTest exTest =  extent.createTest("launchURL");
		test.set(exTest);
		page.getPage(LandingPage.class).givenIAmAtLandingPage(url);
		test.get().pass("URL launced");
	}

}
