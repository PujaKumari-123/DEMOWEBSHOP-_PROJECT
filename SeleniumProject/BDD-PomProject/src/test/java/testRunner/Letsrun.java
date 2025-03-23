package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
    		   "C:\\Users\\manis\\eclipse-workspace\\BDD-PomProject\\src\\test\\resources\\Feature\\log.feature",
               "C:\\Users\\manis\\eclipse-workspace\\BDD-PomProject\\src\\test\\resources\\Feature\\LogIn.feature"
    },  
    glue = "stepDefinition",
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Generates reports
    monochrome = true // Improves console readability
)
public class Letsrun extends AbstractTestNGCucumberTests {
}
