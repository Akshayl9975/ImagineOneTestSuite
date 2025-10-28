package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {

        public WebDriver driver;

        @FindBy(xpath="//div//child::span[text()='User Management']") private WebElement usermgt;

        @FindBy(xpath="//button//child::span[@class=\"mat-button-wrapper\"]//span[text()=' Add User ']") private WebElement adduser;

        @FindBy(xpath="//input[@data-placeholder=\"First Name\"]") private WebElement firstname;

        @FindBy(xpath="//input[@data-placeholder=\"Last Name\"]") private WebElement lastname;

        @FindBy(xpath="//input[@data-placeholder=\"User Name\"]") private WebElement username;

        //@FindBy(xpath="//input[@data-placeholder=\"User Name\"]") private WebElement userrole;

        //@FindBy(xpath="//mat-checkbox//child::span[text()=\"Active\"]") private WebElement userclientaccess;

       @FindBy(xpath="//input[@formcontrolname=\"mobileNumber\"]") private WebElement usermobilenumber;

      @FindBy(xpath="//input[@data-placeholder=\"Email\"]")private WebElement useremail;

      @FindBy(xpath="//input[@data-placeholder=\"Confirm Email\"]")private WebElement userconfirmemail;

        @FindBy(xpath="//button//child::span[text()=' exit_to_app ']") private WebElement usersaveexit;

        @FindBy(xpath="//button//child::span[text()='Save & Add More']") private WebElement usersaveandadd;

        @FindBy(xpath="//div[@class=\"canCross\"]//span[text()='Cancel']")private WebElement usercancelbutton;

        @FindBy(xpath="//div[@id=\"toast-container\"]//child::div//child::div[@aria-label=\"User created successfully\"]") private WebElement usersuccessmsg;



        public UserPage(WebDriver driver)
        {
            this.driver = driver;

            PageFactory.initElements(driver,this);
        }

    public void clickusermgt() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(usermgt));

        usermgt.click();

        Thread.sleep(3000);

    }



        public void clickadduser(WebDriver driver) throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // wait for overlay to disappear

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ngx-overlay.foreground-closing")));

            // wait for the button to be clickable
            WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));

            wait11.until(ExpectedConditions.elementToBeClickable(adduser));

            Thread.sleep(7000);

            adduser.click();
        }


        public void adduserfirstname(String fname) {

            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(firstname));


            firstname.clear();

            firstname.sendKeys(fname);
        }

    public void adduserlastname(String lname) {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lastname));



        lastname.clear();
        lastname.sendKeys(lname);
    }


    public void adduserrole(String role) {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lastname));



        lastname.clear();
        lastname.sendKeys(role);
    }

    public void adduserclientaccess(String access) {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lastname));



        lastname.clear();
        lastname.sendKeys(access);
    }

    public void usermobile(String usrmbl) {

        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait12.until(ExpectedConditions.visibilityOf(usermobilenumber));

        usermobilenumber.clear();

        usermobilenumber.sendKeys(usrmbl);
    }

    public void useremailsend(String usrmail) {


        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait12.until(ExpectedConditions.visibilityOf(useremail));

        useremail.clear();

        useremail.sendKeys(usrmail);


    }
    public void usercnfmemailsend(String usrcmail) {


        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait12.until(ExpectedConditions.visibilityOf(userconfirmemail));

        userconfirmemail.clear();

        userconfirmemail.sendKeys(usrcmail);


    }


    public void userclicksave(WebDriver driver) throws InterruptedException {

            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(usersaveexit));


            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));

            usersaveexit.click();
            Thread.sleep(5000);
        }


        public void userclickaddmore(WebDriver driver) throws InterruptedException {


            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(usersaveandadd));

            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait3.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));

            usersaveandadd.click();
            Thread.sleep(5000);
        }

        public void userclickcancel(WebDriver driver) throws InterruptedException {


            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(usercancelbutton));

            WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait4.until(ExpectedConditions.invisibilityOfElementLocated( By.cssSelector("div.ngx-overlay")));

            usercancelbutton.click();
            Thread.sleep(5000);


        }

        public String usergetSuccessMessage() {


            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
            WebElement toast=wait.until(ExpectedConditions.visibilityOf(usersuccessmsg));


            return toast.getText();



        }




    }




