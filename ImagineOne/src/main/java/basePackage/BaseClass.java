package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {

	
	public WebDriver driver;
	 
	 
	@BeforeMethod
	public void setUp() {
	driver=new ChromeDriver();
	driver.get("https://6tfsm5sgai.us-east-1.awsapprunner.com/login");
	driver.manage().window().maximize();
	
	}
	
	@AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
