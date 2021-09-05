package StepDefinition;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(features= {"src/test/resources/Features"},
glue={"helpers","StepDefinition"},
monochrome=true,
plugin= {"pretty","html:target/HTMLReports.html"}
)
	
public class runner 
{
	public static void main(String[] args) throws Exception 
	{
		JUnitCore jCore = new JUnitCore();
        jCore.run();
	}
}
