package com.kodacars.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class LoginTest extends BaseClass {
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test()
	public void ValidLoginCredentials() {

		LoginPage loginPage = new LoginPage(driver);
		username = ConfigFileReader.getUsername();
		password = ConfigFileReader.getPassword();
		loginPage.setUsername(username);
		loginPage.setLoginPassword(password);
		DashboardPage dashboardpage = loginPage.clickSignin();
		Assert.assertTrue(dashboardpage.isAddReservationBtnDisplayed(), "AddReservation Button Is not dispplaed");
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}

}
