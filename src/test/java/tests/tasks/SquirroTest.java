package tests.tasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestClass;

public class SquirroTest extends BaseTestClass {



    @Test
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

    @Test
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
        Thread.sleep(2000);
        homePage.enterEmail("test.com");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(2000);
        homePage.enterEmail("test@");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(2000);
        homePage.enterEmail("@test");
        homePage.enterPassword("passtest");
        homePage.enterConfirmPassword("passtest");
        homePage.clickCheckBoxTermsAndCond();
        homePage.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.isInvalidEmailDisplayed());

    }

    @Test
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
            Thread.sleep(2000);
            Assert.assertTrue(homePage.isExistingEmailDisplayed());

    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("passtest");
        homePage.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.isAvatarIconDisplayed());

    }
    @Test
    public void testLoginWithIncorrectPassword() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.enterPassword("testpass");
        homePage.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.isInvalidPasswordMessageDisplayed());

    }
    @Test
    public void verifyForgotPasswordFunctionality() throws InterruptedException {

        HomePage homePage = new HomePage(driver).open();

        homePage.clickOnMyInstances();
        homePage.clickForgotPasswordLink();
        homePage.enterUsername("aleksatest111@gmail.com");
        homePage.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.isForgotPasswordMessageDisplayed());

    }

}
