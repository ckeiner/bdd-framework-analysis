package com.ckeiner.bdd.testbddy.tests;

import static com.xceptance.testbddy.api.BddSuite.feature;
import static com.xceptance.testbddy.api.BddSuite.scenario;
import static com.xceptance.testbddy.api.BddSuite.then;
import static com.xceptance.testbddy.api.BddSuite.with;

import org.junit.Test;

import com.xceptance.neodymium.util.Neodymium;
import com.xceptance.neodymium.util.WebDriverUtils;
import com.xceptance.testbddy.core.bdd.steps.Steps;

import posters.pom.pages.browsing.CategoryPage;
import posters.pom.pages.browsing.HomePage;
import posters.pom.util.Util;

public class BrowseCategory
{
    public HomePage homepage;

    public CategoryPage categoryPage;

    @Test
    public void canBrowseCategories()
    {
        //@formatter:off
        feature("Can browse categories",
                () -> scenario("I browse a category",
                        with("World of Nature")
                        .given("I explicitly setup a browser", () -> {
                        	WebDriverUtils.setUp("Chrome");
                            Util.openHomePage();
                        })
                        .when("I open <data>", (data) -> {
                            homepage = new HomePage();
                            categoryPage = homepage.topNavigation.clickCategory(data);
                        })
                        .then("The site has the header <data>", data -> {
                            categoryPage.validate(data);
                        })
                        .then(tearDown())
                    ),
                () -> scenario("I browse a subcategory",
                        with(new ClickedCategory("Chrome", "World of Nature", "Flowers"), new ClickedCategory("Firefox", "World of Nature", "Flowers"))
                        .given("I setup the browser", (data) -> {
                        	setUp(data.browserprofile);
                        })
                        .when("I open <data.subCategoryName> of <data.categoryName>", (data) -> {
                            homepage = new HomePage();
                            categoryPage = homepage.topNavigation.clickSubCategoryByName(data.categoryName, data.subCategoryName);
                        })
                        .then("The site has the header <data.subCategoryName>", data -> {
                            categoryPage.validate(data.subCategoryName);
                        })
                        .then(tearDown())
                    )
        ).test();
        //@formatter:on
    }

    private void setUp(String browserprofile)
    {
        WebDriverUtils.setUp(browserprofile);
        Util.openHomePage();
    }

    private Steps tearDown()
    {
        return then("I close the browser", () -> {
            Neodymium.getDriver().close();
        });
    }

    public static class ClickedCategory
    {
        public String browserprofile;

        public String categoryName;

        public String subCategoryName;

        public ClickedCategory(String browserprofile, String categoryName, String subCategoryName)
        {
            this.browserprofile = browserprofile;
            this.categoryName = categoryName;
            this.subCategoryName = subCategoryName;
        }

        @Override
        public String toString()
        {
            return "Browsing with \"" + browserprofile + "\" to Category: \"" + categoryName + "\" with subcategory: \"" + subCategoryName +
                   "\"";
        }
    }

}
