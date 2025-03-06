package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class AddVehicleDataProvider {

	private static final String VALID_LOGIN_SHEET = "VehicleDetails";

	@DataProvider(name = "addVehicleDetails")
	public static Object[][] validLoginDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(VALID_LOGIN_SHEET);
		return data;
	}
}
