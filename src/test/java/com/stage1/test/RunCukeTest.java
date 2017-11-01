package com.stage1.test;//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report","junit:target/cucumber-junit.xml",
                "json:target/cucumber.json","pretty:target/cucumber-pretty.txt"},
        features = {"/Users/ksyed/Desktop/TR_Clarivate/Personal/Work/Projects/ProjectStage1/src/test/resources/com.stage1.test"},
        tags = {"~@wip"},
        glue={"com.stage1.test"}

)
public class RunCukeTest {
}
