package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
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

	@FindBy(xpath = "//ng-select[@formcontrolname='source']//div[contains(@class,'ng-select-container')]")
	@CacheLookup
	WebElement selectSourcedropdown;

	@FindBy(xpath = "//ng-dropdown-panel//span[@class='ng-option-label ng-star-inserted']")
	@CacheLookup
	WebElement source_dropdownOptionsList;

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

//	@FindBy(xpath = "//ng-select[@placeholder='Select']//div[@class='ng-value-container']")
//	@CacheLookup
//	WebElement selectNonprepaid;

	@FindBy(xpath = "(//div[@role='combobox' and contains(@class, 'ng-input')])[4]")
	private WebElement reservationPrepaidDropdown;
//
//	    // Locate the input field inside the combobox
	@FindBy(xpath = "(//div[@role='combobox']//input[@type='text'])[4]")
	private WebElement reservationInputField;

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

	@FindBy(xpath = "//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']")
	@CacheLookup
	WebElement carMakeDropdown;
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	@CacheLookup
	WebElement carMakeDropdownOptions;

	@FindBy(xpath = "//div[contains(@id,'a94ed9d17181')]//span[contains(@class, 'ng-option-label ng-star-inserted')]")
	@CacheLookup
	WebElement carMake;

	@FindBy(xpath = "//ng-select[@formcontrolname='model']/div/div/div[3]/input")
	@CacheLookup
	WebElement carModel;

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

	public void enterFirstName() {
		String firstName = faker.name().firstName();
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

	public void selectSource(String selectSourceName) {
		utilsObj.elementToBeClickableWaitTime(selectSourcedropdown);
		selectSourcedropdown.click();
		By optionLocator = By.xpath("//ng-dropdown-panel//span[contains(text(),'" + selectSourceName + "')]");
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		option.click();
	}

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

//	public void selectNonprepaid() {
//		utilsObj.elementToBeClickableWaitTime(selectNonprepaid);
//
//		selectNonprepaid.click();
//	}

	public void selectReservation(String prepaid) {
		reservationPrepaidDropdown.click();
		reservationInputField.sendKeys(prepaid,Keys.ENTER);
	}

	public void selectNonprepaidokay() {

		selectNonprepaidokay.click();
	}

	public void clickAddVehicle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", carMakeDropdown);

	}

	private static final By CAR_MODEL_DROPDOWN_OPTIONS = By.xpath("//span[@class='ng-option-label ng-star-inserted']");
	private static final By CAR_MODEL_DROPDOWN = By
			.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='model']//input[@type='text']");

	// Method to select car model from dropdown
	public void selectCarModel1(String carModel) {

		WebElement modelDropdown = wait.until(ExpectedConditions.elementToBeClickable(CAR_MODEL_DROPDOWN));
		modelDropdown.click();

		// Wait for options to appear and select the correct one
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MODEL_DROPDOWN_OPTIONS));
		for (WebElement option : options) {
			System.out.println("The Car_Model_DropDown_Option_List : " + option.getText());
			if (option.getText().equalsIgnoreCase(carModel)) {
				option.click();
				break;
			}
		}
	}

	private static final By CAR_MAKE_DROPDOWN = By
			.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']");
	private static final By CAR_MAKE_DROPDOWN_OPTIONS = By.xpath("//span[@class='ng-option-label ng-star-inserted']");

	public void selectCarMake1(String carMake) {
		WebElement makeDropdown = wait.until(ExpectedConditions.elementToBeClickable(CAR_MAKE_DROPDOWN));
		makeDropdown.click();

		// Get all dropdown options
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MAKE_DROPDOWN_OPTIONS));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(carMake)) {
				option.click();
				System.out.println("Selected: " + carMake);
				break; // Exit inner loop once the match is found
			}
		}
	}

	public void selectLicenceno(String licenseNumber) {
		System.out.println("*************" + licenseNumber);
		enterLicenceno.sendKeys(licenseNumber, Keys.ENTER);
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

	public AddReservationPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
		PageFactory.initElements(driver, this);
	}
}
