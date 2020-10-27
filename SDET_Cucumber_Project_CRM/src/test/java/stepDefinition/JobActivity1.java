package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobActivity1 {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> inside=null;
	
	@Given("^Open the browser to the ​Alchemy CRM​ site and login$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.navigate().to("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user_name")));
		
		driver.findElement(By.cssSelector("#user_name")).clear();
		
		driver.findElement(By.cssSelector("#user_name")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("#username_password")).clear();
		
		driver.findElement(By.cssSelector("#username_password")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.cssSelector("#bigbutton")).click();
		
		
		
	}
	
	@When("^Count the number of Dashlets on the homepage$")
	public void countNumberDashlest() throws InterruptedException {
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@id,'dashlet')]//descendant::h3/span[2]")));
			
					
		inside=driver.findElements(By.xpath("//li[contains(@id,'dashlet')]//descendant::h3/span[2]"));
				
		
				
								
			
		
	}

	@Then("^Print the number and title of each Dashlet into the console$")
	public void clickVacancies() {
			
		System.out.println("Title of each dashlet :");
		for(WebElement e:inside)
		{
					System.out.println(e.getText());
		}
		
		System.out.println("No of dashlet :"+inside.size());
	
	}
	

	
	@And("^Close the browser$")
	public void closeBrowser() {
	//driver.close();	
	}

}
