package testScript;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUserPage;
import pages.LoginPage;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base{
	@Test
	public void verifyWhetherUserIsAbleToCreateNewAdminUser() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		AdminUserPage admin=new AdminUserPage(driver);
		admin.adminUserCreationWindow();
		admin.crateNewoption();
		RandomDataUtility random=new RandomDataUtility();
		
		String enterusername=random.createRandomUsername();
		String enterpassword=random.createRandomPassword();
		admin.enterusernameonfield(enterusername);
		admin.enterPasswordonField(enterpassword);
		admin.selectUserType();
		admin.selectsaveButon();
		boolean isalertdisplayed=admin.createalert();
		Assert.assertTrue(isalertdisplayed, "user creation failed");
			
		}
	@Test
	public void verifyWhetherUserIsAbleToSearchAdminUsers() throws IOException {
		
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		AdminUserPage admin=new AdminUserPage(driver);
		admin.adminUserCreationWindow();
		admin.searchoption();
		String userDataToSearch=ExcelUtility.getStringData(0, 0,"AdmincreationPage");
		admin.userSearchWithNameAndType(userDataToSearch);
		admin.userTypeForUserSearch();
		boolean isTextdisplayedinresult=admin.textinresulthWindow();
		Assert.assertTrue(isTextdisplayedinresult, "User is not able to search");
		
				
	}
	}


