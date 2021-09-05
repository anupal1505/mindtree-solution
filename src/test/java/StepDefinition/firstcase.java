package StepDefinition;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.Select;
public class firstcase 
{
	WebDriver dr=null;
	@Given("bankuser chooses Single option")
		
	public void verify_singleoption() throws FileNotFoundException, Exception
	{
		
		System.out.println("Inside Step-user chooses single applicant option");
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		dr.findElement(By.id("application_type_joint")).click();
		Select drpdependent=new Select(dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div/select")));
		drpdependent.selectByIndex(1);
		dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/div/input")).sendKeys("80000");
		/* Fill value in other income */
		dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/input")).sendKeys("10000");
		/* Fill Living expenses*/
		dr.findElement(By.id("expenses")).sendKeys("500");
		dr.findElement(By.id("homeloans")).sendKeys("0");
		dr.findElement(By.id("otherloans")).sendKeys("0");
		dr.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[3]/div/div[4]/div/input")).sendKeys("0");
		dr.findElement(By.id("credit")).sendKeys("1000");
	 dr.findElement(By.id("btnBorrowCalculater")).click();
	}
}
