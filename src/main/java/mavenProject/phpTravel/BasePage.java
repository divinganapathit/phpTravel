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
import org.testng.asserts.SoftAssert;

import mavenProject.phpTravel.utilities.ExcelData;

public class BasePage {

	WebDriver driver;
	ResourceBundle getvalue = ResourceBundle.getBundle("url");
	SoftAssert softAssert = new SoftAssert();

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getExcelData(int index,String address) throws IOException {
		ExcelData expectedData = new ExcelData();
		List<String> excelValue = new ArrayList<String>();
		excelValue = expectedData.readData(address);
		return excelValue.get(index);

	}

	public String getData(String key) {
		return getvalue.getString(key);
	}

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

	public String xpathToString(WebElement xpath) {

		String uneditedXpath = xpath.toString();
		String prefixRemovedXpath = uneditedXpath.substring(80);
//		System.out.println(prefixRemovedXpath);
		int lengthOfString = prefixRemovedXpath.length();
		String xpathInStringForm = prefixRemovedXpath.substring(0, lengthOfString - 1);
		return xpathInStringForm;

	}

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
	
	public void hover(WebElement xpath) {
		
		Actions hoverAction = new Actions(driver);
		hoverAction.moveToElement(xpath).build().perform();
				
	}

}
