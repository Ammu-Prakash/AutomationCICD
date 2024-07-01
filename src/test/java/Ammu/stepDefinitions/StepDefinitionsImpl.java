package Ammu.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Ammu.pageobject.CartPage;
import Ammu.pageobject.CheckoutPage;
import Ammu.pageobject.LandingPage;
import Ammu.pageobject.OrderConfirmation;
import Ammu.pageobject.Productcatalog;
import Ammu.testComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImpl extends BaseTest{
	
	public LandingPage lp;
	public Productcatalog pc;
	public OrderConfirmation oc;
	public CheckoutPage ch;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException
	{
		lp =launchApplication();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password)
	{
		 pc =lp.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_cart(String productName)
	{
		List<WebElement> products =pc.getProductsList();
		pc.addItemToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_product_and_submit_order(String productName)
	{
		CartPage c  = pc.goToCart();
		boolean flag =c.verifyProductDisplay(productName);
		Assert.assertTrue(flag);
		ch =c.goToCheckout();
		ch.paymentInfo("413", "ammu", "ind");
		 oc = ch.submitOrder();
	}

	 @Then("{string} message is displayed on Confirmation Page")
	 public void message_displayed_in_confirmationpage(String string)
	 {
		
		 String msg = oc.getText();
		 Assert.assertTrue(msg.equalsIgnoreCase(string));
		 driver.close();
	 }
	 @Then("{string} message is displayed")
	 public void message_displayed(String string)
	 {
		
		 Assert.assertEquals(string, lp.getErrorMsg());
		 driver.close();
	 }

}
