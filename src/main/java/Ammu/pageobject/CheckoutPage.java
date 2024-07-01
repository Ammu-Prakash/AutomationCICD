package Ammu.pageobject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//div[@class='payment__cc']//div[2]//input")
	WebElement crv;
	@FindBy(xpath="//div[@class='payment__cc']//div[3]//input")
	WebElement nme;
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".ta-results button")
	List<WebElement> countryList;
	@FindBy(css=".action__submit")
	WebElement submitBtn;
//	@FindBy(css=".hero-primary")
//	WebElement orderText;
	public void paymentInfo(String pin, String name, String cntry)
	{
		crv.sendKeys(pin);
		nme.sendKeys(name);
		country.sendKeys(cntry);
		List<WebElement> opt=countryList.stream().filter(s->s.getText().equalsIgnoreCase("india")).collect(Collectors.toList());
		opt.get(0).click();
		
	}
	public OrderConfirmation submitOrder()
	{
		submitBtn.click();
		//String confirmMsg =orderText.getText();
		return new OrderConfirmation(driver);
		
		
		
	}
	
}
