package com.website.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class StoreLocatorTest {
	WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        // set path of Chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Projects\\automation\\drivers\\Chrome\\chromedriver.exe");

        // initialize new WebDriver session
        driver = new ChromeDriver();
    }


    @Test(priority = 0, description="Validate Officeworks Store Locator Title")
    public void validateTitle() {
        // navigate to the web site
        driver.get("https://www.officeworks.com.au/");
        WebElement el = driver.findElement(By.xpath("//a[text()='Store Locator']"));
        // Validate page title
        Assert.assertEquals(el.getText(), "Store Locator");
    }
    
    @Test(priority = 1, description="Validate Successful navigation to Store Locator")
    public void navigationToStoreLocator() throws InterruptedException {
        // navigate to the web site
        driver.get("https://www.officeworks.com.au/");
        WebElement el = driver.findElement(By.xpath("//a[text()='Store Locator']"));
        el.click();
        Thread.sleep(3);
        
        // Validate page title
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.officeworks.com.au/shop/officeworks/storelocator");
    }
    
    @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }

}
