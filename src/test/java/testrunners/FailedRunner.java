package testrunners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber-reports",
	              "json:target/cucumber.json",
	              "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				}, 
		monochrome = true,
		features = {"@target/rerun.txt"},
		glue = {"stepdefinitions", "hooks"}
)

public class FailedRunner {

}
