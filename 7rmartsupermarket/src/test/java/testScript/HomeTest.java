package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
HomePage home;
	@Test(description="To verify Whether the user is able to logout from homepage")
	public void verifyWhetherUserIsAbleToLogoutFromHomePage() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		home=login.clickSignInButton();		
		home.clickOnAdminButton().clickOnLogoutButton();
		boolean istittledisplayed=home.getpagetitle();
		Assert.assertTrue(istittledisplayed, Messages.LOGOUT_ERROR);
		
		
	}
}
