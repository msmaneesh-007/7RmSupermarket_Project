package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;

	
	

	public void selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
	}

	public void selectDropdownWithVisibleText(WebElement element, String visibleText) {
		Select object = new Select(element);
		object.selectByVisibleText(visibleText);
	}

	public void selectDropdownByValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void verifyCheckBox(WebElement element) {
		element.click();
	}

	public void verifyRadioButton(WebElement element) {
		element.click();
	}

	public void verifyRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void verifyMouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
