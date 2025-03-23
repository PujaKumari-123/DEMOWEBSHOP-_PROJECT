package POMData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	
	private By removalAddtocartbutton = By.name("removefromcart");
	
	private By updatebuttoncartBy= By.cssSelector("[value=\"Update shopping cart\"]");
	
	private By cartqtyBy= By.cssSelector("[class='qty-input valid']");
	
		public void removecartproduct() {
			
			driver.findElement(removalAddtocartbutton).click();
			
			driver.findElement(updatebuttoncartBy).click();
			
		}
		
		public void updateqty() {
			
			driver.findElement(cartqtyBy).sendKeys("3",Keys.ENTER);
		}
    
}
