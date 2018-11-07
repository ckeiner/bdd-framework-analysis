package com.ckeiner.bdd.cucumber.support;

import org.junit.Assert;

import com.ckeiner.CucumberEater;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps
{
    public CucumberEater eater = new CucumberEater();

    @Given("^I have (.*) (?:cucumbe(?:rs|r)|cuk(?:es|e))$")
    @And("^I bought (.*) (?:cucumbe(?:rs|r)|cuk(?:es|e))$")
    @But("^I ordered (.*) (?:cucumbe(?:rs|r)|cuk(?:es|e))$")
    public void givenCucumbers(int cucumbers)
    {
        eater.setCucumbers(cucumbers);
    }

    @When("^I eat (.*) cucumbe(?:rs|r)$")
    public void eatenCucumbers(int eaten)
    {
        eater.eat(eaten);
    }

    @Then("^I have (.*) cucumbe(?:rs|r) left$")
    public void thenCucumbers(int left)
    {
        Assert.assertEquals(left, eater.cucumbers());
    }
}
