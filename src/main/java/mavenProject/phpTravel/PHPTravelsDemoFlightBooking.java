package mavenProject.phpTravel;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsDemoFlightBooking extends BasePage {

	@FindBy(xpath = "//*[contains(@class,'flights')]")
	public WebElement click_Flight_Option;

	@FindBy(xpath = "//*[contains(text(),'Round Trip')]")
	public WebElement roundTrip_Radio_Button;

	@FindBy(xpath = "//a[contains(@class,'chosen-single')]//span[contains(text(),'Economy')]")
	public WebElement class_DropDown_Click;

	@FindBy(xpath = "//ul[contains(@class,'chosen-results')]//li")
	public WebElement dropDown_Elements;

	@FindBy(xpath = "//input[contains(@id,'FlightsDateStart')]")
	public WebElement depart_Click;

	@FindBy(xpath = "//div[contains(@id,'datepickers-container')]//div[contains(@class,'datepicker--nav-title')]")
	public WebElement click_MonthAndYear_Title;

	@FindBy(xpath = "//*[contains(@class,'datepicker--cells datepicker--cells-years')]")
	public WebElement list_Year;

	@FindBy(xpath = "//*[contains(@class,'datepicker--cells datepicker--cells-month')]")
	public WebElement list_Month;

	@FindBy(xpath = "//*[contains(@class,'datepicker--cells datepicker--cells-days')]")
	public WebElement list_Day;

	public PHPTravelsDemoFlightBooking(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void bookFlightTickect() throws InterruptedException {

		click_Flight_Option.click();
		roundTrip_Radio_Button.click();
		class_DropDown_Click.click();
		String xpath_DropDownElement = xpathToString(dropDown_Elements);
		List<WebElement> dropDownElement = driver.findElements(By.xpath(xpath_DropDownElement));
		dropDownElement.get(1).click();
//		Iterator<WebElement> listOfClassOption = dropDownElement.iterator();
		Calendar objCalendar = Calendar.getInstance();
		String departureDate = objCalendar.getTime().toString();
		System.out.println(departureDate);
		objCalendar.add(Calendar.DATE, 7);
		String returnDate = objCalendar.getTime().toString();
		System.out.println(returnDate);
		String[] departureDateArr = departureDate.split(" ");
		for (int i = 0; i < departureDateArr.length; i++) {
			System.out.println(departureDateArr[i]);
		}
		String[] returnDateArr = returnDate.split(" ");
		for (int i = 0; i < returnDateArr.length; i++) {
			System.out.println(returnDateArr[i]);
		}
		depart_Click.click();
//		click_MonthAndYear_Title.click();
//		driver.findElement(By.xpath("//div[@class='datepicker -bottom-left- -from-bottom-']/nav[1]/div[2]")).click();
//		driver.findElement(By.xpath("//div[contains(text(),'2020')]")).click();
		Map<String, String>monthsInNumbers = new HashMap<String , String>();
		monthsInNumbers.put("Jan", "1");
		monthsInNumbers.put("Feb", "2");
		monthsInNumbers.put("Mar", "3");
		monthsInNumbers.put("Apr", "4");
		monthsInNumbers.put("May", "5");
		monthsInNumbers.put("Jun", "6");
		monthsInNumbers.put("Jul", "7");
		monthsInNumbers.put("Aug", "8");
		monthsInNumbers.put("Sep", "9");
		monthsInNumbers.put("Oct", "10");
		monthsInNumbers.put("Nov", "11");
		monthsInNumbers.put("Dec", "12");
		String departureMonth = monthsInNumbers.get(departureDateArr[1]);
		depart_Click.sendKeys(departureDateArr[5]+"-"+departureMonth+"-"+departureDateArr[2]);
		Thread.sleep(5000);
		String returnMonth = monthsInNumbers.get(returnDateArr[1]);
//		return_

	}

}
