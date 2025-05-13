package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href=\"#\" and @data-toggle=\"dropdown\" ]")
	private WebElement adminButton;
	@FindBy(xpath = "//i[@class=\"ace-icon fa fa-power-off\"]")
	private WebElement logoutButton;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement pagetitle;
	@FindBy(xpath = "//a[@class='nav-link']//p[contains(text(),'Admin Users')]")
	private WebElement adminUserDropdown;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement ManageuserButton;
	@FindBy(xpath="//p[text()='Manage Category']")private WebElement manageCategoryButton;
	@FindBy(xpath="//p[text()='Manage News']")private WebElement newsWindowButton;

	public AdminUserPage adminUserCreationWindow() {
		adminUserDropdown.click();
		ManageuserButton.click();
		return new AdminUserPage(driver);
	}
	public ManageCategoryPage clickCategory() {
		manageCategoryButton.click();
		return new ManageCategoryPage(driver);
	}
	public ManageNewsPage clickManageNewsButton() {
		newsWindowButton.click();
		return new ManageNewsPage(driver) ;
	}

	public HomePage clickOnAdminButton() {
		adminButton.click();
		return this;
	}
	

	public LoginPage clickOnLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public boolean getpagetitle() {
		return pagetitle.isDisplayed();
	}
}
