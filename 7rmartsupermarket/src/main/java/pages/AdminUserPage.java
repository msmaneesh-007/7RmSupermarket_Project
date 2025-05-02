package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {

	public WebDriver driver;
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='nav-link']//p[contains(text(),'Admin Users')]") private WebElement adminUserDropdown;
	@FindBy(xpath="//p[text()='Manage Users']")private WebElement ManageuserButton;
	@FindBy(xpath="//a[text()=' New']")private WebElement createNewButton;
	@FindBy(id="username") private WebElement usernamebox;
	@FindBy(id="password") private WebElement passwordbox;
	@FindBy(id="user_type") private WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")private WebElement savebutton;
	@FindBy(xpath="//h5[contains(text(),'Alert')]")private WebElement alert;
	@FindBy(xpath="//a[contains (text(),'Search')]")private WebElement searchbutton;
	@FindBy(id="un")private WebElement usernamefield;
	@FindBy(id="ut")private WebElement usertypeselect;
	@FindBy(xpath="//button[@name=\"Search\"]")private WebElement searchbuttonInSearchAdminUsers;
	@FindBy(xpath="//h4[text()='Admin Users']")private WebElement textinTheSearchResultDiv;
	
	
	public void adminUserCreationWindow() {
		adminUserDropdown.click();
		ManageuserButton.click();
	}
	public void crateNewoption() {
		createNewButton.click();
	}
	public void enterusernameonfield(String enterusername) {
		usernamebox.sendKeys(enterusername);
	
	}
	public void enterPasswordonField(String enterpassword) {
		passwordbox.sendKeys(enterpassword);
	}
    
	public void selectUserType() {
		Select select=new Select(usertype);
		select.selectByIndex(3);
	}
	public void selectsaveButon() {
		savebutton.click();
	}
	public boolean createalert() {
		return alert.isDisplayed();
		
	}
	public void searchoption() {
		searchbutton.click();
	}

	public void userSearchWithNameAndType(String userDataToSearch) {
		searchbutton.click();
		usernamefield.click();
		usernamefield.sendKeys(userDataToSearch);
				
	}
	public void userTypeForUserSearch() {
		
		Select userselect=new Select(usertypeselect);
		userselect.selectByIndex(0);
		searchbuttonInSearchAdminUsers.click();
	}
	public boolean textinresulthWindow() {
		return textinTheSearchResultDiv.isDisplayed();
	}
}
