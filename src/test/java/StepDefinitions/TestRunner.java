package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = {"StepDefinitions"},
        tags = "@regression",
        monochrome = true,
        plugin = {"pretty", "html:reports/htmlReport.html"})
public class TestRunner {
}
