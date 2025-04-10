package com.kodacars.qa.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.ITestListenerClassFile;
@Listeners({ChainTestListener.class,ITestListenerClassFile.class})
public class BaseClass {
	public static WebDriver driver;
//	protected DashboardPage dashboardObj;
//	protected LoginPage loginObj;

	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("Chrome") String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();

		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ConfigFileReader.getLoginUrl());
	}

	@AfterMethod
	public void close() {
		 if (driver != null) {
		      // driver.quit();
		    }
	}


}
