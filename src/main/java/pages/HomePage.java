package pages;

import data.Time;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.PropertiesUtils;

import java.util.ArrayList;
import java.util.Random;


public class HomePage extends CommonLoggedOutPage {

    private final String LOGIN_PAGE_URL = PropertiesUtils.getBaseUrl();

    //Account creation
    private static final By myInstances = By.xpath("//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-disableElevation']");
    private static final By signUpLink = By.xpath("//a[contains(@href, '/auth/realms/Squirro/login-actions/registration?client_id=start.squirro.com')]");
    private static final By firstNameField = By.xpath("//input[@name='firstName']");
    private static final By lastNameField = By.xpath("//input[@name='lastName']");
    private static final By emailField = By.xpath("//input[@name='email']");
    private static final By passwordField = By.xpath("//input[@name='password']");
    private static final By confirmPasswordField = By.xpath("//input[@name='password-confirm']");
    private static final By checkboxTermsAndConditions = By.xpath("//input[@name='user.attributes.terms_and_conditions']");
    private static final By submitButton = By.xpath("//button[@type='submit']");
    private static final By verifyTextMessage = By.xpath("//div[text()='You need to verify your email address to activate your account.']");
    private static final By invalidEmailMessage = By.xpath("//span[text()='Invalid email address.']");
    private static final By existingEmailMessage = By.xpath("//span[text()='Email already exists.']");


    private static final By gmailSignIn = By.xpath("//a[@data-action='sign in']");
    private static final By gmailField = By.xpath("//input[@type='email']");
    private static final By nextButton = By.xpath("//span[text()='Next']");
    private static final By gmailPasswordField = By.xpath("//input[@type='password']");
    private static final By verifyEmail = By.xpath("//span[contains(text(), 'Please confirm your email address to activate your Squirro ID account.')]");

    //Login
    private static final By avatarIcon = By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular jss6 MuiAvatar-colorDefault']");
    private static final By usernameField = By.xpath("//input[@name='username']");
    private static final By invalidPasswordMessage = By.xpath("//span[text()='Invalid username or password.']");
    private static final By forgotPasswordLink = By.xpath("//a[contains(@href, '/auth/realms/Squirro/login-actions/reset-credentials')]");
    private static final By forgotPasswordMessage = By.xpath("//span[text()='You should receive an email shortly with further instructions.']");

    //User Management
    private static final By instancesPage = By.xpath("//a[@href='/admin/instances']");
    private static final By adminInstances = By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiButtonBase-root MuiIconButton-root jss36 MuiTypography-colorPrimary']");
    private static final By inviteUsersButton = By.xpath("//span[text()='Invite Users']");
    private static final By selectRole = By.xpath("//div[@class= 'MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']");
    private static final By sendInviteButton = By.xpath("//span[text()='Send Invite']");
    private static final By userRole = By.xpath("//td[text()='test@test.com']");
    private static final By removeButton = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text jss28 MuiButton-disableElevation']");
    private static final By confirmRemoveButton = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-disableElevation']");

    //Performance
    private static final By askField = By.xpath("//textarea[@placeholder='Ask me anything']");
    private static final By sendButton = By.xpath("//button[@aria-label='Send']");
    private static final By closeDialogButton = By.xpath("//button[text()='Close']");
    private static Random random = new Random();

    public static String generateRandomEmail() {
        String[] names = {"john", "alice", "peter", "maria", "jane"};
        int number = random.nextInt(1000); // Random number
        String name = names[random.nextInt(names.length)];
        return name + number + "@example.com";
    }




    public HomePage(WebDriver driver) {
        super(driver);
        log.trace("new LoginPage()");
    }

    public HomePage open(boolean bVerify) {
        openUrl(LOGIN_PAGE_URL);
        log.debug("Open LoginPage(" + LOGIN_PAGE_URL + ")");
        if(bVerify) {
            verifyLoginPage();
        }
        return this;
    }

    public HomePage open() {
        return open(true);
    }

    public void verifyLoginPage() {
        log.debug("verifyLoginPage()");
        waitForExactUrl(LOGIN_PAGE_URL, Time.TIME_SHORT);
        waitUntilPageIsReady(Time.TIME_MEDIUM);
    }

    public void clickOnMyInstances() {
        waitUntilElementIsVisible(driver, myInstances, 10);
        WebElement element = getWebElement(myInstances);
        element.click();
    }
    public void clickOnSignUpLink() {
        waitUntilElementIsVisible(driver, signUpLink, 10);
        WebElement element = getWebElement(signUpLink);
        element.click();
    }
    public void enterFirstName(String string) {
        waitUntilElementIsVisible(driver, firstNameField, 10);
        WebElement element = getWebElement(firstNameField);
        element.clear();
        element.sendKeys(string);
    }
    public void enterLastName(String string) {
        waitUntilElementIsVisible(driver, lastNameField, 10);
        WebElement element = getWebElement(lastNameField);
        element.clear();
        element.sendKeys(string);
    }
    public void enterEmail(String string) {
//        waitUntilElementIsVisible(driver, emailField, 10);
        WebElement element = getWebElement(emailField);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(string);
    }

    public void enterPassword(String string) {
        waitUntilElementIsVisible(driver, passwordField, 10);
        WebElement element = getWebElement(passwordField);
        element.clear();
        element.sendKeys(string);
    }
    public void enterConfirmPassword(String string)
    {
        waitUntilElementIsVisible(driver, confirmPasswordField, 10);
        WebElement element = getWebElement(confirmPasswordField);
        element.clear();
        element.sendKeys(string);
    }

    public void clickCheckBoxTermsAndCond()
    {
        WebElement element = getWebElement(checkboxTermsAndConditions);
        element.click();
    }
    public void clickSubmitButton()
    {
        waitUntilElementIsVisible(driver, submitButton, 10);
        WebElement element = getWebElement(submitButton);
        element.click();
    }
    public void enterUsername(String string)
    {
        waitUntilElementIsVisible(driver, usernameField, 10);
        WebElement element = getWebElement(usernameField);
        element.clear();
        element.sendKeys(string);
    }
    public void clickForgotPasswordLink()
    {
        waitUntilElementIsVisible(driver, forgotPasswordLink, 10);
        WebElement element = getWebElement(forgotPasswordLink);
        element.click();
    }
    public void clickOnAdminInstances()
    {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://start.squirro.com/admin/instances";
        if (actualUrl.contains(expectedUrl))
        {
            waitUntilElementIsVisible(driver, adminInstances, 10);
            WebElement element = getWebElement(adminInstances);
            element.click();

        }
        else {
            waitUntilElementIsVisible(driver, instancesPage, 10);
            WebElement element = getWebElement(instancesPage);
            element.click();
            waitUntilElementIsVisible(driver, adminInstances, 10);
            WebElement element2 = getWebElement(adminInstances);
            element2.click();
        }
    }
    public void clickOnInviteUsersButton()
    {
        waitUntilElementIsVisible(driver, inviteUsersButton, 10);
        WebElement element = getWebElement(inviteUsersButton);
        element.click();
    }
    public void selectUserRole(String string)
    {
        waitUntilElementIsVisible(driver, selectRole, 10);
        WebElement element = getWebElement(selectRole);
        element.click();
        waitUntilElementIsVisible(driver, selectRole, 10);
        WebElement element2 = getWebElement(By.xpath("//li[@data-value='"+string+"']"));
        element2.click();
    }
    public void clickOnSendInviteButton()
    {
        waitUntilElementIsVisible(driver, sendInviteButton, 10);
        WebElement element = getWebElement(sendInviteButton);
        element.click();
    }
    public void verifyUserRole(String string)
    {
        waitUntilElementIsVisible(driver, userRole, 10);
        WebElement element = getWebElement(By.xpath("//td[text()='test@test.com']/../td/div/div[text()='"+string+"']"));
        String roleCheck = element.getText();

        if (roleCheck.equals(string))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    public void clickOnRemoveButton()
    {
        waitUntilElementIsVisible(driver, removeButton, 10);
        WebElement element = getWebElement(By.xpath("//td[text()='test@test.com']/../td/div/button/span[text()='Remove']"));
        element.click();
    }
    public void clickConfirmRemoveButton()
    {
        waitUntilElementIsVisible(driver, confirmRemoveButton, 10);
        WebElement element = getWebElement(confirmRemoveButton);
        element.click();
    }
    public void clickOnInstanceLink(String string)
    {

        WebElement element = getWebElement(By.xpath("//a[text()='"+string+"']"));
        element.click();

    }
    public void enterTextInAskField(String string)
    {
        waitUntilElementIsVisible(driver, askField, 10);
        WebElement element = getWebElement(askField);
        element.sendKeys(string);

    }
    public void clickSendButton()
    {
        waitUntilElementIsVisible(driver, sendButton, 10);
        WebElement element = getWebElement(sendButton);
        element.click();

    }

    public void clickCloseDialogButton() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        if (isDialogDisplayed() == true) {
            waitUntilElementIsVisible(driver, closeDialogButton, 10);
            WebElement element = getWebElement(closeDialogButton);
            element.click();
        }
    }
    public boolean isUserPresent(String string)
    {
        log.trace("isUserPresent");
        try {
            driver.findElement(By.xpath("//td[text()='"+string+"']"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDialogDisplayed()
    {
//        waitUntilElementIsVisible(driver, closeDialogButton, 10);
        WebElement element = getWebElement(closeDialogButton);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isVerifyDisplayed()
    {
        waitUntilElementIsVisible(driver, verifyTextMessage, 10);
        WebElement element = getWebElement(verifyTextMessage);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isInvalidEmailDisplayed()
    {
        waitUntilElementIsVisible(driver, invalidEmailMessage, 10);
        WebElement element = getWebElement(invalidEmailMessage);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isExistingEmailDisplayed()
    {
        waitUntilElementIsVisible(driver, existingEmailMessage, 10);
        WebElement element = getWebElement(existingEmailMessage);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isAvatarIconDisplayed()
    {
        waitUntilElementIsVisible(driver, avatarIcon, 10);
        WebElement element = getWebElement(avatarIcon);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isInvalidPasswordMessageDisplayed()
    {
        waitUntilElementIsVisible(driver, invalidPasswordMessage, 10);
        WebElement element = getWebElement(invalidPasswordMessage);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isForgotPasswordMessageDisplayed()
    {
        waitUntilElementIsVisible(driver, forgotPasswordMessage, 10);
        WebElement element = getWebElement(forgotPasswordMessage);
        if(element.isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
    public void clickGmailSignIn()
    {
        waitUntilElementIsVisible(driver, gmailSignIn, 10);
        WebElement element = getWebElement(gmailSignIn);
        element.click();
    }
    public void enterGmail(String string) {
        waitUntilElementIsVisible(driver, gmailField, 10);
        WebElement element = getWebElement(gmailField);
        element.clear();
        element.sendKeys(string);
    }
    public void enterGmailPassword(String string) {
        waitUntilElementIsVisible(driver, gmailPasswordField, 10);
        WebElement element = getWebElement(gmailPasswordField);
        element.clear();
        element.sendKeys(string);
    }
    public void clickNextButton()
    {
        waitUntilElementIsVisible(driver, nextButton, 10);
        WebElement element = getWebElement(nextButton);
        element.clear();
        element.click();
    }
    public void openVerifyEmail()
    {
        waitUntilElementIsVisible(driver, verifyEmail, 10);
        WebElement element = getWebElement(verifyEmail);
        element.click();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
