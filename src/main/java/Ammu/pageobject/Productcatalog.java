package Ammu.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Productcatalog extends AbstractComponent{
	WebDriver driver;
	
	public Productcatalog(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	

		
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");

	public List<WebElement> getProductsList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	public WebElement getProductByName(String item)
	{
		WebElement prod= getProductsList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(item)).findFirst().orElse(null);
		return prod;
	}
	public void addItemToCart(String item)
	{
		WebElement prod=getProductByName(item);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
	
		
		
		
	}
	
	
}
