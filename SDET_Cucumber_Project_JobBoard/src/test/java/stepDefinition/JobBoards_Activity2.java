package stepDefinition;

import java.util.List;

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

public class JobBoards_Activity2 {

	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> ele;
	
	@Given("^Open browser with ​Alchemy Jobs site​ and navigate to Jobs page$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.navigate().to("https://alchemy.hguy.co/jobs/​​");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='menu-item-24']/a")));
		
		driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
		
	}
	
	@When("^Find the Keywords search input field$")
	public void findKeywordSearch() {
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search_keywords")));
		
	
		
	}

	@Then("^Type in keywords to search for jobs and change the Job type$")
	public void typeKeywordSearch() {
		
		driver.findElement(By.cssSelector("#search_keywords")).sendKeys("Test");
		
		
	}
	
	@Then("^Find the filter using XPath and filter job type to show only Full Time jobs$")
	public void filterJobType() {
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='job_types']//descendant::label"));
		
		for(WebElement ele:list)
		{
			System.out.println("Element value"+ele.getText());
			if(ele.getText().equals("Full Time"))
			{
				
			}
			else
			{
				ele.click();
			}
		}
			
	}
	
	@Then("^Find a job listing using XPath and it to see job details$")
	public void fillTheDetails() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("Job details");
		ele=driver.findElements(By.xpath("//ul[@class='job_listings']//descendant::a/div[1]/h3"));
		
		for(WebElement job:ele)
		{
			System.out.println("Job details"+job.getText());
		}
			
	}
	
	
	@Then("^Find the title of the job listing using XPath and print it to the console$")
	public void findTitleJobAndPrintIt() {
		
		for(WebElement job:ele)
		{
			if(job.getText().equals("Cucumber/BDD Tester"))
			{
				job.click();
				break;
			}
		}
				
	}
	
	@And("^Find and Click on the Apply for job button$")
	public void applyForJob()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='application_button button']")));
		driver.findElement(By.xpath("//input[@class='application_button button']")).click();
	}
	
	
	
//	@And("^Close the browser$")
//	public void closeBrowser()
//	{
//		//driver.close();
//	}

}
