package tests.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestClass;

public class SquirroTest extends BaseTestClass {



    @Test(priority = 1)
    public void testCreatingAnAccountWithValidInformation() throws InterruptedException {

            HomePage homePage = new HomePage(driver).open();

            homePage.clickOnMyInstances();
            homePage.clickOnSignUpLink();
            homePage.enterFirstName("test");
            homePage.enterLastName("test");
            homePage.enterEmail(homePage.generateRandomEmail());
            homePage.enterPassword("passtest");
            homePage.enterConfirmPassword("passtest");
            homePage.clickCheckBoxTermsAndCond();
            homePage.clickSubmitButton();
            Thread.sleep(2000);
            Assert.assertTrue(homePage.isVerifyDisplayed());

    }
                    //Impossible to do test with email part because gmail secure block automated instances of browsers
//    @Test
//    public void verifyEmailConfirmationProcess() throws InterruptedException {
//
//        HomePage homePage = new HomePage(driver);
//        driver.get("https://www.google.com/intl/en-GB/gmail/about/");
//
//        homePage.clickGmailSignIn();
//        homePage.enterGmail("aleksatest111@gmail.com");
//        homePage.clickNextButton();
//        homePage.enterGmailPassword("exalibur98");
//        homePage.clickNextButton();
//        Thread.sleep(2000);
//    }

    @Test(priority = 2)
    public void testAccountCreationWithInvalidEmailFormats() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.clickOnSignUpLink();
        homePage.enterFirstName("test");
        homePage.enterLastName("test");
        homePage.enterEmail("test");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(1000);
        homePage.enterEmail("test.com");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(1000);
        homePage.enterEmail("test@");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(1000);
        homePage.enterEmail("@test");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isInvalidEmailDisplayed());

    }

    @Test(priority = 3)
    public void attempToCreateDuplicateAccountsWithTheSameEmail() throws InterruptedException {

            HomePage homePage = new HomePage(driver).open();

            homePage.clickOnMyInstances();
            homePage.clickOnSignUpLink();
            homePage.enterFirstName("test");
            homePage.enterLastName("test");
            homePage.enterEmail("aleksatest111@gmail.com");
            homePage.enterPassword("passtest");
            homePage.enterConfirmPassword("passtest");
            homePage.clickCheckBoxTermsAndCond();
            homePage.clickSubmitButton();

            Assert.assertTrue(homePage.isExistingEmailDisplayed());

    }

    @Test(priority = 4)
    public void testLoginWithValidCredentials() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("passtest");
        homePage.clickSubmitButton();
        Assert.assertTrue(homePage.isAvatarIconDisplayed());

    }
    @Test(priority = 5)
    public void testLoginWithIncorrectPassword() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("testpass");
        homePage.clickSubmitButton();
        Assert.assertTrue(homePage.isInvalidPasswordMessageDisplayed());

    }
    @Test(priority = 6)
    public void verifyForgotPasswordFunctionality() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.clickForgotPasswordLink();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.clickSubmitButton();
        Assert.assertTrue(homePage.isForgotPasswordMessageDisplayed());

    }
    //This test fails as it should be because account is never locked and we dont get different message
    @Test(priority = 7)
    public void testAccountLockoutAfterMultipleFailedAttempts() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("testpass");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass1");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass2");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass3");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass4");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass5");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass6");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass7");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass8");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass9");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass10");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass11");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass12");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass13");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass14");
        homePage.clickSubmitButton();
        homePage.enterPassword("testpass15");
        homePage.clickSubmitButton();
        Assert.assertFalse(homePage.isInvalidPasswordMessageDisplayed());

    }

    @Test(priority = 8)
    public void userManagement() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        //Test adding new users to the instance.
        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("passtest");
        homePage.clickSubmitButton();
        homePage.clickOnAdminInstances();
        homePage.clickOnInviteUsersButton();
        homePage.enterEmail("test@test.com");
        homePage.selectUserRole("Users");
        homePage.clickOnSendInviteButton();
        //Verify role assignment and permissions.
        homePage.verifyUserRole("Users");
        //Test user removal process.
        homePage.clickOnRemoveButton();
        homePage.clickConfirmRemoveButton();

        Assert.assertFalse(homePage.isUserPresent("test@test.com"));

    }


//Performance


    @Test(priority = 9)
    public void measureLoadTimesForKeyPages() throws InterruptedException {


        // Beginning calculating time
        long startTimeOfHomePage = System.currentTimeMillis();
        HomePage homePage = new HomePage(driver).open();
        // End calculating time
        long endTimeOfHomePage = System.currentTimeMillis();
        driver.quit();
        // Time loading page
        long loadTimeOfHomePage = endTimeOfHomePage - startTimeOfHomePage;
        System.out.println("Time loading page: " + loadTimeOfHomePage + " milliseconds");

        // Beginning calculating time
        long startTimeOfLoginPage = System.currentTimeMillis();
        driver = setUpDriver();
        HomePage homePages = new HomePage(driver).open();
        homePages.clickOnMyInstances();
        homePages.enterUsername("aleksatest111@gmail.com");
        homePages.enterPassword("passtest");
        homePages.clickSubmitButton();
        Assert.assertTrue(homePages.isAvatarIconDisplayed());
        // End calculating time
        long endTimeOfLoginPage = System.currentTimeMillis();
        driver.quit();
        // Time loading page
        long loadTimeOfLoginPage = endTimeOfLoginPage - startTimeOfLoginPage;
        System.out.println("Time loading page: " + loadTimeOfLoginPage + " milliseconds");


//         Beginning calculating time
        long startTimeOfSignUp = System.currentTimeMillis();
        driver = setUpDriver();
        HomePage homePagee = new HomePage(driver).open();
        homePagee.clickOnMyInstances();
        homePagee.clickOnSignUpLink();
        homePagee.enterFirstName("test");
        homePagee.enterLastName("test");
        homePagee.enterEmail(homePagee.generateRandomEmail());
        homePagee.enterPassword("passtest");
        homePagee.enterConfirmPassword("passtest");
        homePagee.clickCheckBoxTermsAndCond();
        homePagee.clickSubmitButton();
        Assert.assertTrue(homePagee.isVerifyDisplayed());
        // End calculating time
        long endTimeOfSignUp = System.currentTimeMillis();
        // Time loading page
        long loadTimeOfSignUp = endTimeOfSignUp - startTimeOfSignUp;
        System.out.println("Time loading page: " + loadTimeOfSignUp + " milliseconds");


    }
    @Test(priority = 10)
    public void verifySearchFunctionalityPerformanceWithLargeDatasets() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("passtest");
        homePage.clickSubmitButton();
        Assert.assertTrue(homePage.isAvatarIconDisplayed());
        homePage.clickOnInstanceLink("aleksatest");
        homePage.clickCloseDialogButton();
        homePage.enterTextInAskField("test");
        // Start calculating time
        long startTime = System.currentTimeMillis();
        homePage.clickSendButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        // End calculating time
        long endTime = System.currentTimeMillis();
//
//        // Search time
        long searchTime = endTime - startTime;
//
        System.out.println("Search time: " + searchTime + " milliseconds");
    }


}
