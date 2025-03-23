package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	private WebDriver driver;
	
	// locators
	
	private By registerButton = By.xpath("//*[text()='Register']");
	private By genderBy = By.id("gender-male");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By emailId = By.id("Email");
	private By passwordBox = By.id("Password");
	private By confirmPassword = By.id("ConfirmPassword");
	private By regbutton = By.id("register-button");
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void clickRegisterButton() {
		driver.findElement(registerButton).click();
	}
	
	public void clickGender() {
		driver.findElement(genderBy).click();
	}
	
	public void enterFirstname(String name1) {
		driver.findElement(firstName).sendKeys(name1);
	}
	
	public void enterLastname(String name2) {
		driver.findElement(lastName).sendKeys(name2);
	}
	public void enterEmail(String email) {
		driver.findElement(emailId).sendKeys(email);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}
	public void enterConfirmpass(String confirmpassword) {
		driver.findElement(confirmPassword).sendKeys(confirmpassword);
	}
	public void clickButton(String button) {
		driver.findElement(regbutton).click();
	}
}















