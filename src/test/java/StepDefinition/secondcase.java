package StepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.Select;
public class secondcase 
{
	WebDriver dr=null;
	@Given("bankuser2 logs to ANZ site and fills all details")
		
	public void verify_details() throws FileNotFoundException, Exception
	{
		
		System.out.println("Inside Step-user chooses single applicant option");
		//System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		dr.manage().window().maximize();
		dr.findElement(By.id("application_type_single")).click();
		Select drpdependent=new Select(dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div/select")));
		drpdependent.selectByIndex(0);
		System.out.println("Inside Step-User fills expenses and earning details");
			dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/div/input")).sendKeys("80000");
			/* Fill value in other income */
			dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/input")).sendKeys("10000");
			/* Fill Living expenses*/
			dr.findElement(By.id("expenses")).sendKeys("500");
			dr.findElement(By.id("homeloans")).sendKeys("0");
			dr.findElement(By.id("otherloans")).sendKeys("0");
			dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[3]/div/div[4]/div/input")).sendKeys("0");
			dr.findElement(By.id("credit")).sendKeys("10000");
	}
		@When("Order has already submitted and Loan eligibility amount has been calculated")
		public void show_loaneligibility()
		{
	 dr.findElement(By.id("btnBorrowCalculater")).click();
	 System.out.println("User is shown loan eligile amount");
		}
		
		@And ("bankuser2 clicks on startover button")
		public void click_startover_button() throws Exception
		{
	 dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[3]/div/div/div/div[2]/div[2]/button")).click();
	 TimeUnit.SECONDS.sleep(5);
	 System.out.println("All the details are cleared");
	 File screenshotfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile,new File("D:\\Software\\Java Workspace\\mindtree-solution\\screenshot2.png"));
	 dr.quit();
		}
}

