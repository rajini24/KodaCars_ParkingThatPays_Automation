package com.kodacars.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kodacars.qa.uilities.CommonUtils;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	CommonUtils utilsObj = CommonUtils.getInstance();
	
	

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	@CacheLookup
	WebElement username;

	@FindBy(xpath = "//input [@formcontrolname='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement signin;

	public void setUsername(String userName) {
		username.sendKeys(userName);
	}

	public void setLoginPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public DashboardPage clickSignin() {
		signin.click();
		return new DashboardPage(driver);
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	public LoginPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
