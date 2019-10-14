package pages;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.io.TempDir;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;

import com.aventstack.extentreports.ExtentTest;

/**
 * The Class BasePage.
 */
public class BasePage extends PageGenerator {
    public static WebDriver tempDriver;
	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 * @param test 
	 */
	public BasePage(WebDriver driver) {
		super(driver);
        setTempDriver(driver);
}

	/**
	 * Click.
	 *
	 * @param <T>         the generic type
	 * @param elementAttr the element attr
	 */
	// Click Method by using JAVA Generics (You can use both By or Webelement)
	public <T> void click(T elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			driver.findElement((By) elementAttr).click();
		} else {
			((WebElement) elementAttr).click();
		}
	}

	/**
	 * Write text.
	 *
	 * @param <T>         the generic type
	 * @param elementAttr the element attr
	 * @param text        the text
	 */
	// Write Text by using JAVA Generics (You can use both By or Webelement)
	public <T> void writeText(T elementAttr, String text) {
		if (elementAttr.getClass().getName().contains("By")) {
			driver.findElement((By) elementAttr).sendKeys(text);
		} else {
			((WebElement) elementAttr).sendKeys(text);
		}
	}

	/**
	 * Read text.
	 *
	 * @param <T>         the generic type
	 * @param elementAttr the element attr
	 * @return the string
	 */
	// Read Text by using JAVA Generics (You can use both By or Webelement)
	public <T> String readText(T elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			return driver.findElement((By) elementAttr).getText();
		} else {
			return ((WebElement) elementAttr).getText();
		}
	}

	/**
	 * Handle popup.
	 *
	 * @param by the by
	 * @throws InterruptedException the interrupted exception
	 */
	// Close popup if exists
	public void handlePopup(By by) throws InterruptedException {
		List<WebElement> popup = driver.findElements(by);
		if (popup.isEmpty()) {
			return;
		}
		popup.get(0).click();
		Thread.sleep(200);
	}
	
	/**
	 * Take screenshot.
	 *
	 * @param method the method
	 */
	public static void takeScreenshot(String method) {

		String screenShotFile = method + ".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String fileName = new StringBuilder().append(System.getProperty("user.dir")).append("/reports/screenshots/")
				.append(screenShotFile).toString();
		try {
			FileUtils.copyFile(srcFile, new File(fileName));
			test.get().addScreenCaptureFromPath(fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WebDriver getTempDriver() {
		return tempDriver;
	}

	public void setTempDriver(WebDriver tempDriver) {
		BasePage.tempDriver = tempDriver;
	}
}
