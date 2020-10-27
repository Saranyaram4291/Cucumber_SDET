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
	List<WebElement> ele;
	
	@Given("^Open the ​OrangeHRM​ page and login with credentials provided$")
	public void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SaranyaRamamoorthy\\workspace\\LemonadeAutomationHeroku\\src\\test\\resources\\executables\\geckodriver.exe");		

		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		
		driver.navigate().to("http://alchemy.hguy.co/orangehrm​​");
		
		Thread.sleep(2000);
		
		driver.get("http://alchemy.hguy.co/orangehrm​​");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#txtUsername")));
		
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("orange");
		
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("orangepassword123");
		
		driver.findElement(By.cssSelector("#btnLogin")).click();
		
		
		
	}
	
	@When("^Navigate to the Recruitment page$")
	public void navigateToRecuritmentPage() {
	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[5]/a")));
		
		driver.findElement(By.xpath("//div[@class='menu']/ul/li[5]/a/b")).click();
		
	
		
	}

	@Then("^Click on the Vacancies menu item to navigate to the vacancies page$")
	public void clickVacancies() {
		
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[5]/ul/li[2]/a")));
	
	driver.findElement(By.xpath("//div[@class='menu']/ul/li[5]/ul/li[2]/a")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='srchVacancy']")));
	
	
	
	}
	
	@Then("^Click on the Add button to navigate to the Add Job Vacancy form$")
	public void clickAddButton() {
		
		driver.findElement(By.cssSelector("#btnAdd")).click();
		
		
	}
	
	
	@Then("^Fill out the necessary details$")
	public void fillDetails() {
		
		driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']")).click();
		
		Select ele=new Select(driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']")));
		ele.selectByVisibleText("Android Developer");
		
		driver.findElement(By.cssSelector("#addJobVacancy_name")).sendKeys("tesat");
		
		driver.findElement(By.cssSelector("#addJobVacancy_hiringManager")).sendKeys("AA1Test123 Automation");
		
		driver.findElement(By.cssSelector("#addJobVacancy_noOfPositions")).sendKeys("2");
		
		driver.findElement(By.cssSelector("#addJobVacancy_description")).sendKeys("erere");
		
		
	}
	
	@Then("^Click the Save button to save the vacancy$")
	public void clickSaveButton() {
		
		driver.findElement(By.cssSelector("#btnSave")).click();
	}
	

	@And("^Verify that the vacancy was created$")
	public void verifyVacancy() {
		
		String title=driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
		
		Assert.assertEquals("Edit Job Vacancy",title);
	}
	
	@And("^Close the browser$")
	public void closeBrowser() {
	//driver.close();	
	}

}
