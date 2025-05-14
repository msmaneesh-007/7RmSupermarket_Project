package testScript;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;


public class ManageNewsTest extends Base{
HomePage home;
ManageNewsPage news;
	@Test(description="To verify whether user is able to add news")
	public void VerifyWhetheruUserIsAbleToAddNews() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe();
		home=login.clickSignInButton();
		news=home.clickManageNewsButton();
		news.clickcreateNewButton().clickNewsTextbox();
		String newsTextToAdd=ExcelUtility.getStringData(0, 0, "NewsPage");
		news.readDataToNewsTextBox(newsTextToAdd);
		news.clickSaveButton();
		boolean isalertdisplayed=news.successAlertDisplay();
		Assert.assertTrue(isalertdisplayed, Messages.NEWSCREATIONFAILERROR);
		
	}
	@Test(description="To verify whether user is able to search for the news created")
	public void verifywhetherUserIsAbleToSearchNews() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickRememberMe();
		home=login.clickSignInButton();
		news=home.clickManageNewsButton();
		news.clickSearchButton();
	    String searchText=ExcelUtility.getStringData(0, 0, "NewsPage");
		news.enterSearchTittle(searchText).searchForTheText();
		boolean isWarningDisplayed=news.resultPageIndex();
		Assert.assertTrue(isWarningDisplayed,Messages.SEARCHFAILERROR);
	}
}
