package mavenProject.phpTravel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsHomePage extends BasePage {

	@FindBy(xpath = "(//*[contains(@class,'clearfix')]//div[contains(@class,'lvl-0')]//span)|(//*[contains(@class,'clearfix')]//a[contains(@class,'lvl-0')])")
	public WebElement listOfHeaders;

	List<String> titleList = new ArrayList<String>();
	List<WebElement> headerTitle;
	List<String> featureTitleList = new ArrayList<String>();
	List<String> productTitleList = new ArrayList<String>();
	List<String> companyTitleList = new ArrayList<String>();


	public PHPTravelsHomePage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

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

	public void out() {

		System.out.println(titleList);

	}

	public List<String> featuresTextList() throws InterruptedException {

		int index = headerTitleString(listOfHeaders).size();
		System.out.println(index);
		hover(headerTitle.get(2));
		Thread.sleep(5000);
//		System.out.println(headerTitle.get(2));
//		String xpath = xpathToString(headerTitle.get(2));
//		System.out.println(xpath);
//		headerTitle.get(2).findElements(by)
		List<WebElement> featuresText = driver
				.findElements(By.xpath("//*[contains(@class,'dropdown-content featuresDropdown')][1]"));
		System.out.println(featuresText);
		Iterator<WebElement> featuresIteration = featuresText.iterator();
		while (featuresIteration.hasNext()) {

			String featureTitle = featuresIteration.next().getText();
			System.out.println(featureTitle);
//			featureTitleList.add(featureTitle);

		}
		return featureTitleList;

	}

	public String getActualFeatureTitle(int testIndex) {

		List<String> actualTitleList = new ArrayList<String>();
		actualTitleList = featureTitleList;
		return actualTitleList.get(testIndex);

	}
	
	public List<String> productTextList() throws InterruptedException {

		int index = headerTitleString(listOfHeaders).size();
		System.out.println(index);
		hover(headerTitle.get(3));
		Thread.sleep(5000);
//		System.out.println(headerTitle.get(3));
//		String xpath = xpathToString(headerTitle.get(3));
//		System.out.println(xpath);
//		headerTitle.get(2).findElements(by)
		List<WebElement> productText = driver
				.findElements(By.xpath("//*[@class='lvl-0 dropdown open']//a[@class='lvl-1 link nav-link']"));//div[@class='dropdown-content featuresDropdown']//a"));
		System.out.println(productText);
		Iterator<WebElement> productIteration = productText.iterator();
		while (productIteration.hasNext()) {

			String productTitle = productIteration.next().getText();
			System.out.println(productTitle);
			productTitleList.add(productTitle);

		}
		System.out.println(productTitleList);
		return productTitleList;

	}

	public String getActualProductTitle(int testIndex) {

		List<String> actualTitleList = new ArrayList<String>();
		actualTitleList = productTitleList;
		return actualTitleList.get(testIndex);

	}
	
	public List<String> companyTextList() throws InterruptedException {

		int index = headerTitleString(listOfHeaders).size();
		System.out.println(index);
		hover(headerTitle.get(7));
		Thread.sleep(5000);
//		System.out.println(headerTitle.get(7));
//		String xpath = xpathToString(headerTitle.get(7));
//		System.out.println(xpath);
//		headerTitle.get(2).findElements(by)
		List<WebElement> companyText = driver
				.findElements(By.xpath("//*[@class='lvl-0 dropdown headerLang']//a[@class='lvl-1 link nav-link']")); //div[@class='dropdown-content langList']//a));
		System.out.println(companyText);
		Iterator<WebElement> companyIteration = companyText.iterator();
		while (companyIteration.hasNext()) {

			String companyTitle = companyIteration.next().getText();
			System.out.println(companyTitle);
			productTitleList.add(companyTitle);

		}
		System.out.println(companyTitleList);
		return companyTitleList;

	}

	public String getActualCompanyTitle(int testIndex) {

		List<String> actualTitleList = new ArrayList<String>();
		actualTitleList = companyTitleList;
		return actualTitleList.get(testIndex);

	}

}
