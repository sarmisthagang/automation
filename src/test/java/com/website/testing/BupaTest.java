package com.website.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
public class BupaTest {
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


    @Test(priority = 0, description="Successfully redirection to login url")
    public void makeAClaimSuccessfulRedirection() throws InterruptedException {
    	driver.get("https://www.bupa.com.au/");
    	WebElement link = driver.findElement(By.linkText("Make a claim"));
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(link));
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", link);
		
		System.out.println("Url:" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://my.bupa.com.au/login?s_intcid=homepage:topnav:mybupa:login"));
		
    }
    
    
    @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }

}
