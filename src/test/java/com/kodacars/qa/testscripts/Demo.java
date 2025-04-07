package com.kodacars.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
	//	options.addArguments("--disable-javascript");
	//	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("--disable-blink-features=Autofill");
		options.setExperimentalOption("prefs", Map.of(
		    "credentials_enable_service", false,
		    "profile.password_manager_enabled", false,
		    "autofill.credit_card_enabled", false,
		    "autofill.profile_enabled", false
		));
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://stage.providers.kodacars.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		By userNametxt = By.xpath("//input[@formcontrolname='userName']");
		driver.findElement(userNametxt).sendKeys("tstadmin@kodacars.com");
		By passwordtxt = By.xpath("//input[@formcontrolname='password']");
		driver.findElement(passwordtxt).sendKeys("Root@123");
		By submitButton = By.xpath("//button[@type='submit']");
		driver.findElement(submitButton).click();
		By link = By.xpath(
				"//div[@col-id='reservationCode']//span[contains(@class,'ag-cell-value') and text()='BRHM1065429']");
		driver.findElement(link).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// By receiveButton= By.xpath("//div[@class='text-center
		// mt-4']//button[text()='Receive Payment']");
		WebElement receiveButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='text-center mt-4']//button[text()='Receive Payment']")));
		receiveButton.click();

		By selectPaymentModeDDB = By.xpath("//span[text()='Select Payment Mode']");
		driver.findElement(selectPaymentModeDDB).click();
		By cardOption = By.xpath(
				"//p-dropdownitem[contains(@class,'p-element ng-tns-c53-18 ng-star-inserted')]//span[@class='ng-star-inserted' and text()='Card']");
		driver.findElement(cardOption).click();
		String cardWindow = driver.getWindowHandle();
		System.out.println(cardWindow + "@@@@@@@@@@@@@@@@@@@@@");
		By payNowBtn = By.xpath("(//button[text()='Pay Now'])[2]");
		driver.findElement(payNowBtn).click();

		Thread.sleep(3000);

		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getTitle());
		//driver.navigate().to("https://buy.stripe.com/test_bIY9AQd389rM55C96V");

		System.out.println("HAi one");


		
		  new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(driver1 -> driver1.getWindowHandles().size() > 1);

		System.out.println(driver.getWindowHandle());

	//	WebElement element = driver.findElement(By.xpath("//div[@class='ExpandableText--truncated']"));

	//	System.out.println(element.getText());


		Set<String> windowHandles = driver.getWindowHandles();


		System.out.println("No of windows  " +windowHandles.size());
		for (String string : windowHandles) {


			if (!string.equalsIgnoreCase(cardWindow)) {
				driver.switchTo().window(string);
				WebElement emailTxt = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main form input[id='email']")));
				
				Actions actions = new Actions(driver);

				

				WebElement paymentLable = driver.findElement(By.xpath("//h2[text()='Payment method']"));
				actions.moveToElement(paymentLable).click().build().perform();
				

				// WebElement button =
				// driver.findElement(By.cssSelector("[data-testid='afterpay_clearpay-accordion-item-button']"));
				WebElement button = driver.findElement(By.xpath("//button[@data-testid='card-accordion-item-button']"));

				int width = button.getSize().getWidth();
				int height = button.getSize().getHeight();

				// Move toward the right side where ::after is likely rendered
				int xOffset = (int) (width * 0.75); // 75% from left
				int yOffset = height / 2; // vertically centered

				actions.moveToElement(button, xOffset, yOffset).click().perform();

				System.out.println(xOffset + "*********");
				System.out.println(yOffset + "*********");

				WebElement cardInforationTextbox = driver.findElement(By.name("cardNumber"));

				actions.moveToElement(cardInforationTextbox).click().sendKeys("4242 4242 4242 4242").build().perform();
				WebElement cardExpiryTextbox = driver.findElement(By.name("cardExpiry"));

				actions.moveToElement(cardExpiryTextbox).click().sendKeys("09/27").build().perform();
				WebElement cvcTextbox = driver.findElement(By.name("cardCvc"));

				actions.moveToElement(cvcTextbox).click().sendKeys("686").build().perform();
				WebElement billingNameTextbox = driver.findElement(By.name("billingName"));

				actions.moveToElement(billingNameTextbox).click().sendKeys("MeenaKumarri").build().perform();
				WebElement zipTextbox = driver.findElement(By.name("billingPostalCode"));

				actions.moveToElement(zipTextbox).click().sendKeys("30004").build().perform();
				
				WebElement phoneNoCheckbox = driver.findElement(By.id("enableStripePass"));				
				actions.click(phoneNoCheckbox).perform();

				JavascriptExecutor js=(JavascriptExecutor) driver;
				
				
				actions.moveToElement(emailTxt).click().sendKeys("ranja@gmail.com").build().perform();
				
				/*
				 * js.executeScript("arguments[0].value='rani@gmail.com';" +
				 * " arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
				 * "  arguments[0].dispatchEvent(new Event('change', { bubbles: true }));" +
				 * "arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));",
				 * emailTxt);
				 */
				WebElement payButton = driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']"));
				js.executeScript("arguments[0].click();", payButton);
				
				By successMessageLable = By.xpath("//h1[text()='Payment Successful']");
				WebElement successMessageLableWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLable));
				System.out.println(successMessageLableWebElement.getText());
				driver.close();

				
			
				


			//	WebElement payButton = driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']"));
			//	js.executeScript("arguments[0].click();", payButton);
			//	driver.findElement(xpath;


				/*
				 * WebElement button=driver.findElement(By.xpath(
				 * "/button[@data-testid='card-accordion-item-button']"));
				 * 
				 * String afterContent = (String) ((JavascriptExecutor) driver)
				 * .executeScript("return window.getComputedStyle(arguments[0],'::after').getPropertyValue('content');"
				 * , button); System.out.println(afterContent);
				 * 
				 * 
				 * WebElement payRadiobutton =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				 * "/button[@data-testid='card-accordion-item-button']")));
				 * js.executeScript("arguments[0].click();", payRadiobutton);
				 * 
				 * js.executeScript("arguments[0].value='4242 4242 4242 4242';",
				 * driver.findElement(By.id("cardNumber")));
				 */
			}


		}



		// div[@id='root']//main//input[@id='email']

	}

}
