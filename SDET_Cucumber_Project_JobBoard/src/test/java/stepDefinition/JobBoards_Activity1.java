package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobBoards_Activity1 {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@Given("^User opens a browser$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin​​");
		
		Thread.sleep(3000);
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin​​");
		
	}
	
	@When("^Navigated to url and log in$")
	public void logIn() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user_login']")));
		
		driver.findElement(By.xpath("//input[@id='user_login']")).clear();
		
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		
		driver.findElement(By.xpath("//input[@id='user_pass']")).clear();
		
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		
		
		
		
	}

	@Then("^Locate the left hand menu and click the menu item that says Users$")
	public void locatingMenu() {
		
		driver.findElement(By.xpath("//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-users']/div[3]")).click();
		
	}
	
	@Then("^Locate the Add New button and click it$")
	public void locatingNewButton() {
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class='wp-submenu wp-submenu-wrap']//descendant::a"));
		
		for(WebElement check:ele)
		{
			if(check.getText().equals("Add New"))
			{
				check.click();
				break;
			}
		}
	}
	
	@Then("^Fill in the necessary details$")
	public void fillTheDetails() {
		
		driver.findElement(By.cssSelector("#user_login")).sendKeys("Saranya");
		driver.findElement(By.cssSelector("#email")).sendKeys("email@ibm.com");
		driver.findElement(By.cssSelector("#first_name")).sendKeys("Saranya");
		driver.findElement(By.cssSelector("#last_name")).sendKeys("Saranya");
		driver.findElement(By.cssSelector("#url")).sendKeys("Saranya");
		driver.findElement(By.xpath("//button[@class='button wp-generate-pw hide-if-no-js']")).click();
		
		
		
	}
	
	
	@Then("^Click the Add New User button$")
	public void clickAddNewUser() {
		
		driver.findElement(By.cssSelector("#createusersub")).click();
		
	}
	
	@And("^Verify that the user was created$")
	public void validateUserCreation()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='message']/p")));
		if(driver.findElement(By.xpath("//div[@id='message']/p")).isDisplayed())
		{
			System.out.println("User created");
		}
	}
	
	
	
	@And("^Close the browser$")
	public void closeBrowser()
	{
		driver.close();
	}

}
