package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//a[@href=\"#\" and @data-toggle=\"dropdown\" ]")private WebElement adminButton;
	@FindBy(xpath="//i[@class=\"ace-icon fa fa-power-off\"]")private WebElement logoutButton;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement pagetitle;
	
	public void clickOnAdminButton() {
		adminButton.click();
	}
	
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	public boolean getpagetitle() {
	return pagetitle.isDisplayed();
}
}
