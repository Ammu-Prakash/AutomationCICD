package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ammu.pageobject.CartPage;
import Ammu.pageobject.OrderHistoryPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartIcon;
	@FindBy(css="[routerlink*='myorders']")
	WebElement myOrders;
	
	
	By cart = By.cssSelector("[routerlink*='cart']");
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(WebElement element)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	public CartPage goToCart()
	{
		waitForElementToAppear(cart);
		cartIcon.click();
		CartPage c = new CartPage(driver);
		return c;
	}
	public OrderHistoryPage goToOrders()
	{
		myOrders.click();
		OrderHistoryPage oh = new OrderHistoryPage(driver);
		return oh;
	}
	

}
