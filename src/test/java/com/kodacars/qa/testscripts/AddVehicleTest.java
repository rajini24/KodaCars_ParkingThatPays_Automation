package com.kodacars.qa.testscripts;

import org.testng.annotations.Test;

import com.kodacars.qa.dataprovider.AddVehicleDataProvider;

public class AddVehicleTest {

	@Test(dataProvider = "addVehicleDetails",dataProviderClass=AddVehicleDataProvider.class)
	public void verifyAddVehicle()
	{
		
//		reservationObj.clickAddVehicle();
//		reservationObj.carColordropdown();
//		reservationObj.selectCarcolor();
//		reservationObj.selectCarmake();
//		reservationObj.CarModeldropdwn();
//		reservationObj.clickCarModelNumber();
//		reservationObj.selectLicenceno();
//		reservationObj.selectState();
	}
	
}
