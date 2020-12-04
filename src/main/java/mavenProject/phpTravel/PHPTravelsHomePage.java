package mavenProject.phpTravel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Author:
 * Date:
 * Info: Class that contains xpaths, methods to perform certain tasks on the website.
 * 
 * */
public class PHPTravelsHomePage extends BasePage {

	/*
	 * Initialization of webelement that are used to perform tasks on.
	 * 
	 */

	@FindBy(xpath = "(//*[contains(@class,'clearfix')]//div[contains(@class,'lvl-0')]//span)|(//*[contains(@class,'clearfix')]//a[contains(@class,'lvl-0')])")
	public WebElement listOfHeaders;

	@FindBy(xpath = "(//*[contains(text(),'Features')]/parent::*[contains(@class,'dropdown')])[1]//div//a")
	public WebElement featuresList_Xpath;

	@FindBy(xpath = "(//*[contains(text(),'Product')]/parent::*[contains(@class,'dropdown')])[1]//div//a")
	public WebElement productList_Xpath;

	@FindBy(xpath = "(//*[contains(text(),'Company')]/parent::*[contains(@class,'dropdown')])[1]//div//a")
	public WebElement companyList_Xpath;

	@FindBy(xpath = "//*[contains(text(),'http://www.phptravels.net')]")
	public WebElement hompageFrontEnd_Xpath;

	@FindBy(xpath = "//*[contains(@class,'lvl-0 dropdown')][1]")
	public WebElement featureTitle_hover;

	@FindBy(xpath = "//*[contains(@class,'lvl-0 dropdown')][2]")
	public WebElement productTitle_hover;

	@FindBy(xpath = "//span[contains(text(),'Company')]/..")
	public WebElement companyTitle_hover;

	List<String> titleList = new ArrayList<String>();
	List<WebElement> headerTitle;
//	List<String> featureTitleList = new ArrayList<String>();
//	List<String> productTitleList = new ArrayList<String>();
//	List<String> companyTitleList = new ArrayList<String>();

	public PHPTravelsHomePage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*
	 * Method to extract all the titles in the website and return the list of it.
	 * 
	 */
	public List<String> headerTitleString(WebElement xpath) {

		String headerTitleLocator = xpathToString(xpath);
		headerTitle = driver.findElements(By.xpath(headerTitleLocator));
		int listIndex = headerTitle.size();
		System.out.println(listIndex);
//		System.out.println(headerTitle);
		Iterator<WebElement> listIterator = headerTitle.iterator();
		while (listIterator.hasNext()) {

			// String headerIndividualXpath = xpathToString(listIterator.next());
			String title = listIterator.next().getText();
//			System.out.println("!!!!!!!!!!!!!" + title);
			titleList.add(title);

		}

		int listSize = titleList.size();
		titleList.remove(listSize - 1);
		return titleList;

	}

	public String getActualTitle(int testIndex) {

		List<String> actualTitleList = new ArrayList<String>();
		actualTitleList = titleList;
		return actualTitleList.get(testIndex);

	}
//
//	/*
//	 * Method to extract all the element in the drop-down menu of features option
//	 * and return the list of element.
//	 * 
//	 */
//	public List<String> featuresTextList() throws InterruptedException {
//
//		String xpath = xpathToString(featuresList_Xpath);
//		System.out.println(xpath);
//		hover(featureTitle_hover);
//		Thread.sleep(5000);
//		List<WebElement> featuresText = driver.findElements(By.xpath(xpath));
//		System.out.println(featuresText);
//		Iterator<WebElement> featuresIteration = featuresText.iterator();
//		while (featuresIteration.hasNext()) {
//
//			String featureTitle = featuresIteration.next().getText();
//			System.out.println(featureTitle);
//			featureTitleList.add(featureTitle);
//
//		}
//		return featureTitleList;
//
//	}
//
//	public String getActualFeatureTitle(int testIndex) {
//
//		List<String> actualTitleList = new ArrayList<String>();
//		actualTitleList = featureTitleList;
//		return actualTitleList.get(testIndex);
//
//	}
//
//	/*
//	 * Method to extract all the element in the drop-down menu of product option and
//	 * return the list of element.
//	 * 
//	 */
//	public List<String> productTextList() throws InterruptedException {
//
//		hover(productTitle_hover);
//		Thread.sleep(5000);
//
////		WebElement firstDropDown = driver.findElement(
////				By.xpath("(//*[contains(text(),'Product')]/parent::*[contains(@class,'dropdown')])[1]//div//a[1]"));
////
////		hover(firstDropDown);
//		String xpath = xpathToString(productList_Xpath);
//		List<WebElement> productText = driver.findElements(By.xpath(xpath));
//		System.out.println(productText);
//		Iterator<WebElement> productIteration = productText.iterator();
//		while (productIteration.hasNext()) {
////			hover(firstDropDown);
//			WebElement elm = productIteration.next();
//			String productTitle = elm.getText();
//			System.out.println(productTitle);
//			productTitleList.add(productTitle);
//
//		}
//		System.out.println(productTitleList);
//		return productTitleList;
//
//	}
//
//	public String getActualProductTitle(int testIndex) {
//
//		List<String> actualTitleList = new ArrayList<String>();
//		actualTitleList = productTitleList;
//		return actualTitleList.get(testIndex);
//
//	}
//
//	/*
//	 * Method to extract all the element in the drop-down menu of company option and
//	 * return the list of element.
//	 * 
//	 */
//	public List<String> companyTextList() throws InterruptedException {
//
//		hover(companyTitle_hover);
//		Thread.sleep(5000);
//
////		WebElement companyDropDown = driver.findElement(
////				By.xpath("(//*[contains(text(),'Company')]/parent::*[contains(@class,'dropdown')])[1]//div//a[1]"));
////		hover(companyDropDown);
//		String xpath = xpathToString(companyList_Xpath);
//		List<WebElement> companyText = driver.findElements(By.xpath(xpath));
//		System.out.println(companyText);
//		Iterator<WebElement> companyIteration = companyText.iterator();
//		while (companyIteration.hasNext()) {
//
//			String companyTitle = companyIteration.next().getText();
//			System.out.println(companyTitle);
//			companyTitleList.add(companyTitle);
//
//		}
//		System.out.println(companyTitleList);
//		return companyTitleList;
//
//	}
//
//	public String getActualCompanyTitle(int testIndex) {
//
//		List<String> actualTitleList = new ArrayList<String>();
//		actualTitleList = companyTitleList;
//		return actualTitleList.get(testIndex);
//
//	}

}
