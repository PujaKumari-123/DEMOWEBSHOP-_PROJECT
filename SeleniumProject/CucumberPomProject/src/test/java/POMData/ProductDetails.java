package POMData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetails {
	
	WebDriver driver;
	
	public ProductDetails(WebDriver driver) {
		
		this.driver = driver;
	}

	private By addtocartbutton = By.xpath("(//*[@value=\"Add to cart\"])[1]");
	
	private By qtybox= By.name("addtocart_31.EnteredQuantity");
	
	private By comparisonbutton = By.cssSelector("[value=\"Add to compare list\"]");
	
	public void addcart() {
		
		driver.findElement(addtocartbutton).click();
		
	}

}
