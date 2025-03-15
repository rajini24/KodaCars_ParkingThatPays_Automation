package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.kodacars.qa.uilities.CommonUtils;

public class AddReservationPage {
	Faker faker = new Faker();
	WebDriverWait wait;
	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance();

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	@CacheLookup
	WebElement enterFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	@CacheLookup
	WebElement enterLastName;

	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	@CacheLookup
	WebElement enterPhoneNumber;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement enterEmail;

	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']/div/div[@aria-expanded='true']")
	@CacheLookup
	WebElement selectCity;

	@FindBy(xpath = "//ng-select[@bindlabel='name' and @formcontrolname='location']//input")
	@CacheLookup
	WebElement selectLocationdropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='location' and @bindlabel='name']//span[contains(text(),'Barcelona')]")
	@CacheLookup
	WebElement selectLocation;

//	@FindBy(xpath = "//ng-select[@bindlabel='name' and @formcontrolname='source']//input[@type='text']")
	@FindBy(xpath = "//ng-select[@formcontrolname='source']//div[contains(@class,'ng-select-container')]")
	@CacheLookup
	WebElement selectSourcedropdown;

	@FindBy(xpath = "//ng-dropdown-panel//span[@class='ng-option-label ng-star-inserted']")
	@CacheLookup
	WebElement source_dropdownOptionsList;

//	@FindBy(xpath = "//ng-select[@formcontrolname='source']//div[contains(@class,'ng-select-container')]")
//	WebElement selectSource;

	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	@CacheLookup
	WebElement enterstartDate;

	@FindBy(xpath = "//input[@formcontrolname='startTime']")
	@CacheLookup
	WebElement enterstartTime;

	@FindBy(xpath = "//input[@formcontrolname='endDate']")
	@CacheLookup
	WebElement enterEndDate;

	@FindBy(xpath = "//input[@formcontrolname='endTime']")
	@CacheLookup
	WebElement enterEndTime;

	@FindBy(xpath = "//ng-select[@placeholder='Select']//div[@class='ng-value-container']")
	@CacheLookup
	WebElement selectNonprepaid;

	@FindBy(xpath = "//button[normalize-space()='Okay']")
	@CacheLookup
	WebElement selectNonprepaidokay;

	@FindBy(xpath = "//button[contains(text(),'Add Vehicle')]")
	@CacheLookup
	WebElement clickAddVehicle;

	@FindBy(xpath = "//ng-select[@bindlabel='color']//div[@class='ng-select-container ng-has-value']")
	@CacheLookup
	WebElement carColorDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='carColor']//input[@type='text']")
	@CacheLookup
	WebElement selectCarcolor;

//	 private static final By CAR_MAKE = By.xpath("//div[contains(@id,'a94ed9d17181')]//span[contains(@class, 'ng-option-label ng-star-inserted')]");
//		
//		private static final By CAR_MAKE_DROPDOWN = By.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']");
//		private static final By CAR_MODEL_DROPDOWN = By.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='model']//input[@type='text']");
//		private static final By CAR_MODEL = By.xpath("//ng-select[@formcontrolname='model']/div/div/div[3]/input");

//	@FindBy(xpath = "//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']")
	@FindBy(xpath = "//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']")
	@CacheLookup
	WebElement carMakeDropdown;
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	@CacheLookup
	WebElement carMakeDropdownOptions;

	@FindBy(xpath = "//div[contains(@id,'a94ed9d17181')]//span[contains(@class, 'ng-option-label ng-star-inserted')]")
	@CacheLookup
	WebElement carMake;

	@FindBy(xpath = "//div[@class='col-3 form-group']/ng-select[@formcontrolname='model']//input[@type='text']")
	@CacheLookup
	WebElement carModelDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='model']/div/div/div[3]/input")
	@CacheLookup
	WebElement carModel;

//	@FindBy(xpath = "//ng-select[@formcontrolname='make']//input[@type='text']")
//	WebElement selectCarmake;
//
//	@FindBy(css = "ng-select[class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-touched ng-dirty ng-invalid ng-select-bottom ng-select-focused'] span[class='ng-arrow-wrapper']")
//	WebElement CarModeldropdwn;
//
//	@FindBy(xpath = "//div[@aria-expanded='true']//input[@type='text']")
//	WebElement CarModeldropdwntext;
//
//	@FindBy(xpath = "//span[normalize-space()='Avalon']")
//	WebElement CarModeldummy;

	// @FindBy(xpath = "//div[@id='a740fd26e679-0']/span[text()='240']")
	@FindBy(xpath = "//ng-select[@formcontrolname='model']/div/div/div[3]/input")
	// ng-select[@formcontrolname='model']//input[@type='text']

	@CacheLookup
	WebElement clickCarModelNumber;

	@FindBy(xpath = "//input[@formcontrolname='licenseNo']")
	@CacheLookup
	WebElement enterLicenceno;

	@FindBy(xpath = "//ng-select[@formcontrolname='state']//input[@type='text']")
	@CacheLookup
	WebElement Statedropdown;

	@FindBy(xpath = "//button[text()='Create Reservation']")
	@CacheLookup
	WebElement createReservationBtn;

	@FindBy(xpath = "//div[@class='modal-content']/div[@class='p-3 m-auto']/div/button[text()='Ok']")
	@CacheLookup
	WebElement reservationSuccessBtn;

	@FindBy(xpath = "//label[normalize-space()='Reservation Created Successfully.']")
	@CacheLookup
	WebElement reservationSuccessTextMessage;

	@FindBy(xpath = "//span[@id='cell-515']//button[@title='Delete Reservation']")
	@CacheLookup
	WebElement deleteReservation;

	@FindBy(xpath = "//button[@title='Cancel Reservation']")
	@CacheLookup
	WebElement cancelReservation;

	@FindBy(xpath = "//div[@class='col-6 cursor']/i")
	@CacheLookup
	WebElement reservationDetailsArrowLeft;

	// div[contains(@class, 'ng-option')]

	// Enter Customer Details

	public void enterFirstName() {
		String firstName = faker.name().fullName();
		System.out.println("The First Name : " + firstName);
		enterFirstName.sendKeys(firstName);

	}

	public void enterLastName() {
		String lastName = faker.name().lastName();
		System.out.println("The Last Name : " + lastName);
		enterLastName.sendKeys(lastName);
	}

	public void enterPhoneNumber() {
		String phoneNumber = faker.phoneNumber().cellPhone();
		System.out.println("The Phone Number : " + phoneNumber);
		enterPhoneNumber.sendKeys(phoneNumber);

	}

	public void enterEmail() {
		String uniqueEmail = faker.internet().safeEmailAddress();
		System.out.println("Unique Email: " + uniqueEmail);
		enterEmail.sendKeys(uniqueEmail);
	}

	public void selectCity() {
		selectCity.click();
	}

	public void selectLocationdropdown() throws InterruptedException {
		Thread.sleep(3000);
		utilsObj.visibilityOf(selectLocationdropdown);
		selectLocationdropdown.click();
	}

	public void selectLocation() throws InterruptedException {
		Thread.sleep(3000);
		utilsObj.visibilityOf(selectLocation);
		selectLocation.click();
	}

	public void selectSourcedropdown() {
//		  WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(CLICK_SOURCE_DROPDOWN));
//	        dropdownElement.click();
		utilsObj.elementToBeClickableWaitTime(selectSourcedropdown);
		// utilsObj.visibilityOf(selectSourcedropdown);
		selectSourcedropdown.click();
	}

	// Method to get list of WebElements
	public List<WebElement> getDropdownOptionsList() {
		return wait.until(ExpectedConditions.visibilityOfAllElements(source_dropdownOptionsList));
	}

	public void selectSource(String selectSourceName) {
		selectSourcedropdown();
		By optionLocator = By.xpath("//ng-dropdown-panel//span[contains(text(),'" + selectSourceName + "')]");
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		option.click();

	}

//	public void selectSource() {
//		utilsObj.visibilityOf(selectSource);
//		selectSource.click();
//	}

	public void enterstartDate() {
		enterstartDate.sendKeys("04/21/2025");
	}

	public void enterstartTime() {
		enterstartTime.sendKeys("09:00 AM");
	}

	public void enterEndDate() {
		enterEndDate.sendKeys("04/25/2025");
	}

	public void enterEndTime() {
		enterEndTime.sendKeys("10:00 AM");
	}

	public void selectNonprepaid() {
		utilsObj.elementToBeClickableWaitTime(selectNonprepaid);

		selectNonprepaid.click();
	}

	public void selectNonprepaidokay() {

		selectNonprepaidokay.click();
	}

	// **********************

	public void clickAddVehicle() {
		clickAddVehicle.click();
	}

	public void carColordropdown() throws InterruptedException {
		WebElement colorDropdown = utilsObj.elementToBeClickableExtraWaitTime(carColorDropdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", colorDropdown);
	}

	public void selectCarcolor(String color) {
		System.out.println("The excel color **********" + color);
		selectCarcolor.sendKeys(color, Keys.ENTER);
	}

	public void clickCarMakeDropdown() {
		carMakeDropdown.click();
		// .sendKeys("Volvo", Keys.ENTER);
	}

//	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
//	@CacheLookup 
//	private List<WebElement> carMakeDropdownOptions;

	public void selectCarMake(String carMake) {
//    WebElement makeDropdown = wait.until(ExpectedConditions.elementToBeClickable(carMakeDropdown));
//    makeDropdown.sendKeys(carMake);// Open dropdown
//
//		// Get all dropdown options
//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(carMakeDropdownOptions));
//
//
//		for (WebElement option : options) {
//			if (option.getText().equalsIgnoreCase(carMake)) {
//				option.click();
//				System.out.println("Selected: " + carMake);
//				break; 
//			}
//		}
		WebElement makeDropdown = wait.until(ExpectedConditions.elementToBeClickable(carMakeDropdown));
		// makeDropdown.sendKeys(carMake);// Open dropdown
		makeDropdown.click();

		// Get all dropdown options
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(carMakeDropdownOptions));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(carMake)) {
				option.click();
				System.out.println("Selected: " + carMake);
				break; // Exit inner loop once the match is found
			}
		}
	}

	public void clickCarModelDropdown() {
		carModelDropdown.click();
	}

	// private static final By CAR_MODEL_DROPDOWN_OPTIONS =
	// By.xpath("//div[@class='col-3
	// form-group']/ng-select[@formcontrolname='make']//span[@class='ng-option-label
	// ng-star-inserted']");

	// @FindBy(xpath="//div[@class='col-3
	// form-group']/ng-select[@formcontrolname='make']//span[@class='ng-option-label
	// ng-star-inserted']")
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	WebElement carModelDropdownOptions;

	// Method to select car model from dropdown
	public void selectCarModel(String carModel) {
		// final By CAR_MODEL_DROPDOWN_OPTIONS = By.xpath("//div[@class='col-3
		// form-group']/ng-select[@formcontrolname='make']//span[@class='ng-option-label
		// ng-star-inserted']");

		WebElement modelDropdown = wait.until(ExpectedConditions.elementToBeClickable(carModelDropdown));
		modelDropdown.sendKeys(carModel); // Type model name

//	        // Wait for options to appear and select the correct one
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(carModelDropdownOptions));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(carModel)) {
				option.click();
				break;
			}
		}
	}

//	public void selectCarmake(String carMake) {
//		selectCarmake.sendKeys(carMake, Keys.ENTER);
//	}

//	public void CarModeldropdwn() {
//
//		// CarModeldropdwn.clear();
//		CarModeldropdwn1.click();
//
//	}
//
//	public void CarModeldropdwn1(String carModel) {
//
//		// CarModeldropdwn.clear();
//		CarModeldropdwn1.sendKeys(carModel, Keys.ENTER);
//
//	}

//	@FindBy(xpath = "//ng-select[@formcontrolname='model']//input[@type='text']")
	@FindBy(xpath = "//div[@class='col-3 form-group']/ng-select[@formcontrolname='model']//input[@type='text']")
//	@FindBy(xpath = "//ng-dropdown-panel/div[@class='ng-dropdown-panel-items scroll-host']/div/div")
	WebElement CarModeldropdwn1;

//	public void CarModeldropdwntext(String carModel) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Click the dropdown first
//		WebElement dropdown = wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//div[contains(@class, 'ng-dropdown-panel-items scroll-host')]")));
//		dropdown.click();
//
//		// Wait for the dropdown to expand
//		wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));
//
//		// Now wait for the input field to be visible
//		wait.until(ExpectedConditions.visibilityOf(CarModeldropdwntext));
//
//		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-expanded='true']//input[@type='text']")));
//
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////		wait.until(ExpectedConditions.visibilityOf(CarModeldropdwntext));
//		CarModeldropdwntext.sendKeys(carModel, Keys.ENTER);
//
//	}

//	public void CarModeldummy(String carModel) {
//		// CarModeldropdwn.clear();
//
//		// CarModeldummy.sendKeys(carModel);
//		CarModeldummy.sendKeys(Keys.ENTER);
//	}

	public void clickCarModelNumber() {
		clickCarModelNumber.sendKeys(Keys.ARROW_DOWN);
		clickCarModelNumber.sendKeys(Keys.ENTER);

	}

	public void selectLicenceno() {
		enterLicenceno.sendKeys("RFT9909", Keys.ENTER);
		enterLicenceno.sendKeys(Keys.TAB);
	}

	public void selectLicenceno(String licenseNumber) {
		System.out.println("*************" + licenseNumber);
		enterLicenceno.sendKeys(licenseNumber, Keys.ENTER);
		// enterLicenceno.sendKeys(Keys.TAB);
	}

	public void selectState() {
		Statedropdown.sendKeys("California", Keys.ENTER);
	}

	public void selectState(String state) {
		System.out.println("*************" + state);
		Statedropdown.sendKeys(state, Keys.ENTER);
	}

	public void clickCreateReservation() {
		createReservationBtn.click();
	}

	public String getReservationSuccessTextMessage() {
		return reservationSuccessTextMessage.getText();
	}

	public void clickReservationSuccessBtn() {
		reservationSuccessBtn.click();
	}

	public void clickCancelReservationBtn() {
		cancelReservation.click();
	}

	public void clickReservationDetailsArrowLeft() {
		reservationDetailsArrowLeft.click();
	}

	public void clickDeleteReservationBtn() {
		utilsObj.visibilityOfExtraWaitTime(deleteReservation);
		deleteReservation.click();
	}

	@FindAll(value = { @FindBy(xpath = "//div[contains(@class, 'ng-option')]") })
	// @FindAll(value = { @FindBy
	// (xpath="//div[@style='text-align:right;padding-bottom:15px;'][1]//a[@class='rescurrpg'
	// or @class='respglink']")})z { @FindBy
	// (xpath="//div[@style='text-align:right;padding-bottom:15px;'][1]//a[@class='rescurrpg'
	// or @class='respglink']")})
	private List<WebElement> dropdownOptions;

	// Method to get text of all dropdown options
	public void printDropdownOptions() {
		// Wait for elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.presenceOfElementLocated(dropdownOptions));
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,
		// 'ng-option')]")));
		WebElement element = driver.findElement(By.xpath("//div[@class='ng-option'][text()='Black']"));
		// ng-dropdown-panel/div/div/div["+ colour + "]

		for (WebElement option : dropdownOptions) {
			System.out.println(option.getText());
			option.click();
		}
	}

	public AddReservationPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
		PageFactory.initElements(driver, this);
	}
}
