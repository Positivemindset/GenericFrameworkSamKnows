package pages;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * The Class ExtentManager.
 */
public class ExtentManager {

	/** The d. */
	static Date d = new Date();

	/** The extent. */
	private static ExtentReports extent;

	/** The platform. */
	private static Platform platform;

	/** The report file name. */
	private static String reportFileName = "Paralleltesting.html";

	/** The mac path. */
	private static String macPath = System.getProperty("user.dir") + "/reports";

	/** The windows path. */
	private static String windowsPath = System.getProperty("user.dir") + "\\reports";

	/** The mac report file loc. */
	private static String macReportFileLoc = new StringBuilder().append(macPath).append("/").append(reportFileName)
			.toString();

	/** The win report file loc. */
	private static String winReportFileLoc = new StringBuilder().append(windowsPath).append("\\").append(reportFileName)
			.toString();

	/**
	 * Gets the single instance of ExtentManager.
	 *
	 * @return single instance of ExtentManager
	 */
	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	/**
	 * Creates the instance.
	 *
	 * @return the extent reports
	 */
	// Create an extent report instance
	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String fileName = getReportFileLocation(platform);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

	/**
	 * Gets the report file location.
	 *
	 * @param platform the platform
	 * @return the report file location
	 */
	// Select the extent report file location based on platform
	private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		switch (platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
			createReportPath(macPath);
			System.out.println(
					new StringBuilder().append("ExtentReport Path for MAC: ").append(macPath).append("\n").toString());
			break;
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
			createReportPath(windowsPath);
			System.out.println(new StringBuilder().append("ExtentReport Path for WINDOWS: ").append(windowsPath)
					.append("\n").toString());
			break;
		default:
			System.out.println("ExtentReport path has not been set! There is a problem!\n");
			break;
		}
		return reportFileLocation;
	}

	/**
	 * Creates the report path.
	 *
	 * @param path the path
	 */
	// Create the report path if it does not exist
	private static void createReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println(
						new StringBuilder().append("Directory: ").append(path).append(" is created!").toString());
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	/**
	 * Gets the current platform.
	 *
	 * @return the current platform
	 */
	// Get current platform
	private static Platform getCurrentPlatform() {
		if (platform == null) {
			String operSys = StringUtils.lowerCase(System.getProperty("os.name"));
			if (StringUtils.contains(operSys, "win")) {
				platform = Platform.WINDOWS;
			} else if (StringUtils.contains(operSys, "nix") || StringUtils.contains(operSys, "nux")
					|| StringUtils.contains(operSys, "aix")) {
				platform = Platform.LINUX;
			} else if (StringUtils.contains(operSys, "mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}
}