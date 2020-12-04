package mavenProject.phpTravel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import mavenProject.phpTravel.utilities.ExcelData;

/*
 * Author:
 * Date:
 * Info: Class has all the common methods the is implemented in the other page sub classes.
 * 
 * 
 * */
public class BasePage {

	/*
	 * Initialization of webdriver and resource bundle that is used to read the
	 * .properties file.
	 * 
	 */
	WebDriver driver;
	ResourceBundle getvalue = ResourceBundle.getBundle("url");
	List<String> titleList = new ArrayList<String>();

	/*
	 * Constructor with webdriver as parameter.
	 * 
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Method that is called from ExcelData class, return string of data that is
	 * stored in the excel file.
	 * 
	 */
	public String getExcelData(int index, String address) throws IOException {
		ExcelData expectedData = new ExcelData();
		List<String> excelValue = new ArrayList<String>();
		excelValue = expectedData.readData(address);
		return excelValue.get(index);

	}

	/*
	 * Method used to return data that is stored in .properties file, in the form of
	 * string.
	 * 
	 */
	public String getData(String key) {
		return getvalue.getString(key);
	}

	/*
	 * Method used to produce delay until a certain webelement is found.
	 * 
	 */
	public boolean delay(WebElement xPath) {
		String uneditedLocator = xPath.toString();
		String locatorInfoUnedited = uneditedLocator.substring(80);
		System.out.println(locatorInfoUnedited);
		int n = locatorInfoUnedited.length();
		String locatorInfo = locatorInfoUnedited.substring(0, n - 1);
		System.out.println(locatorInfo);
		long startTime = System.currentTimeMillis();
		List<WebElement> findElement = driver.findElements(By.xpath(locatorInfo));
		boolean status = findElement.size() > 0;
		long waitTime = 0;

		while (!(status) && (waitTime < 120000)) {
			findElement = driver.findElements(By.xpath(locatorInfo));
			status = findElement.size() > 0;
			waitTime = System.currentTimeMillis() - startTime;
			System.out.println(waitTime);
		}
		if (status == false) {
			System.out.println("Element not Found!!");
		}

		return status;
	}

	/*
	 * Method used to convert webelement of xpath to String format.
	 * 
	 */
	public String xpathToString(WebElement xpath) {

		String uneditedXpath = xpath.toString();
		String prefixRemovedXpath = uneditedXpath.substring(80);
//		System.out.println(prefixRemovedXpath);
		int lengthOfString = prefixRemovedXpath.length();
		String xpathInStringForm = prefixRemovedXpath.substring(0, lengthOfString - 1);
		return xpathInStringForm;

	}

	/*
	 * Method used to switch to child window and verify the same.
	 * 
	 */
	public void switchWindows(WebElement xpath) {

		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		xpath.click();
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);
		Iterator<String> interateBtwWindow = childWindow.iterator();
		while (interateBtwWindow.hasNext()) {

			String nextWindow = interateBtwWindow.next();
			driver.switchTo().window(nextWindow);
			System.out.println(driver.getCurrentUrl());
		}
	}

	/*
	 * Method to hover on a webelement.
	 * 
	 */
	public void hover(WebElement xpath) {

		Actions hoverAction = new Actions(driver);
		hoverAction.moveToElement(xpath).build().perform();

	}
	
	/*
	 * Method to extract all the element in the drop-down menu
	 * and return the list of element.
	 * 
	 */
	public List<String> textListMethod(WebElement hoverXpath, WebElement ListXpath) throws InterruptedException {

		String xpath = xpathToString(ListXpath);
		System.out.println(xpath);
		hover(hoverXpath);
		Thread.sleep(5000);
		List<WebElement> listText = driver.findElements(By.xpath(xpath));
		System.out.println(listText);
		Iterator<WebElement> featuresIteration = listText.iterator();
		while (featuresIteration.hasNext()) {

			String featureTitle = featuresIteration.next().getText();
			System.out.println(featureTitle);
			titleList.add(featureTitle);

		}
		return titleList;

	}

	public String getActualDropDownTitle(int testIndex) {

		List<String> actualTitleList = new ArrayList<String>();
		actualTitleList = titleList;
		return actualTitleList.get(testIndex);

	}

}
