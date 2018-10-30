package com.ckeiner.bdd.cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@formatter:off
@CucumberOptions(features = "src/test/java/com/ckeiner/bdd/cucumber/features", glue = {
        "com.ckeiner.bdd.cucumber.features", "com.ckeiner.bdd.cucumber.support" },
        tags = "@Consumption", plugin = { "pretty", // console output
                "html:target/cucumber-report/", // html report
})
//@formatter:on
public class WIPFeaturesTest
{
}