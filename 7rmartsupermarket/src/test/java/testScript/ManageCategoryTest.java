package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageCategoryTest extends Base{

	@Test
	public void verifyWhetherUserIsAbleToCreateNEwCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "Login page");
		String password = ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		ManageCategoryPage category=new ManageCategoryPage(driver);
		category.clickCategory();
		category.createNewButon();
		RandomDataUtility randomcategory=new RandomDataUtility();
		String categoryName=randomcategory.createRandomProductCategory();
		category.enterCategoryName(categoryName);
		category.selectGroup();
		category.selectimagefile();
		category.leftMenuRadio();
		category.topMenuradio();
		category.saveButton();
		boolean isalertdisplayed=category.getAlertText();
		Assert.assertTrue(isalertdisplayed, "unable to Save Category");
		
	}
}
