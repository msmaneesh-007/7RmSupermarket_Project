package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
public static int IMPLICITWAIT=5;
public static int EXPLICITWAIT=5;



public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
		int total) {
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
			.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
}

public void implicitWait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT));
}

public void waitForWebElementAlert(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.alertIsPresent());
}
public void waitForWebElementToBeclickable(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForWebElementToBeVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void waitForWebElementToBeSelected(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
}