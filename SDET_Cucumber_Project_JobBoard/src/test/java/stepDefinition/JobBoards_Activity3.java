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

public class JobBoards_Activity3 {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> ele;
	
	@Given("^user opens browser with alchemy site$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.navigate().to("https://alchemy.hguy.co/jobs/​​");
		
		
		
	}
	
	@When("^Go to Post a Job page$")
	public void goToPostJobPage() {
	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='menu-item-26']/a")));
		
		driver.findElement(By.xpath("//li[@id='menu-item-26']/a")).click();
		
	
		
	}

	@Then("^Read job information from the Feature file table and fill in the details \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fillJobInformation(String email,String jobTitle,String jobLocation,String jobType,String desc,String application) {
		
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create_account_email")));
	
	driver.findElement(By.xpath("//div[@class='field account-sign-in']/a")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user_login")));
		driver.findElement(By.cssSelector("#user_login")).sendKeys("root");
	
	driver.findElement(By.cssSelector("#user_pass")).sendKeys("pa$$w0rd");
	
	driver.findElement(By.cssSelector("#wp-submit")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#job_title")));
	
	
	driver.findElement(By.cssSelector("#job_title")).sendKeys(jobTitle);
	
	driver.findElement(By.cssSelector("#job_location")).sendKeys(jobLocation);
	
	driver.findElement(By.xpath("//select[@id='job_type']")).click();
	
	Select ele=new Select(driver.findElement(By.xpath("//select[@id='job_type']")));
	
	ele.selectByVisibleText(jobType);
	
	driver.switchTo().frame("job_description_ifr");
	
	driver.findElement(By.xpath("//html/body[@id='tinymce']")).sendKeys(desc);
	
	driver.switchTo().parentFrame();
	

	}
	
	@Then("^Click submit$")
	public void clickSubmit() {
		
		driver.findElement(By.xpath("//input[@class='button secondary save_draft']")).click();
		
		String result=driver.findElement(By.xpath("//div[@class='job-manager-info']/a")).getText();
		
		Assert.assertEquals(result,"job dashboard");
		
			}
	
	@Then("^Go to the Jobs page$")
	public void goToJobPage() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='job-manager-info']/a")).click();
	}
	
	
	@And("^Confirm job listing is shown on page$")
	public void confirmJobListing() {
		
		String test=driver.findElement(By.xpath("//table[@class='job-manager-jobs']//tbody/tr[1]/td[1]")).getText();
		Assert.assertEquals(test,"testScript (Draft)");
	}
	
	@And("^Generate HTML report$")
	public void closeBrowser()
	{
		//driver.close();
	}
	

}
