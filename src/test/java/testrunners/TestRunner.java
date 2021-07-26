package testrunners;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome= true,
		features = {"src/test/resources/com/features"},
		glue = {"stepdefinitions", "hooks"},
		plugin = {"pretty","html:target/cucumber-reports/report.html",
	              "json:target/cucumber.json",
	              "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"				
		}
		
		)
public class TestRunner {
}