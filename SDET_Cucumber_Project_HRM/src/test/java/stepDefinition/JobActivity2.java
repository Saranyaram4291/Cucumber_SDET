package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class JobActivity2 {

	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> ele;
	
	@Given("^Open the ​OrangeHRM​ page1 and login with credentials provided$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.navigate().to("http://alchemy.hguy.co/orangehrm");
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#txtUsername")));
		
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("orange");
		
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("orangepassword123");
		
		driver.findElement(By.cssSelector("#btnLogin")).click();
		
		
		
	}
	
	@When("^Navigate to the Recruitment page and click on the Add button to add candidate  information$")
	public void navigateToRecuritmentPage() {
	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[5]/a")));
		
				
		driver.findElement(By.xpath("//div[@class='menu']/ul/li[5]/a/b")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btnAdd")));
		
		driver.findElement(By.cssSelector("#btnAdd")).click();
		
		
	}
	
	@Then("^On the next page, fill in the details of the candidate$")
	public void fillDetails() {
		
		driver.findElement(By.cssSelector("#addCandidate_firstName")).sendKeys("fname1");
		
		driver.findElement(By.cssSelector("#addCandidate_lastName")).sendKeys("lname1");
		
		driver.findElement(By.cssSelector("#addCandidate_email")).sendKeys("email@gmail.com");
		
		driver.findElement(By.cssSelector("#addCandidate_contactNo")).sendKeys("9090909090");
		
		driver.findElement(By.xpath("//select[@id='addCandidate_vacancy']")).click();
		
		Select ele1=new Select(driver.findElement(By.xpath("//select[@id='addCandidate_vacancy']")));
		
		ele1.selectByVisibleText("1212");
		
		
		driver.findElement(By.cssSelector("#addCandidate_keyWords")).sendKeys("Test");
		
		driver.findElement(By.cssSelector("#addCandidate_comment")).sendKeys("CommentTest");
		
			
	}
	
	@Then("^Upload a resume docx or pdf to the form$")
	public void uploadResume() {
		//driver.findElement(By.cssSelector("#addCandidate_resume")).click();
		
		WebElement upload=driver.findElement(By.cssSelector("#addCandidate_resume"));
		
		upload.sendKeys("C:\\Users\\SaranyaRamamoorthy\\Documents\\Call center.doc");
	}
	
	@Then("^Click Save$")
	public void clickSave() {
		
		
		
		WebElement save=driver.findElement(By.cssSelector("#btnSave"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", save);
		
		save.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='status']")));
		String result=driver.findElement(By.xpath("//span[@class='status']")).getText();
		Assert.assertEquals("Status: Application Initiated",result);
	}
	
	@And("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void backRecuritment()
	{
		driver.findElement(By.cssSelector("#btnBack")).click();
		
		
		for(int i=1;i<6;i++)
		{
		String result=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+i+"]/td[3]")).getText();
		if(result.equals("fname1 lname1"))
			{
			System.out.println(result);
			break;
			}
		}
	}
	
	
//
//	@And("^Close the browser$")
//	public void closeBrowser()
//	{
//		
//	}
	
	
	

}
