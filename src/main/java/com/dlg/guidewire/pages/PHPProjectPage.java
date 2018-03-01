package com.dlg.guidewire.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PHPProjectPage {
	WebDriver driver;

	@FindBy(linkText="Projects")
	public WebElement projectsLink;	
	
	@FindBy(xpath="//img[@name='saP0']")
	public WebElement addProject;

	@FindBy(xpath="//input[@name='pn']")
	public WebElement projectNameObj;	
    
	@FindBy(xpath="//select[@name='pr']")
	public WebElement priorityObj;
    

	@FindBy(xpath="//select[@name='pown']")
	public WebElement ownerObj;
    
	@FindBy(xpath="//input[@value='Save']")
	public WebElement save;

	@FindBy(xpath="//td")
	public WebElement message;

	public PHPProjectPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddProject(String projectName, String priority, String owner) throws InterruptedException{
		projectsLink.click();
		addProject.click();
		projectNameObj.sendKeys(projectName);
		Select priorityList=new Select(priorityObj);
		priorityList.selectByVisibleText(priority);
		Select ownerList=new Select(ownerObj);
		ownerList.selectByVisibleText(owner);
		save.click();
		Thread.sleep(2000);
	}
	
	public void ModifyProject(String projectName, String priority, String owner) throws InterruptedException{
		
	}
	
}
