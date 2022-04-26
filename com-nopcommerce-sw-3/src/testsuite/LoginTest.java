package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // Find log in link and click on login link
       /* WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();*/
        clickOnElement(By.linkText("Log in"));

        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        // Find the welcome text element and get the text
       /* WebElement actuleMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actuleMessageElement.getText();*/
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        // Find log in link and click on login link
       /* WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();*/
        clickOnElement(By.linkText("Log in"));

        // Find the email field element
        /*WebElement emailField = driver.findElement(By.id("Email"));
        // Sending email to email field element
        emailField.sendKeys("prime123@gmail.com");*/
        sendTextToElement(By.id("Email"), "prime123@gmail.com");

        // Find the password field element
       /* WebElement passwordField = driver.findElement(By.name("Password"));
        // Sending Password to password field element
        passwordField.sendKeys("Prime123");*/
        sendTextToElement(By.name("Password"), "Prime123");

        //Find the login button and click on it
        /*WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();*/
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
//        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));

        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}





