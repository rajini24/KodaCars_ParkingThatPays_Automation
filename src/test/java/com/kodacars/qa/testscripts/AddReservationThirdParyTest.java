package com.kodacars.qa.testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacars.qa.dataprovider.SearchThirdpartyConfirmationNumberDataProvider2;
import com.kodacars.qa.dataprovider.ThirdpartyManuallyCreateConfirmationNumberDataProvider;
import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class AddReservationThirdParyTest extends BaseClass {
	String username;
	String password;
	
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	
	//Create Manually the confirmation Number
	@Test(priority=0,dataProvider = "ThirdpartyManuallyCreateConfirmationNumber",dataProviderClass=ThirdpartyManuallyCreateConfirmationNumberDataProvider.class)
	
	public void AddReservationForThirdPartyCreateManually(Map<String, String> rowData) throws InterruptedException {

		String selectSourceName = rowData.get("Select Source");
		String confirmationNumber = rowData.get("confirmation Number");
		String PrepaidPartial = rowData.get("Prepaid Or Partial");
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
		
		AddReservationPage reservationObj = dashboardObj.clickYesConfirmation();
		reservationObj.clickcreateManually();
		
		//reservationObj.clickThirdPartySource();
		  // Wait for dropdown to be visible
       // Thread.sleep(2000);
		// Customer Details
		reservationObj.enterPhoneNumber();
		reservationObj.enterEmail();
		reservationObj.enterFirstName();
		reservationObj.enterLastName();

//		//Reservation Details
		reservationObj.selectLocationdropdown1();
		reservationObj.selectLocation();
		reservationObj.selectSource(selectSourceName);
		reservationObj.enterconfirmationNumber(confirmationNumber);
		reservationObj.enterstartDate();
		reservationObj.enterstartTime();
		reservationObj.enterEndDate();
		reservationObj.enterEndTime();
		reservationObj.selectReservationPrepaidOrPartial2(PrepaidPartial);
		reservationObj.enterTotalAmount();
		reservationObj.enterPrepaidAmount();
		
//
//		//Add Vehicle Details
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
	
	// Search the third party confirmation Number
		@Test(priority=1,dataProvider = "SearchThirdpartyConfirmationNumber",dataProviderClass=SearchThirdpartyConfirmationNumberDataProvider2.class)
		
		public void AddReservationConfirmationNumberSearch(Map<String, String> rowData) throws InterruptedException {

			//String selectSourceName = rowData.get("Select Source");
			String confirmationNumber = rowData.get("confirmation Number");
			String PrepaidPartial = rowData.get("Prepaid Or Partial");
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
			
			AddReservationPage reservationObj = dashboardObj.clickYesConfirmation();
			reservationObj.enterconfirmationNumber(confirmationNumber);
			reservationObj.clicksearchBtn();
			
			
		}
	
}
