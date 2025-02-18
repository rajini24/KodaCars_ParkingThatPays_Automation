package kodacarsTestScripts;

import org.testng.annotations.Test;

import com.kodacarsPageObjects.AddReservationPage;
import com.kodacarsPageObjects.LoginPage;
import com.kodacarsTestBase.BaseClass;
import com.kodacarsUilities.ConfigFileReader;
import com.kodacarsUilities.LoggerLoad;

public class AddReservationTest extends BaseClass {
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test()
	public void AddReservationForWalkIn() throws InterruptedException {

		LoginPage loginObj = new LoginPage(driver);
		username = configFileReader.getUsername();
		password = configFileReader.getPassword();
		loginObj.setUsername(username);
		loginObj.setLoginPassword(password);
		loginObj.clickSignin();
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
		AddReservationPage reservationObj = new AddReservationPage(driver);
		reservationObj.clickAddReservation();
		reservationObj.clickNoConfirmation();
		reservationObj.enterPhoneNumber();
		reservationObj.enterEmail();
		reservationObj.enterFirstName();
		reservationObj.enterLastName();

		reservationObj.selectLocationdropdown();
		reservationObj.selectLocation();
		reservationObj.selectSourcedropdown();
		reservationObj.selectSource();
		reservationObj.enterstartDate();
		reservationObj.enterstartTime();
		reservationObj.enterEndDate();
		reservationObj.enterEndTime();

		reservationObj.clickAddVehicle();
		reservationObj.carColordropdown();
		reservationObj.selectCarcolor();
		reservationObj.selectCarmake();
		reservationObj.CarModeldropdwn();
		reservationObj.clickCarModelNumber();
		reservationObj.selectLicenceno();
		reservationObj.selectState();
		reservationObj.clickCreateReservation();
		reservationObj.clickReservationSuccessBtn();

       //	reservationObj.clickCancelReservationBtn();

	}
}
