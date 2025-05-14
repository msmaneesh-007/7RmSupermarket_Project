package testScript;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base{
	HomePage home;
	AdminUserPage admin;
	@Test(description="To verify whether user is able to create new admin user")
	public void verifyWhetherUserIsAbleToCreateNewAdminUser() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe();
		home=login.clickSignInButton();
		admin=home.adminUserCreationWindow();
		admin.crateNewoption();
		RandomDataUtility random=new RandomDataUtility();
		String enterusername=random.createRandomUsername();
		String enterpassword=random.createRandomPassword();
		admin.enterusernameonfield(enterusername).enterPasswordonField(enterpassword).selectUserType().selectsaveButon();
		boolean isalertdisplayed=admin.createalert();
		Assert.assertTrue(isalertdisplayed, Messages.USERCREATIONFAILERROR);
			
		}
	@Test(description="To verify whether user is able to search for the created users")
	public void verifyWhetherUserIsAbleToSearchAdminUsers() throws IOException {
		
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe();
		home=login.clickSignInButton();
		admin=home.adminUserCreationWindow();
		admin.searchoption();
		String userDataToSearch=ExcelUtility.getStringData(0, 0,"AdmincreationPage");
		admin.userSearchWithNameAndType(userDataToSearch).userTypeForUserSearch();
		boolean isTextdisplayedinresult=admin.textinresulthWindow();
		Assert.assertTrue(isTextdisplayedinresult, Messages.USERSEARCHFAILERROR);
		
				
	}
	}


