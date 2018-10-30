package com.ckeiner.bdd.cucumber.support;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps
{
    public int amountCukes;

    @Given("^I have (.*) (?:cucumbe(?:rs|r)|cuk(?:es|e))$")
    @And("^I bought (.*) (?:cucumbe(?:rs|r)|cuk(?:es|e))$")
    @But("^I ordered (.*) (?:cucumbe(?:rs|r)|cuk(?:es|e))$")
    public void givenCucumbers(int cukes)
    {
        amountCukes = cukes;
    }

    @When("^I eat (.*) cucumbe(?:rs|r)$")
    public void eatenCucumbers(int cukes)
    {
        amountCukes -= cukes;
    }

    @Then("^I have (.*) cucumbe(?:rs|r) left$")
    public void thenCucumbers(int cukes)
    {
        Assert.assertEquals(amountCukes, cukes);
    }
}
