package Ammu.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {
	
	WebDriver driver;
	public OrderConfirmation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(css="#htmlData tr:nth-child(4) table tbody tr:nth-child(3) label")
	//WebElement orderID;
	@FindBy(css=".hero-primary")
	WebElement orderText;
//	public void getOrderID()
//	{
//		String orderId= orderID.getText();
//		String Id =orderId.split(" ")[1];
//		System.out.println("Order ID: "+Id);
//	}
//	
	public String getText() {
		return orderText.getText();
	}
}
