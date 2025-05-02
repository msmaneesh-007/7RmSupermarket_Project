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
import utilities.ManageProductExcel;

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
		String tittle=ManageProductExcel.getStringData(0, 1, "sheet");
		manage.enterTittle(tittle);
		manage.selectProductType();
		String tagname=ManageProductExcel.getStringData(1, 1, "sheet");
		manage.entertagName(tagname);
		manage.selectGorup();
		manage.selectPriceType();
		manage.minPieceSelect();
		String maxqty=ManageProductExcel.getintigerData(2, 1, "sheet");
		manage.enterMaxQty(maxqty);
		String price=ManageProductExcel.getintigerData(3, 1, "sheet");
		manage.enterPrice(price);
		String mrp=ManageProductExcel.getintigerData(4, 1, "sheet");
		manage.enterMrp(mrp);
		String stock=ManageProductExcel.getintigerData(5, 1, "sheet");
		manage.stockavailablity(stock);
		String purchaseprice=ManageProductExcel.getintigerData(6, 1, "sheet");
		manage.purchasePrice(purchaseprice);
		String description=ManageProductExcel.getStringData(7, 1, "sheet");
		manage.description(description);
		manage.imagefile();
		
		manage.featuredRadio();
		manage.saveButton();
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
	String tittleSearch=ManageProductExcel.getStringData(8, 1, "sheet");
	search.searchWithName(tittleSearch);
	search.finalSearchRed();
	boolean isSearchindexDisplayed=search.searchIndex();
	Assert.assertTrue(isSearchindexDisplayed, "Search Not found");
	
}
}

