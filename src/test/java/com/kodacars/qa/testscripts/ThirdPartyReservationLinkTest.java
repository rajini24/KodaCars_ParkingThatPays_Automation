package com.kodacars.qa.testscripts;

import org.testng.annotations.Test;

import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class ThirdPartyReservationLinkTest extends BaseClass {
		String username;
		String password;
		
		ConfigFileReader configFileReader = ConfigFileReader.getInstance();

		//Third Party Reservation Link Receiving the Cash Payment
		
		@Test()
		public void DashboardThirdPartyReservationLink() {
			loginObj = new LoginPage(driver);
			username = ConfigFileReader.getUsername();
			password = ConfigFileReader.getPassword();
			loginObj.setUsername(username);
			loginObj.setLoginPassword(password);
				
			dashboardObj = loginObj.clickSignin();
			LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");	
			AddReservationPage reservationObj = dashboardObj.clickReservationLink();
			//AddReservationPage reservationObj = dashboardObj.clickYesConfirmation();
			reservationObj.clickReceivePayment();
			reservationObj.selectPaymentMode();
			reservationObj.selectCash();
			reservationObj.clickcollectPayment();
			reservationObj.clickpaymentReceivedSuccessfully();
			
		}
}
