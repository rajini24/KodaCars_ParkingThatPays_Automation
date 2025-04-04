package com.kodacars.qa.testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class AddReservationKodaWalkinTest extends BaseClass {
	DashboardPage dashboardpage;

	@BeforeMethod
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		dashboardpage = loginPage.login(ConfigFileReader.getUsername(), ConfigFileReader.getPassword());
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}

	// Walk-in Customer and Koda
	@Test(priority = 0,dataProvider = "KodaWalkIn", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)

	public void AddReservationForWalkIn(Map<String, String> rowData) throws InterruptedException {

		dashboardpage.clickAddReservation();
		AddReservationPage reservationObj = dashboardpage.clickNoConfirmation();
		Assert.assertTrue(reservationObj.KodaWalkAddReservation(rowData.get("Select Source"),
																rowData.get("Reservation Prepaid"),
																rowData.get("Car Color"),
																rowData.get("Make"),
																rowData.get("Model"),
																rowData.get("License Plate"),
																rowData.get("State")));

	}

	@Test(priority = 1, dataProvider = "ThirdpartyManuallyCreateConfirmationNumber", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)

	public void AddReservationForThirdPartyCreateManually(Map<String, String> rowData) throws InterruptedException {

		dashboardpage.clickAddReservation();
		AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
		Assert.assertTrue(reservationObj.KodaWalkAddReservation(rowData.get("Select Source"),
																rowData.get("confirmation Number"),
																rowData.get("Prepaid Or Partial"),
																rowData.get("Car Color"),
																rowData.get("Make"),
																rowData.get("Model"),
																rowData.get("License Plate"),
																rowData.get("State")));
	}

	
	// Search the third party confirmation Number
	@Test(priority = 2, dataProvider = "ThirdpartyManuallyCreateConfirmationNumber", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)
	
	public void AddReservationConfirmationNumberSearch(Map<String, String> rowData) throws InterruptedException {
		
		dashboardpage.clickAddReservation();
		
		AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
		reservationObj.enterconfirmationNumber( rowData.get("confirmation Number"));
		reservationObj.clicksearchBtn();
		Assert.assertTrue(reservationObj.isReceivePaymentMethodDispalyed());
	}
	
	// the third party confirmation Number Cash/Card Payment Method
	@Test(priority = 3, dataProvider = "receivePayment", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)
	
	public void receiveCashOrCardPayment(Map<String, String> rowData) throws InterruptedException {
		
		
		AddReservationPage reservationObj =dashboardpage.clickLinkByConfirmationNumber(rowData.get("confirmation Number"));
		Assert.assertTrue(reservationObj.ispaymentReceivedSuccessfullyBtnDisplayed(rowData.get("PaymentMode"),
													        	 rowData.get("Card Reference No")));
		
	}
	
	
	


}
