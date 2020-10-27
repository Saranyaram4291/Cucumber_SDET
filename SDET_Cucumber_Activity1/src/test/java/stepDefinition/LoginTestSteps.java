package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@Given("^User is on Login page$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.get("https://www.training-support.net/selenium/login-form");
		
	}

	@When("^User enters username and password$")
	public void searchValue() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[@class='ui button']")).click();
		
		
	}

	@Then("^Read the page title and confirmation message$")
	public void resultOutput() {
		
		String title=driver.getTitle();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='action-confirmation']")));
		String result=driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		System.out.println("Resulted value "+result);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='action-confirmation']")).isDisplayed());
		
	}
	
	@And("^Close the Browser$")
	public void closeBrowser()
	{
		driver.close();
	}

}
