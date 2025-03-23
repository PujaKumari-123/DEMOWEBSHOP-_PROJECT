package stepDefinition;

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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageScenarios {
	
	WebDriver driver;
	
	Pages.Homepage hScenarios;
	
	Pages.Homepage cPageScenarios;
	
	Pages.Homepage productDetails;
	
	Pages.SearchesProductPage sPage;
	
@Given("User is on the homepage")
public void user_is_on_the_homepage() {
	driver = new ChromeDriver();
	
	driver.get("https://demowebshop.tricentis.com/");
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 // Initialize all page objects
    hScenarios = new Pages.Homepage(driver);
    cPageScenarios = new Pages.Homepage(driver);
    productDetails = new Pages.Homepage(driver);
    sPage = new SearchesProductPage(driver);
}

@When("User searches for Laptop")
public void user_searches_for_laptop() {
	
	
	hScenarios.search();
	
	hScenarios.searchdata("laptop");
	
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
	
	String shopString=driver.findElement(By.linkText("shopping cart")).getText();
    
    Assert.assertEquals(shopString, "shopping cart");
}

@Then("The cart count should increase")
public void the_cart_count_should_increase() {
	
	List<WebElement> itemElements = driver.findElements(By.cssSelector("[class='items']"));
	
	if (!itemElements.isEmpty()) {
		
		System.out.println("Items has been added successfully");
		
	}
}

@Given("User has a product in the cart")
public void user_has_a_product_in_the_cart() {
	hScenarios.shoppingpage();
	
	WebElement addedproduct = driver.findElement(By.cssSelector("[class=\"product-name\"]"));
	
	if (addedproduct.isDisplayed()) {
		
	      System.out.println("A product is available in the cart");
		
	}
	
	else {
		
		System.out.println("Item is missing");
	}
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
	String emptyassertString=driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
	
	Assert.assertEquals(emptyassertString, "Your Shopping Cart is empty!");
}

@Then("The cart count should decrease")
public void the_cart_count_should_decrease() {
   
	driver.getCurrentUrl();

}

@When("User changes the quantity of the product to two")
public void user_changes_the_quantity_of_the_product_to_two() {
   
	cPageScenarios.updateqty();
}

@When("User clicks on Update Cart")
public void user_clicks_on_update_cart() {

	WebElement tamountElement= driver.findElement(By.xpath("(//*[@class=\"product-price order-total\"])"));
	if (tamountElement.getText().equals("4770")) {
		
		System.out.println("Product Updated");
		
	}
}

@Then("The cart should reflect the updated quantity")
public void the_cart_should_reflect_the_updated_quantity() {
	WebElement tamountElement= driver.findElement(By.xpath("(//*[@class=\"product-price order-total\"])"));
	if (tamountElement.getText().equals("4770")) {
		
		System.out.println("Product Updated");
		
	}
}

@Then("The total price should be updated accordingly")
public void the_total_price_should_be_updated_accordingly() {
	 String emptyassertString=driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
		
		Assert.assertEquals(emptyassertString, "Your Shopping Cart is empty!");
}

@Given("User has an empty cart")
public void user_has_an_empty_cart() {
	String emptyassertString=driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
//	
	Assert.assertEquals(emptyassertString, "Your Shopping Cart is empty!");
}

@Then("A message Your cart is empty should be displayed")
public void a_message_your_cart_is_empty_should_be_displayed() {
	String emptyassertString=driver.findElement(By.cssSelector("[class=\"order-summary-content\"]")).getText();
//	
	Assert.assertEquals(emptyassertString, "Your Shopping Cart is empty!");
}

@When("User clicks on Proceed to Checkout")
public void user_clicks_on_proceed_to_checkout() {
    driver.getTitle();
}

@Then("The checkout page should be displayed")
public void the_checkout_page_should_be_displayed() {
    driver.getCurrentUrl();
}

}


