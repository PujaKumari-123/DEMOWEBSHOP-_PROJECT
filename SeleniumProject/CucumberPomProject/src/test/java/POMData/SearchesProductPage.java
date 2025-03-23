package POMData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchesProductPage {
	
	WebDriver driver;
	
    private By searchedBy=By.xpath("(//*[@class='picture'])");
    
    
    public SearchesProductPage (WebDriver driver) {
		
    	this.driver=driver;
	}
    
    public void searchedproduct() {
    	
        	List<WebElement> product = driver.findElements(searchedBy);

        	if (!product.isEmpty()) {
        		
        		product.get(1).click();
        		
        		System.out.println("Product Found and Clicked on it");
				
			}
        	
        	
        	
				
			
			
		
		
	}
	

}
