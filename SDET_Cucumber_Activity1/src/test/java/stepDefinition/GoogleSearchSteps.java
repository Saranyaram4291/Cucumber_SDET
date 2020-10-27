package stepDefinition;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@Given("^User is on Google Home Page$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		
		String userProfile= "C:\\Users\\SaranyaRamamoorthy\\AppData\\Local\\Google\\Chrome\\AutomationProfile\\";
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-gpu","start-maximized","disable-extensions");
//		options.add_argument(--profile-directory="Default")
		//options.addArguments("user-data-dir="+userProfile);
		//options.addArguments("--start-maximized");
        
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.get("https://www.google.com");
		
	}

	@When("^User types in Cheese and hits ENTER$")
	public void searchValue() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search']")));
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Cheese");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		
		
	}

	@Then("^Show how many search results were shown$")
	public void resultOutput() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='result-stats']")));
		String result=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
		System.out.println("Resulted value"+result);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result-stats']")).isDisplayed());
		
	}
	
	@And("^Close the browser$")
	public void closeBrowser()
	{
		driver.close();
	}

}
