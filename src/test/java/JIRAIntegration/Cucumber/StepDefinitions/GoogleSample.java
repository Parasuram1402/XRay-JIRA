package JIRAIntegration.Cucumber.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class GoogleSample {
	WebDriver driver;
	@Given("^Google is Open$")
	public void google_is_Open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
		Thread.sleep(3000);			
		System.out.println("Given");
	    //throw new PendingException();
	}

	@When("^Search for \"([^\"]*)\"$")
	public void search_for(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When " + arg1);
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
	    //throw new PendingException();
	}

	@Then("^Validate Search Results$")
	public void validate_Search_Results() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Then");
	    //throw new PendingException();
		driver.close();
	}



}
