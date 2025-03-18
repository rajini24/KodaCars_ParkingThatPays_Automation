package com.kodacars.qa.testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.kodacars.qa.dataprovider.CarMakeDataProvider;
import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class CarModelAndCarMakeTest extends BaseClass{
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test(dataProvider = "CarMakeDetails", dataProviderClass = CarMakeDataProvider.class)
	// @Test()
	public void verifyAddVehicle(Map<String, String> rowData) throws InterruptedException {
		String selectSourceName = rowData.get("Select Source");
		String carColor = rowData.get("Car Color");
		String carMake = rowData.get("Make");
		String carModel = rowData.get("Model");
		String license = rowData.get("License Plate");
		String state = rowData.get("State");
String Acura="Acura";
		LoginPage loginObj = new LoginPage(driver);
		username = ConfigFileReader.getUsername();
		password = configFileReader.getPassword();
		loginObj.setUsername(username);
		loginObj.setLoginPassword(password);
		DashboardPage dashboardObj = loginObj.clickSignin();
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
		dashboardObj.clickAddReservation();
		dashboardObj.clickNoConfirmation();
		AddReservationPage reservationObj = new AddReservationPage(driver);

//		reservationObj.enterPhoneNumber();
//		reservationObj.enterEmail();
//		reservationObj.enterFirstName();
//		reservationObj.enterLastName();
//
//		reservationObj.selectLocationdropdown();
//		reservationObj.selectLocation();
//		reservationObj.selectSource(selectSourceName);
//		reservationObj.enterstartDate();
//		reservationObj.enterstartTime();
//		reservationObj.enterEndDate();
//		reservationObj.enterEndTime();

		reservationObj.clickAddVehicle();

		System.out.println("***********click carcolor");
		reservationObj.carColordropdown();

		System.out.println("***********click color");

		reservationObj.selectCarcolor(carColor);
		reservationObj.clickCarMakeDropdown();
	//	reservationObj.selectCarMake2();
	//	reservationObj.clickCarModelDropdown();
	//	reservationObj.selectCarModel2();
//		reservationObj.selectLicenceno(license);
		reservationObj.selectState(state);

	}

}
