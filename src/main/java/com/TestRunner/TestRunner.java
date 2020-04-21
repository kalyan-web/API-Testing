package com.TestRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features//",
		plugin = {"pretty","json:target/cucumber.json"},
		glue= {"com.cucumber"},
		tags= {"@Foriegn"},
		monochrome=true)

public class TestRunner {}
