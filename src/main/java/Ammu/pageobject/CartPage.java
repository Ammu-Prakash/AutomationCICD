package Ammu.pageobject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	public boolean verifyProductDisplay(String item)
	{
		boolean match= cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return match;
	}

	public CheckoutPage goToCheckout()
	{
		checkoutBtn.click();
		CheckoutPage ch = new CheckoutPage(driver);
		return ch;
	}
}
