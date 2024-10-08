package tests.tasks;

import org.testng.Assert;
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
            Thread.sleep(1000);
            Assert.assertTrue(homePage.isExistingEmailDisplayed());

    }

    @Test(priority = 4)
    public void testLoginWithValidCredentials() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("passtest");
        homePage.clickSubmitButton();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isAvatarIconDisplayed());

    }
    @Test(priority = 5)
    public void testLoginWithIncorrectPassword() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("testpass");
        homePage.clickSubmitButton();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isInvalidPasswordMessageDisplayed());

    }
    @Test(priority = 6)
    public void verifyForgotPasswordFunctionality() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.clickForgotPasswordLink();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.clickSubmitButton();
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        Assert.assertFalse(homePage.isInvalidPasswordMessageDisplayed());

    }

}
