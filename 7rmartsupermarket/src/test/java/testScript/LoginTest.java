package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class LoginTest extends Base {
	@Test(priority = 1, description = "verifying whether the user is able to login with valid credentials",retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWithValidUserCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "Login page");
		String password = ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		boolean isdashboarddisplayed = login.dashboardDisplayed();
		Assert.assertTrue(isdashboarddisplayed,Messages.VALIDCREDENTIALERROR);

	}
	@Test(priority = 2, description = "Verify Whether User IS Able To Login With Valid Username And Invalid Password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Login page");
		String password = ExcelUtility.getStringData(1, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		String actual = login.getpagetitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "User is able to login with invalid username");
	}

	@Test(priority = 3, description = "Verify Whether User Is able To Login With INvalid Username ANd Valid Password")
	public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "Login page");
		String password = ExcelUtility.getStringData(2, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		boolean isalertdisplayed = login.invalidUserAlert();
		Assert.assertTrue(isalertdisplayed, "user is able to login with INVALID username");

	}

	@Test(priority = 4, description = "Verify user Login With invalid Username and Invalid Password",dataProvider="LoginProvider")
	public void verifyUserLoginWithInvalidCredentials() throws IOException {

		RandomDataUtility random = new RandomDataUtility();
		String username = random.createRandomUsername();
		String password = random.createRandomPassword();
		// String username=ExcelUtility.getStringData(3, 0,"Login page");
		// String password=ExcelUtility.getStringData(3, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		boolean isalertdisplayed = login.invalidUserAlert();
		Assert.assertTrue(isalertdisplayed, "user is able to login with INVALID credentials");
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin","admin"},new Object[] {"123","1234"},new Object[] {
				//ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")
					}
		};
}}

