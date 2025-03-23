package StepDefinitions;

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
    public void user_enters_the_browser_and_enter_url() {
        try {
            // Initialize ExtentReports
            extent = new ExtentReports("C:\\Users\\manis\\OneDrive\\Desktop\\SeleniumProject\\SeleniumProject\\CucumberPomProject\\CucPomReports.html");
            logger = extent.startTest("Homepage Test");

            // Initialize WebDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to the URL
            driver.get("https://demowebshop.tricentis.com/");
            hpScenarios = new Homepage(driver);

            logger.log(LogStatus.PASS, "Browser opened and URL entered");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to open browser or enter URL: " + e.getMessage());
            throw e;
        }
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased wait time
            wait.until(ExpectedConditions.urlContains("electronics"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/electronics");
            logger.log(LogStatus.PASS, "URL changed successfully");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "URL did not change as expected: " + e.getMessage());
            throw e;
        }
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
        try {
            WebElement noResultsElement = driver.findElement(By.xpath("//div[@class='no-result']"));
            Assert.assertTrue(noResultsElement.isDisplayed(), "No results message is not visible");
            logger.log(LogStatus.PASS, "No results visible as expected");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "No results message not found: " + e.getMessage());
            throw e;
        }
    }

    @When("User clicks on Register , Login, Shopping Cart , Wishlist")
    public void user_clicks_on_register_login_shopping_cart_wishlist() {
        try {
            hpScenarios.registeringpage();
            hpScenarios.loginpage();
            hpScenarios.shoppingpage();
            hpScenarios.wish();
            logger.log(LogStatus.PASS, "User clicked on Register, Login, Shopping Cart, and Wishlist");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to click on one or more links: " + e.getMessage());
            throw e;
        }
    }

    @Then("New Page should be opened")
    public void new_page_should_be_opened() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("wishlist"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/wishlist");
            logger.log(LogStatus.PASS, "New page opened successfully");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "New page did not open as expected: " + e.getMessage());
            throw e;
        }
    }

    @When("User scrolls down")
    public void user_scrolls_down() {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,1400)", true);
        logger.log(LogStatus.PASS, "User scrolled down");
    }

    @Then("Featured Options should be visible")
    public void featured_options_should_be_visible() {
        try {
            WebElement featuredElement = driver.findElement(By.xpath("//*[.='Featured products']"));
            Assert.assertEquals(featuredElement.getText(), "FEATURED PRODUCTS");
            logger.log(LogStatus.PASS, "Featured options are visible");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Featured options not found: " + e.getMessage());
            throw e;
        }
    }

    @Then("Customer Service should be visible")
    public void customer_service_should_be_visible() {
        try {
            WebElement customerServiceElement = driver.findElement(By.xpath("//*[.='Customer service']"));
            Assert.assertEquals(customerServiceElement.getText(), "CUSTOMER SERVICE");
            logger.log(LogStatus.PASS, "Customer service section is visible");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Customer service section not found: " + e.getMessage());
            throw e;
        }
    }

    @When("Clicks on View all")
    public void clicks_on_view_all() {
        try {
            WebElement viewAllLink = driver.findElement(By.xpath("//a[contains(text(),'View all')]"));
            viewAllLink.click();
            logger.log(LogStatus.PASS, "User clicked on View all");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to click on View all: " + e.getMessage());
            throw e;
        }
    }

    @Then("List should be visible")
    public void list_should_be_visible() {
        try {
            WebElement listElement = driver.findElement(By.xpath("//div[@class='list']"));
            Assert.assertTrue(listElement.isDisplayed(), "List is not visible");
            logger.log(LogStatus.PASS, "List is visible");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "List not found: " + e.getMessage());
            throw e;
        }
    }

    @Then("End Test and Generate Report")
    public void end_test_and_generate_report() {
        extent.endTest(logger);
        extent.flush();
        extent.close();
        driver.quit();
    }
}