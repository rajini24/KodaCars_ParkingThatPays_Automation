package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class CarMakeDataProvider {

	private static final String VALID_LOGIN_SHEET = "CarMake";

	@DataProvider(name = "CarMakeDetails")
	public static Object[][] validLoginDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(VALID_LOGIN_SHEET);
		return data;
	}
}
