package com.kodacars.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
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

	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance();

	public AddReservationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//button[text()='No']")
//	WebElement clickNoConfirmation;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement enterFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement enterLastName;

	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	WebElement enterPhoneNumber;

	@FindBy(xpath = "//input[@type='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']/div/div[@aria-expanded='true']")
	WebElement selectCity;

	@FindBy(xpath = "//ng-select[@bindlabel='name' and @formcontrolname='location']//input")
	WebElement selectLocationdropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='location' and @bindlabel='name']//span[contains(text(),'Barcelona')]")
	WebElement selectLocation;

	@FindBy(xpath = "//ng-select[@bindlabel='name' and @formcontrolname='source']//input[@type='text']")
	WebElement selectSourcedropdown;

	@FindBy(xpath = "//ng-dropdown-panel//span[contains(text(),'Walk-in')]")
	WebElement selectSource;

	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	WebElement enterstartDate;

	@FindBy(xpath = "//input[@formcontrolname='startTime']")
	WebElement enterstartTime;

	@FindBy(xpath = "//input[@formcontrolname='endDate']")
	WebElement enterEndDate;

	@FindBy(xpath = "//input[@formcontrolname='endTime']")
	WebElement enterEndTime;

	@FindBy(xpath = "//ng-select[@placeholder='Select']//div[@class='ng-value-container']")
	WebElement selectNonprepaid;

	@FindBy(xpath = "//button[normalize-space()='Okay']")
	WebElement selectNonprepaidokay;

	@FindBy(xpath = "//button[contains(text(),'Add Vehicle')]")
	WebElement clickAddVehicle;

	@FindBy(xpath = "//ng-select[@formcontrolname='carColor']")
	WebElement Carcolor_drp;

	@FindBy(xpath = "//ng-select[@formcontrolname='carColor']//input[@type='text']")
	WebElement selectCarcolor;

	@FindBy(xpath = "//ng-select[@formcontrolname='make']//input[@type='text']")
	WebElement selectCarmake;

	@FindBy(css = "ng-select[class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-touched ng-dirty ng-invalid ng-select-bottom ng-select-focused'] span[class='ng-arrow-wrapper']")
//	@FindBy(xpath = "//div[@aria-expanded='true']//input[@type='text']")
	WebElement CarModeldropdwn;

	@FindBy(xpath = "//div[@aria-expanded='true']//input[@type='text']")
	WebElement CarModeldropdwntext;

	@FindBy(xpath = "//span[normalize-space()='Avalon']")
	WebElement CarModeldummy;

	//@FindBy(xpath = "//div[@id='a740fd26e679-0']/span[text()='240']")
	@FindBy(xpath = "//ng-select[@formcontrolname='model']/div/div/div[3]/input")
	WebElement clickCarModelNumber;

	@FindBy(xpath = "//input[@formcontrolname='licenseNo']")
	WebElement enterLicenceno;

	@FindBy(xpath = "//ng-select[@formcontrolname='state']//input[@type='text']")
	WebElement Statedropdown;

	@FindBy(xpath = "//button[text()='Create Reservation']")
	@CacheLookup
	WebElement createReservationBtn;

	@FindBy(xpath = "//div[@class='modal-content']/div[@class='p-3 m-auto']/div/button[text()='Ok']")
	WebElement reservationSuccessBtn;

	@FindBy(xpath = "//label[normalize-space()='Reservation Created Successfully.']")
	WebElement reservationSuccessTextMessage;

	@FindBy(xpath = "//span[@id='cell-515']//button[@title='Delete Reservation']")
	WebElement deleteReservation;

	@FindBy(xpath = "//button[@title='Cancel Reservation']")
	WebElement cancelReservation;

	@FindBy(xpath = "//div[@class='col-6 cursor']/i")
	WebElement reservationDetailsArrowLeft;

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
		utilsObj.visibilityOf(selectSourcedropdown);
		selectSourcedropdown.click();
	}

	public void selectSource() {
		utilsObj.visibilityOf(selectSource);
		selectSource.click();
	}

	public void enterstartDate() {
		enterstartDate.sendKeys("02/21/2025");
	}

	public void enterstartTime() {
		enterstartTime.sendKeys("09:00 AM");
	}

	public void enterEndDate() {
		enterEndDate.sendKeys("02/25/2025");
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
		// utilsObj.visibilityOfExtraWaitTime(Carcolor_drp);
		Thread.sleep(5000);
		Carcolor_drp.click();
	}

	public void selectCarcolor() {
		selectCarcolor.sendKeys("Black", Keys.ENTER);
	}

	public void selectCarcolor(String color) {
		selectCarcolor.sendKeys(color, Keys.ENTER);
	}

	public void selectCarmake() {
		selectCarmake.sendKeys("Volvo", Keys.ENTER);
	}

	public void selectCarmake(String carMake) {
		selectCarmake.sendKeys(carMake, Keys.ENTER);
	}

	public void CarModeldropdwn() {

		// CarModeldropdwn.clear();
		CarModeldropdwn1.click();

	}
	@FindBy(xpath = "//ng-select[@formcontrolname='model']//input[@type='text']")
	WebElement CarModeldropdwn1;

	public void CarModeldropdwntext(String carModel) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Click the dropdown to make the list visible
		WebElement dropdown1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'dropdown-trigger')]")));
		dropdown1.click();

		// Click the dropdown first
		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class, 'ng-dropdown-panel-items scroll-host')]")));
		dropdown.click();

		// Wait for the dropdown to expand
		wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));

		// Now wait for the input field to be visible
		wait.until(ExpectedConditions.visibilityOf(CarModeldropdwntext));

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-expanded='true']//input[@type='text']")));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(CarModeldropdwntext));
		CarModeldropdwntext.sendKeys(carModel, Keys.ENTER);

	}

	public void CarModeldummy(String carModel) {
		// CarModeldropdwn.clear();

		// CarModeldummy.sendKeys(carModel);
		CarModeldummy.sendKeys(Keys.ENTER);
	}

	public void clickCarModelNumber() {
		clickCarModelNumber.sendKeys(Keys.ARROW_DOWN);
		clickCarModelNumber.sendKeys(Keys.ENTER);
		
	}

	public void selectLicenceno() {
		enterLicenceno.sendKeys("RFT9909", Keys.ENTER);
		enterLicenceno.sendKeys(Keys.TAB);
	}

	public void selectLicenceno(String licenseNumber) {
		enterLicenceno.sendKeys(licenseNumber, Keys.ENTER);
		enterLicenceno.sendKeys(Keys.TAB);
	}

	public void selectState() {
		Statedropdown.sendKeys("California", Keys.ENTER);
	}

	public void selectState(String state) {
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

}
