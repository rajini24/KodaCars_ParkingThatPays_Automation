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

public class AddReservationTest extends BaseClass {
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test()
	
	public void AddReservationForWalkIn() throws InterruptedException {

//		String carColor = rowData.get("Car Color");
//		String carMake = rowData.get("Make");
//		String carModel = rowData.get("Model");
//		String license = rowData.get("License Plate");
//		String state = rowData.get("State");
	LoginPage loginObj = new LoginPage(driver);
		username = configFileReader.getUsername();
		password = configFileReader.getPassword();
		loginObj.setUsername(username);
		loginObj.setLoginPassword(password);
	//	loginObj.clickSignin();
		
		DashboardPage dashboardObj = loginObj.clickSignin();
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
//		AddReservationPage reservationObj = new AddReservationPage(driver);
		dashboardObj.clickAddReservation();
		AddReservationPage reservationObj = dashboardObj.clickNoConfirmation();
		
		reservationObj.enterPhoneNumber();
		reservationObj.enterEmail();
		reservationObj.enterFirstName();
		reservationObj.enterLastName();

		reservationObj.selectLocationdropdown();
		reservationObj.selectLocation();
		reservationObj.selectSourcedropdown();
		reservationObj.selectSource();
		reservationObj.enterstartDate();
		reservationObj.enterstartTime();
		reservationObj.enterEndDate();
		reservationObj.enterEndTime();

		reservationObj.clickAddVehicle();
		reservationObj.carColordropdown();
		reservationObj.selectCarcolor();
		reservationObj.selectCarmake();
		reservationObj.CarModeldropdwn();
	//	reservationObj.CarModeldropdwntext();
	//	reservationObj.CarModeldummy(carModel);
		reservationObj.clickCarModelNumber();
		reservationObj.selectLicenceno();
		reservationObj.selectState();
		reservationObj.clickCreateReservation();
		Assert.assertEquals(reservationObj.getReservationSuccessTextMessage(), "Reservation Created Successfully.");
		reservationObj.clickReservationSuccessBtn();
	//	reservationObj.clickReservationDetailsArrowLeft();
		//reservationObj.clickDeleteReservationBtn();

       //	reservationObj.clickCancelReservationBtn();

	}
}
