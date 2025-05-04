package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {

	public WebDriver driver;
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Category']")private WebElement manageCategoryButton;
	@FindBy(xpath="//a[text()=' New']")private WebElement createNewButton;
	@FindBy(id="category")private WebElement newTextField;
	@FindBy(id="134-selectable")private WebElement selectGroup;
	@FindBy(id="main_img")private WebElement imageFile;
	@FindBy(xpath="//input[@name='top_menu'and@type='radio'and@value='yes'and@checked='checked']")private WebElement topMenuradio;
	@FindBy(xpath="//input[@name='show_home'and@type='radio'and@value='no']")private WebElement leftMenuRadio;
	@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertTrue;
	
	public void clickCategory() {
		manageCategoryButton.click();
	}
	public void createNewButon() {
		createNewButton.click();
	}
	public void enterCategoryName(String categoryName) {
		newTextField.sendKeys(categoryName);
	}
	public void selectGroup() {
		selectGroup.click();
	}
	public void selectimagefile() {
		imageFile.sendKeys("C:\\Users\\msman\\git\\7RmSupermarket_Project\\7rmartsupermarket\\src\\test\\resources\\Mahindra BE 6E Price and Specifications Info _ Droom.jpg");
		
	}
	public void topMenuradio() {
		JavascriptExecutor jsradio=(JavascriptExecutor)driver;
		jsradio.executeScript("arguments[0].click();", topMenuradio);		
		//jsradio.executeScript("window.scrollBy(0,150)", "");
	}
	public void leftMenuRadio() {
		JavascriptExecutor jsrightradio=(JavascriptExecutor)driver;
		jsrightradio.executeScript("arguments[0].click();", leftMenuRadio);
		jsrightradio.executeScript("window.scrollBy(0,150)", "");
	}
	public void saveButton() {
		JavascriptExecutor jsrightradio=(JavascriptExecutor)driver;
		jsrightradio.executeScript("arguments[0].click();", saveButton);
		//jsrightradio.executeScript("window.scrollBy(0,150)", "");
	}
	
	public boolean getAlertText() {
		return alertTrue.isDisplayed();
	}
	
}
