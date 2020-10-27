package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobActivity4 {
	

	WebDriver driver=null;
	WebDriverWait wait=null;
	List<WebElement> inside=null;
	
	
	@Given("^Open the browser to the ​Alchemy CRM3 site and login$")
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
	
	@When("^Navigate to All -> Products-> Create Product$")
	public void navigation() throws InterruptedException {
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li[7]/span[2]/a")));
			
		
		
		Actions actions = new Actions(driver);
		
		WebElement ele=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[7]/span[2]/a"));
		actions.moveToElement(ele).perform();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement ele1=driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[25]/a"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-menu']/li[25]/a")));

		js.executeScript("arguments[0].scrollIntoView(true);",ele1);
		
		ele1.click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")));
		
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[1]/a/div[2]")).click();
	}
	
	@Then("^enter the details of the product \"(.*)\",\"(.*)\",\"(.*)\"$")
	public void enterDetails(String productName,String price,String partNo) throws InterruptedException {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("name")).click();
		
		driver.findElement(By.id("name")).sendKeys(productName);
		
		driver.findElement(By.id("price")).sendKeys(price);
		
		driver.findElement(By.id("part_number")).sendKeys(partNo);
		
	}
	
	@Then("^Click Save1$")
	public void clickSave() {
			
	driver.findElement(By.id("SAVE")).click();	
	
	}
	
	
	@And("^Go to the “View Products” page to see all products listed$")
	public void viewProducts() {
			
		driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[2]/a/div[2]")).click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[3]/b/a")));
		
		String result=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[3]/b/a")).getText();
	
		System.out.println("Result"+result);
	}
}
