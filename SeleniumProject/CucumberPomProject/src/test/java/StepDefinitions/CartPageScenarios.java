package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import POMData.CartPage;
import POMData.Homepage;
import POMData.ProductDetails;
import POMData.SearchesProductPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageScenarios {

    WebDriver driver;
    Homepage hScenarios;
    CartPage cPageScenarios;
    ProductDetails productDetails;
    SearchesProductPage sPage;

    // Initialize WebDriver and Page Objects before each scenario
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize all Page Objects
        hScenarios = new Homepage(driver);
        cPageScenarios = new CartPage(driver);
        productDetails = new ProductDetails(driver);
        sPage = new SearchesProductPage(driver);
    }

    // Clean up after each scenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("User searches for {string}")
    public void user_searches_for(String product) {
        hScenarios.search();
        hScenarios.searchdata(product);
    }

    @When("User clicks on the first product")
    public void user_clicks_on_the_first_product() {
        sPage.searchedproduct();
    }

    @When("User clicks on Add to Cart")
    public void user_clicks_on_add_to_cart() {
        productDetails.addcart();
    }

    @Then("The product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        String shopString = driver.findElement(By.linkText("shopping cart")).getText();
        Assert.assertEquals(shopString, "shopping cart", "Product was not added to the cart.");
    }

    @Then("The cart count should increase")
    public void the_cart_count_should_increase() {
        List<WebElement> itemElements = driver.findElements(By.cssSelector("[class='items']"));
        Assert.assertFalse(itemElements.isEmpty(), "Cart count did not increase.");
        System.out.println("Items have been added successfully.");
    }

    @Given("User has a product in the cart")
    public void user_has_a_product_in_the_cart() {
        hScenarios.shoppingpage();
        WebElement addedProduct = driver.findElement(By.cssSelector("[class=\"product-name\"]"));
        Assert.assertTrue(addedProduct.isDisplayed(), "No product is available in the cart.");
        System.out.println("A product is available in the cart.");
    }

    @When("User navigates to the cart")
    public void user_navigates_to_the_cart() {
        hScenarios.shoppingpage();
    }

    @When("User clicks on Remove for the product")
    public void user_clicks_on_remove_for_the_product() {
        cPageScenarios.removecartproduct();
    }

    @Then("The product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
        String emptyAssertString = driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
        Assert.assertEquals(emptyAssertString, "Your Shopping Cart is empty!", "Product was not removed from the cart.");
    }

    @Then("The cart count should decrease")
    public void the_cart_count_should_decrease() {
        List<WebElement> itemElements = driver.findElements(By.cssSelector("[class='items']"));
        Assert.assertTrue(itemElements.isEmpty(), "Cart count did not decrease.");
        System.out.println("Cart count decreased.");
    }

    @When("User changes the quantity of the product to {int}")
    public void user_changes_the_quantity_of_the_product_to(int quantity) {
        cPageScenarios.updateqty();
    }

    @When("User clicks on Update Cart")
    public void user_clicks_on_update_cart() {
        cPageScenarios.updateqty();
    }

    @Then("The cart should reflect the updated quantity")
    public void the_cart_should_reflect_the_updated_quantity() {
        WebElement quantityElement = driver.findElement(By.cssSelector("[class='qty-input']"));
        String updatedQuantity = quantityElement.getAttribute("value");
        Assert.assertEquals(updatedQuantity, "2", "Quantity was not updated.");
        System.out.println("Cart quantity updated to 2.");
    }

    @Then("The total price should be updated accordingly")
    public void the_total_price_should_be_updated_accordingly() {
        WebElement totalPriceElement = driver.findElement(By.cssSelector("[class='product-price order-total']"));
        String totalPrice = totalPriceElement.getText();
        Assert.assertNotEquals(totalPrice, "$0.00", "Total price was not updated.");
        System.out.println("Total price updated to: " + totalPrice);
    }

    @Given("User has an empty cart")
    public void user_has_an_empty_cart() {
        String emptyAssertString = driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
        Assert.assertEquals(emptyAssertString, "Your Shopping Cart is empty!", "Cart is not empty.");
    }

    @Then("A message Your cart is empty should be displayed")
    public void a_message_your_cart_is_empty_should_be_displayed() {
        String emptyAssertString = driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
        Assert.assertEquals(emptyAssertString, "Your Shopping Cart is empty!", "Empty cart message is not displayed.");
    }

    @When("User clicks on Proceed to Checkout")
    public void user_clicks_on_proceed_to_checkout() {
        cPageScenarios.proceedToCheckout();
    }

    @Then("The checkout page should be displayed")
    public void the_checkout_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout"), "Checkout page is not displayed.");
        System.out.println("Checkout page is displayed.");
    }
}