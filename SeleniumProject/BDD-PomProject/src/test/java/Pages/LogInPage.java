package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LogInPage {

	private WebDriverWait wait;
	
	private By loginLink = By.xpath("//a[text()='Log in']");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By checkbox = By.id("RememberMe");
	private By loginbutton = By.cssSelector(".button-1.login-button");
	private By loginErrorMessage = By.className("message-error");
	
	// constructor
	public LogInPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// **Methods**
    public void clickLoginLink() {
    	 wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }
	
	public void enterEmail(String emails) {
		 WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
	     emailField.clear();
	     emailField.sendKeys(emails);
	}
	public void enterPassword(String passwordbox) {
		 WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
	     passwordField.clear();
	     passwordField.sendKeys(passwordbox);
	}
	public void clickOnCheckbox() {
		 wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	}
	public void clickLoginbutton() {
		  wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
	}
    public void verifyLoginErrorMessage(String expectedMessage) {
    	String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)).getText();
    	
    	SoftAssert softAssert = new SoftAssert();
    	
    	softAssert.assertEquals(actualMessage, expectedMessage, "Error message does not match!");
    }
}
