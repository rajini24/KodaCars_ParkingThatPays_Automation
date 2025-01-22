package kodacarsTestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacarsPageObjects.LoginPage;
import com.kodacarsTestBase.BaseClass;
import com.kodacarsUilities.ConfigFileReader;
import com.kodacarsUilities.LoggerLoad;

public class TC001_LoginTest extends BaseClass {
	String username;
	String password;
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();
	@Test()
	public void ValidLoginCredentials() {

		LoginPage loginObj = new LoginPage(driver);
		 username=configFileReader.getUsername();
		 password=configFileReader.getPassword();

		LoggerLoad.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
			+ password + "\" ");
		if (username != null || password != null) {
			loginObj.setUsername(username);
			loginObj.setLoginPassword(password);
			loginObj.clickLoginBtn();
		}

		System.out.println(loginObj.getActualTitle());
		Assert.assertEquals(loginObj.getActualTitle(), "KodaCars Web Portal");
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}

}
