package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{

	@Test
	public void verifyWhetherUserIsAbleToLogoutFromHomePage() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnAdminButton();
		homepage.clickOnLogoutButton();
		boolean istittledisplayed=homepage.getpagetitle();
		Assert.assertTrue(istittledisplayed, "user unable to logout from dashboard");
		
		
	}
}
