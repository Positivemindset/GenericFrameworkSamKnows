package pages;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * The Class PageGenerator.
 */
public class PageGenerator {

	/** The driver. */
	public WebDriver driver;
	public static final ExtentReports extent = ExtentManager.createInstance();
	public static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	/**
	 * Instantiates a new page generator.
	 *
	 * @param driver the driver
	 * @param test2 
	 */
	public PageGenerator(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Gets the page.
	 *
	 * @param <tpage>   the generic type
	 * @param pageClass the page class
	 * @return the page
	 */
	// JAVA Generics to Create and return a New Page
	public <tpage extends BasePage> tpage getPage(Class<tpage> pageClass) {
		try {
			// Initialize the Page with its elements and return it.
			return PageFactory.initElements(driver, pageClass);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	
}
