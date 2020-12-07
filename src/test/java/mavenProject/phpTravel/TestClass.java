package mavenProject.phpTravel;

import java.io.IOException;

import org.testng.annotations.Test;

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

		BasePage objBasePage = new BasePage(driver);
		driver.navigate().to(objBasePage.getData("url"));
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		String address = objBasePage.getData("title");
		int index = objPHPTravelsHomePage.headerTitleString(objPHPTravelsHomePage.listOfHeaders).size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objPHPTravelsHomePage.getActualTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objPHPTravelsHomePage.getActualTitle(i));

		}
	}

	/*
	 * Test method used to verify the content in the drop-down option of the features
	 * menu, with the expected value, from the website.
	 * 
	 */
	@Test(priority = 2, enabled = true)
	public void compareExpectedAndActualFeatureTitle() throws InterruptedException, IOException {

		BasePage objBasePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objBasePage.textListMethod(objPHPTravelsHomePage.featureTitle_hover, objPHPTravelsHomePage.featuresList_Xpath);
		String address = objBasePage.getData("feature");
		int index = objBasePage.titleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objBasePage.getActualDropDownTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objBasePage.getActualDropDownTitle(i));

		}

	}

	/*
	 * Test method used to verify the content in the drop-down option of the product
	 * menu, with the expected value, from the website.
	 * 
	 */
	@Test(priority = 3, enabled = true)
	public void compareExpectedAndActualProductTitle() throws InterruptedException, IOException {
		
		
		

		BasePage objBasePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objBasePage.textListMethod(objPHPTravelsHomePage.productTitle_hover, objPHPTravelsHomePage.productList_Xpath);
		String address = objBasePage.getData("product");
		int index = objBasePage.titleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objBasePage.getActualDropDownTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objBasePage.getActualDropDownTitle(i));

		}

	}

	/*
	 * Test method used to verify the content in the drop-down option of the company
	 * menu, with the expected value, from the website.
	 * 
	 */
	@Test(priority = 4, enabled = true)
	public void compareExpectedAndActualCompanyTitle() throws InterruptedException, IOException {

		BasePage objBasePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objBasePage.textListMethod(objPHPTravelsHomePage.companyTitle_hover, objPHPTravelsHomePage.companyList_Xpath);
		String address = objBasePage.getData("company");
		int index = objBasePage.titleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(objBasePage.getActualDropDownTitle(i));
			softAssertion.assertEquals(objBasePage.getExcelData(i, address), objBasePage.getActualDropDownTitle(i));

		}
	}

	/*
	 * Test method to click on Home page Front End option, and move on to the newly
	 * opened window, and verify the same.
	 * 
	 */
	@Test(priority = 5, enabled = true)
	public void moveToDemoWindow() throws InterruptedException {

		BasePage objBasePage = new BasePage(driver);
		PHPTravelsHomePage objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		PHPTravelsDemoFlightBooking objPhpTravelsDemoFlightBooking = new PHPTravelsDemoFlightBooking(driver);
		objBasePage.switchWindows(objPHPTravelsHomePage.hompageFrontEnd_Xpath);
		objPhpTravelsDemoFlightBooking.bookFlightTickect();

	}

}
