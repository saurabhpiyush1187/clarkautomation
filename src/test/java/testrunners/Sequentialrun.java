package testrunners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome= true,
		features = {"src/test/resources/com/features"},
		glue = {"stepdefinitions", "hooks"},
		plugin = {"pretty","html:target/cucumber-reports",
	              "json:target/cucumber.json",
	              "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"				
		}
		
		)
public class Sequentialrun {

}
