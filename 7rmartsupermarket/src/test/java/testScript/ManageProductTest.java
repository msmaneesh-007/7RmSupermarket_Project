package testScript;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;


public class ManageProductTest extends Base{
     
	@Test
	public void verifyWhetherUserIsAbleToManageProduct() throws IOException {
		String username=ExcelUtility.getStringData(0, 0,"Login page");
		String password=ExcelUtility.getStringData(0, 1, "Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickRememberMe();
		login.clickSignInButton();
		ManageProductPage manage=new ManageProductPage(driver);
		manage.clickManageProduct();
		manage.clickNew();
		String tittle=ExcelUtility.getStringData(0, 1, "ManageProduct");
		manage.enterTittle(tittle);
		manage.selectProductType();
		String tagname=ExcelUtility.getStringData(1, 1, "ManageProduct");
		manage.entertagName(tagname);
		manage.selectGorup();
		manage.selectPriceType();
		manage.minPieceSelect();
		String maxqty=ExcelUtility.getintigerData(2, 1, "ManageProduct");
		manage.enterMaxQty(maxqty);
		String price=ExcelUtility.getintigerData(3, 1, "ManageProduct");
		manage.enterPrice(price);
		String mrp=ExcelUtility.getintigerData(4, 1, "ManageProduct");
		manage.enterMrp(mrp);
		String stock=ExcelUtility.getintigerData(5, 1, "ManageProduct");
		manage.stockavailablity(stock);
		String purchaseprice=ExcelUtility.getintigerData(6, 1, "ManageProduct");
		manage.purchasePrice(purchaseprice);
		String description=ExcelUtility.getStringData(7, 1, "ManageProduct");
		manage.description(description);
		manage.imagefile();
		manage.featuredRadio();
		manage.saveButton();
		boolean erroralertdisplay=manage.alert();
		Assert.assertTrue(erroralertdisplay, "unable to click save");
	}
@Test	
public void verifyWhetherUserisAbletoSearchProduct() throws IOException {
	String username=ExcelUtility.getStringData(0, 0,"Login page");
	String password=ExcelUtility.getStringData(0, 1, "Login page");
	LoginPage login=new LoginPage(driver);
	login.enterUserNameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickRememberMe();
	login.clickSignInButton();
	ManageProductPage search=new ManageProductPage(driver);
	search.clickManageProduct();
	search.initialsearchBlue();
	String tittleSearch=ExcelUtility.getStringData(8, 1, "ManageProduct");
	search.searchWithName(tittleSearch);
	search.finalSearchRed();
	boolean isSearchindexDisplayed=search.searchIndex();
	Assert.assertTrue(isSearchindexDisplayed, "Search Not found");
	
}
}

