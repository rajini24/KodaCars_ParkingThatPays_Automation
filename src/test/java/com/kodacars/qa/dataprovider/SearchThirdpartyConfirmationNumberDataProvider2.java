package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class SearchThirdpartyConfirmationNumberDataProvider2 {
	private static final String VALID_LOGIN_SHEET = "ThirdParty";

	@DataProvider(name = "SearchThirdpartyConfirmationNumber")
	public static Object[][] validLoginDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(VALID_LOGIN_SHEET);
		return data;
	}

}
