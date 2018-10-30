package com.ckeiner.bdd.serenity.stepdefinition;

import com.xceptance.neodymium.util.WebDriverUtils;

import net.thucydides.core.annotations.Step;
import posters.pom.components.TopNavigation;
import posters.pom.pages.browsing.CategoryPage;
import posters.pom.pages.browsing.HomePage;
import posters.pom.util.Util;

public class BrowsingStep
{

    @Step("{0} is opened")
    public void open_Browser(String browsername)
    {
        WebDriverUtils.setUp(browsername);
    }

    @Step("When I open the homepage")
    public void open_the_homepage()
    {
        HomePage homePage = Util.openHomePage();
        homePage.isExpectedPage();
    }

    @Step("When I open the category {0}")
    public void open_Category(String categoryName)
    {
        TopNavigation topNavigation = new TopNavigation();
        topNavigation.isComponentAvailable();
        topNavigation.clickCategory(categoryName);
    }

    @Step("The I should see products in the catalogue")
    public void should_See_Products_In_Catalog()
    {
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.isExpectedPage();

        categoryPage.validateStructure();
    }

    @Step("When I open the subcategory {0} from {1}")
    public void open_Subcategory(String subCategoryName, String categoryName)
    {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = homePage.topNavigation.clickSubCategoryByName(categoryName, subCategoryName);
        categoryPage.isExpectedPage();
    }

    @Step("Then I only see products of the subcategory {0}")
    public void should_See_Products_Of_Subcategory(String subcategory)
    {
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.isExpectedPage();
    }

}
