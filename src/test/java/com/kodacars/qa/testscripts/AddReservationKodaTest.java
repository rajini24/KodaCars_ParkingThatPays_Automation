package com.kodacars.qa.testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacars.qa.dataprovider.AddVehicleKodaDataProvider;
import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class AddReservationKodaTest extends BaseClass {
	String username;
	String password;

	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test(dataProvider = "KodaAddVehicle", dataProviderClass = AddVehicleKodaDataProvider.class)

	public void AddReservationForKoda(Map<String, String> rowData) throws InterruptedException {

		String selectSourceName = rowData.get("Select Source");
		String selectPrepaid = rowData.get("Reservation Prepaid");
		String carColor = rowData.get("Car Color");
		String carMake = rowData.get("Make");
		String carModel = rowData.get("Model");
		String license = rowData.get("License Plate");
		String state = rowData.get("State");

		loginObj = new LoginPage(driver);
		username = ConfigFileReader.getUsername();
		password = ConfigFileReader.getPassword();
		loginObj.setUsername(username);
		loginObj.setLoginPassword(password);

		dashboardObj = loginObj.clickSignin();
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
		dashboardObj.clickAddReservation();

		AddReservationPage reservationObj = dashboardObj.clickNoConfirmation();

		// Customer Details
		reservationObj.enterPhoneNumber();
		reservationObj.enterEmail();
		reservationObj.enterFirstName();
		reservationObj.enterLastName();

		// Reservation Details
		reservationObj.selectLocationdropdown();
		reservationObj.selectLocation();
		reservationObj.selectSource(selectSourceName);
		reservationObj.enterstartDate();
		reservationObj.enterstartTime();
		reservationObj.enterEndDate();
		reservationObj.enterEndTime();
		//reservationObj.selectReservation(selectPrepaid);

		// Add Vehicle Details
		reservationObj.clickAddVehicle();
		reservationObj.carColordropdown();
		reservationObj.selectCarcolor(carColor);
		reservationObj.clickCarMakeDropdown();
		reservationObj.selectCarMake(carMake);
		reservationObj.selectCarModel(carModel);

		reservationObj.selectLicenceno(license);
		reservationObj.selectState(state);
		reservationObj.clickCreateReservation();
		Assert.assertEquals(reservationObj.getReservationSuccessTextMessage(), "Reservation Created Successfully.");
		reservationObj.clickReservationSuccessBtn();
	}
}
