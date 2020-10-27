package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JavaScriptAlerts {
	WebDriver driver=null;
	WebDriverWait wait=null;
	Alert alert;
	
	
	@Given("^User is on the page$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
	}

	@When("^User clicks the Simple Alert button$")
	public void simpleAlert() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='simple']")));
				
		driver.findElement(By.xpath("//button[@id='simple']")).click();
		
		
	}
	
	@When("^User clicks the Confirm Alert button$")
	public void confirmAlert() {
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='confirm']")));
				
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
		
	}
	
	@When("^User clicks the Prompt Alert button$")
	public void promptAlert() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='prompt']")));
		
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		
		
	}

	@Then("^Alert opens$")
	public void alertOpen() {
		
		
		alert=driver.switchTo().alert();
		
	}
	
	@And("^Read the text from it and print it$")
	public void readTextAndPrint() {
		
		System.out.println("Alert text "+alert.getText());
		
	}
	
	@And("^Close the alert$")
	public void closeAlert() {
		
		alert.accept();
		
	}
	

	@And("^Close the alert with Cancel$")
	public void closeAlertCancel() {
		
		alert.dismiss();
		
	}

	
	@And("^Write a custom message in it$")
	public void writeResultText()
	{
		alert.sendKeys("Message");
	}
	
	
	
	@And("^Close Browser$")
	public void closeBrowser()
	{
		driver.close();
	}

}