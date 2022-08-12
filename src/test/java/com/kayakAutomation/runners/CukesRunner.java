package com.kayakAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // coming from jUnit, cucumber does not have this. This engine provided by jUnit. Cucumber will read Login.feature and will execute as a test.
@CucumberOptions(
        features = "src/test/resources/features",// path to the features. Right click and copy path. Path to features
        glue = "com/kayakAutomation/step_definitions", // to give the cucumber exact path. Otherwise we can not run the code. Path to step definitions
        dryRun = false, // if you say true it will not run your code.
        tags = {""}, // this line indicates that tests with given annotation will be executed, and others will be ignored
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json", // this is default report. You can make it more advance. It is only take the report. And you can
                // see the reports by clicking right of the target and show in explorer. You decide the location so you can change it also.
                // we added one more which is json. For transfering data it's popular. Our framework we will add another report, look like much better so
                // cucumber html report independe@ant plugger that generate nice report. To be able to generate it plugin needs json and it can generate it for readable
                // nice and user friendly report. That's why we generated it here.
                "rerun:target/rerun.txt"} // To generate txt file with
        // at the end of the test, this file will be under target folder
)
public class CukesRunner {

}