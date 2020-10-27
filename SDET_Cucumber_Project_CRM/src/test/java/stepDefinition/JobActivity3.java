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

public class JobActivity3 {


	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> inside=null;
	
	
	@Given("^Open the browser to the ​Alchemy CRM2 site and login$")
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
	
	@When("^Navigate to Activities -> Meetings -> Schedule a Meeting$")
	public void navigation() throws InterruptedException {
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li[5]/span[2]/a")));
			
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[5]/span[2]/a")).click();
		
		//Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement ele=driver.findElement(By.xpath("//a[@id='moduleTab_9_Meetings']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='moduleTab_9_Meetings']")));
		
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		
		ele.click();
		
		//Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")));
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")).click();
			
		
	}
	
	@Then("^Enter the details of the meeting$")
	public void enterDetails() throws InterruptedException {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("name")).click();
		
		driver.findElement(By.id("name")).sendKeys("Meeting testing");
		
		driver.findElement(By.id("description")).sendKeys("check");
		
	
		
	}

	@Then("^Search for members and add them to the meeting \"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fillDetails(String fname,String lname,String email) {
		
		driver.findElement(By.id("search_first_name")).click();
		
		driver.findElement(By.id("search_first_name")).sendKeys(fname);
		
		driver.findElement(By.id("search_last_name")).sendKeys(lname);
		
		driver.findElement(By.id("search_email")).sendKeys(email);
		
		driver.findElement(By.id("invitees_search")).click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invitees_add_1")));
		
		driver.findElement(By.id("invitees_add_1")).click();
		
		
		
		
	
	}
	
	@Then("^Click Save$")
	public void clickSave() {
			
	driver.findElement(By.id("SAVE_HEADER")).click();	
	
	}
	
	@And("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void validateResults() {
		
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[2]/a/div[2]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[4]")));
		String result=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[4]/b/a")).getText();
		System.out.println(result);
	
	}

	
}
