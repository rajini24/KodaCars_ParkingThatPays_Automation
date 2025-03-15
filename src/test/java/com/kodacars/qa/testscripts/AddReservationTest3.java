package com.kodacars.qa.testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacars.qa.dataprovider.AddVehicleDataProvider;
import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class AddReservationTest3 extends BaseClass {
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test()
	public void AddReservationForWalkIn() throws InterruptedException {

		LoginPage loginObj = new LoginPage(driver);
		username = configFileReader.getUsername();
		password = configFileReader.getPassword();
		loginObj.setUsername(username);
		loginObj.setLoginPassword(password);
		DashboardPage dashboardObj = loginObj.clickSignin();
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
		dashboardObj.clickAddReservation();
		 dashboardObj.clickNoConfirmation();
		AddReservationPage reservationObj = new AddReservationPage(driver);
		reservationObj.enterPhoneNumber();
		reservationObj.enterEmail();
		reservationObj.enterFirstName();
		reservationObj.enterLastName();

		reservationObj.selectLocationdropdown();
		reservationObj.selectLocation();
		reservationObj.selectSourcedropdown();
	//	reservationObj.selectSource();
		reservationObj.enterstartDate();
		reservationObj.enterstartTime();
		reservationObj.enterEndDate();
		reservationObj.enterEndTime();

		reservationObj.clickAddVehicle();
		reservationObj.carColordropdown();
	//	reservationObj.selectCarcolor();
//		reservationObj.selectCarmake();
//		reservationObj.CarModeldropdwn();
		reservationObj.clickCarModelNumber();
		reservationObj.selectLicenceno();
		reservationObj.selectState();
	//	reservationObj.clickCreateReservation();
		Assert.assertEquals(reservationObj.getReservationSuccessTextMessage(), "Reservation Created Successfully.");
//		reservationObj.clickReservationSuccessBtn();

	}
}
