package Ammu.tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ammu.pageobject.CartPage;
import Ammu.pageobject.CheckoutPage;
import Ammu.pageobject.OrderConfirmation;
import Ammu.pageobject.OrderHistoryPage;
import Ammu.pageobject.Productcatalog;
import Ammu.testComponents.BaseTest;
import Ammu.testComponents.Retry;

public class StandAloneTestFinal extends BaseTest {
		
		String itemToAdd = "zara coat 3";

		@Test(dataProvider = "getData",groups = {"submitOrder"},retryAnalyzer = Retry.class)
		public  void submitOrder(String email, String pwd,String itemToAdd) throws IOException 
		{
		
		String crv ="143";
		String nme ="Zimba";
		String inputCountry="ind";
		String orderSuccessMsg ="THANKYOU FOR THE ORDER.";

		Productcatalog pc =lp.loginApplication(email,pwd);
		@SuppressWarnings("unused")
		List<WebElement> products =pc.getProductsList();
		pc.addItemToCart(itemToAdd);
		CartPage c  = pc.goToCart();
		boolean flag =c.verifyProductDisplay(itemToAdd);
		Assert.assertTrue(flag);
		CheckoutPage ch =c.goToCheckout();
		ch.paymentInfo(crv, nme, inputCountry);
		//String confirmMsg= ch.submitOrder();
	//	Assert.assertTrue(confirmMsg.equalsIgnoreCase(orderSuccessMsg));
		OrderConfirmation oc = ch.submitOrder();
		String msg = oc.getText();
		Assert.assertTrue(msg.equalsIgnoreCase(orderSuccessMsg));
		//oc.getOrderID();
		driver.close();
		
	}
//		@Test(dataProvider = "getData1",groups = {"submitOrder1"})
//		public  void submitOrder1(HashMap<String, String> input) throws IOException 
//		{
//		
//		String crv ="143";
//		String nme ="Zimba";
//		String inputCountry="ind";
//		String orderSuccessMsg ="THANKYOU FOR THE ORDER.";
//
//		Productcatalog pc =lp.loginApplication(input.get("email"),input.get("pwd"));
//		@SuppressWarnings("unused")
//		List<WebElement> products =pc.getProductsList();
//		pc.addItemToCart(input.get("itemtoadd"));
//		CartPage c  = pc.goToCart();
//		boolean flag =c.verifyProductDisplay(input.get("itemtoadd"));
//		Assert.assertTrue(flag);
//		CheckoutPage ch =c.goToCheckout();
//		ch.paymentInfo(crv, nme, inputCountry);
//		String confirmMsg= ch.submitOrder();
//		Assert.assertTrue(confirmMsg.equalsIgnoreCase(orderSuccessMsg));
//		OrderConfirmation oc = new OrderConfirmation(driver);
//		oc.getOrderID();
//		
//		}
		@Test(dependsOnMethods = {"submitOrder"})
		public void verifyOrderHistory()
		{
			lp.loginApplication("zimbacookie@gmail.com","Zoya@123");
			OrderHistoryPage oh=lp.goToOrders();
			boolean val =oh.VerifyOrderDisply(itemToAdd);
			Assert.assertTrue(val);
			
			
		}
		@DataProvider
		public Object[][] getData()
		{
			return new Object[][] {{"zimbacookie@gmail.com","Zoya@123","zara coat 3"},{"zoyamani@gmail.com","Zoya@123","ADIDAS ORIGINAL"}};
		}
//		@DataProvider
//		public Object[][] getData1() throws IOException
//		{
////			HashMap<String, String> map = new HashMap<String,String>();
////			map.put("email", "zimbacookie@gmail.com");
////			map.put("pwd", "Zoya@123");
////			map.put("itemtoadd", "zara coat 3");
////			
////			HashMap<String, String> map1 = new HashMap<String,String>();
////			map1.put("email", "zoyamani@gmail.com");
////			map1.put("pwd", "Zoya@123");
////			map1.put("itemtoadd", "ADIDAS ORIGINAL");
//			List<HashMap<String, String>> data =readjson(System.getProperty("user.dir")+"\\src\\test\\java\\Ammu\\data\\PurchaseOrder.json");
//			
//			return new Object[][] {{data.get(0)},{data.get(1)}};
//		}
		

}
