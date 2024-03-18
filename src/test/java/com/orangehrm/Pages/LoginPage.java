/**
 * 
 */
package com.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 */
public class LoginPage {
	WebDriver driver;
	
	
	By username= By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//button[normalize-space()='Login']");

	
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void typeUserName() {
		
	driver.findElement(username).sendKeys("Admin");;
		
	}
	public void typePassword(){
		
	driver.findElement(password).sendKeys("admin123");
	}
	
	public void submitLogIn () {
		driver.findElement(loginButton).click();
		
		
	}
	
}




