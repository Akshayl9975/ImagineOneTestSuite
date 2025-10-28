package testPackage;


import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.GroupPage;
import pomPackage.LoginPage;
import pomPackage.HomePage;

public class GroupTest extends BaseClass{
    @Test(enabled = false)
    public void verifyLogin() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();

        //avoid duplication of group name

        Random r = new Random();

        // Generate random 4-letter string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        String randomChars = sb.toString();

        // Create unique client name
        String uniqueGroupName = "Group" + randomChars;




        GroupPage group=new GroupPage(driver);



        group.grouphoveraction(driver);
        group.clickgroups();
        group.clickaddgroups(driver);
        group.addgroupname(uniqueGroupName);
        group.groupactive(driver);
        group.groupclicksave(driver);

        String successMsg = group.groupgetSuccessMessage();
        Assert.assertTrue(successMsg.contains("Group created successfully"),
                "Expected success message not found. Actual: " + successMsg);

    }


    @Test(enabled = false)
    public void groupclickandaddmore() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();


        GroupPage group=new GroupPage(driver);


        group.grouphoveraction(driver);
        group.clickgroups();
        group.clickaddgroups(driver);


        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] groupNames = new String[3]; // store unique names

        for (int i = 0; i < 3; i++) {
            String groupName;
            boolean isDuplicate;

            do {
                // Generate 4-letter random string
                StringBuilder sb = new StringBuilder(4);
                for (int j = 0; j < 4; j++) {
                    sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
                }
                groupName = sb.toString();

                // Check if this name is already used
                isDuplicate = false;
                for (int k = 0; k < i; k++) {
                    if (groupNames[k].equals(groupName)) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            groupNames[i] = groupName; // save the unique name
            System.out.println("Group" + groupName);




            group.addgroupname(groupNames[i]);
            group.groupactive(driver);



            if (i < 3) {
                // For first 2, click Save & Add More (stay on form)

                group.groupclickaddmore(driver);


            } else {
                // For the last one, click Save & Exit (finish)
                group.groupclicksave(driver);
            }



            String successMsg = group.groupgetSuccessMessage();

            Assert.assertTrue(successMsg.contains("created successfully"),
                    "Expected success message not found. Actual: " + successMsg);


        }

    }
    @Test(enabled = false)
    public void groupresetoption() throws InterruptedException {

        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();

        //avoid duplication of group name

        Random r = new Random();

        // Generate random 4-letter string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        String randomChars = sb.toString();

        // Create unique client name
        String uniqueGroupName = "Group" + randomChars;




        GroupPage group=new GroupPage(driver);



        group.grouphoveraction(driver);
        group.clickgroups();
        group.clickaddgroups(driver);
        group.addgroupname(uniqueGroupName);
        group.groupactive(driver);


        group.groupclickreset(driver);
        group.groupclicksave(driver);

        String reset=group.getgroupReseterrorMessage();
        Assert.assertEquals(reset,"Group name is a required field","Error msg do not match");
    }


    @Test(enabled = false)
    public void groupnamelengthvalidation() throws InterruptedException {


        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();

        //avoid duplication of group name

        Random r = new Random();

        // Generate random 4-letter string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        String randomChars = sb.toString();

        // Create unique client name
        String uniqueGroupName = "Group" + randomChars;




        GroupPage group=new GroupPage(driver);



        group.grouphoveraction(driver);
        group.clickgroups();
        group.clickaddgroups(driver);
        group.addgroupname(uniqueGroupName +"testing");
        group.groupactive(driver);
        group.groupclicksave(driver);



        // Assert the error messages

        String groupnamelengtherror= group.getgrouplengtherrorMessage();

        Assert.assertTrue(groupnamelengtherror.contains("Group name can not contain more than 15 characters"),"Expected success message not found. Actual: " + groupnamelengtherror);



    }

    @Test(enabled = false)
    public void groupnamevalidation() throws InterruptedException {


        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();

        //avoid duplication of group name

        Random r = new Random();

        // Generate random 4-letter string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        String randomChars = sb.toString();

        // Create unique client name
        String uniqueGroupName = "group" + randomChars;




        GroupPage group=new GroupPage(driver);



        group.grouphoveraction(driver);
        group.clickgroups();
        group.clickaddgroups(driver);
        group.addgroupname("g" + uniqueGroupName);
        group.groupactive(driver);
        group.groupclicksave(driver);



        // Assert the error messages

        String groupnameerror= group.getgroupnameerrorMessage();

        Assert.assertTrue(groupnameerror.contains("Group name first character needs to be in caps"),"Expected success message not found. Actual: " + groupnameerror);


    }


    @Test
    public void groupnamenumbervalidation() throws InterruptedException {


        LoginPage login = new LoginPage(driver);

        login.enterId("sugandha");
        login.enterPassword("Sugandhaqa@123");
        login.clickEnter();

        //avoid duplication of group name

        Random r = new Random();

        // Generate random 4-letter string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        String randomChars = sb.toString();

        // Create unique client name
        String uniqueGroupName = "Group" + randomChars;




        GroupPage group=new GroupPage(driver);



        group.grouphoveraction(driver);
        group.clickgroups();
        group.clickaddgroups(driver);
        group.addgroupname(uniqueGroupName + "1" );
        group.groupactive(driver);
        group.groupclicksave(driver);



        // Assert the error messages

        String groupnamenumbererror= group.getgroupnumbererrorMessage();

        Assert.assertTrue(groupnamenumbererror.contains("Group name can only contain alphabets"),"Expected success message not found. Actual: " + groupnamenumbererror);


    }

}
