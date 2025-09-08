package pomPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;

	@FindBy(xpath="//input[@formcontrolname=\"username\"]") private WebElement id;
	@FindBy(xpath="//input[@formcontrolname=\"password\"]") private WebElement password;
	@FindBy(xpath="//button[contains(@class,\"login-btn\")]") private WebElement enter;
	
	
	public LoginPage(WebDriver driver)
	{
	    this.driver = driver;  

		PageFactory.initElements(driver,this);
	}
	
	
	public void enterId(String userid) 
	{
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOf(id));
		
		id.sendKeys(userid);
	}
	
	public void  enterPassword(String userpassword) 
	{
		password.sendKeys(userpassword);
	}
	
	public void clickEnter() 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(enter));
		
		enter.click();
	}
	
	
}
