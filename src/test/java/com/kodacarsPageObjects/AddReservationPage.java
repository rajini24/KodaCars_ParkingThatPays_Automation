package com.kodacarsPageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kodacarsUilities.CommonUtils;

public class AddReservationPage {
	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance();

	@FindBy(xpath = "//div[@id='gridContainer']/div[@class='row text-center']/div/label")
	WebElement addReservation;
	
	@FindBy(xpath = "//button[text()='No']")
	WebElement clickNoConfirmation;

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

	@FindBy(xpath = "//ng-select[@formcontrolname='location' and @bindlabel='name']//span[contains(text(),'Damco, Noida')]")
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
	@CacheLookup
	WebElement clickAddVehicle;
	
	@FindBy(xpath = "//ng-select[@formcontrolname='carColor']")
	@CacheLookup
	WebElement Carcolor_drp;

	@FindBy(xpath = "//ng-select[@formcontrolname='carColor']//input[@type='text']")
	@CacheLookup
	WebElement selectCarcolor;

	@FindBy(xpath = "//ng-select[@formcontrolname='make']//input[@type='text']")
	@CacheLookup
	WebElement selectCarmake;

	@FindBy(xpath = "//ng-select[@formcontrolname='model']//input[@type='text']")
	@CacheLookup
	WebElement CarModeldropdwn;

	@FindBy(xpath = "//span[text()='740']")
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

	@FindBy(xpath = "//span[@id='cell-1642']//button[@title='Cancel Reservation']")
	@CacheLookup
	WebElement deleteReservation;

	public void clickAddReservation() {
		utilsObj.visibilityOfMoreWaitTime(addReservation);
		addReservation.click();
	}

	public void clickNoConfirmation() {
		utilsObj.visibilityOfMoreWaitTime(clickNoConfirmation);
		clickNoConfirmation.click();
	}

	// Enter Customer Details

	public void enterFirstName() {
		enterFirstName.sendKeys("Adam");
	}

	public void enterLastName() {
		enterLastName.sendKeys("Samuel");
	}

	public void enterPhoneNumber() {
		enterPhoneNumber.sendKeys("248569400");
	}

	public void enterEmail() {
		enterEmail.sendKeys("abdc@gmail.com");
	}

	public void selectCity() {
		selectCity.click();
	}

	public void selectLocationdropdown() {
		utilsObj.visibilityOf(selectLocationdropdown);
		selectLocationdropdown.click();
	}

	public void selectLocation() {
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
		enterstartDate.sendKeys("02/10/2025");
	}

	public void enterstartTime() {
		enterstartTime.sendKeys("09:00 AM");
	}

	public void enterEndDate() {
		enterEndDate.sendKeys("02/21/2025");
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

	public void selectCarmake() {
		selectCarmake.sendKeys("Volvo", Keys.ENTER);
	}

	public void CarModeldropdwn() {
		CarModeldropdwn.sendKeys(Keys.ENTER);
	}

	public void clickCarModelNumber() {
		clickCarModelNumber.click();
	}

	public void selectLicenceno() {
		enterLicenceno.sendKeys("RFT9909", Keys.ENTER);
		enterLicenceno.sendKeys(Keys.TAB);
	}

	public void selectState() {
		Statedropdown.sendKeys("California", Keys.ENTER);
	}

	public void clickCreateReservation() {
		createReservationBtn.click();
	}

	public AddReservationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
