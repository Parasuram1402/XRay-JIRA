package com.dlg.guidewire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPLoginPage {
	WebDriver driver;

	@FindBy(xpath="//input[@name='loginForm']")
	public WebElement usernameObj;
	
	@FindBy(name="passwordForm")
	public WebElement passwordObj;

	@FindBy(name="save")
	public WebElement loginObj;
    
	@FindBy(linkText="Log Out")
	public WebElement logoutObj;
	
	public PHPLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get("http://localhost/");
	}

    public void Login(String username, String password){
    	
    	
    	usernameObj.sendKeys(username);
    	passwordObj.sendKeys(password);
    	loginObj.click();
    	
    }
    
    public void Logout(){
    	  logoutObj.click();
    	  driver.quit();
    }

	
}
