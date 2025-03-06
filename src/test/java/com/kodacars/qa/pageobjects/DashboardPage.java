package com.kodacars.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kodacars.qa.uilities.CommonUtils;

public class DashboardPage {
	
	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance();
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()=' Add Reservation ']")
	private WebElement addReservation;
	
	@FindBy(xpath = "//button[text()='No']")
	private WebElement clickNoConfirmation;
	
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
	
	
}
