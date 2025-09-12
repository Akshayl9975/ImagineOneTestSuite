package testPackage;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.HomePage;
import pomPackage.LoginPage;

public class LoginTest extends BaseClass{
	
	


	@Test(priority=1)
    public void verifyLogin() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        
        login.enterId("alavate");
        login.enterPassword("Testing@123");
        login.clickEnter();
       
     //avoid duplication of client name
        
        Random r = new Random();
        int randomNum = r.nextInt(10000);  
        

        String uniqueClientName = "Client" + randomNum;
        String uniqueShortName = "CL" + randomNum;
        
    
        HomePage home=new HomePage(driver);
    
    	
    	
    	 home.hoveraction(driver);
    	 home.clickclient();
    	 home.clickaddclient(driver);
    	 
    	 
    	 home.addclientname(uniqueClientName);
    	 home.addshortname(uniqueShortName);
    	 home.copilot(driver);
    	 home.active(driver);
    	 home.clientcontactname("akshaytest");
    	 home.clientemailsend("test@qa.com");
    	 home.clientcphonesend("2012220000");
    	 home.imaginecnamesend("iclient");
    	 home.imaginecemailsend("testimagine@test.com");
    	 home.imaginecphonesend("2012220101");
    	 home.subscriptionfee("2000");
    	 
    	 home.clicksave(driver);
    	 
    	String successMsg = home.getSuccessMessage();
         Assert.assertTrue(successMsg.contains("Client created Successfully"),
                 "Expected success message not found. Actual: " + successMsg);
         
          }

	
	@Test(priority=2)
	 public void clickandaddmore() throws InterruptedException {
	        LoginPage login = new LoginPage(driver);
	        
	        login.enterId("alavate");
	        login.enterPassword("Testing@123");
	        login.clickEnter();
	        
	        
	        HomePage home=new HomePage(driver);
	        
	        home.hoveraction(driver);
	        home.clickclient();
	    	home.clickaddclient(driver);
	       
	     //avoid duplication of client name
	        
	        Random r2 = new Random();

	        // Loop to create 5 clients
	        for (int i = 1; i <= 3; i++) {
	            int randomNum1 = r2.nextInt(10000);
	            
	            String uniqueClientNamemore = "Client" + randomNum1;
	            String uniqueShortNamemore = "CL" + randomNum1;

	            
	           
	            
	            home.addclientname(uniqueClientNamemore);
	            home.addshortname(uniqueShortNamemore);
	            
	            
		    	home.copilot(driver);
		    	home.active(driver);
		    	home.clientcontactname("akshaytest");
		    	home.clientemailsend("test@qa.com");
		    	home.clientcphonesend("2012220000");
		    	home.imaginecnamesend("iclient");
		    	home.imaginecemailsend("testimagine@test.com");
		    	home.imaginecphonesend("2012220101");
		    	home.subscriptionfee("2000");

	            if (i < 3) {
	                // For first 2, click Save & Add More (stay on form)
	                home.clickaddmore(driver);
	            } else {
	                // For the last one, click Save & Exit (finish)
	                home.clicksave(driver);
	            }
	    
	    	
	    	
	    	
	    	 
	    	String successMsg = home.getSuccessMessage();
	         Assert.assertTrue(successMsg.contains("Client created Successfully"),
	                 "Expected success message not found. Actual: " + successMsg);
	     }
}
	}
