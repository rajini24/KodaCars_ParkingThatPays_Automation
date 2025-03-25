package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class AddVehicleWalkInDataProvider {

	private static final String VALID_LOGIN_SHEET = "WalkIn";

	@DataProvider(name = "WalkIn")
	public static Object[][] validLoginDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(VALID_LOGIN_SHEET);
		return data;
	}
}
