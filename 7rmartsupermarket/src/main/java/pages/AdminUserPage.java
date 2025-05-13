package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement createNewButton;
	@FindBy(id = "username")
	private WebElement usernamebox;
	@FindBy(id = "password")
	private WebElement passwordbox;
	@FindBy(id = "user_type")
	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebutton;
	@FindBy(xpath = "//h5[contains(text(),'Alert')]")
	private WebElement alert;
	@FindBy(xpath = "//a[contains (text(),'Search')]")
	private WebElement searchbutton;
	@FindBy(id = "un")
	private WebElement usernamefield;
	@FindBy(id = "ut")
	private WebElement usertypeselect;
	@FindBy(xpath = "//button[@name=\"Search\"]")
	private WebElement searchbuttonInSearchAdminUsers;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	private WebElement textinTheSearchResultDiv;



	public AdminUserPage crateNewoption() {
		WaitUtility wait = new WaitUtility();
		wait.waitForWebElementToBeclickable(driver, createNewButton);
		createNewButton.click();
		return this;
	}

	public AdminUserPage enterusernameonfield(String enterusername) {
		usernamebox.sendKeys(enterusername);
		return this;

	}

	public AdminUserPage enterPasswordonField(String enterpassword) {
		passwordbox.sendKeys(enterpassword);
		return this;
	}

	public AdminUserPage selectUserType() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(usertype, Constant.DROPDOWNONIDEX2);
		return this;
	}

	public AdminUserPage selectsaveButon() {
		savebutton.click();
		return this;
	}

	public boolean createalert() {
		return alert.isDisplayed();

	}

	public AdminUserPage searchoption() {
		WaitUtility wait = new WaitUtility();
		wait.waitForWebElementToBeclickable(driver, searchbutton);
		searchbutton.click();
		return this;
	}

	public AdminUserPage userSearchWithNameAndType(String userDataToSearch) {
		searchbutton.click();
		usernamefield.click();
		usernamefield.sendKeys(userDataToSearch);
		return this;

	}

	public AdminUserPage userTypeForUserSearch() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(usertypeselect, Constant.DROPDOWNONIDEX2);
		searchbuttonInSearchAdminUsers.click();
		return this;
	}

	public boolean textinresulthWindow() {
		return textinTheSearchResultDiv.isDisplayed();
	}
}
