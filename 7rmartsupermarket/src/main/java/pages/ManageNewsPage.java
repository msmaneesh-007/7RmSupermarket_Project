package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(xpath="//p[text()='Manage News']")private WebElement newsWindowButton;
@FindBy(xpath="//a[contains (text(),' New')]")private WebElement createNewNewsButton;
@FindBy(id="news")private WebElement textBoxForNews;
@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement successalert;
@FindBy(xpath="//a[text()=' Search']")private WebElement searchbutton;
@FindBy(xpath="//input[@class='form-control']")private WebElement searchtextField;
@FindBy(xpath="//button[@name='Search']")private WebElement finalSearchButton;
@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")private WebElement searchNotFound;
@FindBy(xpath="//a[@class=\"page-link\"]")private WebElement resultpageindex;



public void clickManageNewsButton() {
	newsWindowButton.click();
}
public void clickcreateNewButton() {
	
	createNewNewsButton.click();
}
public void clickNewsTextbox() {
	textBoxForNews.click();
}
public void readDataToNewsTextBox(String newsTextToAdd) {
	
	textBoxForNews.sendKeys(newsTextToAdd);
	}
public void clickSaveButton() {
	saveButton.click();
}
public boolean successAlertDisplay() {
	return successalert.isDisplayed();
}

public void clickSearchButton() {
	searchbutton.click();
}
public void enterSearchTittle(String searchText) {
	searchtextField.click();
	
	searchtextField.sendKeys(searchText);
	
}
public void searchForTheText() {
	finalSearchButton.click();
	
	
}
/*public boolean searchNotFoundWarning() {
	return searchNotFound.isDisplayed();
}*/
public boolean resultPageIndex() {
	
	return resultpageindex.isDisplayed();
}





}