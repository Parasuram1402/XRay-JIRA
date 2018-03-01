package com.dlg.guidewire.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class PHPUserPage {
	WebDriver driver;

	@FindBy(xpath="//img[@alt='Add']")
	public WebElement addUserObj;	

	@FindBy(xpath="//input[@name='un']")
	public WebElement userNameObj;

	@FindBy(xpath="//input[@name='fn']")
	public WebElement fullNameObj;
    
	@FindBy(xpath="//input[@name='pw']")
	public WebElement passwordObj;
    
	@FindBy(xpath="//input[@name='pwa']")
	public WebElement confirmPasswordObj;
    
	@FindBys({ @FindBy (xpath="//input[@name='perm']")})
	public List<WebElement> permissionsObjList;
    
	@FindBy(xpath="//input[@name='Save']")
	public WebElement save;
    
	@FindBy(xpath="//td")
	public WebElement message;

	@FindBy(linkText="User Management")
	public WebElement userManagementObj;

	public PHPUserPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public void AddUser(String name, String fullname, String password, String permission) throws InterruptedException{	
    	addUserObj.click();
		userNameObj.sendKeys(name);
		fullNameObj.sendKeys(fullname);
		passwordObj.sendKeys(password);
		confirmPasswordObj.sendKeys(password);
		List<WebElement> permissions=permissionsObjList;
		  
		if(permission.equals("Project Manager"))
		{
			permissions.get(0).click();
		} else if (permission.equals("Project Administrator")) {
			permissions.get(3).click();
		} else if (permission.equals("User")) {
			permissions.get(1).click();
		}
		save.click();
		Thread.sleep(1000);    	
    }
    
    public void ModifyUser(String name, String fullname, String password, String permission) throws InterruptedException{
    	
    }
	
}
