package com.ckeiner.bdd.cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Executes all features in the feature package.
 * 
 * @author ckeiner
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/ckeiner/bdd/cucumber/features", glue = {
        "com.ckeiner.bdd.cucumber.features", "com.ckeiner.bdd.cucumber.support" }, tags = "not @Skip", plugin = {
                "pretty", // console // output
                "html:target/cucumber-report/", // html report
})
public class AllFeaturesTest
{
}