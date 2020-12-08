package mavenProject.phpTravel;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Author:
 * Date:
 * Info: This class is were automation of flight booking coded
 * 
 * 
 * */
public class PHPTravelsDemoFlightBooking extends BasePage {

	/*
	 * Initialization of required web-element for performing automation testing
	 * flight booking
	 * 
	 * 
	 */
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

	@FindBy(xpath = "//input[contains(@id,'FlightsDateEnd')]")
	public WebElement returnTab_Click;

	@FindBy(xpath = "(//*[contains(@class,'datepicker--cell datepicker--cell-day -current-')])[9]")
	public WebElement click_Present_Date;

	@FindBy(xpath = "(//*[contains(@class,'datepicker--nav-action')][contains(@data-action,'next')])[10]")
	public WebElement click_Next_Month;

	@FindBy(xpath = "(//button[@type ='submit'])[2]")
	public WebElement click_Submit;

	public PHPTravelsDemoFlightBooking(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*
	 * -Method for automation testing of flight booking. 
	 * -In this method flight
	 * ticket for round trip is booked, for the current date till the date 7 days
	 * after the current date.
	 * 
	 * 
	 */
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

		Map<String, String> monthsInNumbers = new HashMap<String, String>();
		monthsInNumbers.put("Jan", "0");
		monthsInNumbers.put("Feb", "1");
		monthsInNumbers.put("Mar", "2");
		monthsInNumbers.put("Apr", "3");
		monthsInNumbers.put("May", "4");
		monthsInNumbers.put("Jun", "5");
		monthsInNumbers.put("Jul", "6");
		monthsInNumbers.put("Aug", "7");
		monthsInNumbers.put("Sep", "8");
		monthsInNumbers.put("Oct", "9");
		monthsInNumbers.put("Nov", "10");
		monthsInNumbers.put("Dec", "11");
		String returnMonth = monthsInNumbers.get(returnDateArr[1]);
		Thread.sleep(5000);

		click_Present_Date.click();
		returnTab_Click.click();

		boolean flag = false;
		while (flag == false) {
			if (driver.findElements(
					By.xpath("(//*[contains(@class,'datepicker--cell datepicker--cell-day')][@data-date=\'"
							+ returnDateArr[2] + "\'][ @data-month=\'" + returnMonth + "\' ][ @data-year=\'"
							+ returnDateArr[5] + "\'])[10]"))
					.size() > 0) {
				List<WebElement> dateList = driver.findElements(
						By.xpath("(//*[contains(@class,'datepicker--cell datepicker--cell-day')][@data-date=\'"
								+ returnDateArr[2] + "\'][ @data-month=\'" + returnMonth + "\' ][ @data-year=\'"
								+ returnDateArr[5] + "\'])[10]"));
				System.out.println("Number of elements: " + dateList.size());
				Iterator<WebElement> dateIterate = dateList.iterator();
				while (dateIterate.hasNext()) {
					dateIterate.next().click();
				}
				flag = true;
				break;
			} else {
				click_Next_Month.click();
			}
		}
		click_Submit.click();

	}

}
