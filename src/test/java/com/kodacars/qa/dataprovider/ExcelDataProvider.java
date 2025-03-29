package com.kodacars.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	private static final String KODA_WALKIN_SHEET = "KodaWalkIn";
	private static final String THIRDPARTY_MANUALLY_CREATED_CONFIRMATION_NUMBER_SHEET = "ThirdParty";
	private static final String SEARCH_THIRDPARTY_CONFIRMATION_NUMEBR = "ThirdPartySearchConfirmationNum";

	@DataProvider(name = "KodaWalkIn")
	public static Object[][] kodaWalkInDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(KODA_WALKIN_SHEET);
		return data;
	}

	@DataProvider(name = "ThirdpartyManuallyCreateConfirmationNumber")
	public static Object[][] thirdPartyManuallyCreateConfirmationNumberDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(THIRDPARTY_MANUALLY_CREATED_CONFIRMATION_NUMBER_SHEET);
		return data;
	}

	@DataProvider(name = "SearchThirdpartyConfirmationNumber")
	public static Object[][] SearchThirdpartyConfirmationNumberDataProvider() {
		Object[][] data = CommonDataProvider.getAllRows(SEARCH_THIRDPARTY_CONFIRMATION_NUMEBR);
		return data;
	}

}
