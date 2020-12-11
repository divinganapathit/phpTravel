package mavenProject.phpTravel;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/*
 * Author:
 * Date:
 * Info: Test class, to verify the working of different aspect of the website
 * 
 * */
public class TestClass extends TestEnvironment {

	/*
	 * Test method used to verify title of header, with the expected value, from the
	 * website.
	 * 
	 */
	@Test(priority = 1, enabled = true)
	public void compareExpectedAndActualTitle() throws IOException {

		extentTest = extent.createTest("compareExpectedAndActualTitle");
		BasePage objBasePage = new BasePage(driver);
		driver.navigate().to(objBasePage.getData("url"));
		Reporter.log("Navigate to the given URL");
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		String address = objBasePage.getData("title");
		Reporter.log("Store the list of title.");
		int index = objPHPTravelsHomePage.headerTitleString(objPHPTravelsHomePage.listOfHeaders).size();
		System.out.println(index);
		Reporter.log("Using assertion to see if actual and expected titles are equal.");
		for (int i = 0; i < index; i++) {

			System.out.println(objPHPTravelsHomePage.getActualTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objPHPTravelsHomePage.getActualTitle(i));
			softAssertion.assertAll("Actual and expected titles in the website is equal.");

		}
		Reporter.log("Comparison of actual and expected title is completed.");
	}

	/*
	 * Test method used to verify the content in the drop-down option of the
	 * features menu, with the expected value, from the website.
	 * 
	 */
	@Test(priority = 2, enabled = true)
	public void compareExpectedAndActualFeatureTitle() throws InterruptedException, IOException {

		extentTest = extent.createTest("compareExpectedAndActualFeatureTitle");
		BasePage objBasePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		Reporter.log("Point towards features tab.");
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objBasePage.textListMethod(objPHPTravelsHomePage.featureTitle_hover, objPHPTravelsHomePage.featuresList_Xpath);
		String address = objBasePage.getData("feature");
		int index = objBasePage.titleList.size();
		Reporter.log("Store the list of elements that is in features drop-down menu");
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objBasePage.getActualDropDownTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objBasePage.getActualDropDownTitle(i));
			softAssertion.assertAll("Actual and expected titles in the features drop-down is equal");

		}
		Reporter.log("Comparison of actual and expected features drop-down title is completed.");

	}

	/*
	 * Test method used to verify the content in the drop-down option of the product
	 * menu, with the expected value, from the website.
	 * 
	 */
	@Test(priority = 3, enabled = true)
	public void compareExpectedAndActualProductTitle() throws InterruptedException, IOException {

		extentTest = extent.createTest("compareExpectedAndActualProductTitle");
		BasePage objBasePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objBasePage.textListMethod(objPHPTravelsHomePage.productTitle_hover, objPHPTravelsHomePage.productList_Xpath);
		String address = objBasePage.getData("product");
		Reporter.log("Store the list of elements that is in product drop-down menu");
		int index = objBasePage.titleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objBasePage.getActualDropDownTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objBasePage.getActualDropDownTitle(i));
			softAssertion.assertAll("Actual and expected titles in the product drop-down is equal");

		}
		Reporter.log("Comparison of actual and expected product drop-down title is completed.");

	}

	/*
	 * Test method used to verify the content in the drop-down option of the company
	 * menu, with the expected value, from the website.
	 * 
	 */
	@Test(priority = 4, enabled = true)
	public void compareExpectedAndActualCompanyTitle() throws InterruptedException, IOException {

		extentTest = extent.createTest("compareExpectedAndActualCompanyTitle");
		BasePage objBasePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objBasePage.textListMethod(objPHPTravelsHomePage.companyTitle_hover, objPHPTravelsHomePage.companyList_Xpath);
		String address = objBasePage.getData("company");
		Reporter.log("Store the list of elements that is in company drop-down menu");
		int index = objBasePage.titleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objBasePage.getActualDropDownTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objBasePage.getActualDropDownTitle(i));
			softAssertion.assertAll("Actual and expected titles in the company drop-down is equal");

		}
		Reporter.log("Comparison of actual and expected company drop down title is completed.");
	}

	/*
	 * Test method to click on Home page Front End option, and move on to the newly
	 * opened window, and verify the same.
	 * 
	 */
	@Test(priority = 5, enabled = true)
	public void moveToDemoWindow() throws InterruptedException {

		extentTest = extent.createTest("moveToDemoWindow");
		BasePage objBasePage = new BasePage(driver);
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		PHPTravelsDemoFlightBooking objPhpTravelsDemoFlightBooking = new PHPTravelsDemoFlightBooking(driver);
		objBasePage.switchWindows(objPHPTravelsHomePage.hompageFrontEnd_Xpath);
		objPhpTravelsDemoFlightBooking.bookFlightTickect();
		Reporter.log("Completed flight booking.");

	}

//	@BeforeMethod
//	public void beforeMethod() {
//		// comment
//	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		BasePage objBasePage = new BasePage(driver);

		if (result.getStatus() == ITestResult.FAILURE) {

			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			extentTest.fail("<details>" + "<summary>" + "<b>" + "<font color =\'red\'>"
					+ "Exception Occured: Click to see" + "</font>" + "</b>" + "</summary>"
					+ exceptionMessage.replaceAll(",", "<br>") + "</details" + "\n");
			String failLog = "TEST CASE FAILED";
			String screenShotPath = objBasePage.capture();
			extentTest.log(Status.FAIL, "Snapshot below: " + extentTest.addScreenCaptureFromPath(screenShotPath));
			Markup m = MarkupHelper.createLabel(failLog, ExtentColor.RED);
			extentTest.log(Status.FAIL, m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE:" + methodName.toUpperCase() + "  SKIPPED" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.CYAN);

			extentTest.skip(m);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE:" + methodName.toUpperCase() + "  PASSED" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentTest.pass(m);

		}

	}

}
