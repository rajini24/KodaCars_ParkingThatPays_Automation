package com.kodacarsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kodacarsUilities.CommonUtils;

public class LoginPage {
	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance();

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	WebElement username;

	@FindBy(xpath = "//input [@formcontrolname='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinBtn;

	public void setUsername(String userName) {
		username.sendKeys(userName);
	}

	public void setLoginPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLoginBtn() {
		signinBtn.click();
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
