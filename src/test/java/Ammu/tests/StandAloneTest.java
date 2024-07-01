package Ammu.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		String item = "zara coat 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("zimbacookie@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Zoya@123");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod= products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(item)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		String text = driver.findElement(By.cssSelector("#toast-container")).getText();
		System.out.println(text);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Assert.assertEquals(text, "Product Added To Cart");
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean val = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		Assert.assertTrue(val);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input")).sendKeys("143");
		driver.findElement(By.xpath("//div[@class='payment__cc']//div[3]//input")).sendKeys("Zimba");
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> drp = driver.findElements(By.cssSelector(".ta-results button"));
		List<WebElement> opt =drp.stream().filter(s->s.getText().equalsIgnoreCase("india")).collect(Collectors.toList());
		//System.out.println(opt.get(0).getText());
		opt.get(0).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		String orderId= driver.findElement(By.cssSelector("#htmlData tr:nth-child(4) table tbody tr:nth-child(3) label")).getText();
		String Id =orderId.split(" ")[1];
		System.out.println("Order ID"+Id);
		
	}

}
