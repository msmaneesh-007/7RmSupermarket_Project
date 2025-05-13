package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageCategoryPage {

	public WebDriver driver;
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=' New']")private WebElement createNewButton;
	@FindBy(id="category")private WebElement newTextField;
	@FindBy(id="134-selectable")private WebElement selectGroup;
	@FindBy(id="main_img")private WebElement imageFile;
	@FindBy(xpath="//input[@name='top_menu'and@type='radio'and@value='yes'and@checked='checked']")private WebElement topMenuradio;
	@FindBy(xpath="//input[@name='show_home'and@type='radio'and@value='no']")private WebElement leftMenuRadio;
	@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertTrue;
	
	
	public ManageCategoryPage createNewButon() {
		createNewButton.click();
		return this;
	}
	public ManageCategoryPage enterCategoryName(String categoryName) {
		newTextField.sendKeys(categoryName);
		return this;
	}
	public ManageCategoryPage selectGroup() {
		selectGroup.click();
		return this;
	}
	public ManageCategoryPage selectimagefile() {
		imageFile.sendKeys(Constant.IMAGEFILE4CATEGORY);
		return this;
		
	}
	public ManageCategoryPage topMenuradio() {
		JavascriptExecutor jsradio=(JavascriptExecutor)driver;
		jsradio.executeScript("arguments[0].click();", topMenuradio);		
		//jsradio.executeScript("window.scrollBy(0,150)", "");
		return this;
		
	}
	public ManageCategoryPage leftMenuRadio() {
		JavascriptExecutor jsrightradio=(JavascriptExecutor)driver;
		jsrightradio.executeScript("arguments[0].click();", leftMenuRadio);
		jsrightradio.executeScript("window.scrollBy(0,150)", "");
		return this;
	}
	public ManageCategoryPage saveButton() {
		JavascriptExecutor jsrightradio=(JavascriptExecutor)driver;
		jsrightradio.executeScript("arguments[0].click();", saveButton);
		//jsrightradio.executeScript("window.scrollBy(0,150)", "");
		return this;
	}
	
	public boolean getAlertText() {
		return alertTrue.isDisplayed();
	}
	
}
