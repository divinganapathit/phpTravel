package mavenProject.phpTravel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

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
		Reporter.log("Method that returns list to elements that are title in the website.");
		return titleList;

	}

	public String getActualTitle(int testIndex) {

		List<String> actualTitleList = new ArrayList<String>();
		actualTitleList = titleList;
		Reporter.log("Return individual element that is stored in the list of titles.");
		return actualTitleList.get(testIndex);

	}
}