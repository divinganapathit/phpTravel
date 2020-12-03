package mavenProject.phpTravel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class TestEnvironment {
	
	static WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeSuite(alwaysRun = true)
	@Parameters({"option"})
	public void testEnvironment(String option) {
		System.out.println(option);
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resource\\chromedriver.exe");
		if (option.contentEquals("false")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
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
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@AfterSuite(alwaysRun = true)
	public void Endmethod() {
		driver.quit();
	}

}