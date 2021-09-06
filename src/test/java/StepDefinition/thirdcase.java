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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.Select;
public class thirdcase 
{
	WebDriver dr=null;
	@Given("bankuser3 logs to ANZ site")
		
	public void verify_details() throws FileNotFoundException, Exception
	{
		
		System.out.println("Inside Step-user chooses single applicant option");
		//System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		dr.manage().window().maximize();
	}
	@When("bankuser only fills living expenses and submit the application")
	public void submit_application() throws Exception
	{
		dr.findElement(By.id("application_type_single")).click();
		Select drpdependent=new Select(dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div/select")));
		drpdependent.selectByIndex(0);
		
			dr.findElement(By.id("expenses")).sendKeys("1");
			dr.findElement(By.id("btnBorrowCalculater")).click();
			TimeUnit.SECONDS.sleep(5);
	}
		@Then("bankuser receives error message")
		public void show_loaneligibility() throws Exception
		{
	 	 System.out.println("User is shown error message");
	 	File screenshotfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile,new File("D:\\Software\\Java Workspace\\mindtree-solution\\screenshot3.png"));
		}
		
}

