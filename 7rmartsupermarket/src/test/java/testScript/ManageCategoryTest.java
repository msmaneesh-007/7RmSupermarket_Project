package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageCategoryTest extends Base{
HomePage home;
ManageCategoryPage category;
	@Test(description="To verify whether user is able to create new category")
	public void verifyWhetherUserIsAbleToCreateNEwCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "Login page");
		String password = ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		home=login.clickSignInButton();
		category=home.clickCategory();
		category.createNewButon();
		RandomDataUtility randomcategory=new RandomDataUtility();
		String categoryName=randomcategory.createRandomProductCategory();
		category.enterCategoryName(categoryName).selectGroup().selectimagefile().leftMenuRadio().topMenuradio().saveButton();
		boolean isalertdisplayed=category.getAlertText();
		Assert.assertTrue(isalertdisplayed, Messages.CATEGORYSAVEERROR);
		
	}
}
