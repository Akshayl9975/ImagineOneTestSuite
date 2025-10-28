package pomPackage;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GroupPage {
    public WebDriver driver;

    @FindBy(xpath="//div[@id=\"provisioning-hovered\"]") private WebElement provhover;

    @FindBy(xpath="//div//child::span[text()='Groups']") private WebElement groupsprov;

    @FindBy(xpath="//button//child::span[@class=\"mat-button-wrapper\"]//span[text()=' add ']") private WebElement addgroup;

    @FindBy(xpath="//input[@data-placeholder=\"Enter Group Name\"]") private WebElement groupname;

    @FindBy(xpath="//mat-checkbox//child::span[text()=\"Active\"]") private WebElement groupactivebox;

    @FindBy(xpath="//button//child::span[text()=' exit_to_app ']") private WebElement groupsaveexit;

    @FindBy(xpath="//button//child::span[text()='Save & Add More']") private WebElement groupsaveandadd;

    @FindBy(xpath="//div[@id=\"toast-container\"]//child::div//child::div[@aria-label=\"Group created successfully\"]") private WebElement groupsuccessmsg;

   @FindBy(xpath="//div[@id='toast-container']//div[contains(text(),'Group name first character needs to be in caps')]") private WebElement groupfirstcharerrormsg;

    @FindBy(xpath = "//div[@id='toast-container']//div[contains(text(),'Group name can not contain more than 15 characters')]")private WebElement groupnamelengthexceederrormsg;

    @FindBy(xpath="//div[@id='toast-container']//div[contains(text(),'Group name can')]") private WebElement groupnumbererror;

    @FindBy(xpath="//div[@class=\"canCross\"]//span[text()='Reset']")private WebElement groupresetbutton;

    @FindBy(xpath="//div[@id=\"toast-container\"]//div[text()=' Group name is a required field ']")private WebElement groupreseterrormsg;

    public GroupPage(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }


    public void grouphoveraction(WebDriver driver) {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(provhover));


        Actions actions = new Actions(driver);

        actions.moveToElement(provhover).build().perform();
    }

    public void clickgroups() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(groupsprov));

        groupsprov.click();

        Thread.sleep(3000);

    }

    public void clickaddgroups(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // wait for overlay to disappear

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

        // wait for the button to be clickable
        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait11.until(ExpectedConditions.elementToBeClickable(addgroup));

        Thread.sleep(7000);

        addgroup.click();
    }


    public void addgroupname(String cname) {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(groupname));

        groupname.clear();


        groupname.sendKeys(cname);
    }




    public void groupactive(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-overlay.loading-foreground")));

        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait11.until(ExpectedConditions.elementToBeClickable(groupactivebox));

        groupactivebox.click();


    }



    public void groupclicksave(WebDriver driver) throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(groupsaveexit));


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));

        groupsaveexit.click();
        Thread.sleep(5000);
    }


    public void groupclickaddmore(WebDriver driver) throws InterruptedException {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(groupsaveandadd));

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait3.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));

        groupsaveandadd.click();
        Thread.sleep(5000);
    }

    public void groupclickreset(WebDriver driver) throws InterruptedException {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(groupresetbutton));

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait4.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));

        groupresetbutton.click();
        Thread.sleep(5000);


    }

    public String groupgetSuccessMessage() {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement toast=wait.until(ExpectedConditions.visibilityOf(groupsuccessmsg));
      

        return toast.getText();



    }


    public String getgroupnameerrorMessage() {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement grouperror=wait.until(ExpectedConditions.visibilityOf(groupfirstcharerrormsg));

        return grouperror.getText();
    }

    public String getgrouplengtherrorMessage() {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement lengtherror=wait.until(ExpectedConditions.visibilityOf(groupnamelengthexceederrormsg));

        return lengtherror.getText();
    }

    public String getgroupnumbererrorMessage() {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement numbererror=wait.until(ExpectedConditions.visibilityOf(groupnumbererror));

        return numbererror.getText();
    }


    public String getgroupReseterrorMessage() {


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement groupresetbuttonerror=wait.until(ExpectedConditions.visibilityOf(groupreseterrormsg));

        return groupresetbuttonerror.getText();
    }



    }


