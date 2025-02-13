package kodacarsTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacarsPageObjects.LoginPage;
import com.kodacarsTestBase.BaseClass;
import com.kodacarsUilities.ConfigFileReader;
import com.kodacarsUilities.LoggerLoad;

public class LoginTest extends BaseClass {
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test()
	public void ValidLoginCredentials() {

		LoginPage loginObj = new LoginPage(driver);
		username = configFileReader.getUsername();
		password = configFileReader.getPassword();
		loginObj.setUsername(username);
		loginObj.setLoginPassword(password);
		loginObj.clickSignin();
		Assert.assertEquals(loginObj.getActualTitle(), "KodaCars Web Portal");
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}
}
