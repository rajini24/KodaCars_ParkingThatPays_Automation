package com.kodacars.qa.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class ThirdPartyReservationLinkTest extends BaseClass {
DashboardPage dashboardpage;
	
	@BeforeMethod
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		 dashboardpage = loginPage.login(ConfigFileReader.getUsername(), ConfigFileReader.getPassword());
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}


		//Third Party Reservation Link Receiving the Cash Payment
		
		@Test()
		public void DashboardThirdPartyReservationLink() {
				
			//AddReservationPage reservationObj = dashboardpage.clickReservationLink();
//			reservationObj.clickReceivePayment();
//			reservationObj.selectPaymentMode();
//			reservationObj.selectCash();
//			reservationObj.clickcollectPayment();
//			reservationObj.clickpaymentReceivedSuccessfully();
		}
}
