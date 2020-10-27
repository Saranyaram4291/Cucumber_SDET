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

public class JobActivity4 {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> ele;
	
	@Given("^Open the ​OrangeHRM​ page3 and login with credentials provided$")
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
	
	@When("^Navigate to the Recruitment page1$")
	public void navigateToRecuritmentPage() throws InterruptedException {
	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[5]/a")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='menu']/ul/li[5]/a/b")).click();
	}
	
	
	@Then("^Click on the Vacancies menu item to navigate to the vacancies page1$")
	public void clickVacancies() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[5]/ul/li[2]/a")));
		driver.findElement(By.xpath("//div[@class='menu']/ul/li[5]/ul/li[2]/a")).click();
	}

	@Then("^Click on the Add button to navigate to the Add Job Vacancy form1$")
	public void clickAddButton() {
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btnAdd")));
		
		driver.findElement(By.cssSelector("#btnAdd")).click();
		
	}
	
	@Then("^Fill out the necessary details using data from the Examples tables and click Save \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fillDetails(String jobTitle,String vacancyName,String hiringManager,String noOfPositions,String desc) {
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#addJobVacancy_name")));
		
		Select ele=new Select(driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']")));
		
		ele.selectByVisibleText(jobTitle);
		
		driver.findElement(By.cssSelector("#addJobVacancy_name")).sendKeys(vacancyName);
		
		driver.findElement(By.cssSelector("#addJobVacancy_hiringManager")).sendKeys(hiringManager);
		
		driver.findElement(By.cssSelector("#addJobVacancy_noOfPositions")).sendKeys(noOfPositions);
		
		driver.findElement(By.cssSelector("#addJobVacancy_description")).sendKeys(desc);
		
	}
	
	@Then("^Click the Save button to save the vacancy1$")
	public void clickSaveButton() {
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btnSave")));
		
		driver.findElement(By.cssSelector("#btnSave")).click();
		
	}
	
	@And("^Verify that the employees have been created1$")
	public void verfityEmployeeCreation() {
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btnSave")));
		
		driver.findElement(By.cssSelector("#btnSave")).click();
		
	}
	
	
	

}
