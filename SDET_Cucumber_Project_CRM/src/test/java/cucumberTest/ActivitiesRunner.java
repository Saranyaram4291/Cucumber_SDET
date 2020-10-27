package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Feature",
    glue = {"stepDefinition"},
    tags="@activity_4",
    monochrome=true,
    plugin = { "pretty", "html:target/cucumber-reports/reports1" }
   
)

public class ActivitiesRunner {

}
