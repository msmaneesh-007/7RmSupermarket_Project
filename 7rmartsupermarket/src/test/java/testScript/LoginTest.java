package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority = 1, description = "verifying whether the user is able to login with valid credentials",retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWithValidUserCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "Login page");
		String password = ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe();
		home=login.clickSignInButton();
		boolean isdashboarddisplayed = login.dashboardDisplayed();
		Assert.assertTrue(isdashboarddisplayed,Messages.VALIDCREDENTIALERROR);

	}
	@Test(priority = 2, description = "Verify Whether User IS Able To Login With Valid Username And Invalid Password",groups={"smoke"})
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login page");
		String password = ExcelUtility.getStringData(1, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe().clickSignInButton();
		String actual = login.getpagetitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.INVALIDPASSWORDERROR);
	}

	@Test(dataProvider="loginProvider",priority = 3, description = "Verify Whether User Is able To Login With INvalid Username ANd Valid Password")
	public void verifyLoginWithInvalidUsernameAndValidPassword(String username,String password) throws IOException {
		//String username = ExcelUtility.getStringData(2, 0, "Login page");
		//String password = ExcelUtility.getStringData(2, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe().clickSignInButton();
		boolean isalertdisplayed = login.invalidUserAlert();
		Assert.assertTrue(isalertdisplayed, Messages.INVALIDUSERNAMEERROR);

	}

	@Test(priority = 4, description = "Verify user Login With invalid Username and Invalid Password",groups={"smoke"})
	public void verifyUserLoginWithInvalidCredentials() throws IOException {

		RandomDataUtility random = new RandomDataUtility();
		String username = random.createRandomUsername();
		String password = random.createRandomPassword();
		// String username=ExcelUtility.getStringData(3, 0,"Login page");
		// String password=ExcelUtility.getStringData(3, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe().clickSignInButton();
		boolean isalertdisplayed = login.invalidUserAlert();
		Assert.assertTrue(isalertdisplayed, Messages.INVALIDCREDENTIALERROR );
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"123","admin"} 
				
					
		};
}
	}

