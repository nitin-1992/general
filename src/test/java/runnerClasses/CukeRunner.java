package runnerClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
//    plugin = {
//        "html:target/cucumberHtmlReport",
//        "json:target/cucumber-report.json"
//    }, // Plugin to generate HTML report and json report
    features = {
        "src/main/java/Feature"
    },
    glue = {
        "Step_Defination"
    },
    tags = {
        "@Get"
    })
public class CukeRunner {}