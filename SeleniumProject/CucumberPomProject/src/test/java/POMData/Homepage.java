package POMData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
    WebDriver driver;

    private By registerbutton= By.linkText("Register");

    private By loginbutton= By.linkText("Log in");

   private By Shoppingcartbutton= By.linkText("Shopping cart");

   private By wishlistbutton = By.linkText("Wishlist");
   
   private By searchbutton = By.cssSelector("[value='Search store']");
   
   private By books= By.linkText("Books");
   
   private By computers =By.linkText("Computers");
   
   private By electronics=By.linkText("Electronics");
   
   private By viewallbutton =By.linkText("View all");
   
   
   
   
    // Constructor
    public Homepage(WebDriver driver) {
    	
        this.driver = driver;
    }

    //Methods
    
    public void registeringpage() {
    	
    	driver.findElement(registerbutton).click();
		
	}
    
    public void loginpage() {
    	
    	driver.findElement(loginbutton).click();
		
	}
    
    public void shoppingpage() {
    	
    	driver.findElement(Shoppingcartbutton).click();
    	
	}
    
    public void wish() {
    	
    	driver.findElement(wishlistbutton).click();
    	
	}
    
    
    public void search() {
    	
    	driver.findElement(searchbutton).click();
		
	}
    
    public void searchinvalid(String invalidsearch1,String invalidsearch2) {
		
    	driver.findElement(searchbutton).sendKeys(invalidsearch1);
    	
    	driver.findElement(searchbutton).clear();
    	
    	WebElement searchclear= driver.findElement(searchbutton);
    	
    	searchclear.sendKeys(Keys.CONTROL+"a");
    	
    	searchclear.sendKeys(Keys.DELETE);
    	
    	driver.findElement(searchbutton).sendKeys(invalidsearch2);

        searchclear.sendKeys(Keys.CONTROL+"a");
    	
    	searchclear.sendKeys(Keys.DELETE);
    	
    	
	}
    
    public void searchdata(String data) {
    	
    	driver.findElement(searchbutton).sendKeys(data);
		
	}
    
    public void book() throws InterruptedException {
    	
    	driver.findElement(books).click();
    	
    	Thread.sleep(2000);
    	
    	driver.navigate().back();
	}
    
public void computer() throws InterruptedException {
    	
    	driver.findElement(computers).click();
    	
    	Thread.sleep(2000);
    	
    	driver.navigate().back();
	}

public void electrics() throws InterruptedException {
	
	driver.findElement(electronics).click();
	
	Thread.sleep(2000);
	
	driver.navigate().back();
}


public void viewall() throws InterruptedException {
	
	driver.findElement(viewallbutton).click();
	
	Thread.sleep(2000);
	
} 
    
   
    
    
    
    
    
}
