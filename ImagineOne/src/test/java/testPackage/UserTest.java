package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pomPackage.GroupPage;
import pomPackage.LoginPage;

import java.util.Random;

public class UserTest {

    @Test(enabled = false)
    public void verifyLogin() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();

        //avoid duplication of user first name

        Random r = new Random();

        // Generate random 4-letter string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        String randomChars = sb.toString();

        // Create unique user first name
        String uniqueFirstName = randomChars + "FirstNameTest" ;




        UserPage user=new UserPage(driver);



        user.usermgt(driver);
        user.adduser(driver);
        user.firstname(uniqueFirstName);
        user.lastname("Singh");
        user.adduserrole(driver);
        user.usermobilenumber("8090349020");
        user.useremail("sugandha@mindwisetech.com");
        user.userconfirmemail("sugandha@mindwisetech.com");
        user.groupclicksave(driver);

        String successMsg = user.usergetSuccessMessage();
        Assert.assertTrue(successMsg.contains("User created successfully"),
                "Expected success message not found. Actual: " + successMsg);

    }


    @Test(enabled = false)
    public void groupclickandaddmore() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();


        UserPage user=new UserPage(driver);


        user.usermgt(driver);
        user.adduser(driver);


        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] firstNames = new String[3]; // store unique names

        for (int i = 0; i < 3; i++) {
            String firstName;
            boolean isDuplicate;

            do {
                // Generate 4-letter random string
                StringBuilder sb = new StringBuilder(4);
                for (int j = 0; j < 4; j++) {
                    sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
                }
                firstName = sb.toString();

                // Check if this name is already used
                isDuplicate = false;
                for (int k = 0; k < i; k++) {
                    if (firstNames[k].equals(firstName)) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            firstNames[i] = firstName; // save the unique name
            System.out.println(firstName+"usertest");




            user.firstname(firstNames[i]);


            user.lastname("Singh");
            user.adduserrole(driver);
            user.usermobilenumber("8090349020");
            user.useremail("sugandha@mindwisetech.com");
            user.userconfirmemail("sugandha@mindwisetech.com");




            if (i < 3) {
                // For first 2, click Save & Add More (stay on form)

                user.userclickaddmore(driver);


            } else {
                // For the last one, click Save & Exit (finish)
                user.userclicksave(driver);
            }



            String successMsg = user.usergetSuccessMessage();

            Assert.assertTrue(successMsg.contains("created successfully"),
                    "Expected success message not found. Actual: " + successMsg);


        }

    }
}
