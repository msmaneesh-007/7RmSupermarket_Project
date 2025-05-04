package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class LoginTest extends Base{
@Test
	public void verifyUserLoginWithValidUserCredentials() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		boolean isdashboarddisplayed=login.dashboardDisplayed();
		Assert.assertTrue(isdashboarddisplayed, "User is unable to login successfully");
		
	}
@Test
public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
	String username=ExcelUtility.getStringData(1, 0,"Login page");
	String password=ExcelUtility.getStringData(1, 1, "Login page");
	LoginPage login=new LoginPage(driver);
	login.enterUserNameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickRememberMe();
	login.clickSignInButton();
	String actual=login.getpagetitle();
	String expected="7rmart supermarket";
	Assert.assertEquals(actual, expected,"User is able to login with invalid username");
}
@Test
public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
	String username=ExcelUtility.getStringData(2, 0,"Login page");
	String password=ExcelUtility.getStringData(2, 1, "Login page");
	LoginPage login=new LoginPage(driver);
	login.enterUserNameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickRememberMe();
	login.clickSignInButton();
	boolean isalertdisplayed=login.invalidUserAlert();
	Assert.assertTrue(isalertdisplayed, "user is able to login with INVALID username");
	
}
@Test
public void verifyUserLoginWithInvalidCredentials() throws IOException {
	
	RandomDataUtility random=new RandomDataUtility();
	String username=random.createRandomUsername();
	String password=random.createRandomPassword();
	//String username=ExcelUtility.getStringData(3, 0,"Login page");
	//String password=ExcelUtility.getStringData(3, 1, "Login page");
	LoginPage login=new LoginPage(driver);
	login.enterUserNameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickRememberMe();
	login.clickSignInButton();
	boolean isalertdisplayed=login.invalidUserAlert();
	Assert.assertTrue(isalertdisplayed, "user is able to login with INVALID credentials");
}
}

