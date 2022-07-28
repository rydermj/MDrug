package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="src/test/resources",
glue="org.stepDefinitions",
dryRun=false,
plugin= {"pretty","html:target/mutualDrugTestReports.html"},
monochrome=true, tags="@tag3")
public class TestRunner {

}
