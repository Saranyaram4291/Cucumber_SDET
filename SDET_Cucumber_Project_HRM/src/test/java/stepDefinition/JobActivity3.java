package stepDefinition;

import java.util.List;

import org.junit.Assert;
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

public class JobActivity3 {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> ele;
	
	@Given("^Open the ​OrangeHRM​ page2 and login with credentials provided$")
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
	
	@When("^Find the PIM option in the menu and click it$")
	public void navigateToPIMPage() throws InterruptedException {
	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[2]/a")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='menu']/ul/li[2]/a/b")).click();
	}

	
	@Then("^Click the Add button to add a new Employee$")
	public void clickAddButton() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btnAdd")));
		driver.findElement(By.cssSelector("#btnAdd")).click();
	}
	
	
	@Then("^Make sure the Create Login Details checkbox is checked$")
	public void createLoginDetails() {
		
		
		
		driver.findElement(By.cssSelector("#chkLogin")).click();
		
	}
	
	@Then("^Fill in the required fields using the data from the Examples table and click Save \"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fillDetails(String fname,String lname,String uname)
	{
		
	driver.findElement(By.cssSelector("#firstName")).sendKeys(fname);
	
	driver.findElement(By.cssSelector("#lastName")).sendKeys(lname);
	
	WebElement ele=driver.findElement(By.cssSelector("#photofile"));
	
	ele.sendKeys("C:\\Users\\SaranyaRamamoorthy\\Downloads\\apache-jmeter-5.3\\apache-jmeter-5.3\\docs\\images\\screenshots\\changes\\2.6\\01_toolbar.png");
	
	driver.findElement(By.cssSelector("#user_name")).sendKeys(uname);
	
	driver.findElement(By.cssSelector("#btnSave")).click();
		
	}
	
	@And("^Verify that the employees have been created$")
	public void verifyEmployeeCreation()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='employee-details']/div[1]/div[1]/h1")));
		String result=driver.findElement(By.xpath("//div[@id='employee-details']/div[1]/div[1]/h1")).getText();
		
		System.out.println(result);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='employee-details']/div[1]/div[1]/h1")).isDisplayed());
	}
	
		
	
}
