package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInstep {
	
	WebDriver driver;
	SignInPage loginPage;
	
	@Given("User is open chromebrowser and put on url")
	public void user_is_open_chromebrowser_and_put_on_url() {
	   
	   driver = new ChromeDriver();
	   
	   driver.get("https://demowebshop.tricentis.com/");
	   
	   driver.manage().window().maximize();
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	   
	  // Initialize LoginPage
	   loginPage = new SignInPage(driver);
		
	}

	@When("User is click on Gender button, Firstname, Lastname, Email")
	public void user_is_click_on_gender_button_firstname_lastname_email() {
		    loginPage.clickRegisterButton();
		    loginPage.clickGender();
		    loginPage.enterFirstname("John");
		    loginPage.enterLastname("Doe");
		    loginPage.enterEmail("puja2911@gmail.com");
		
	}
	

	@When("User is put on password , Confirm password")
	public void user_is_put_on_password_confirm_password() {
	   loginPage.enterPassword("123John");
	   loginPage.enterConfirmpass("123John");
	}

	@Then("User is click on Registeration button")
	public void user_is_click_on_registeration_button() {
	  loginPage.clickButton(null);
	  driver.quit();
	  
	}
}
