package mavenProject.phpTravel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestClass extends TestEnvironment {

	@Test(priority = 1, enabled = true)
	public void compareExpectedAndActualTitle() throws IOException {

		BasePage basePage = new BasePage(driver);
		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage homepage = new PHPTravelsHomePage(driver);
		String address = basePage.getData("title");
		int index = homepage.headerTitleString(homepage.listOfHeaders).size();
		homepage.out();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(homepage.getActualTitle(i));
			softAssertion.assertEquals(basePage.getExcelData(i, address), homepage.getActualTitle(i));

		}
	}

	@Test(priority = 2, enabled = true)
	public void compareExpectedAndActualFeatureTitle() throws InterruptedException, IOException {

		BasePage basePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage features = new PHPTravelsHomePage(driver);
		features.featuresTextList();
		String address = basePage.getData("feature");
		int index = features.featureTitleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(features.getActualFeatureTitle(i));
			softAssertion.assertEquals(basePage.getExcelData(i, address), features.getActualFeatureTitle(i));

		}

	}

	@Test(priority = 3, enabled = true)
	public void compareExpectedAndActualProductTitle() throws InterruptedException, IOException {

		BasePage basePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage product = new PHPTravelsHomePage(driver);
		product.productTextList();
		String address = basePage.getData("product");
		int index = product.productTitleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(product.getActualProductTitle(i));
			softAssertion.assertEquals(basePage.getExcelData(i, address), product.getActualProductTitle(i));

		}

	}

	@Test(priority = 4, enabled = true)
	public void compareExpectedAndActualCompanyTitle() throws InterruptedException, IOException {

		BasePage basePage = new BasePage(driver);
//		driver.navigate().to(basePage.getData("url"));
		PHPTravelsHomePage company = new PHPTravelsHomePage(driver);
		company.productTextList();
		String address = basePage.getData("company");
		int index = company.productTitleList.size();
		System.out.println(index);
		for (int i = 0; i < index; i++) {

			System.out.println(company.getActualProductTitle(i));
			softAssertion.assertEquals(basePage.getExcelData(i, address), company.getActualProductTitle(i));

		}
	}

	@Test(priority = 5, enabled = true)
	public void moveToDemoWindow() {
		
		BasePage basePage = new BasePage(driver);
		WebElement xpath = driver.findElement(By.xpath("//a[contains(text(),'Demo')]"));
		basePage.switchWindows(xpath);

	}

}
