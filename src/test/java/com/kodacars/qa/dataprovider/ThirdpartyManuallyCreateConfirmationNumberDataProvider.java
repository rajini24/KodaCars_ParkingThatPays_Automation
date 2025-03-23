package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class ThirdpartyManuallyCreateConfirmationNumberDataProvider {
	private static final String VALID_LOGIN_SHEET = "ThirdParty";

	@DataProvider(name = "ThirdpartyManuallyCreateConfirmationNumber")
	public static Object[][] validLoginDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(VALID_LOGIN_SHEET);
		return data;
	}

}
