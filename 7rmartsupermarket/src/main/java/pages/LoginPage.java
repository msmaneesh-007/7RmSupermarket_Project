package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement passwordField;
	@FindBy(xpath="//label[@for=\"remember\"]")
	private WebElement remembermeField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement pagetitle;
	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]") private WebElement alert;

	public void enterUserNameOnUserNameField(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickRememberMe() {
		remembermeField.click();
	}

	public void clickSignInButton() {
		signin.click();

	}
	public boolean dashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public String getpagetitle() {
		return pagetitle.getText();
	}
	public boolean invalidUserAlert() {
		return alert.isDisplayed();
	}
}
