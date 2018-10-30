package com.ckeiner.bdd.cucumber.support;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import posters.pom.components.TopNavigation;
import posters.pom.pages.AbstractPageObject;
import posters.pom.pages.browsing.CategoryPage;
import posters.pom.pages.browsing.HomePage;

public class BrowsingStep
{
    public AbstractPageObject lastPage;

    @When("^I open the category (.*)$")
    public void openCategory(String categoryName)
    {
        TopNavigation topNavigation = new TopNavigation();
        topNavigation.isComponentAvailable();
        topNavigation.clickCategory(categoryName);
    }

    @Then("^I see the (?:catalogue|catalog|category)")
    @And("^I see different products")
    public void shouldSeeProductsInCatalog()
    {
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.isExpectedPage();
        categoryPage.validateStructure();
    }

    @When("^I open the subcategory (.*) of the category (.*)")
    public void openSubcategory(String subCategoryName, String categoryName)
    {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = homePage.topNavigation.clickSubCategoryByName(categoryName, subCategoryName);
        categoryPage.isExpectedPage();
    }

    @Then("I only see products of the subcategory (.*)")
    public void shouldSeeProductsOfSubcategory(String subcategory)
    {
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.isExpectedPage();
    }

}
