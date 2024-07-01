package Ammu.tests;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ammu.pageobject.CartPage;
import Ammu.pageobject.Productcatalog;
import Ammu.testComponents.BaseTest;
import Ammu.testComponents.Retry;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups = {"ErrorValidations"},retryAnalyzer = Retry.class)
	public void loginErroValidation()
	{
		lp.loginApplication("zimbacookie@gmail.com","Zoyasw@123");
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg());
	
	}
	@Test(retryAnalyzer = Retry.class)
	public  void productErrorValidation() throws IOException, InterruptedException 
	{
	String itemToAdd = "zara coat 3";
	Productcatalog pc =lp.loginApplication("zoyamani@gmail.com","Zoya@123");
	@SuppressWarnings("unused")
	List<WebElement> products =pc.getProductsList();
	pc.addItemToCart(itemToAdd);
	Thread.sleep(3000);
	CartPage c  = pc.goToCart();
	boolean flag =c.verifyProductDisplay("zara coat2");
	Assert.assertFalse(flag);
	}

}
