package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import POMData.Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageScenarios {
    
    WebDriver driver;
    Homepage hpScenarios;
    JavascriptExecutor jsExecutor;
    ExtentReports extent;
    ExtentTest logger;
    
    @Given("User enters the browser and enter url")
    public void user_enters_the_browser_and_enter_url() throws FileNotFoundException {
    	
    	String fileInputStream = new String("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\CucumberPomProject\\ProjctsReport.html");
        extent = new ExtentReports(fileInputStream);
        logger = extent.startTest("Homepage Test");

        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        hpScenarios = new Homepage(driver);
        
        logger.log(LogStatus.PASS, "Browser opened and URL entered");
    }

    @When("User clicks on Book")
    public void user_clicks_on_book() throws InterruptedException {
        hpScenarios.book();
        logger.log(LogStatus.PASS, "User clicked on Book");
    }

    @When("Clicks on Computer")
    public void clicks_on_computer() throws InterruptedException {
        hpScenarios.computer();
        logger.log(LogStatus.PASS, "User clicked on Computer");
    }

    @When("Clicks on Electonics")
    public void clicks_on_electonics() throws InterruptedException {
        hpScenarios.electrics();
        logger.log(LogStatus.PASS, "User clicked on Electronics");
    }

    @Then("Url should change")
    public void url_should_change() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("electronics"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/electronics");
        logger.log(LogStatus.PASS, "URL changed successfully");
    }

    @When("User clicks on Search")
    public void user_clicks_on_search() {
        hpScenarios.search();
        logger.log(LogStatus.PASS, "User clicked on Search");
    }

    @When("Enters Invalid data")
    public void enters_invalid_data() {
        hpScenarios.searchinvalid("3902i4oer&384923!@#)!@_@)#(","______!@#~~   @)@)!@efkd000");
        logger.log(LogStatus.PASS, "Invalid data entered");
    }

    @Then("No Results should be visible")
    public void no_results_should_be_visible() {
        driver.getTitle();
        logger.log(LogStatus.PASS, "No results visible as expected");
    }

    @Then("New Page should be opened")
    public void new_page_should_be_opened() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/wishlist");
        logger.log(LogStatus.PASS, "New page opened successfully");
    }

    @When("User scrolls down")
    public void user_scrolls_down() {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,1400)", true);
        logger.log(LogStatus.PASS, "User scrolled down");
    }

    @Then("Featured Options should be visible")
    public void featured_options_should_be_visible() {
        String featurElement = driver.findElement(By.xpath("//*[.='Featured products']")).getText();
        Assert.assertEquals(featurElement, "FEATURED PRODUCTS");
        logger.log(LogStatus.PASS, "Featured options are visible");
    }

    @Then("Customer Service should be visible")
    public void customer_service_should_be_visible() {
        String customerassert = driver.findElement(By.xpath("//*[.='Customer service']")).getText();
        Assert.assertEquals(customerassert, "CUSTOMER SERVICE");
        logger.log(LogStatus.PASS, "Customer service section is visible");
    }
    
    @Then("End Test and Generate Report")
    public void end_test_and_generate_report() {
        extent.endTest(logger);
        extent.flush();
        extent.close();
        driver.quit();
    }
}
