package mavenProject.phpTravel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * Author:
 * Date:
 * Info: Class to setup the test environment
 * 
 * 
 * */
public class TestEnvironment {

	static WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();
	public static ExtentReports extent;
	public  static ExtentTest extentTest;
	public static ExtentHtmlReporter htmlReport;

	/*
	 * Method to open the Chrome browser in normal or incognito mode depending upon
	 * parameter that is passed.
	 *
	 * 
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "option" })
	public void testEnvironment(String option) {
		System.out.println(option);
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resource\\chromedriver.exe");
		if (option.contentEquals("false")) {
			driver = new ChromeDriver();
			Reporter.log("Launching Chrome Browser.");
			driver.manage().window().maximize();
			Reporter.log("Maximize the browser window.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("test-type");
			options.addArguments("--disable-notifications");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			Reporter.log("Launching Chrome Browser in Incognito mode.");
			driver.manage().window().maximize();
			Reporter.log("Maximize the browser window.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	/*
	 * Method that is executed once all the test is done, in this method driver and
	 * browser is closed.
	 * 
	 */
	@AfterSuite(alwaysRun = true)
	public void Endmethod() {
		driver.quit();
		Reporter.log("Close the browser and end all the tasks related to browser.");
	}

	@BeforeTest
	public void setExtent() {

		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		htmlReport.config().setDocumentTitle("Automation testing");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setReportName("PHP Travels Testing");
		htmlReport.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReport);

	}
	
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}

}
