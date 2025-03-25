package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kodacars.qa.uilities.CommonUtils;

public class AddVehiclePage {
	WebDriverWait wait;
	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance(driver);

	

	@FindBy(xpath = "//div[contains(@class, 'ng-option')]")
	private List<WebElement> dropdownOptions;

	
	public void printDropdownOptions() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(dropdownOptions));

		for (WebElement option : dropdownOptions) {
			System.out.println(option.getText());
			option.click();
		}
	}
	public AddVehiclePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
		PageFactory.initElements(driver, this);
	}
}
