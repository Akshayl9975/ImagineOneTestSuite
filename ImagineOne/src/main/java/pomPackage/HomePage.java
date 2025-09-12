package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriver driver;

	@FindBy(xpath="//div[@id=\"provisioning-hovered\"]") private WebElement hover;
	
	@FindBy(xpath="//div//child::span[text()='Client Provisioning']") private WebElement clientprov;
	
	@FindBy(xpath="//button//child::span[@class=\"mat-button-wrapper\"]//span[text()=' add ']") private WebElement addclient;
	
	@FindBy(xpath="//input[@data-placeholder=\"Client Name\"]") private WebElement clientname;
	
	@FindBy(xpath="//input[@data-placeholder=\"Short Name\"]") private WebElement shortname;
	
	@FindBy(xpath="//span[text()=\"Co-Pilot Enabled\"]") private WebElement Copilotbox;
	
	@FindBy(xpath="//*[@id='mat-checkbox-2']") private WebElement activebox;
	
	@FindBy(xpath="//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"clientContactName\"]")private WebElement clientcname;
	
	@FindBy(xpath="//input[@data-placeholder=\"Client Email\"]")private WebElement clientemail;
	
	@FindBy(xpath="//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"clientContactPhone\"]")private WebElement clientcphone;
	
	@FindBy(xpath="//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"imagineContactName\"]")private WebElement imaginecname;
	
	@FindBy(xpath="//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"imagineContactEmail\"]")private WebElement imaginecemail;
	
	@FindBy(xpath="//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"imagineContactPhone\"]")private WebElement imaginecphone;
	
	@FindBy(xpath="//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"subscriptionFee\"]")private WebElement sfees;
	
	@FindBy(xpath="//button//child::span[text()=' exit_to_app ']") private WebElement saveexit;
	
	@FindBy(xpath="//button//child::span[text()='Save & Add More']") private WebElement saveandadd;
	
	@FindBy(xpath="//div[@id=\"toast-container\"]//child::div[@aria-label=\"Client created Successfully\"]") private WebElement successmsg;


	
	

	
	public HomePage(WebDriver driver)
	{
	    this.driver = driver;  

		PageFactory.initElements(driver,this);
	}
	
	
	public void hoveraction(WebDriver driver) {
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hover));
		
		
		Actions actions = new Actions(driver);
 
		actions.moveToElement(hover).build().perform();
	}

	public void clickclient() {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(clientprov));
		
		clientprov.click();
		
	}

	public void clickaddclient(WebDriver driver) throws InterruptedException {
		
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
		// wait for overlay to disappear
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));
 
		// wait for the button to be clickable
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		wait1.until(ExpectedConditions.elementToBeClickable(addclient)); 
		
		Thread.sleep(7000);
		
		addclient.click();
	}
	
	
	public void addclientname(String cname) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(clientname));
		
		clientname.clear();

		
		clientname.sendKeys(cname);
	}

	
	public void addshortname(String sname) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(shortname));
		
	    shortname.clear();

		shortname.sendKeys(sname);
	}
	
	public void copilot(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-overlay.loading-foreground")));

		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait11.until(ExpectedConditions.elementToBeClickable(Copilotbox));

		Copilotbox.click();
	}
	
	public void active(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-overlay.loading-foreground")));

		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait12.until(ExpectedConditions.elementToBeClickable(activebox));
		
		activebox.click();
	}
	
	public void clientcontactname (String clcname){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
			// wait for overlay to disappear
			
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));
	 
			
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait12.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,\"mat-form-field-flex ng-tns-c70\")]//child::input[@formcontrolname=\"clientContactName\"]")));
		
		clientcname.clear();

		clientcname.sendKeys(clcname);
		
	}
	
	
	public void clientemailsend(String clemail) {
		
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(clientemail));
		
		clientemail.clear();
		
		clientemail.sendKeys(clemail);
		
		
	}
	
	
	public void clientcphonesend(String clcphone) {
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(clientcphone));
		
		clientcphone.clear();
		
		clientcphone.sendKeys(clcphone);
	}
	
	
	public void imaginecnamesend(String icname) {
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(imaginecname));
		
		imaginecname.clear();
		
		imaginecname.sendKeys(icname);
		
		
	}
	
	
	
   public void imaginecemailsend(String icemail) {
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(imaginecemail));
		
		imaginecemail.clear();
		
		imaginecemail.sendKeys(icemail);
	}
	
   
   public void imaginecphonesend(String icphone) {
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(imaginecphone));
		
		imaginecphone.clear();
		
		imaginecphone.sendKeys(icphone);
	}
   
   
   public void subscriptionfee(String subfee) {
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.visibilityOf(sfees));
		
		sfees.clear();
		
		sfees.sendKeys(subfee);
	}
   
   
	public void clicksave(WebDriver driver) throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(saveexit));
		

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));
		
		saveexit.click();
		Thread.sleep(5000);
	}
	
	
	public void clickaddmore(WebDriver driver) throws InterruptedException {
		

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(saveandadd));
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));
		
		saveandadd.click();
		Thread.sleep(5000);
	}
	
	 public String getSuccessMessage() {
	       
		 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement toast=wait.until(ExpectedConditions.visibilityOf(successmsg));
		
		  return toast.getText();
	    }
}
