package com.orangehrm.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.Pages.LoginPage;

public class VerifyOrangehrmLogin {
	WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        // set path of Chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Projects\\automation\\drivers\\Chrome\\v122\\chromedriver.exe");

        // initialize new WebDriver session
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        
    }
        @Test
        public void verifyLogin() throws InterruptedException
        {
        
        	LoginPage logIn= new LoginPage (driver);
        	
        	logIn.typeUserName();
        	logIn.typePassword();
        	logIn.submitLogIn();
        	Thread.sleep(2000);
        }
    
        @AfterMethod
        public void afterMethod() {

            // close and quit the browser
            driver.quit();
        }
    
}
