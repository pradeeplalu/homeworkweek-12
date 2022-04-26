package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username filed and sen values
        sendTextToElement(By.xpath("//input[@name=\"username\"]"), "christina123");

        //to find the password field element
        sendTextToElement(By.xpath("//input[@name=\"password\"]"), "chris123");

        //find login element and click
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));

        //validate actual and expected text
        assertVerifyText(By.tagName("h1"), "Accounts Overview");
    }
    @Test
    public void verifyTheErrorMessage() {
        //find username element
        sendTextToElement(By.xpath("//input[@name=\"username\"]"), "london23");

        //to find the password field element
        sendTextToElement(By.xpath("//input[@name=\"password\"]"), "Hind$123");

        //find login element and click
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));

        //validate actual and expected text
        assertVerifyText(By.tagName("h1"), "The username and password could not be verified.");
    }
    @Test
    public void userShouldLogOutSuccessfully(){
//find username filed and sen values
        sendTextToElement(By.xpath("//input[@name=\"username\"]"),"christina123");

        //to find the password field element
        sendTextToElement(By.xpath("//input[@name=\"password\"]"),"chris123");

        //find login element and click
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));

        //find logout element and click
        clickOnElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }


}
