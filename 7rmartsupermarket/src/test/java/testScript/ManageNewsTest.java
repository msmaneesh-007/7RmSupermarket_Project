package testScript;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;


public class ManageNewsTest extends Base{

	@Test
	public void VerifyWhetheruUserIsAbleToAddNews() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		ManageNewsPage news= new ManageNewsPage(driver);
		news.clickManageNewsButton();
		news.clickcreateNewButton();
		news.clickNewsTextbox();
		String newsTextToAdd=ExcelUtility.getStringData(0, 0, "NewsPage");
		news.readDataToNewsTextBox(newsTextToAdd);
		news.clickSaveButton();
		boolean isalertdisplayed=news.successAlertDisplay();
		Assert.assertTrue(isalertdisplayed, "news creation failed");
		
	}
	@Test
	public void verifywhetherUserIsAbleToSearchNews() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		ManageNewsPage search=new ManageNewsPage(driver);
		search.clickManageNewsButton();
		search.clickSearchButton();
	    String searchText=ExcelUtility.getStringData(0, 0, "NewsPage");
		search.enterSearchTittle(searchText);
		search.searchForTheText();
		boolean isWarningDisplayed=search.resultPageIndex();
		Assert.assertTrue(isWarningDisplayed,"no search results found");
	}
}
