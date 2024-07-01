package Ammu.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.By;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
		
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail")); 
	//using PageFactory instead
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	//@FindBy(css="#toast-container")
	//WebElement errorMsg;
	

	
	public void toGo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public Productcatalog loginApplication(String uname, String pass) 
	{
		userEmail.sendKeys(uname);
		pwd.sendKeys(pass);
		loginbtn.click();
		Productcatalog pc = new Productcatalog(driver);
		return pc;
		
		
	}
	public String getErrorMsg()
	{
		return errorMsg.getText();
		
	}

}
