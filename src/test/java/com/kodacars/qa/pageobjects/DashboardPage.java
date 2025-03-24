package com.kodacars.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kodacars.qa.uilities.CommonUtils;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;
	CommonUtils utilsObj = CommonUtils.getInstance();

	@FindBy(xpath = "//button[text()=' Add Reservation ']")
	@CacheLookup
	private WebElement addReservation;

	@FindBy(xpath = "//button[text()='No']")
	@CacheLookup
	private WebElement clickNoConfirmation;

	@FindBy(xpath = "//button[text()='Yes']")
	@CacheLookup
	private WebElement clickYesConfirmation;

	@FindBy(xpath = "//span[starts-with(@id, 'cell-') and text()='BRHM1063012']")
	@CacheLookup
	private WebElement clickReservationLink;
	
	
	public void clickAddReservation() {
		utilsObj.visibilityOfMoreWaitTime(addReservation);
		addReservation.click();
	}

	public boolean isAddReservationBtnDisplayed() {
		return addReservation.isDisplayed();
	}

	public AddReservationPage clickNoConfirmation() {
		utilsObj.visibilityOfMoreWaitTime(clickNoConfirmation);
		clickNoConfirmation.click();
		return new AddReservationPage(driver);

	}

	public AddReservationPage clickYesConfirmation() {
		utilsObj.visibilityOfMoreWaitTime(clickYesConfirmation);
		clickYesConfirmation.click();
		return new AddReservationPage(driver);
	}

	public AddReservationPage clickReservationLink() {
		utilsObj.visibilityOfMoreWaitTime(clickReservationLink);
		clickReservationLink.click();
		return new AddReservationPage(driver);
	}

	public DashboardPage(WebDriver driver) {

		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
