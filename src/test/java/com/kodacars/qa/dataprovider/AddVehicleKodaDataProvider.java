package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class AddVehicleKodaDataProvider {
	private static final String VALID_LOGIN_SHEET = "Koda";

	@DataProvider(name = "KodaAddVehicle")
	public static Object[][] validLoginDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(VALID_LOGIN_SHEET);
		return data;
	}

}
