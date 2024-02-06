package com.website.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
public class IdentityTest {
	WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        // set path of Chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Projects\\automation\\drivers\\Chrome\\chromedriver.exe");

        // initialize new WebDriver session
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(priority = 0, description="Successfully redirection to auth url")
    public void successfulRedirection() {
    	driver.get("https://www.officeworks.com.au/");
        // WebElement search = driver.findElement(By.className(""));
        //3. Navigate mega menu logIn button
        WebElement button = driver.findElement(By.className("MenuButton__Button-sc-nqjnfm-1"));
        //4. Open the login dropdown
        button.click();

        WebElement LogIn = driver.findElement(By.className("Button__ButtonLabel-e6xond-2"));
        LogIn.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("auth.officeworks.com.au"));
    }    
    
    //Following test is disabled as BOT enabled in production
    @Test(priority = 1, enabled = false, description="Successfully login using proper username and password")
    public void successfulLogin() {
    	driver.get("https://www.officeworks.com.au/");
        // WebElement search = driver.findElement(By.className(""));
        //3. Navigate mega menu logIn button
        WebElement button = driver.findElement(By.className("MenuButton__Button-sc-nqjnfm-1"));
        //4. Open the login dropdown
        button.click();

        WebElement LogIn = driver.findElement(By.className("Button__ButtonLabel-e6xond-2"));
        LogIn.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("auth.officeworks.com.au"));

        WebElement userText = driver.findElement(By.cssSelector("label[for='username']"));

        /* Following username and password should not be hard-coded in code, so dummy username and password used here.
        Please change the following fields with proper username and pasword
        */
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("retail@test.com");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("Test1234");

        WebElement loginField = driver.findElement(By.cssSelector("button[data-action-button-primary='true']"));
        loginField.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.officeworks.com.au/");
    }
    
    
    @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }

}
