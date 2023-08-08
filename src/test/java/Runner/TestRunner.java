package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:/RahulShetty_SeleniumFramework/CucumberFramework/src/main/java/Features/login.feature" //path of feature file
        ,glue = {"StepDefinitions"}   //path of StepDefinitions
       ,plugin= {"pretty","html:html_output/cucumber.html","json:json_output/cucumber.json"} //to generate different type of reports
       , monochrome=true //Display the console Output in a readable format
        // ,strict=true // it will check if any step is not defined in Step Definition
        ,dryRun = false //to check mapping is proper between feature file and Step Definition
        ,tags = "@FunctionalTest"
)
class TestRunner {



}
