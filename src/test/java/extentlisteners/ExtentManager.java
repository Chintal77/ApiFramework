package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Jr. Test Engineer", "Gaurav Purohit");
		extent.setSystemInfo("Organization", "AQM Technologies");
		extent.setSystemInfo("Build no", "A-1,401,RAHEJA PLAZA");

		return extent;
	}

	/*
	 * public static String screenshotPath; public static String screenshotName;
	 * 
	 * public static void captureScreenshot() {
	 * 
	 * File scrFile = ((TakesScreenshot)
	 * DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	 * 
	 * Date d = new Date(); screenshotName = d.toString().replace(":",
	 * "_").replace(" ", "_") + ".jpg";
	 * 
	 * try { FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +
	 * "\\reports\\" + screenshotName)); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */

}
