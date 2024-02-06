package com.website.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
public class BookingWebsite{
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

    @Test(priority = 0, description="Successfully redirection to Signin url")
    public void signInRedirection() throws InterruptedException {
    	driver.get("https://www.booking.com/");
    	//Relative Xpath
    	WebElement button= driver.findElement(By.xpath("//header/nav[1]/div[2]/span[1]/a[1]"));
    	button.click();
    	
    	Assert.assertEquals(driver.getCurrentUrl().contains("https://account.booking.com/sign-in"), true);    	
    }
    
    @Test(priority = 0, description="Successfully able to check the Header in SignIn")
    public void signInHeader() throws InterruptedException {
    	driver.get("https://www.booking.com/");
    	//Relative Xpath
    	WebElement button= driver.findElement(By.xpath("//header/nav[1]/div[2]/span[1]/a[1]"));
    	button.click();
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("https://account.booking.com/sign-in"));
    	    	
    	//WebElement el= driver.findElement(By.xpath("//h1[text()='Sign in or create an account']"));
    	List<WebElement> elements = driver.findElements(By.xpath("//h1"));
    	    	
    	Assert.assertEquals(elements.get(0).getText(), "Sign in or create an account");
    }
    
    
    @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }

}

