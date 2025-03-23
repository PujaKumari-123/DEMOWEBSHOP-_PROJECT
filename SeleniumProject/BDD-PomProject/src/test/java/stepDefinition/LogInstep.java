package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LogInPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInstep {

	WebDriver driver;
    LogInPage loginPage;
    
	@Given("Users Open chromebrowser and put on Url")
	public void users_open_chromebrowser_and_put_on_url() {
	    
	if (driver == null) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		driver.get("https://demowebshop.tricentis.com/");
		
		// Initialize LoginPage
		
		loginPage = new LogInPage(driver);
	}

	@When("Users click on Login")
	public void users_click_on_login() {
	   loginPage.clickLoginLink();
	}

	@When("Users put on Email id, Password and click on Remember me checkbox")
	public void users_put_on_email_id_password_and_click_on_remember_me_checkbox() {
		loginPage.enterEmail("puja2911@gmail.com");
        loginPage.enterPassword("123John");
        loginPage.clickOnCheckbox();
	}

	@Then("Users click on Login button")
	public void users_click_on_login_button() {
		loginPage.clickLoginbutton();
	}

	@Given("Users Open Chrome browser and put on URL")
	public void users_open_chrome_browser_and_put_on_url() {
		 users_open_chromebrowser_and_put_on_url();
	}

	@When("Users enter invalid Email ID or incorrect Password")
	public void users_enter_invalid_email_id_or_incorrect_password() {
		 loginPage.enterEmail("invalid@example.com");
	     loginPage.enterPassword("wrongPassword123");
	     loginPage.clickOnCheckbox();
	}

	@Then("Users should see a login error message")
	public void users_should_see_a_login_error_message() {
		String expectedErrorMessage = "Login was unsuccessful";
        loginPage.verifyLoginErrorMessage(expectedErrorMessage);
	}

	@Then("Users close the browser")
	public void users_close_the_browser() {
		 if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	}
	
	@After
	public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
	

}

