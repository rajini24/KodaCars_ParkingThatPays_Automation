package com.kodacars.qa.uilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	WebDriver driver;
	String pagetitle;
	WebDriverWait wait;
	private static CommonUtils utilsObj = null;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (utilsObj != null) {
			return utilsObj;
		} else {
			utilsObj = new CommonUtils();
			return utilsObj;
		}
	}

	public void visibilityOf(WebElement webElementName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElementName));
	}

	public void visibilityOfMoreWaitTime(WebElement webElementName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(webElementName));
	}

	public void visibilityOfExtraWaitTime(WebElement webElementName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(webElementName));
	}

	public void elementToBeClickableWaitTime(WebElement webElementName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(webElementName));
	}
	public WebElement elementToBeClickableExtraWaitTime(WebElement webElementName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(webElementName));
	}
	
	public void attributeToBeWaitTime(WebElement webElementName, String attributeName, String attributeValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(webElementName, attributeName, attributeValue));
	}

	public boolean IsElementDisplayed(WebElement element) {
		boolean flag = false;
		try {
			if (((WebElement) element).isDisplayed()) {
				flag = true;
				//System.out.println("The element is Displayed" + element);

			} else {
				flag = false;
				//System.out.println("The element is not Displayed" + element);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	public boolean listofElementDisplayed(List<WebElement> element) {
		boolean flag = false;
		try {
			if (((WebElement) element).isDisplayed()) {
				flag = true;
				//System.out.println("The element is Displayed" + element);

			} else {
				flag = false;
				//System.out.println("The element is not Displayed" + element);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

}
