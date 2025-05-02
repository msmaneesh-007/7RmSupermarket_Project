package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageProductPage {
public WebDriver driver;
public ManageProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


@FindBy(xpath="//p[text()='Manage Product']")private WebElement manageProductSelect;
@FindBy(xpath="//a[normalize-space (text())='New']")private WebElement clicknewButton;
@FindBy(id="title")private WebElement productTittleText;
@FindBy(xpath="//input[@value='Others']")private WebElement productTypeRadio;
@FindBy(id="tag")private WebElement tagName;
@FindBy(id="cat_id")private WebElement categoryselect;
@FindBy(id="sub_id")private WebElement subCategorySelect;
@FindBy(id="grp_id")private WebElement groupSelect;
@FindBy(id="purpose1")private WebElement priceTypeRadio;
@FindBy(id="p_minimum")private WebElement minimumPieceSelect;
@FindBy(id="p_max")private WebElement maxQtyTxt;
@FindBy(id="p_price")private WebElement priceEnter;
@FindBy(id="p_mrp")private WebElement mrpEnter;
@FindBy(id="p_stock")private WebElement stockAvailableTxt;
@FindBy(id="p_pp")private WebElement purchasePriceTxt;
@FindBy(xpath="//input[@name='unlimitp[]']")private WebElement unlimitedStockCheckBox;
@FindBy(xpath="//div[@role='textbox']")private WebElement descriptionTxt;
@FindBy(xpath="//input[@type='radio' and @name='stock' and @value='yes' and @checked='checked']")private WebElement StockYesRadio;
@FindBy(id="main_img")private WebElement imageFileselect;
@FindBy(id="main_imgs")private WebElement subImageFileselect;
@FindBy(xpath="//input[@type='radio' and @name='featured' and @value='yes']")private WebElement featuredYesRadio;
@FindBy(xpath="//input[@type='radio' and @name='combo' and @checked=\"checked")private WebElement comboPackNoRadio;
@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
@FindBy(xpath="//a[@onclick=\'click_button(2)']")private WebElement searchButtonBlue;
@FindBy(xpath="//input[@placeholder='Title']")private WebElement searchWithTittle;
@FindBy(xpath="//button[text()='Search']")private WebElement searchButtonRed;
@FindBy(xpath="//a[normalize-space(text())='1']")private WebElement searchPageIndex;




public void clickManageProduct() {
	manageProductSelect.click();	
}
public void clickNew() {
	clicknewButton.click();
}

public void enterTittle(String tittle) {
	productTittleText.sendKeys(tittle);
}
public void selectProductType() {
	productTypeRadio.click();
}
public void entertagName(String tagname) {
	tagName.sendKeys(tagname);
}
public void selectGorup() {
	Select select=new Select(groupSelect);
	select.selectByIndex(1);
}
public void selectPriceType() {
	priceTypeRadio.click();
}
public void minPieceSelect() {
	Select minpiece=new Select(minimumPieceSelect);
	minpiece.selectByIndex(2);
}
public void enterMaxQty(String maxqty) {
	maxQtyTxt.sendKeys(maxqty);
}
public void enterPrice(String price) {
	priceEnter.sendKeys(price);
}
public void enterMrp(String mrp) {
	mrpEnter.sendKeys(mrp);
}
public void stockavailablity(String stock) {
	stockAvailableTxt.sendKeys(stock);
}
public void purchasePrice(String purchaseprice) {
	purchasePriceTxt.sendKeys(purchaseprice);
}
public void description(String description) {
	descriptionTxt.sendKeys(description);
}
public void imagefile() {
	imageFileselect.sendKeys("C:\\Users\\msman\\git\\Automation_21-03-2025\\AutomationCourse\\src\\test\\resources\\porsche 911.jpeg");
	
}
public void featuredRadio() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",featuredYesRadio );
	js.executeScript("window.scrollBy(0,50)", "");
	
	}
public void saveButton() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",saveButton );
	js.executeScript("window.scrollBy(0,350)", "");
	//js.executeScript("window.scrollBy(0,-350)", "");
	//saveButton.click();
}

public void initialsearchBlue() {
	searchButtonBlue.click();
}
public void searchWithName(String tittleSearch) {
	searchWithTittle.sendKeys(tittleSearch);
}

public void finalSearchRed() {
	searchButtonRed.click();
}
public boolean searchIndex() {
	return searchPageIndex.isDisplayed();
}
}
