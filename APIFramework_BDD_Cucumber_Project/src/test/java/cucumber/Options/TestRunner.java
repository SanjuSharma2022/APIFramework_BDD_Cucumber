package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
				 plugin = "json:target/JsonReports/Cucumber-Report.json",glue={"stepDefinations"},
				 tags= "@DeletePlace")
public class TestRunner {
///
}
