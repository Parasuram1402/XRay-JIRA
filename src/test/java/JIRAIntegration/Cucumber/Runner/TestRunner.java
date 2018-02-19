package JIRAIntegration.Cucumber.Runner;
//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"JIRAIntegration.Cucumber.StepDefinitions"}, plugin={"pretty","report.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
