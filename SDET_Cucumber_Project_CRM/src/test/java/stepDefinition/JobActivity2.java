package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobActivity2 {

	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> inside=null;
	
	
	@Given("^Open the browser to the ​Alchemy CRM1​ site and login$")
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
	
	@When("^Navigate to Sales -> Leads -> Create Lead$")
	public void navigation() throws InterruptedException {
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li[2]/span[2]/a")));
			
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/span[2]/a")).click();
		
		//Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement ele=driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='moduleTab_9_Leads']")));
		
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		
		ele.click();
		
		//Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")));
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")).click();
			
		
	}

	@Then("^Fill in the necessary details to create lead accounts using the values passed from  the Feature file \"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fillDetails(String fname,String lname,String phone) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first_name")));
			
		driver.findElement(By.id("first_name")).click();
		
		driver.findElement(By.id("first_name")).sendKeys(fname);
		
		driver.findElement(By.id("last_name")).sendKeys(lname);
		
		driver.findElement(By.id("phone_work")).sendKeys(phone);
		
		
	
	}
	
	@Then("^Click Save to finish$")
	public void clickSave() {
			
	driver.findElement(By.id("SAVE")).click();	
	
	}
	
	@And("^Navigate to the View Leads page to see results$")
	public void validateResults() {
		
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[3]/a/div[2]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[3]")));
		String result=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[3]")).getText();
		System.out.println(result);
	
	}

	
	
//	@And("^Close the browser$")
//	public void closeBrowser() {
//	//driver.close();	
//	}
//	
}
