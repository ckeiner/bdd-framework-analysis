package com.ckeiner.bdd.cucumber.support;

import com.xceptance.neodymium.util.WebDriverUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import posters.pom.pages.browsing.HomePage;
import posters.pom.util.Util;

public class BackgroundStep
{
    @Given("^(.*) is opened$")
    public void openBrowser(String browserProfile)
    {
        WebDriverUtils.setUp(browserProfile);
    }

    @When("^I open the homepage$")
    public void openHomepage()
    {
        HomePage homePage = Util.openHomePage();
        homePage.isExpectedPage();
    }
}
